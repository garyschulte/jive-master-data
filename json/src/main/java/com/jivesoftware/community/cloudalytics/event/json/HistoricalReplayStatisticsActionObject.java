/*
 * Copyright (C) 1999-2015 Jive Software. All rights reserved.
 *
 * This software is the proprietary information of Jive Software. Use is subject to license terms.
 */
package com.jivesoftware.community.cloudalytics.event.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HistoricalReplayStatisticsActionObject extends ActionObject {

    // Environment
    @JsonProperty
    private String state;
    @JsonProperty
    private int batchSize;
    @JsonProperty
    private int batchIntervalMS;

    // Run info
    @JsonProperty
    private String runId;

    // Stage Info
    @JsonProperty
    private String stage;
    @JsonProperty
    private Long stageNumToProcess;
    @JsonProperty
    private Long stageStartTime;
    @JsonProperty
    private Long stageEndTime;
    @JsonProperty
    private Integer stageProcessedCount;
    @JsonProperty
    private Integer stageSentCount;
    @JsonProperty
    private Integer stageDroppedCount;
    @JsonProperty
    private Integer stageErrorCount;
    @JsonProperty
    private Integer stageUnknownCodeCount;

    // Cursor position
    @JsonProperty
    private String cursor;

    // Batch info
    @JsonProperty
    private Long batchStartTime;
    @JsonProperty
    private Integer batchNumFound;
    @JsonProperty
    private Integer batchSentCount;
    @JsonProperty
    private Integer batchDroppedCount;
    @JsonProperty
    private Integer batchErrorCount;
    @JsonProperty
    private Integer batchUnknownCodeCount;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }

    public int getBatchIntervalMS() {
        return batchIntervalMS;
    }

    public void setBatchIntervalMS(int batchIntervalSeconds) {
        this.batchIntervalMS = batchIntervalSeconds;
    }

    public String getRunId() {
        return runId;
    }

    public void setRunId(String runId) {
        this.runId = runId;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public Long getStageNumToProcess() {
        return stageNumToProcess;
    }

    public void setStageNumToProcess(Long stageNumToProcess) {
        this.stageNumToProcess = stageNumToProcess;
    }

    public Long getStageStartTime() {
        return stageStartTime;
    }

    public void setStageStartTime(Long stageStartTime) {
        this.stageStartTime = stageStartTime;
    }

    public Long getStageEndTime() {
        return stageEndTime;
    }

    public void setStageEndTime(Long stageEndTime) {
        this.stageEndTime = stageEndTime;
    }

    public Integer getStageProcessedCount() {
        return stageProcessedCount;
    }

    public void setStageProcessedCount(Integer stageProcessedCount) {
        this.stageProcessedCount = stageProcessedCount;
    }

    public Integer getStageSentCount() {
        return stageSentCount;
    }

    public void setStageSentCount(Integer stageSentCount) {
        this.stageSentCount = stageSentCount;
    }

    public Integer getStageDroppedCount() {
        return stageDroppedCount;
    }

    public void setStageDroppedCount(Integer stageDroppedCount) {
        this.stageDroppedCount = stageDroppedCount;
    }

    public Integer getStageErrorCount() {
        return stageErrorCount;
    }

    public void setStageErrorCount(Integer stageErrorCount) {
        this.stageErrorCount = stageErrorCount;
    }

    public Integer getStageUnknownCodeCount() {
        return stageUnknownCodeCount;
    }

    public void setStageUnknownCodeCount(Integer stageUnknownCodeCount) {
        this.stageUnknownCodeCount = stageUnknownCodeCount;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public Integer getBatchNumFound() {
        return batchNumFound;
    }

    public void setBatchNumFound(Integer batchNumFound) {
        this.batchNumFound = batchNumFound;
    }

    public Integer getBatchSentCount() {
        return batchSentCount;
    }

    public void setBatchSentCount(Integer batchSentCount) {
        this.batchSentCount = batchSentCount;
    }

    public Integer getBatchDroppedCount() {
        return batchDroppedCount;
    }

    public void setBatchDroppedCount(Integer batchDroppedCount) {
        this.batchDroppedCount = batchDroppedCount;
    }

    public Integer getBatchErrorCount() {
        return batchErrorCount;
    }

    public void setBatchErrorCount(Integer batchErrorCount) {
        this.batchErrorCount = batchErrorCount;
    }

    public void setBatchStartTime(Long batchStartTime) {
        this.batchStartTime = batchStartTime;
    }

    public Long getBatchStartTime() {
        return batchStartTime;
    }

    public Integer getBatchUnknownCodeCount() {
        return batchUnknownCodeCount;
    }

    public void setBatchUnknownCodeCount(Integer batchUnknownCodeCount) {
        this.batchUnknownCodeCount = batchUnknownCodeCount;
    }
}
