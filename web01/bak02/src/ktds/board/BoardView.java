package ktds.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import ktds.domain.Board;

@WebServlet("/board/view")
public class BoardView extends GenericServlet {

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
      
      String sql = "select bno,title,contents,cnt,create_date"
          + " from boards"
          + " where bno=" + request.getParameter("no");
      
      rs = stmt.executeQuery(sql);
      
      if (rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("bno"));
        board.setTitle(rs.getString("title"));
        board.setContents(rs.getString("contents"));
        board.setCount(rs.getInt("cnt"));
        board.setCreateDate(rs.getDate("create_date"));
        
        request.setAttribute("board", board);
      }
      
      RequestDispatcher rd = request.getRequestDispatcher(
          "/board/view.jsp");
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




