# Valiation in Spring

@Valid

@Validated : // @Validated annotation is only evaluated on class level, so don’t put it on a method in this use case.



cotroller BindingResult , service layer custom handler 

service layer  선택. 이유 : MVC 패턴, 비즈니스 로직 분리, 등등 정리



두 애노테이션의 차이점은 알아보면 `@Valid`는 jakarta.validation-api에서 제공하는 애노테이션입니다. nested 객체나 메서드 파라미터 객체를 validation할 사용합니다. 하지만 groups 관련 설정이 없기 때문에 Spring에서 `@Validated` 애노테이션을 추가로 만들어서 사용합니다.



domian에 각 항목에 제약사항 설정 service Layer에 class에  @Validated 추가,  method 안 파라미터에 @valid 추가



### Exception Handle

```
/* In contrast to request body validation a failed validation
*  will trigger a ConstraintViolationException instead of a MethodArgumentNotValidException.
* */
```



@ControllerAdvice 는 컨트롤러 에서만 발생한 오류를 캐치한다.

@RestControllerAdvice 도 있음.

Ex) Controller에서 Service를 호출한 경우, Service에서 Exception이 발생해도 결국은 Controller로 부터 문제가 발생했음을 감지 → Handler가 작동한다.

```java
@Slf4j
@ControllerAdvice
@Component
public class ValidationExceptionsHandler {
    /* In contrast to request body validation a failed validation
    *  will trigger a ConstraintViolationException instead of a MethodArgumentNotValidException.
    * */
    @ExceptionHandler(value= MethodArgumentNotValidException.class)
    public ResponseEntity handleValidationExceptions(MethodArgumentNotValidException ex){
        JsonObject responseMessage = new JsonObject();
        log.info("#Error, Invalid Input Data , : "+ ex.getMessage());
        responseMessage.addProperty("responseCode",0);
        return new ResponseEntity(responseMessage.toString(), HttpStatus.OK);
    }
    @ExceptionHandler(value= ConstraintViolationException.class)
    public ResponseEntity handleConstraintViolationExceptions(ConstraintViolationException ex){
        JsonObject responseMessage = new JsonObject();
        log.info("#Error, Invalid Input Data , : "+ ex.getMessage());
        responseMessage.addProperty("responseCode",0);
        return new ResponseEntity(responseMessage.toString(), HttpStatus.OK);
    }
}
```



## ConstraintViolationException

위와 같이 메서드 파라미터나 리턴 값에 문제가 있으면 `ConstraintViolationException` 오류가 발생합니다. Spring에서는 이 오류를 기본적으로 HTTP 500 에러로 처리하기 때문에 사용자 요청 오류인 HTTP 400으로 변경하고 싶다면 별도로 변경처리를 해야 합니다.

## MethodArgumentNotValidException

`@ModelAttribute` 나 `@RequestBody` 처리를 위해 데이터 바인딩 중에 Validation 오류가 있을 경우 발생하는 오류입니다. 이 오류는 `ConstraintViolationException`과 다르게 기본적으로 HTTP 400 오류로 처리합니다.

`ConstraintViolationException`에서는 `BindingResult` 정보를 가지고 있어서 필요한 오류 정보와 메시지 코드를 확인할 수 있습니다.





> 참고 :
>
> https://www.baeldung.com/exception-handling-for-rest-with-spring
>
> https://stackoverflow.com/questions/57010688/what-is-the-difference-between-constraintviolationexception-and-methodargumentno
>
> https://kapentaz.github.io/spring/Spring-Boo-Bean-Validation-%EC%A0%9C%EB%8C%80%EB%A1%9C-%EC%95%8C%EA%B3%A0-%EC%93%B0%EC%9E%90/#
>
> https://reflectoring.io/bean-validation-with-spring-boot/