package main.java.peers;

import main.java.com.CommonProperties;
import main.java.com.PeerInfo;
import main.java.com.PeerInfoProperties;
import main.java.util.Constants;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PeerProcess {

  private int peerID;
  private String peerAddress;
  private int portNumber;
  private int hasFile;
  private List<PeerInfo> connectToPeers;
  PeerProcess(int peerID) {
    this.peerID = peerID;
    this.peerAddress = Constants.LOCALHOST;
    this.portNumber = Constants.FIRST_PEER_PORT_NUMBER;
    this.hasFile = Constants.NO_FILE;
    this.connectToPeers = new ArrayList<>();
  }

  public void connectPeers() {
    try{
      PeerInfoProperties peerInfo = new PeerInfoProperties();
      CommonProperties commonInfo = new CommonProperties();
      BufferedReader commonPropsReader = new BufferedReader(new FileReader(Constants.COMMON_CONFIG_FILE));
      commonInfo.read(commonPropsReader);
      BufferedReader peerInfoReader = new BufferedReader(new FileReader(Constants.PEER_CONFIG_FILE));
      peerInfo.read(peerInfoReader);
      //loop through all peers and compare ids
      for(PeerInfo peer: peerInfo.getPeers()) {
        if(peerID == peer.getPeerID()) {
          peerAddress = peer.getHostName();
          portNumber = peer.getListeningPort();
          hasFile = peer.getHasFile();
        } else {
            connectToPeers.add(peer);
        }
      }
      commonPropsReader.close();
      peerInfoReader.close();

      //creating a new process - peer process and intialize it
    }
    catch (FileNotFoundException e) {
      System.out.println("File not found "+e);
    }
    catch (IOException e) {
      System.out.println("Unable to read peer info "+e);
    }
  }

  public int getPeerID() {
    return peerID;
  }

  public String getPeerAddress() {
    return peerAddress;
  }

  public int getPortNumber() {
    return portNumber;
  }

  public int getHasFile() {
    return hasFile;
  }

  public List<PeerInfo> getConnectToPeers() {
    return connectToPeers;
  }
}
