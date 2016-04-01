/*
 * Copyright (C) 1999-2015 Jive Software. All rights reserved.
 *
 * This software is the proprietary information of Jive Software. Use is subject to license terms.
 */
package com.jivesoftware.community.cloudalytics.event.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 */
public class AppLoadedObject extends ActionObject implements Cloneable {

    @JsonProperty
    private String appName;
    @JsonProperty
    private String appURL;
    @JsonProperty
    private String extensionUUID;
    @JsonProperty
    private Boolean isSynthetic;
    @JsonProperty
    protected String associatedObjectType;
    @JsonProperty
    protected Long associatedObjectId;
    @JsonProperty
    protected String associatedName;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppURL() {
        return appURL;
    }

    public void setAppURL(String appURL) {
        this.appURL = appURL;
    }

    public String getExtensionUUID() {
        return extensionUUID;
    }

    public void setExtensionUUID(String extensionUUID) {
        this.extensionUUID = extensionUUID;
    }

    public Boolean getIsSynthetic() {
        return isSynthetic;
    }

    public void setIsSynthetic(Boolean isSynthetic) {
        this.isSynthetic = isSynthetic;
    }

    public String getAssociatedObjectType() {
        return associatedObjectType;
    }

    public void setAssociatedObjectType(String associatedObjectType) {
        this.associatedObjectType = associatedObjectType;
    }

    public Long getAssociatedObjectId() {
        return associatedObjectId;
    }

    public void setAssociatedObjectId(Long associatedObjectId) {
        this.associatedObjectId = associatedObjectId;
    }

    public String getAssociatedName() {
        return associatedName;
    }

    public void setAssociatedName(String associatedName) {
        this.associatedName = associatedName;
    }
}
