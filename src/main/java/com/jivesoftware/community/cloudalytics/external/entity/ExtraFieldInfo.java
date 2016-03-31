/*
 * Copyright (C) 1999-2015 Jive Software. All rights reserved.
 *
 * This software is the proprietary information of Jive Software. Use is subject to license terms.
 */
package com.jivesoftware.community.cloudalytics.external.entity;

/**
 * Convenience copy of com.jivesoftware.community.cloudalytics.export.entity from cloudalytics-api.
 * May or may not be in sync
 */
public enum ExtraFieldInfo {

    //MOVE Event - Source Container Data
    fromContainerType,
    fromContainerId,
    fromContainerName,

    //ATTACHMENT Event
    attachmentFilename,
    attachmentContentType,
    attachmentCreationDate,
    attachmentModifiedDate,
    attachmentSize,

    //COMMENT EVent
    commentId,
    commentSubject,
    commentCreationDate,
    commentModifiedDate,
    commentAuthors,
    commentStatus,
    commentUrl,
    commentParentid,
    isRootReply,
    commentParentAuthor,

    //SHARE Event
    shareSubject,
    shareCreationDate,
    shareModifiedDate,
    shareAuthors,
    shareStatus,
    shareRecipients,

    //BOOKMARK Event
    bookmarkSubject,
    bookmarkCreationDate,
    bookmarkModifiedDate,
    bookmarkAuthors,
    bookmarkStatus,
    bookmarkBody,
    bookmarkUrl,

    //MENTION Event
    mentionId,
    mentionName,
    mentionType,
    mentionUrl,

    //OUTCOME Event
    outcomeId,
    outcomeType,
    outcomeApprovers,
    outcomeNote,
    outcomeStatus,
    outcomePredecessorId,
    outcomeParentId,
    outcomeParentType,
    outcomeParentContainerId,
    outcomeParentContainerType,

    //Email Event
    emailSender,
    emailRecipients,
    emailSubject,
    emailCombinedParentObjectTypeId,
    //Invitation Event
    /*
    invitationId,
    invitationCreationDate,
    invitationObjectId,
    invitationObjectType,
    invitationInviter,
    invitationEmail
    */

    // Status Points Changed event
    pointTotal,

    //for MessageEvent
    isRootMessage,
    belongsToQuestion,
    messageParentId,

    // Expertise (Endorsement) event
    endorsementTagName,
    endorsementTagUnfilteredName,
    endorsementTagId,
    endorsementTagObjectType,
    endorsementApprovalStep,

    // MessageEvent
    forumThreadId,

    // AcclaimType
    acclaimId,
    acclaimType,

    // SearchEvent
    searchSelectedId,
    searchSelectedType,
    searchFinalQuery,

    // Permissions
    permissionLevelId,
    permissionLevelName,
    oldPermissionLevelId,
    oldPermissionLevelName,

    // Direct Messages and shares and mentions
    recipientUser,

    // EventEvent
    response,

    // CollaborationEvent
    affectedCollaborationUsers;
}
