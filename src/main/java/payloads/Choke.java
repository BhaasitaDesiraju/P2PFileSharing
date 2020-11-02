package main.java.payloads;

import main.java.messages.Message;
import main.java.messages.MessageType;

public class Choke extends Message {

  public Choke(MessageType messageType, String messagePayload) {
    super(messageType, null);
  }
}
