package ktds.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class DBConnectionPool {
  static ArrayList<Connection> connList = new ArrayList<Connection>();
  
  static {
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public static Connection getConnection() throws Exception {
    if (connList.size() > 0) {
      return connList.remove(0);
      
    } else {
      return DriverManager.getConnection(
          "jdbc:mysql://localhost/ktds", "root", "1234");
    }
  }
  
  public static void returnConnection(Connection conn) {
    connList.add(conn);
  }
}








