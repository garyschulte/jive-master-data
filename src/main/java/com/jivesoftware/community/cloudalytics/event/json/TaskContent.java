/*
 * Copyright (C) 1999-2015 Jive Software. All rights reserved.
 *
 * This software is the proprietary information of Jive Software. Use is subject to license terms.
 */
package com.jivesoftware.community.cloudalytics.event.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskContent extends ActivityContent implements Cloneable {

    @JsonProperty
    private boolean completed;
    @JsonProperty
    private Long dueDate;
    @JsonProperty
    private Actor owner;
    @JsonProperty
    private TaskContent parentTask;


    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Long getDueDate() {
        return dueDate;
    }

    public void setDueDate(Long dueDate) {
        this.dueDate = dueDate;
    }

    public Actor getOwner() {
        return owner;
    }

    public void setOwner(Actor owner) {
        this.owner = owner;
    }

    public TaskContent getParentTask() {
        return parentTask;
    }

    public void setParentTask(TaskContent parentTask) {
        this.parentTask = parentTask;
    }
}
