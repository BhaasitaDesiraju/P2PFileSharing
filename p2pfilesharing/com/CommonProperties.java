package com;

import util.Constants;

import java.io.*;

public class CommonProperties {

  private static int numberOfPreferredNeighbors;
  private static int unchokingInterval;
  private static int optimisticUnchokingInterval;
  private static String fileName;
  private static int fileSize;
  private static int pieceSize;

  public void read(Reader reader) throws IOException {
    try {
      BufferedReader bufferedReader = new BufferedReader(new FileReader(Constants.COMMON_CONFIG_FILE));
      while (bufferedReader.readLine() != null) {
        String line = bufferedReader.readLine();
        String[] tokens = line.split(" ");
        String name = tokens[0];
        int value = Integer.parseInt(tokens[1]);
        switch (name) {
          case "NumberOfPreferredNeighbors":
            numberOfPreferredNeighbors = value;
            break;
          case "UnchokingInterval":
            unchokingInterval = value;
            break;
          case "OptimisticUnchokingInterval":
            optimisticUnchokingInterval = value;
            break;
          case "FileName":
            fileName = String.valueOf(value);
            break;
          case "FileSize":
            fileSize = value;
            break;
          case "PieceSize":
            pieceSize = value;
            break;
          default:
            throw new IOException("Invalid case");
        }
        bufferedReader.close();
      }
    } catch(FileNotFoundException e) {
        System.out.println("Invalid config file name "+e);
    }
  }

  public static int getNumberOfPreferredNeighbors() {
    return numberOfPreferredNeighbors;
  }

  public static int getUnchokingInterval() {
    return unchokingInterval;
  }

  public static int getOptimisticUnchokingInterval() {
    return optimisticUnchokingInterval;
  }

  public static String getFileName() {
    return fileName;
  }

  public static int getFileSize() {
    return fileSize;
  }

  public static int getPieceSize() {
    return pieceSize;
  }
}
