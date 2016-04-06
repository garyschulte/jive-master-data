/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.jivesoftware.community.cloudalytics.event.avro;  
@SuppressWarnings("all")
/** *  END CONTENT ACTIVITY DEFINITIONS *** */
@org.apache.avro.specific.AvroGenerated
public class AvroAction extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -4629799312674303173L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AvroAction\",\"namespace\":\"com.jivesoftware.community.cloudalytics.event.avro\",\"doc\":\"*  END CONTENT ACTIVITY DEFINITIONS ***\",\"fields\":[{\"name\":\"class\",\"type\":{\"type\":\"string\",\"order\":\"ignore\"}},{\"name\":\"objectType\",\"type\":\"string\"},{\"name\":\"objectId\",\"type\":\"long\"},{\"name\":\"objectHash\",\"type\":\"string\"},{\"name\":\"isDataAvailable\",\"type\":\"boolean\"},{\"name\":\"tags\",\"type\":{\"type\":\"array\",\"items\":\"string\"}},{\"name\":\"extras\",\"type\":{\"type\":\"map\",\"values\":\"string\"}},{\"name\":\"extendedActionObject\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"AvroActor\",\"fields\":[{\"name\":\"class\",\"type\":{\"type\":\"string\",\"order\":\"ignore\"}},{\"name\":\"objectType\",\"type\":\"string\"},{\"name\":\"objectId\",\"type\":\"long\"},{\"name\":\"objectHash\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"isDataAvailable\",\"type\":\"boolean\"},{\"name\":\"tags\",\"type\":{\"type\":\"array\",\"items\":\"string\"}},{\"name\":\"extras\",\"type\":{\"type\":\"map\",\"values\":[\"string\",\"boolean\",\"long\"]}},{\"name\":\"profile\",\"type\":{\"type\":\"map\",\"values\":\"string\"}},{\"name\":\"username\",\"type\":\"string\"},{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"firstName\",\"type\":\"string\"},{\"name\":\"lastName\",\"type\":\"string\"},{\"name\":\"email\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"creationDate\",\"type\":\"long\"},{\"name\":\"modificationDate\",\"type\":\"long\"},{\"name\":\"enabled\",\"type\":\"boolean\"},{\"name\":\"lastLoggedIn\",\"type\":\"long\"},{\"name\":\"lastProfileUpdate\",\"type\":\"long\"},{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"federated\",\"type\":\"boolean\"},{\"name\":\"visible\",\"type\":\"boolean\"},{\"name\":\"status\",\"type\":\"string\"},{\"name\":\"url\",\"type\":\"string\"}],\"order\":\"ignore\"},{\"type\":\"record\",\"name\":\"AvroDestination\",\"fields\":[{\"name\":\"class\",\"type\":{\"type\":\"string\",\"order\":\"ignore\"}},{\"name\":\"objectType\",\"type\":\"string\"},{\"name\":\"objectId\",\"type\":\"long\"},{\"name\":\"objectHash\",\"type\":\"string\"},{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"extras\",\"type\":{\"type\":\"map\",\"values\":[\"string\",\"boolean\",\"long\"]}},{\"name\":\"tags\",\"type\":{\"type\":\"array\",\"items\":\"string\"}},{\"name\":\"displayName\",\"type\":\"string\"},{\"name\":\"description\",\"type\":\"string\"},{\"name\":\"url\",\"type\":\"string\"},{\"name\":\"status\",\"type\":\"string\"},{\"name\":\"fullPath\",\"type\":\"string\"},{\"name\":\"normalizedPath\",\"type\":\"string\"},{\"name\":\"combinedObjectTypeId\",\"type\":\"string\"},{\"name\":\"isDataAvailable\",\"type\":\"boolean\"},{\"name\":\"isVisibleToPartner\",\"type\":\"boolean\"},{\"name\":\"creationDate\",\"type\":\"long\"},{\"name\":\"modificationDate\",\"type\":\"long\"},{\"name\":\"parentId\",\"type\":\"long\"},{\"name\":\"parentType\",\"type\":\"string\"}]},{\"type\":\"record\",\"name\":\"AvroContent\",\"fields\":[{\"name\":\"subject\",\"type\":{\"type\":\"string\",\"order\":\"ignore\"}},{\"name\":\"creationDate\",\"type\":\"long\"},{\"name\":\"modificationDate\",\"type\":\"long\"},{\"name\":\"author\",\"type\":\"AvroActor\"},{\"name\":\"containerId\",\"type\":\"long\"},{\"name\":\"containerType\",\"type\":\"string\"},{\"name\":\"isVisibleToPartner\",\"type\":\"boolean\"},{\"name\":\"status\",\"type\":\"string\"},{\"name\":\"url\",\"type\":\"string\"},{\"name\":\"fullPath\",\"type\":\"string\"},{\"name\":\"normalizedPath\",\"type\":\"string\"},{\"name\":\"combinedObjectTypeId\",\"type\":\"string\"},{\"name\":\"contentElements\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"AvroComment\",\"doc\":\"****** BEGIN CONTENT ACTIVITY DEFINITIONS *********\",\"fields\":[{\"name\":\"parentCommentId\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"parentComment\",\"type\":[\"null\",\"string\"],\"default\":null}]},{\"type\":\"record\",\"name\":\"AvroQuestion\",\"fields\":[{\"name\":\"isQuestion\",\"type\":[\"boolean\"],\"default\":true},{\"name\":\"questionStatus\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"resolved\",\"type\":[\"null\",\"boolean\"],\"default\":null},{\"name\":\"assumedResolved\",\"type\":[\"null\",\"boolean\"],\"default\":null},{\"name\":\"open\",\"type\":[\"null\",\"boolean\"],\"default\":null},{\"name\":\"questionCreateDate\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"resolutionDate\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"numHelpfulAnswers\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"numReplies\",\"type\":[\"null\",\"int\"],\"default\":null}]},{\"type\":\"record\",\"name\":\"AvroThread\",\"fields\":[{\"name\":\"isQuestion\",\"type\":{\"type\":\"boolean\",\"order\":\"ignore\"},\"default\":false}]},{\"type\":\"record\",\"name\":\"AvroTask\",\"fields\":[{\"name\":\"completed\",\"type\":[\"null\",\"boolean\"],\"default\":null},{\"name\":\"dueDate\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"owner\",\"type\":[\"null\",\"AvroActor\"],\"default\":null},{\"name\":\"parentTask\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"AvroParentTask\",\"fields\":[{\"name\":\"class\",\"type\":{\"type\":\"string\",\"order\":\"ignore\"}},{\"name\":\"objectType\",\"type\":\"string\"},{\"name\":\"objectId\",\"type\":\"long\"},{\"name\":\"objectHash\",\"type\":\"string\"},{\"name\":\"isDataAvailable\",\"type\":\"boolean\"},{\"name\":\"tags\",\"type\":{\"type\":\"array\",\"items\":\"string\"}},{\"name\":\"extras\",\"type\":{\"type\":\"map\",\"values\":\"string\"}},{\"name\":\"completed\",\"type\":[\"null\",\"boolean\"],\"default\":null},{\"name\":\"dueDate\",\"type\":[\"null\",\"long\"],\"default\":null},{\"name\":\"owner\",\"type\":[\"null\",\"AvroActor\"],\"default\":null},{\"name\":\"parentTask\",\"type\":[\"null\",\"AvroParentTask\"],\"default\":null}]}],\"default\":null}]},{\"type\":\"record\",\"name\":\"AvroWallEntry\",\"fields\":[{\"name\":\"recipientIds\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"long\"}],\"default\":null},{\"name\":\"numRecipients\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"messageType\",\"type\":[\"null\",\"string\"],\"default\":null}]}]}]},{\"type\":\"record\",\"name\":\"AvroActorRelation\",\"fields\":[{\"name\":\"user\",\"type\":\"AvroActor\"},{\"name\":\"relatedUser\",\"type\":\"AvroActor\"},{\"name\":\"status\",\"type\":\"string\"},{\"name\":\"graphType\",\"type\":\"string\"},{\"name\":\"relation\",\"type\":\"string\"},{\"name\":\"creationDate\",\"type\":\"long\"},{\"name\":\"retiredDate\",\"type\":\"long\"}]},{\"type\":\"record\",\"name\":\"AvroActorRelationList\",\"fields\":[{\"name\":\"size\",\"type\":{\"type\":\"int\",\"order\":\"ignore\"}},{\"name\":\"name\",\"type\":\"string\"}]},{\"type\":\"record\",\"name\":\"AvroAppLoad\",\"fields\":[{\"name\":\"appName\",\"type\":{\"type\":\"string\",\"order\":\"ignore\"}},{\"name\":\"appURL\",\"type\":\"string\"},{\"name\":\"extensionUUID\",\"type\":\"string\"},{\"name\":\"isSynthetic\",\"type\":\"boolean\"},{\"name\":\"associatedObjectType\",\"type\":\"string\"},{\"name\":\"associatedObjectId\",\"type\":\"long\"},{\"name\":\"associatedName\",\"type\":\"string\"}]},{\"type\":\"record\",\"name\":\"AvroAttachment\",\"fields\":[{\"name\":\"mimeType\",\"type\":{\"type\":\"string\",\"order\":\"ignore\"}},{\"name\":\"fileName\",\"type\":\"string\"},{\"name\":\"attachmentSize\",\"type\":\"int\"},{\"name\":\"contentDataAvailable\",\"type\":\"boolean\"},{\"name\":\"creationDate\",\"type\":\"long\"},{\"name\":\"modificationDate\",\"type\":\"long\"}]},{\"type\":\"record\",\"name\":\"AvroExStorageFile\",\"fields\":[{\"name\":\"contentObjectType\",\"type\":{\"type\":\"string\",\"order\":\"ignore\"}},{\"name\":\"contentObjectId\",\"type\":\"long\"},{\"name\":\"definitionObjectType\",\"type\":\"string\"},{\"name\":\"definitionObjectId\",\"type\":\"long\"},{\"name\":\"definitionName\",\"type\":\"string\"},{\"name\":\"extensionUUID\",\"type\":\"string\"}]},{\"type\":\"record\",\"name\":\"AvroExStorageAttachment\",\"fields\":[{\"name\":\"definitionObjectType\",\"type\":{\"type\":\"string\",\"order\":\"ignore\"}},{\"name\":\"definitionObjectId\",\"type\":\"long\"},{\"name\":\"definitionName\",\"type\":\"string\"},{\"name\":\"extensionUUID\",\"type\":\"string\"}]},{\"type\":\"record\",\"name\":\"AvroExtension\",\"fields\":[{\"name\":\"extensionUUID\",\"type\":{\"type\":\"string\",\"order\":\"ignore\"}},{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"creationDate\",\"type\":\"long\"},{\"name\":\"deployDate\",\"type\":\"long\"},{\"name\":\"isLocal\",\"type\":\"boolean\"},{\"name\":\"status\",\"type\":\"string\"},{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"isVisibleToAll\",\"type\":\"boolean\"}]},{\"type\":\"record\",\"name\":\"AvroHistoricalReplayStatistics\",\"fields\":[{\"name\":\"state\",\"type\":{\"type\":\"string\",\"order\":\"ignore\"}},{\"name\":\"batchSize\",\"type\":\"int\"},{\"name\":\"batchIntervalMS\",\"type\":\"int\"},{\"name\":\"runId\",\"type\":\"string\"},{\"name\":\"stage\",\"type\":\"string\"},{\"name\":\"stageNumToProcess\",\"type\":\"long\"},{\"name\":\"stageStartTime\",\"type\":\"long\"},{\"name\":\"stageEndTime\",\"type\":\"long\"},{\"name\":\"stageProcessedCount\",\"type\":\"int\"},{\"name\":\"stageSentCount\",\"type\":\"int\"},{\"name\":\"stageDroppedCount\",\"type\":\"int\"},{\"name\":\"stageErrorCount\",\"type\":\"int\"},{\"name\":\"stageUnknownCodeCount\",\"type\":\"int\"},{\"name\":\"cursor\",\"type\":\"string\"},{\"name\":\"batchStartTime\",\"type\":\"long\"},{\"name\":\"batchNumFound\",\"type\":\"int\"},{\"name\":\"batchSentCount\",\"type\":\"int\"},{\"name\":\"batchDroppedCount\",\"type\":\"int\"},{\"name\":\"batchErrorCount\",\"type\":\"int\"},{\"","name\":\"batchUnknownCodeCount\",\"type\":\"int\"}]},{\"type\":\"record\",\"name\":\"AvroInvitation\",\"fields\":[{\"name\":\"invitationId\",\"type\":{\"type\":\"long\",\"order\":\"ignore\"}},{\"name\":\"invterUserName\",\"type\":\"string\"},{\"name\":\"inviterEmail\",\"type\":\"string\"},{\"name\":\"inviteeEmail\",\"type\":\"string\"},{\"name\":\"revokerUsername\",\"type\":\"string\"},{\"name\":\"state\",\"type\":\"string\"},{\"name\":\"sentDate\",\"type\":\"long\"},{\"name\":\"revokeDate\",\"type\":\"long\"},{\"name\":\"creationDate\",\"type\":\"long\"},{\"name\":\"modificationDate\",\"type\":\"long\"}]},{\"type\":\"record\",\"name\":\"AvroPlayboxQuest\",\"fields\":[{\"name\":\"questId\",\"type\":{\"type\":\"string\",\"order\":\"ignore\"}},{\"name\":\"taskId\",\"type\":\"string\"},{\"name\":\"secret\",\"type\":\"string\"},{\"name\":\"isApiRequest\",\"type\":\"boolean\"}]},{\"type\":\"record\",\"name\":\"AvroSearch\",\"fields\":[{\"name\":\"keywords\",\"type\":{\"type\":\"string\",\"order\":\"ignore\"}},{\"name\":\"searchSelectedId\",\"type\":\"long\"},{\"name\":\"searchSelectedType\",\"type\":\"string\"},{\"name\":\"queries\",\"type\":{\"type\":\"array\",\"items\":\"string\"}},{\"name\":\"searchFinalQuery\",\"type\":\"string\"}]},{\"type\":\"record\",\"name\":\"AvroSecurityGroup\",\"fields\":[{\"name\":\"name\",\"type\":{\"type\":\"string\",\"order\":\"ignore\"}},{\"name\":\"creationDate\",\"type\":\"long\"},{\"name\":\"modificationDate\",\"type\":\"long\"},{\"name\":\"federated\",\"type\":\"boolean\"}]},{\"type\":\"record\",\"name\":\"AvroTileInstance\",\"fields\":[{\"name\":\"tileDefinitionObjectType\",\"type\":{\"type\":\"string\",\"order\":\"ignore\"}},{\"name\":\"tileDefinitionObjectId\",\"type\":\"long\"},{\"name\":\"tileDefinitionName\",\"type\":\"string\"},{\"name\":\"tileDefinitionVisualType\",\"type\":\"string\"},{\"name\":\"isActivityStream\",\"type\":\"boolean\"},{\"name\":\"extensionUUID\",\"type\":\"string\"}]},{\"type\":\"record\",\"name\":\"AvroUserRewardBadge\",\"fields\":[{\"name\":\"badgeId\",\"type\":{\"type\":\"string\",\"order\":\"ignore\"}},{\"name\":\"userEmail\",\"type\":\"string\"},{\"name\":\"message\",\"type\":\"string\"},{\"name\":\"streamEntryId\",\"type\":\"string\"},{\"name\":\"streamEntryUrl\",\"type\":\"string\"}]}]}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence class$;
  @Deprecated public java.lang.CharSequence objectType;
  @Deprecated public long objectId;
  @Deprecated public java.lang.CharSequence objectHash;
  @Deprecated public boolean isDataAvailable;
  @Deprecated public java.util.List<java.lang.CharSequence> tags;
  @Deprecated public java.util.Map<java.lang.CharSequence,java.lang.CharSequence> extras;
  @Deprecated public java.lang.Object extendedActionObject;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public AvroAction() {}

  /**
   * All-args constructor.
   */
  public AvroAction(java.lang.CharSequence class$, java.lang.CharSequence objectType, java.lang.Long objectId, java.lang.CharSequence objectHash, java.lang.Boolean isDataAvailable, java.util.List<java.lang.CharSequence> tags, java.util.Map<java.lang.CharSequence,java.lang.CharSequence> extras, java.lang.Object extendedActionObject) {
    this.class$ = class$;
    this.objectType = objectType;
    this.objectId = objectId;
    this.objectHash = objectHash;
    this.isDataAvailable = isDataAvailable;
    this.tags = tags;
    this.extras = extras;
    this.extendedActionObject = extendedActionObject;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return class$;
    case 1: return objectType;
    case 2: return objectId;
    case 3: return objectHash;
    case 4: return isDataAvailable;
    case 5: return tags;
    case 6: return extras;
    case 7: return extendedActionObject;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: class$ = (java.lang.CharSequence)value$; break;
    case 1: objectType = (java.lang.CharSequence)value$; break;
    case 2: objectId = (java.lang.Long)value$; break;
    case 3: objectHash = (java.lang.CharSequence)value$; break;
    case 4: isDataAvailable = (java.lang.Boolean)value$; break;
    case 5: tags = (java.util.List<java.lang.CharSequence>)value$; break;
    case 6: extras = (java.util.Map<java.lang.CharSequence,java.lang.CharSequence>)value$; break;
    case 7: extendedActionObject = (java.lang.Object)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'class$' field.
   */
  public java.lang.CharSequence getClass$() {
    return class$;
  }

  /**
   * Sets the value of the 'class$' field.
   * @param value the value to set.
   */
  public void setClass$(java.lang.CharSequence value) {
    this.class$ = value;
  }

  /**
   * Gets the value of the 'objectType' field.
   */
  public java.lang.CharSequence getObjectType() {
    return objectType;
  }

  /**
   * Sets the value of the 'objectType' field.
   * @param value the value to set.
   */
  public void setObjectType(java.lang.CharSequence value) {
    this.objectType = value;
  }

  /**
   * Gets the value of the 'objectId' field.
   */
  public java.lang.Long getObjectId() {
    return objectId;
  }

  /**
   * Sets the value of the 'objectId' field.
   * @param value the value to set.
   */
  public void setObjectId(java.lang.Long value) {
    this.objectId = value;
  }

  /**
   * Gets the value of the 'objectHash' field.
   */
  public java.lang.CharSequence getObjectHash() {
    return objectHash;
  }

  /**
   * Sets the value of the 'objectHash' field.
   * @param value the value to set.
   */
  public void setObjectHash(java.lang.CharSequence value) {
    this.objectHash = value;
  }

  /**
   * Gets the value of the 'isDataAvailable' field.
   */
  public java.lang.Boolean getIsDataAvailable() {
    return isDataAvailable;
  }

  /**
   * Sets the value of the 'isDataAvailable' field.
   * @param value the value to set.
   */
  public void setIsDataAvailable(java.lang.Boolean value) {
    this.isDataAvailable = value;
  }

  /**
   * Gets the value of the 'tags' field.
   */
  public java.util.List<java.lang.CharSequence> getTags() {
    return tags;
  }

  /**
   * Sets the value of the 'tags' field.
   * @param value the value to set.
   */
  public void setTags(java.util.List<java.lang.CharSequence> value) {
    this.tags = value;
  }

  /**
   * Gets the value of the 'extras' field.
   */
  public java.util.Map<java.lang.CharSequence,java.lang.CharSequence> getExtras() {
    return extras;
  }

  /**
   * Sets the value of the 'extras' field.
   * @param value the value to set.
   */
  public void setExtras(java.util.Map<java.lang.CharSequence,java.lang.CharSequence> value) {
    this.extras = value;
  }

  /**
   * Gets the value of the 'extendedActionObject' field.
   */
  public java.lang.Object getExtendedActionObject() {
    return extendedActionObject;
  }

  /**
   * Sets the value of the 'extendedActionObject' field.
   * @param value the value to set.
   */
  public void setExtendedActionObject(java.lang.Object value) {
    this.extendedActionObject = value;
  }

  /**
   * Creates a new AvroAction RecordBuilder.
   * @return A new AvroAction RecordBuilder
   */
  public static com.jivesoftware.community.cloudalytics.event.avro.AvroAction.Builder newBuilder() {
    return new com.jivesoftware.community.cloudalytics.event.avro.AvroAction.Builder();
  }
  
  /**
   * Creates a new AvroAction RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new AvroAction RecordBuilder
   */
  public static com.jivesoftware.community.cloudalytics.event.avro.AvroAction.Builder newBuilder(com.jivesoftware.community.cloudalytics.event.avro.AvroAction.Builder other) {
    return new com.jivesoftware.community.cloudalytics.event.avro.AvroAction.Builder(other);
  }
  
  /**
   * Creates a new AvroAction RecordBuilder by copying an existing AvroAction instance.
   * @param other The existing instance to copy.
   * @return A new AvroAction RecordBuilder
   */
  public static com.jivesoftware.community.cloudalytics.event.avro.AvroAction.Builder newBuilder(com.jivesoftware.community.cloudalytics.event.avro.AvroAction other) {
    return new com.jivesoftware.community.cloudalytics.event.avro.AvroAction.Builder(other);
  }
  
  /**
   * RecordBuilder for AvroAction instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AvroAction>
    implements org.apache.avro.data.RecordBuilder<AvroAction> {

    private java.lang.CharSequence class$;
    private java.lang.CharSequence objectType;
    private long objectId;
    private java.lang.CharSequence objectHash;
    private boolean isDataAvailable;
    private java.util.List<java.lang.CharSequence> tags;
    private java.util.Map<java.lang.CharSequence,java.lang.CharSequence> extras;
    private java.lang.Object extendedActionObject;

    /** Creates a new Builder */
    private Builder() {
      super(com.jivesoftware.community.cloudalytics.event.avro.AvroAction.SCHEMA$);
    }
    
    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.jivesoftware.community.cloudalytics.event.avro.AvroAction.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.class$)) {
        this.class$ = data().deepCopy(fields()[0].schema(), other.class$);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.objectType)) {
        this.objectType = data().deepCopy(fields()[1].schema(), other.objectType);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.objectId)) {
        this.objectId = data().deepCopy(fields()[2].schema(), other.objectId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.objectHash)) {
        this.objectHash = data().deepCopy(fields()[3].schema(), other.objectHash);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.isDataAvailable)) {
        this.isDataAvailable = data().deepCopy(fields()[4].schema(), other.isDataAvailable);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.tags)) {
        this.tags = data().deepCopy(fields()[5].schema(), other.tags);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.extras)) {
        this.extras = data().deepCopy(fields()[6].schema(), other.extras);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.extendedActionObject)) {
        this.extendedActionObject = data().deepCopy(fields()[7].schema(), other.extendedActionObject);
        fieldSetFlags()[7] = true;
      }
    }
    
    /**
     * Creates a Builder by copying an existing AvroAction instance
     * @param other The existing instance to copy.
     */
    private Builder(com.jivesoftware.community.cloudalytics.event.avro.AvroAction other) {
            super(com.jivesoftware.community.cloudalytics.event.avro.AvroAction.SCHEMA$);
      if (isValidValue(fields()[0], other.class$)) {
        this.class$ = data().deepCopy(fields()[0].schema(), other.class$);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.objectType)) {
        this.objectType = data().deepCopy(fields()[1].schema(), other.objectType);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.objectId)) {
        this.objectId = data().deepCopy(fields()[2].schema(), other.objectId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.objectHash)) {
        this.objectHash = data().deepCopy(fields()[3].schema(), other.objectHash);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.isDataAvailable)) {
        this.isDataAvailable = data().deepCopy(fields()[4].schema(), other.isDataAvailable);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.tags)) {
        this.tags = data().deepCopy(fields()[5].schema(), other.tags);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.extras)) {
        this.extras = data().deepCopy(fields()[6].schema(), other.extras);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.extendedActionObject)) {
        this.extendedActionObject = data().deepCopy(fields()[7].schema(), other.extendedActionObject);
        fieldSetFlags()[7] = true;
      }
    }

    /**
      * Gets the value of the 'class$' field.
      * @return The value.
      */
    public java.lang.CharSequence getClass$() {
      return class$;
    }

    /**
      * Sets the value of the 'class$' field.
      * @param value The value of 'class$'.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroAction.Builder setClass$(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.class$ = value;
      fieldSetFlags()[0] = true;
      return this; 
    }

    /**
      * Checks whether the 'class$' field has been set.
      * @return True if the 'class$' field has been set, false otherwise.
      */
    public boolean hasClass$() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'class$' field.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroAction.Builder clearClass$() {
      class$ = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'objectType' field.
      * @return The value.
      */
    public java.lang.CharSequence getObjectType() {
      return objectType;
    }

    /**
      * Sets the value of the 'objectType' field.
      * @param value The value of 'objectType'.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroAction.Builder setObjectType(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.objectType = value;
      fieldSetFlags()[1] = true;
      return this; 
    }

    /**
      * Checks whether the 'objectType' field has been set.
      * @return True if the 'objectType' field has been set, false otherwise.
      */
    public boolean hasObjectType() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'objectType' field.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroAction.Builder clearObjectType() {
      objectType = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'objectId' field.
      * @return The value.
      */
    public java.lang.Long getObjectId() {
      return objectId;
    }

    /**
      * Sets the value of the 'objectId' field.
      * @param value The value of 'objectId'.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroAction.Builder setObjectId(long value) {
      validate(fields()[2], value);
      this.objectId = value;
      fieldSetFlags()[2] = true;
      return this; 
    }

    /**
      * Checks whether the 'objectId' field has been set.
      * @return True if the 'objectId' field has been set, false otherwise.
      */
    public boolean hasObjectId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'objectId' field.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroAction.Builder clearObjectId() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'objectHash' field.
      * @return The value.
      */
    public java.lang.CharSequence getObjectHash() {
      return objectHash;
    }

    /**
      * Sets the value of the 'objectHash' field.
      * @param value The value of 'objectHash'.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroAction.Builder setObjectHash(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.objectHash = value;
      fieldSetFlags()[3] = true;
      return this; 
    }

    /**
      * Checks whether the 'objectHash' field has been set.
      * @return True if the 'objectHash' field has been set, false otherwise.
      */
    public boolean hasObjectHash() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'objectHash' field.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroAction.Builder clearObjectHash() {
      objectHash = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'isDataAvailable' field.
      * @return The value.
      */
    public java.lang.Boolean getIsDataAvailable() {
      return isDataAvailable;
    }

    /**
      * Sets the value of the 'isDataAvailable' field.
      * @param value The value of 'isDataAvailable'.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroAction.Builder setIsDataAvailable(boolean value) {
      validate(fields()[4], value);
      this.isDataAvailable = value;
      fieldSetFlags()[4] = true;
      return this; 
    }

    /**
      * Checks whether the 'isDataAvailable' field has been set.
      * @return True if the 'isDataAvailable' field has been set, false otherwise.
      */
    public boolean hasIsDataAvailable() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'isDataAvailable' field.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroAction.Builder clearIsDataAvailable() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'tags' field.
      * @return The value.
      */
    public java.util.List<java.lang.CharSequence> getTags() {
      return tags;
    }

    /**
      * Sets the value of the 'tags' field.
      * @param value The value of 'tags'.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroAction.Builder setTags(java.util.List<java.lang.CharSequence> value) {
      validate(fields()[5], value);
      this.tags = value;
      fieldSetFlags()[5] = true;
      return this; 
    }

    /**
      * Checks whether the 'tags' field has been set.
      * @return True if the 'tags' field has been set, false otherwise.
      */
    public boolean hasTags() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'tags' field.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroAction.Builder clearTags() {
      tags = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'extras' field.
      * @return The value.
      */
    public java.util.Map<java.lang.CharSequence,java.lang.CharSequence> getExtras() {
      return extras;
    }

    /**
      * Sets the value of the 'extras' field.
      * @param value The value of 'extras'.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroAction.Builder setExtras(java.util.Map<java.lang.CharSequence,java.lang.CharSequence> value) {
      validate(fields()[6], value);
      this.extras = value;
      fieldSetFlags()[6] = true;
      return this; 
    }

    /**
      * Checks whether the 'extras' field has been set.
      * @return True if the 'extras' field has been set, false otherwise.
      */
    public boolean hasExtras() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'extras' field.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroAction.Builder clearExtras() {
      extras = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'extendedActionObject' field.
      * @return The value.
      */
    public java.lang.Object getExtendedActionObject() {
      return extendedActionObject;
    }

    /**
      * Sets the value of the 'extendedActionObject' field.
      * @param value The value of 'extendedActionObject'.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroAction.Builder setExtendedActionObject(java.lang.Object value) {
      validate(fields()[7], value);
      this.extendedActionObject = value;
      fieldSetFlags()[7] = true;
      return this; 
    }

    /**
      * Checks whether the 'extendedActionObject' field has been set.
      * @return True if the 'extendedActionObject' field has been set, false otherwise.
      */
    public boolean hasExtendedActionObject() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'extendedActionObject' field.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroAction.Builder clearExtendedActionObject() {
      extendedActionObject = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    @Override
    public AvroAction build() {
      try {
        AvroAction record = new AvroAction();
        record.class$ = fieldSetFlags()[0] ? this.class$ : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.objectType = fieldSetFlags()[1] ? this.objectType : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.objectId = fieldSetFlags()[2] ? this.objectId : (java.lang.Long) defaultValue(fields()[2]);
        record.objectHash = fieldSetFlags()[3] ? this.objectHash : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.isDataAvailable = fieldSetFlags()[4] ? this.isDataAvailable : (java.lang.Boolean) defaultValue(fields()[4]);
        record.tags = fieldSetFlags()[5] ? this.tags : (java.util.List<java.lang.CharSequence>) defaultValue(fields()[5]);
        record.extras = fieldSetFlags()[6] ? this.extras : (java.util.Map<java.lang.CharSequence,java.lang.CharSequence>) defaultValue(fields()[6]);
        record.extendedActionObject = fieldSetFlags()[7] ? this.extendedActionObject : (java.lang.Object) defaultValue(fields()[7]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);  

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, org.apache.avro.specific.SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);  

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, org.apache.avro.specific.SpecificData.getDecoder(in));
  }

}