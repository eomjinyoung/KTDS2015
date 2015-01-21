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

import ktds.dao.BoardDao;
import ktds.domain.Board;

@WebServlet("/board/update")
public class BoardUpdate extends GenericServlet {
  @Override
  public void service(ServletRequest request, ServletResponse response) 
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    
    new BoardDao().update(new Board()
    .setTitle(request.getParameter("title"))
    .setContents(request.getParameter("contents"))
    .setNo(Integer.parseInt(request.getParameter("no"))));
      
      ((HttpServletResponse)response).sendRedirect("list");
  }
}













