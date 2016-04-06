package com.jivesoftware.community.cloudalytics.event.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Created by gary.schulte on 3/16/16.
 */
public class EventDocument {


    @JsonProperty
    String name;

    @JsonProperty
    long timestamp;

    @JsonProperty
    long seqId;

    @JsonProperty
    String uuid;

    // TODO: this likely needs to be more strongly typed.  some fields like service.tenantID *must* exist
    @JsonProperty
    Map<String, Map<String, String>> context;

    @JsonProperty
    Map<String, String> payload;

    @JsonProperty
    long actorID;

    @JsonProperty
    int actorType;

    @JsonProperty
    String activityType;

    @JsonProperty
    long actionObjectId;

    @JsonProperty
    int actionObjectType;

    @JsonProperty
    long containerId;

    @JsonProperty
    int containerType;

    @JsonProperty
    AnalyticsActivity activity;

    @JsonProperty
    boolean isHistoricalReplay;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getSeqId() {
        return seqId;
    }

    public void setSeqId(long seqId) {
        this.seqId = seqId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Map<String, Map<String, String>> getContext() {
        return context;
    }

    public void setContext(Map<String, Map<String, String>> context) {
        this.context = context;
    }

    public Map<String, String> getPayload() {
        return payload;
    }

    public void setPayload(Map<String, String> payload) {
        this.payload = payload;
    }

    public long getActorID() {
        return actorID;
    }

    public void setActorID(long actorID) {
        this.actorID = actorID;
    }

    public int getActorType() {
        return actorType;
    }

    public void setActorType(int actorType) {
        this.actorType = actorType;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public long getActionObjectId() {
        return actionObjectId;
    }

    public void setActionObjectId(long actionObjectId) {
        this.actionObjectId = actionObjectId;
    }

    public int getActionObjectType() {
        return actionObjectType;
    }

    public void setActionObjectType(int actionObjectType) {
        this.actionObjectType = actionObjectType;
    }

    public long getContainerId() {
        return containerId;
    }

    public void setContainerId(long containerId) {
        this.containerId = containerId;
    }

    public int getContainerType() {
        return containerType;
    }

    public void setContainerType(int containerType) {
        this.containerType = containerType;
    }

    public AnalyticsActivity getActivity() {
        return activity;
    }

    public void setActivity(AnalyticsActivity activity) {
        this.activity = activity;
    }

    public boolean isHistoricalReplay() {
        return isHistoricalReplay;
    }

    public void setIsHistoricalReplay(boolean isHistoricalReplay) {
        this.isHistoricalReplay = isHistoricalReplay;
    }

}
