/*
 * Copyright (C) 1999-2015 Jive Software. All rights reserved.
 *
 * This software is the proprietary information of Jive Software. Use is subject to license terms.
 */
package com.jivesoftware.community.cloudalytics.event.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 */
public class ExtensionObject extends ActionObject implements Cloneable {

    @JsonProperty
    private String extensionUUID;
    @JsonProperty
    private String name;
    @JsonProperty
    private Long creationDate;
    @JsonProperty
    private Long deployDate;
    @JsonProperty
    private Boolean isLocal;
    @JsonProperty
    private String status;
    @JsonProperty
    private String type;
    @JsonProperty
    private Boolean isVisibleToAll;

    public String getExtensionUUID() {
        return extensionUUID;
    }

    public void setExtensionUUID(String extensionUUID) {
        this.extensionUUID = extensionUUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
    }

    public Long getDeployDate() {
        return deployDate;
    }

    public void setDeployDate(Long deployDate) {
        this.deployDate = deployDate;
    }

    public Boolean getIsLocal() {
        return isLocal;
    }

    public void setIsLocal(Boolean isLocal) {
        this.isLocal = isLocal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getIsVisibleToAll() {
        return isVisibleToAll;
    }

    public void setIsVisibleToAll(Boolean isVisibleToAll) {
        this.isVisibleToAll = isVisibleToAll;
    }
}
