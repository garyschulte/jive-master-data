package com.jivesoftware.community.cloudalytics.masterdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.jivesoftware.community.cloudalytics.masterdata.avro.AvroEvent;
import com.jivesoftware.community.cloudalytics.masterdata.jsonschema.EventDocument;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecord;
import org.apache.commons.compress.utils.IOUtils;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

/**
 * Created by gary.schulte on 4/18/16.
 * load smoke test json events from json test resources, transform back/forth and validate
 */
@RunWith(Parameterized.class)
public class SmokeCloners {
    ObjectMapper mapper = new ObjectMapper();
    String TMP_OUT = "/tmp/AvroOutput.avro";
    String testDoc = null;

    public SmokeCloners(String file){
        testDoc = getDocAsString(file);
    }

    @Parameterized.Parameters
    public static String[] data() {
        String[] eventCases =
                {"actor_as_extra.json"
                        , "mega_nested_actionObject.json"
                        , "message_content.json"
                };
        return eventCases;
    }


    @Test
    public void biDirectionalTransform() throws IOException, JSONException {
        File file = new File(TMP_OUT);
        EventDocument doc = parseTestDoc(testDoc);
        AvroEvent avroEvent = Json2AvroCloner.clone(doc);
        EventDocument deXformed = Avro2JsonCloner.clone(avroEvent);
        assertReflectionEquals(doc, deXformed);

        String docReSerialized = mapper.writeValueAsString(deXformed);
        JSONAssert.assertEquals(testDoc, docReSerialized, JSONCompareMode.LENIENT);
    }

    EventDocument parseTestDoc(String doc) throws IOException {
        return mapper.readValue(doc, EventDocument.class);
    }

    public void writeAvroDoc(SpecificRecord avroDoc, File file) throws IOException {

        DatumWriter writer = new SpecificDatumWriter<>();
        DataFileWriter out = new DataFileWriter<>(writer);
        out.create(avroDoc.getSchema(), file);
        out.append(avroDoc);
        out.close();

    }

    public AvroEvent readAvroDoc(File file) throws IOException {
        AvroEvent avroEvent = null;
        DataFileReader<AvroEvent> dataFileReader = null;

        try {
            DatumReader<AvroEvent> reader = new SpecificDatumReader<AvroEvent>(AvroEvent.class);
            dataFileReader = new DataFileReader<AvroEvent>(file, reader);
            if (dataFileReader.hasNext()) {
                avroEvent = dataFileReader.next();
            }
        } finally {
            IOUtils.closeQuietly(dataFileReader);
        }
        return avroEvent;
    }


    String getDocAsString(String docName) {
        URL docURL = getClass().getResource("/" + docName);
        String docContent = null;
        if (docURL != null) {
            try {
                docContent = Files.toString(new File(docURL.getFile()), Charsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return docContent;
    }
}


