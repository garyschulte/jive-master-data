package com.jivesoftware.community.cloudalytics.masterdata;

import java.io.File;

/**
 * Wrapper exception which encapsulated validation and/or IO exceptions when
 * writing master data objects (avro or json)
 */
public class WriteException extends Exception {
    File targetFile = null;
    Object sourceObject = null;

    WriteException(Exception cause, File targetFile, Object sourceObject) {
        super(cause);
        this.targetFile = targetFile;
        this.sourceObject = sourceObject;
    }

    File getTargetFile() {
        return targetFile;
    }

    Object getSourceObject() {
        return sourceObject;
    }
}
