package com.jivesoftware.community.cloudalytics.event;

import com.jivesoftware.community.cloudalytics.event.avro.*;
import com.jivesoftware.community.cloudalytics.event.json.ActionObject;
import com.jivesoftware.community.cloudalytics.event.json.ActivityContent;
import com.jivesoftware.community.cloudalytics.event.json.ActivityDestination;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;

/**
 * Created by gary.schulte on 4/1/16.
 */
public class EventModelMap {

    public static ModelMapper getJsonToAvroMapper() {
        ModelMapper modelMapper = new ModelMapper();
        //modelMapper.getConfiguration().setAmbiguityIgnored(true);
        //modelMapper.addMappings(new ActionMap());

        Provider<Object> delegatingProvider = new Provider<Object>() {
            public Object get(ProvisionRequest<Object> request) {

                if (request.getRequestedType().equals(AvroAction.class)) {
                    AvroAction ao = new AvroAction();
                    Object eao = null;
                    String sourceObjType = request.getSource().getClass().getSimpleName();
                    switch (sourceObjType) {
                        case "ActivityContent" : eao = new AvroContent(); break;
                        case "CommentContent" : eao = new AvroComment(); break;
                        case "QuestionActionObject" : eao = new AvroQuestion(); break;
                        case "TaskContentObject" : eao = new AvroTask(); break;
                        case "ThreadActionObject" : eao = new AvroThread(); break;
                        case "WallEntryContent" : eao = new AvroWallEntry(); break;
                        case "ActivityDestination" : eao = new AvroDestination(); break;
                        case "Actor" : eao = new AvroActor(); break;
                        case "ActorRelation" : eao = new AvroActorRelation(); break;
                        case "ActorRelationList" : eao = new AvroActorRelationList(); break;
                        case "AppLoadedObject" : eao = new AvroAppLoad(); break;
                        case "AttachmentContent" : eao = new AvroAttachment(); break;
                        case "ExStorageFileObject" : eao = new AvroExStorageFile(); break;
                        case "ExtStorageAttachmentObject" : eao = new AvroExStorageAttachment(); break;
                        case "ExtensionObject" : eao = new AvroExtension(); break;
                        case "HistoricalReplayStatisticsActionObject" : eao = new AvroHistoricalReplayStatistics(); break;
                        case "InvitationActionObject" : eao = new AvroInvitation(); break;
                        case "PbQuestActionObject" : eao = new AvroPlayboxQuest(); break;
                        case "SearchActionObject" : eao = new AvroSearch(); break;
                        case "SecurityGroupActionObject" : eao = new AvroSecurityGroup(); break;
                        case "TagActionObject" : break;
                        case "TileInstanceObject" : eao = new AvroTileInstance(); break;
                        case "UserRewardBadgeActionObject" : eao = new AvroUserRewardBadge(); break;
                        default : ;
                    }
                    ao.setExtendedActionObject(eao);
                    return ao;
                }

                // let modelmapper do the construction if requested object is not ActionObject
                return null;
            }
        };


        modelMapper.getConfiguration().setProvider(delegatingProvider);
        return modelMapper;

    }

    public static ModelMapper getAvroToJsonMapper() {

        return null;
    }
}
