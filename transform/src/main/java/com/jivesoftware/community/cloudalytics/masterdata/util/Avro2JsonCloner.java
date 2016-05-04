package com.jivesoftware.community.cloudalytics.masterdata.util;

import static com.jivesoftware.community.cloudalytics.masterdata.util.AvroCollectionsHelper.*;

import com.jivesoftware.community.cloudalytics.masterdata.ParseException;
import com.jivesoftware.community.cloudalytics.masterdata.avro.*;
import com.jivesoftware.community.cloudalytics.masterdata.jsonschema.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Static utility methods for transforming avro types to json/jackson types.
 */
public class Avro2JsonCloner {

    public static EventDocument clone(AvroEvent avroEvent) throws ParseException {
        EventDocument eventDoc = null;
        if (avroEvent != null) {
            eventDoc = new EventDocument();
            eventDoc.setActionObjectId(avroEvent.getActionObjectId());
            eventDoc.setActionObjectType(avroEvent.getActionObjectType());
            eventDoc.setActivityType(safeToString(avroEvent.getActivityType()));
            eventDoc.setActorID(avroEvent.getActorId());
            eventDoc.setActorType(avroEvent.getActorType());
            eventDoc.setContainerId(avroEvent.getContainerId());
            eventDoc.setContainerType(avroEvent.getContainerType());
            eventDoc.setContext(eraseNestedMapType(avroEvent.getContext()));
            eventDoc.setIsHistoricalReplay(avroEvent.getIsHistoricalReplay());
            eventDoc.setName(safeToString(avroEvent.getName()));
            eventDoc.setPayload(eraseMapType(avroEvent.getPayload()));
            eventDoc.setSeqId(avroEvent.getSeqId());
            eventDoc.setTimestamp(avroEvent.getTimestamp());
            eventDoc.setUuid(safeToString(avroEvent.getUuid()));
            try {
                eventDoc.setActivity(clone(avroEvent.getActivity()));
            } catch (ParseException e) {
                throw new ParseException(e, avroEvent.toString(), eventDoc);
            }
        }

        return eventDoc;
    }

    public static AnalyticsActivity clone(AvroActivity avroActivity) throws ParseException {
        AnalyticsActivity aa = null;
        if (avroActivity != null) {
            aa = new AnalyticsActivity();
            aa.setAction(safeToString(avroActivity.getAction()));
            aa.setActivityTime(avroActivity.getActivityTime());
            aa.setActor(clone(avroActivity.getActor()));
            aa.setDestination(clone(avroActivity.getDestination()));
            try {
                aa.setActionObject(clone(avroActivity.getActionObject()));
            } catch (ParseException e) {
                throw new ParseException(e, avroActivity.toString(), aa);
            }
        }
        return aa;
    }

    public static Actor clone(AvroActor avroActor) {
        Actor a = null;
        if (avroActor != null) {
            a = new Actor();
            a.setCreationDate(avroActor.getCreationDate());
            a.setEmail(safeToString(avroActor.getEmail()));
            a.setEnabled(avroActor.getEnabled());
            a.setFederated(avroActor.getFederated());
            a.setFirstName(safeToString(avroActor.getFirstName()));
            a.setLastLoggedIn(avroActor.getLastLoggedIn());
            a.setLastName(safeToString(avroActor.getLastName()));
            a.setLastProfileUpdate(avroActor.getLastProfileUpdate());
            a.setModificationDate(avroActor.getModificationDate());
            a.setName(safeToString(avroActor.getName()));
            a.setProfile(unflattenJsonMap(avroActor.getProfile()));
            a.setPublicationData(clone(avroActor.getPublicationData()));
            a.setStatus(safeToString(avroActor.getStatus()));
            a.setType(safeToString(avroActor.getType()));
            a.setUrl(safeToString(avroActor.getUrl()));
            a.setUsername(safeToString(avroActor.getUsername()));
            a.setVisible(avroActor.getVisible());

            // manually set superclass attributes rather than using visitor pattern since AvroActor
            // is a standalone object as well as ExtendedActionObject
            a.setTags(eraseListType(avroActor.getTags()));
            a.setCombinedObjectTypeId(safeToString(avroActor.getCombinedObjectTypeId()));
            a.setExtras(unflattenJsonMap(avroActor.getExtras()));
            a.setIsDataAvailable(avroActor.getIsDataAvailable());
            a.setObjectHash(safeToString(avroActor.getObjectHash()));
            a.setObjectId(avroActor.getObjectId());
            a.setObjectType(safeToString(avroActor.getObjectType()));
        }


        return a;
    }

    public static ActivityDestination clone(AvroDestination avroDestination) {
        ActivityDestination ad = null;
        if (avroDestination != null) {
            ad = new ActivityDestination();
            ad.setName(safeToString(avroDestination.getName()));
            ad.setDisplayName(safeToString(avroDestination.getDisplayName()));
            ad.setDescription(safeToString(avroDestination.getDescription()));
            ad.setCreationDate(avroDestination.getCreationDate());
            ad.setModificationDate(avroDestination.getModificationDate());
            ad.setUrl(safeToString(avroDestination.getUrl()));
            ad.setStatus(safeToString(avroDestination.getStatus()));
            ad.setIsVisibleToPartner(avroDestination.getIsVisibleToPartner());
            ad.setParentId(avroDestination.getParentId());
            ad.setParentType(safeToString(avroDestination.getParentType()));
            ad.setFullPath(safeToString(avroDestination.getFullPath()));
            ad.setNormalizedPath(safeToString(avroDestination.getNormalizedPath()));

            // manually set superclass attributes rather than using visitor pattern since AvroDestination
            // is a standalone object as well as ExtendedActionObject
            ad.setTags(eraseListType(avroDestination.getTags()));
            ad.setCombinedObjectTypeId(safeToString(avroDestination.getCombinedObjectTypeId()));
            ad.setExtras(unflattenJsonMap(avroDestination.getExtras()));
            ad.setIsDataAvailable(avroDestination.getIsDataAvailable());
            ad.setObjectHash(safeToString(avroDestination.getObjectHash()));
            ad.setObjectId(avroDestination.getObjectId());
            ad.setObjectType(safeToString(avroDestination.getObjectType()));
        }
        return ad;
    }

    public static List<PublicationData> clone(List<AvroPublication> avroPubList) {
        List<PublicationData> pubData = null;
        if (avroPubList != null) {
            pubData = new ArrayList<>();
            for (AvroPublication avroPub : avroPubList) {
                if (avroPub != null) {
                    PublicationData pd = new PublicationData();
                    pd.setPublicationID(avroPub.getPublicationId());
                    List<AvroSubscription> avroSubs = avroPub.getPublicationData();
                    if (avroSubs != null) {
                        pd.setSubscriptionData(new ArrayList<>());
                        for(AvroSubscription avroSub : avroSubs) {
                            if(avroSub != null){
                                SubscriptionData sd = new SubscriptionData();
                                sd.setSubscribed(avroSub.getSubscribed());
                                sd.setSubscriptionId(avroSub.getSubscriptionId());
                                pd.getSubscriptionData().add(sd);
                            }
                        }
                    }
                    pubData.add(pd);
                }
            }
        }
        return pubData;
    }

    static CommentContent clone(AvroParentComment apc) {
        CommentContent cc = null;
        if (apc != null) {

            cc = new CommentContent();

            cc.setParentCommentId(apc.getParentCommentId());
            if (apc.getParentComment() != null)
                cc.setParentComment(clone(apc.getParentComment()));

            // manually set superclass attributes rather than using visitor pattern since CommentContent
            // is a standalone object to help sort out circular references

            // superclass ActivityContent fields
            cc.setAuthor(Avro2JsonCloner.clone(apc.getAuthor()));
            cc.setAuthorId(apc.getAuthorId());
            cc.setContainerId(apc.getContainerId());
            cc.setContainerType(safeToString(apc.getContainerType()));
            cc.setCreationDate(apc.getCreationDate());
            cc.setFullPath(safeToString(apc.getFullPath()));
            cc.setIsVisibleToPartner(apc.getIsVisibleToPartner());
            cc.setLatestVersionAuthorId(apc.getLatestVersionAuthorId());
            cc.setModifiedDate(apc.getModificationDate());
            cc.setNormalizedPath(safeToString(apc.getNormalizedPath()));
            cc.setStatus(safeToString(apc.getStatus()));
            cc.setSubject(safeToString(apc.getSubject()));
            cc.setUrl(safeToString(apc.getUrl()));
            cc.setVersionId(apc.getVersionId());

            //super-superclass ActionObject fields
            cc.setTags(eraseListType(apc.getTags()));
            cc.setCombinedObjectTypeId(safeToString(apc.getCombinedObjectTypeId()));
            cc.setExtras(unflattenJsonMap(apc.getExtras()));
            cc.setIsDataAvailable(apc.getIsDataAvailable());
            cc.setObjectHash(safeToString(apc.getObjectHash()));
            cc.setObjectId(apc.getObjectId());
            cc.setObjectType(safeToString(apc.getObjectType()));
        }
        return cc;
    }

    static TaskContent clone(AvroParentTask apt) {
        TaskContent tc = null;
        if (apt != null) {
            tc = new TaskContent();
            tc.setCompleted(apt.getCompleted());
            tc.setDueDate(apt.getDueDate());
            tc.setOwner(Avro2JsonCloner.clone(apt.getOwner()));
            tc.setParentTask(Avro2JsonCloner.clone(apt.getParentTask()));

            // manually set superclass attributes rather than using visitor pattern since CommentContent
            // is a standalone object to help sort out circular references

            // superclass ActivityContent fields
            tc.setAuthor(Avro2JsonCloner.clone(apt.getAuthor()));
            tc.setAuthorId(apt.getAuthorId());
            tc.setContainerId(apt.getContainerId());
            tc.setContainerType(safeToString(apt.getContainerType()));
            tc.setCreationDate(apt.getCreationDate());
            tc.setFullPath(safeToString(apt.getFullPath()));
            tc.setIsVisibleToPartner(apt.getIsVisibleToPartner());
            tc.setLatestVersionAuthorId(apt.getLatestVersionAuthorId());
            tc.setModifiedDate(apt.getModificationDate());
            tc.setNormalizedPath(safeToString(apt.getNormalizedPath()));
            tc.setStatus(safeToString(apt.getStatus()));
            tc.setSubject(safeToString(apt.getSubject()));
            tc.setUrl(safeToString(apt.getUrl()));
            tc.setVersionId(apt.getVersionId());

            // super-superclass ActionObject fields
            tc.setTags(eraseListType(apt.getTags()));
            tc.setCombinedObjectTypeId(safeToString(apt.getCombinedObjectTypeId()));
            tc.setExtras(unflattenJsonMap(apt.getExtras()));
            tc.setIsDataAvailable(apt.getIsDataAvailable());
            tc.setObjectHash(safeToString(apt.getObjectHash()));
            tc.setObjectId(apt.getObjectId());
            tc.setObjectType(safeToString(apt.getObjectType()));
        }

        return tc;
    }


    public static ActionObject clone(AvroAction avroAction) throws ParseException {
        ActionObject ao = null;

        if (avroAction != null && avroAction.getClass$() != null) {
            ao = ExtendedActionObjectHelper.resolve(avroAction);
        }
        return ao;
    }

    /**
     * Class to flatten the avro action object composition into their polymorphic json counterparts
     */
    static class ExtendedActionObjectHelper {

        /* compartmentalize all of the warning and type checking suppression here */
        public static ActionObject resolve(AvroAction avroAction) throws ParseException {
            ActionObject ao = new ActionObject();
            if (avroAction != null) {
                try {
                    // get the target json class
                    String jsonClassName = ActionObject.class.getPackage().getName() + "." + avroAction.getClass$().toString();
                    Class jsonClass = ActionObject.class.forName(jsonClassName);
                    ao = (ActionObject) jsonClass.newInstance();
                    Object eao = avroAction.getExtendedActionObject();
                    if (eao != null) {
                        ao = invokeVisitor(ao, eao);
                    }
                } catch (ClassNotFoundException e) {
                    // TODO: for this or NPE, an explicit  mapping between the polymorphic types
                    // and their avro counterparts would be a possible fallback option
                    throw new ParseException(e, avroAction.toString(), ao);
                } catch (IllegalAccessException e) {
                    throw new ParseException(e, avroAction.toString(), ao);
                } catch (InstantiationException e) {
                    throw new ParseException(e, avroAction.toString(), ao);
                }
            }

            ao.setTags(eraseListType(avroAction.getTags()));
            ao.setCombinedObjectTypeId(safeToString(avroAction.getCombinedObjectTypeId()));
            ao.setExtras(unflattenJsonMap(avroAction.getExtras()));
            ao.setIsDataAvailable(avroAction.getIsDataAvailable());
            ao.setObjectHash(safeToString(avroAction.getObjectHash()));
            ao.setObjectId(avroAction.getObjectId());
            ao.setObjectType(safeToString(avroAction.getObjectType()));

            return ao;
        }

        static ActionObject visitor(Actor jsonActor, AvroActor avroActor) {
            // use the actor clone method to return a new clone of the actor.  possible because AvroActor is a standalone object also
            return Avro2JsonCloner.clone(avroActor);
        }

        static ActionObject visitor(ActivityDestination jsonDestination, AvroDestination avroDestination) {
            // use the destination clone method to return a new clone of the destination.  possible because AvroDestination is a standalone object also
            return Avro2JsonCloner.clone(avroDestination);
        }

        static ActionObject visitor(ActivityContent jsonContent, AvroContent ac) {
            if (ac != null && jsonContent != null) {
                jsonContent.setAuthor(Avro2JsonCloner.clone(ac.getAuthor()));
                jsonContent.setAuthorId(ac.getAuthorId());
                jsonContent.setContainerId(ac.getContainerId());
                jsonContent.setContainerType(safeToString(ac.getContainerType()));
                jsonContent.setCreationDate(ac.getCreationDate());
                jsonContent.setFullPath(safeToString(ac.getFullPath()));
                jsonContent.setIsVisibleToPartner(ac.getIsVisibleToPartner());
                jsonContent.setLatestVersionAuthorId(ac.getLatestVersionAuthorId());
                jsonContent.setModifiedDate(ac.getModificationDate());
                jsonContent.setNormalizedPath(safeToString(ac.getNormalizedPath()));
                jsonContent.setStatus(safeToString(ac.getStatus()));
                jsonContent.setSubject(safeToString(ac.getSubject()));
                jsonContent.setUrl(safeToString(ac.getUrl()));
                jsonContent.setVersionId(ac.getVersionId());

                Object contentElements = ac.getContentElements();
                if (contentElements != null) {
                    // a little bit more reflection magic due to ActivityContent being a superclass
                    invokeVisitor(jsonContent, contentElements);
                }
            }
            return jsonContent;
        }

        static ActionObject visitor(CommentContent jsonComment, AvroComment avroComment) {
            if (avroComment != null && jsonComment != null) {
                jsonComment.setParentCommentId(avroComment.getParentCommentId());
                jsonComment.setParentComment(Avro2JsonCloner.clone(avroComment.getParentComment()));
            }
            return jsonComment;
        }

        static ActionObject visitor(QuestionActionObject qao, AvroQuestion aq) {
            if (aq != null && qao != null) {
                qao.setAssumedResolved(aq.getAssumedResolved());
                qao.setIsQuestion(aq.getIsQuestion());
                qao.setNumHelpfulAnswers(aq.getNumHelpfulAnswers());
                qao.setNumReplies(aq.getNumReplies());
                qao.setOpen(aq.getOpen());
                qao.setQuestionCreationDate(aq.getQuestionCreateDate());
                qao.setQuestionStatus(safeToString(aq.getQuestionStatus()));
                qao.setResolutionDate(aq.getResolutionDate());
                qao.setResolved(aq.getResolved());
            }
            return qao;
        }

        static ActionObject visitor(ThreadActionObject tao, AvroThread at) {
            if (at != null && tao != null) {
                tao.setIsQuestion(at.getIsQuestion());
            }
            return tao;
        }

        static ActionObject visitor(TaskContent tc, AvroTask at) {
            if (at != null && tc != null) {
                tc.setCompleted(at.getCompleted());
                tc.setDueDate(at.getDueDate());
                tc.setOwner(Avro2JsonCloner.clone(at.getOwner()));
                tc.setParentTask(Avro2JsonCloner.clone(at.getParentTask()));
            }
            return tc;
        }

        static ActionObject visitor(WallEntryContent wec, AvroWallEntry awe) {
            if (awe != null && wec != null) {
                wec.setMessageType(safeToString(awe.getMessageType()));
                wec.setNumRecipients(awe.getNumRecipients());
                wec.setRecipientIds(awe.getRecipientIds());
            }
            return wec;
        }

        static ActionObject visitor(ActorRelation arel, AvroActorRelation aar) {
            if (arel != null && aar != null) {
                arel.setCreated(aar.getCreationDate());
                arel.setGraphType(safeToString(aar.getGraphType()));
                arel.setRelatedUser(Avro2JsonCloner.clone(aar.getRelatedUser()));
                arel.setRelation(safeToString(aar.getRelation()));
                arel.setRetired(aar.getRetiredDate());
                arel.setStatus(safeToString(aar.getStatus()));
                arel.setUser(Avro2JsonCloner.clone(aar.getUser()));

            }
            return arel;
        }

        static ActionObject visitor(ActorRelationList arel, AvroActorRelationList aarl) {
            if (arel != null && aarl != null) {
                arel.setName(safeToString(aarl.getName()));
                arel.setSize(aarl.getSize());
            }
            return arel;
        }

        static ActionObject visitor(AppLoadedObject alo, AvroAppLoad aal) {
            if (alo != null && aal != null) {
                alo.setAppName(safeToString(aal.getAppName()));
                alo.setAppURL(safeToString(aal.getAppURL()));
                alo.setAssociatedName(safeToString(aal.getAssociatedName()));
                alo.setAssociatedObjectId(aal.getAssociatedObjectId());
                alo.setAssociatedObjectType(safeToString(aal.getAssociatedObjectType()));
                alo.setExtensionUUID(safeToString(aal.getExtensionUUID()));
                alo.setIsSynthetic(aal.getIsSynthetic());
            }
            return alo;
        }

        static ActionObject visitor(AttachmentContent ac, AvroAttachment aa) {
            if (ac != null && aa != null) {
                ac.setAttachmentSize(aa.getAttachmentSize());
                ac.setContentDataAvailable(aa.getContentDataAvailable());
                ac.setCreationDate(aa.getCreationDate());
                ac.setFileName(safeToString(aa.getFileName()));
                ac.setMimeType(safeToString(aa.getMimeType()));
                ac.setModificationDate(aa.getModificationDate());
            }
            return ac;
        }

        static ActionObject visitor(ExStorageFileObject esfo, AvroExStorageFile aesf) {
            if (esfo != null && aesf != null) {
                esfo.setExtensionUUID(safeToString(aesf.getExtensionUUID()));
                esfo.setDefinitionName(safeToString(aesf.getDefinitionName()));
                esfo.setDefinitionObjectId(aesf.getDefinitionObjectId());
                esfo.setDefinitionObjectType(safeToString(aesf.getDefinitionObjectType()));
                esfo.setContentObjectId(aesf.getContentObjectId());
                esfo.setContentObjectType(safeToString(aesf.getContentObjectType()));
            }
            return esfo;
        }

        static ActionObject visitor(ExtStorageAttachmentObject esao, AvroExStorageAttachment aesa) {
            if (esao != null && aesa != null) {
                esao.setDefinitionObjectType(safeToString(aesa.getDefinitionObjectType()));
                esao.setDefinitionObjectId(aesa.getDefinitionObjectId());
                esao.setDefinitionName(safeToString(aesa.getDefinitionName()));
                esao.setExtensionUUID(safeToString(aesa.getExtensionUUID()));
            }
            return esao;
        }

        static ActionObject visitor(ExtStorageContainerObject esco, AvroExStorageContainer aesc) {
            if (esco != null && aesc != null) {
                esco.setExtensionUUID(safeToString(aesc.getExtensionUUID()));
                esco.setDefinitionName(safeToString(aesc.getDefinitionName()));
                esco.setDefinitionObjectId(aesc.getDefinitionObjectId());
                esco.setDefinitionObjectType(safeToString(aesc.getDefinitionObjectType()));
                esco.setState(safeToString(aesc.getState()));
            }
            return esco;
        }

        static ActionObject visitor(ExtensionObject eo, AvroExtension ae) {
            if (eo != null && ae != null) {
                eo.setName(safeToString(ae.getName()));
                eo.setCreationDate(ae.getCreationDate());
                eo.setDeployDate(ae.getDeployDate());
                eo.setExtensionUUID(safeToString(ae.getExtensionUUID()));
                eo.setIsLocal(ae.getIsLocal());
                eo.setIsVisibleToAll(ae.getIsVisibleToAll());
                eo.setStatus(safeToString(ae.getStatus()));
                eo.setType(safeToString(ae.getType()));
            }
            return eo;
        }

        static ActionObject visitor(HistoricalReplayStatisticsActionObject hrsao, AvroHistoricalReplayStatistics ahrs) {
            if (hrsao != null && ahrs != null) {
                hrsao.setBatchDroppedCount(ahrs.getBatchDroppedCount());
                hrsao.setBatchErrorCount(ahrs.getBatchErrorCount());
                hrsao.setBatchIntervalMS(ahrs.getBatchIntervalMS());
                hrsao.setBatchNumFound(ahrs.getBatchNumFound());
                hrsao.setBatchSentCount(ahrs.getBatchSentCount());
                hrsao.setBatchSize(ahrs.getBatchSize());
                hrsao.setBatchStartTime(ahrs.getBatchStartTime());
                hrsao.setBatchUnknownCodeCount(ahrs.getBatchUnknownCodeCount());
                hrsao.setCursor(safeToString(ahrs.getCursor()));
                hrsao.setRunId(safeToString(ahrs.getRunId()));
                hrsao.setStage(safeToString(ahrs.getStage()));
                hrsao.setStageDroppedCount(ahrs.getStageDroppedCount());
                hrsao.setStageEndTime(ahrs.getStageEndTime());
                hrsao.setStageErrorCount(ahrs.getStageErrorCount());
                hrsao.setStageNumToProcess(ahrs.getStageNumToProcess());
                hrsao.setStageProcessedCount(ahrs.getStageProcessedCount());
                hrsao.setStageSentCount(ahrs.getStageSentCount());
                hrsao.setStageStartTime(ahrs.getStageStartTime());
                hrsao.setStageUnknownCodeCount(ahrs.getStageUnknownCodeCount());
                hrsao.setState(safeToString(ahrs.getState()));
            }
            return hrsao;
        }

        static ActionObject visitor(InvitationActionObject iao, AvroInvitation ai) {
            if (iao != null && ai != null) {
                iao.setCreationDate(ai.getCreationDate());
                iao.setInvitationId(ai.getInvitationId());
                iao.setInviteeEmail(safeToString(ai.getInviteeEmail()));
                iao.setInviterEmail(safeToString(ai.getInviterEmail()));
                iao.setInviterUsername(safeToString(ai.getInvterUserName()));
                iao.setModificationDate(ai.getModificationDate());
                iao.setRevokeDate(ai.getRevokeDate());
                iao.setRevokerUsername(safeToString(ai.getRevokerUsername()));
                iao.setSentDate(ai.getSentDate());
                iao.setState(safeToString(ai.getState()));
            }
            return iao;
        }
        static ActionObject visitor(PbQuestActionObject pqao, AvroPlayboxQuest apq) {
            if (pqao != null && apq != null) {
                pqao.setIsApiRequest(apq.getIsApiRequest());
                pqao.setQuestId(safeToString(apq.getQuestId()));
                pqao.setSecret(safeToString(apq.getSecret()));
                pqao.setTaskId(safeToString(apq.getTaskId()));
            }
            return pqao;
        }

        static ActionObject visitor(SearchActionObject sao, AvroSearch as) {
            if (sao!= null && as != null) {
                sao.setKeywords(safeToString(as.getKeywords()));
                sao.setQueries(eraseListType(as.getQueries()));
                sao.setSearchFinalQuery(safeToString(as.getSearchFinalQuery()));
                sao.setSearchSelectedId(as.getSearchSelectedId());
                sao.setSearchSelectedType(safeToString(as.getSearchSelectedType()));
            }
            return sao;
        }

        static ActionObject visitor(SecurityGroupActionObject sgo, AvroSecurityGroup asg) {
            if (sgo!= null && asg!=null){
                sgo.setName(safeToString(asg.getName()));
                sgo.setCreationDate(asg.getCreationDate());
                sgo.setFederated(asg.getFederated());
                sgo.setModificationDate(asg.getModificationDate());
            }
            return sgo;
        }

        static ActionObject visitor(TileInstanceObject tio, AvroTileInstance ati) {
            if (tio != null && ati != null) {
                tio.setExtensionUUID(safeToString(ati.getExtensionUUID()));
                tio.setIsActivityStream(ati.getIsActivityStream());
                tio.setTileDefinitionName(safeToString(ati.getTileDefinitionName()));
                tio.setTileDefinitionObjectId(ati.getTileDefinitionObjectId());
                tio.setTileDefinitionObjectType(safeToString(ati.getTileDefinitionObjectType()));
                tio.setTileDefinitionVisualType(safeToString(ati.getTileDefinitionVisualType()));
            }
            return tio;
        }

        static ActionObject visitor(UserRewardBadgeActionObject urbao, AvroUserRewardBadge aurb) {
            if (urbao!= null && aurb != null) {
                urbao.setBadgeId(safeToString(aurb.getBadgeId()));
                urbao.setMessage(safeToString(aurb.getMessage()));
                urbao.setStreamEntryId(safeToString(aurb.getStreamEntryId()));
                urbao.setStreamEntryUrl(safeToString(aurb.getStreamEntryUrl()));
                urbao.setUserEmail(safeToString(aurb.getUserEmail()));
            }
            return urbao;
        }

        /* compartmentalize the reflection and invocation necessary to resolve visitor methods*/
        static final String VISITOR = "visitor";
        private static ActionObject invokeVisitor(ActionObject ao, Object eao) {
            Class me = ExtendedActionObjectHelper.class;
            Class jsonClass = ao.getClass();
            Class eaoClass = eao.getClass();
            Method visitor = null;
            try {
                visitor = me.getDeclaredMethod(VISITOR, jsonClass, eaoClass);
            } catch (NoSuchMethodException nsme) {
                for (Method method : me.getDeclaredMethods()) {
                    if (method.getName().equals(VISITOR)) {
                        if (method.getParameterCount() == 2) {
                            Class params[] = method.getParameterTypes();
                            if (params[0].isAssignableFrom(jsonClass)
                                    &&
                                    params[1].isAssignableFrom(eaoClass)) {
                                visitor = method;
                                break;
                            }
                        }
                    }
                }
            }
            if (visitor != null) {
                try {
                    return (ActionObject) visitor.invoke(null, ao, eao);
                } catch (IllegalAccessException e) {
                    //TODO: fixme, log or warn or rethrow
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    //TODO: fixme, log or warn or rethrow
                    e.printStackTrace();
                }
            }
            return null;
        }

    }

}
