package com.jivesoftware.community.cloudalytics.event.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by bmoshe on 8/9/15.
 */
public class PbQuestActionObject extends ActionObject implements Cloneable {
    @JsonProperty
    protected String questId;

    @JsonProperty
    protected String taskId;

    @JsonProperty
    protected String secret;

    @JsonProperty
    protected boolean isApiRequest;

    public String getQuestId()
    {
        return questId;
    }

    public PbQuestActionObject setQuestId(String questId)
    {
        this.questId = questId;
        return this;
    }

    public String getTaskId()
    {
        return taskId;
    }

    public PbQuestActionObject setTaskId(String taskId)
    {
        this.taskId = taskId;
        return this;
    }

    public String getSecret() {
        return secret;
    }

    public PbQuestActionObject setSecret(String secret) {
        this.secret = secret;
        return this;
    }

    public boolean isApiRequest() {
        return isApiRequest;
    }

    public PbQuestActionObject setIsApiRequest(boolean isApiRequest) {
        this.isApiRequest = isApiRequest;
        return this;
    }
}
