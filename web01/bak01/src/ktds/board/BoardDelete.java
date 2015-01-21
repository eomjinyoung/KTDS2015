package ktds.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/delete")
public class BoardDelete extends GenericServlet {
  @Override
  public void service(ServletRequest request, ServletResponse response) 
      throws ServletException, IOException {
    Connection con = null;
    Statement stmt = null;
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>삭제결과</title></head>");
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost/ktds", "root", "1234");
      stmt = con.createStatement();
      stmt.executeUpdate("delete from boards where bno=" 
          + request.getParameter("no"));
      
      out.println("<body><h1>삭제 성공입니다.</h1></body></html>");
      
      ((HttpServletResponse)response).setHeader(
          "Refresh", "1;url=list");
    } catch (Exception e) {
      e.printStackTrace();
      out.println("<body><h1>삭제 실패입니다!</h1></body></html>");
    
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
}













