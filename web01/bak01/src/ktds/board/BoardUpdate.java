package ktds.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/update")
public class BoardUpdate extends GenericServlet {
  @Override
  public void service(ServletRequest request, ServletResponse response) 
      throws ServletException, IOException {
    Connection con = null;
    PreparedStatement stmt = null;
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>변경결과</title></head>");
    
    try {
      request.setCharacterEncoding("UTF-8");
      String title = request.getParameter("title");
      String contents = request.getParameter("contents");
      int no = Integer.parseInt(request.getParameter("no"));
      
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost/ktds", "root", "1234");
      
      //참고: ? => in-parameter 라 부른다.
      String sql = "update boards set"
          + " title=?,contents=?,create_date=now() where bno=?";

      stmt = con.prepareStatement(sql);
      stmt.setString(1, title);
      stmt.setString(2, contents);
      stmt.setInt(3, no);
      
      stmt.executeUpdate();
      
      out.println("<body><h1>변경 성공입니다.</h1></body></html>");
      
      ((HttpServletResponse)response).sendRedirect("list");
      
    } catch (Exception e) {
      e.printStackTrace();
      out.println("<body><h1>변경 실패입니다!</h1></body></html>");
    
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
}













