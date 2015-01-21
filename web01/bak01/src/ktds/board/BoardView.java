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

@WebServlet("/board/view")
public class BoardView extends GenericServlet {

  @Override
  public void service(ServletRequest request, ServletResponse response) 
      throws ServletException,
      IOException {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>게시물 상세보기</title></head>");
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost/ktds", "root", "1234");
      stmt = con.createStatement();
      
      String sql = "select bno,title,contents,cnt,create_date"
          + " from boards"
          + " where bno=" + request.getParameter("no");
      
      rs = stmt.executeQuery(sql);
      
      out.println("<body><h1>게시물 상세보기</h1>");
      
      if (rs.next()) {
        out.println("<form action='update' method='post'>");
        out.println("   번호:<input name='no' type='text' readonly "
            + " value='" + rs.getInt("bno") 
            + "'><br>");
        out.println("   제목:<input name='title' type='text' "
            + " value='" + rs.getString("title") 
            + "'><br>");
        out.println("   내용:<textarea name='contents'>"
            + rs.getString("contents") 
            + "</textarea><br>");
        out.println("   조회수: " + rs.getInt("cnt") + "<br>");
        out.println("   등록일: " + rs.getDate("create_date") + "<br>");
        out.println("  <button type='submit'>변경</button>");
        out.println("  <button type='button'"
            + " onclick='onDelete(" + rs.getInt("bno")
            + ")'>삭제</button>");
        out.println("  <button type='button'>취소</button>");
        out.println("</form>");
        out.println("<script>");
        out.println("  function onDelete(no) {");
        out.println("    location.href = 'delete?no=' + no;");
        out.println("  }");
        out.println("</script>");
      } else {
        out.println("<h1>해당 게시물이 존재하지 않습니다!</h1>");
      }
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




