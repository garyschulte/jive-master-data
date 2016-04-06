/*
 * Copyright (C) 1999-2015 Jive Software. All rights reserved.
 *
 * This software is the proprietary information of Jive Software. Use is subject to license terms.
 */
package com.jivesoftware.community.cloudalytics.event.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;

/**
 * DirectMessageContent
 * Created: 2/20/13
 *
 * @author Brent Halsey
 */
public class WallEntryContent extends ActivityContent implements Cloneable {

    @JsonProperty
    private Collection<Long> recipientIds;
    @JsonProperty
    private Integer numRecipients;
    @JsonProperty
    private String messageType;


    public Collection<Long> getRecipientIds() {
        return recipientIds;
    }

    public void setRecipientIds(Collection<Long> recipientIds) {
        this.recipientIds = recipientIds;
    }

    public Integer getNumRecipients() {
        return numRecipients;
    }

    public void setNumRecipients(Integer numRecipients) {
        this.numRecipients = numRecipients;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
}
