package ktds.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/board/list")
public class BoardList extends GenericServlet {

  @Override
  public void service(ServletRequest request, ServletResponse response) 
      throws ServletException,
      IOException {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>게시물 목록</title></head>");
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost/ktds", "root", "1234");
      stmt = con.createStatement();
      
      String sql = "select bno,title,cnt,create_date from boards";
      rs = stmt.executeQuery(sql);
      
      out.println("<body><h1>게시물 목록</h1>");
      out.println("<table>");
      out.println("<tr><!--table row-->");
      out.println("  <th>번호</th> <!--table header-->");
      out.println("  <th>제목</th>");
      out.println("  <th>조회수</th>");
      out.println("  <th>등록일</th>");
      out.println("</tr>  ");
      while(rs.next()) {
        out.println("<tr>");
        out.println("  <td>" + rs.getInt("bno") + "</td><!--table data-->");
        out.println("  <td><a href='view?no=" + rs.getInt("bno")
            + "'>" + rs.getString("title") + "</a></td>");
        out.println("  <td>" + rs.getInt("cnt") + "</td>");
        out.println("  <td>" + rs.getDate("create_date") + "</td>");
        out.println("</tr>");
      }
      out.println("</table>");
      out.println("<a href='form.html'>글쓰기</a><br>");
      out.println("</body></html>");
      
    } catch (Exception e) {
      e.printStackTrace();
      out.println("<body><h1>오류입니다.</h1></body></html>");
    } finally {
      try {rs.close();} catch (Exception e) {}
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }

  }

}




