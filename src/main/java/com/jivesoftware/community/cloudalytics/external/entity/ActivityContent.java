/*
 * Copyright (C) 1999-2015 Jive Software. All rights reserved.
 *
 * This software is the proprietary information of Jive Software. Use is subject to license terms.
 */
package com.jivesoftware.community.cloudalytics.external.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.avro.reflect.Union;

public class ActivityContent extends ActionObject implements Cloneable {

    @JsonProperty
    private String subject;
    @JsonProperty
    private Long creationDate;
    @JsonProperty
    private Long modifiedDate;
    @JsonProperty
    private Actor author;
    @JsonProperty
    private Long containerId;
    @JsonProperty
    private String containerType;
    @JsonProperty
    private Boolean isVisibleToPartner;
    @JsonProperty
    private String status;
    @JsonProperty
    private Integer versionId;
    @JsonProperty
    private Long latestVersionAuthorId;
    @JsonProperty
    private String url;
    @JsonProperty
    private String fullPath;
    @JsonProperty
    private String normalizedPath;

    // stitched in for widened events that started life as "narrow"
    @JsonProperty
    private String combinedObjectTypeId;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
    }

    public Long getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Long modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Actor getAuthor() {
        return author;
    }

    public Long getAuthorId() {
        return author == null ? 0 : author.getObjectId();
    }

    public void setAuthor(Actor author) {
        this.author = author;
    }

    public Long getContainerId() {
        return containerId;
    }

    public void setContainerId(Long containerId) {
        this.containerId = containerId;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public Boolean getVisibleToPartner() {
        return isVisibleToPartner;
    }

    public void setVisibleToPartner(Boolean visibleToPartner) {
        isVisibleToPartner = visibleToPartner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    public Long getLatestVersionAuthorId() {
        return latestVersionAuthorId;
    }

    public void setLatestVersionAuthorId(Long latestVersionAuthorId) {
        this.latestVersionAuthorId = latestVersionAuthorId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
