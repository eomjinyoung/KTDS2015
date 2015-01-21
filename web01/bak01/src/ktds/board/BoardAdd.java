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

public class BoardAdd extends GenericServlet {
  @Override
  public void service(ServletRequest request, ServletResponse response) 
      throws ServletException, IOException {
    Connection con = null;
    Statement stmt = null;
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>등록결과</title>"
        + "<meta http-equiv='Refresh' content='1;url=list'>"
        + "</head>");
    
    try {
      //1. 사용자가 보낸 데이터를 변수에 담는다.
      request.setCharacterEncoding("UTF-8");
      String title = request.getParameter("title");
      String contents = request.getParameter("contents");
      
      //2. 사용자가 보낸 데이터를 가지고 SQL문을 준비한다.
      String sql = "insert into boards(title, contents, create_date)"
          + " values('" + title + "','" + contents + "',now())";
      
      
      //3. JDBC 드라이버 클래스를 로딩한다.
      Class.forName("com.mysql.jdbc.Driver");
      
      //4. DriverManager의 도움을 받아 DB에 연결한다.
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost/ktds", "root", "1234");
      
      //5. SQL을 DBMS 전달할 도구를 준비한다.
      stmt = con.createStatement();
      
      //6. SQL문을 서버에 전달한다.
      stmt.executeUpdate(sql);
      
      //7. 웹브라우저에 등록완료 메시지를 보낸다.
      out.println("<body><h1>등록성공입니다.</h1></body></html>");
      
    } catch (Exception e) {
      e.printStackTrace();
      out.println("<body><h1>등록실패입니다!</h1></body></html>");
    
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
}













