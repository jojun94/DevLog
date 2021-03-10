### Spring Annotations

##### SpringBootApplication

##### SpringBootConfiguration

##### EnableAutoConfiguration

##### Autowired

> - IoC 컨테이너에 등록된 Bean을 주입할 때 사용.
>
>
> - 해당 자리에 들어올 수 있는 객체가 여러개인 경우 @Qualifier("Bean's Name")을 이용히야 명시해주어야 한다.

##### Controller

##### RestController

##### Configuration

##### Bean

> - IoC 컨테이너에 Bean을 등록하는 어노테이션.
>
>
> - 개발자가 직접 제어 불가능한 외부 라이브러리 등을 Bean으로 등록할 때 사용.
>
>
> - 개발자가 작성한 Method를 통해 반환되는 객체를 Bean으로 만든는 것.

##### Component

> - IoC 컨테이너에 Bean을 등록하는 어노테이션.
>
>
> - 개발자가 직접 작성한 Class를 Bean으로 등록할 때 사용.

##### RequestMapping

##### ResponseBody

#### Lombok

##### Getter, Setter

##### Slf4j

##### NoArgsConstructor, AllArgsConstructor

> - "AccessLevel"을 통해 접근 제한자 설정이 가능.(Default : Public)
>
>   ex) @NoArgsConstructor(access = AccessLevel.PROOTECTED)
>
> - NoArgsConstructor : 기본생성자를 자동 생성해준다.
>
> - AllArgsConstructor : 필드값을 모두 포함한 생성자를 자동 생성해준다.


##### ToString

>  - toString 메소드를 자동생성 하여 준다.
>
>  - 클래스명(필드명1=값1, 필드명2=값2, . . . ) 형태로 출력된다.
>    - exclude 키워드를 이용하여 출력을 원치 않는 필드 지정이 가능하다. 
>
>  - 필드의 명을 출력하고 싶지 않을때 : includeFieldNames을 false. 제외시키고 싶은 필드는 exclude 파라미터에 추가하면된다.
>
>  - of 파라미터를 이용하여 원하는 필드만 출력할 수 도 있다. 부모 클래스의 toString을 출력하고 싶은 경우에는 callSuper 파라미터를 true로 설정하여 포함시킬 수도 있다.

##### EqualsAndHashCode

> equals()와 hashCode()를 자동으로 생성해 준다.

##### Notnull

> - 멤버필드에 선언해 주면, 해당 변수 Setter에 null값이 들어 올 때 NullPointException을 발생시킨다.

##### cleanup

> - try finally에서 close()를 대신 호출해주는 어노테이션

##### Synchronized

> - 자바의 synchronized를 사용할 때 deadlock이 발생하는 경우가 종종 발생하는걸 방지하기 위해 Lombok이 메소드가 실행되기 전에 잠글 $ lock이라는 개인 잠금 필드를 생성한다.
> - lock 오브젝트를 자동으로 생성, synchronized를 손쉽게 사용할수 있게 해준다. 

##### Data

> - @Getter, @Setter, @NonNull, @EqualsAndHashCode, @ToString 에 대한 걸 모두 해주는 Annotation
> - @NotNull 또는 final 필드를 매개변수로 사용하는 public 생성자가 생성된다.
> - @Data는 staticConstructor 하나의 파라미터 옵션만 제공하는데, 파라미터를 이름으로 하는 static factory 메서드를 생성하여 준다.
> - 오류가 발생할 가능성이 있으므로 사용 자제

##### Builder

> - 어노테이션을 선언하면 생성자 대신에 빌더를 사용할 수 있다.
> - @Singular : collection 타입에 선언하게 되면 파라미터를 하나씩 추가할 수 있다.

##### Value

> - Value는 Immutable Class을 생성해준다.
> - @Data와 비슷하지만 모든 필드를 기본적으로 Private 및 Final로 로 하고, Setter 함수를 생성하지 않고, Class또한 Final로 지정하는 것만 빼고 동일하다.



### Component vs Service vs Repository

- Component

  > We can use @Component across the application to mark the beans as Spring's managed components. Spring only pick up and registers beans with @Component  and doesn't look for @Service and @Repository in general.
  > They are registered in ApplicationContext because they themselves are annotated with @Component:
  > @Service and @Repository are special cases of @Component. They are technically the same but we use them for the different purposes.

- Service

  >@Service
  >We mark beans with @Service to indicate that it's holding the business logic. So there's not any other specialty except using it in the service layer.

- Repository

  >@Repository’s job is to catch persistence specific exceptions and rethrow them as one of Spring’s unified unchecked exception.
  >For this Spring provides PersistenceExceptionTranslationPostProcessor, that requires to add in our application context:
  ><bean class=
  >  "org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor"/>
  >This bean post processor adds an advisor to any bean that’s annotated with @Repository.

- So?

  >Conclusion
  >In this write-up, we learned about the differences between  @Component, @Repository, @Service annotations. We examined each annotation separately with the areas of their use.
  >
  >As a conclusion, it's always a good idea to choose the annotation-based on their layer conventions.







> 참고:
>
> https://goddaehee.tistory.com/208 
>
> https://www.baeldung.com/spring-component-repository-service