package com.jivesoftware.community.cloudalytics.masterdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.base.Predicate;
import com.google.common.io.Files;
import com.jivesoftware.community.cloudalytics.masterdata.avro.AvroEvent;
import com.jivesoftware.community.cloudalytics.masterdata.jsonschema.EventDocument;
import com.jivesoftware.community.cloudalytics.masterdata.jsonschema.SmokeGen;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecord;
import org.apache.commons.compress.utils.IOUtils;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collection;
import java.util.regex.Pattern;

/**
 * Created by gary.schulte on 5/2/16.
 */
public class TestBase {
    static ObjectMapper mapper = new ObjectMapper();
    static Collection<URL> urls = ClasspathHelper.forPackage("testCases");
    static Reflections refs = new Reflections(new ConfigurationBuilder().setUrls(urls).setScanners(new ResourcesScanner()));


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


    public static String getTestResourceAsString(final String docName) {

        return SmokeGen.getDocAsString(docName);
/*
        String docPath = refs.getResources(new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return docName.equals(input);
            }
        }).iterator().next();

        URL docURL = TestBase.class.getResource("/" + docPath);
        String docContent = null;
        if (docURL != null) {
            try {
                docContent = Files.toString(new File(docURL.getFile()), Charsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return docContent;
        */
    }
}
