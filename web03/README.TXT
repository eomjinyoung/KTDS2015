1. 의존 라이브러리 가져오기
2. 스프링 MVC 설정하기
1) web.xml에 DispatcherServlet 추가 => 서블릿 이름은 "ktds"로 한다.
2) DispatcherServlet이 사용할 설정 파일 추가
   파일명: 서블릿이름-servlet.xml => ktds-servlet.xml
   파일을 두는 위치: WEB-INF/ktds-servlet.xml

2) web.xml에 입력 파라미터의 한글 처리 필터 추가
  서블릿 클래스: org.springframework.web.filter.CharacterEncodingFilter
  
3. BoardControl 클래스 작성
1) BoardControl 클래스 생성
2) 페이지 컨트롤러 역할을 할 클래스임을 설정한다.
   클래스 선언부에 표식(@Controller)을 붙여라!
3) 어떤 URL의 요청을 처리할지 설정한다.
-클래스 선언부에 표식(@RequestMapping)을 붙인다.
-@RequestMapping 애노테이션에 URL을 설정한다.
 @RequestMapping("URL")      

4. 요청 처리 메서드 만들기
1) 특정 URL에 대해 호출될 메서드를 정의한다.
   ex) public String list() {}
2) 메서드 선언부에 URL을 지정한다.
   ex) 
   @RequestMapping("/list")
   public String list() {}   

3) 메서드가 해야할 일을 작성한다.

4) DispatcherServlet에게 JSP 주소 알려주기
- JSP URL을 리턴한다.    

5) 메서드를 실행하는데 필요한 객체가 있다면 스프링에게 요구한다.
   그러면, 컨트롤 객체를 생성할 때 설정해 줄 것이다.
   ex)
  @Autowired
  BoardDao boardDao;

6) 메서드 호출 후 JSP에게 결과를 전달하는 방법
  메서드 선언부에 빈 바구니 달라고 요청하라!
  public String list(Model model) { }
  
  model 파라미터가 바구니 역할을 한다.
  
  *주의: list() 메서드를 호출하는 것은 누규? DispatcherServlet
  list() 메서드에 Model 객체를 만들어 전달하는 것은 누규? 
  
  Model m = new Model();
  xxxx.list(m);
  
5. 스프링 DispatcherServlet 설정파일 변경하기
1) 스프링에 SqlSessionFactory 설정하기
- 스프링과 mybatis를 연동해주는 라이브러리 가져온다.
  mvnrepository 검색(mybatis-spring) -> build.gradle에 추가 -> build 수행
-   
  
  
  
  
  
  
  
  
  












   
   
   
   
   
   
   
