package com.jivesoftware.community.cloudalytics.external;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.avro.AvroFactory;
import com.fasterxml.jackson.dataformat.avro.AvroSchema;
import com.fasterxml.jackson.dataformat.avro.schema.AvroSchemaGenerator;
import com.jivesoftware.community.cloudalytics.external.entity.ActionObject;
import com.jivesoftware.community.cloudalytics.external.entity.ActivityDestination;
import com.jivesoftware.community.cloudalytics.external.entity.EventDocument;
import com.jivesoftware.community.cloudalytics.schemata.*;
import org.apache.avro.Schema;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.reflect.ReflectData;
import org.apache.avro.reflect.ReflectDatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;
import org.junit.Test;
import org.modelmapper.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

//import com.fasterxml.jackson.dataformat.avro.schema.AvroSchemaGen1erator;
//import com.jivesoftware.community.cloudalytics.schemata.actor;
//import com.jivesoftware.community.cloudalytics.schemata.analyticsActivity;

/**
 * Created by gary.schulte on 3/16/16.
 */
public class SmokeJSONReader {

    ObjectMapper mapper = new ObjectMapper();
    ObjectMapper avroMapper = new ObjectMapper(new AvroFactory());
    AvroSchemaGenerator gen = new AvroSchemaGenerator();

    static String testDoc = "{\n" +
            "               \"name\": \"ACTIVITY_CREATE_MESSAGE\",\n" +
            "               \"timestamp\": 1413308470322,\n" +
            "               \"seqId\": 3469,\n" +
            "               \"uuid\": \"48d22120-53c9-11e4-b84e-005056a42765\",\n" +
            "               \"context\": {\n" +
            "                  \"service\": {\n" +
            "                     \"jiveUrl\": \"https://sprinklr-qa.jiveon.com\",\n" +
            "                     \"tenantId\": \"9996e4a5-2465-43b5-859b-320668052fa5\",\n" +
            "                     \"instanceType\": \"\",\n" +
            "                     \"instanceId\": \"9996e4a5-2465-43b5-859b-320668052fa5\",\n" +
            "                     \"serviceVersion\": \"8.0.0.0_8c3.1-20140914130344.a839958.release_8c3\",\n" +
            "                     \"serviceName\": \"Jive SBS\"\n" +
            "                  },\n" +
            "                  \"jvm\": {\n" +
            "                     \"jvmHome\": \"/usr/local/jive/applications/sbs/.\",\n" +
            "                     \"jvmIpAddr\": \"nic=eth1,mac=00:00:06:f4:07:05,ip=10.175.99.80;nic=eth0,mac=00:00:06:f4:07:04,ip=10.174.163.80\",\n" +
            "                     \"jvmHost\": \"thunder45731.dynphx1.jivehosted.com\",\n" +
            "                     \"jvmUid\": \"63e73ba0-4e31-11e4-b84e-005056a42765\"\n" +
            "                  },\n" +
            "                  \"web\": {\n" +
            "                     \"visible\": \"true\",\n" +
            "                     \"userAgent\": \"Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.120 Safari/537.36\",\n" +
            "                     \"requestId\": \"48ce5090-53c9-11e4-b84e-005056a42765\",\n" +
            "                     \"external\": \"false\",\n" +
            "                     \"userEmail\": \"snavaneeth@sprinklr.com\",\n" +
            "                     \"userType\": \"REGULAR\",\n" +
            "                     \"valueCase\": \"trial\",\n" +
            "                     \"username\": \"snavaneeth@sprinklr.com\",\n" +
            "                     \"anon\": \"false\",\n" +
            "                     \"sessionId\": \"2A2A44FCD66D963861744340AE805A75.node01\",\n" +
            "                     \"userId\": \"2010\",\n" +
            "                     \"partner\": \"false\",\n" +
            "                     \"federated\": \"false\",\n" +
            "                     \"flowId\": \"48ce5091-53c9-11e4-b84e-005056a42765\"\n" +
            "                  }\n" +
            "               },\n" +
            "               \"payload\": {},\n" +
            "               \"actorID\": 2010,\n" +
            "               \"actorType\": 3,\n" +
            "               \"activityType\": \"Create\",\n" +
            "               \"actionObjectId\": 1024,\n" +
            "               \"actionObjectType\": 2,\n" +
            "               \"containerId\": 2004,\n" +
            "               \"containerType\": 14,\n" +
            "               \"activity\": {\n" +
            "                  \"actor\": {\n" +
            "                     \"@class\": \".Actor\",\n" +
            "                     \"objectType\": \"user\",\n" +
            "                     \"objectId\": 2010,\n" +
            "                     \"objectHash\": \"45812381100ed77a05141db27b6c30e06d3963c0\",\n" +
            "                     \"isDataAvailable\": true,\n" +
            "                     \"extras\": {},\n" +
            "                     \"tags\": [],\n" +
            "                     \"username\": \"snavaneeth@sprinklr.com\",\n" +
            "                     \"name\": \"Soumya Navaneeth\",\n" +
            "                     \"firstName\": \"Soumya\",\n" +
            "                     \"lastName\": \"Navaneeth\",\n" +
            "                     \"email\": \"snavaneeth@sprinklr.com\",\n" +
            "                     \"creationDate\": 1413187083558,\n" +
            "                     \"modificationDate\": 1413308393103,\n" +
            "                     \"profile\": {\n" +
            "                        \"hasProfileImage\": \"true\",\n" +
            "                        \"hasAvatar\": \"true\"\n" +
            "                     },\n" +
            "                     \"enabled\": true,\n" +
            "                     \"lastLoggedIn\": 1413308393102,\n" +
            "                     \"lastProfileUpdate\": 1413187083558,\n" +
            "                     \"type\": \"REGULAR\",\n" +
            "                     \"federated\": false,\n" +
            "                     \"visible\": true,\n" +
            "                     \"status\": \"registered\",\n" +
            "                     \"url\": \"https://sprinklr-qa.jiveon.com/people/snavaneeth%40sprinklr.com\"\n" +
            "                  },\n" +
            "                  \"action\": \"Create\",\n" +
            "                  \"actionObject\": {\n" +
            "                     \"@class\": \".ActivityContent\",\n" +
            "                     \"objectType\": \"message\",\n" +
            "                     \"objectId\": 1024,\n" +
            "                     \"objectHash\": \"6397cef3b9d7593da6cba783907220ec6bf5c448\",\n" +
            "                     \"isDataAvailable\": true,\n" +
            "                     \"extras\": {\n" +
            "                        \"forumThreadId\": \"1011\",\n" +
            "                        \"isRootMessage\": false\n" +
            "                     },\n" +
            "                     \"tags\": [],\n" +
            "                     \"subject\": \"Re: nayaa question\",\n" +
            "                     \"creationDate\": 1413308470303,\n" +
            "                     \"modifiedDate\": 1413308470303,\n" +
            "                     \"author\": {\n" +
            "                        \"@class\": \".Actor\",\n" +
            "                        \"objectType\": \"user\",\n" +
            "                        \"objectId\": 2010,\n" +
            "                        \"isDataAvailable\": false,\n" +
            "                        \"extras\": {},\n" +
            "                        \"tags\": [],\n" +
            "                        \"username\": \"snavaneeth@sprinklr.com\",\n" +
            "                        \"name\": \"Soumya Navaneeth\",\n" +
            "                        \"firstName\": \"Soumya\",\n" +
            "                        \"lastName\": \"Navaneeth\",\n" +
            "                        \"email\": \"snavaneeth@sprinklr.com\",\n" +
            "                        \"creationDate\": 1413187083558,\n" +
            "                        \"modificationDate\": 1413308393103,\n" +
            "                        \"profile\": {\n" +
            "                           \"hasProfileImage\": \"true\",\n" +
            "                           \"hasAvatar\": \"true\"\n" +
            "                        },\n" +
            "                        \"enabled\": true,\n" +
            "                        \"lastLoggedIn\": 1413308393102,\n" +
            "                        \"lastProfileUpdate\": 1413187083558,\n" +
            "                        \"type\": \"REGULAR\",\n" +
            "                        \"federated\": false,\n" +
            "                        \"visible\": true,\n" +
            "                        \"status\": \"registered\",\n" +
            "                        \"url\": \"https://sprinklr-qa.jiveon.com/people/snavaneeth%40sprinklr.com\"\n" +
            "                     },\n" +
            "                     \"containerId\": 2004,\n" +
            "                     \"containerType\": \"community\",\n" +
            "                     \"isVisibleToPartner\": false,\n" +
            "                     \"status\": \"PUBLISHED\",\n" +
            "                     \"url\": \"https://sprinklr-qa.jiveon.com/message/1024#1024\",\n" +
            "                     \"fullPath\": \"/community_1/community_2004\",\n" +
            "                     \"normalizedPath\": \"/community_2004\",\n" +
            "                     \"combinedObjectTypeId\": \"2_1024\"\n" +
            "                  },\n" +
            "                  \"activityTime\": 1413308470322,\n" +
            "                  \"destination\": {\n" +
            "                     \"@class\": \".ActivityDestination\",\n" +
            "                     \"objectType\": \"community\",\n" +
            "                     \"objectId\": 2004,\n" +
            "                     \"objectHash\": \"e7bb6b160236e5e4172a395de12f9e1e231ffe4c\",\n" +
            "                     \"isDataAvailable\": true,\n" +
            "                     \"extras\": {},\n" +
            "                     \"tags\": [],\n" +
            "                     \"name\": \"QA Space 1\",\n" +
            "                     \"displayName\": \"qaspace1\",\n" +
            "                     \"description\": \" \",\n" +
            "                     \"creationDate\": 1413190939816,\n" +
            "                     \"modificationDate\": 1413190939816,\n" +
            "                     \"url\": \"https://sprinklr-qa.jiveon.com/community/qaspace1\",\n" +
            "                     \"status\": \"ACTIVE\",\n" +
            "                     \"isVisibleToPartner\": false,\n" +
            "                     \"parentId\": 1,\n" +
            "                     \"parentType\": \"community\",\n" +
            "                     \"fullPath\": \"/community_1/community_2004\",\n" +
            "                     \"normalizedPath\": \"/community_2004\",\n" +
            "                     \"combinedObjectTypeId\": \"14_2004\"\n" +
            "                  }\n" +
            "               },\n" +
            "               \"isHistoricalReplay\": false\n" +
            "            }";
    @Test
    public void smokeReadActivity() throws IOException {
        mapper.writeValueAsString(parseTestDoc());
    }

    @Test
    public void createImplicitAvroSchema() throws JsonMappingException {
        // Todo: none of this works.  jackson-avro can't handle polymorphism

        //String destination = createImplicitAvroSchema(ActivityDestination.class).toString(true);

        //String activity = createImplicitAvroSchema(ActivityContent.class).toString(true);
        //String comment = createImplicitAvroSchema(CommentContent.class).toString(true);
        //String question = createImplicitAvroSchema(QuestionActionObject.class).toString(true);
        //String task = createImplicitAvroSchema(TaskContent.class).toString(true);
        //String thread = createImplicitAvroSchema(ThreadActionObject.class).toString(true);
        //String wall = createImplicitAvroSchema(WallEntryContent.class).toString(true);

        //System.err.println(badge);
    }
/*
    @Test public void smokeJSONtoAvro() throws IOException {
        EventDocument doc = parseTestDoc();
        Actor actor = doc.getActivity().getActor();

        //Schema raw = new Schema.Parser().setValidate(true).parse(new File("/Users/gary.schulte/git/master-data/target/classes/activityContent.avsc"));
        //AvroSchema schema = new AvroSchema(raw);
        //System.err.println(avroMapper.writer(schema).writeValueAsBytes(doc.getActivity().getActionObject()));

        actor testActor = new actor();
        testActor.setClass$(actor.getType().name());
        testActor.setCreationDate(actor.getCreationDate());
        testActor.setEmail(actor.getEmail());
        testActor.setEnabled(actor.getEnabled());

        testActor.setFederated(actor.getFederated());
        testActor.setFirstName(actor.getFirstName());
        testActor.setIsDataAvailable(actor.getIsDataAvailable());
        testActor.setLastLoggedIn(actor.getLastLoggedIn());
        testActor.setLastName(actor.getLastName());
        testActor.setLastProfileUpdate(actor.getLastProfileUpdate());
        testActor.setModificationDate(actor.getModificationDate());
        testActor.setName(actor.getName());
        testActor.setObjectHash(actor.getObjectHash());
        testActor.setObjectId(actor.getObjectId());
        testActor.setObjectType(actor.getObjectType());
        testActor.setStatus(actor.getStatus().name());
        testActor.setType(actor.getType().name());
        testActor.setUrl(actor.getUrl());
        testActor.setUsername(actor.getUsername());
        testActor.setVisible(actor.getVisible());

        Map<CharSequence, Object> extras = new HashMap<>();
        if (actor.getExtras() != null) {
            extras.putAll(actor.getExtras());
        }
        testActor.setExtras(extras);

        List<CharSequence> tags = new ArrayList();
        if (actor.getTags() != null) {
            tags.addAll(actor.getTags());
        }
        testActor.setTags(tags);

        Map<CharSequence, CharSequence> profile = new HashMap<>();
        if(testActor.getProfile() != null) {
            profile.putAll(testActor.getProfile());
        }
        testActor.setProfile(profile);


        try {

            File file = new File("/tmp/actor.avro");

            // write it
            DatumWriter<actor> userDatumWriter = new SpecificDatumWriter<actor>(actor.class);
            DataFileWriter<actor> dataFileWriter = new DataFileWriter<actor>(userDatumWriter);
            dataFileWriter.create(testActor.getSchema(), file);
            dataFileWriter.append(testActor);
            dataFileWriter.close();

            // read it
            DatumReader<actor> userDatumReader = new SpecificDatumReader<actor>(actor.class);
            DataFileReader<actor> dataFileReader = new DataFileReader<actor>(file, userDatumReader);
            actor user = null;
            while (dataFileReader.hasNext()) {
                user = dataFileReader.next(user);
                System.out.println(user);
            }
        } finally {

        }
    }
*/

/*
    @Test
    public void testDirectSerialization() throws IOException {
        Schema schema = new Schema.Parser().parse(new File("activityContent.avsc"));
        EventDocument doc = parseTestDoc();
        DatumWriter<analyticsActivity> writer = new ReflectDatumWriter<>(analyticsActivity.class);
        DataFileWriter<AnalyticsActivity> out = new DataFileWriter<>(writer)
                .create(schema, new File("/tmp/hopeful.bin"))
                .append(doc.getActivity());
    }

*/


    @Test
    public void testJacksonAvroReflectWriter() throws IOException {
        EventDocument doc = parseTestDoc();

        Schema eventSchema = ReflectData.AllowNull.get()
                .getSchema(EventDocument.class);
        DatumWriter<EventDocument> writer = new ReflectDatumWriter<>(EventDocument.class);
        DataFileWriter<EventDocument> out = new DataFileWriter<>(writer);
        out.create(eventSchema, new File("/tmp/reflect.bin"));
        out.append(doc);
        out.close();


    }

    @Test
    public void testModelMapper() throws IOException {
        ModelMapper modelMapper = new ModelMapper();
//        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.addMappings(new ActionMap());



        EventDocument jsonDoc = parseTestDoc();
        Event avroEvent = modelMapper.map(jsonDoc, Event.class);
        Content activityContent = modelMapper.map(jsonDoc.getActivity().getActionObject(), Content.class);
        assertEquals("failed to correctly map action object", (long)jsonDoc.getActionObjectType(), (long)avroEvent.getActionObjectType());


    }

    Schema createImplicitAvroSchema(Class clazz) throws JsonMappingException {

        avroMapper.acceptJsonFormatVisitor(clazz, gen);
        AvroSchema schemaWrapper = gen.getGeneratedSchema();

        Schema avroSchema = schemaWrapper.getAvroSchema();
        return avroSchema;

    }

    EventDocument parseTestDoc() throws IOException {
        return mapper.readValue(testDoc, EventDocument.class);
    }

    public static class ActionMap extends PropertyMap<ActionObject, Action> {

        @Override
        protected void configure() {
            map().setObjectHash(source.getObjectHash());
            map().setObjectId(source.getObjectId());
            map().setObjectType(source.getObjectType());
            map().setIsDataAvailable(source.getIsDataAvailable());
            map().setClass$(source.getClassName());
            map(source.getTags()).setTags(null);
            map(source.getExtras()).setExtras(null);

            with(getActionProvider()).map().setExtendedActionObject(source.getShallowClone());

        }
    }

    public static Provider<Object> getActionProvider() {
        return new Provider<Object>(){
            @Override
            public Object get(ProvisionRequest<Object> provisionRequest) {

                // I hate myself a little bit for this.
                String objClass = ((ActionObject) provisionRequest.getSource()).getObjectType();
                System.err.println("objClass: " + objClass);
                switch (objClass) {
                    case "ActivityContent" : return new Content();
                    case "ActivityDestination" : return new Destination();
                    case "Actor" : return new Actor();
                    default : return null;
                }
            }
        };

    }

}
