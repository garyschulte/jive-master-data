package com.jivesoftware.community.cloudalytics.event;

import com.jivesoftware.community.cloudalytics.event.avro.*;
import com.jivesoftware.community.cloudalytics.event.json.ActionObject;
import com.jivesoftware.community.cloudalytics.event.json.TagActionObject;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.Provider;

/**
 * Created by gary.schulte on 4/1/16.
 */
public class EventModelMap {

    private static ModelMapper
            jsonToAvroModelMapper = null, avroToJsonModelMapper = null;


    public static ModelMapper getJsonToAvroMapper() {
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
                                case "ActivityContent": eao = AvroContent.class; break;
                                case "CommentContent": eao = AvroComment.class; break;
                                case "QuestionActionObject": eao = AvroQuestion.class; break;
                                case "TaskContentObject": eao = AvroTask.class; break;
                                case "ThreadActionObject": eao = AvroThread.class; break;
                                case "WallEntryContent": eao = AvroWallEntry.class; break;
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
                                case "TagActionObject": break;
                                case "TileInstanceObject": eao = AvroTileInstance.class; break;
                                case "UserRewardBadgeActionObject": eao = AvroUserRewardBadge.class; break;
                                default: ;
                            }

                            if (eao != null) {
                                obj = jsonToAvroModelMapper.map(source, eao);
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

    public static ModelMapper getAvroToJsonMapper() {
        if (avroToJsonModelMapper == null) {
            avroToJsonModelMapper = new ModelMapper();
            //TODO: remove ambiguity ignored if possible
            avroToJsonModelMapper.getConfiguration().setAmbiguityIgnored(true);
            Provider<ActionObject> delegatingProvider = new Provider<ActionObject>() {
                public ActionObject get(ProvisionRequest<ActionObject> request) {
                    ActionObject ao = null;

                    if (request.getSource() instanceof AvroAction) {
                        String sourceObjType = ((AvroAction) request.getSource()).getClass$().toString();
                        if (sourceObjType != null) {
                            try {
                                //TODO: so dirty
                                Class clazz = Class.forName(ActionObject.class.getPackage().getName() + "." + sourceObjType);
                                ao = (ActionObject) clazz.newInstance();
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            } catch (InstantiationException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        // let modelmapper do the construction if requested object is not ActionObject
                    }

                    return ao;
                }
            };

            avroToJsonModelMapper.getConfiguration().setProvider(delegatingProvider);
        }

        return avroToJsonModelMapper;

    }
}