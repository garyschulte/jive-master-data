/*
 * Copyright (C) 1999-2015 Jive Software. All rights reserved.
 *
 * This software is the proprietary information of Jive Software. Use is subject to license terms.
 */
package com.jivesoftware.community.cloudalytics.external.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ActorRelation extends ActionObject implements Cloneable {

    @JsonProperty
    private Actor user;
    @JsonProperty
    private Actor relatedUser;
    @JsonProperty
    private String status;
    @JsonProperty
    private GraphType graphType = GraphType.FRIENDS;
    @JsonProperty
    private Relation relation = Relation.PEER;
    @JsonProperty
    private Date created;
    @JsonProperty
    private Date retired;

    public ActorRelation() {
        super.isDataAvailable = true; // Data is always available
    }

    public enum GraphType {
        ORG,
        FRIENDS;
    }

    public enum Relation {
        ABOVE,
        PEER;

        public GraphType getGraphType() {
            switch(this) {
                case ABOVE:
                    return GraphType.ORG;
                case PEER:
                    return GraphType.FRIENDS;
            }
            return null;
        }
    }

    public Actor getUser() {
        return user;
    }

    public void setUser(Actor user) {
        this.user = user;
    }

    public Actor getRelatedUser() {
        return relatedUser;
    }

    public void setRelatedUser(Actor relatedUser) {
        this.relatedUser = relatedUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public GraphType getGraphType() {
        return graphType;
    }

    public void setGraphType(GraphType graphType) {
        this.graphType = graphType;
    }

    public Relation getRelation() {
        return relation;
    }

    public void setRelation(Relation relation) {
        this.relation = relation;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getRetired() {
        return retired;
    }

    public void setRetired(Date retired) {
        this.retired = retired;
    }

    public boolean getIsDataAvailable() {
        return true;
    }

    public void setIsDataAvailable(boolean dataAvailable) {
        // Ignored - ActorRelation is always wide.
    }

    @Override
    public String getObjectType() {
        return ("user-"+this.graphType.toString()+"-relationship").toLowerCase();
    }
}
