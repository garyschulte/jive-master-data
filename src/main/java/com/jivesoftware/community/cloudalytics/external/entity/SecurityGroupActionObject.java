/*
 * Copyright (C) 1999-2015 Jive Software. All rights reserved.
 *
 * This software is the proprietary information of Jive Software. Use is subject to license terms.
 */
package com.jivesoftware.community.cloudalytics.external.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SecurityGroupActionObject extends ActionObject implements Cloneable {

    @JsonProperty
    private String name = null;
    @JsonProperty
    private Long creationDate = null;
    @JsonProperty
    private Long modificationDate;
    @JsonProperty
    private Boolean federated;

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

    public Long getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Long modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Boolean getFederated() {
        return federated;
    }

    public void setFederated(Boolean federated) {
        this.federated = federated;
    }
}
