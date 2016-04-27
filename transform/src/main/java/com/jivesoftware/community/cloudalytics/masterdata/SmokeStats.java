package com.jivesoftware.community.cloudalytics.masterdata;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.jivesoftware.community.cloudalytics.masterdata.avro.AvroEvent;
import com.jivesoftware.community.cloudalytics.masterdata.jsonschema.EventDocument;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

/**
 * Created by gary.schulte on 4/11/16.
 */
public class SmokeStats {

    /**
     * read json in from stdin, collect stats on it
     *  1. jackson-ify it
     *  2. avro-ify it
     *  3. validate avro
     *
     */

    private static int numRead = 0, jsonError = 0, unrecognizedPropertyError = 0, xformrError = 0, avroError = 0;

    public static void main(String args[]) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        ObjectMapper looseMapper = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String doc;

        DatumWriter<AvroEvent> writer = new SpecificDatumWriter<>(AvroEvent.class);
        DataFileWriter<AvroEvent> avroOut = new DataFileWriter<>(writer)
                .create(AvroEvent.getClassSchema(),new File("/tmp/avroStats.bin"));


        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                System.out.println("_____________________________________________________________");
                System.out.println(String.format("Processed %s docs, %s jackson errors, %s unrecognized property errors, %s transform errors, %s avro errors", numRead, jsonError, unrecognizedPropertyError, xformrError, avroError));
                System.out.println("_____________________________________________________________");
            }});


        while (null!= (doc = br.readLine())){
            numRead++;
            EventDocument jsonDoc = null;
            try {

                try {
                    jsonDoc = mapper.readValue(doc, EventDocument.class);
                } catch (UnrecognizedPropertyException upex) {
                    System.err.println(String.format("JACKSON at %s for \nunmapped property %s at %s ",new Date(), upex.getPropertyName(), upex.getPathReference()));
                    unrecognizedPropertyError++;
                    //upex.printStackTrace();
                    jsonDoc = looseMapper.readValue(doc, EventDocument.class);
                }

                try {
                    if (jsonDoc != null) {
                        AvroEvent avroDoc = Json2AvroCloner.clone(jsonDoc);

                        try {
                            avroOut.append(avroDoc);
                        } catch (Exception e3) {
                            avroError++;
                            //System.err.println("AVRO\n");
                            System.err.println(String.format("AVRO at %s for \n%s", new Date().toString(), doc));
                            String errmsg = e3.getMessage();
                            int firstCR = errmsg.indexOf("\n");
                            System.err.println(errmsg.substring(0, (firstCR > 0) ? firstCR : errmsg.length()));
                            e3.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    xformrError++;
                    System.err.println(String.format("TRANSFORM at %s for \n%s", new Date(), doc));
                    e2.printStackTrace();
                }
            } catch (Exception e) {
                jsonError ++;
                System.err.println(String.format("JACKSON at %sfor \n%s", new Date(), doc));
                e.printStackTrace();
            }

        }

    }
}
