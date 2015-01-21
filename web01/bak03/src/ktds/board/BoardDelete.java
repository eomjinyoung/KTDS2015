package ktds.board;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

import ktds.dao.BoardDao;

@WebServlet("/board/delete")
public class BoardDelete extends GenericServlet {
  @Override
  public void service(ServletRequest request, ServletResponse response) 
      throws ServletException, IOException {
    new BoardDao().delete(Integer.parseInt(request.getParameter("no")));
    
    ((HttpServletResponse)response).sendRedirect("list");
  }
}













