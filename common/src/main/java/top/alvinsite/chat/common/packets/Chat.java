// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat.proto

package top.alvinsite.chat.common.packets;

public final class Chat {
  private Chat() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ChatMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ChatMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nchat.proto\"q\n\013ChatMessage\022\032\n\004type\030\001 \002(" +
      "\0162\014.MessageType\022#\n\014receiverType\030\002 \002(\0162\r." +
      "ReceiverType\022\020\n\010receiver\030\005 \001(\t\022\017\n\007conten" +
      "t\030\006 \001(\t*\235\001\n\013MessageType\022\r\n\tLOGIN_REQ\020\001\022\016" +
      "\n\nLOGIN_RESP\020\002\022\021\n\rHEARTBEAT_REQ\020\003\022\022\n\016HEA" +
      "RTBEAT_RESP\020\004\022\014\n\010CHAT_REQ\020\005\022\r\n\tCHAT_RESP" +
      "\020\006\022\016\n\nLOGOUT_REQ\020\007\022\017\n\013LOGOUT_RESP\020\010\022\n\n\006O" +
      "THERS\020\n*/\n\014ReceiverType\022\n\n\006SYSTEM\020\001\022\010\n\004U" +
      "SER\020\002\022\t\n\005GROUP\020\003B%\n!top.alvinsite.chat.c" +
      "ommon.packetsP\001"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_ChatMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ChatMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ChatMessage_descriptor,
        new java.lang.String[] { "Type", "ReceiverType", "Receiver", "Content", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
