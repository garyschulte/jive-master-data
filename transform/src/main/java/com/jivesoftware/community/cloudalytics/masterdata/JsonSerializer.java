package com.jivesoftware.community.cloudalytics.masterdata;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.jivesoftware.community.cloudalytics.masterdata.jsconschema.EventData;
import com.jivesoftware.community.cloudalytics.masterdata.jsonschema.ActionObject;
import com.jivesoftware.community.cloudalytics.masterdata.jsonschema.EventDocument;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Convenience class to map/parse json docs from string or file and encapsulate exceptions
 */
public class JsonSerializer {

    static ObjectMapper mapper = new ObjectMapper();

    public static EventDocument parseEventDoc(String doc) throws ParseException {
        EventDocument docObj = null;
        try {
            docObj = mapper.readValue(doc, EventDocument.class);
        } catch (IOException e) {
            throw new ParseException(e, doc, docObj);
        }
        return docObj;
    }

    public static EventDocument parseEventDoc(File docFile, Charset charset) throws ParseException {
        String docContent = null;
        EventDocument docObj = null;
        try {
            docContent = Files.toString(docFile, charset);
            docObj = parseEventDoc(docContent);
        } catch (IOException e) {
            throw new ParseException(e, docContent, docObj);
        }
        return docObj;
    }
    public static EventDocument parseEventDoc(File docFile) throws ParseException {
        return parseEventDoc(docFile, Charsets.UTF_8);
    }

    <T extends ActionObject> T parseActionObject(String actionObjDoc) throws ParseException {
        T actionObj = null;
        try {
            actionObj = (T) mapper.readValue(actionObjDoc, ActionObject.class);
        } catch (IOException e) {
            throw new ParseException(e, actionObjDoc, actionObj);
        }
        return actionObj;
    }

    public static String serialize(EventData jsonObject) throws WriteException {
        try {
            return mapper.writeValueAsString(jsonObject);
        } catch (JsonProcessingException e) {
            throw new WriteException(e, null, jsonObject);
        }
    }

    public static void write(EventData jsonObject, File fil) throws WriteException {
        try {
            FileWriter fw = new FileWriter(fil);
            fw.write(serialize(jsonObject));
        } catch (IOException e) {
            throw new WriteException(e, fil, jsonObject);
        } catch (NullPointerException e) {
            throw new WriteException(e, fil, jsonObject);
        } catch (WriteException e) {
            e.targetFile = fil;
            throw e;
        }
    }

}
