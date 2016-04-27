package com.jivesoftware.community.cloudalytics.masterdata.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * static conversion methods for convenience
 */
public class AvroCollectionsHelper {
    static ObjectMapper jsonMapper = new ObjectMapper();

    /* utility conversion methods */

    public static <DestType, SourceType> List<DestType> eraseListType(List<SourceType> lst) {
        List<DestType> chrList = null;
        if (lst != null) {
            chrList = new ArrayList<>();
            for (SourceType str : lst) {
                chrList.add((DestType) str);
            }
        }
        return chrList;
    }



    /* Support flattening complex maps to <CharSequence, CharSequece> for simplicity of avro transformation */
    public static <KSource,VSource> Map<CharSequence,CharSequence> flattenToJsonMap(Map<KSource, VSource> strMap) {
        Map<CharSequence, CharSequence> charseqMap = null;
        jsonMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        if (strMap != null) {
            charseqMap = new LinkedHashMap<>();
            for (Map.Entry<KSource, VSource> entry : strMap.entrySet()) {
                try {
                    charseqMap.put(entry.getKey().toString(), jsonMapper.writeValueAsString(entry.getValue()));
                } catch (JsonProcessingException jpex) {
                    throw new RuntimeException(jpex);
                }
            }
        }
        return charseqMap;
    }

    public static <T_Key, T_Value, S_Key, S_Value> Map<T_Key, T_Value> eraseMapType(Map<S_Key, S_Value> strMap) {
        Map<T_Key, T_Value> charseqMap = null;
        if (strMap != null) {
            charseqMap = new LinkedHashMap<>();
            for (Map.Entry<S_Key, S_Value> entry : strMap.entrySet()) {
                charseqMap.put((T_Key)entry.getKey(), (T_Value) entry.getValue());
            }
        }
        return charseqMap;
    }

    /* transform nested string/charsequence maps, e.g. context elements */
    public static <T_OuterKey, T_InnerKey, T_InnerValue, S_OuterKey, S_InnerKey, S_InnerValue>
    Map<T_OuterKey, Map<T_InnerKey, T_InnerValue>> eraseNestedMapType(Map<S_OuterKey, Map<S_InnerKey, S_InnerValue>> strMap) {
        Map<T_OuterKey, Map<T_InnerKey, T_InnerValue>> charseqMap = null;
        if (strMap != null) {
            charseqMap = new LinkedHashMap<>();
            for (Map.Entry<S_OuterKey, Map<S_InnerKey, S_InnerValue>> entry : strMap.entrySet()) {
                charseqMap.put((T_OuterKey)entry.getKey(), eraseMapType(entry.getValue()));
            }
        }
        return charseqMap;
    }

    public static Map<String, Object> unflattenJsonMap(Map<CharSequence, CharSequence> flatMap) {
        Map<String, Object> ret = null;
        if (flatMap != null) {
            ret = new LinkedHashMap<>();
            for(Map.Entry<CharSequence, CharSequence> entry : flatMap.entrySet()) {
                try {
                    ret.put(entry.getKey().toString(), jsonMapper.readValue(entry.getValue().toString(), Object.class));
                } catch (IOException ioe) {
                    throw new RuntimeException(ioe);
                }
            }
        }

        return ret;
    }

    public static String safeToString(CharSequence chr) {
        if (chr != null) {
            return chr.toString();
        }
        return null;
    }
}
