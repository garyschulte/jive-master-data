package com.jivesoftware.community.cloudalytics.masterdata.jsonschema;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
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

/**
 * Created by gary.schulte on 4/13/16.
 *
 * basic deserialization/serializaton testing to ensure POJO creation was successful
 */
@RunWith(Parameterized.class)
public class SmokeGen {

    ObjectMapper mapper = new ObjectMapper();
    String testDoc = null;

    // As corner case type json events show up that are problem for parsing,
    // add them to master-data-json test/resources/testCases with name smoke_*.json
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

    public SmokeGen(String file){
        testDoc = getDocAsString(file);
    }

    @Test
    public void basicParseAndCompare() throws Exception {

        EventDocument docObj = mapper.readValue(testDoc, EventDocument.class);
        String docReSerialized = mapper.writeValueAsString(docObj);
        JSONAssert.assertEquals(testDoc, docReSerialized, JSONCompareMode.LENIENT);
        assertTrue("Unexpected properties found " + docObj.getAdditionalProperties()
                ,(docObj.getAdditionalProperties().size() == 0));
    }

    public static String getDocAsString(String docName) {
        URL docURL = SmokeGen.class.getResource("/" + docName);
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
