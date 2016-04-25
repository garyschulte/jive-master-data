package com.jivesoftware.community.cloudalytics.masterdata;

import com.jivesoftware.community.cloudalytics.masterdata.avro.AvroAction;
import com.jivesoftware.community.cloudalytics.masterdata.avro.AvroContent;
import com.jivesoftware.community.cloudalytics.masterdata.jsonschema.ActionObject;
import com.jivesoftware.community.cloudalytics.masterdata.jsonschema.ActivityContent;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.Provider;
import org.modelmapper.convention.MatchingStrategies;

/**
 * Created by gary.schulte on 4/7/16.
 */
public class AvroToJsonMapper {

    private static ModelMapper
            avroToJsonModelMapper = null
            ,helperModelMapper = null;

    public static <D> D map(Object avroSource, Class<D> jsonDestClass) {
        return getAvroToJsonMapper().map(avroSource, jsonDestClass);
    }

    private static ModelMapper getAvroToJsonMapper() {
        if (avroToJsonModelMapper == null) {
            avroToJsonModelMapper = new ModelMapper();
            //TODO: remove ambiguity ignored if possible
            //avroToJsonModelMapper.getConfiguration().setAmbiguityIgnored(true);


            Provider<ActionObject> delegatingProvider = new Provider<ActionObject>() {
                public ActionObject get(ProvisionRequest<ActionObject> request) {
                    ActionObject ao = null;

                    if (request.getSource() instanceof AvroAction) {
                        AvroAction source = (AvroAction) request.getSource();
                        String sourceObjType = source.getClass$().toString();
                        if (sourceObjType != null) {
                            try {
                                //TODO: so dirty
                                Class clazz = Class.forName(ActionObject.class.getPackage().getName() + "." + sourceObjType);
                                //ao = (ActionObject) clazz.newInstance();

                                ao = (ActionObject) getHelperMapper().map(source.getExtendedActionObject(), clazz);

                                // TODO: fixme, special case bs here.  ugly ugly.
                                switch (sourceObjType) {
                                    case "ActivityContent" :
                                        ((ActivityContent)ao).setModifiedDate(((AvroContent)source.getExtendedActionObject()).getModificationDate());
                                        break;
                                }

                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        // let modelmapper do the construction if requested object is not ActionObject
                    }

                    return ao;
                }
            };

            avroToJsonModelMapper.getConfiguration().setProvider(delegatingProvider);

/*
            avroToJsonModelMapper.addMappings(new PropertyMap<AvroActivity, AnalyticsActivity>() {
                @Override
                protected void configure() {

                    // explicitly define a converter for ActionObject to Avro Union Object type
                    AbstractConverter actionObjectConverter = new AbstractConverter<AvroAction, ActionObject>() {
                        @Override
                        protected ActionObject convert(AvroAction source) {
                            ActionObject ao = null;

                            if (source instanceof AvroAction) {
                                String sourceObjType = ((AvroAction) source).getClass$().toString();
                                if (sourceObjType != null) {
                                    try {
                                        Class clazz = Class.forName(ActionObject.class.getPackage().getName() + "." + sourceObjType);
                                        ao = (ActionObject) getHelperMapper().map(source.getExtendedActionObject(), clazz);
                                        ao.setObjectId(source.getObjectId());
                                        ao.setIsDataAvailable(source.getIsDataAvailable());
                                        ao.setObjectHash(source.getObjectHash().toString());
                                        ao.setObjectType(source.getObjectType().toString());

                                        //ao.setTags(source.getTags());
                                        //ao.setExtras(source.getExtras());

                                    } catch (ClassNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            return ao;
                        }
                    };


//                    using(actionObjectConverter).map(source.getActionObject()).setActionObject(null);
//                    map(source.getActivity().getActionObject().getExtendedActionObject()).setActivity
                }
            });
*/

        }

        return avroToJsonModelMapper;
    }

    static <D extends ActionObject> ModelMapper getHelperMapper() {
        if (helperModelMapper == null) {
            helperModelMapper = new ModelMapper();
            //helperModelMapper.getConfiguration().setFieldMatchingEnabled(true);
            helperModelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            helperModelMapper.getConfiguration().setAmbiguityIgnored(true);
            helperModelMapper.addMappings(new PropertyMap<AvroAction, D>() {
                @Override
                protected void configure() {
                    skip().setObjectId(null);
                    skip().setObjectType(null);
                    skip().setObjectHash(null);
                    skip().setIsDataAvailable(true);
                    skip().setExtras(null);
                    skip().setTags(null);
                }
            });
        }
        return helperModelMapper;
    }

}
