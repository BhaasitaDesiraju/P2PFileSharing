package main.java.payloads;

import main.java.messages.Message;
import main.java.messages.MessageType;

public class Interested extends Message {

  public Interested(MessageType messageType, String messagePayload) {
    super(messageType, null);
  }
}
