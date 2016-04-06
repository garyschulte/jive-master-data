/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.jivesoftware.community.cloudalytics.event.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class AvroInvitation extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 364361104635756153L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"AvroInvitation\",\"namespace\":\"com.jivesoftware.community.cloudalytics.event.avro\",\"fields\":[{\"name\":\"invitationId\",\"type\":{\"type\":\"long\",\"order\":\"ignore\"}},{\"name\":\"invterUserName\",\"type\":\"string\"},{\"name\":\"inviterEmail\",\"type\":\"string\"},{\"name\":\"inviteeEmail\",\"type\":\"string\"},{\"name\":\"revokerUsername\",\"type\":\"string\"},{\"name\":\"state\",\"type\":\"string\"},{\"name\":\"sentDate\",\"type\":\"long\"},{\"name\":\"revokeDate\",\"type\":\"long\"},{\"name\":\"creationDate\",\"type\":\"long\"},{\"name\":\"modificationDate\",\"type\":\"long\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public long invitationId;
  @Deprecated public java.lang.CharSequence invterUserName;
  @Deprecated public java.lang.CharSequence inviterEmail;
  @Deprecated public java.lang.CharSequence inviteeEmail;
  @Deprecated public java.lang.CharSequence revokerUsername;
  @Deprecated public java.lang.CharSequence state;
  @Deprecated public long sentDate;
  @Deprecated public long revokeDate;
  @Deprecated public long creationDate;
  @Deprecated public long modificationDate;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public AvroInvitation() {}

  /**
   * All-args constructor.
   */
  public AvroInvitation(java.lang.Long invitationId, java.lang.CharSequence invterUserName, java.lang.CharSequence inviterEmail, java.lang.CharSequence inviteeEmail, java.lang.CharSequence revokerUsername, java.lang.CharSequence state, java.lang.Long sentDate, java.lang.Long revokeDate, java.lang.Long creationDate, java.lang.Long modificationDate) {
    this.invitationId = invitationId;
    this.invterUserName = invterUserName;
    this.inviterEmail = inviterEmail;
    this.inviteeEmail = inviteeEmail;
    this.revokerUsername = revokerUsername;
    this.state = state;
    this.sentDate = sentDate;
    this.revokeDate = revokeDate;
    this.creationDate = creationDate;
    this.modificationDate = modificationDate;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return invitationId;
    case 1: return invterUserName;
    case 2: return inviterEmail;
    case 3: return inviteeEmail;
    case 4: return revokerUsername;
    case 5: return state;
    case 6: return sentDate;
    case 7: return revokeDate;
    case 8: return creationDate;
    case 9: return modificationDate;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: invitationId = (java.lang.Long)value$; break;
    case 1: invterUserName = (java.lang.CharSequence)value$; break;
    case 2: inviterEmail = (java.lang.CharSequence)value$; break;
    case 3: inviteeEmail = (java.lang.CharSequence)value$; break;
    case 4: revokerUsername = (java.lang.CharSequence)value$; break;
    case 5: state = (java.lang.CharSequence)value$; break;
    case 6: sentDate = (java.lang.Long)value$; break;
    case 7: revokeDate = (java.lang.Long)value$; break;
    case 8: creationDate = (java.lang.Long)value$; break;
    case 9: modificationDate = (java.lang.Long)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'invitationId' field.
   */
  public java.lang.Long getInvitationId() {
    return invitationId;
  }

  /**
   * Sets the value of the 'invitationId' field.
   * @param value the value to set.
   */
  public void setInvitationId(java.lang.Long value) {
    this.invitationId = value;
  }

  /**
   * Gets the value of the 'invterUserName' field.
   */
  public java.lang.CharSequence getInvterUserName() {
    return invterUserName;
  }

  /**
   * Sets the value of the 'invterUserName' field.
   * @param value the value to set.
   */
  public void setInvterUserName(java.lang.CharSequence value) {
    this.invterUserName = value;
  }

  /**
   * Gets the value of the 'inviterEmail' field.
   */
  public java.lang.CharSequence getInviterEmail() {
    return inviterEmail;
  }

  /**
   * Sets the value of the 'inviterEmail' field.
   * @param value the value to set.
   */
  public void setInviterEmail(java.lang.CharSequence value) {
    this.inviterEmail = value;
  }

  /**
   * Gets the value of the 'inviteeEmail' field.
   */
  public java.lang.CharSequence getInviteeEmail() {
    return inviteeEmail;
  }

  /**
   * Sets the value of the 'inviteeEmail' field.
   * @param value the value to set.
   */
  public void setInviteeEmail(java.lang.CharSequence value) {
    this.inviteeEmail = value;
  }

  /**
   * Gets the value of the 'revokerUsername' field.
   */
  public java.lang.CharSequence getRevokerUsername() {
    return revokerUsername;
  }

  /**
   * Sets the value of the 'revokerUsername' field.
   * @param value the value to set.
   */
  public void setRevokerUsername(java.lang.CharSequence value) {
    this.revokerUsername = value;
  }

  /**
   * Gets the value of the 'state' field.
   */
  public java.lang.CharSequence getState() {
    return state;
  }

  /**
   * Sets the value of the 'state' field.
   * @param value the value to set.
   */
  public void setState(java.lang.CharSequence value) {
    this.state = value;
  }

  /**
   * Gets the value of the 'sentDate' field.
   */
  public java.lang.Long getSentDate() {
    return sentDate;
  }

  /**
   * Sets the value of the 'sentDate' field.
   * @param value the value to set.
   */
  public void setSentDate(java.lang.Long value) {
    this.sentDate = value;
  }

  /**
   * Gets the value of the 'revokeDate' field.
   */
  public java.lang.Long getRevokeDate() {
    return revokeDate;
  }

  /**
   * Sets the value of the 'revokeDate' field.
   * @param value the value to set.
   */
  public void setRevokeDate(java.lang.Long value) {
    this.revokeDate = value;
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
   * Gets the value of the 'modificationDate' field.
   */
  public java.lang.Long getModificationDate() {
    return modificationDate;
  }

  /**
   * Sets the value of the 'modificationDate' field.
   * @param value the value to set.
   */
  public void setModificationDate(java.lang.Long value) {
    this.modificationDate = value;
  }

  /**
   * Creates a new AvroInvitation RecordBuilder.
   * @return A new AvroInvitation RecordBuilder
   */
  public static com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation.Builder newBuilder() {
    return new com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation.Builder();
  }
  
  /**
   * Creates a new AvroInvitation RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new AvroInvitation RecordBuilder
   */
  public static com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation.Builder newBuilder(com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation.Builder other) {
    return new com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation.Builder(other);
  }
  
  /**
   * Creates a new AvroInvitation RecordBuilder by copying an existing AvroInvitation instance.
   * @param other The existing instance to copy.
   * @return A new AvroInvitation RecordBuilder
   */
  public static com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation.Builder newBuilder(com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation other) {
    return new com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation.Builder(other);
  }
  
  /**
   * RecordBuilder for AvroInvitation instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<AvroInvitation>
    implements org.apache.avro.data.RecordBuilder<AvroInvitation> {

    private long invitationId;
    private java.lang.CharSequence invterUserName;
    private java.lang.CharSequence inviterEmail;
    private java.lang.CharSequence inviteeEmail;
    private java.lang.CharSequence revokerUsername;
    private java.lang.CharSequence state;
    private long sentDate;
    private long revokeDate;
    private long creationDate;
    private long modificationDate;

    /** Creates a new Builder */
    private Builder() {
      super(com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation.SCHEMA$);
    }
    
    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.invitationId)) {
        this.invitationId = data().deepCopy(fields()[0].schema(), other.invitationId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.invterUserName)) {
        this.invterUserName = data().deepCopy(fields()[1].schema(), other.invterUserName);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.inviterEmail)) {
        this.inviterEmail = data().deepCopy(fields()[2].schema(), other.inviterEmail);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.inviteeEmail)) {
        this.inviteeEmail = data().deepCopy(fields()[3].schema(), other.inviteeEmail);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.revokerUsername)) {
        this.revokerUsername = data().deepCopy(fields()[4].schema(), other.revokerUsername);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.state)) {
        this.state = data().deepCopy(fields()[5].schema(), other.state);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.sentDate)) {
        this.sentDate = data().deepCopy(fields()[6].schema(), other.sentDate);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.revokeDate)) {
        this.revokeDate = data().deepCopy(fields()[7].schema(), other.revokeDate);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.creationDate)) {
        this.creationDate = data().deepCopy(fields()[8].schema(), other.creationDate);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.modificationDate)) {
        this.modificationDate = data().deepCopy(fields()[9].schema(), other.modificationDate);
        fieldSetFlags()[9] = true;
      }
    }
    
    /**
     * Creates a Builder by copying an existing AvroInvitation instance
     * @param other The existing instance to copy.
     */
    private Builder(com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation other) {
            super(com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation.SCHEMA$);
      if (isValidValue(fields()[0], other.invitationId)) {
        this.invitationId = data().deepCopy(fields()[0].schema(), other.invitationId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.invterUserName)) {
        this.invterUserName = data().deepCopy(fields()[1].schema(), other.invterUserName);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.inviterEmail)) {
        this.inviterEmail = data().deepCopy(fields()[2].schema(), other.inviterEmail);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.inviteeEmail)) {
        this.inviteeEmail = data().deepCopy(fields()[3].schema(), other.inviteeEmail);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.revokerUsername)) {
        this.revokerUsername = data().deepCopy(fields()[4].schema(), other.revokerUsername);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.state)) {
        this.state = data().deepCopy(fields()[5].schema(), other.state);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.sentDate)) {
        this.sentDate = data().deepCopy(fields()[6].schema(), other.sentDate);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.revokeDate)) {
        this.revokeDate = data().deepCopy(fields()[7].schema(), other.revokeDate);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.creationDate)) {
        this.creationDate = data().deepCopy(fields()[8].schema(), other.creationDate);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.modificationDate)) {
        this.modificationDate = data().deepCopy(fields()[9].schema(), other.modificationDate);
        fieldSetFlags()[9] = true;
      }
    }

    /**
      * Gets the value of the 'invitationId' field.
      * @return The value.
      */
    public java.lang.Long getInvitationId() {
      return invitationId;
    }

    /**
      * Sets the value of the 'invitationId' field.
      * @param value The value of 'invitationId'.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation.Builder setInvitationId(long value) {
      validate(fields()[0], value);
      this.invitationId = value;
      fieldSetFlags()[0] = true;
      return this; 
    }

    /**
      * Checks whether the 'invitationId' field has been set.
      * @return True if the 'invitationId' field has been set, false otherwise.
      */
    public boolean hasInvitationId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'invitationId' field.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation.Builder clearInvitationId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'invterUserName' field.
      * @return The value.
      */
    public java.lang.CharSequence getInvterUserName() {
      return invterUserName;
    }

    /**
      * Sets the value of the 'invterUserName' field.
      * @param value The value of 'invterUserName'.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation.Builder setInvterUserName(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.invterUserName = value;
      fieldSetFlags()[1] = true;
      return this; 
    }

    /**
      * Checks whether the 'invterUserName' field has been set.
      * @return True if the 'invterUserName' field has been set, false otherwise.
      */
    public boolean hasInvterUserName() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'invterUserName' field.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation.Builder clearInvterUserName() {
      invterUserName = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'inviterEmail' field.
      * @return The value.
      */
    public java.lang.CharSequence getInviterEmail() {
      return inviterEmail;
    }

    /**
      * Sets the value of the 'inviterEmail' field.
      * @param value The value of 'inviterEmail'.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation.Builder setInviterEmail(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.inviterEmail = value;
      fieldSetFlags()[2] = true;
      return this; 
    }

    /**
      * Checks whether the 'inviterEmail' field has been set.
      * @return True if the 'inviterEmail' field has been set, false otherwise.
      */
    public boolean hasInviterEmail() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'inviterEmail' field.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation.Builder clearInviterEmail() {
      inviterEmail = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'inviteeEmail' field.
      * @return The value.
      */
    public java.lang.CharSequence getInviteeEmail() {
      return inviteeEmail;
    }

    /**
      * Sets the value of the 'inviteeEmail' field.
      * @param value The value of 'inviteeEmail'.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation.Builder setInviteeEmail(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.inviteeEmail = value;
      fieldSetFlags()[3] = true;
      return this; 
    }

    /**
      * Checks whether the 'inviteeEmail' field has been set.
      * @return True if the 'inviteeEmail' field has been set, false otherwise.
      */
    public boolean hasInviteeEmail() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'inviteeEmail' field.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation.Builder clearInviteeEmail() {
      inviteeEmail = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'revokerUsername' field.
      * @return The value.
      */
    public java.lang.CharSequence getRevokerUsername() {
      return revokerUsername;
    }

    /**
      * Sets the value of the 'revokerUsername' field.
      * @param value The value of 'revokerUsername'.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation.Builder setRevokerUsername(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.revokerUsername = value;
      fieldSetFlags()[4] = true;
      return this; 
    }

    /**
      * Checks whether the 'revokerUsername' field has been set.
      * @return True if the 'revokerUsername' field has been set, false otherwise.
      */
    public boolean hasRevokerUsername() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'revokerUsername' field.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation.Builder clearRevokerUsername() {
      revokerUsername = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'state' field.
      * @return The value.
      */
    public java.lang.CharSequence getState() {
      return state;
    }

    /**
      * Sets the value of the 'state' field.
      * @param value The value of 'state'.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation.Builder setState(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.state = value;
      fieldSetFlags()[5] = true;
      return this; 
    }

    /**
      * Checks whether the 'state' field has been set.
      * @return True if the 'state' field has been set, false otherwise.
      */
    public boolean hasState() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'state' field.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation.Builder clearState() {
      state = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'sentDate' field.
      * @return The value.
      */
    public java.lang.Long getSentDate() {
      return sentDate;
    }

    /**
      * Sets the value of the 'sentDate' field.
      * @param value The value of 'sentDate'.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation.Builder setSentDate(long value) {
      validate(fields()[6], value);
      this.sentDate = value;
      fieldSetFlags()[6] = true;
      return this; 
    }

    /**
      * Checks whether the 'sentDate' field has been set.
      * @return True if the 'sentDate' field has been set, false otherwise.
      */
    public boolean hasSentDate() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'sentDate' field.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation.Builder clearSentDate() {
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'revokeDate' field.
      * @return The value.
      */
    public java.lang.Long getRevokeDate() {
      return revokeDate;
    }

    /**
      * Sets the value of the 'revokeDate' field.
      * @param value The value of 'revokeDate'.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation.Builder setRevokeDate(long value) {
      validate(fields()[7], value);
      this.revokeDate = value;
      fieldSetFlags()[7] = true;
      return this; 
    }

    /**
      * Checks whether the 'revokeDate' field has been set.
      * @return True if the 'revokeDate' field has been set, false otherwise.
      */
    public boolean hasRevokeDate() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'revokeDate' field.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation.Builder clearRevokeDate() {
      fieldSetFlags()[7] = false;
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
    public com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation.Builder setCreationDate(long value) {
      validate(fields()[8], value);
      this.creationDate = value;
      fieldSetFlags()[8] = true;
      return this; 
    }

    /**
      * Checks whether the 'creationDate' field has been set.
      * @return True if the 'creationDate' field has been set, false otherwise.
      */
    public boolean hasCreationDate() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'creationDate' field.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation.Builder clearCreationDate() {
      fieldSetFlags()[8] = false;
      return this;
    }

    /**
      * Gets the value of the 'modificationDate' field.
      * @return The value.
      */
    public java.lang.Long getModificationDate() {
      return modificationDate;
    }

    /**
      * Sets the value of the 'modificationDate' field.
      * @param value The value of 'modificationDate'.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation.Builder setModificationDate(long value) {
      validate(fields()[9], value);
      this.modificationDate = value;
      fieldSetFlags()[9] = true;
      return this; 
    }

    /**
      * Checks whether the 'modificationDate' field has been set.
      * @return True if the 'modificationDate' field has been set, false otherwise.
      */
    public boolean hasModificationDate() {
      return fieldSetFlags()[9];
    }


    /**
      * Clears the value of the 'modificationDate' field.
      * @return This builder.
      */
    public com.jivesoftware.community.cloudalytics.event.avro.AvroInvitation.Builder clearModificationDate() {
      fieldSetFlags()[9] = false;
      return this;
    }

    @Override
    public AvroInvitation build() {
      try {
        AvroInvitation record = new AvroInvitation();
        record.invitationId = fieldSetFlags()[0] ? this.invitationId : (java.lang.Long) defaultValue(fields()[0]);
        record.invterUserName = fieldSetFlags()[1] ? this.invterUserName : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.inviterEmail = fieldSetFlags()[2] ? this.inviterEmail : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.inviteeEmail = fieldSetFlags()[3] ? this.inviteeEmail : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.revokerUsername = fieldSetFlags()[4] ? this.revokerUsername : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.state = fieldSetFlags()[5] ? this.state : (java.lang.CharSequence) defaultValue(fields()[5]);
        record.sentDate = fieldSetFlags()[6] ? this.sentDate : (java.lang.Long) defaultValue(fields()[6]);
        record.revokeDate = fieldSetFlags()[7] ? this.revokeDate : (java.lang.Long) defaultValue(fields()[7]);
        record.creationDate = fieldSetFlags()[8] ? this.creationDate : (java.lang.Long) defaultValue(fields()[8]);
        record.modificationDate = fieldSetFlags()[9] ? this.modificationDate : (java.lang.Long) defaultValue(fields()[9]);
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