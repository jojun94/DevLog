# Spring MVC 처리 순서

1. 클라이언트(client) 가 서버에 어떤 요청(Request)을 한다면 DispatcherServlet 이라는 클래스(일종의 front controller)가 요청을 가로챈다.

   + web.xml 에서 url에 서블릿 매핑을 하여 모든 요청을 DispatcherServlet이 가로채게 설정 (변경 가능)

2. 요청을 가로챈 DispatcherServlet은 HandlerMapping(URL 분석 등)에게 어떤 컨트롤러에게 요청을 위임하면 좋을지 질의한다.

   + servlet-context.xml에서 @Controller를 스캔하여 찾아준다.

3. 요청에 매핑된 컨트롤러가 있다면 @RequestMapping을 통하여 요청을 처리할 메서드에 도달한다.

4. 컨트롤러에서는 해당 요청을 처리할 Service를 주입받아(DI) 비즈니스 로직을 Service에 위임한다.

5. Service에서는 요청에 필요한 작업의 대부분을 담당하며, 터베이스에 접근이 필요하면 DAO를 주입받아 DB처리는 DAO에게 위임한다.

6. DAO는 Mybatis 또는 Hibernate 등을 이용하여 SQL 쿼리를 수행하여 DB의 정보를 받아 서비스에게 다시 돌려준다.

   + 이 때 보통 VO(DTO)를 컨트롤러에서 부터 내려받아 쿼리의 결과를 VO에 담는다.

7. 모든 로직을 끝낸 서비스가 결과를 컨트롤러에게 반환한다.

8. 결과를 받은 컨트롤러는 Model 객체에 결과물로 View에 대한 정보를 담아 DispatcherServlet에게 보낸다.

9. DispatcherServlet은 ViewResolver에게 View에 대한 정보를 보낸다.

10. ViewResolver는 해당 JSP를 찾아서(응답할 View) DispatcherServlet에게 알려준다.

    (servlet-context.xml에서 suffix, prefix를 통해 /WEB-INF/views/index.jsp 이렇게 만들어주는 것도 ViewResolver이다.)

11. DispatcherServlet은 응답할 View에게 Render를 지시하고 View는 응답 로직을 처리한다.

12. 결과적으로 DispatcherServlet이 클라이언트에게 렌더링된 View를 응답한다.



+ Spring에서는 위와 같은 일련의 과정을 거쳐 요청에 대한 응답을 MVC 패턴을 이용하여 처리한다.



> 참고 
>
> https://jeong-pro.tistory.com/96