package ktds.extra;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MiniWebServer {

  public static void main(String[] args) throws Exception {
    ServerSocket ss = new ServerSocket(9999);
    Socket socket = ss.accept();
    
    InputStream in = socket.getInputStream();
    OutputStream out = socket.getOutputStream();
    
    Scanner scanner = new Scanner(in);
    PrintStream writer = new PrintStream(out);

    // 웹 브라우저가 보내온 데이터를 출력
    String line = null;
    while(true) {
      try {
        line = scanner.nextLine();
        System.out.println(line);
        if (line.equals(""))
          break;
      } catch (Exception e) {
        break;
      }
    } 
    System.out.println("---------");
    
    // 웹 브라우저에게 응답
    writer.println("HTTP/1.1 200 ok");
    writer.println();
    writer.println("hello");
    
    try {writer.close();} catch(Exception e) {}
    try {scanner.close();} catch(Exception e) {}
    try {socket.close();} catch(Exception e) {}
    try {ss.close();} catch(Exception e) {}
  }

}













