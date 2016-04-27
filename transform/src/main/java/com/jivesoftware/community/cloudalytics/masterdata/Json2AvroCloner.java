package com.jivesoftware.community.cloudalytics.masterdata;

/**
 * Created by gary.schulte on 4/14/16.
 */

import static com.jivesoftware.community.cloudalytics.masterdata.util.AvroCollectionsHelper.*;

import com.jivesoftware.community.cloudalytics.masterdata.avro.*;
import com.jivesoftware.community.cloudalytics.masterdata.jsonschema.*;

import java.util.ArrayList;
import java.util.List;


/**
 * brute force json/jackson-to-avro transformation class
 *
 * TODO: break this up into sensible/readable classes
 */
public class Json2AvroCloner {

    public static AvroEvent clone(EventDocument eventDoc) {
        AvroEvent e = null ;
        if (eventDoc != null) {
            e = new AvroEvent();
            e.setActivity(clone(eventDoc.getActivity()));
            e.setActionObjectId(eventDoc.getActionObjectId());
            e.setActionObjectType(eventDoc.getActionObjectType());
            e.setActivityType(eventDoc.getActivityType());
            e.setActorId(eventDoc.getActorID());
            e.setActorType(eventDoc.getActorType());
            e.setContainerId(eventDoc.getContainerId());
            e.setContainerType(eventDoc.getContainerType());
            e.setContext(eraseNestedMapType(eventDoc.getContext()));
            e.setIsHistoricalReplay(eventDoc.getIsHistoricalReplay());
            e.setName(eventDoc.getName());
            e.setPayload(flattenToJsonMap(eventDoc.getPayload()));
            e.setSeqId(eventDoc.getSeqId());
            e.setTimestamp(eventDoc.getTimestamp());
            e.setUuid(eventDoc.getUuid());
        }
        return e;
    }


    public static AvroActor clone(Actor actor) {
        AvroActor a = null;
        if (actor != null) {
            a = new AvroActor();
            a.setEmail(actor.getEmail());
            a.setClass$(actor.getClass().getSimpleName());
            a.setCombinedObjectTypeId(actor.getCombinedObjectTypeId());
            a.setCreationDate(actor.getCreationDate());
            a.setEnabled(actor.getEnabled());
            a.setExtras(flattenToJsonMap(actor.getExtras()));
            a.setFederated(actor.getFederated());
            a.setFirstName(actor.getFirstName());
            a.setIsDataAvailable(actor.getIsDataAvailable());
            a.setLastLoggedIn(actor.getLastLoggedIn());
            a.setLastName(actor.getLastName());
            a.setLastProfileUpdate(actor.getLastProfileUpdate());
            a.setModificationDate(actor.getModificationDate());
            a.setName(actor.getName());
            a.setObjectHash(actor.getObjectHash());
            a.setObjectId(actor.getObjectId());
            a.setObjectType(actor.getObjectType());
            a.setProfile(flattenToJsonMap(actor.getProfile()));
            if (actor.getStatus() != null) a.setStatus(actor.getStatus());
            a.setTags(eraseListType(actor.getTags()));
            if( actor.getType() != null) a.setType(actor.getType());
            a.setUrl(actor.getUrl());
            a.setUsername(actor.getUsername());
            a.setVisible(actor.getVisible());
            a.setPublicationData(clone(actor.getPublicationData()));
        }
        return a;
    }

    public static AvroDestination clone(ActivityDestination destination) {

        AvroDestination ad = null;
        if (destination != null) {
            ad = new AvroDestination();
            ad.setUrl(destination.getUrl());
            ad.setTags(eraseListType(destination.getTags()));
            ad.setStatus(destination.getStatus());
            ad.setClass$(destination.getClass().getSimpleName());
            ad.setCombinedObjectTypeId(destination.getCombinedObjectTypeId());
            if (destination.getCreationDate() != null) ad.setCreationDate(destination.getCreationDate());
            if (destination.getModificationDate() != null) ad.setModificationDate(destination.getModificationDate());
            ad.setDescription(destination.getDescription());
            ad.setDisplayName(destination.getDisplayName());
            ad.setExtras(flattenToJsonMap(destination.getExtras()));
            ad.setFullPath(destination.getFullPath());
            ad.setIsDataAvailable(destination.getIsDataAvailable());
            ad.setIsVisibleToPartner(destination.getIsVisibleToPartner());
            ad.setName(destination.getName());
            ad.setNormalizedPath(destination.getNormalizedPath());
            ad.setObjectHash(destination.getObjectHash());
            ad.setObjectId(destination.getObjectId());
            ad.setObjectType(destination.getObjectType());
            ad.setParentType(destination.getParentType());
            ad.setParentId(destination.getParentId());
        }
        return ad;
    }

    public static AvroActivity clone(AnalyticsActivity activity){
        AvroActivity a = null;
        if (activity != null) {
            a = new AvroActivity();
            a.setAction(activity.getAction());
            if (activity.getActivityTime() != null) {
                a.setActivityTime(activity.getActivityTime());
            }
            a.setActor(clone(activity.getActor()));
            if (activity.getDestination() != null) {
                a.setDestination(clone(activity.getDestination()));
            }
            a.setActionObject(clone(activity.getActionObject()));
        }
        return a;
    }

    public static List<AvroPublication> clone(List<PublicationData> pubList) {
        List<AvroPublication> aps = null;
        if (pubList != null) {
            aps = new ArrayList<>();
            for(PublicationData pd : pubList) {
                if (pd != null) {
                    AvroPublication ap = new AvroPublication();
                    ap.setPublicationId(pd.getPublicationID());
                    List<SubscriptionData> sds = pd.getSubscriptionData();
                    if (sds != null) {
                        ap.setPublicationData(new ArrayList<>());
                        for (SubscriptionData sd : sds){
                            if (sd != null) {
                                AvroSubscription as = new AvroSubscription();
                                as.setSubscriptionId(sd.getSubscriptionId());
                                as.setSubscribed(sd.getSubscribed());
                                ap.getPublicationData().add(as);
                            }
                        }
                    }
                    aps.add(ap);
                }
            }
        }

        return aps;
    }

    public static AvroAction clone(ActionObject actionObject) {
        return AvroActionDecomposer.decompose(actionObject);
    }


    /**
     * compartmentalize all of the decomposition necessary for the polymorphic
     * actionObject types
     */

    public static class AvroActionDecomposer {

        public static AvroAction decompose(ActionObject actionObject) {
            AvroAction a = null;
            if (actionObject != null) {
                a = new AvroAction();
                a.setClass$(actionObject.getClass().getSimpleName());
                a.setCombinedObjectTypeId(actionObject.getCombinedObjectTypeId());
                a.setObjectType(actionObject.getObjectType());
                a.setObjectId(actionObject.getObjectId());
                a.setObjectHash(actionObject.getObjectHash());
                a.setExtras(flattenToJsonMap(actionObject.getExtras()));
                a.setIsDataAvailable(actionObject.getIsDataAvailable());
                a.setTags(eraseListType(actionObject.getTags()));

                // can't find the reflection magic necessary to not need this switch
                Object eao = null;
                switch (actionObject.getClass().getSimpleName()) {
                    case "ActivityDestination":
                        eao = Json2AvroCloner.clone((ActivityDestination) actionObject);
                        break;
                    case "Actor":
                        eao = Json2AvroCloner.clone((Actor) actionObject);
                        break;
                    case "ActorRelation":
                        eao = clone((ActorRelation) actionObject);
                        break;
                    case "ActorRelationList":
                        eao = clone((ActorRelationList) actionObject);
                        break;
                    case "AppLoadedObject":
                        eao = clone((AppLoadedObject) actionObject);
                        break;
                    case "AttachmentContent":
                        eao = clone((AttachmentContent) actionObject);
                        break;
                    case "ExStorageFileObject":
                        eao = clone((ExStorageFileObject) actionObject);
                        break;
                    case "ExtStorageAttachmentObject":
                        eao = clone((ExtStorageAttachmentObject) actionObject);
                        break;
                    case "ExtensionObject":
                        eao = clone((ExtensionObject) actionObject);
                        break;
                    case "HistoricalReplayStatisticsActionObject":
                        eao = clone((HistoricalReplayStatisticsActionObject) actionObject);
                        break;
                    case "InvitationActionObject":
                        eao = clone((InvitationActionObject) actionObject);
                        break;
                    case "PbQuestActionObject":
                        eao = clone((PbQuestActionObject) actionObject);
                        break;
                    case "SearchActionObject":
                        eao = clone((SearchActionObject) actionObject);
                        break;
                    case "SecurityGroupActionObject":
                        eao = clone((SecurityGroupActionObject) actionObject);
                        break;
                    case "TileInstanceObject":
                        eao = clone((TileInstanceObject) actionObject);
                        break;
                    case "UserRewardBadgeActionObject":
                        eao = clone((UserRewardBadgeActionObject) actionObject);
                        break;

                    // no extended attributes for tag action object
                    case "TagActionObject":
                        break;

                    // these types require additional care
                    case "ActivityContent":
                    case "CommentContent":
                    case "QuestionActionObject":
                    case "TaskContent":
                    case "ThreadActionObject":
                    case "WallEntryContent":
                        eao = clone((ActivityContent) actionObject);
                        break;

                    default:
                        ;

                }
                a.setExtendedActionObject(eao);
            }
            return a;
        }

        private static Object clone(ActionObject obj) throws Exception {
            //no-op. This method should never resolve, unless the specific jackson subclass has not
            // implemented the clone method.
            throw new RuntimeException("unimplemented clone method for " + obj.getClass().getSimpleName());
        }




        private static AvroActorRelation clone(ActorRelation arel) {
            AvroActorRelation eao = null;
            if (arel != null) {
                eao = new AvroActorRelation();
                eao.setStatus(arel.getStatus());
                if (arel.getCreated() != null) eao.setCreationDate(arel.getCreated());
                if (arel.getRetired() != null) eao.setRetiredDate(arel.getRetired());
                if (arel.getGraphType() != null) eao.setGraphType(arel.getGraphType());
                eao.setRelatedUser(Json2AvroCloner.clone(arel.getRelatedUser()));
                if (arel.getRelation() != null) eao.setRelation(arel.getRelation());
                eao.setUser(Json2AvroCloner.clone(arel.getUser()));
            }
            return eao;
        }

        private static AvroActorRelationList clone(ActorRelationList relist) {
            AvroActorRelationList eao = null;
            if (relist != null) {
                eao = new AvroActorRelationList();
                eao.setName(relist.getName());
                eao.setSize(relist.getSize());
            }
            return eao;
        }

        private static AvroAppLoad clone(AppLoadedObject alo) {
            AvroAppLoad eao = null;
            if (alo != null) {
                eao = new AvroAppLoad();
                eao.setAppName(alo.getAppName());
                eao.setAppURL(alo.getAppURL());
                eao.setAssociatedName(alo.getAssociatedName());
                eao.setAssociatedObjectId(alo.getAssociatedObjectId());
                eao.setAssociatedObjectType(alo.getAssociatedObjectType());
                eao.setExtensionUUID(alo.getExtensionUUID());
                eao.setIsSynthetic(alo.getIsSynthetic());
            }
            return eao;
        }

        private static AvroAttachment clone(AttachmentContent ac) {
            AvroAttachment eao = null;
            if (ac != null) {
                eao = new AvroAttachment();
                eao.setAttachmentSize(ac.getAttachmentSize());
                eao.setContentDataAvailable(ac.getContentDataAvailable());
                eao.setCreationDate(ac.getCreationDate());
                eao.setFileName(ac.getFileName());
                eao.setMimeType(ac.getMimeType());
                eao.setModificationDate(ac.getModificationDate());
            }
            return eao;
        }

        private static AvroExStorageFile clone(ExStorageFileObject fo) {
            AvroExStorageFile eao = null;
            if (fo != null) {
                eao = new AvroExStorageFile();
                eao.setExtensionUUID(fo.getExtensionUUID());
                eao.setContentObjectId(fo.getContentObjectId());
                eao.setContentObjectType(fo.getContentObjectType());
                eao.setDefinitionName(fo.getDefinitionName());
                eao.setDefinitionObjectId(fo.getDefinitionObjectId());
                eao.setDefinitionObjectType(fo.getDefinitionObjectType());

            }
            return eao;
        }

        private static AvroExStorageAttachment clone(ExtStorageAttachmentObject ao) {
            AvroExStorageAttachment eao = null;
            if (ao != null) {
                eao = new AvroExStorageAttachment();
                eao.setDefinitionObjectId(ao.getDefinitionObjectId());
                eao.setDefinitionObjectType(ao.getDefinitionObjectType());
                eao.setDefinitionName(ao.getDefinitionName());
                eao.setExtensionUUID(ao.getExtensionUUID());
            }
            return eao;
        }

        private static AvroExtension clone(ExtensionObject eo) {
            AvroExtension eao = null;
            if (eo != null) {
                eao = new AvroExtension();
                eao.setExtensionUUID(eo.getExtensionUUID());
                eao.setStatus(eo.getStatus());
                eao.setCreationDate(eo.getCreationDate());
                eao.setDeployDate(eo.getDeployDate());
                eao.setIsLocal(eo.getIsLocal());
                eao.setIsVisibleToAll(eo.getIsVisibleToAll());
                eao.setName(eo.getName());
                eao.setType(eo.getType());
            }
            return eao;
        }

        private static AvroHistoricalReplayStatistics clone(HistoricalReplayStatisticsActionObject hr) {
            AvroHistoricalReplayStatistics eao = null;
            if (hr != null) {
                eao = new AvroHistoricalReplayStatistics();
                eao.setBatchDroppedCount(hr.getBatchDroppedCount());
                eao.setBatchErrorCount(hr.getBatchErrorCount());
                eao.setBatchIntervalMS(hr.getBatchIntervalMS());
                eao.setBatchNumFound(hr.getBatchNumFound());
                eao.setBatchSentCount(hr.getBatchSentCount());
                eao.setBatchSize(hr.getBatchSize());
                eao.setBatchStartTime(hr.getBatchStartTime());
                eao.setBatchUnknownCodeCount(hr.getBatchUnknownCodeCount());
                eao.setCursor(hr.getCursor());
                eao.setRunId(hr.getRunId());
                eao.setStage(hr.getStage());
                eao.setStageDroppedCount(hr.getStageDroppedCount());
                eao.setStageEndTime(hr.getStageEndTime());
                eao.setStageErrorCount(hr.getStageErrorCount());
                eao.setStageNumToProcess(hr.getStageNumToProcess());
                eao.setStageSentCount(hr.getStageSentCount());
                eao.setStageStartTime(hr.getStageStartTime());
                eao.setStageUnknownCodeCount(hr.getStageUnknownCodeCount());
                eao.setStageProcessedCount(hr.getStageProcessedCount());
                eao.setState(hr.getState());
            }
            return eao;
        }

        private static AvroInvitation clone(InvitationActionObject iao) {
            AvroInvitation eao = null;
            if (iao != null) {
                eao = new AvroInvitation();
                eao.setCreationDate(iao.getCreationDate());
                eao.setInvitationId(iao.getInvitationId());
                eao.setInviteeEmail(iao.getInviteeEmail());
                eao.setInviterEmail(iao.getInviterEmail());
                eao.setInvterUserName(iao.getInviterUsername());
                eao.setModificationDate(iao.getModificationDate());
                eao.setRevokeDate(iao.getRevokeDate());
                eao.setRevokerUsername(iao.getRevokerUsername());
                eao.setSentDate(iao.getSentDate());
                eao.setState(iao.getState());
            }
            return eao;
        }

        private static AvroPlayboxQuest clone(PbQuestActionObject pao) {
            AvroPlayboxQuest eao = null;
            if (pao != null) {
                eao = new AvroPlayboxQuest();
                eao.setIsApiRequest(pao.getIsApiRequest());
                eao.setQuestId(pao.getQuestId());
                eao.setSecret(pao.getSecret());
                eao.setTaskId(pao.getTaskId());
            }
            return eao;
        }

        private static AvroSearch clone(SearchActionObject sao) {
            AvroSearch eao = null;
            if (sao != null) {
                eao = new AvroSearch();
                eao.setKeywords(sao.getKeywords());
                eao.setQueries(eraseListType(sao.getQueries()));
                eao.setSearchFinalQuery(sao.getSearchFinalQuery());
                eao.setSearchSelectedId(sao.getSearchSelectedId());
                eao.setSearchSelectedType(sao.getSearchSelectedType());
            }
            return eao;
        }

        private static AvroSecurityGroup clone(SecurityGroupActionObject sga) {
            AvroSecurityGroup eao = null;
            if (sga != null) {
                eao = new AvroSecurityGroup();
                eao.setCreationDate(sga.getCreationDate());
                eao.setFederated(sga.getFederated());
                eao.setModificationDate(sga.getModificationDate());
                eao.setName(sga.getName());
            }
            return eao;
        }

        private static AvroTileInstance clone(TileInstanceObject tio) {
            AvroTileInstance eao = null;
            if (tio != null) {
                eao = new AvroTileInstance();
                eao.setExtensionUUID(tio.getExtensionUUID());
                eao.setIsActivityStream(tio.getIsActivityStream());
                eao.setTileDefinitionName(tio.getTileDefinitionName());
                eao.setTileDefinitionObjectId(tio.getTileDefinitionObjectId());
                eao.setTileDefinitionObjectType(tio.getTileDefinitionObjectType());
                eao.setTileDefinitionVisualType(tio.getTileDefinitionVisualType());
            }
            return eao;
        }

        private static AvroUserRewardBadge clone(UserRewardBadgeActionObject urb) {
            AvroUserRewardBadge eao = null;
            if (urb != null) {
                eao = new AvroUserRewardBadge();
                eao.setBadgeId(urb.getBadgeId());
                eao.setMessage(urb.getMessage());
                eao.setStreamEntryId(urb.getStreamEntryId());
                eao.setStreamEntryUrl(urb.getStreamEntryUrl());
                eao.setUserEmail(urb.getUserEmail());
            }
            return eao;
        }

        private static Object clone(TagActionObject tao) {
            // tag actions have no extended action attributes
            return null;
        }

        private static AvroContent clone(ActivityContent ac) {
            AvroContent avc = null;
            if (ac != null) {
                avc = new AvroContent();
                avc.setStatus(ac.getStatus());
                avc.setModificationDate(ac.getModifiedDate());
                avc.setAuthor(Json2AvroCloner.clone(ac.getAuthor()));
                avc.setAuthorId(ac.getAuthorId());
                avc.setContainerId(ac.getContainerId());
                avc.setContainerType(ac.getContainerType());
                avc.setCreationDate(ac.getCreationDate());
                avc.setFullPath(ac.getFullPath());
                avc.setUrl(ac.getUrl());
                avc.setIsVisibleToPartner(ac.getIsVisibleToPartner());
                avc.setSubject(ac.getSubject());
                avc.setNormalizedPath(ac.getNormalizedPath());
                Object eco = null;

                // decompose the content elements, again lacking reflection magic to avoid switch statement
                switch (ac.getClass().getSimpleName()) {
                    case "CommentContent":
                        eco = clone((CommentContent) ac);
                        break;
                    case "QuestionActionObject":
                        eco = clone((QuestionActionObject) ac);
                        break;
                    case "TaskContent":
                        eco = clone((TaskContent) ac);
                        break;
                    case "ThreadActionObject":
                        eco = clone((ThreadActionObject) ac);
                        break;
                    case "WallEntryContent":
                        eco = clone((WallEntryContent) ac);
                        break;
                    default:
                        ;

                }
                avc.setContentElements(eco);
            }
            return avc;
        }

        private static AvroComment clone(CommentContent cc) {
            AvroComment eco = null;
            if (cc != null) {
                eco = new AvroComment();
                eco.setParentCommentId(cc.getParentCommentId());
                eco.setParentComment(decompose(cc.getParentComment()));
            }
            return eco;
        }

        /**
         * this method resolves the self-reference of CommentContent (which has a
         * parentComment element of CommentContent).  The Avro schema denormalizes
         * parent comments into their own standalone objects for simplicity and
         * explicit definition.
         */
        private static AvroParentComment decompose(CommentContent cc) {
            AvroParentComment pc = null;
            if (cc != null) {
                pc = new AvroParentComment();
                pc.setAuthor(Json2AvroCloner.clone(cc.getAuthor()));
                pc.setAuthorId(cc.getAuthorId());
                pc.setClass$(cc.getClass().getSimpleName());
                pc.setCombinedObjectTypeId(cc.getCombinedObjectTypeId());
                pc.setContainerId(cc.getContainerId());
                pc.setContainerType(cc.getContainerType());
                pc.setCreationDate(cc.getCreationDate());
                pc.setExtras(flattenToJsonMap(cc.getExtras()));
                pc.setFullPath(cc.getFullPath());
                pc.setIsVisibleToPartner(cc.getIsVisibleToPartner());
                pc.setIsDataAvailable(cc.getIsDataAvailable());
                pc.setModificationDate(cc.getModifiedDate());
                pc.setNormalizedPath(cc.getNormalizedPath());
                pc.setObjectHash(cc.getObjectHash());
                pc.setObjectId(cc.getObjectId());
                pc.setObjectType(cc.getObjectType());
                pc.setParentCommentId(cc.getParentCommentId());
                pc.setParentComment(decompose(cc.getParentComment()));
                pc.setStatus(cc.getStatus());
                pc.setSubject(cc.getSubject());
                pc.setTags(eraseListType(cc.getTags()));
                pc.setUrl(cc.getUrl());
            }
            return pc;
        }

        private static AvroQuestion clone(QuestionActionObject qao) {
            AvroQuestion eco = null;
            if (qao != null) {
                eco = new AvroQuestion();
                eco.setNumHelpfulAnswers(qao.getNumHelpfulAnswers());
                eco.setResolved(qao.getResolved());
                eco.setResolutionDate(qao.getResolutionDate());
                eco.setQuestionStatus(qao.getQuestionStatus());
                eco.setQuestionCreateDate(qao.getQuestionCreationDate());
                eco.setIsQuestion(qao.getIsQuestion());
                eco.setNumReplies(qao.getNumReplies());
                eco.setOpen(qao.getOpen());
                eco.setAssumedResolved(qao.getAssumedResolved());
            }
            return eco;
        }

        private static AvroTask clone(TaskContent tc) {
            AvroTask eco = null;
            if (tc != null) {
                eco = new AvroTask();
                eco.setParentTask(decompose(tc.getParentTask()));
                eco.setOwner(Json2AvroCloner.clone(tc.getOwner()));
                eco.setDueDate(tc.getDueDate());
                eco.setCompleted(tc.getCompleted());
            }
            return eco;
        }

        /**
         * this method resolves the self-reference of TaskContent (which has a
         * parent TaskContent element).  The Avro schema denormalizes
         * parent tasks into their own standalone objects for simplicity and
         * explicit definition.
         */

        private static AvroParentTask decompose(TaskContent pt) {
            AvroParentTask pc = null;
            if (pc != null) {
                pc = new AvroParentTask();
                pc.setAuthor(Json2AvroCloner.clone(pt.getAuthor()));
                pc.setAuthorId(pt.getAuthorId());
                pc.setClass$(pt.getClass().getSimpleName());
                pc.setCombinedObjectTypeId(pt.getCombinedObjectTypeId());
                pc.setCompleted(pt.getCompleted());
                pc.setContainerId(pt.getContainerId());
                pc.setContainerType(pt.getContainerType());
                pc.setCreationDate(pt.getCreationDate());
                pc.setDueDate(pt.getDueDate());
                pc.setExtras(flattenToJsonMap(pt.getExtras()));
                pc.setFullPath(pt.getFullPath());
                pc.setIsVisibleToPartner(pt.getIsVisibleToPartner());
                pc.setIsDataAvailable(pt.getIsDataAvailable());
                pc.setModificationDate(pt.getModifiedDate());
                pc.setNormalizedPath(pt.getNormalizedPath());
                pc.setObjectHash(pt.getObjectHash());
                pc.setObjectId(pt.getObjectId());
                pc.setObjectType(pt.getObjectType());
                pc.setOwner(Json2AvroCloner.clone(pt.getOwner()));
                pc.setParentTask(decompose(pt.getParentTask()));
                pc.setStatus(pt.getStatus());
                pc.setSubject(pt.getSubject());
                pc.setTags(eraseListType(pt.getTags()));
                pc.setUrl(pt.getUrl());
            }
            return pc;

        }

        private static AvroThread clone(ThreadActionObject tao) {
            AvroThread eco = null;
            if (tao != null) {
                eco = new AvroThread();
                eco.setIsQuestion(tao.getIsQuestion());
            }
            return eco;
        }

        private static AvroWallEntry clone(WallEntryContent wec) {
            AvroWallEntry eco = null;
            if (wec != null) {
                eco = new AvroWallEntry();
                if (wec.getRecipientIds() != null)
                    eco.setRecipientIds(new ArrayList<Long>(wec.getRecipientIds()));
                eco.setNumRecipients(wec.getNumRecipients());
                eco.setMessageType(wec.getMessageType());
            }
            return eco;
        }


    }

}
