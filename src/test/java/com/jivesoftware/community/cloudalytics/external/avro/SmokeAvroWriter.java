package com.jivesoftware.community.cloudalytics.external.avro;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.reflect.ReflectData;
import org.apache.avro.reflect.ReflectDatumWriter;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by gary.schulte on 3/28/16.
 */
public class SmokeAvroWriter {

    @Test
    public void testAvroReflect() throws IOException {
        EventDocument avDoc = new EventDocument();
        AnalyticsActivity avActivity = new AnalyticsActivity();
        ActionObject avAO = new ActionObject();
        avActivity.setActionObject(avAO);
        avAO.setActionElement(new ActivityContent());
        Schema eventSchema = ReflectData.AllowNull.get()
                .getSchema(com.jivesoftware.community.cloudalytics.external.avro.EventDocument.class);
        DatumWriter<com.jivesoftware.community.cloudalytics.external.avro.EventDocument> writer = new ReflectDatumWriter<>(com.jivesoftware.community.cloudalytics.external.avro.EventDocument.class);
        DataFileWriter<com.jivesoftware.community.cloudalytics.external.avro.EventDocument> out = new DataFileWriter<>(writer);
        out.create(eventSchema, new File("/tmp/avroReflect.bin"));
        out.append(avDoc);
        out.close();

    }

}
