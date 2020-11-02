# 의존성을 주입(DI)하는 세가지 방법

##### 의존성 이란?

프로그램 개발을 진행 시 객체간의 의존성이 생긴다. 의존성 이란 무엇일까 ?

A 타입의 변수를 생성하고, 이에 A를 상속받는 B 객체를 초기화하면 이는 B 객체에 의존성을 가진다.

예를 들어

```java
public class Cook{
	private Knife knife;
	
	public Cook() {
		knife = new knife();
	}
    
    public void cook(Food food){
        knife.cut(food);
    }
}
```

위 `Cook` 클래스는 `cook()` 메소드를 실행 할 때 `cut()` 메소드로 인해 `Knife` 클래스가 필요하다. 이 때 `Cook 클래스가 Knife에 의존성을 가지고 있다.(의존하고 있다)` 라고 한다.

 이 때 생길수 있는 이슈 들은

- Unit Test가 어려워진다.

  > 내부에서 직접 생성하는 객체에 대해서 Mocking할 방법이 없어 단위 테스트가 까다롭다.

- Code의 변경이 어려워진다.

  > Cook 클래스는 생성자에서 Knife 객체를 직접 생성하여 사용하고 있다. 
  >
  > 추후 Knife라는 클래스가 변경 된다면 
  >
  > <u>Knife클래스에 의존하고 있는 Cook 클래스도 직접 같이 변경해주어야 한다.</u>

 위와 같이 생성자에서 의존성이 있는 클래스들을 초기화 하면 클래스들간의 결합도 가 높아진다.

 하지만 개발을 진행하다 보면 다양한 컴포넌트들을 조합하게되는데, 효율적으로 관리하기 위해 결합도를 낮추어야 한다.

 결합도를 낮추기 위해서 생성자에서 구현하는 것 보다, 생성자에서 인자로 받는것이 더 효율적이다. 이렇게 하면 인터페이스에 명시된 메소드만을 사용하고, 실제 Impl 구현체는 쉽게 수정할 수 있게 된다.

 이러한 경우(생성자를 직접 주입받는 경우)에도 각 컴포넌트를 개발자가 직접 주입해주어야 하기 때문에, 로직의 변경이 필요할 때 큰 수정이 필요하다. 이를 위해 의존성 주입, DI라는 개념이 나오게 되었다.



##### 의존성 주입(Dependency Injection) 이란?

- 기존의 방식

  > 기존의 프로그래밍 방식 대로, 클래스간의 의존성이 생기면 다음과 같이 사용한다.
  >
  > ![img](https://blog.kakaocdn.net/dn/bbUDiL/btqxI9ZkvBh/4R8xe36z4VqyAkyAiLmTt0/img.png)

- DI  방식 

  > DI의 방식은 이를 관리해주는 DI 컨테이너가 존재하고 의존성이 필요할 때 다른 인스턴스를 DI 컨테이너를 통해 획득.
  >
  > ![img](https://blog.kakaocdn.net/dn/Wenek/btqxIF5rrxM/WT9GenESCvBlfaXfIijUpK/img.png)
  >
  >  위와 같은 방식으로 인스턴스의 생성 및 관리를 DI 컨테이너가 해주기 때문에 개발자는 비즈니스 로직에 집중할 수 있다.
  >
  > 참고 : https://jyoondev.tistory.com/99



##### DI Container and Bean

- 스프링에서는 자바 객체 (`POJO`)를 `Bean` 이라고 부른다.

  > - POJO(Plain Old Java Object)란?
  >
  >   특정 `기술`에 종속되어 동작하는 것이 아닌 순수한 자바 객체

- `ApplicationContext`는 `DI 컨테이너 `역할을 한다. DI 컨테이너가 자바 객체인 `Bean` 을 소유한다. 



##### 의존성 주입

스프링에서는 의존성을 주입할 수 있는 다양한 방법을 제공한다.

- 생성자 주입

  ```java
  @Controller
  public class TestController(){
      private TestService testService;
      
      @Autowired
      public TestController(TestService testService){
          this.testService =  testService;
      }
      
  }
  ```

  > 생성자에 @Autowired 을 붙여 의존성을 주입 받을 수 있다.
  >
  > Spring 4.3부터는 클래스의 생성자가 하나이고 그 생성자로 주입받을 객체가 빈으로 등록되어 있다면 생성자 주입에서 @Autowired를 생략할 수 있다.

- 필드 주입

  ```java
  @Controller
  public class TestController(){
      @Autowired
      private TestService testService;
  }
  ```

  > 변수 선언부에 @Autowired 어노테이션을 추가해  의존성을 주입 받는다.

- Setter 주입

  ```java
  @Controller
  public class TestController(){
      private TestService testService;
      
      @Autowired
      public void setTestService(TestService testService){
          this.testService =  testService;
      }
  }
  ```

  > Setter 메소드에 @Autowired 어노테이션을 붙인다.



- 위 세가지 방법은 모두 동일하게 TestController에 TestService를 주입하도록 한다.

- `Spring Framework`에서 권장하는 방법은 `생성자를 통한 주입`이다.

  생성자를 사용하는 방법을 권장하는 이유는 

  - 단일 책임의 원칙

    > 생성자의 인자가 많아지면서 하나의 클래스가 많은 책음을 떠안는다.
    >
    > 그래서 생성자 를 통한 주입을 사용해 의존관계, 복잡성을 쉽게 알 수 있다.

  - 의존성이 명시적이다. (다시 정리가 필요)

    > 의존성이 명시적으로 드러난다.
    >
    > 필드 주입 방식은 의존성이 드러나지 않는다.

  - DI 컨테이너의 결합성과 테스트의 용이성

    > DI에서 핵심은 관리되는 클래스가 DI 컨테이너에 의존성이 없어야 한다. 즉, 필요 의존성을 전달하면 독립적으로 인스턴스화 할 수 있는 단순 POJO의 형식.
    >
    > DI 컨테이너 없이 유닛테스트에서 인스턴스화가 가능하며 테스트를 가능하게 한다.

  - 불변 객체

    > 생성자 주입 방식에서 필드는 final 로 선언 할 수 있다.
    >
    > 하지만 필드 주입 방식에서는 final 로 선언할 수 없어 객체가 변경 가능한 상태가 된다.

  - 순환 의존성

    > 생성자 주입 방식에서 순환 의존성을 가질 경우  `BeanCurrentlyCreationExcepiton`을 발생시킴으로 순환 의존성을 알수 있다.
    >
    > - 순환 의존성이란? A 클래스가 B 클래스를 참조하는데 다시 B클래스가 A 클래스를 참조하는 경우를 순환 의존성이라고 부른다. 





> 참고 : https://galid1.tistory.com/493
>
> https://jyoondev.tistory.com/99
>
> https://atoz-develop.tistory.com/entry/Spring-%EC%9D%98%EC%A1%B4%EC%84%B1-%EC%A3%BC%EC%9E%85DI-Dependency-Injection%EC%9D%98-%EC%84%B8%EA%B0%80%EC%A7%80-%EB%B0%A9%EB%B2%95
>
> https://n1tjrgns.tistory.com/230
>
> https://madplay.github.io/post/why-constructor-injection-is-better-than-field-injection