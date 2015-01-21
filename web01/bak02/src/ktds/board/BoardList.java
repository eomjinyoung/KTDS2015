package ktds.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import ktds.domain.Board;

@WebServlet("/board/list")
public class BoardList extends GenericServlet {

  @Override
  public void service(ServletRequest request, ServletResponse response) 
      throws ServletException,
      IOException {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      Class.forName("com.mysql.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost/ktds", "root", "1234");
      stmt = con.createStatement();
      
      String sql = "select bno,title,cnt,create_date from boards";
      rs = stmt.executeQuery(sql);
      
      ArrayList list = new ArrayList();
      Board b = null;
      
      while(rs.next()) {
        b = new Board();
        b.setNo( rs.getInt("bno") );
        b.setTitle( rs.getString("title") );
        b.setCount( rs.getInt("cnt") );
        b.setCreateDate( rs.getDate("create_date") );
        
        list.add(b);
      }
      
      // list.jsp가 게시물 목록을 사용할 수 있도록 request에 보관한다.
      request.setAttribute("list", list);
      
      RequestDispatcher rd = request.getRequestDispatcher(
          "/board/list.jsp");
      rd.forward(request, response);
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      try {rs.close();} catch (Exception e) {}
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }

  }

}




