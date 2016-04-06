/*
 * Copyright (C) 1999-2015 Jive Software. All rights reserved.
 *
 * This software is the proprietary information of Jive Software. Use is subject to license terms.
 */
package com.jivesoftware.community.cloudalytics.event.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommentContent extends ActivityContent implements Cloneable {

    @JsonProperty
    private Long parentCommentId;
    @JsonProperty
    private CommentContent parentComment;

    public Long getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public CommentContent getParentComment() {
        return parentComment;
    }

    public void setParentComment(CommentContent parentComment) {
        this.parentComment = parentComment;
    }
}
