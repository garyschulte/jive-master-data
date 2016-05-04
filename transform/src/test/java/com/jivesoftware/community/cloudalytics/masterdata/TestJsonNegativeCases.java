package com.jivesoftware.community.cloudalytics.masterdata;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.jivesoftware.community.cloudalytics.masterdata.jsconschema.EventData;
import com.jivesoftware.community.cloudalytics.masterdata.jsonschema.EventDocument;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by gary.schulte on 5/2/16.
 */
public class TestJsonNegativeCases extends TestBase {

    static String BAD_JSON = "boom!";
    static String BAD_ACTION_OBJECT_JSON_RESOURCE = "testCases/malformed_actionObject.json";

    @Test(expected = ParseException.class)
    public void testMalformedJsonString() throws ParseException {
        assertJsonReadException(BAD_JSON, JsonParseException.class);
    }

    @Test(expected = ParseException.class)
    public void testBadActionObject() throws ParseException {
        assertJsonReadException(getTestResourceAsString(BAD_ACTION_OBJECT_JSON_RESOURCE), JsonMappingException.class);
    }

    @Test (expected = WriteException.class)
    public void testUnSerializable() throws WriteException {
        assertJsonWriteException(new EventData() {}, new File("blah"), JsonProcessingException.class);
    }

    @Test (expected = WriteException.class)
    public void testNullFileWrite() throws WriteException {
        assertJsonWriteException(new EventDocument(), null, NullPointerException.class);
    }

    @Test (expected = WriteException.class)
    public void testBadFileHandle() throws WriteException {
        assertJsonWriteException(new EventDocument(), new File("/"), FileNotFoundException.class);
    }

    void assertJsonWriteException(EventData ed, File fil, Class expectedException) throws WriteException {
        try {
            JsonSerializer.write(ed, fil);
        } catch (WriteException e) {
            assertEquals("Unexpected raw doc source", e.getSourceObject(), ed);
            assertTrue("Unexpected parse exception cause", expectedException.isAssignableFrom(e.getCause().getClass()));
            assertTrue(e.getTargetFile() == fil);
            throw e;
        }

    }

    void assertJsonReadException(String doc, Class exceptionCause) throws ParseException {
        try {
            JsonSerializer.parseEventDoc(doc);
        } catch (ParseException e) {
            assertEquals("Unexpected raw doc source", e.getRawDocSource(), doc);
            assertTrue("Unexpected parse exception cause", exceptionCause.isAssignableFrom(e.getCause().getClass()));
            assertTrue(e.getParseTarget() == null);
            throw e;
        }

    }

}
