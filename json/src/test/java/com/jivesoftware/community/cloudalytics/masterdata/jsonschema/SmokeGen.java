package com.jivesoftware.community.cloudalytics.masterdata.jsonschema;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by gary.schulte on 4/13/16.
 *
 * basic deserialization/serializaton testing to ensure POJO creation was successful
 */
@RunWith(Parameterized.class)
public class SmokeGen {

    ObjectMapper mapper = new ObjectMapper();
    String testDoc = null;

    @Parameterized.Parameters
    public static String[] data() {
        String[] eventCases =
                {"actor_as_extra.json"
                        , "mega_nested_actionObject.json"
                        , "message_content.json"};
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
