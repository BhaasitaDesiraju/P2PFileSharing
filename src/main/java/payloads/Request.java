package main.java.payloads;

import main.java.messages.Message;
import main.java.messages.MessageType;

public class Request extends Message {

  private int index;

  public Request(MessageType messageType, String messagePayload, int index) {
    super(messageType, messagePayload);
    this.index = index;
  }

  public int getIndex() {
    return index;
  }
}
