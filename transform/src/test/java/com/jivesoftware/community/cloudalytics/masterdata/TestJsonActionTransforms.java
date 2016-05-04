package com.jivesoftware.community.cloudalytics.masterdata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jivesoftware.community.cloudalytics.masterdata.avro.AvroAction;
import com.jivesoftware.community.cloudalytics.masterdata.jsonschema.ActionObject;
import com.jivesoftware.community.cloudalytics.masterdata.util.Avro2JsonCloner;
import com.jivesoftware.community.cloudalytics.masterdata.util.Json2AvroCloner;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.reflections.Reflections;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import uk.co.jemos.podam.api.DefaultClassInfoStrategy;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.io.IOException;
import java.util.Set;

import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

/**
 * Created by gary.schulte on 4/25/16.
 * test each/all polymorphic action objects via randomized inputs and comparing their JSON serialized output
 */
@RunWith(Parameterized.class)
public class TestJsonActionTransforms {

    ObjectMapper mapper = new ObjectMapper();
    PodamFactory factory = new PodamFactoryImpl();
    Class<? extends ActionObject> actionType = null;

    @Before
    public void setup(){
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        ((DefaultClassInfoStrategy)factory.getClassStrategy()).addExcludedAnnotation(JsonIgnore.class);
    }

    public TestJsonActionTransforms(Class<? extends ActionObject> actionType){
        this.actionType = actionType;
    }

    @Parameterized.Parameters
    public static Set<Class<? extends ActionObject>> polymorphicActionTypes()  {

        Reflections reflections = new Reflections("com.jivesoftware.community.cloudalytics.masterdata.jsonschema");
        Set <Class<? extends ActionObject>> actionObjectTypes = reflections.getSubTypesOf(ActionObject.class);
        if (actionObjectTypes.size() <1) {
            throw new RuntimeException("jsonschema pojo types not found in classpath");
        }
        return actionObjectTypes;
    }

    @Test
    public void smokeJsonActionTypes() throws IllegalAccessException, InstantiationException, IOException, JSONException, ParseException {

        // generate randomized actionobject, serialize and deserialize to get bogus object refs in maps
        ActionObject junkObj = factory.manufacturePojo(actionType);
        String junkDoc = " " + mapper.writeValueAsString(junkObj) ;

        ActionObject actionObj = mapper.readValue(junkDoc, ActionObject.class);
        AvroAction avroAction = Json2AvroCloner.clone(actionObj);

        ActionObject xformedActionObj = Avro2JsonCloner.clone(avroAction);
        //Assert bidirectionally transformed json pojo is identical to original pojo
        assertReflectionEquals(actionObj, xformedActionObj);

        //just for completeness sake, serialize to json and do a json comparison
        String actionJson = mapper.writeValueAsString(actionObj);
        String xformedJson = mapper.writeValueAsString(xformedActionObj);
        JSONAssert.assertEquals(actionJson, xformedJson, JSONCompareMode.LENIENT);

    }

}