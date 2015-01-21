package ktds.board;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class InitServlet extends GenericServlet {
  public static SqlSessionFactory sqlSessionFactory;
  
  @Override
  public void init() throws ServletException {
    System.out.println("InitServlet.init().....");
    super.init();
    try {
      // mybatis-config.xml => mybatis 사용을 위한 환경 정보를 설정하는 파일 
      String resource = "ktds/dao/mybatis-config.xml";
      
      // ktds.dao 패키지에 있는 mybatis-config.xml 파일을 읽을 때 사용할 도구를 준비한다.
      InputStream inputStream = Resources.getResourceAsStream(resource);
      
      // SqlSession => SQL문을 찾아서 실행하는 도구
      // SqlSessionFactory => SqlSession을 생성해주는 도구
      // SqlSessionFactoryBuilder => SqlSessionFactory를 생성하는 도구
      // 미칬나? 스마트폰 <= 삼성전자공장 <= 삼성전자공장건설사 
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException,
      IOException {}

}













