package main.java.payloads;

import main.java.messages.Message;
import main.java.messages.MessageType;

public class NotInterested extends Message {

  public NotInterested(MessageType messageType, String messagePayload) {
    super(messageType, null);
  }
}
