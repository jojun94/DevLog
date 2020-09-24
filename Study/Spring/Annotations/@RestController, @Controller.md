# RestController와 Controller의 차이

1. @Controller와 @RestController의 차이

> HTTP Response Body가 생성되는 방식의 차이.
>
> 
>
> 기존의 MVC @Controller는 View 기술을 사용하지만, @RestController는 객체를 반환할때 객체 데이터는 바로 JSON/XML 타입의 HTTP 응답을 직접 리턴하게 된다.
>
> 
>
> @Controller의 메서드에 @ResponseBody를 선언해서 객체를 리턴 하는 방법도 있다.



2. 실행 흐름 순서

> @Controller의 실행 흐름
>
> Client -> Request -> Dispatcher Servlet -> Handler Mapping -> **Controller** -> View -> Dispatcher Servlet -> Response -> Client 
>
> 
>
> @ResponseBody의 실행 흐름
>
> Client -> Request -> Dispatcher Servlet -> Handler Mapping -> **Controller (ResponseBody)**-> Response -> Client 
>
> 
>
> @RestController의 실행 흐름
>
> Client -> HTTP Request -> Dispatcher Servlet -> Handler Mapping -> **RestController (자동** **ResponseBody 추가)**-> HTTP Response -> 
>
> Client

 

3. ResponseEntity

별도의 View를 제공하지 않는 형태로 서비스를 실행한다. 예외의 상황에서 문제가 발생 할 수 있다.



개발자가 직접 결과 데이터와 HTTP 상태 코드를 직접 제어할 수 있는 클래스로 404, 500같은 HTTP 상태 코드를 전송하려는 데이터와 함께 전송 가능 하므로 세밀한 제어를 원하는 경우 사용 가능하다.



참고

> http://doublesprogramming.tistory.com/105
>
> https://lkg3796.tistory.com/58