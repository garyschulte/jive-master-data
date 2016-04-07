package com.jivesoftware.community.cloudalytics.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jivesoftware.community.cloudalytics.event.avro.*;
import com.jivesoftware.community.cloudalytics.event.json.*;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.Provider;
import org.modelmapper.convention.MatchingStrategies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gary.schulte on 4/1/16.
 */
public class EventModelMap {

    private static ModelMapper
            jsonToAvroModelMapper = null, avroToJsonModelMapper = null, helperModelMapper = null;



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
                                // these types require additional care
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

                                //TODO: fixme, special case conversion
                                if (obj instanceof AvroContent) {
                                    ((AvroContent) obj).setModificationDate(((ActivityContent)source).getModifiedDate());
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

    public static ModelMapper getAvroToJsonMapper() {
        if (avroToJsonModelMapper == null) {
            avroToJsonModelMapper = new ModelMapper();
            //TODO: remove ambiguity ignored if possible
            //avroToJsonModelMapper.getConfiguration().setAmbiguityIgnored(true);


            Provider<ActionObject> delegatingProvider = new Provider<ActionObject>() {
                public ActionObject get(ProvisionRequest<ActionObject> request) {
                    ActionObject ao = null;

                    if (request.getSource() instanceof AvroAction) {
                        AvroAction source = (AvroAction) request.getSource();
                        String sourceObjType = source.getClass$().toString();
                        if (sourceObjType != null) {
                            try {
                                //TODO: so dirty
                                Class clazz = Class.forName(ActionObject.class.getPackage().getName() + "." + sourceObjType);
                                //ao = (ActionObject) clazz.newInstance();

                                ao = (ActionObject) getHelperMapper().map(source.getExtendedActionObject(), clazz);

                                // TODO: fixme, special case bs here.  ugly ugly.
                                switch (sourceObjType) {
                                    case "ActivityContent" :
                                        ((ActivityContent)ao).setModifiedDate(((AvroContent)source.getExtendedActionObject()).getModificationDate());
                                        break;
                                }

                            } catch (ClassNotFoundException e) {
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


            avroToJsonModelMapper.addMappings(new PropertyMap<AvroActivity, AnalyticsActivity>() {
                @Override
                protected void configure() {

                    // explicitly define a converter for ActionObject to Avro Union Object type
                    AbstractConverter actionObjectConverter = new AbstractConverter<AvroAction, ActionObject>() {
                        @Override
                        protected ActionObject convert(AvroAction source) {
                            ActionObject ao = null;

                            if (source instanceof AvroAction) {
                                String sourceObjType = ((AvroAction) source).getClass$().toString();
                                if (sourceObjType != null) {
                                    try {
                                        Class clazz = Class.forName(ActionObject.class.getPackage().getName() + "." + sourceObjType);
                                        ao = (ActionObject) getHelperMapper().map(source.getExtendedActionObject(), clazz);
                                        ao.setObjectId(source.getObjectId());
                                        ao.setIsDataAvailable(source.getIsDataAvailable());
                                        ao.setObjectHash(source.getObjectHash().toString());
                                        ao.setObjectType(source.getObjectType().toString());
/*
                                        ao.setTags(source.getTags());
                                        ao.setExtras(source.getExtras());
*/
                                    } catch (ClassNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            return ao;
                        }
                    };


//                    using(actionObjectConverter).map(source.getActionObject()).setActionObject(null);
//                    map(source.getActivity().getActionObject().getExtendedActionObject()).setActivity
                }
            });


        }

        return avroToJsonModelMapper;
    }

    static <D extends ActionObject> ModelMapper getHelperMapper() {
        if (helperModelMapper == null) {
            helperModelMapper = new ModelMapper();
            //helperModelMapper.getConfiguration().setFieldMatchingEnabled(true);
            helperModelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            helperModelMapper.getConfiguration().setAmbiguityIgnored(true);
            helperModelMapper.addMappings(new PropertyMap<AvroAction, D>() {
                @Override
                protected void configure() {
                    skip().setObjectId(null);
                    skip().setObjectType(null);
                    skip().setObjectHash(null);
                    skip().setIsDataAvailable(true);
                    skip().setExtras(null);
                    skip().setTags(null);
                }
            });
        }
        return helperModelMapper;
    }

}
