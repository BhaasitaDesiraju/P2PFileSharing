package messages;

import util.Constants;

import java.io.*;

public class Handshake implements Serializable {

  private String header = Constants.HANDSHAKE_HEADER;
  private String zeroBits;
  private int peerID;
  private static final long serialVersionUID = -1482860868859618509L;


  public Handshake(int peerID) {
    this.zeroBits = Constants.ZERO_BITS;
    this.peerID = peerID;
  }

  @Override
  public String toString() {
    return String.format("Header: %s, ZeroBits: %s, PeerId: %s", header, this.zeroBits, this.peerID);
  }

  //send handshake
  public void sendHandShake(OutputStream outputStream) throws IOException {
      ObjectOutputStream outputObjectStream = new ObjectOutputStream(outputStream);
      outputObjectStream.writeObject(this);
      //sends handshake message to this.peerID
  }

  //receive handshake
  public int receiveHandShake(InputStream inputStream) throws IOException {
    try {
      ObjectInputStream inputObjectStream = new ObjectInputStream(inputStream);
      Handshake response = (Handshake) inputObjectStream.readObject();
      if(response != null) {
        return response.peerID;
      }
      return Constants.INVALID_PEER_ID;
    }
    catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return Constants.INVALID_PEER_ID;
  }

  public int getPeerID() {
    return peerID;
  }

  public String getHeader() {
    return header;
  }
}

