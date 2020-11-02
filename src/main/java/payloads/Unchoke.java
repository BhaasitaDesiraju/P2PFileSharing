package main.java.payloads;

import main.java.messages.Message;
import main.java.messages.MessageType;

public class Unchoke extends Message {

  public Unchoke(MessageType messageType, String messagePayload) {
    super(messageType, null);
  }
}
