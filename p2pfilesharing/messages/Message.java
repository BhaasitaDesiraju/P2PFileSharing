package messages;

import payloads.Payload;

import java.io.Serializable;

public class Message implements Serializable {

  private int messageLength;
  private MessageType messageType;
  private Payload messagePayload;
  private static final long serialVersionUID = -2925592711545151885L;

  public Message(MessageType messageType, Payload messagePayload) {
    this.messageType = messageType;
    this.messagePayload = messagePayload;
    if(messagePayload == null) {
      messageLength = 0;
    } else {
      messageLength = messagePayload.getMessageLength()+1;
    }
  }

  public int getMessageLength() {
    return messageLength;
  }

  public MessageType getMessageType() {
    return messageType;
  }

  public Payload getMessagePayload() {
    return messagePayload;
  }
}
