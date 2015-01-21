package ktds.extra;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class MiniWebBrowser {

  public static void main(String[] args) throws Exception {
    Socket socket = new Socket("www.naver.com", 80);
    
    InputStream in = socket.getInputStream();
    OutputStream out = socket.getOutputStream();
    
    Scanner scanner = new Scanner(in);
    PrintStream writer = new PrintStream(out);
    
    writer.println("GET / HTTP/1.1");
    writer.println("Host: www.naver.com");
    writer.println();
    
    String line = null;
    while(true) {
      try {
        line = scanner.nextLine();
        System.out.println(line);
      } catch (Exception e) {
        break;
      }
    } 
    
    try {writer.close();} catch(Exception e) {}
    try {scanner.close();} catch(Exception e) {}
    try {socket.close();} catch(Exception e) {}
  }

}










