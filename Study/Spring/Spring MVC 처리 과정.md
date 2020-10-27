# Spring MVC Overview



![](http://terasolunaorg.github.io/guideline/1.0.1.RELEASE/en/_images/RequestLifecycle.png)

- 요청을 받은 후 응답을 할 때 까지의 처리 흐름은 위와 같다.

#### Details

- `DispatcherServlet` receives the request.

  > `DispatcherServlet` 가 요청을 받는다.

- `DispatcherServlet` dispatches the task of selecting an appropriate `controller` to `HandlerMapping`. `HandlerMapping` selects the controller which is mapped to the incoming request URL and returns the `(selected Handler)` and `Controller` to `DispatcherServlet`.

  > `DispatcherServlet` 이 적절한 `controller` 를 선정하여 `HandlerMapping`에 전달한다.
  >
  > `HandlerMapping`은  요청한 URL과 매핑되는 `controller` 를 선택하고,  `(selected Handler)` 와 `Controller` 를  `DispatcherServlet` 에 반환한다.

- `DispatcherServlet` dispatches the task of executing of business logic of `Controller` to `HandlerAdapter`.

  > `DispatcherServlet` 은 `Controller` 의 비즈니스 로직의 실행 과업을 `HandlerAdapter`에게 전달한다.

- `HandlerAdapter` calls the business logic process of `Controller`.

  > `HandlerAdapter` 은  `Controller` 의 비즈니스 로직의 실행 과정을 호출한다.

- `Controller` executes the business logic, sets the processing result in `Model` and returns the logical name of view to `HandlerAdapter`.

  > `Controller`  비즈니스 로직을 실행하고, 실행 결과를 `Model` 안에 설정하고 뷰의 논리적 이름을 `HandlerAdapter`에 반환한다.

- `DispatcherServlet` dispatches the task of resolving the `View` corresponding to the View name to `ViewResolver`. `ViewResolver` returns the `View` mapped to View name.

  > `DispatcherServlet` 은 `ViewResolver`에 뷰 이름에 해당하는 뷰의 논리적 이름을 전달한다.`ViewResolver` 는 뷰 네임에 매핑된 뷰를 반환한다.

- `DispatcherServlet` dispatches the rendering process to returned `View`.

  > `DispatcherServlet` 는 반환된 뷰로 렌더링 과정을 전달한다.

- `View` renders `Model` data and returns the response.

  > `View` 는 `Model`  데이터를 렌더하고, 응답을 반환한다.







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
> http://terasolunaorg.github.io/guideline/1.0.1.RELEASE/en/Overview/SpringMVCOverview.html#id2
>
> https://jeong-pro.tistory.com/96