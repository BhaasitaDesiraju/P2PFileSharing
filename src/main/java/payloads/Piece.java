package main.java.payloads;

import main.java.messages.Message;
import main.java.messages.MessageType;

public class Piece extends Message {

  private int index;
  private byte[] content;

  public Piece(MessageType messageType, String messagePayload, int index, byte[] content) {
    super(messageType, messagePayload);
    this.index = index;
    this.content = content;
  }

  public int getIndex() {
    return index;
  }

  public byte[] getContent() {
    return content;
  }

}
