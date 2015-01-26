package ktds.control;

import ktds.dao.BoardDao;
import ktds.domain.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
public class BoardControl {
  
  //스프링에게 필요한 객체를 요구한다.
  // "나 BoardDao 객체가 필요하니까, BoardControl 객체를 만들 때 설정해줘!"
  @Autowired
  BoardDao boardDao;
  
  // http://localhost:8080/web03/board/list.do 요청을 처리하는 메서드!
  @RequestMapping("/list")
  public String list(
      @RequestParam(defaultValue="1") int pageNo, 
      Model model) {
    int pageSize = 4;
    int startIndex = (pageNo - 1) * pageSize;
    int totalCount = boardDao.totalCount(); 
    int totalPage =  totalCount / pageSize;
    if ((totalCount % pageSize) > 0)
      totalPage++;
    
    model.addAttribute("list", boardDao.selectList(startIndex, pageSize));
    model.addAttribute("pageNo", pageNo);
    model.addAttribute("totalPage", totalPage);
    return "/board/list.jsp";
  }
  
  @RequestMapping("/add")
  public String add(Board board) {
    boardDao.insert(board);
    return "redirect:list.do";
  }
  
  @RequestMapping("/view")
  public String view(int no, Model model) {
    model.addAttribute("board", boardDao.selectOne(no));
    return "/board/view.jsp";
  }
  
  @RequestMapping("/delete")
  public String delete(int no) {
    boardDao.delete(no);
    return "redirect:list.do";
  }
  
  @RequestMapping("/update")
  public String update(Board board) {
    boardDao.update(board);
    return "redirect:list.do";
  }
  
      
}








