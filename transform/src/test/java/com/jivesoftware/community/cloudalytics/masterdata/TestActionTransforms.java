package com.jivesoftware.community.cloudalytics.masterdata;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jivesoftware.community.cloudalytics.masterdata.avro.AvroAction;
import com.jivesoftware.community.cloudalytics.masterdata.jsonschema.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.reflections.Reflections;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.util.Set;

/**
 * Created by gary.schulte on 4/25/16.
 */
@RunWith(Parameterized.class)
public class TestActionTransforms {

    ObjectMapper mapper = new ObjectMapper();
    PodamFactory factory = new PodamFactoryImpl();
    Class<? extends ActionObject> actionType = null;


    public TestActionTransforms(Class<? extends ActionObject> actionType){
        this.actionType = actionType;
    }

    @Parameterized.Parameters
    public static Set<Class<? extends ActionObject>> polymorphicActionTypes()  {

        Reflections reflections = new Reflections();
        Set <Class<? extends ActionObject>> actionObjectTypes = reflections.getSubTypesOf(ActionObject.class);
        if (actionObjectTypes.size() <1) {
            throw new RuntimeException("jsonschema pojo types not found in classpath");
        }
        return actionObjectTypes;
    }

    @Test
    public void smokeEachActionType() throws IllegalAccessException, InstantiationException, JsonProcessingException {
        System.out.println(actionType.getName());
        ActionObject actionObj = factory.manufacturePojo(actionType);
        AvroAction avroAction = JsonAvroCloner.decompose(actionObj);

        System.out.println(avroAction);
        //String actionJson = mapper.writeValueAsString(actionObj);
        //JSONAssert.assertEquals(testDoc, docReSerialized, JSONCompareMode.LENIENT);

    }



}
