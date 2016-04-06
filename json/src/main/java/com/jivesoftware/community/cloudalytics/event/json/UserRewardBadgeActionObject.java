package com.jivesoftware.community.cloudalytics.event.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by janne.gershman on 11/5/15.
 */
public class UserRewardBadgeActionObject extends ActionObject implements Cloneable {
    @JsonProperty
    protected String badgeId;

    @JsonProperty
    protected String userEmail;

    @JsonProperty
    protected String message;

    @JsonProperty
    protected String streamEntryId;

    @JsonProperty
    protected String streamEntryUrl;

    public String getBadgeId()
    {
        return badgeId;
    }

    public void setBadgeId(String badgeId)
    {
        this.badgeId = badgeId;
    }

    public String getUserEmail()
    {
        return userEmail;
    }

    public void setUserEmail(String userEmail)
    {
        this.userEmail = userEmail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStreamEntryId() {
        return streamEntryId;
    }

    public void setStreamEntryId(String streamEntryId) {
        this.streamEntryId = streamEntryId;
    }

    public String getStreamEntryUrl() {
        return streamEntryUrl;
    }

    public void setStreamEntryUrl(String streamEntryUrl) {
        this.streamEntryUrl = streamEntryUrl;
    }
}
