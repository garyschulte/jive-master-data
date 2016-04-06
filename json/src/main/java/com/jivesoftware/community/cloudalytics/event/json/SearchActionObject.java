/*
 * Copyright (C) 1999-2015 Jive Software. All rights reserved.
 *
 * This software is the proprietary information of Jive Software. Use is subject to license terms.
 */
package com.jivesoftware.community.cloudalytics.event.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SearchActionObject extends ActionObject implements Cloneable {

    @JsonProperty
    private String keywords;
    @JsonProperty
    private Long searchSelectedId;
    @JsonProperty
    private String searchSelectedType;
    @JsonProperty
    private List<String> queries;
    @JsonProperty
    private String searchFinalQuery;



    public SearchActionObject() {
        super.isDataAvailable = true; // Data is always available
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public boolean getIsDataAvailable() {
        return true; // Data is always available.
    }

    public void setIsDataAvailable(boolean dataAvailable) {
        // Ignored
    }

    public Long getSearchSelectedId() {
        return searchSelectedId;
    }

    public void setSearchSelectedId(Long searchSelectedId) {
        this.searchSelectedId = searchSelectedId;
    }

    public String getSearchSelectedType() {
        return searchSelectedType;
    }

    public void setSearchSelectedType(String searchSelectedType) {
        this.searchSelectedType = searchSelectedType;
    }

    public List<String> getQueries() {
        return queries;
    }

    public void setQueries(List<String> queries) {
        this.queries = queries;
    }

    public String getSearchFinalQuery() { return searchFinalQuery; }

    public void setSearchFinalQuery(String searchFinalQuery) { this.searchFinalQuery = searchFinalQuery; }
}
