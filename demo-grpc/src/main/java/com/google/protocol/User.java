// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: message.proto

package com.google.protocol;

/**
 * Protobuf type {@code protocol.User}
 */
public  final class User extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:protocol.User)
    UserOrBuilder {
private static final long serialVersionUID = 0L;
  // Use User.newBuilder() to construct.
  private User(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private User() {
    userId_ = 0;
    username_ = "";
    name_ = "";
    userType_ = 0;
    roles_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private User(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 8: {

            userId_ = input.readInt32();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            username_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();
            msgCase_ = 3;
            msg_ = s;
            break;
          }
          case 32: {
            msgCase_ = 4;
            msg_ = input.readInt32();
            break;
          }
          case 66: {
            java.lang.String s = input.readStringRequireUtf8();

            name_ = s;
            break;
          }
          case 72: {
            int rawValue = input.readEnum();

            userType_ = rawValue;
            break;
          }
          case 80: {
            if (!((mutable_bitField0_ & 0x00000040) == 0x00000040)) {
              roles_ = new java.util.ArrayList<java.lang.Integer>();
              mutable_bitField0_ |= 0x00000040;
            }
            roles_.add(input.readInt32());
            break;
          }
          case 82: {
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (!((mutable_bitField0_ & 0x00000040) == 0x00000040) && input.getBytesUntilLimit() > 0) {
              roles_ = new java.util.ArrayList<java.lang.Integer>();
              mutable_bitField0_ |= 0x00000040;
            }
            while (input.getBytesUntilLimit() > 0) {
              roles_.add(input.readInt32());
            }
            input.popLimit(limit);
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000040) == 0x00000040)) {
        roles_ = java.util.Collections.unmodifiableList(roles_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.google.protocol.UserProtobuf.internal_static_protocol_User_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.protocol.UserProtobuf.internal_static_protocol_User_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.protocol.User.class, com.google.protocol.User.Builder.class);
  }

  private int bitField0_;
  private int msgCase_ = 0;
  private java.lang.Object msg_;
  public enum MsgCase
      implements com.google.protobuf.Internal.EnumLite {
    ERROR(3),
    CODE(4),
    MSG_NOT_SET(0);
    private final int value;
    private MsgCase(int value) {
      this.value = value;
    }
    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static MsgCase valueOf(int value) {
      return forNumber(value);
    }

    public static MsgCase forNumber(int value) {
      switch (value) {
        case 3: return ERROR;
        case 4: return CODE;
        case 0: return MSG_NOT_SET;
        default: return null;
      }
    }
    public int getNumber() {
      return this.value;
    }
  };

  public MsgCase
  getMsgCase() {
    return MsgCase.forNumber(
        msgCase_);
  }

  public static final int USERID_FIELD_NUMBER = 1;
  private int userId_;
  /**
   * <code>int32 userId = 1;</code>
   */
  public int getUserId() {
    return userId_;
  }

  public static final int USERNAME_FIELD_NUMBER = 2;
  private volatile java.lang.Object username_;
  /**
   * <code>string username = 2;</code>
   */
  public java.lang.String getUsername() {
    java.lang.Object ref = username_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      username_ = s;
      return s;
    }
  }
  /**
   * <code>string username = 2;</code>
   */
  public com.google.protobuf.ByteString
      getUsernameBytes() {
    java.lang.Object ref = username_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      username_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ERROR_FIELD_NUMBER = 3;
  /**
   * <code>string error = 3;</code>
   */
  public java.lang.String getError() {
    java.lang.Object ref = "";
    if (msgCase_ == 3) {
      ref = msg_;
    }
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (msgCase_ == 3) {
        msg_ = s;
      }
      return s;
    }
  }
  /**
   * <code>string error = 3;</code>
   */
  public com.google.protobuf.ByteString
      getErrorBytes() {
    java.lang.Object ref = "";
    if (msgCase_ == 3) {
      ref = msg_;
    }
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      if (msgCase_ == 3) {
        msg_ = b;
      }
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CODE_FIELD_NUMBER = 4;
  /**
   * <code>int32 code = 4;</code>
   */
  public int getCode() {
    if (msgCase_ == 4) {
      return (java.lang.Integer) msg_;
    }
    return 0;
  }

  public static final int NAME_FIELD_NUMBER = 8;
  private volatile java.lang.Object name_;
  /**
   * <code>string name = 8;</code>
   */
  public java.lang.String getName() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      name_ = s;
      return s;
    }
  }
  /**
   * <code>string name = 8;</code>
   */
  public com.google.protobuf.ByteString
      getNameBytes() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int USERTYPE_FIELD_NUMBER = 9;
  private int userType_;
  /**
   * <code>.protocol.UserType userType = 9;</code>
   */
  public int getUserTypeValue() {
    return userType_;
  }
  /**
   * <code>.protocol.UserType userType = 9;</code>
   */
  public com.google.protocol.UserType getUserType() {
    com.google.protocol.UserType result = com.google.protocol.UserType.valueOf(userType_);
    return result == null ? com.google.protocol.UserType.UNRECOGNIZED : result;
  }

  public static final int ROLES_FIELD_NUMBER = 10;
  private java.util.List<java.lang.Integer> roles_;
  /**
   * <code>repeated int32 roles = 10;</code>
   */
  public java.util.List<java.lang.Integer>
      getRolesList() {
    return roles_;
  }
  /**
   * <code>repeated int32 roles = 10;</code>
   */
  public int getRolesCount() {
    return roles_.size();
  }
  /**
   * <code>repeated int32 roles = 10;</code>
   */
  public int getRoles(int index) {
    return roles_.get(index);
  }
  private int rolesMemoizedSerializedSize = -1;

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    getSerializedSize();
    if (userId_ != 0) {
      output.writeInt32(1, userId_);
    }
    if (!getUsernameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, username_);
    }
    if (msgCase_ == 3) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, msg_);
    }
    if (msgCase_ == 4) {
      output.writeInt32(
          4, (int)((java.lang.Integer) msg_));
    }
    if (!getNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 8, name_);
    }
    if (userType_ != com.google.protocol.UserType.UNKNOW.getNumber()) {
      output.writeEnum(9, userType_);
    }
    if (getRolesList().size() > 0) {
      output.writeUInt32NoTag(82);
      output.writeUInt32NoTag(rolesMemoizedSerializedSize);
    }
    for (int i = 0; i < roles_.size(); i++) {
      output.writeInt32NoTag(roles_.get(i));
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (userId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, userId_);
    }
    if (!getUsernameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, username_);
    }
    if (msgCase_ == 3) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, msg_);
    }
    if (msgCase_ == 4) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(
            4, (int)((java.lang.Integer) msg_));
    }
    if (!getNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(8, name_);
    }
    if (userType_ != com.google.protocol.UserType.UNKNOW.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(9, userType_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < roles_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeInt32SizeNoTag(roles_.get(i));
      }
      size += dataSize;
      if (!getRolesList().isEmpty()) {
        size += 1;
        size += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(dataSize);
      }
      rolesMemoizedSerializedSize = dataSize;
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.google.protocol.User)) {
      return super.equals(obj);
    }
    com.google.protocol.User other = (com.google.protocol.User) obj;

    boolean result = true;
    result = result && (getUserId()
        == other.getUserId());
    result = result && getUsername()
        .equals(other.getUsername());
    result = result && getName()
        .equals(other.getName());
    result = result && userType_ == other.userType_;
    result = result && getRolesList()
        .equals(other.getRolesList());
    result = result && getMsgCase().equals(
        other.getMsgCase());
    if (!result) return false;
    switch (msgCase_) {
      case 3:
        result = result && getError()
            .equals(other.getError());
        break;
      case 4:
        result = result && (getCode()
            == other.getCode());
        break;
      case 0:
      default:
    }
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + USERID_FIELD_NUMBER;
    hash = (53 * hash) + getUserId();
    hash = (37 * hash) + USERNAME_FIELD_NUMBER;
    hash = (53 * hash) + getUsername().hashCode();
    hash = (37 * hash) + NAME_FIELD_NUMBER;
    hash = (53 * hash) + getName().hashCode();
    hash = (37 * hash) + USERTYPE_FIELD_NUMBER;
    hash = (53 * hash) + userType_;
    if (getRolesCount() > 0) {
      hash = (37 * hash) + ROLES_FIELD_NUMBER;
      hash = (53 * hash) + getRolesList().hashCode();
    }
    switch (msgCase_) {
      case 3:
        hash = (37 * hash) + ERROR_FIELD_NUMBER;
        hash = (53 * hash) + getError().hashCode();
        break;
      case 4:
        hash = (37 * hash) + CODE_FIELD_NUMBER;
        hash = (53 * hash) + getCode();
        break;
      case 0:
      default:
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.protocol.User parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.protocol.User parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.protocol.User parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.protocol.User parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.protocol.User parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.protocol.User parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.protocol.User parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.protocol.User parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.protocol.User parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.google.protocol.User parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.protocol.User parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.protocol.User parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.google.protocol.User prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code protocol.User}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:protocol.User)
      com.google.protocol.UserOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.google.protocol.UserProtobuf.internal_static_protocol_User_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.protocol.UserProtobuf.internal_static_protocol_User_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.protocol.User.class, com.google.protocol.User.Builder.class);
    }

    // Construct using com.google.protocol.User.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      userId_ = 0;

      username_ = "";

      name_ = "";

      userType_ = 0;

      roles_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000040);
      msgCase_ = 0;
      msg_ = null;
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.google.protocol.UserProtobuf.internal_static_protocol_User_descriptor;
    }

    public com.google.protocol.User getDefaultInstanceForType() {
      return com.google.protocol.User.getDefaultInstance();
    }

    public com.google.protocol.User build() {
      com.google.protocol.User result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.google.protocol.User buildPartial() {
      com.google.protocol.User result = new com.google.protocol.User(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.userId_ = userId_;
      result.username_ = username_;
      if (msgCase_ == 3) {
        result.msg_ = msg_;
      }
      if (msgCase_ == 4) {
        result.msg_ = msg_;
      }
      result.name_ = name_;
      result.userType_ = userType_;
      if (((bitField0_ & 0x00000040) == 0x00000040)) {
        roles_ = java.util.Collections.unmodifiableList(roles_);
        bitField0_ = (bitField0_ & ~0x00000040);
      }
      result.roles_ = roles_;
      result.bitField0_ = to_bitField0_;
      result.msgCase_ = msgCase_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.protocol.User) {
        return mergeFrom((com.google.protocol.User)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.protocol.User other) {
      if (other == com.google.protocol.User.getDefaultInstance()) return this;
      if (other.getUserId() != 0) {
        setUserId(other.getUserId());
      }
      if (!other.getUsername().isEmpty()) {
        username_ = other.username_;
        onChanged();
      }
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        onChanged();
      }
      if (other.userType_ != 0) {
        setUserTypeValue(other.getUserTypeValue());
      }
      if (!other.roles_.isEmpty()) {
        if (roles_.isEmpty()) {
          roles_ = other.roles_;
          bitField0_ = (bitField0_ & ~0x00000040);
        } else {
          ensureRolesIsMutable();
          roles_.addAll(other.roles_);
        }
        onChanged();
      }
      switch (other.getMsgCase()) {
        case ERROR: {
          msgCase_ = 3;
          msg_ = other.msg_;
          onChanged();
          break;
        }
        case CODE: {
          setCode(other.getCode());
          break;
        }
        case MSG_NOT_SET: {
          break;
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.google.protocol.User parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.google.protocol.User) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int msgCase_ = 0;
    private java.lang.Object msg_;
    public MsgCase
        getMsgCase() {
      return MsgCase.forNumber(
          msgCase_);
    }

    public Builder clearMsg() {
      msgCase_ = 0;
      msg_ = null;
      onChanged();
      return this;
    }

    private int bitField0_;

    private int userId_ ;
    /**
     * <code>int32 userId = 1;</code>
     */
    public int getUserId() {
      return userId_;
    }
    /**
     * <code>int32 userId = 1;</code>
     */
    public Builder setUserId(int value) {
      
      userId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 userId = 1;</code>
     */
    public Builder clearUserId() {
      
      userId_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object username_ = "";
    /**
     * <code>string username = 2;</code>
     */
    public java.lang.String getUsername() {
      java.lang.Object ref = username_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        username_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string username = 2;</code>
     */
    public com.google.protobuf.ByteString
        getUsernameBytes() {
      java.lang.Object ref = username_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        username_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string username = 2;</code>
     */
    public Builder setUsername(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      username_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string username = 2;</code>
     */
    public Builder clearUsername() {
      
      username_ = getDefaultInstance().getUsername();
      onChanged();
      return this;
    }
    /**
     * <code>string username = 2;</code>
     */
    public Builder setUsernameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      username_ = value;
      onChanged();
      return this;
    }

    /**
     * <code>string error = 3;</code>
     */
    public java.lang.String getError() {
      java.lang.Object ref = "";
      if (msgCase_ == 3) {
        ref = msg_;
      }
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (msgCase_ == 3) {
          msg_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string error = 3;</code>
     */
    public com.google.protobuf.ByteString
        getErrorBytes() {
      java.lang.Object ref = "";
      if (msgCase_ == 3) {
        ref = msg_;
      }
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        if (msgCase_ == 3) {
          msg_ = b;
        }
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string error = 3;</code>
     */
    public Builder setError(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  msgCase_ = 3;
      msg_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string error = 3;</code>
     */
    public Builder clearError() {
      if (msgCase_ == 3) {
        msgCase_ = 0;
        msg_ = null;
        onChanged();
      }
      return this;
    }
    /**
     * <code>string error = 3;</code>
     */
    public Builder setErrorBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      msgCase_ = 3;
      msg_ = value;
      onChanged();
      return this;
    }

    /**
     * <code>int32 code = 4;</code>
     */
    public int getCode() {
      if (msgCase_ == 4) {
        return (java.lang.Integer) msg_;
      }
      return 0;
    }
    /**
     * <code>int32 code = 4;</code>
     */
    public Builder setCode(int value) {
      msgCase_ = 4;
      msg_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 code = 4;</code>
     */
    public Builder clearCode() {
      if (msgCase_ == 4) {
        msgCase_ = 0;
        msg_ = null;
        onChanged();
      }
      return this;
    }

    private java.lang.Object name_ = "";
    /**
     * <code>string name = 8;</code>
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        name_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string name = 8;</code>
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string name = 8;</code>
     */
    public Builder setName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      name_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string name = 8;</code>
     */
    public Builder clearName() {
      
      name_ = getDefaultInstance().getName();
      onChanged();
      return this;
    }
    /**
     * <code>string name = 8;</code>
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      name_ = value;
      onChanged();
      return this;
    }

    private int userType_ = 0;
    /**
     * <code>.protocol.UserType userType = 9;</code>
     */
    public int getUserTypeValue() {
      return userType_;
    }
    /**
     * <code>.protocol.UserType userType = 9;</code>
     */
    public Builder setUserTypeValue(int value) {
      userType_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.protocol.UserType userType = 9;</code>
     */
    public com.google.protocol.UserType getUserType() {
      com.google.protocol.UserType result = com.google.protocol.UserType.valueOf(userType_);
      return result == null ? com.google.protocol.UserType.UNRECOGNIZED : result;
    }
    /**
     * <code>.protocol.UserType userType = 9;</code>
     */
    public Builder setUserType(com.google.protocol.UserType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      userType_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.protocol.UserType userType = 9;</code>
     */
    public Builder clearUserType() {
      
      userType_ = 0;
      onChanged();
      return this;
    }

    private java.util.List<java.lang.Integer> roles_ = java.util.Collections.emptyList();
    private void ensureRolesIsMutable() {
      if (!((bitField0_ & 0x00000040) == 0x00000040)) {
        roles_ = new java.util.ArrayList<java.lang.Integer>(roles_);
        bitField0_ |= 0x00000040;
       }
    }
    /**
     * <code>repeated int32 roles = 10;</code>
     */
    public java.util.List<java.lang.Integer>
        getRolesList() {
      return java.util.Collections.unmodifiableList(roles_);
    }
    /**
     * <code>repeated int32 roles = 10;</code>
     */
    public int getRolesCount() {
      return roles_.size();
    }
    /**
     * <code>repeated int32 roles = 10;</code>
     */
    public int getRoles(int index) {
      return roles_.get(index);
    }
    /**
     * <code>repeated int32 roles = 10;</code>
     */
    public Builder setRoles(
        int index, int value) {
      ensureRolesIsMutable();
      roles_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 roles = 10;</code>
     */
    public Builder addRoles(int value) {
      ensureRolesIsMutable();
      roles_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 roles = 10;</code>
     */
    public Builder addAllRoles(
        java.lang.Iterable<? extends java.lang.Integer> values) {
      ensureRolesIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, roles_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated int32 roles = 10;</code>
     */
    public Builder clearRoles() {
      roles_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000040);
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:protocol.User)
  }

  // @@protoc_insertion_point(class_scope:protocol.User)
  private static final com.google.protocol.User DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.google.protocol.User();
  }

  public static com.google.protocol.User getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<User>
      PARSER = new com.google.protobuf.AbstractParser<User>() {
    public User parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new User(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<User> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<User> getParserForType() {
    return PARSER;
  }

  public com.google.protocol.User getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

