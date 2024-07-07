// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: skuListRes.proto

package org.example.protocol;

/**
 * Protobuf type {@code com.protocol.GetSkuListResDTOProto}
 */
public  final class GetSkuListResDTOProto extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.protocol.GetSkuListResDTOProto)
    GetSkuListResDTOProtoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetSkuListResDTOProto.newBuilder() to construct.
  private GetSkuListResDTOProto(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetSkuListResDTOProto() {
    companyId_ = 0L;
    saleC1Id_ = 0;
    biId_ = 0L;
    skuId_ = 0L;
    source_ = 0;
    lastOrderTime_ = 0;
    channel_ = 0;
    buyNum_ = 0;
    uT_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GetSkuListResDTOProto(
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

            companyId_ = input.readInt64();
            break;
          }
          case 16: {

            saleC1Id_ = input.readInt32();
            break;
          }
          case 24: {

            biId_ = input.readInt64();
            break;
          }
          case 32: {

            skuId_ = input.readInt64();
            break;
          }
          case 40: {

            source_ = input.readInt32();
            break;
          }
          case 48: {

            lastOrderTime_ = input.readInt32();
            break;
          }
          case 56: {

            channel_ = input.readInt32();
            break;
          }
          case 64: {

            buyNum_ = input.readInt32();
            break;
          }
          case 72: {

            uT_ = input.readInt64();
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
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.example.protocol.SkuListRes.internal_static_com_protocol_GetSkuListResDTOProto_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.example.protocol.SkuListRes.internal_static_com_protocol_GetSkuListResDTOProto_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.example.protocol.GetSkuListResDTOProto.class, org.example.protocol.GetSkuListResDTOProto.Builder.class);
  }

  public static final int COMPANYID_FIELD_NUMBER = 1;
  private long companyId_;
  /**
   * <code>int64 companyId = 1;</code>
   */
  public long getCompanyId() {
    return companyId_;
  }

  public static final int SALEC1ID_FIELD_NUMBER = 2;
  private int saleC1Id_;
  /**
   * <code>int32 saleC1Id = 2;</code>
   */
  public int getSaleC1Id() {
    return saleC1Id_;
  }

  public static final int BIID_FIELD_NUMBER = 3;
  private long biId_;
  /**
   * <code>int64 biId = 3;</code>
   */
  public long getBiId() {
    return biId_;
  }

  public static final int SKUID_FIELD_NUMBER = 4;
  private long skuId_;
  /**
   * <code>int64 skuId = 4;</code>
   */
  public long getSkuId() {
    return skuId_;
  }

  public static final int SOURCE_FIELD_NUMBER = 5;
  private int source_;
  /**
   * <pre>
   * 来源 0:商户添加 1:下单写入
   * </pre>
   *
   * <code>int32 source = 5;</code>
   */
  public int getSource() {
    return source_;
  }

  public static final int LASTORDERTIME_FIELD_NUMBER = 6;
  private int lastOrderTime_;
  /**
   * <pre>
   * 注意：Java中的Integer类型在protobuf中通常对应int32，但如果你明确这是用来表示时间戳且可能为null，
   * 在protobuf中没有直接的null支持，通常我们会用特殊值（如0或负数）来表示"未设置"状态。
   * 这里假设lastOrderTime和channel非负，如果可以为负，请调整或者明确其含义。
   * </pre>
   *
   * <code>int32 lastOrderTime = 6;</code>
   */
  public int getLastOrderTime() {
    return lastOrderTime_;
  }

  public static final int CHANNEL_FIELD_NUMBER = 7;
  private int channel_;
  /**
   * <code>int32 channel = 7;</code>
   */
  public int getChannel() {
    return channel_;
  }

  public static final int BUYNUM_FIELD_NUMBER = 8;
  private int buyNum_;
  /**
   * <code>int32 buyNum = 8;</code>
   */
  public int getBuyNum() {
    return buyNum_;
  }

  public static final int UT_FIELD_NUMBER = 9;
  private long uT_;
  /**
   * <code>int64 uT = 9;</code>
   */
  public long getUT() {
    return uT_;
  }

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
    if (companyId_ != 0L) {
      output.writeInt64(1, companyId_);
    }
    if (saleC1Id_ != 0) {
      output.writeInt32(2, saleC1Id_);
    }
    if (biId_ != 0L) {
      output.writeInt64(3, biId_);
    }
    if (skuId_ != 0L) {
      output.writeInt64(4, skuId_);
    }
    if (source_ != 0) {
      output.writeInt32(5, source_);
    }
    if (lastOrderTime_ != 0) {
      output.writeInt32(6, lastOrderTime_);
    }
    if (channel_ != 0) {
      output.writeInt32(7, channel_);
    }
    if (buyNum_ != 0) {
      output.writeInt32(8, buyNum_);
    }
    if (uT_ != 0L) {
      output.writeInt64(9, uT_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (companyId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, companyId_);
    }
    if (saleC1Id_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, saleC1Id_);
    }
    if (biId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, biId_);
    }
    if (skuId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(4, skuId_);
    }
    if (source_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(5, source_);
    }
    if (lastOrderTime_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(6, lastOrderTime_);
    }
    if (channel_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(7, channel_);
    }
    if (buyNum_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(8, buyNum_);
    }
    if (uT_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(9, uT_);
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
    if (!(obj instanceof org.example.protocol.GetSkuListResDTOProto)) {
      return super.equals(obj);
    }
    org.example.protocol.GetSkuListResDTOProto other = (org.example.protocol.GetSkuListResDTOProto) obj;

    boolean result = true;
    result = result && (getCompanyId()
        == other.getCompanyId());
    result = result && (getSaleC1Id()
        == other.getSaleC1Id());
    result = result && (getBiId()
        == other.getBiId());
    result = result && (getSkuId()
        == other.getSkuId());
    result = result && (getSource()
        == other.getSource());
    result = result && (getLastOrderTime()
        == other.getLastOrderTime());
    result = result && (getChannel()
        == other.getChannel());
    result = result && (getBuyNum()
        == other.getBuyNum());
    result = result && (getUT()
        == other.getUT());
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
    hash = (37 * hash) + COMPANYID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getCompanyId());
    hash = (37 * hash) + SALEC1ID_FIELD_NUMBER;
    hash = (53 * hash) + getSaleC1Id();
    hash = (37 * hash) + BIID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getBiId());
    hash = (37 * hash) + SKUID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getSkuId());
    hash = (37 * hash) + SOURCE_FIELD_NUMBER;
    hash = (53 * hash) + getSource();
    hash = (37 * hash) + LASTORDERTIME_FIELD_NUMBER;
    hash = (53 * hash) + getLastOrderTime();
    hash = (37 * hash) + CHANNEL_FIELD_NUMBER;
    hash = (53 * hash) + getChannel();
    hash = (37 * hash) + BUYNUM_FIELD_NUMBER;
    hash = (53 * hash) + getBuyNum();
    hash = (37 * hash) + UT_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getUT());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.example.protocol.GetSkuListResDTOProto parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.example.protocol.GetSkuListResDTOProto parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.example.protocol.GetSkuListResDTOProto parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.example.protocol.GetSkuListResDTOProto parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.example.protocol.GetSkuListResDTOProto parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.example.protocol.GetSkuListResDTOProto parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.example.protocol.GetSkuListResDTOProto parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.example.protocol.GetSkuListResDTOProto parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.example.protocol.GetSkuListResDTOProto parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.example.protocol.GetSkuListResDTOProto parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.example.protocol.GetSkuListResDTOProto parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.example.protocol.GetSkuListResDTOProto parseFrom(
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
  public static Builder newBuilder(org.example.protocol.GetSkuListResDTOProto prototype) {
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
   * Protobuf type {@code com.protocol.GetSkuListResDTOProto}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.protocol.GetSkuListResDTOProto)
      org.example.protocol.GetSkuListResDTOProtoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.example.protocol.SkuListRes.internal_static_com_protocol_GetSkuListResDTOProto_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.example.protocol.SkuListRes.internal_static_com_protocol_GetSkuListResDTOProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.example.protocol.GetSkuListResDTOProto.class, org.example.protocol.GetSkuListResDTOProto.Builder.class);
    }

    // Construct using org.example.protocol.GetSkuListResDTOProto.newBuilder()
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
      companyId_ = 0L;

      saleC1Id_ = 0;

      biId_ = 0L;

      skuId_ = 0L;

      source_ = 0;

      lastOrderTime_ = 0;

      channel_ = 0;

      buyNum_ = 0;

      uT_ = 0L;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.example.protocol.SkuListRes.internal_static_com_protocol_GetSkuListResDTOProto_descriptor;
    }

    public org.example.protocol.GetSkuListResDTOProto getDefaultInstanceForType() {
      return org.example.protocol.GetSkuListResDTOProto.getDefaultInstance();
    }

    public org.example.protocol.GetSkuListResDTOProto build() {
      org.example.protocol.GetSkuListResDTOProto result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public org.example.protocol.GetSkuListResDTOProto buildPartial() {
      org.example.protocol.GetSkuListResDTOProto result = new org.example.protocol.GetSkuListResDTOProto(this);
      result.companyId_ = companyId_;
      result.saleC1Id_ = saleC1Id_;
      result.biId_ = biId_;
      result.skuId_ = skuId_;
      result.source_ = source_;
      result.lastOrderTime_ = lastOrderTime_;
      result.channel_ = channel_;
      result.buyNum_ = buyNum_;
      result.uT_ = uT_;
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
      if (other instanceof org.example.protocol.GetSkuListResDTOProto) {
        return mergeFrom((org.example.protocol.GetSkuListResDTOProto)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.example.protocol.GetSkuListResDTOProto other) {
      if (other == org.example.protocol.GetSkuListResDTOProto.getDefaultInstance()) return this;
      if (other.getCompanyId() != 0L) {
        setCompanyId(other.getCompanyId());
      }
      if (other.getSaleC1Id() != 0) {
        setSaleC1Id(other.getSaleC1Id());
      }
      if (other.getBiId() != 0L) {
        setBiId(other.getBiId());
      }
      if (other.getSkuId() != 0L) {
        setSkuId(other.getSkuId());
      }
      if (other.getSource() != 0) {
        setSource(other.getSource());
      }
      if (other.getLastOrderTime() != 0) {
        setLastOrderTime(other.getLastOrderTime());
      }
      if (other.getChannel() != 0) {
        setChannel(other.getChannel());
      }
      if (other.getBuyNum() != 0) {
        setBuyNum(other.getBuyNum());
      }
      if (other.getUT() != 0L) {
        setUT(other.getUT());
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
      org.example.protocol.GetSkuListResDTOProto parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.example.protocol.GetSkuListResDTOProto) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long companyId_ ;
    /**
     * <code>int64 companyId = 1;</code>
     */
    public long getCompanyId() {
      return companyId_;
    }
    /**
     * <code>int64 companyId = 1;</code>
     */
    public Builder setCompanyId(long value) {
      
      companyId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 companyId = 1;</code>
     */
    public Builder clearCompanyId() {
      
      companyId_ = 0L;
      onChanged();
      return this;
    }

    private int saleC1Id_ ;
    /**
     * <code>int32 saleC1Id = 2;</code>
     */
    public int getSaleC1Id() {
      return saleC1Id_;
    }
    /**
     * <code>int32 saleC1Id = 2;</code>
     */
    public Builder setSaleC1Id(int value) {
      
      saleC1Id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 saleC1Id = 2;</code>
     */
    public Builder clearSaleC1Id() {
      
      saleC1Id_ = 0;
      onChanged();
      return this;
    }

    private long biId_ ;
    /**
     * <code>int64 biId = 3;</code>
     */
    public long getBiId() {
      return biId_;
    }
    /**
     * <code>int64 biId = 3;</code>
     */
    public Builder setBiId(long value) {
      
      biId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 biId = 3;</code>
     */
    public Builder clearBiId() {
      
      biId_ = 0L;
      onChanged();
      return this;
    }

    private long skuId_ ;
    /**
     * <code>int64 skuId = 4;</code>
     */
    public long getSkuId() {
      return skuId_;
    }
    /**
     * <code>int64 skuId = 4;</code>
     */
    public Builder setSkuId(long value) {
      
      skuId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 skuId = 4;</code>
     */
    public Builder clearSkuId() {
      
      skuId_ = 0L;
      onChanged();
      return this;
    }

    private int source_ ;
    /**
     * <pre>
     * 来源 0:商户添加 1:下单写入
     * </pre>
     *
     * <code>int32 source = 5;</code>
     */
    public int getSource() {
      return source_;
    }
    /**
     * <pre>
     * 来源 0:商户添加 1:下单写入
     * </pre>
     *
     * <code>int32 source = 5;</code>
     */
    public Builder setSource(int value) {
      
      source_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 来源 0:商户添加 1:下单写入
     * </pre>
     *
     * <code>int32 source = 5;</code>
     */
    public Builder clearSource() {
      
      source_ = 0;
      onChanged();
      return this;
    }

    private int lastOrderTime_ ;
    /**
     * <pre>
     * 注意：Java中的Integer类型在protobuf中通常对应int32，但如果你明确这是用来表示时间戳且可能为null，
     * 在protobuf中没有直接的null支持，通常我们会用特殊值（如0或负数）来表示"未设置"状态。
     * 这里假设lastOrderTime和channel非负，如果可以为负，请调整或者明确其含义。
     * </pre>
     *
     * <code>int32 lastOrderTime = 6;</code>
     */
    public int getLastOrderTime() {
      return lastOrderTime_;
    }
    /**
     * <pre>
     * 注意：Java中的Integer类型在protobuf中通常对应int32，但如果你明确这是用来表示时间戳且可能为null，
     * 在protobuf中没有直接的null支持，通常我们会用特殊值（如0或负数）来表示"未设置"状态。
     * 这里假设lastOrderTime和channel非负，如果可以为负，请调整或者明确其含义。
     * </pre>
     *
     * <code>int32 lastOrderTime = 6;</code>
     */
    public Builder setLastOrderTime(int value) {
      
      lastOrderTime_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 注意：Java中的Integer类型在protobuf中通常对应int32，但如果你明确这是用来表示时间戳且可能为null，
     * 在protobuf中没有直接的null支持，通常我们会用特殊值（如0或负数）来表示"未设置"状态。
     * 这里假设lastOrderTime和channel非负，如果可以为负，请调整或者明确其含义。
     * </pre>
     *
     * <code>int32 lastOrderTime = 6;</code>
     */
    public Builder clearLastOrderTime() {
      
      lastOrderTime_ = 0;
      onChanged();
      return this;
    }

    private int channel_ ;
    /**
     * <code>int32 channel = 7;</code>
     */
    public int getChannel() {
      return channel_;
    }
    /**
     * <code>int32 channel = 7;</code>
     */
    public Builder setChannel(int value) {
      
      channel_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 channel = 7;</code>
     */
    public Builder clearChannel() {
      
      channel_ = 0;
      onChanged();
      return this;
    }

    private int buyNum_ ;
    /**
     * <code>int32 buyNum = 8;</code>
     */
    public int getBuyNum() {
      return buyNum_;
    }
    /**
     * <code>int32 buyNum = 8;</code>
     */
    public Builder setBuyNum(int value) {
      
      buyNum_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 buyNum = 8;</code>
     */
    public Builder clearBuyNum() {
      
      buyNum_ = 0;
      onChanged();
      return this;
    }

    private long uT_ ;
    /**
     * <code>int64 uT = 9;</code>
     */
    public long getUT() {
      return uT_;
    }
    /**
     * <code>int64 uT = 9;</code>
     */
    public Builder setUT(long value) {
      
      uT_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 uT = 9;</code>
     */
    public Builder clearUT() {
      
      uT_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:com.protocol.GetSkuListResDTOProto)
  }

  // @@protoc_insertion_point(class_scope:com.protocol.GetSkuListResDTOProto)
  private static final org.example.protocol.GetSkuListResDTOProto DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.example.protocol.GetSkuListResDTOProto();
  }

  public static org.example.protocol.GetSkuListResDTOProto getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetSkuListResDTOProto>
      PARSER = new com.google.protobuf.AbstractParser<GetSkuListResDTOProto>() {
    public GetSkuListResDTOProto parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GetSkuListResDTOProto(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetSkuListResDTOProto> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetSkuListResDTOProto> getParserForType() {
    return PARSER;
  }

  public org.example.protocol.GetSkuListResDTOProto getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

