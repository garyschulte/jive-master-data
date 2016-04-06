/*
 * Copyright (C) 1999-2015 Jive Software. All rights reserved.
 *
 * This software is the proprietary information of Jive Software. Use is subject to license terms.
 */
package com.jivesoftware.community.cloudalytics.event.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "activity")
public class AnalyticsActivity {


    @JsonProperty
    private Actor actor;

    @JsonProperty
    private String action;

    @JsonProperty
    private ActionObject actionObject;

    @JsonProperty
    private Date activityTime;

    @JsonProperty
    private ActivityDestination destination;

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }


    public Date getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }

    public ActivityDestination getDestination() {
        return destination;
    }

    public void setDestination(ActivityDestination destination) {
        this.destination = destination;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public ActionObject getActionObject() {
        return actionObject;
    }

    public void setActionObject(ActionObject actionObject) {
        this.actionObject = actionObject;
    }

    @Override
    public String toString() {
        return "AnalyticsActivity{" +
                "actor=" + actor +
                ", action='" + action + '\'' +
                ", actionObject=" + actionObject +
                ", activityTime=" + activityTime +
                ", destination=" + destination +
                '}';
    }
}
