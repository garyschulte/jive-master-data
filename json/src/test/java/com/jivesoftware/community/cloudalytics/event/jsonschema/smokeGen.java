package com.jivesoftware.community.cloudalytics.event.jsonschema;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

/**
 * Created by gary.schulte on 4/13/16.
 */
public class smokeGen {

static String badActor = "{\n" +
                "  \"name\":\"ACTIVITY_SENT_SHARE\",\n" +
                "  \"timestamp\":1460697144856,\n" +
                "  \"seqId\":4786,\n" +
                "  \"uuid\":\"a3f0c980-02c8-11e6-8115-005056a740d8\",\n" +
                "  \"context\":{ },\n" +
                "  \"payload\":{\n" +
                "\n" +
                "  },\n" +
                "  \"actorID\":2184,\n" +
                "  \"actorType\":3,\n" +
                "  \"activityType\":\"Send\",\n" +
                "  \"actionObjectId\":1062,\n" +
                "  \"actionObjectType\":700,\n" +
                "  \"containerId\":1170,\n" +
                "  \"containerType\":2020,\n" +
                "  \"activity\":{\n" +
                "    \"actor\":{\n" +
                "      \"@class\":\".Actor\",\n" +
                "      \"objectType\":\"user\",\n" +
                "      \"objectId\":2184,\n" +
                "      \"objectHash\":\"1a3de99ad5a2c6e0485650e6874a3c3ae6fdbabe\",\n" +
                "      \"isDataAvailable\":true,\n" +
                "      \"extras\":{\n" +
                "\n" +
                "      },\n" +
                "      \"tags\":[\n" +
                "\n" +
                "      ],\n" +
                "      \"username\":\"regularuser-xdg1lfqswr7j@example.com\",\n" +
                "      \"name\":\"regularUser-xdG1LFQSwR7j TestUser\",\n" +
                "      \"firstName\":\"regularUser-xdG1LFQSwR7j\",\n" +
                "      \"lastName\":\"TestUser\",\n" +
                "      \"email\":\"regularuser-xdg1lfqswr7j@example.com\",\n" +
                "      \"creationDate\":1460697065264,\n" +
                "      \"modificationDate\":1460697075215,\n" +
                "      \"profile\":{\n" +
                "        \"hasAvatar\":\"true\"\n" +
                "      },\n" +
                "      \"enabled\":true,\n" +
                "      \"lastLoggedIn\":1460697067599,\n" +
                "      \"lastProfileUpdate\":1460697065555,\n" +
                "      \"type\":\"REGULAR\",\n" +
                "      \"federated\":false,\n" +
                "      \"visible\":true,\n" +
                "      \"status\":\"registered\",\n" +
                "      \"url\":\"https://banzai-qe-people-places-brewspace-123-8.jivelandia.com/people/regularuser-xdg1lfqswr7j@example.com\"\n" +
                "    },\n" +
                "    \"action\":\"Send\",\n" +
                "    \"actionObject\":{\n" +
                "      \"@class\":\".ActivityDestination\",\n" +
                "      \"objectType\":\"socialgroup\",\n" +
                "      \"objectId\":1062,\n" +
                "      \"objectHash\":\"2f052e81be19d0299013e35ff1999790056d0529\",\n" +
                "      \"isDataAvailable\":true,\n" +
                "      \"extras\":{\n" +
                "        \"recipientUser\":{\n" +
                "          \"objectType\":\"user\",\n" +
                "          \"objectId\":2185,\n" +
                "          \"isDataAvailable\":true,\n" +
                "          \"extras\":{\n" +
                "\n" +
                "          },\n" +
                "          \"tags\":[\n" +
                "\n" +
                "          ],\n" +
                "          \"username\":\"regularuser-brvcf8ng6qmy@example.com\",\n" +
                "          \"name\":\"regularUser-brVcf8nG6Qmy TestUser\",\n" +
                "          \"firstName\":\"regularUser-brVcf8nG6Qmy\",\n" +
                "          \"lastName\":\"TestUser\",\n" +
                "          \"email\":\"regularuser-brvcf8ng6qmy@example.com\",\n" +
                "          \"creationDate\":1460697065909,\n" +
                "          \"modificationDate\":1460697066193,\n" +
                "          \"profile\":{\n" +
                "            \"hasAvatar\":\"true\"\n" +
                "          },\n" +
                "          \"enabled\":true,\n" +
                "          \"lastLoggedIn\":-1,\n" +
                "          \"lastProfileUpdate\":1460697066192,\n" +
                "          \"type\":\"REGULAR\",\n" +
                "          \"federated\":false,\n" +
                "          \"visible\":true,\n" +
                "          \"status\":\"registered\",\n" +
                "          \"url\":\"https://banzai-qe-people-places-brewspace-123-8.jivelandia.com/people/regularuser-brvcf8ng6qmy@example.com\"\n" +
                "        },\n" +
                "        \"shareModifiedDate\":1460697144805,\n" +
                "        \"shareStatus\":\"Published\",\n" +
                "        \"shareAuthors\":\"2185,2184\",\n" +
                "        \"shareSubject\":\"Hi,  Check out 'RobotGroup-ltohEfnXxiGg' in Jive.\",\n" +
                "        \"shareCreationDate\":1460697144805\n" +
                "      },\n" +
                "      \"tags\":[\n" +
                "\n" +
                "      ],\n" +
                "      \"name\":\"RobotGroup-ltohEfnXxiGg\",\n" +
                "      \"displayName\":\"robotgroup-ltohefnxxigg\",\n" +
                "      \"description\":\"jive-api-test group desc\",\n" +
                "      \"creationDate\":1460697062925,\n" +
                "      \"modificationDate\":1460697062925,\n" +
                "      \"url\":\"https://banzai-qe-people-places-brewspace-123-8.jivelandia.com/groups/robotgroup-ltohefnxxigg\",\n" +
                "      \"status\":\"ACTIVE\",\n" +
                "      \"isVisibleToPartner\":false,\n" +
                "      \"parentId\":17,\n" +
                "      \"parentType\":\"systemcontainer\",\n" +
                "      \"fullPath\":\"/systemcontainer_17/socialgroup_1062\",\n" +
                "      \"normalizedPath\":\"/socialgroup_1062\",\n" +
                "      \"combinedObjectTypeId\":\"700_1062\"\n" +
                "    },\n" +
                "    \"activityTime\":1460697144856,\n" +
                "    \"destination\":{\n" +
                "      \"@class\":\".ActivityDestination\",\n" +
                "      \"objectType\":\"usercontainer\",\n" +
                "      \"objectId\":1170,\n" +
                "      \"objectHash\":\"69163606995cbddb198ba8804ff04cce8189c2fe\",\n" +
                "      \"isDataAvailable\":true,\n" +
                "      \"extras\":{ },\n" +
                "      \"tags\":[\n" +
                "\n" +
                "      ],\n" +
                "      \"name\":\"regularUser-xdG1LFQSwR7j TestUser\",\n" +
                "      \"displayName\":\"regularuser-xdg1lfqswr7j@example.com\",\n" +
                "      \"description\":\"regularUser-xdG1LFQSwR7j TestUser\",\n" +
                "      \"creationDate\":1460697065306,\n" +
                "      \"modificationDate\":1460697065306,\n" +
                "      \"url\":\"https://banzai-qe-people-places-brewspace-123-8.jivelandia.com/people/regularuser-xdg1lfqswr7j@example.com\",\n" +
                "      \"status\":\"ACTIVE\",\n" +
                "      \"isVisibleToPartner\":false,\n" +
                "      \"parentId\":1,\n" +
                "      \"parentType\":\"community\",\n" +
                "      \"fullPath\":\"/community_1/usercontainer_1170\",\n" +
                "      \"normalizedPath\":\"/usercontainer_1170\",\n" +
                "      \"combinedObjectTypeId\":\"2020_1170\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"isHistoricalReplay\":false\n" +
                "}";
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
            "                     \"url\": \"https://sprinklr-qa.jiveon.com/people/snavaneeth%40sprinklr.com\",\n" +
            "                     \"publicationData\": []\n" +
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
    public void basicParse() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        EventDocument doc = mapper.readValue(badActor, EventDocument.class);
        System.err.println(doc);

    }

}
