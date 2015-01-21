package ktds.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class BoardAdd extends GenericServlet {
  @Override
  public void service(ServletRequest request, ServletResponse response) 
      throws ServletException, IOException {
    Connection con = null;
    Statement stmt = null;
    
    try {
      request.setCharacterEncoding("UTF-8");
      String title = request.getParameter("title");
      String contents = request.getParameter("contents");
      
      String sql = "insert into boards(title, contents, create_date)"
          + " values('" + title + "','" + contents + "',now())";
      
      Class.forName("com.mysql.jdbc.Driver");
      
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost/ktds", "root", "1234");
      
      stmt = con.createStatement();
      
      stmt.executeUpdate(sql);
      
      ((HttpServletResponse)response).sendRedirect("list");
      
    } catch (Exception e) {
      e.printStackTrace();
    
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
}













