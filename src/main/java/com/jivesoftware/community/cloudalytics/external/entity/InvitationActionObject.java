package com.jivesoftware.community.cloudalytics.external.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InvitationActionObject extends ActionObject implements Cloneable {

    @JsonProperty
    private Long invitationId;
    @JsonProperty
    private String inviterUsername;
    @JsonProperty
    private String inviterEmail;
    @JsonProperty
    private String inviteeEmail;
    @JsonProperty
    private String revokerUsername;
    @JsonProperty
    private String state;

    @JsonProperty
    private Long sentDate;
    @JsonProperty
    private Long revokeDate;
    @JsonProperty
    private Long creationDate;
    @JsonProperty
    private Long modificationDate;

    public Long getInvitationId() {
        return invitationId;
    }

    public InvitationActionObject setInvitationId(Long invitationId) {
        this.invitationId = invitationId;
        return this;
    }

    public String getInviterUsername() {
        return inviterUsername;
    }

    public InvitationActionObject setInviterUsername(String inviterUsername) {
        this.inviterUsername = inviterUsername;
        return this;
    }

    public String getInviterEmail() {
        return inviterEmail;
    }

    public InvitationActionObject setInviterEmail(String inviterEmail) {
        this.inviterEmail = inviterEmail;
        return this;
    }

    public String getInviteeEmail() {
        return inviteeEmail;
    }

    public InvitationActionObject setInviteeEmail(String inviteeEmail) {
        this.inviteeEmail = inviteeEmail;
        return this;
    }

    public String getRevokerUsername() {
        return revokerUsername;
    }

    public InvitationActionObject setRevokerUsername(String revokerUsername) {
        this.revokerUsername = revokerUsername;
        return this;
    }

    public String getState() {
        return state;
    }

    public InvitationActionObject setState(String state) {
        this.state = state;
        return this;
    }

    public Long getSentDate() {
        return sentDate;
    }

    public InvitationActionObject setSentDate(Long sentDate) {
        this.sentDate = sentDate;
        return this;
    }

    public Long getRevokeDate() {
        return revokeDate;
    }

    public InvitationActionObject setRevokeDate(Long revokeDate) {
        this.revokeDate = revokeDate;
        return this;
    }

    public Long getCreationDate() {
        return creationDate;
    }

    public InvitationActionObject setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public Long getModificationDate() {
        return modificationDate;
    }

    public InvitationActionObject setModificationDate(Long modificationDate) {
        this.modificationDate = modificationDate;
        return this;
    }
}
