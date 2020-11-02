package main.java.messages;

public class Message {

  private int messageLength;
  private MessageType messageType;
  private String messagePayload;

  public Message(MessageType messageType, String messagePayload) {
    this.messageType = messageType;
    this.messagePayload = messagePayload;
    if(messagePayload == null) {
      messageLength = 0;
    } else {
      messageLength = messagePayload.length()+1;
    }
  }

  public int getMessageLength() {
    return messageLength;
  }

  public MessageType getMessageType() {
    return messageType;
  }

  public String getMessagePayload() {
    return messagePayload;
  }
}
