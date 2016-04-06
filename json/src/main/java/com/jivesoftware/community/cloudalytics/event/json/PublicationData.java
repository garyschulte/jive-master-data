package com.jivesoftware.community.cloudalytics.event.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;


public class PublicationData {

    @JsonProperty
    private long publicationID;
    @JsonProperty
    private Collection<SubscriptionData> subscriptionData;

    public PublicationData() {

    }

    public PublicationData(long publicationID,
                           Collection<SubscriptionData> subscriptionData)
    {
        this.publicationID = publicationID;
        this.subscriptionData = subscriptionData;
    }

    public long getPublicationID() {
        return publicationID;
    }

    public Collection<SubscriptionData> getSubscriptionData() {
        return subscriptionData;
    }

    public void setPublicationID(long publicationID) {
        this.publicationID = publicationID;
    }

    public void setSubscriptionData(Collection<SubscriptionData> subscriptionData) {
        this.subscriptionData = subscriptionData;
    }

    public static class SubscriptionData {
        @JsonProperty
        private long subscriptionID;
        @JsonProperty
        private boolean subscribed;

        public SubscriptionData() {

        }

        public SubscriptionData(long subscriptionID, boolean subscribed) {
            this.subscriptionID = subscriptionID;
            this.subscribed = subscribed;
        }

        public long getSubscriptionID() {
            return subscriptionID;
        }

        public boolean isSubscribed() {
            return subscribed;
        }

        public void setSubscribed(boolean subscribed) {
            this.subscribed = subscribed;
        }

        public void setSubscriptionID(long subscriptionID) {
            this.subscriptionID = subscriptionID;
        }
    }


}
