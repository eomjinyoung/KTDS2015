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

import ktds.dao.BoardDao;
import ktds.domain.Board;

@WebServlet("/board/view")
public class BoardView extends GenericServlet {

  @Override
  public void service(ServletRequest request, ServletResponse response) 
      throws ServletException,
      IOException {
    request.setAttribute("board", new BoardDao().selectOne(
        Integer.parseInt(request.getParameter("no"))));
    
    RequestDispatcher rd = request.getRequestDispatcher(
        "/board/view.jsp");
    rd.forward(request, response);
    
  }

}




