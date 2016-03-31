/*
 * Copyright (C) 1999-2015 Jive Software. All rights reserved.
 *
 * This software is the proprietary information of Jive Software. Use is subject to license terms.
 */
package com.jivesoftware.community.cloudalytics.external.avro;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jivesoftware.base.User;
import com.jivesoftware.community.JiveObjectType;
import com.jivesoftware.community.cloudalytics.external.entity.ActionObject;
import com.jivesoftware.community.cloudalytics.external.entity.PublicationData;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Actor implements ActionObjectType {

    @JsonProperty
    private String username = null;
    @JsonProperty
    private String name = null;
    @JsonProperty
    private String firstName = null;
    @JsonProperty
    private String lastName = null;
    @JsonProperty
    private String email = null;
    @JsonProperty
    private Long creationDate = null;
    @JsonProperty
    private Long modificationDate;
    @JsonProperty
    private Map<String, String> profile = new TreeMap<String, String>();
    @JsonProperty
    private Boolean enabled;
    @JsonProperty
    private Long lastLoggedIn;
    @JsonProperty
    private Long lastProfileUpdate;
    @JsonProperty
    private User.Type type = User.Type.REGULAR;
    @JsonProperty
    private Boolean federated;
    @JsonProperty
    private Boolean visible;
    @JsonProperty
    private User.Status status = null;
    @JsonProperty
    private String url;
    @JsonProperty
    private List<PublicationData> publicationData = null;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
    }

    public Long getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Long modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Map<String, String> getProfile() {
        return profile;
    }

    public void setProfile(Map<String, String> profile) {
        this.profile = profile;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Long getLastLoggedIn() {
        return lastLoggedIn;
    }

    public void setLastLoggedIn(Long lastLoggedIn) {
        this.lastLoggedIn = lastLoggedIn;
    }

    public Long getLastProfileUpdate() {
        return lastProfileUpdate;
    }

    public void setLastProfileUpdate(Long lastProfileUpdate) {
        this.lastProfileUpdate = lastProfileUpdate;
    }

    public User.Type getType() {
        return type;
    }

    public void setType(User.Type type) {
        this.type = type;
    }

    public Boolean getFederated() {
        return federated;
    }

    public void setFederated(Boolean federated) {
        this.federated = federated;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public User.Status getStatus() {
        return status;
    }

    public void setStatus(User.Status status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<PublicationData> getPublicationData() {
        return publicationData;
    }

    public void setPublicationData(List<PublicationData> publicationData) {
        this.publicationData = publicationData;
    }

}
