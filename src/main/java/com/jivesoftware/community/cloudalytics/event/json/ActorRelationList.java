package com.jivesoftware.community.cloudalytics.event.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * tweaked to remove reference to jivecore userrelationships.  We don't really care about anything not
 * serialized/deserialized to/from the event documents as this is more of a reader
 */
public class ActorRelationList extends ActionObject implements Cloneable  {

    @JsonProperty
    private int size;
    @JsonProperty
    private String name;

    public void setSize(int size) {
        this.size = size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getSize() {
        return size;
    }

}
