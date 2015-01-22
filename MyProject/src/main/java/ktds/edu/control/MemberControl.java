package ktds.edu.control;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import ktds.edu.dao.MemberDao;
import ktds.edu.domain.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member")
public class MemberControl {
  @Autowired
  MemberDao memberDao;
  
  @Autowired
  ServletContext context; // 웹 애플리케이션 정보를 알아내는 도구
  
  // http://localhost:8080/MyProject/member/signUp.do
  @RequestMapping("/signUp")
  public String signUp(Member member, MultipartFile file) {
    String realPath = context.getRealPath("/files");
    String filename = "photo_" + System.currentTimeMillis();
    
    try {
      file.transferTo(new File(realPath + "/" + filename));
      member.setPhoto(filename);
      memberDao.insert(member);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "redirect:../";
  }
  
  @RequestMapping(value="/login", method=RequestMethod.POST)
  public String login(String id, String password, HttpSession session) {
    Member member = memberDao.getLoginInfo(id, password);
    if (member != null) {
      // 로그인을 성공한다면, 로그인 기본 정보를 세션에 보관한다.
      session.setAttribute("loginInfo", member);
      return "redirect:../";
    } else {
      return "redirect:login.html";
    }
  }
  
  @RequestMapping("/logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:../";
  }
  
  @RequestMapping("/check")
  public ModelAndView check(String id) {
    ModelAndView mv = new ModelAndView();
    if (memberDao.exist(id)) { // 존재할 경우
      mv.addObject("checkId", id);
    }
    mv.setViewName("/member/check.jsp");
    return mv;
  }
}












































