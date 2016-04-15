package com.jivesoftware.community.cloudalytics.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jivesoftware.community.cloudalytics.event.avro.AvroEvent;
import com.jivesoftware.community.cloudalytics.event.jsonschema.EventDocument;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecord;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

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
            "                     \"isVisibleToPartner\": true,\n" +
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
        mapper.writeValueAsString(parseTestDoc(testDoc));
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
    public void testModelMapper() throws IOException {
        testBidirectional(testDoc, new File("/tmp/testDoc.avro"));
    }

    @Test
    public void testParentCommentEdges() throws IOException {
        testBidirectional(nestedParentCommentsDoc);
    }

    @Test
    public void testParentTaskEdges() throws IOException {
        testBidirectional(nestedParentTaskDoc);
    }

    public void testBidirectional(String doc) throws IOException {
        testBidirectional(doc, null);
    }
    public void testBidirectional(String doc, File file) throws IOException {
        EventDocument nested = parseTestDoc(doc);
        AvroEvent avroEvent = JsonToAvroMapper.map(nested, AvroEvent.class);
        EventDocument postAvroJson = AvroToJsonMapper.map(avroEvent, EventDocument.class);
        assertEquals("failed to correctly map action object", (long) nested.getActionObjectType(), (long) avroEvent.getActionObjectType());
        if (file != null) {
            writeAvroDoc(avroEvent.getActivity().getActor(), file);
            //writeAvroDoc(avroEvent, file);
        }
    }

    EventDocument parseTestDoc(String doc) throws IOException {
        return mapper.readValue(doc, EventDocument.class);
    }

    public void writeAvroDoc(SpecificRecord avroDoc, File file) throws IOException {

        DatumWriter writer = new SpecificDatumWriter<>();
        DataFileWriter out = new DataFileWriter<>(writer);
        out.create(avroDoc.getSchema(), file);
        out.append(avroDoc);
        out.close();

    }

        String nestedParentCommentsDoc = "{\n" +
            "               \"name\": \"ACTIVITY_SEND_EMAIL\",\n" +
            "               \"timestamp\": 1413212947455,\n" +
            "               \"seqId\": 15343,\n" +
            "               \"uuid\": \"e0c158f0-52ea-11e4-948c-005056a28ba3\",\n" +
            "               \"context\": {\n" +
            "                  \"service\": {\n" +
            "                     \"jiveUrl\": \"https://www.mbgreenhouse.com\",\n" +
            "                     \"tenantId\": \"326e730b-c374-4f8b-afe0-bdaa1d145397\",\n" +
            "                     \"instanceType\": \"\",\n" +
            "                     \"instanceId\": \"326e730b-c374-4f8b-afe0-bdaa1d145397\",\n" +
            "                     \"serviceVersion\": \"7.0.2.0_-Custom\",\n" +
            "                     \"serviceName\": \"Jive SBS\"\n" +
            "                  },\n" +
            "                  \"jvm\": {\n" +
            "                     \"jvmHome\": \"/mnt/jive_persist/jivehome/applications/millwardbrown-v7/.\",\n" +
            "                     \"jvmIpAddr\": \"nic=eth1,mac=00:00:06:f2:fb:f3,ip=10.167.130.139;nic=eth0,mac=00:00:06:f2:fb:f2,ip=10.167.2.139\",\n" +
            "                     \"jvmHost\": \"millwardbrown-v7-wa02.m2phx1.jivehosted.com\",\n" +
            "                     \"jvmUid\": \"0255c7e0-5105-11e4-948c-005056a28ba3\"\n" +
            "                  }\n" +
            "               },\n" +
            "               \"payload\": {},\n" +
            "               \"actorID\": -9223372036854775000,\n" +
            "               \"actorType\": 3,\n" +
            "               \"activityType\": \"Send\",\n" +
            "               \"actionObjectId\": 33561,\n" +
            "               \"actionObjectType\": 105,\n" +
            "               \"containerId\": 1451,\n" +
            "               \"containerType\": 700,\n" +
            "               \"activity\": {\n" +
            "                  \"actor\": {\n" +
            "                     \"@class\": \".Actor\",\n" +
            "                     \"objectType\": \"user\",\n" +
            "                     \"objectId\": -9223372036854775000,\n" +
            "                     \"objectHash\": \"ae838698dab47dea3ed758e577a4d84e477d2b64\",\n" +
            "                     \"isDataAvailable\": true,\n" +
            "                     \"extras\": {},\n" +
            "                     \"tags\": [],\n" +
            "                     \"username\": \"SYSTEM\",\n" +
            "                     \"name\": \"SYSTEM\",\n" +
            "                     \"firstName\": \"SYSTEM\",\n" +
            "                     \"lastName\": \"SYSTEM\",\n" +
            "                     \"creationDate\": -1,\n" +
            "                     \"modificationDate\": -1,\n" +
            "                     \"profile\": {\n" +
            "                        \"hasAvatar\": \"true\"\n" +
            "                     },\n" +
            "                     \"enabled\": true,\n" +
            "                     \"lastLoggedIn\": -1,\n" +
            "                     \"lastProfileUpdate\": -1,\n" +
            "                     \"type\": \"REGULAR\",\n" +
            "                     \"federated\": false,\n" +
            "                     \"visible\": false,\n" +
            "                     \"status\": \"none\",\n" +
            "                     \"url\": \"https://www.mbgreenhouse.com/people/SYSTEM\"\n" +
            "                  },\n" +
            "                  \"action\": \"Send\",\n" +
            "                  \"actionObject\": {\n" +
            "                     \"@class\": \".CommentContent\",\n" +
            "                     \"objectType\": \"comment\",\n" +
            "                     \"objectId\": 33561,\n" +
            "                     \"objectHash\": \"88491877291af8a178cf33a35100c3316ec5ac6a\",\n" +
            "                     \"isDataAvailable\": true,\n" +
            "                     \"extras\": {\n" +
            "                        \"emailCombinedParentObjectTypeId\": \"102_61602\",\n" +
            "                        \"emailSender\": \"millwardbrown@millwardbrown-int.hosted.jivesoftware.com\",\n" +
            "                        \"emailRecipients\": \"EmailAddress{email='gloria.perez@mercaplan.com', name='Gloria Perez'}\"\n" +
            "                     },\n" +
            "                     \"tags\": [],\n" +
            "                     \"subject\": \"Individuals_Internet_2000-2013.xlsx\",\n" +
            "                     \"creationDate\": 1413212944177,\n" +
            "                     \"modifiedDate\": 1413212944177,\n" +
            "                     \"authorId\": 10119,\n" +
            "                     \"containerId\": 1451,\n" +
            "                     \"containerType\": \"socialgroup\",\n" +
            "                     \"isVisibleToPartner\": false,\n" +
            "                     \"status\": \"PUBLISHED\",\n" +
            "                     \"url\": \"https://www.mbgreenhouse.com/docs/DOC-61602#comment-33561\",\n" +
            "                     \"fullPath\": \"/systemcontainer_17/socialgroup_1451\",\n" +
            "                     \"normalizedPath\": \"/socialgroup_1451\",\n" +
            "                     \"parentCommentId\": 33590,\n" +
            "                     \"parentComment\": {\n" +
            "                        \"@class\": \".CommentContent\",\n" +
            "                        \"objectType\": \"comment\",\n" +
            "                        \"objectId\": 33590,\n" +
            "                        \"objectHash\": \"5daab549b7dc42d09181c0f05495e1fc919761b5\",\n" +
            "                        \"isDataAvailable\": true,\n" +
            "                        \"extras\": {},\n" +
            "                        \"tags\": [],\n" +
            "                        \"subject\": \"Individuals_Internet_2000-2013.xlsx\",\n" +
            "                        \"creationDate\": 1413212310752,\n" +
            "                        \"modifiedDate\": 1413212310752,\n" +
            "                        \"authorId\": 10102,\n" +
            "                        \"containerId\": 1451,\n" +
            "                        \"containerType\": \"socialgroup\",\n" +
            "                        \"isVisibleToPartner\": false,\n" +
            "                        \"status\": \"PUBLISHED\",\n" +
            "                        \"url\": \"https://www.mbgreenhouse.com/docs/DOC-61602#comment-33590\",\n" +
            "                        \"fullPath\": \"/systemcontainer_17/socialgroup_1451\",\n" +
            "                        \"normalizedPath\": \"/socialgroup_1451\",\n" +
            "                        \"parentCommentId\": 33573,\n" +
            "                        \"parentComment\": {\n" +
            "                           \"@class\": \".CommentContent\",\n" +
            "                           \"objectType\": \"comment\",\n" +
            "                           \"objectId\": 33573,\n" +
            "                           \"objectHash\": \"bf7c8e5bd781bb2dc7b2dbaaa7a9dcafbfbbc9f5\",\n" +
            "                           \"isDataAvailable\": true,\n" +
            "                           \"extras\": {},\n" +
            "                           \"tags\": [],\n" +
            "                           \"subject\": \"Individuals_Internet_2000-2013.xlsx\",\n" +
            "                           \"creationDate\": 1413212070519,\n" +
            "                           \"modifiedDate\": 1413212070519,\n" +
            "                           \"authorId\": 10119,\n" +
            "                           \"containerId\": 1451,\n" +
            "                           \"containerType\": \"socialgroup\",\n" +
            "                           \"isVisibleToPartner\": false,\n" +
            "                           \"status\": \"PUBLISHED\",\n" +
            "                           \"url\": \"https://www.mbgreenhouse.com/docs/DOC-61602#comment-33573\",\n" +
            "                           \"fullPath\": \"/systemcontainer_17/socialgroup_1451\",\n" +
            "                           \"normalizedPath\": \"/socialgroup_1451\",\n" +
            "                           \"parentCommentId\": -1\n" +
            "                        }\n" +
            "                     },\n" +
            "                     \"combinedObjectTypeId\": \"105_33561\"\n" +
            "                  },\n" +
            "                  \"activityTime\": 1413212947455,\n" +
            "                  \"destination\": {\n" +
            "                     \"@class\": \".ActivityDestination\",\n" +
            "                     \"objectType\": \"socialgroup\",\n" +
            "                     \"objectId\": 1451,\n" +
            "                     \"objectHash\": \"470a0d05dca9a8da9682590989a708238a4fdd78\",\n" +
            "                     \"isDataAvailable\": true,\n" +
            "                     \"extras\": {},\n" +
            "                     \"tags\": [],\n" +
            "                     \"name\": \"Mercaplan Millward Brown Central America & Caribbean\",\n" +
            "                     \"displayName\": \"mercaplan\",\n" +
            "                     \"description\": \"Equipo MB de Centroamérica y el Caribe\",\n" +
            "                     \"creationDate\": 1330351863329,\n" +
            "                     \"modificationDate\": 1412724187074,\n" +
            "                     \"url\": \"https://www.mbgreenhouse.com/groups/mercaplan\",\n" +
            "                     \"status\": \"ACTIVE\",\n" +
            "                     \"isVisibleToPartner\": false,\n" +
            "                     \"parentId\": 17,\n" +
            "                     \"parentType\": \"systemcontainer\",\n" +
            "                     \"fullPath\": \"/systemcontainer_17/socialgroup_1451\",\n" +
            "                     \"normalizedPath\": \"/socialgroup_1451\",\n" +
            "                     \"combinedObjectTypeId\": \"700_1451\"\n" +
            "                  }\n" +
            "               },\n" +
            "               \"isHistoricalReplay\": false\n" +
            "            }\n" +
            "         }";


    String nestedParentTaskDoc = "{\n" +
            "               \"name\": \"ACTIVITY_CREATE_TASK\",\n" +
            "               \"timestamp\": 1309526035860,\n" +
            "               \"seqId\": 42863833,\n" +
            "               \"uuid\": \"3d0a0410-ec8c-11e3-b5d3-0050568b2072\",\n" +
            "               \"context\": {\n" +
            "                  \"service\": {\n" +
            "                     \"jiveUrl\": \"https://vox.sapient.com\",\n" +
            "                     \"tenantId\": \"2a760b3e-54a5-418b-9dd9-555cd32dea45\",\n" +
            "                     \"instanceType\": \"\",\n" +
            "                     \"instanceId\": \"2a760b3e-54a5-418b-9dd9-555cd32dea45\",\n" +
            "                     \"serviceVersion\": \"7.0.0.1_-201211221138.72eb13c.release_5_0_5.b1\",\n" +
            "                     \"serviceName\": \"Jive SBS\"\n" +
            "                  },\n" +
            "                  \"jvm\": {\n" +
            "                     \"jvmHome\": \"/mnt/jive_persist/jivehome/applications/sapient-corp-v7/.\",\n" +
            "                     \"jvmIpAddr\": \"nic=eth1,mac=00:00:06:fb:00:02,ip=10.172.194.106;nic=eth0,mac=00:00:06:fb:00:01,ip=10.172.2.106\",\n" +
            "                     \"jvmHost\": \"sapient-corp-v7-wa01.dynphx1.jivehosted.com\",\n" +
            "                     \"jvmUid\": \"2a443390-eb84-11e3-b5d3-0050568b2072\"\n" +
            "                  }\n" +
            "               },\n" +
            "               \"payload\": {},\n" +
            "               \"actorID\": 4786,\n" +
            "               \"actorType\": 3,\n" +
            "               \"activityType\": \"Create\",\n" +
            "               \"actionObjectId\": 1439,\n" +
            "               \"actionObjectType\": 602,\n" +
            "               \"containerId\": 1172,\n" +
            "               \"containerType\": 600,\n" +
            "               \"activity\": {\n" +
            "                  \"actor\": {\n" +
            "                     \"@class\": \".Actor\",\n" +
            "                     \"objectType\": \"user\",\n" +
            "                     \"objectId\": 4786,\n" +
            "                     \"isDataAvailable\": true,\n" +
            "                     \"extras\": {},\n" +
            "                     \"tags\": [],\n" +
            "                     \"username\": \"kfried\",\n" +
            "                     \"name\": \"Kirk Friedenberger\",\n" +
            "                     \"firstName\": \"Kirk\",\n" +
            "                     \"lastName\": \"Friedenberger\",\n" +
            "                     \"email\": \"kfriedenberger@sapient.com\",\n" +
            "                     \"creationDate\": 1308754656354,\n" +
            "                     \"modificationDate\": 1401463182889,\n" +
            "                     \"profile\": {\n" +
            "                        \"hasProfileImage\": \"true\",\n" +
            "                        \"title\": \"Chicago Client Executive\",\n" +
            "                        \"homeOffice\": \"Chi - Loop\",\n" +
            "                        \"phoneNumber\": \"+1.312.925.2661\",\n" +
            "                        \"hireDate\": 802335600000,\n" +
            "                        \"workLocation\": \"Chicago\",\n" +
            "                        \"careerStage\": \"VP/Fellow\",\n" +
            "                        \"hasAvatar\": \"true\",\n" +
            "                        \"team\": \"Team Hendrix\",\n" +
            "                        \"displayName\": \"Kirk Friedenberger\",\n" +
            "                        \"mobilePhoneNumber\": \"+1.312.925.2661\"\n" +
            "                     },\n" +
            "                     \"enabled\": true,\n" +
            "                     \"lastLoggedIn\": 1401463182889,\n" +
            "                     \"lastProfileUpdate\": 1352320049889,\n" +
            "                     \"type\": \"REGULAR\",\n" +
            "                     \"federated\": true,\n" +
            "                     \"visible\": true,\n" +
            "                     \"status\": \"registered\",\n" +
            "                     \"url\": \"https://vox.sapient.com/people/kfried\"\n" +
            "                  },\n" +
            "                  \"action\": \"Create\",\n" +
            "                  \"actionObject\": {\n" +
            "                     \"@class\": \".TaskContent\",\n" +
            "                     \"objectType\": \"task\",\n" +
            "                     \"objectId\": 1439,\n" +
            "                     \"isDataAvailable\": true,\n" +
            "                     \"extras\": {},\n" +
            "                     \"tags\": [],\n" +
            "                     \"subject\": \"Project Initiation (CE related)\",\n" +
            "                     \"creationDate\": 1309526035725,\n" +
            "                     \"modifiedDate\": 1352319968735,\n" +
            "                     \"authorId\": 4786,\n" +
            "                     \"containerId\": 1172,\n" +
            "                     \"containerType\": \"project\",\n" +
            "                     \"isVisibleToPartner\": false,\n" +
            "                     \"status\": \"PUBLISHED\",\n" +
            "                     \"url\": \"https://vox.sapient.com/tasks/1439\",\n" +
            "                     \"fullPath\": \"/systemcontainer_17/socialgroup_1328/project_1172\",\n" +
            "                     \"normalizedPath\": \"/socialgroup_1328/project_1172\",\n" +
            "                     \"completed\": true,\n" +
            "                     \"dueDate\": 1325314800000,\n" +
            "                     \"owner\": {\n" +
            "                        \"@class\": \".Actor\",\n" +
            "                        \"objectType\": \"user\",\n" +
            "                        \"objectId\": 2207,\n" +
            "                        \"isDataAvailable\": true,\n" +
            "                        \"extras\": {},\n" +
            "                        \"tags\": [],\n" +
            "                        \"username\": \"tmcnei\",\n" +
            "                        \"name\": \"Sebastian Toby Orlando McNeill\",\n" +
            "                        \"firstName\": \"Sebastian Toby Orlando\",\n" +
            "                        \"lastName\": \"McNeill\",\n" +
            "                        \"email\": \"tmcneill@sapient.com\",\n" +
            "                        \"creationDate\": 1294941637609,\n" +
            "                        \"modificationDate\": 1401890097614,\n" +
            "                        \"profile\": {\n" +
            "                           \"hasProfileImage\": \"true\",\n" +
            "                           \"title\": \"Director of General Management\",\n" +
            "                           \"homeOffice\": \"NEW YORK Fulton Street\",\n" +
            "                           \"phoneNumber\": \"19173993854\",\n" +
            "                           \"careerStage\": \"Director/Expert\",\n" +
            "                           \"hasAvatar\": \"true\",\n" +
            "                           \"displayName\": \"Toby McNeill\"\n" +
            "                        },\n" +
            "                        \"enabled\": true,\n" +
            "                        \"lastLoggedIn\": 1401890096937,\n" +
            "                        \"lastProfileUpdate\": 1348516925711,\n" +
            "                        \"type\": \"REGULAR\",\n" +
            "                        \"federated\": true,\n" +
            "                        \"visible\": true,\n" +
            "                        \"status\": \"registered\",\n" +
            "                        \"url\": \"https://vox.sapient.com/people/tmcnei\"\n" +
            "                     },\n" +
            "                     \"parentTask\": {\n" +
            "                        \"@class\": \".TaskContent\",\n" +
            "                        \"objectType\": \"task\",\n" +
            "                        \"objectId\": 1437,\n" +
            "                        \"isDataAvailable\": true,\n" +
            "                        \"extras\": {},\n" +
            "                        \"tags\": [],\n" +
            "                        \"subject\": \"Delivery Improvement\",\n" +
            "                        \"creationDate\": 1309526035722,\n" +
            "                        \"modifiedDate\": 1352319968742,\n" +
            "                        \"authorId\": 4786,\n" +
            "                        \"containerId\": 1172,\n" +
            "                        \"containerType\": \"project\",\n" +
            "                        \"isVisibleToPartner\": false,\n" +
            "                        \"status\": \"PUBLISHED\",\n" +
            "                        \"url\": \"https://vox.sapient.com/tasks/1437\",\n" +
            "                        \"fullPath\": \"/systemcontainer_17/socialgroup_1328/project_1172\",\n" +
            "                        \"normalizedPath\": \"/socialgroup_1328/project_1172\",\n" +
            "                        \"completed\": true,\n" +
            "                        \"dueDate\": 1325314800000,\n" +
            "                        \"owner\": {\n" +
            "                           \"@class\": \".Actor\",\n" +
            "                           \"objectType\": \"user\",\n" +
            "                           \"objectId\": 4786,\n" +
            "                           \"isDataAvailable\": true,\n" +
            "                           \"extras\": {},\n" +
            "                           \"tags\": [],\n" +
            "                           \"username\": \"kfried\",\n" +
            "                           \"name\": \"Kirk Friedenberger\",\n" +
            "                           \"firstName\": \"Kirk\",\n" +
            "                           \"lastName\": \"Friedenberger\",\n" +
            "                           \"email\": \"kfriedenberger@sapient.com\",\n" +
            "                           \"creationDate\": 1308754656354,\n" +
            "                           \"modificationDate\": 1401463182889,\n" +
            "                           \"profile\": {\n" +
            "                              \"hasProfileImage\": \"true\",\n" +
            "                              \"title\": \"Chicago Client Executive\",\n" +
            "                              \"homeOffice\": \"Chi - Loop\",\n" +
            "                              \"phoneNumber\": \"+1.312.925.2661\",\n" +
            "                              \"hireDate\": 802335600000,\n" +
            "                              \"workLocation\": \"Chicago\",\n" +
            "                              \"careerStage\": \"VP/Fellow\",\n" +
            "                              \"hasAvatar\": \"true\",\n" +
            "                              \"team\": \"Team Hendrix\",\n" +
            "                              \"displayName\": \"Kirk Friedenberger\",\n" +
            "                              \"mobilePhoneNumber\": \"+1.312.925.2661\"\n" +
            "                           },\n" +
            "                           \"enabled\": true,\n" +
            "                           \"lastLoggedIn\": 1401463182889,\n" +
            "                           \"lastProfileUpdate\": 1352320049889,\n" +
            "                           \"type\": \"REGULAR\",\n" +
            "                           \"federated\": true,\n" +
            "                           \"visible\": true,\n" +
            "                           \"status\": \"registered\",\n" +
            "                           \"url\": \"https://vox.sapient.com/people/kfried\"\n" +
            "                        },\n" +
            "                        \"parentTask\": {\n" +
            "                           \"@class\": \".TaskContent\",\n" +
            "                           \"objectType\": \"task\",\n" +
            "                           \"objectId\": 1434,\n" +
            "                           \"isDataAvailable\": true,\n" +
            "                           \"extras\": {},\n" +
            "                           \"tags\": [],\n" +
            "                           \"subject\": \"Working Groups\",\n" +
            "                           \"creationDate\": 1309526035714,\n" +
            "                           \"modifiedDate\": 1352319965078,\n" +
            "                           \"authorId\": 4786,\n" +
            "                           \"containerId\": 1172,\n" +
            "                           \"containerType\": \"project\",\n" +
            "                           \"isVisibleToPartner\": false,\n" +
            "                           \"status\": \"PUBLISHED\",\n" +
            "                           \"url\": \"https://vox.sapient.com/tasks/1434\",\n" +
            "                           \"fullPath\": \"/systemcontainer_17/socialgroup_1328/project_1172\",\n" +
            "                           \"normalizedPath\": \"/socialgroup_1328/project_1172\",\n" +
            "                           \"completed\": true,\n" +
            "                           \"dueDate\": 1325314800000,\n" +
            "                           \"owner\": {\n" +
            "                              \"@class\": \".Actor\",\n" +
            "                              \"objectType\": \"user\",\n" +
            "                              \"objectId\": 4786,\n" +
            "                              \"isDataAvailable\": true,\n" +
            "                              \"extras\": {},\n" +
            "                              \"tags\": [],\n" +
            "                              \"username\": \"kfried\",\n" +
            "                              \"name\": \"Kirk Friedenberger\",\n" +
            "                              \"firstName\": \"Kirk\",\n" +
            "                              \"lastName\": \"Friedenberger\",\n" +
            "                              \"email\": \"kfriedenberger@sapient.com\",\n" +
            "                              \"creationDate\": 1308754656354,\n" +
            "                              \"modificationDate\": 1401463182889,\n" +
            "                              \"profile\": {\n" +
            "                                 \"hasProfileImage\": \"true\",\n" +
            "                                 \"title\": \"Chicago Client Executive\",\n" +
            "                                 \"homeOffice\": \"Chi - Loop\",\n" +
            "                                 \"phoneNumber\": \"+1.312.925.2661\",\n" +
            "                                 \"hireDate\": 802335600000,\n" +
            "                                 \"workLocation\": \"Chicago\",\n" +
            "                                 \"careerStage\": \"VP/Fellow\",\n" +
            "                                 \"hasAvatar\": \"true\",\n" +
            "                                 \"team\": \"Team Hendrix\",\n" +
            "                                 \"displayName\": \"Kirk Friedenberger\",\n" +
            "                                 \"mobilePhoneNumber\": \"+1.312.925.2661\"\n" +
            "                              },\n" +
            "                              \"enabled\": true,\n" +
            "                              \"lastLoggedIn\": 1401463182889,\n" +
            "                              \"lastProfileUpdate\": 1352320049889,\n" +
            "                              \"type\": \"REGULAR\",\n" +
            "                              \"federated\": true,\n" +
            "                              \"visible\": true,\n" +
            "                              \"status\": \"registered\",\n" +
            "                              \"url\": \"https://vox.sapient.com/people/kfried\"\n" +
            "                           }\n" +
            "                        }\n" +
            "                     },\n" +
            "                     \"combinedObjectTypeId\": \"602_1439\"\n" +
            "                  },\n" +
            "                  \"activityTime\": 1309526035860,\n" +
            "                  \"destination\": {\n" +
            "                     \"@class\": \".ActivityDestination\",\n" +
            "                     \"objectType\": \"project\",\n" +
            "                     \"objectId\": 1172,\n" +
            "                     \"isDataAvailable\": true,\n" +
            "                     \"extras\": {},\n" +
            "                     \"tags\": [],\n" +
            "                     \"name\": \"Doors Working Groups\",\n" +
            "                     \"displayName\": \"doors-working-groups\",\n" +
            "                     \"description\": \"Doors Working Groups\",\n" +
            "                     \"creationDate\": 1309211008837,\n" +
            "                     \"modificationDate\": 1352319968755,\n" +
            "                     \"url\": \"https://vox.sapient.com/groups/team-doors/projects/doors-working-groups\",\n" +
            "                     \"status\": \"ACTIVE\",\n" +
            "                     \"isVisibleToPartner\": false,\n" +
            "                     \"parentId\": 1328,\n" +
            "                     \"parentType\": \"socialgroup\",\n" +
            "                     \"fullPath\": \"/systemcontainer_17/socialgroup_1328/project_1172\",\n" +
            "                     \"normalizedPath\": \"/socialgroup_1328/project_1172\",\n" +
            "                     \"combinedObjectTypeId\": \"600_1172\"\n" +
            "                  }\n" +
            "               },\n" +
            "               \"isHistoricalReplay\": true\n" +
            "            }\n" +
            "         }";
}
