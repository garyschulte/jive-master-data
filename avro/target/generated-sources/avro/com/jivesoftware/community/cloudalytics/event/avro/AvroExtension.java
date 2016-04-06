/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.jivesoftware.community.cloudalytics.event.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class AvroExtension extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -3359877729892745535L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AvroExtension\",\"namespace\":\"com.jivesoftware.community.cloudalytics.event.avro\",\"fields\":[{\"name\":\"extensionUUID\",\"type\":{\"type\":\"string\",\"order\":\"ignore\"}},{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"creationDate\",\"type\":\"long\"},{\"name\":\"deployDate\",\"type\":\"long\"},{\"name\":\"isLocal\",\"type\":\"boolean\"},{\"name\":\"status\",\"type\":\"string\"},{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"isVisibleToAll\",\"type\":\"boolean\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.lang.CharSequence extensionUUID;
  @Deprecated public java.lang.CharSequence name;
  @Deprecated public long creationDate;
  @Deprecated public long deployDate;
  @Deprecated public boolean isLocal;
  @Deprecated public java.lang.CharSequence status;
  @Deprecated public java.lang.CharSequence type;
  @Deprecated public boolean isVisibleToAll;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public AvroExtension() {}

  /**
   * All-args constructor.
   */
  public AvroExtension(java.lang.CharSequence extensionUUID, java.lang.CharSequence name, java.lang.Long creationDate, java.lang.Long deployDate, java.lang.Boolean isLocal, java.lang.CharSequence status, java.lang.CharSequence type, java.lang.Boolean isVisibleToAll) {
    this.extensionUUID = extensionUUID;
    this.name = name;
    this.creationDate = creationDate;
    this.deployDate = deployDate;
    this.isLocal = isLocal;
    this.status = status;
    this.type = type;
    this.isVisibleToAll = isVisibleToAll;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return extensionUUID;
    case 1: return name;
    case 2: return creationDate;
    case 3: return deployDate;
    case 4: return isLocal;
    case 5: return status;
    case 6: return type;
    case 7: return isVisibleToAll;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: extensionUUID = (java.lang.CharSequence)value$; break;
    case 1: name = (java.lang.CharSequence)value$; break;
    case 2: creationDate = (java.lang.Long)value$; break;
    case 3: deployDate = (java.lang.Long)value$; break;
    case 4: isLocal = (java.lang.Boolean)value$; break;
    case 5: status = (java.lang.CharSequence)value$; break;
    case 6: type = (java.lang.CharSequence)value$; break;
    case 7: isVisibleToAll = (java.lang.Boolean)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'extensionUUID' field.
   */
  public java.lang.CharSequence getExtensionUUID() {
    return extensionUUID;
  }

  /**
   * Sets the value of the 'extensionUUID' field.
   * @param value the value to set.
   */
  public void setExtensionUUID(java.lang.CharSequence value) {
    this.extensionUUID = value;
  }

  /**
   * Gets the value of the 'name' field.
   */
  public java.lang.CharSequence getName() {
    return name;
  }

  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Gets the value of the 'creationDate' field.
   */
  public java.lang.Long getCreationDate() {
    return creationDate;
  }

  /**
   * Sets the value of the 'creationDate' field.
   * @param value the value to set.
   */
  public void setCreationDate(java.lang.Long value) {
    this.creationDate = value;
  }

  /**
   * Gets the value of the 'deployDate' field.
   */
  public java.lang.Long getDeployDate() {
    return deployDate;
  }

  /**
   * Sets the value of the 'deployDate' field.
   * @param value the value to set.
   */
  public void setDeployDate(java.lang.Long value) {
    this.deployDate = value;
  }

  /**
   * Gets the value of the 'isLocal' field.
   */
  public java.lang.Boolean getIsLocal() {
    return isLocal;
  }

  /**
   * Sets the value of the 'isLocal' field.
   * @param value the value to set.
   */
  public void setIsLocal(java.lang.Boolean value) {
    this.isLocal = value;
  }

  /**
   * Gets the value of the 'status' field.
   */
  public java.lang.CharSequence getStatus() {
    return status;
  }

  /**
   * Sets the value of the 'status' field.
   * @param value the value to set.
   */
  public void setStatus(java.lang.CharSequence value) {
    this.status = value;
  }

  /**
   * Gets the value of the 'type' field.
   */
  public java.lang.CharSequence getType() {
    return type;
  }

  /**
   * Sets the value of the 'type' field.
   * @param value the value to set.
   */
  public void setType(java.lang.CharSequence value) {
    this.type = value;
  }

  /**
   * Gets the value of the 'isVisibleToAll' field.
   */
  public java.lang.Boolean getIsVisibleToAll() {
    return isVisibleToAll;
  }

  /**
   * Sets the value of the 'isVisibleToAll' field.
   * @param value the value to set.
   */
  public void setIsVisibleToAll(java.lang.Boolean value) {
    this.isVisibleToAll = value;
  }

  /**
   * Creates a new AvroExtension RecordBuilder.
   * @return A new AvroExtension RecordBuilder
   */
  public static com.jivesoftware.community.cloudalytics.event.avro.AvroExtension.Builder newBuilder() {
    return new com.jivesoftware.community.cloudalytics.event.avro.AvroExtension.Builder();
  }
  
  /**
   * Creates a new AvroExtension RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new AvroExtension RecordBuilder
   */
  public static com.jivesoftware.community.cloudalytics.event.avro.AvroExtension.Builder newBuilder(com.jivesoftware.community.cloudalytics.event.avro.AvroExtension.Builder other) {
    return new com.jivesoftware.community.cloudalytics.event.avro.AvroExtension.Builder(other);
  }
  
  /**
   * Creates a new AvroExtension RecordBuilder by copying an existing AvroExtension instance.
   * @param other The existing instance to copy.
   * @return A new AvroExtension RecordBuilder
   */
  public static com.jivesoftware.community.cloudalytics.event.avro.AvroExtension.Builder newBuilder(com.jivesoftware.community.cloudalytics.event.avro.AvroExtension other) {
    return new com.jivesoftware.community.cloudalytics.event.avro.AvroExtension.Builder(other);
  }
  
  /**
   * RecordBuilder for AvroExtension instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AvroExtension>
    implements org.apache.avro.data.RecordBuilder<AvroExtension> {

    private java.lang.CharSequence extensionUUID;
    private java.lang.CharSequence name;
    private long creationDate;
    private long deployDate;
    private boolean isLocal;
    private java.lang.CharSequence status;
    private java.lang.CharSequence type;
    private boolean isVisibleToAll;

    /** Creates a new Builder */
    private Builder() {
      super(com.jivesoftware.community.cloudalytics.event.avro.AvroExtension.SCHEMA$);
    }
    
    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.jivesoftware.community.cloudalytics.event.avro.AvroExtension.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.extensionUUID)) {
        this.extensionUUID = data().deepCopy(fields()[0].schema(), other.extensionUUID);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.creationDate)) {
        this.creationDate = data().deepCopy(fields()[2].schema(), other.creationDate);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.deployDate)) {
        this.deployDate = data().deepCopy(fields()[3].schema(), other.deployDate);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.isLocal)) {
        this.isLocal = data().deepCopy(fields()[4].schema(), other.isLocal);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.status)) {
        this.status = data().deepCopy(fields()[5].schema(), other.status);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.type)) {
        this.type = data().deepCopy(fields()[6].schema(), other.type);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.isVisibleToAll)) {
        this.isVisibleToAll = data().deepCopy(fields()[7].schema(), other.isVisibleToAll);
        fieldSetFlags()[7] = true;
      }
    }
    
    /**
     * Creates a Builder by copying an existing AvroExtension instance
     * @param other The existing instance to copy.
     */
    private Builder(com.jivesoftware.community.cloudalytics.event.avro.AvroExtension other) {
            super(com.jivesoftware.community.cloudalytics.event.avro.AvroExtension.SCHEMA$);
      if (isValidValue(fields()[0], other.extensionUUID)) {
        this.extensionUUID = data().deepCopy(fields()[0].schema(), other.extensionUUID);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.creationDate)) {
        this.creationDate = data().deepCopy(fields()[2].schema(), other.creationDate);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.deployDate)) {
        this.deployDate = data().deepCopy(fields()[3].schema(), other.deployDate);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.isLocal)) {
        this.isLocal = data().deepCopy(fields()[4].schema(), other.isLocal);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.status)) {
        this.status = data().deepCopy(fields()[5].schema(), other.status);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.type)) {
        this.type = data().deepCopy(fields()[6].schema(), other.type);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.isVisibleToAll)) {
        this.isVisibleToAll = data().deepCopy(fields()[7].schema(), other.isVisibleToAll);
        fieldSetFlags()[7] = true;
      }
    }

    /**
      * Gets the value of the 'extensionUUID' field.
      * @return The value.
      */
    public java.lang.CharSequence getExtensionUUID() {
      return extensionUUID;
    }

    /**
      * Sets the value of the 'extensionUUID' field.
      * @param value The value of 'extensionUUID'.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroExtension.Builder setExtensionUUID(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.extensionUUID = value;
      fieldSetFlags()[0] = true;
      return this; 
    }

    /**
      * Checks whether the 'extensionUUID' field has been set.
      * @return True if the 'extensionUUID' field has been set, false otherwise.
      */
    public boolean hasExtensionUUID() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'extensionUUID' field.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroExtension.Builder clearExtensionUUID() {
      extensionUUID = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'name' field.
      * @return The value.
      */
    public java.lang.CharSequence getName() {
      return name;
    }

    /**
      * Sets the value of the 'name' field.
      * @param value The value of 'name'.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroExtension.Builder setName(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.name = value;
      fieldSetFlags()[1] = true;
      return this; 
    }

    /**
      * Checks whether the 'name' field has been set.
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'name' field.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroExtension.Builder clearName() {
      name = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'creationDate' field.
      * @return The value.
      */
    public java.lang.Long getCreationDate() {
      return creationDate;
    }

    /**
      * Sets the value of the 'creationDate' field.
      * @param value The value of 'creationDate'.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroExtension.Builder setCreationDate(long value) {
      validate(fields()[2], value);
      this.creationDate = value;
      fieldSetFlags()[2] = true;
      return this; 
    }

    /**
      * Checks whether the 'creationDate' field has been set.
      * @return True if the 'creationDate' field has been set, false otherwise.
      */
    public boolean hasCreationDate() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'creationDate' field.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroExtension.Builder clearCreationDate() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'deployDate' field.
      * @return The value.
      */
    public java.lang.Long getDeployDate() {
      return deployDate;
    }

    /**
      * Sets the value of the 'deployDate' field.
      * @param value The value of 'deployDate'.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroExtension.Builder setDeployDate(long value) {
      validate(fields()[3], value);
      this.deployDate = value;
      fieldSetFlags()[3] = true;
      return this; 
    }

    /**
      * Checks whether the 'deployDate' field has been set.
      * @return True if the 'deployDate' field has been set, false otherwise.
      */
    public boolean hasDeployDate() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'deployDate' field.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroExtension.Builder clearDeployDate() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'isLocal' field.
      * @return The value.
      */
    public java.lang.Boolean getIsLocal() {
      return isLocal;
    }

    /**
      * Sets the value of the 'isLocal' field.
      * @param value The value of 'isLocal'.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroExtension.Builder setIsLocal(boolean value) {
      validate(fields()[4], value);
      this.isLocal = value;
      fieldSetFlags()[4] = true;
      return this; 
    }

    /**
      * Checks whether the 'isLocal' field has been set.
      * @return True if the 'isLocal' field has been set, false otherwise.
      */
    public boolean hasIsLocal() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'isLocal' field.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroExtension.Builder clearIsLocal() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'status' field.
      * @return The value.
      */
    public java.lang.CharSequence getStatus() {
      return status;
    }

    /**
      * Sets the value of the 'status' field.
      * @param value The value of 'status'.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroExtension.Builder setStatus(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.status = value;
      fieldSetFlags()[5] = true;
      return this; 
    }

    /**
      * Checks whether the 'status' field has been set.
      * @return True if the 'status' field has been set, false otherwise.
      */
    public boolean hasStatus() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'status' field.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroExtension.Builder clearStatus() {
      status = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'type' field.
      * @return The value.
      */
    public java.lang.CharSequence getType() {
      return type;
    }

    /**
      * Sets the value of the 'type' field.
      * @param value The value of 'type'.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroExtension.Builder setType(java.lang.CharSequence value) {
      validate(fields()[6], value);
      this.type = value;
      fieldSetFlags()[6] = true;
      return this; 
    }

    /**
      * Checks whether the 'type' field has been set.
      * @return True if the 'type' field has been set, false otherwise.
      */
    public boolean hasType() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'type' field.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroExtension.Builder clearType() {
      type = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'isVisibleToAll' field.
      * @return The value.
      */
    public java.lang.Boolean getIsVisibleToAll() {
      return isVisibleToAll;
    }

    /**
      * Sets the value of the 'isVisibleToAll' field.
      * @param value The value of 'isVisibleToAll'.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroExtension.Builder setIsVisibleToAll(boolean value) {
      validate(fields()[7], value);
      this.isVisibleToAll = value;
      fieldSetFlags()[7] = true;
      return this; 
    }

    /**
      * Checks whether the 'isVisibleToAll' field has been set.
      * @return True if the 'isVisibleToAll' field has been set, false otherwise.
      */
    public boolean hasIsVisibleToAll() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'isVisibleToAll' field.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroExtension.Builder clearIsVisibleToAll() {
      fieldSetFlags()[7] = false;
      return this;
    }

    @Override
    public AvroExtension build() {
      try {
        AvroExtension record = new AvroExtension();
        record.extensionUUID = fieldSetFlags()[0] ? this.extensionUUID : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.name = fieldSetFlags()[1] ? this.name : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.creationDate = fieldSetFlags()[2] ? this.creationDate : (java.lang.Long) defaultValue(fields()[2]);
        record.deployDate = fieldSetFlags()[3] ? this.deployDate : (java.lang.Long) defaultValue(fields()[3]);
        record.isLocal = fieldSetFlags()[4] ? this.isLocal : (java.lang.Boolean) defaultValue(fields()[4]);
        record.status = fieldSetFlags()[5] ? this.status : (java.lang.CharSequence) defaultValue(fields()[5]);
        record.type = fieldSetFlags()[6] ? this.type : (java.lang.CharSequence) defaultValue(fields()[6]);
        record.isVisibleToAll = fieldSetFlags()[7] ? this.isVisibleToAll : (java.lang.Boolean) defaultValue(fields()[7]);
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