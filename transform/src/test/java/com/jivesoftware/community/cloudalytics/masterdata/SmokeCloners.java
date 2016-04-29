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
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;
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
    public static List<String> data() {
        List<String> eventCases = new ArrayList<>();
        Collection<URL> urls = ClasspathHelper.forPackage("testCases");
        Reflections refs = new Reflections(new ConfigurationBuilder().setUrls(urls).setScanners(new ResourcesScanner()));

        for(String testCase : refs.getResources(Pattern.compile("smoke.*\\.json"))) {
            eventCases.add(testCase);
        }
        return eventCases;
    }


    @Test
    public void biDirectionalTransform() throws IOException, JSONException {
        File file = new File(TMP_OUT);
        EventDocument doc = parseTestDoc(testDoc);
        AvroEvent avroEvent = Json2AvroCloner.clone(doc);
        EventDocument deXformed = Avro2JsonCloner.clone(avroEvent);
        assertReflectionEquals(doc, deXformed);
        assertTrue("Unexpected additional properties in de-transformed document: " + deXformed.getAdditionalProperties(),
                deXformed.getAdditionalProperties().size()== 0);

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


