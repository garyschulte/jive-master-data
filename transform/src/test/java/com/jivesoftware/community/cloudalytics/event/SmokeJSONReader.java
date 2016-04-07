package com.jivesoftware.community.cloudalytics.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jivesoftware.community.cloudalytics.event.avro.AvroEvent;
import com.jivesoftware.community.cloudalytics.event.json.EventDocument;
import org.apache.avro.Schema;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.reflect.ReflectData;
import org.apache.avro.reflect.ReflectDatumWriter;
import org.modelmapper.ModelMapper;

import java.io.File;
import java.io.IOException;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by gary.schulte on 3/16/16.
 */
public class SmokeJSONReader {
    ObjectMapper mapper = new ObjectMapper();
//    ObjectMapper avroMapper = new ObjectMapper(new AvroFactory());
//    AvroSchemaGenerator gen = new AvroSchemaGenerator();

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
            "                     \"event\": \"false\",\n" +
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
        ModelMapper modelMapper = EventModelMap.getJsonToAvroMapper();
        EventDocument jsonDoc = parseTestDoc();
        AvroEvent avroEvent = modelMapper.map(jsonDoc, AvroEvent.class);

        //Content activityContent = modelMapper.map(jsonDoc.getActivity().getActionObject(), Content.class);
        assertEquals("failed to correctly map action object", (long) jsonDoc.getActionObjectType(), (long) avroEvent.getActionObjectType());


        EventDocument postAvroJsonDoc = modelMapper.map(avroEvent, EventDocument.class);

        assertEquals("failed to correctly remap action object", (long)jsonDoc.getActionObjectType(), (long)postAvroJsonDoc.getActionObjectType());

    }
/*
    Schema createImplicitAvroSchema(Class clazz) throws JsonMappingException {

        avroMapper.acceptJsonFormatVisitor(clazz, gen);
        AvroSchema schemaWrapper = gen.getGeneratedSchema();

        Schema avroSchema = schemaWrapper.getAvroSchema();
        return avroSchema;

    }
*/

    EventDocument parseTestDoc() throws IOException {
        return mapper.readValue(testDoc, EventDocument.class);
    }

}
