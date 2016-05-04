package com.jivesoftware.community.cloudalytics.masterdata;

import com.jivesoftware.community.cloudalytics.masterdata.avro.AvroEvent;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecord;
import org.apache.commons.compress.utils.IOUtils;

import java.io.File;
import java.io.IOException;

/**
 * Convenience class to handle reading/parsing/validating/writing avro docs
 * to/from string or file and encapsulate exceptions
 */
public class AvroSerializer {


    public static void writeAvroDoc(SpecificRecord avroDoc, File file) throws WriteException {

        DatumWriter writer = new SpecificDatumWriter<>();
        DataFileWriter out = new DataFileWriter<>(writer);
        try {
            out.create(avroDoc.getSchema(), file);
            out.append(avroDoc);
            out.close();
        } catch (IOException e) {
            throw new WriteException(e, file, avroDoc);
        }

    }

    public static AvroEvent readAvroEventDoc(File file) throws ParseException {
        AvroEvent avroEvent = null;
        DataFileReader<AvroEvent> dataFileReader = null;

        try {
            DatumReader<AvroEvent> reader = new SpecificDatumReader<AvroEvent>(AvroEvent.class);
            dataFileReader = new DataFileReader<AvroEvent>(file, reader);
            if (dataFileReader.hasNext()) {
                avroEvent = dataFileReader.next();
            }
        } catch (IOException e) {
            throw new ParseException(e, null, avroEvent);
        } finally {
            IOUtils.closeQuietly(dataFileReader);
        }
        return avroEvent;
    }
}
