// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat.proto

package top.alvinsite.chat.common.packets;

/**
 * Protobuf type {@code ChatMessage}
 */
public  final class ChatMessage extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ChatMessage)
    ChatMessageOrBuilder {
  // Use ChatMessage.newBuilder() to construct.
  private ChatMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ChatMessage() {
    type_ = 1;
    receiverType_ = 1;
    receiver_ = "";
    content_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ChatMessage(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
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
            if (!parseUnknownField(input, unknownFields,
                                   extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 8: {
            int rawValue = input.readEnum();
            top.alvinsite.chat.common.packets.MessageType value = top.alvinsite.chat.common.packets.MessageType.valueOf(rawValue);
            if (value == null) {
              unknownFields.mergeVarintField(1, rawValue);
            } else {
              bitField0_ |= 0x00000001;
              type_ = rawValue;
            }
            break;
          }
          case 16: {
            int rawValue = input.readEnum();
            top.alvinsite.chat.common.packets.ReceiverType value = top.alvinsite.chat.common.packets.ReceiverType.valueOf(rawValue);
            if (value == null) {
              unknownFields.mergeVarintField(2, rawValue);
            } else {
              bitField0_ |= 0x00000002;
              receiverType_ = rawValue;
            }
            break;
          }
          case 42: {
            com.google.protobuf.ByteString bs = input.readBytes();
            bitField0_ |= 0x00000004;
            receiver_ = bs;
            break;
          }
          case 50: {
            com.google.protobuf.ByteString bs = input.readBytes();
            bitField0_ |= 0x00000008;
            content_ = bs;
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
    return top.alvinsite.chat.common.packets.Chat.internal_static_ChatMessage_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return top.alvinsite.chat.common.packets.Chat.internal_static_ChatMessage_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            top.alvinsite.chat.common.packets.ChatMessage.class, top.alvinsite.chat.common.packets.ChatMessage.Builder.class);
  }

  private int bitField0_;
  public static final int TYPE_FIELD_NUMBER = 1;
  private int type_;
  /**
   * <code>required .MessageType type = 1;</code>
   */
  public boolean hasType() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>required .MessageType type = 1;</code>
   */
  public top.alvinsite.chat.common.packets.MessageType getType() {
    top.alvinsite.chat.common.packets.MessageType result = top.alvinsite.chat.common.packets.MessageType.valueOf(type_);
    return result == null ? top.alvinsite.chat.common.packets.MessageType.LOGIN_REQ : result;
  }

  public static final int RECEIVERTYPE_FIELD_NUMBER = 2;
  private int receiverType_;
  /**
   * <code>required .ReceiverType receiverType = 2;</code>
   */
  public boolean hasReceiverType() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>required .ReceiverType receiverType = 2;</code>
   */
  public top.alvinsite.chat.common.packets.ReceiverType getReceiverType() {
    top.alvinsite.chat.common.packets.ReceiverType result = top.alvinsite.chat.common.packets.ReceiverType.valueOf(receiverType_);
    return result == null ? top.alvinsite.chat.common.packets.ReceiverType.SYSTEM : result;
  }

  public static final int RECEIVER_FIELD_NUMBER = 5;
  private volatile java.lang.Object receiver_;
  /**
   * <code>optional string receiver = 5;</code>
   */
  public boolean hasReceiver() {
    return ((bitField0_ & 0x00000004) == 0x00000004);
  }
  /**
   * <code>optional string receiver = 5;</code>
   */
  public java.lang.String getReceiver() {
    java.lang.Object ref = receiver_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        receiver_ = s;
      }
      return s;
    }
  }
  /**
   * <code>optional string receiver = 5;</code>
   */
  public com.google.protobuf.ByteString
      getReceiverBytes() {
    java.lang.Object ref = receiver_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      receiver_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CONTENT_FIELD_NUMBER = 6;
  private volatile java.lang.Object content_;
  /**
   * <code>optional string content = 6;</code>
   */
  public boolean hasContent() {
    return ((bitField0_ & 0x00000008) == 0x00000008);
  }
  /**
   * <code>optional string content = 6;</code>
   */
  public java.lang.String getContent() {
    java.lang.Object ref = content_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        content_ = s;
      }
      return s;
    }
  }
  /**
   * <code>optional string content = 6;</code>
   */
  public com.google.protobuf.ByteString
      getContentBytes() {
    java.lang.Object ref = content_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      content_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    if (!hasType()) {
      memoizedIsInitialized = 0;
      return false;
    }
    if (!hasReceiverType()) {
      memoizedIsInitialized = 0;
      return false;
    }
    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      output.writeEnum(1, type_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeEnum(2, receiverType_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 5, receiver_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 6, content_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, type_);
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, receiverType_);
    }
    if (((bitField0_ & 0x00000004) == 0x00000004)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, receiver_);
    }
    if (((bitField0_ & 0x00000008) == 0x00000008)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, content_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof top.alvinsite.chat.common.packets.ChatMessage)) {
      return super.equals(obj);
    }
    top.alvinsite.chat.common.packets.ChatMessage other = (top.alvinsite.chat.common.packets.ChatMessage) obj;

    boolean result = true;
    result = result && (hasType() == other.hasType());
    if (hasType()) {
      result = result && type_ == other.type_;
    }
    result = result && (hasReceiverType() == other.hasReceiverType());
    if (hasReceiverType()) {
      result = result && receiverType_ == other.receiverType_;
    }
    result = result && (hasReceiver() == other.hasReceiver());
    if (hasReceiver()) {
      result = result && getReceiver()
          .equals(other.getReceiver());
    }
    result = result && (hasContent() == other.hasContent());
    if (hasContent()) {
      result = result && getContent()
          .equals(other.getContent());
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
    hash = (19 * hash) + getDescriptorForType().hashCode();
    if (hasType()) {
      hash = (37 * hash) + TYPE_FIELD_NUMBER;
      hash = (53 * hash) + type_;
    }
    if (hasReceiverType()) {
      hash = (37 * hash) + RECEIVERTYPE_FIELD_NUMBER;
      hash = (53 * hash) + receiverType_;
    }
    if (hasReceiver()) {
      hash = (37 * hash) + RECEIVER_FIELD_NUMBER;
      hash = (53 * hash) + getReceiver().hashCode();
    }
    if (hasContent()) {
      hash = (37 * hash) + CONTENT_FIELD_NUMBER;
      hash = (53 * hash) + getContent().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static top.alvinsite.chat.common.packets.ChatMessage parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static top.alvinsite.chat.common.packets.ChatMessage parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static top.alvinsite.chat.common.packets.ChatMessage parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static top.alvinsite.chat.common.packets.ChatMessage parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static top.alvinsite.chat.common.packets.ChatMessage parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static top.alvinsite.chat.common.packets.ChatMessage parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static top.alvinsite.chat.common.packets.ChatMessage parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static top.alvinsite.chat.common.packets.ChatMessage parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static top.alvinsite.chat.common.packets.ChatMessage parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static top.alvinsite.chat.common.packets.ChatMessage parseFrom(
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
  public static Builder newBuilder(top.alvinsite.chat.common.packets.ChatMessage prototype) {
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
   * Protobuf type {@code ChatMessage}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ChatMessage)
      top.alvinsite.chat.common.packets.ChatMessageOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return top.alvinsite.chat.common.packets.Chat.internal_static_ChatMessage_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return top.alvinsite.chat.common.packets.Chat.internal_static_ChatMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              top.alvinsite.chat.common.packets.ChatMessage.class, top.alvinsite.chat.common.packets.ChatMessage.Builder.class);
    }

    // Construct using top.alvinsite.chat.common.packets.ChatMessage.newBuilder()
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
      type_ = 1;
      bitField0_ = (bitField0_ & ~0x00000001);
      receiverType_ = 1;
      bitField0_ = (bitField0_ & ~0x00000002);
      receiver_ = "";
      bitField0_ = (bitField0_ & ~0x00000004);
      content_ = "";
      bitField0_ = (bitField0_ & ~0x00000008);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return top.alvinsite.chat.common.packets.Chat.internal_static_ChatMessage_descriptor;
    }

    public top.alvinsite.chat.common.packets.ChatMessage getDefaultInstanceForType() {
      return top.alvinsite.chat.common.packets.ChatMessage.getDefaultInstance();
    }

    public top.alvinsite.chat.common.packets.ChatMessage build() {
      top.alvinsite.chat.common.packets.ChatMessage result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public top.alvinsite.chat.common.packets.ChatMessage buildPartial() {
      top.alvinsite.chat.common.packets.ChatMessage result = new top.alvinsite.chat.common.packets.ChatMessage(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.type_ = type_;
      if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
        to_bitField0_ |= 0x00000002;
      }
      result.receiverType_ = receiverType_;
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000004;
      }
      result.receiver_ = receiver_;
      if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
        to_bitField0_ |= 0x00000008;
      }
      result.content_ = content_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
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
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof top.alvinsite.chat.common.packets.ChatMessage) {
        return mergeFrom((top.alvinsite.chat.common.packets.ChatMessage)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(top.alvinsite.chat.common.packets.ChatMessage other) {
      if (other == top.alvinsite.chat.common.packets.ChatMessage.getDefaultInstance()) return this;
      if (other.hasType()) {
        setType(other.getType());
      }
      if (other.hasReceiverType()) {
        setReceiverType(other.getReceiverType());
      }
      if (other.hasReceiver()) {
        bitField0_ |= 0x00000004;
        receiver_ = other.receiver_;
        onChanged();
      }
      if (other.hasContent()) {
        bitField0_ |= 0x00000008;
        content_ = other.content_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      if (!hasType()) {
        return false;
      }
      if (!hasReceiverType()) {
        return false;
      }
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      top.alvinsite.chat.common.packets.ChatMessage parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (top.alvinsite.chat.common.packets.ChatMessage) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int type_ = 1;
    /**
     * <code>required .MessageType type = 1;</code>
     */
    public boolean hasType() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required .MessageType type = 1;</code>
     */
    public top.alvinsite.chat.common.packets.MessageType getType() {
      top.alvinsite.chat.common.packets.MessageType result = top.alvinsite.chat.common.packets.MessageType.valueOf(type_);
      return result == null ? top.alvinsite.chat.common.packets.MessageType.LOGIN_REQ : result;
    }
    /**
     * <code>required .MessageType type = 1;</code>
     */
    public Builder setType(top.alvinsite.chat.common.packets.MessageType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000001;
      type_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>required .MessageType type = 1;</code>
     */
    public Builder clearType() {
      bitField0_ = (bitField0_ & ~0x00000001);
      type_ = 1;
      onChanged();
      return this;
    }

    private int receiverType_ = 1;
    /**
     * <code>required .ReceiverType receiverType = 2;</code>
     */
    public boolean hasReceiverType() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required .ReceiverType receiverType = 2;</code>
     */
    public top.alvinsite.chat.common.packets.ReceiverType getReceiverType() {
      top.alvinsite.chat.common.packets.ReceiverType result = top.alvinsite.chat.common.packets.ReceiverType.valueOf(receiverType_);
      return result == null ? top.alvinsite.chat.common.packets.ReceiverType.SYSTEM : result;
    }
    /**
     * <code>required .ReceiverType receiverType = 2;</code>
     */
    public Builder setReceiverType(top.alvinsite.chat.common.packets.ReceiverType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000002;
      receiverType_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>required .ReceiverType receiverType = 2;</code>
     */
    public Builder clearReceiverType() {
      bitField0_ = (bitField0_ & ~0x00000002);
      receiverType_ = 1;
      onChanged();
      return this;
    }

    private java.lang.Object receiver_ = "";
    /**
     * <code>optional string receiver = 5;</code>
     */
    public boolean hasReceiver() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional string receiver = 5;</code>
     */
    public java.lang.String getReceiver() {
      java.lang.Object ref = receiver_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          receiver_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string receiver = 5;</code>
     */
    public com.google.protobuf.ByteString
        getReceiverBytes() {
      java.lang.Object ref = receiver_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        receiver_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string receiver = 5;</code>
     */
    public Builder setReceiver(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
      receiver_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string receiver = 5;</code>
     */
    public Builder clearReceiver() {
      bitField0_ = (bitField0_ & ~0x00000004);
      receiver_ = getDefaultInstance().getReceiver();
      onChanged();
      return this;
    }
    /**
     * <code>optional string receiver = 5;</code>
     */
    public Builder setReceiverBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
      receiver_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object content_ = "";
    /**
     * <code>optional string content = 6;</code>
     */
    public boolean hasContent() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>optional string content = 6;</code>
     */
    public java.lang.String getContent() {
      java.lang.Object ref = content_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          content_ = s;
        }
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string content = 6;</code>
     */
    public com.google.protobuf.ByteString
        getContentBytes() {
      java.lang.Object ref = content_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        content_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string content = 6;</code>
     */
    public Builder setContent(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
      content_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string content = 6;</code>
     */
    public Builder clearContent() {
      bitField0_ = (bitField0_ & ~0x00000008);
      content_ = getDefaultInstance().getContent();
      onChanged();
      return this;
    }
    /**
     * <code>optional string content = 6;</code>
     */
    public Builder setContentBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
      content_ = value;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:ChatMessage)
  }

  // @@protoc_insertion_point(class_scope:ChatMessage)
  private static final top.alvinsite.chat.common.packets.ChatMessage DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new top.alvinsite.chat.common.packets.ChatMessage();
  }

  public static top.alvinsite.chat.common.packets.ChatMessage getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  @java.lang.Deprecated public static final com.google.protobuf.Parser<ChatMessage>
      PARSER = new com.google.protobuf.AbstractParser<ChatMessage>() {
    public ChatMessage parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new ChatMessage(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ChatMessage> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ChatMessage> getParserForType() {
    return PARSER;
  }

  public top.alvinsite.chat.common.packets.ChatMessage getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

