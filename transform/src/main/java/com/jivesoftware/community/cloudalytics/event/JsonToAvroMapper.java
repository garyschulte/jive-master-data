package com.jivesoftware.community.cloudalytics.event;

import com.jivesoftware.community.cloudalytics.event.avro.*;
import com.jivesoftware.community.cloudalytics.event.json.*;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.ArrayList;

/**
 * static class which builds/returns singleton configured instance of ModelMapper that
 * can map the polymorphic json format to composed avro objects.
 */
public class JsonToAvroMapper {

    private static ModelMapper jsonToAvroModelMapper = null;

    public static <D> D map(Object jsonSource, Class<D> avroDestClass) {
        return getJsonToAvroMapper().map(jsonSource, avroDestClass);
    }

    private static ModelMapper getJsonToAvroMapper() {
        if (jsonToAvroModelMapper == null) {
            jsonToAvroModelMapper = new ModelMapper();
            //jsonToAvroModelMapper.getConfiguration().setAmbiguityIgnored(true);

            // add a mapping for extended action union object
            jsonToAvroModelMapper.addMappings(new PropertyMap<ActionObject, AvroAction>() {
                @Override
                protected void configure() {

                    // explicitly define a converter for ActionObject to Avro Union Object type
                    AbstractConverter actionObjectConverter = new AbstractConverter<ActionObject, Object>() {
                        @Override
                        protected Object convert(ActionObject source) {
                            Class eao = null;
                            Object obj = null;

                            switch (source.getClass().getSimpleName()) {

                                case "ActivityDestination": eao = AvroDestination.class; break;
                                case "Actor": eao = AvroActor.class; break;
                                case "ActorRelation": eao = AvroActorRelation.class; break;
                                case "ActorRelationList": eao = AvroActorRelationList.class; break;
                                case "AppLoadedObject": eao = AvroAppLoad.class; break;
                                case "AttachmentContent": eao = AvroAttachment.class; break;
                                case "ExStorageFileObject": eao = AvroExStorageFile.class; break;
                                case "ExtStorageAttachmentObject": eao = AvroExStorageAttachment.class; break;
                                case "ExtensionObject": eao = AvroExtension.class; break;
                                case "HistoricalReplayStatisticsActionObject": eao = AvroHistoricalReplayStatistics.class; break;
                                case "InvitationActionObject": eao = AvroInvitation.class; break;
                                case "PbQuestActionObject": eao = AvroPlayboxQuest.class; break;
                                case "SearchActionObject": eao = AvroSearch.class; break;
                                case "SecurityGroupActionObject": eao = AvroSecurityGroup.class; break;
                                case "TileInstanceObject": eao = AvroTileInstance.class; break;
                                case "UserRewardBadgeActionObject": eao = AvroUserRewardBadge.class; break;

                                // no extended attributes for tag action object
                                case "TagActionObject": break;

                                // these types require additional care
                                case "ActivityContent":
                                case "CommentContent":
                                case "QuestionActionObject":
                                case "TaskContent":
                                case "ThreadActionObject":
                                case "WallEntryContent":
                                    eao = AvroContent.class;
                                    break;

                                default: ;
                            }

                            if (eao != null) {
                                obj = jsonToAvroModelMapper.map(source, eao);

                                // map/copy elements of subclasses of ActivityContent
                                if (source instanceof ActivityContent) {
                                    visitContentElements((AvroContent) obj, (ActivityContent) source);
                                }
                            }

                            return obj;
                        }
                    };

                    // setup the typemap for the properties ModelMapper has difficulty with
                    using(actionObjectConverter).map().setExtendedActionObject(source.getExtendedAction());
                    map().setClass$(source.getSimpleClassName());
                }
            });
        }

        return jsonToAvroModelMapper;
    }


    /* brute force match these few elements rather than build a new modelmapper object mapping hierarchy */
    private static void visitContentElements(AvroContent obj, ActivityContent source) {

        obj.setModificationDate(((ActivityContent) source).getModifiedDate());

        if (source instanceof WallEntryContent) {
            AvroWallEntry awe = new AvroWallEntry();
            awe.setMessageType(((WallEntryContent)source).getMessageType());
            awe.setNumRecipients(((WallEntryContent) source).getNumRecipients());
            awe.setRecipientIds(new ArrayList(((WallEntryContent) source).getRecipientIds()));
            obj.setContentElements(awe);

        } else if (source instanceof ThreadActionObject) {
            AvroThread at = new AvroThread();
            at.setIsQuestion(((ThreadActionObject)source).isQuestion());
            obj.setContentElements(at);

        } else if (source instanceof TaskContent) {
            AvroTask at = new AvroTask();
            at.setCompleted(((TaskContent) source).isCompleted());
            at.setDueDate(((TaskContent) source).getDueDate());

            // rely on model mapper to map owner and parent task elements
            Actor owner = ((TaskContent)source).getOwner();
            if (owner != null) {
                at.setOwner(jsonToAvroModelMapper.map(owner, AvroActor.class));
            }
            TaskContent parent = ((TaskContent)source).getParentTask();
            if (parent != null) {
                at.setParentTask(jsonToAvroModelMapper.map(parent, AvroParentTask.class));
            }
            obj.setContentElements(at);

        } else if (source instanceof QuestionActionObject) {
            AvroQuestion aq = new AvroQuestion();
            aq.setAssumedResolved(((QuestionActionObject) source).isAssumedResolved());
            aq.setIsQuestion(((QuestionActionObject) source).isQuestion());
            aq.setNumHelpfulAnswers(((QuestionActionObject)source).getNumHelpfulAnswers());
            aq.setNumReplies(((QuestionActionObject)source).getNumReplies());
            aq.setOpen(((QuestionActionObject)source).isOpen());
            aq.setQuestionCreateDate(((QuestionActionObject)source).getQuestionCreationDate());
            aq.setQuestionStatus(((QuestionActionObject)source).getQuestionStatus());
            aq.setResolutionDate(((QuestionActionObject)source).getResolutionDate());
            aq.setResolved(((QuestionActionObject)source).isResolved());
            obj.setContentElements(aq);
        } else if (source instanceof CommentContent) {
            AvroComment ac = new AvroComment();
            ac.setParentCommentId(((CommentContent)source).getParentCommentId());

            // rely on model mapper to resolve parent comment
            CommentContent parentComment = ((CommentContent) source).getParentComment();
            if (parentComment != null) {
                ac.setParentComment(jsonToAvroModelMapper.map(parentComment, AvroParentComment.class));
            }
            obj.setContentElements(ac);
        }


    }

}
