/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.jivesoftware.community.cloudalytics.event.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class AvroWallEntry extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -2937994986401434635L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AvroWallEntry\",\"namespace\":\"com.jivesoftware.community.cloudalytics.event.avro\",\"fields\":[{\"name\":\"recipientIds\",\"type\":[\"null\",{\"type\":\"array\",\"items\":\"long\"}],\"default\":null},{\"name\":\"numRecipients\",\"type\":[\"null\",\"int\"],\"default\":null},{\"name\":\"messageType\",\"type\":[\"null\",\"string\"],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.util.List<java.lang.Long> recipientIds;
  @Deprecated public java.lang.Integer numRecipients;
  @Deprecated public java.lang.CharSequence messageType;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public AvroWallEntry() {}

  /**
   * All-args constructor.
   */
  public AvroWallEntry(java.util.List<java.lang.Long> recipientIds, java.lang.Integer numRecipients, java.lang.CharSequence messageType) {
    this.recipientIds = recipientIds;
    this.numRecipients = numRecipients;
    this.messageType = messageType;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return recipientIds;
    case 1: return numRecipients;
    case 2: return messageType;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: recipientIds = (java.util.List<java.lang.Long>)value$; break;
    case 1: numRecipients = (java.lang.Integer)value$; break;
    case 2: messageType = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'recipientIds' field.
   */
  public java.util.List<java.lang.Long> getRecipientIds() {
    return recipientIds;
  }

  /**
   * Sets the value of the 'recipientIds' field.
   * @param value the value to set.
   */
  public void setRecipientIds(java.util.List<java.lang.Long> value) {
    this.recipientIds = value;
  }

  /**
   * Gets the value of the 'numRecipients' field.
   */
  public java.lang.Integer getNumRecipients() {
    return numRecipients;
  }

  /**
   * Sets the value of the 'numRecipients' field.
   * @param value the value to set.
   */
  public void setNumRecipients(java.lang.Integer value) {
    this.numRecipients = value;
  }

  /**
   * Gets the value of the 'messageType' field.
   */
  public java.lang.CharSequence getMessageType() {
    return messageType;
  }

  /**
   * Sets the value of the 'messageType' field.
   * @param value the value to set.
   */
  public void setMessageType(java.lang.CharSequence value) {
    this.messageType = value;
  }

  /**
   * Creates a new AvroWallEntry RecordBuilder.
   * @return A new AvroWallEntry RecordBuilder
   */
  public static com.jivesoftware.community.cloudalytics.event.avro.AvroWallEntry.Builder newBuilder() {
    return new com.jivesoftware.community.cloudalytics.event.avro.AvroWallEntry.Builder();
  }
  
  /**
   * Creates a new AvroWallEntry RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new AvroWallEntry RecordBuilder
   */
  public static com.jivesoftware.community.cloudalytics.event.avro.AvroWallEntry.Builder newBuilder(com.jivesoftware.community.cloudalytics.event.avro.AvroWallEntry.Builder other) {
    return new com.jivesoftware.community.cloudalytics.event.avro.AvroWallEntry.Builder(other);
  }
  
  /**
   * Creates a new AvroWallEntry RecordBuilder by copying an existing AvroWallEntry instance.
   * @param other The existing instance to copy.
   * @return A new AvroWallEntry RecordBuilder
   */
  public static com.jivesoftware.community.cloudalytics.event.avro.AvroWallEntry.Builder newBuilder(com.jivesoftware.community.cloudalytics.event.avro.AvroWallEntry other) {
    return new com.jivesoftware.community.cloudalytics.event.avro.AvroWallEntry.Builder(other);
  }
  
  /**
   * RecordBuilder for AvroWallEntry instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AvroWallEntry>
    implements org.apache.avro.data.RecordBuilder<AvroWallEntry> {

    private java.util.List<java.lang.Long> recipientIds;
    private java.lang.Integer numRecipients;
    private java.lang.CharSequence messageType;

    /** Creates a new Builder */
    private Builder() {
      super(com.jivesoftware.community.cloudalytics.event.avro.AvroWallEntry.SCHEMA$);
    }
    
    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.jivesoftware.community.cloudalytics.event.avro.AvroWallEntry.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.recipientIds)) {
        this.recipientIds = data().deepCopy(fields()[0].schema(), other.recipientIds);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.numRecipients)) {
        this.numRecipients = data().deepCopy(fields()[1].schema(), other.numRecipients);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.messageType)) {
        this.messageType = data().deepCopy(fields()[2].schema(), other.messageType);
        fieldSetFlags()[2] = true;
      }
    }
    
    /**
     * Creates a Builder by copying an existing AvroWallEntry instance
     * @param other The existing instance to copy.
     */
    private Builder(com.jivesoftware.community.cloudalytics.event.avro.AvroWallEntry other) {
            super(com.jivesoftware.community.cloudalytics.event.avro.AvroWallEntry.SCHEMA$);
      if (isValidValue(fields()[0], other.recipientIds)) {
        this.recipientIds = data().deepCopy(fields()[0].schema(), other.recipientIds);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.numRecipients)) {
        this.numRecipients = data().deepCopy(fields()[1].schema(), other.numRecipients);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.messageType)) {
        this.messageType = data().deepCopy(fields()[2].schema(), other.messageType);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'recipientIds' field.
      * @return The value.
      */
    public java.util.List<java.lang.Long> getRecipientIds() {
      return recipientIds;
    }

    /**
      * Sets the value of the 'recipientIds' field.
      * @param value The value of 'recipientIds'.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroWallEntry.Builder setRecipientIds(java.util.List<java.lang.Long> value) {
      validate(fields()[0], value);
      this.recipientIds = value;
      fieldSetFlags()[0] = true;
      return this; 
    }

    /**
      * Checks whether the 'recipientIds' field has been set.
      * @return True if the 'recipientIds' field has been set, false otherwise.
      */
    public boolean hasRecipientIds() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'recipientIds' field.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroWallEntry.Builder clearRecipientIds() {
      recipientIds = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'numRecipients' field.
      * @return The value.
      */
    public java.lang.Integer getNumRecipients() {
      return numRecipients;
    }

    /**
      * Sets the value of the 'numRecipients' field.
      * @param value The value of 'numRecipients'.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroWallEntry.Builder setNumRecipients(java.lang.Integer value) {
      validate(fields()[1], value);
      this.numRecipients = value;
      fieldSetFlags()[1] = true;
      return this; 
    }

    /**
      * Checks whether the 'numRecipients' field has been set.
      * @return True if the 'numRecipients' field has been set, false otherwise.
      */
    public boolean hasNumRecipients() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'numRecipients' field.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroWallEntry.Builder clearNumRecipients() {
      numRecipients = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'messageType' field.
      * @return The value.
      */
    public java.lang.CharSequence getMessageType() {
      return messageType;
    }

    /**
      * Sets the value of the 'messageType' field.
      * @param value The value of 'messageType'.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroWallEntry.Builder setMessageType(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.messageType = value;
      fieldSetFlags()[2] = true;
      return this; 
    }

    /**
      * Checks whether the 'messageType' field has been set.
      * @return True if the 'messageType' field has been set, false otherwise.
      */
    public boolean hasMessageType() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'messageType' field.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroWallEntry.Builder clearMessageType() {
      messageType = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    public AvroWallEntry build() {
      try {
        AvroWallEntry record = new AvroWallEntry();
        record.recipientIds = fieldSetFlags()[0] ? this.recipientIds : (java.util.List<java.lang.Long>) defaultValue(fields()[0]);
        record.numRecipients = fieldSetFlags()[1] ? this.numRecipients : (java.lang.Integer) defaultValue(fields()[1]);
        record.messageType = fieldSetFlags()[2] ? this.messageType : (java.lang.CharSequence) defaultValue(fields()[2]);
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