package ktds.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmailControl {
  
  @Autowired
  JavaMailSender mailSender;
  
  @RequestMapping("/email/send")
  public String send(String to, String subject, String content) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("아이디@gmail.com");
    message.setTo(to);
    message.setSubject(subject);
    message.setText(content);
    mailSender.send(message);
    return "/email/sendResult.jsp";
  }
 
      
}








