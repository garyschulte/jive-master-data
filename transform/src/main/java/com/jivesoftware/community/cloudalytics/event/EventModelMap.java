package com.jivesoftware.community.cloudalytics.event;

import com.jivesoftware.community.cloudalytics.event.avro.*;
import com.jivesoftware.community.cloudalytics.event.json.ActionObject;
import com.jivesoftware.community.cloudalytics.event.json.ActivityContent;
import com.jivesoftware.community.cloudalytics.event.json.ActivityDestination;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.Provider;

/**
 * Created by gary.schulte on 4/1/16.
 */
public class EventModelMap {

    // TODO: setup proper singleton!!
    private static ModelMapper modelMapper;

    public static ModelMapper getJsonToAvroMapper() {
        modelMapper = new ModelMapper();
        //modelMapper.getConfiguration().setAmbiguityIgnored(true);

        // add a mapping for extended action union object
        modelMapper.addMappings(new ActionObjectMap());


        // use a provider to instantiate the destination object
        //Provider<Object> delegatingProvider = new ExtendedActionProvider();
        //modelMapper.getConfiguration().setProvider(delegatingProvider);


        // explicitly define a converter for ActionObject to Avro Union type


        return modelMapper;

    }

    public static ModelMapper getAvroToJsonMapper() {

        return null;
    }

    public static class ActionObjectMap extends PropertyMap<ActionObject, AvroAction> {

        @Override
        protected void configure() {
            //
            //map(source).setExtendedActionObject(null);

            // explicitly define a converter for ActionObject to Avro Union type
            using(new ExtendedActionConverter()).map().setExtendedActionObject(source.getExtendedAction());
        }
    }

    public static class ExtendedActionConverter extends AbstractConverter<ActionObject, Object> {

        @Override
        protected Object convert(ActionObject source) {
            Class eao = null;
            Object obj = null;

            switch (source.getClass().getSimpleName()) {
                    case "ActivityContent" : eao = AvroContent.class; break;
                    case "CommentContent" : eao = AvroComment.class; break;
                    case "QuestionActionObject" : eao = AvroQuestion.class; break;
                    case "TaskContentObject" : eao = AvroTask.class; break;
                    case "ThreadActionObject" : eao = AvroThread.class; break;
                    case "WallEntryContent" : eao = AvroWallEntry.class; break;
                    case "ActivityDestination" : eao = AvroDestination.class; break;
                    case "Actor" : eao = AvroActor.class; break;
                    case "ActorRelation" : eao = AvroActorRelation.class; break;
                    case "ActorRelationList" : eao = AvroActorRelationList.class; break;
                    case "AppLoadedObject" : eao = AvroAppLoad.class; break;
                    case "AttachmentContent" : eao = AvroAttachment.class; break;
                    case "ExStorageFileObject" : eao = AvroExStorageFile.class; break;
                    case "ExtStorageAttachmentObject" : eao = AvroExStorageAttachment.class; break;
                    case "ExtensionObject" : eao = AvroExtension.class; break;
                    case "HistoricalReplayStatisticsActionObject" : eao = AvroHistoricalReplayStatistics.class; break;
                    case "InvitationActionObject" : eao = AvroInvitation.class; break;
                    case "PbQuestActionObject" : eao = AvroPlayboxQuest.class; break;
                    case "SearchActionObject" : eao = AvroSearch.class; break;
                    case "SecurityGroupActionObject" : eao = AvroSecurityGroup.class; break;
                    case "TagActionObject" : break;
                    case "TileInstanceObject" : eao = AvroTileInstance.class; break;
                    case "UserRewardBadgeActionObject" : eao = AvroUserRewardBadge.class; break;
                    default : ;
            }

            if (eao != null) {
                obj = modelMapper.map(source, eao);
            }

            return obj;
        }
    }



/*
    public static class ExtendedActionProvider implements Provider<Object> {

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
    }
*/

}
