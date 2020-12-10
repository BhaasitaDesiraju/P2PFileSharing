package main.java.log;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class WriteLog {

  private PrintWriter logFile;
  private int peerID;

  public WriteLog() {

  }

  public WriteLog(int peerID) {
    try {
      this.peerID = peerID;
      logFile = new PrintWriter("log_peer_" + peerID + ".log");
    }
    catch (FileNotFoundException e) {
      System.out.println("Log writer not created " + e);
    }
  }

  public PrintWriter getLogFile() {
    return logFile;
  }

  public int getPeerID() {
    return peerID;
  }

  //TCP Connections
  public void connectToPeer(int peerIDToConnect) {
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime time = LocalDateTime.now();
    logFile.println(String.format("[%s]: Peer [%s] makes a connection to peer [%s]", dateFormat.format(time),
                                  peerID, peerIDToConnect));
    logFile.flush();
  }

  public void connectFromPeer(int connectingPeerID) {
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime time = LocalDateTime.now();
    logFile.println(String.format("[%s]: Peer [%s] is connected from peer [%s]", dateFormat.format(time),
                                  peerID, connectingPeerID));
    logFile.flush();
  }

  //change of preferred neighbors
  public void changeNeighbour(ArrayList<Integer> neighbouringPeers) {
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime time = LocalDateTime.now();
    logFile.println(String.format("[%s]: Peer [%s] has the preferred neighbors [%s]", dateFormat.format(time),
                                  peerID, neighbouringPeers));
    logFile.flush();
  }

  //change of optimistically unchoked neighbor
  public void changeOptimisticallyUnchokedNeighbor(int unchokedNeighbor) {
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime time = LocalDateTime.now();
    logFile.println(String.format("[%s]: Peer [%s] has the optimistically unchoked neighbor [%s]",
                                  dateFormat.format(time), peerID, unchokedNeighbor));
    logFile.flush();
  }

  //when a peer is unchoked by a neighbor
  public void unchokedByNeighbor(int unchokedPeerID){
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime time = LocalDateTime.now();
    logFile.println(String.format("[%s]: Peer [%s] is unchoked by [%s]",
                                  dateFormat.format(time), peerID, unchokedPeerID));
    logFile.flush();
  }

  //when a peer is choked by a neighbor
  public void chokedByNeighbor(int chokedPeerID){
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime time = LocalDateTime.now();
    logFile.println(String.format("[%s]: Peer [%s] is choked by [%s]",
                                  dateFormat.format(time), peerID, chokedPeerID));
    logFile.flush();
  }

  //when a peer receives a 'have' message
  public void receiveHaveMessage(int receivedFromPeer, int pieceIndex){
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime time = LocalDateTime.now();
    logFile.println(String.format("[%s]: Peer [%s] received the 'have' message from [%s] for the piece [%s]",
                                  dateFormat.format(time), peerID, receivedFromPeer, pieceIndex));
    logFile.flush();
  }

  //when a peer receives a 'interested' message
  public void receiveInterestedMessage(int receivedFromPeer){
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime time = LocalDateTime.now();
    logFile.println(String.format("[%s]: Peer [%s] received the 'interested' message from [%s]",
                                  dateFormat.format(time), peerID, receivedFromPeer));
    logFile.flush();
  }

  //when a peer receives a 'not interested' message
  public void receiveUninterestedMessage(int receivedFromPeer){
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime time = LocalDateTime.now();
    logFile.println(String.format("[%s]: Peer [%s] received the 'not interested' message from [%s]",
                                  dateFormat.format(time), peerID, receivedFromPeer));
    logFile.flush();
  }

  //when a peer completes downloading a piece
  public void finishDownloadingPiece(int senderPeer, int pieceIndex, int numOfPieces){
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime time = LocalDateTime.now();
    logFile.println(String.format("[%s]: Peer [%s] has downloaded the piece [%s] from [%s]. " +
                                  "Now the number of pieces  it has is [%s]",
                                  dateFormat.format(time), peerID, pieceIndex, senderPeer, numOfPieces));
    logFile.flush();
  }

  //when a peer completes downloading a file
  public void completedDownload (){
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime time = LocalDateTime.now();
    logFile.println(String.format("[%s]: Peer [%s] has downloaded the complete file",
                                  dateFormat.format(time), peerID));
    logFile.flush();
  }
}
