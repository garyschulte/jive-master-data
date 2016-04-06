/*
 * Copyright (C) 1999-2015 Jive Software. All rights reserved.
 *
 * This software is the proprietary information of Jive Software. Use is subject to license terms.
 */
package com.jivesoftware.community.cloudalytics.event.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Extension of ActionObject that includes specific fields for creating a JSON representation
 * of an {@link com.jivesoftware.community.integration.tileinstance.TileInstance} object
 */
public class TileInstanceObject extends ActionObject implements Cloneable {

    /* Information about Tile Definition */
    @JsonProperty
    protected String tileDefinitionObjectType;
    @JsonProperty
    protected Long tileDefinitionObjectId;
    @JsonProperty
    protected String tileDefinitionName;
    @JsonProperty
    private String tileDefinitionVisualType;
    @JsonProperty
    private Boolean isActivityStream;
    @JsonProperty
    private String extensionUUID;

    public String getTileDefinitionObjectType() {
        return tileDefinitionObjectType;
    }

    public void setTileDefinitionObjectType(String tileDefinitionObjectType) {
        this.tileDefinitionObjectType = tileDefinitionObjectType;
    }

    public Long getTileDefinitionObjectId() {
        return tileDefinitionObjectId;
    }

    public void setTileDefinitionObjectId(Long tileDefinitionObjectId) {
        this.tileDefinitionObjectId = tileDefinitionObjectId;
    }

    public String getTileDefinitionName() {
        return tileDefinitionName;
    }

    public void setTileDefinitionName(String tileDefinitionName) {
        this.tileDefinitionName = tileDefinitionName;
    }

    public String getTileDefinitionVisualType() {
        return tileDefinitionVisualType;
    }

    public void setTileDefinitionVisualType(String tileDefinitionVisualType) {
        this.tileDefinitionVisualType = tileDefinitionVisualType;
    }

    public Boolean getIsActivityStream() {
        return isActivityStream;
    }

    public void setIsActivityStream(Boolean isActivityStream) {
        this.isActivityStream = isActivityStream;
    }

    public String getExtensionUUID() {
        return extensionUUID;
    }

    public void setExtensionUUID(String extensionUUID) {
        this.extensionUUID = extensionUUID;
    }
}
