/*
 * Copyright (C) 1999-2015 Jive Software. All rights reserved.
 *
 * This software is the proprietary information of Jive Software. Use is subject to license terms.
 */
package com.jivesoftware.community.cloudalytics.event.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
public abstract class ActionObject implements Cloneable {

    @JsonProperty
    protected String objectType;
    @JsonProperty
    protected Long objectId;
    @JsonProperty
    protected String objectHash;
    @JsonProperty
    protected boolean isDataAvailable;
    @JsonProperty
    protected Map<String,Object> extras = new HashMap<>();
    @JsonProperty
    protected List<String> tags = new ArrayList<>();

    // discovered in the 'wild' likely from stitched hbase widening
    @JsonProperty
    private String combinedObjectTypeId;

    public ActionObject() {}

    public ActionObject(String objectType, Long objectId) { this.objectId = objectId; this.objectType = objectType;}

    public String getObjectType() {
        return this.objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public void setObjectHash(String objectHash) {
        this.objectHash = objectHash;
    }

    public String getObjectHash() {
        return this.objectHash;
    }

    public boolean getIsDataAvailable() {
        return isDataAvailable;
    }

    public void setIsDataAvailable(boolean dataAvailable) {
        this.isDataAvailable = dataAvailable;
    }

    public Map<String, Object> getExtras() {
        return extras;
    }

    public void setExtras(Map<String, Object> extras) {
        if (MapUtils.isNotEmpty(extras)) {
            this.extras.putAll(extras);
        }
    }

    public void setTags (List<String> tags) {
        if (tags != null && tags.size() > 0) {
            this.tags.addAll(tags);
        }
    }

    public void addTag (String tag) {
        if (StringUtils.isNotEmpty(tag)) {
            this.tags.add(tag);
        }
    }

    public void removeTag (String tag) {
        if (StringUtils.isNotEmpty(tag)) {
            this.tags.remove(tag);
        }
    }

    public List<String> getTags() {
        return tags;
    }

    public ActionObject getExtendedAction() {
        try {
            return (ActionObject) this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String getSimpleClassName() {
        return this.getClass().getSimpleName();
    }

    public String getCombinedObjectTypeId() {
        return combinedObjectTypeId;
    }

    public void setCombinedObjectTypeId(String combinedObjectTypeId) {
        this.combinedObjectTypeId = combinedObjectTypeId;
    }
}
