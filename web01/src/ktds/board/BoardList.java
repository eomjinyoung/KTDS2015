package ktds.board;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import ktds.dao.BoardDao;

@WebServlet("/board/list")
public class BoardList extends GenericServlet {

  @Override
  public void service(ServletRequest request, ServletResponse response) 
      throws ServletException,
      IOException {
    request.setAttribute("list", new BoardDao().selectList());
    
    RequestDispatcher rd = request.getRequestDispatcher(
        "/board/list.jsp");
    rd.forward(request, response);
  }

}




