/*
 * Copyright (C) 1999-2015 Jive Software. All rights reserved.
 *
 * This software is the proprietary information of Jive Software. Use is subject to license terms.
 */
package com.jivesoftware.community.cloudalytics.external.avro;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jivesoftware.community.cloudalytics.external.entity.ActionObject;

import java.util.Date;

public class ActivityDestination implements ActionObjectType {

    @JsonProperty
    private String name;
    @JsonProperty
    private String displayName;
    @JsonProperty
    private String description;
    @JsonProperty
    private Date creationDate;
    @JsonProperty
    private Date modificationDate;
    @JsonProperty
    private String url;
    @JsonProperty
    private String status;
    @JsonProperty
    private Boolean isVisibleToPartner;
    @JsonProperty
    private Long parentId;

    @JsonProperty
    private String parentType;

    @JsonProperty
    private String fullPath;

    @JsonProperty
    private String normalizedPath;

    @JsonProperty
    private String combinedObjectTypeId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getVisibleToPartner() {
        return isVisibleToPartner;
    }

    public void setVisibleToPartner(Boolean visibleToPartner) {
        isVisibleToPartner = visibleToPartner;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getParentType() {
        return parentType;
    }

    public void setParentType(String parentType) {
        this.parentType = parentType;
    }

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public String getNormalizedPath() {
        return normalizedPath;
    }

    public void setNormalizedPath(String normalizedPath) {
        this.normalizedPath = normalizedPath;
    }

    public String getCombinedObjectTypeId() {
        return combinedObjectTypeId;
    }

    public void setCombinedObjectTypeId(String combinedObjectTypeId) {
        this.combinedObjectTypeId = combinedObjectTypeId;
    }

}
