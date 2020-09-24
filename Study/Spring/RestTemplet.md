# 1. RestTemplet 이란?

- RestTemplet

  - Spring 3.0 부터 지원, 스프링에서 제공하는 http 통신에 유용하게 사용할 수 있는 템플릿

  - HTTP 서버와의 통신을 단순화 하고 RESTful한 원칙을 준수

  - JdbcTemplet 처럼 RestTemplet도 기계적이고 반복적인 코드들을 정리 해줌

  - REST API 호출 후 응답을 받을때 까지 기다리는 동기방식이다.

- AsyncRestTemplet
  - Spring 4에 추가된 비동기 RestTemplet 
  - Spring 5에서 deprecated 되었음

- WebClient
  - Spring 5에서 추가된 논블럭, 리액티브 웹 클라이언트로 동기, 비동기 방식을 지원



# 예제

1.  GET Method
   1. getForObject()
      + getFotObject() 메서드는 GET을 수행하고 HTTP 응답을 객체타입으로 변환해서 반환하는 메소드
      + REST API의 Controller단에 @RestController 어노테이션을 추가하면 클래스패스에 Jackson2 가 있는한 기본적으로 JSON 응답을 처리한다. (spring-boot-starter-web 의존성을 추가하였다면 같이 포함된다.)
   2. getForEntity
      + getForEntity() 메서드의 경우에는 응답을 ResponseEntity 객체로 받게 된다. getForObject()와 달리 HTTP 응답에 대한 추가 정보를 담고 있어서, GET 요청에 대한 응답 코드, 실제 데이터를 확인할 수 있다. 또한 ResponseEntity<T> 제네릭 타입에 따라서 응답을 String이나 Object로 받을 수 있다. 
2. POST Method
   1. postForObject()
   2. postForEntity
   3. postForLocation
3. DELETE Method
4. PUT Method
5. Exchange()
6. patchForObject()
7. Excute()



> 참고 
>
> https://advenoh.tistory.com/46
>
> https://sjh836.tistory.com/141