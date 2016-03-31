/*
 * Copyright (C) 1999-2015 Jive Software. All rights reserved.
 *
 * This software is the proprietary information of Jive Software. Use is subject to license terms.
 */
package com.jivesoftware.community.cloudalytics.external.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 */
public class ExStorageFileObject extends ActionObject implements Cloneable {
    @JsonProperty
    protected String contentObjectType;
    @JsonProperty
    protected Long contentObjectId;
    @JsonProperty
    protected String definitionObjectType;
    @JsonProperty
    protected Long definitionObjectId;
    @JsonProperty
    private String definitionName;
    @JsonProperty
    private String extensionUUID;

    public String getContentObjectType() {
        return contentObjectType;
    }

    public void setContentObjectType(String contentObjectType) {
        this.contentObjectType = contentObjectType;
    }

    public Long getContentObjectId() {
        return contentObjectId;
    }

    public void setContentObjectId(Long contentObjectId) {
        this.contentObjectId = contentObjectId;
    }

    public String getDefinitionObjectType() {
        return definitionObjectType;
    }

    public void setDefinitionObjectType(String definitionObjectType) {
        this.definitionObjectType = definitionObjectType;
    }

    public Long getDefinitionObjectId() {
        return definitionObjectId;
    }

    public void setDefinitionObjectId(Long definitionObjectId) {
        this.definitionObjectId = definitionObjectId;
    }

    public String getDefinitionName() {
        return definitionName;
    }

    public void setDefinitionName(String definitionName) {
        this.definitionName = definitionName;
    }

    public String getExtensionUUID() {
        return extensionUUID;
    }

    public void setExtensionUUID(String extensionUUID) {
        this.extensionUUID = extensionUUID;
    }
}
