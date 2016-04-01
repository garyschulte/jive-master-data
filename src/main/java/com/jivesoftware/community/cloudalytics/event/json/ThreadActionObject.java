/*
 * Copyright (C) 1999-2015 Jive Software. All rights reserved.
 *
 * This software is the proprietary information of Jive Software. Use is subject to license terms.
 */
package com.jivesoftware.community.cloudalytics.event.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ThreadActionObject extends ActivityContent implements Cloneable {

    @JsonProperty
    private boolean isQuestion;

    public ThreadActionObject() {
        isQuestion = this instanceof QuestionActionObject;
    }

    public boolean isQuestion() {
        return isQuestion;
    }

    public void setQuestion(boolean isQuestion) {
        this.isQuestion = isQuestion;
    }
}
