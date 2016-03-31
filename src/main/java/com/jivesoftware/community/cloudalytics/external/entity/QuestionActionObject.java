/*
 * Copyright (C) 1999-2015 Jive Software. All rights reserved.
 *
 * This software is the proprietary information of Jive Software. Use is subject to license terms.
 */
package com.jivesoftware.community.cloudalytics.external.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionActionObject extends ThreadActionObject implements Cloneable {

    @JsonProperty
    private String questionStatus;
    @JsonProperty
    private boolean resolved;
    @JsonProperty
    private boolean assumedResolved;
    @JsonProperty
    private boolean open;
    @JsonProperty
    private Long questionCreationDate;
    @JsonProperty
    private Long resolutionDate;
    @JsonProperty
    private Integer numHelpfulAnswers;
    @JsonProperty
    private Integer numReplies;


    public String getQuestionStatus() {
        return questionStatus;
    }

    public void setQuestionStatus(String questionStatus) {
        this.questionStatus = questionStatus;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    public boolean isAssumedResolved() {
        return assumedResolved;
    }

    public void setAssumedResolved(boolean assumedResolved) {
        this.assumedResolved = assumedResolved;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public Long getQuestionCreationDate() {
        return questionCreationDate;
    }

    public void setQuestionCreationDate(Long questionCreationDate) {
        this.questionCreationDate = questionCreationDate;
    }

    public Long getResolutionDate() {
        return resolutionDate;
    }

    public void setResolutionDate(Long resolutionDate) {
        this.resolutionDate = resolutionDate;
    }

    public Integer getNumHelpfulAnswers() {
        return numHelpfulAnswers;
    }

    public void setNumHelpfulAnswers(Integer numHelpfulAnswers) {
        this.numHelpfulAnswers = numHelpfulAnswers;
    }

    public Integer getNumReplies() {
        return numReplies;
    }

    public void setNumReplies(Integer numReplies) {
        this.numReplies = numReplies;
    }
}
