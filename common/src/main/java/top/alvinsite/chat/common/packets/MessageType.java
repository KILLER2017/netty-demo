// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat.proto

package top.alvinsite.chat.common.packets;

/**
 * Protobuf enum {@code MessageType}
 */
public enum MessageType
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>LOGIN_REQ = 1;</code>
   */
  LOGIN_REQ(1),
  /**
   * <code>LOGIN_RESP = 2;</code>
   */
  LOGIN_RESP(2),
  /**
   * <code>HEARTBEAT_REQ = 3;</code>
   */
  HEARTBEAT_REQ(3),
  /**
   * <code>HEARTBEAT_RESP = 4;</code>
   */
  HEARTBEAT_RESP(4),
  /**
   * <code>CHAT_REQ = 5;</code>
   */
  CHAT_REQ(5),
  /**
   * <code>CHAT_RESP = 6;</code>
   */
  CHAT_RESP(6),
  /**
   * <code>LOGOUT_REQ = 7;</code>
   */
  LOGOUT_REQ(7),
  /**
   * <code>LOGOUT_RESP = 8;</code>
   */
  LOGOUT_RESP(8),
  /**
   * <code>OTHERS = 10;</code>
   */
  OTHERS(10),
  ;

  /**
   * <code>LOGIN_REQ = 1;</code>
   */
  public static final int LOGIN_REQ_VALUE = 1;
  /**
   * <code>LOGIN_RESP = 2;</code>
   */
  public static final int LOGIN_RESP_VALUE = 2;
  /**
   * <code>HEARTBEAT_REQ = 3;</code>
   */
  public static final int HEARTBEAT_REQ_VALUE = 3;
  /**
   * <code>HEARTBEAT_RESP = 4;</code>
   */
  public static final int HEARTBEAT_RESP_VALUE = 4;
  /**
   * <code>CHAT_REQ = 5;</code>
   */
  public static final int CHAT_REQ_VALUE = 5;
  /**
   * <code>CHAT_RESP = 6;</code>
   */
  public static final int CHAT_RESP_VALUE = 6;
  /**
   * <code>LOGOUT_REQ = 7;</code>
   */
  public static final int LOGOUT_REQ_VALUE = 7;
  /**
   * <code>LOGOUT_RESP = 8;</code>
   */
  public static final int LOGOUT_RESP_VALUE = 8;
  /**
   * <code>OTHERS = 10;</code>
   */
  public static final int OTHERS_VALUE = 10;


  public final int getNumber() {
    return value;
  }

  /**
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static MessageType valueOf(int value) {
    return forNumber(value);
  }

  public static MessageType forNumber(int value) {
    switch (value) {
      case 1: return LOGIN_REQ;
      case 2: return LOGIN_RESP;
      case 3: return HEARTBEAT_REQ;
      case 4: return HEARTBEAT_RESP;
      case 5: return CHAT_REQ;
      case 6: return CHAT_RESP;
      case 7: return LOGOUT_REQ;
      case 8: return LOGOUT_RESP;
      case 10: return OTHERS;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<MessageType>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      MessageType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<MessageType>() {
          public MessageType findValueByNumber(int number) {
            return MessageType.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return top.alvinsite.chat.common.packets.Chat.getDescriptor()
        .getEnumTypes().get(0);
  }

  private static final MessageType[] VALUES = values();

  public static MessageType valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private MessageType(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:MessageType)
}

