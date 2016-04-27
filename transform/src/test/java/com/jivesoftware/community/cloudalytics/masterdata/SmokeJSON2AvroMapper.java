package com.jivesoftware.community.cloudalytics.masterdata;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jivesoftware.community.cloudalytics.masterdata.avro.AvroEvent;
import com.jivesoftware.community.cloudalytics.masterdata.jsonschema.EventDocument;
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
public class SmokeJSON2AvroMapper {
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
            "                     \"masterdata\": \"false\",\n" +
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
        testBidirectional(megaNestedComment);
    }

    public void testBidirectional(String doc) throws IOException {
        testBidirectional(doc, null);
    }
    public void testBidirectional(String doc, File file) throws IOException {
        EventDocument nested = parseTestDoc(doc);
        AvroEvent avroEvent = Json2AvroCloner.clone(nested);
        EventDocument postAvroJson = Avro2JsonCloner.clone(avroEvent);
        assertEquals("failed to correctly map action object", (long) nested.getActionObjectType(), (long) avroEvent.getActionObjectType());
        if (file != null) {
            writeAvroDoc(avroEvent, file);
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

    String megaNestedComment = "{\"name\":\"ACTIVITY_MENTION_USER\",\"timestamp\":1461005279246,\"seqId\":277210,\"uuid\":\"125962e0-0596-11e6-b191-005056b908c2\",\"context\":{\"jvm\":{\"jvmHome\":\"/usr/local/jive/applications/brewspace/.\",\"jvmIpAddr\":\"nic=eth1,mac=00:00:06:f9:08:f2,ip=10.10.60.74;nic=eth0,mac=00:00:06:f9:08:f1,ip=10.10.80.74\",\"jvmHost\":\"brew-wa02\",\"jvmUid\":\"15fa5800-005f-11e6-b191-005056b908c2\"},\"web\":{\"anon\":\"false\",\"visible\":\"true\",\"userAgent\":\"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/601.5.17 (KHTML, like Gecko) Version/9.1 Safari/601.5.17\",\"sessionId\":\"0E22A6ACA7C931D0CD3A718998721728.node02\",\"userId\":\"8827\",\"external\":\"false\",\"federated\":\"true\",\"partner\":\"false\",\"valueCase\":\"ob\",\"requestId\":\"12536f70-0596-11e6-b191-005056b908c2\",\"appID\":\"web\",\"userEmail\":\"judith.rich@jivesoftware.com\",\"userType\":\"REGULAR\",\"flowId\":\"12536f71-0596-11e6-b191-005056b908c2\",\"username\":\"Judith.Rich\"},\"service\":{\"serviceVersion\":\"2016.2.0.0\",\"instanceId\":\"99927a59-3eff-4000-b243-b5d16ed97999\",\"instanceType\":\"\",\"tenantId\":\"99927a59-3eff-4000-b243-b5d16ed97999\",\"serviceName\":\"Jive SBS\",\"jiveUrl\":\"https://brewspace.jiveland.com\"}},\"payload\":{},\"actorID\":8827,\"actorType\":3,\"activityType\":\"Mention\",\"actionObjectId\":2048122,\"actionObjectType\":105,\"containerId\":5490,\"containerType\":700,\"activity\":{\"actor\":{\"@class\":\".Actor\",\"objectType\":\"user\",\"objectId\":8827,\"objectHash\":\"14b82686aaa53c9a0d8fa03012a6e429e67e6185\",\"isDataAvailable\":true,\"extras\":{},\"tags\":[],\"username\":\"Judith.Rich\",\"name\":\"Judith Rich\",\"firstName\":\"Judith\",\"lastName\":\"Rich\",\"email\":\"judith.rich@jivesoftware.com\",\"creationDate\":1428649212056,\"modificationDate\":1460962818371,\"profile\":{\"hasAvatar\":\"true\",\"hasProfileImage\":\"true\",\"phoneNumber\":\"+1 (503) 575-4412\",\"company\":\"Jive Software\",\"office\":\"Portland\",\"title\":\"Senior Branded Content Manager\",\"department\":\"Marketing\"},\"enabled\":true,\"lastLoggedIn\":1460741627513,\"lastProfileUpdate\":1460962818371,\"type\":\"REGULAR\",\"federated\":true,\"visible\":true,\"status\":\"registered\",\"url\":\"https://brewspace.jiveland.com/people/Judith.Rich\"},\"action\":\"Mention\",\"actionObject\":{\"@class\":\".CommentContent\",\"objectType\":\"comment\",\"objectId\":2048122,\"objectHash\":\"8b5fe0ec027824e11a7211a43069e844b6183ca2\",\"isDataAvailable\":true,\"extras\":{\"mentionId\":8775,\"mentionName\":\"Jason Harris\",\"mentionType\":3,\"recipientUser\":{\"objectType\":\"user\",\"objectId\":8775,\"isDataAvailable\":true,\"extras\":{},\"tags\":[],\"username\":\"jason.harris\",\"name\":\"Jason Harris\",\"firstName\":\"Jason\",\"lastName\":\"Harris\",\"email\":\"jason.harris@jivesoftware.com\",\"creationDate\":1427439612827,\"modificationDate\":1460409131229,\"profile\":{\"hasAvatar\":\"true\",\"hasProfileImage\":\"true\",\"phoneNumber\":\"+1 (503) 467-2000\",\"company\":\"Vitamin T\",\"office\":\"Portland\",\"availability\":\"In Office\",\"title\":\"Art Director\",\"department\":\"Marketing\",\"jive-wLocation\":\"PDX [America/Los_Angeles]\"},\"enabled\":true,\"lastLoggedIn\":1460409131140,\"lastProfileUpdate\":1460409131229,\"type\":\"REGULAR\",\"federated\":true,\"visible\":true,\"status\":\"registered\",\"url\":\"https://brewspace.jiveland.com/people/jason.harris\"},\"mentionUrl\":\"https://brewspace.jiveland.com/people/jason.harris\"},\"tags\":[],\"subject\":\"Creative Brief: (Creative + Content) [Effective Clinical Communication] \",\"creationDate\":1461005279214,\"modifiedDate\":1461005279214,\"author\":{\"@class\":\".Actor\",\"objectType\":\"user\",\"objectId\":8827,\"isDataAvailable\":false,\"extras\":{},\"tags\":[],\"username\":\"Judith.Rich\",\"name\":\"Judith Rich\",\"firstName\":\"Judith\",\"lastName\":\"Rich\",\"email\":\"judith.rich@jivesoftware.com\",\"creationDate\":1428649212056,\"modificationDate\":1460962818371,\"profile\":{\"hasAvatar\":\"true\",\"hasProfileImage\":\"true\",\"phoneNumber\":\"+1 (503) 575-4412\",\"company\":\"Jive Software\",\"office\":\"Portland\",\"title\":\"Senior Branded Content Manager\",\"department\":\"Marketing\"},\"enabled\":true,\"lastLoggedIn\":1460741627513,\"lastProfileUpdate\":1460962818371,\"type\":\"REGULAR\",\"federated\":true,\"visible\":true,\"status\":\"registered\",\"url\":\"https://brewspace.jiveland.com/people/Judith.Rich\"},\"containerId\":5490,\"containerType\":\"socialgroup\",\"isVisibleToPartner\":false,\"status\":\"PUBLISHED\",\"url\":\"https://brewspace.jiveland.com/docs/DOC-272185#comment-2048122\",\"fullPath\":\"/systemcontainer_17/socialgroup_5490\",\"normalizedPath\":\"/socialgroup_5490\",\"parentCommentId\":2048111,\"parentComment\":{\"@class\":\".CommentContent\",\"objectType\":\"comment\",\"objectId\":2048111,\"objectHash\":\"d05611748cc19786ab70d0139044b8595d98fbbd\",\"isDataAvailable\":true,\"extras\":{\"mentionId\":8775,\"mentionName\":\"Jason Harris\",\"mentionType\":3,\"recipientUser\":{\"objectType\":\"user\",\"objectId\":8775,\"isDataAvailable\":true,\"extras\":{},\"tags\":[],\"username\":\"jason.harris\",\"name\":\"Jason Harris\",\"firstName\":\"Jason\",\"lastName\":\"Harris\",\"email\":\"jason.harris@jivesoftware.com\",\"creationDate\":1427439612827,\"modificationDate\":1460409131229,\"profile\":{\"hasAvatar\":\"true\",\"hasProfileImage\":\"true\",\"phoneNumber\":\"+1 (503) 467-2000\",\"company\":\"Vitamin T\",\"office\":\"Portland\",\"availability\":\"In Office\",\"title\":\"Art Director\",\"department\":\"Marketing\",\"jive-wLocation\":\"PDX [America/Los_Angeles]\"},\"enabled\":true,\"lastLoggedIn\":1460409131140,\"lastProfileUpdate\":1460409131229,\"type\":\"REGULAR\",\"federated\":true,\"visible\":true,\"status\":\"registered\",\"url\":\"https://brewspace.jiveland.com/people/jason.harris\"},\"mentionUrl\":\"https://brewspace.jiveland.com/people/jason.harris\"},\"tags\":[],\"subject\":\"Creative Brief: (Creative + Content) [Effective Clinical Communication] \",\"creationDate\":1461005069150,\"modifiedDate\":1461005069150,\"author\":{\"@class\":\".Actor\",\"objectType\":\"user\",\"objectId\":9729,\"isDataAvailable\":false,\"extras\":{},\"tags\":[],\"username\":\"ian.botbyl\",\"name\":\"Ian Botbyl\",\"firstName\":\"Ian\",\"lastName\":\"Botbyl\",\"email\":\"ian.botbyl@jivesoftware.com\",\"creationDate\":1453945725292,\"modificationDate\":1460989281293,\"profile\":{\"mobilePhoneNumber\":\"+1 616-402-8514\",\"hasProfileImage\":\"true\",\"hireDate\":1454313600000,\"office\":\"Remote\",\"availability\":\"Working Remotely\",\"biography\":\"Helping Healthcare work better together! Coach, athlete, analyst, social collaborator, musician, geek, actor, director, fantasy football all-star, wrestling official, Grand Valley State University alumni, five star chef of breakfast foods. \",\"primaryWorkType\":\"Energizer\",\"linkedIn\":\"http://www.linkedin.com/in/ianbotbyl\",\"title\":\"Marketing Associate, Healthcare\",\"expertise\":\"Social business, social intranet, Healthcare IT, Information Technology, Jive 6 hosted, Jive 7 hosted, Jive Cloud, Jive 8 hosted, SharePoint, project management, training, coaching, film and video, presentations, Android, Confluence, audio, HTML, Adobe Creative Suite, CA Service Desk, SAP, SQL Server, JIRA, PING, HIPAA, Healthcare, Information Technology, Jive 6 hosted, Jive 7 hosted, Jive Cloud, Jive 8 hosted, SharePoint, project management, training, coaching, film and video, presentations, Android, Confluence, audio, HTML, Adobe Creative Suite, CA Service Desk, SAP, SQL Server, JIRA, PING SSO, HIPPA\",\"hasAvatar\":\"true\",\"previousCompanies\":\"Spectrum Health, Best Buy\",\"twitter\":\"Bots60\",\"workStyle\":\"Collaborative, coffee \",\"company\":\"Jive Software\",\"location\":\"Grand Rapids, MI\",\"department\":\"Product Marketing\",\"currentGoals\":\"Engage healthcare customers to use Jive more effectively \",\"jive-wLocation\":\"Remote\"},\"enabled\":true,\"lastLoggedIn\":1460989261197,\"lastProfileUpdate\":1460989261353,\"type\":\"REGULAR\",\"federated\":true,\"visible\":true,\"status\":\"registered\",\"url\":\"https://brewspace.jiveland.com/people/ian.botbyl\"},\"containerId\":5490,\"containerType\":\"socialgroup\",\"isVisibleToPartner\":false,\"status\":\"PUBLISHED\",\"url\":\"https://brewspace.jiveland.com/docs/DOC-272185#comment-2048111\",\"fullPath\":\"/systemcontainer_17/socialgroup_5490\",\"normalizedPath\":\"/socialgroup_5490\",\"parentCommentId\":2048095,\"parentComment\":{\"@class\":\".CommentContent\",\"objectType\":\"comment\",\"objectId\":2048095,\"objectHash\":\"3e6f5453c5b7a03cf3361d15303a3eaf4b242bb6\",\"isDataAvailable\":true,\"extras\":{\"mentionId\":8775,\"mentionName\":\"Jason Harris\",\"mentionType\":3,\"recipientUser\":{\"objectType\":\"user\",\"objectId\":8775,\"isDataAvailable\":true,\"extras\":{},\"tags\":[],\"username\":\"jason.harris\",\"name\":\"Jason Harris\",\"firstName\":\"Jason\",\"lastName\":\"Harris\",\"email\":\"jason.harris@jivesoftware.com\",\"creationDate\":1427439612827,\"modificationDate\":1460409131229,\"profile\":{\"hasAvatar\":\"true\",\"hasProfileImage\":\"true\",\"phoneNumber\":\"+1 (503) 467-2000\",\"company\":\"Vitamin T\",\"office\":\"Portland\",\"availability\":\"In Office\",\"title\":\"Art Director\",\"department\":\"Marketing\",\"jive-wLocation\":\"PDX [America/Los_Angeles]\"},\"enabled\":true,\"lastLoggedIn\":1460409131140,\"lastProfileUpdate\":1460409131229,\"type\":\"REGULAR\",\"federated\":true,\"visible\":true,\"status\":\"registered\",\"url\":\"https://brewspace.jiveland.com/people/jason.harris\"},\"mentionUrl\":\"https://brewspace.jiveland.com/people/jason.harris\"},\"tags\":[],\"subject\":\"Creative Brief: (Creative + Content) [Effective Clinical Communication] \",\"creationDate\":1461004275812,\"modifiedDate\":1461004275812,\"author\":{\"@class\":\".Actor\",\"objectType\":\"user\",\"objectId\":8827,\"isDataAvailable\":false,\"extras\":{},\"tags\":[],\"username\":\"Judith.Rich\",\"name\":\"Judith Rich\",\"firstName\":\"Judith\",\"lastName\":\"Rich\",\"email\":\"judith.rich@jivesoftware.com\",\"creationDate\":1428649212056,\"modificationDate\":1460962818371,\"profile\":{\"hasAvatar\":\"true\",\"hasProfileImage\":\"true\",\"phoneNumber\":\"+1 (503) 575-4412\",\"company\":\"Jive Software\",\"office\":\"Portland\",\"title\":\"Senior Branded Content Manager\",\"department\":\"Marketing\"},\"enabled\":true,\"lastLoggedIn\":1460741627513,\"lastProfileUpdate\":1460962818371,\"type\":\"REGULAR\",\"federated\":true,\"visible\":true,\"status\":\"registered\",\"url\":\"https://brewspace.jiveland.com/people/Judith.Rich\"},\"containerId\":5490,\"containerType\":\"socialgroup\",\"isVisibleToPartner\":false,\"status\":\"PUBLISHED\",\"url\":\"https://brewspace.jiveland.com/docs/DOC-272185#comment-2048095\",\"fullPath\":\"/systemcontainer_17/socialgroup_5490\",\"normalizedPath\":\"/socialgroup_5490\",\"parentCommentId\":2047003,\"parentComment\":{\"@class\":\".CommentContent\",\"objectType\":\"comment\",\"objectId\":2047003,\"objectHash\":\"c4d82f48ed1d2133f0eff617efda195ed13c70fe\",\"isDataAvailable\":true,\"extras\":{\"mentionId\":8775,\"mentionName\":\"Jason Harris\",\"mentionType\":3,\"recipientUser\":{\"objectType\":\"user\",\"objectId\":8775,\"isDataAvailable\":true,\"extras\":{},\"tags\":[],\"username\":\"jason.harris\",\"name\":\"Jason Harris\",\"firstName\":\"Jason\",\"lastName\":\"Harris\",\"email\":\"jason.harris@jivesoftware.com\",\"creationDate\":1427439612827,\"modificationDate\":1460409131229,\"profile\":{\"hasAvatar\":\"true\",\"hasProfileImage\":\"true\",\"phoneNumber\":\"+1 (503) 467-2000\",\"company\":\"Vitamin T\",\"office\":\"Portland\",\"availability\":\"In Office\",\"title\":\"Art Director\",\"department\":\"Marketing\",\"jive-wLocation\":\"PDX [America/Los_Angeles]\"},\"enabled\":true,\"lastLoggedIn\":1460409131140,\"lastProfileUpdate\":1460409131229,\"type\":\"REGULAR\",\"federated\":true,\"visible\":true,\"status\":\"registered\",\"url\":\"https://brewspace.jiveland.com/people/jason.harris\"},\"mentionUrl\":\"https://brewspace.jiveland.com/people/jason.harris\"},\"tags\":[],\"subject\":\"Creative Brief: (Creative + Content) [Effective Clinical Communication] \",\"creationDate\":1460750694404,\"modifiedDate\":1460750694404,\"author\":{\"@class\":\".Actor\",\"objectType\":\"user\",\"objectId\":9729,\"isDataAvailable\":false,\"extras\":{},\"tags\":[],\"username\":\"ian.botbyl\",\"name\":\"Ian Botbyl\",\"firstName\":\"Ian\",\"lastName\":\"Botbyl\",\"email\":\"ian.botbyl@jivesoftware.com\",\"creationDate\":1453945725292,\"modificationDate\":1460989281293,\"profile\":{\"mobilePhoneNumber\":\"+1 616-402-8514\",\"hasProfileImage\":\"true\",\"hireDate\":1454313600000,\"office\":\"Remote\",\"availability\":\"Working Remotely\",\"biography\":\"Helping Healthcare work better together! Coach, athlete, analyst, social collaborator, musician, geek, actor, director, fantasy football all-star, wrestling official, Grand Valley State University alumni, five star chef of breakfast foods. \",\"primaryWorkType\":\"Energizer\",\"linkedIn\":\"http://www.linkedin.com/in/ianbotbyl\",\"title\":\"Marketing Associate, Healthcare\",\"expertise\":\"Social business, social intranet, Healthcare IT, Information Technology, Jive 6 hosted, Jive 7 hosted, Jive Cloud, Jive 8 hosted, SharePoint, project management, training, coaching, film and video, presentations, Android, Confluence, audio, HTML, Adobe Creative Suite, CA Service Desk, SAP, SQL Server, JIRA, PING, HIPAA, Healthcare, Information Technology, Jive 6 hosted, Jive 7 hosted, Jive Cloud, Jive 8 hosted, SharePoint, project management, training, coaching, film and video, presentations, Android, Confluence, audio, HTML, Adobe Creative Suite, CA Service Desk, SAP, SQL Server, JIRA, PING SSO, HIPPA\",\"hasAvatar\":\"true\",\"previousCompanies\":\"Spectrum Health, Best Buy\",\"twitter\":\"Bots60\",\"workStyle\":\"Collaborative, coffee \",\"company\":\"Jive Software\",\"location\":\"Grand Rapids, MI\",\"department\":\"Product Marketing\",\"currentGoals\":\"Engage healthcare customers to use Jive more effectively \",\"jive-wLocation\":\"Remote\"},\"enabled\":true,\"lastLoggedIn\":1460989261197,\"lastProfileUpdate\":1460989261353,\"type\":\"REGULAR\",\"federated\":true,\"visible\":true,\"status\":\"registered\",\"url\":\"https://brewspace.jiveland.com/people/ian.botbyl\"},\"containerId\":5490,\"containerType\":\"socialgroup\",\"isVisibleToPartner\":false,\"status\":\"PUBLISHED\",\"url\":\"https://brewspace.jiveland.com/docs/DOC-272185#comment-2047003\",\"fullPath\":\"/systemcontainer_17/socialgroup_5490\",\"normalizedPath\":\"/socialgroup_5490\",\"parentCommentId\":2046976,\"parentComment\":{\"@class\":\".CommentContent\",\"objectType\":\"comment\",\"objectId\":2046976,\"objectHash\":\"ec3db4384653f23eb7acc0317088205cf11a63a2\",\"isDataAvailable\":true,\"extras\":{\"mentionId\":8775,\"mentionName\":\"Jason Harris\",\"mentionType\":3,\"recipientUser\":{\"objectType\":\"user\",\"objectId\":8775,\"isDataAvailable\":true,\"extras\":{},\"tags\":[],\"username\":\"jason.harris\",\"name\":\"Jason Harris\",\"firstName\":\"Jason\",\"lastName\":\"Harris\",\"email\":\"jason.harris@jivesoftware.com\",\"creationDate\":1427439612827,\"modificationDate\":1460409131229,\"profile\":{\"hasAvatar\":\"true\",\"hasProfileImage\":\"true\",\"phoneNumber\":\"+1 (503) 467-2000\",\"company\":\"Vitamin T\",\"office\":\"Portland\",\"availability\":\"In Office\",\"title\":\"Art Director\",\"department\":\"Marketing\",\"jive-wLocation\":\"PDX [America/Los_Angeles]\"},\"enabled\":true,\"lastLoggedIn\":1460409131140,\"lastProfileUpdate\":1460409131229,\"type\":\"REGULAR\",\"federated\":true,\"visible\":true,\"status\":\"registered\",\"url\":\"https://brewspace.jiveland.com/people/jason.harris\"},\"mentionUrl\":\"https://brewspace.jiveland.com/people/jason.harris\"},\"tags\":[],\"subject\":\"Creative Brief: (Creative + Content) [Effective Clinical Communication] \",\"creationDate\":1460750177637,\"modifiedDate\":1460750177637,\"author\":{\"@class\":\".Actor\",\"objectType\":\"user\",\"objectId\":8827,\"isDataAvailable\":false,\"extras\":{},\"tags\":[],\"username\":\"Judith.Rich\",\"name\":\"Judith Rich\",\"firstName\":\"Judith\",\"lastName\":\"Rich\",\"email\":\"judith.rich@jivesoftware.com\",\"creationDate\":1428649212056,\"modificationDate\":1460962818371,\"profile\":{\"hasAvatar\":\"true\",\"hasProfileImage\":\"true\",\"phoneNumber\":\"+1 (503) 575-4412\",\"company\":\"Jive Software\",\"office\":\"Portland\",\"title\":\"Senior Branded Content Manager\",\"department\":\"Marketing\"},\"enabled\":true,\"lastLoggedIn\":1460741627513,\"lastProfileUpdate\":1460962818371,\"type\":\"REGULAR\",\"federated\":true,\"visible\":true,\"status\":\"registered\",\"url\":\"https://brewspace.jiveland.com/people/Judith.Rich\"},\"containerId\":5490,\"containerType\":\"socialgroup\",\"isVisibleToPartner\":false,\"status\":\"PUBLISHED\",\"url\":\"https://brewspace.jiveland.com/docs/DOC-272185#comment-2046976\",\"fullPath\":\"/systemcontainer_17/socialgroup_5490\",\"normalizedPath\":\"/socialgroup_5490\",\"parentCommentId\":2046949,\"parentComment\":{\"@class\":\".CommentContent\",\"objectType\":\"comment\",\"objectId\":2046949,\"objectHash\":\"5d6c60f81282d1dbf1f071a4c31b790ede113f68\",\"isDataAvailable\":true,\"extras\":{\"mentionId\":8775,\"mentionName\":\"Jason Harris\",\"mentionType\":3,\"recipientUser\":{\"objectType\":\"user\",\"objectId\":8775,\"isDataAvailable\":true,\"extras\":{},\"tags\":[],\"username\":\"jason.harris\",\"name\":\"Jason Harris\",\"firstName\":\"Jason\",\"lastName\":\"Harris\",\"email\":\"jason.harris@jivesoftware.com\",\"creationDate\":1427439612827,\"modificationDate\":1460409131229,\"profile\":{\"hasAvatar\":\"true\",\"hasProfileImage\":\"true\",\"phoneNumber\":\"+1 (503) 467-2000\",\"company\":\"Vitamin T\",\"office\":\"Portland\",\"availability\":\"In Office\",\"title\":\"Art Director\",\"department\":\"Marketing\",\"jive-wLocation\":\"PDX [America/Los_Angeles]\"},\"enabled\":true,\"lastLoggedIn\":1460409131140,\"lastProfileUpdate\":1460409131229,\"type\":\"REGULAR\",\"federated\":true,\"visible\":true,\"status\":\"registered\",\"url\":\"https://brewspace.jiveland.com/people/jason.harris\"},\"mentionUrl\":\"https://brewspace.jiveland.com/people/jason.harris\"},\"tags\":[],\"subject\":\"Creative Brief: (Creative + Content) [Effective Clinical Communication] \",\"creationDate\":1460749598034,\"modifiedDate\":1460749598034,\"author\":{\"@class\":\".Actor\",\"objectType\":\"user\",\"objectId\":9729,\"isDataAvailable\":false,\"extras\":{},\"tags\":[],\"username\":\"ian.botbyl\",\"name\":\"Ian Botbyl\",\"firstName\":\"Ian\",\"lastName\":\"Botbyl\",\"email\":\"ian.botbyl@jivesoftware.com\",\"creationDate\":1453945725292,\"modificationDate\":1460989281293,\"profile\":{\"mobilePhoneNumber\":\"+1 616-402-8514\",\"hasProfileImage\":\"true\",\"hireDate\":1454313600000,\"office\":\"Remote\",\"availability\":\"Working Remotely\",\"biography\":\"Helping Healthcare work better together! Coach, athlete, analyst, social collaborator, musician, geek, actor, director, fantasy football all-star, wrestling official, Grand Valley State University alumni, five star chef of breakfast foods. \",\"primaryWorkType\":\"Energizer\",\"linkedIn\":\"http://www.linkedin.com/in/ianbotbyl\",\"title\":\"Marketing Associate, Healthcare\",\"expertise\":\"Social business, social intranet, Healthcare IT, Information Technology, Jive 6 hosted, Jive 7 hosted, Jive Cloud, Jive 8 hosted, SharePoint, project management, training, coaching, film and video, presentations, Android, Confluence, audio, HTML, Adobe Creative Suite, CA Service Desk, SAP, SQL Server, JIRA, PING, HIPAA, Healthcare, Information Technology, Jive 6 hosted, Jive 7 hosted, Jive Cloud, Jive 8 hosted, SharePoint, project management, training, coaching, film and video, presentations, Android, Confluence, audio, HTML, Adobe Creative Suite, CA Service Desk, SAP, SQL Server, JIRA, PING SSO, HIPPA\",\"hasAvatar\":\"true\",\"previousCompanies\":\"Spectrum Health, Best Buy\",\"twitter\":\"Bots60\",\"workStyle\":\"Collaborative, coffee \",\"company\":\"Jive Software\",\"location\":\"Grand Rapids, MI\",\"department\":\"Product Marketing\",\"currentGoals\":\"Engage healthcare customers to use Jive more effectively \",\"jive-wLocation\":\"Remote\"},\"enabled\":true,\"lastLoggedIn\":1460989261197,\"lastProfileUpdate\":1460989261353,\"type\":\"REGULAR\",\"federated\":true,\"visible\":true,\"status\":\"registered\",\"url\":\"https://brewspace.jiveland.com/people/ian.botbyl\"},\"containerId\":5490,\"containerType\":\"socialgroup\",\"isVisibleToPartner\":false,\"status\":\"PUBLISHED\",\"url\":\"https://brewspace.jiveland.com/docs/DOC-272185#comment-2046949\",\"fullPath\":\"/systemcontainer_17/socialgroup_5490\",\"normalizedPath\":\"/socialgroup_5490\",\"parentCommentId\":2046933,\"parentComment\":{\"@class\":\".CommentContent\",\"objectType\":\"comment\",\"objectId\":2046933,\"objectHash\":\"7b51a3988890373abf20214e8111705befbac92c\",\"isDataAvailable\":true,\"extras\":{\"mentionId\":8775,\"mentionName\":\"Jason Harris\",\"mentionType\":3,\"recipientUser\":{\"objectType\":\"user\",\"objectId\":8775,\"isDataAvailable\":true,\"extras\":{},\"tags\":[],\"username\":\"jason.harris\",\"name\":\"Jason Harris\",\"firstName\":\"Jason\",\"lastName\":\"Harris\",\"email\":\"jason.harris@jivesoftware.com\",\"creationDate\":1427439612827,\"modificationDate\":1460409131229,\"profile\":{\"hasAvatar\":\"true\",\"hasProfileImage\":\"true\",\"phoneNumber\":\"+1 (503) 467-2000\",\"company\":\"Vitamin T\",\"office\":\"Portland\",\"availability\":\"In Office\",\"title\":\"Art Director\",\"department\":\"Marketing\",\"jive-wLocation\":\"PDX [America/Los_Angeles]\"},\"enabled\":true,\"lastLoggedIn\":1460409131140,\"lastProfileUpdate\":1460409131229,\"type\":\"REGULAR\",\"federated\":true,\"visible\":true,\"status\":\"registered\",\"url\":\"https://brewspace.jiveland.com/people/jason.harris\"},\"mentionUrl\":\"https://brewspace.jiveland.com/people/jason.harris\"},\"tags\":[],\"subject\":\"Creative Brief: (Creative + Content) [Effective Clinical Communication] \",\"creationDate\":1460749056423,\"modifiedDate\":1460749056423,\"author\":{\"@class\":\".Actor\",\"objectType\":\"user\",\"objectId\":8827,\"isDataAvailable\":false,\"extras\":{},\"tags\":[],\"username\":\"Judith.Rich\",\"name\":\"Judith Rich\",\"firstName\":\"Judith\",\"lastName\":\"Rich\",\"email\":\"judith.rich@jivesoftware.com\",\"creationDate\":1428649212056,\"modificationDate\":1460962818371,\"profile\":{\"hasAvatar\":\"true\",\"hasProfileImage\":\"true\",\"phoneNumber\":\"+1 (503) 575-4412\",\"company\":\"Jive Software\",\"office\":\"Portland\",\"title\":\"Senior Branded Content Manager\",\"department\":\"Marketing\"},\"enabled\":true,\"lastLoggedIn\":1460741627513,\"lastProfileUpdate\":1460962818371,\"type\":\"REGULAR\",\"federated\":true,\"visible\":true,\"status\":\"registered\",\"url\":\"https://brewspace.jiveland.com/people/Judith.Rich\"},\"containerId\":5490,\"containerType\":\"socialgroup\",\"isVisibleToPartner\":false,\"status\":\"PUBLISHED\",\"url\":\"https://brewspace.jiveland.com/docs/DOC-272185#comment-2046933\",\"fullPath\":\"/systemcontainer_17/socialgroup_5490\",\"normalizedPath\":\"/socialgroup_5490\",\"parentCommentId\":-1}}}}}},\"combinedObjectTypeId\":\"105_2048122\"},\"activityTime\":1461005279246,\"destination\":{\"@class\":\".ActivityDestination\",\"objectType\":\"socialgroup\",\"objectId\":5490,\"objectHash\":\"e1c9c9e50f2ee2aaac0f8699ad62e05a14557233\",\"isDataAvailable\":true,\"extras\":{},\"tags\":[],\"name\":\"Creative Services Requests\",\"displayName\":\"creative-services-requests\",\"description\":\" \",\"creationDate\":1366741598897,\"modificationDate\":1460663194583,\"url\":\"https://brewspace.jiveland.com/groups/creative-services-requests\",\"status\":\"ACTIVE\",\"isVisibleToPartner\":false,\"parentId\":17,\"parentType\":\"systemcontainer\",\"fullPath\":\"/systemcontainer_17/socialgroup_5490\",\"normalizedPath\":\"/socialgroup_5490\",\"combinedObjectTypeId\":\"700_5490\"}},\"isHistoricalReplay\":false}";
}
