package com.jivesoftware.community.cloudalytics.masterdata;

/**
 * Wrapper Exception thrown by json/jackson and/or Avro cloudalytics master data readers
 */
public class ParseException extends Exception {

    String rawDocSource = null;
    Object parseTarget = null;

    public ParseException(Exception cause, String rawString, Object partialParsed) {
        super(cause);
        this.rawDocSource = rawString;
        this.parseTarget = partialParsed;
    }

    Object getParseTarget() {
        return parseTarget;
    }

    String getRawDocSource() {
        return rawDocSource;
    }

}
