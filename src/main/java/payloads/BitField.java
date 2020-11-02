package main.java.payloads;

import main.java.messages.Message;
import main.java.messages.MessageType;

public class BitField extends Message {

  private byte[] bitfield;

  public BitField(MessageType messageType, String messagePayload, byte[] bitfield) {
    super(messageType, messagePayload);
    this.bitfield = bitfield;
  }

  public byte[] getBitField() {
    return bitfield;
  }
}
