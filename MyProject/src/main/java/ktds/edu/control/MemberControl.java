package ktds.edu.control;

import java.io.File;

import javax.servlet.ServletContext;

import ktds.edu.dao.MemberDao;
import ktds.edu.domain.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

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
    return "redirect:../index.html";
  }
}








