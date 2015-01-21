package ktds.board;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import ktds.dao.BoardDao;
import ktds.domain.Board;

public class BoardAdd extends GenericServlet {
  @Override
  public void service(ServletRequest request, ServletResponse response) 
      throws ServletException, IOException {
    
    request.setCharacterEncoding("UTF-8");
    
    new BoardDao().insert(new Board()
              .setTitle(request.getParameter("title"))
              .setContents(request.getParameter("contents")));
      
    ((HttpServletResponse)response).sendRedirect("list");
      
    
  }
}













