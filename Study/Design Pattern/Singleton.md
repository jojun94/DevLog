# Singleton Pattern

**싱글톤 패턴**

애플리케이션이 시작될 때 어떤 클래스가 **최초 한번만** 메모리를 할당하고(Static) 그 메모리에 인스턴스를 만들어 사용하는 디자인패턴.

생성자가 여러 차례 호출되더라도 실제로 생성되는 객체는 하나고 최초 생성 이후에 호출된 생성자는 최초에 생성한 객체를 반환한다. (자바에선 생성자를 private로 선언해서 생성 불가하게 하고 getInstance()로 받아쓰기도 함)

=> 싱글톤 패턴은 단 하나의 인스턴스를 생성해 사용하는 디자인 패턴이다.

(인스턴스가 필요 할 때 똑같은 인스턴스를 만들어 내는 것이 아니라, 동일(기존) 인스턴스를 사용하게함)



**싱글톤 패턴을 쓰는 이유**

고정된 메모리 영역을 얻으면서 한번의 new로 인스턴스를 사용하기 때문에 메모리 낭비를 방지할 수 있음

또한 싱글톤으로 만들어진 클래스의 인스턴스는 전역 인스턴스이기 때문에 다른 클래스의 인스턴스들이 데이터를 공유하기 쉽다.

DBCP(DataBase Connection Pool)처럼 공통된 객체를 여러개 생성해서 사용해야하는 상황에서 많이 사용.

(사용자 설정, 레지스트리 설정, 로그 기록 객체등)

인스턴스가 절대적으로 한개만 존재하는 것을 보증하고 싶을 경우 사용.



**싱글톤 패턴의 문제점**

싱글톤 인스턴스가 너무 많은 일을 하거나 많은 데이터를 공유시킬 경우 다른 클래스의 인스턴스들 간에 결합도가 높아져 "개방-폐쇄 원칙" 을 위배하게 된다. (=객체 지향 설계 원칙에 어긋남)

따라서 수정이 어려워지고 테스트하기 어려워진다.

또한 멀티쓰레드환경에서 동기화처리를 안하면 인스턴스가 두개가 생성된다든지 하는 경우가 발생할 수 있음

개발을 할때 항상 들어온 goto는 쓰면 안돼! 전역 객체는 안 좋은거야! 라는 말 처럼 꼭 필요한 경우아니면 지양해야함.





**멀티쓰레드에서 안전한(Thread-safe) 싱글톤 클래스, 인스턴스 만드는 방법**

1. Thread safe Lazy initialization (게으른 초기화)

```java
public class ThreadSafeLazyInitialization{
    private static ThreadSafeLazyInitialization instance;
    private ThreadSafeLazyInitialization(){}

    public static synchronized ThreadSafeLazyInitialization getInstance(){
        if(instance == null){
            instance = new ThreadSafeLazyInitialization();
        }
        return instance;
    }
}
```

private static으로 인스턴스 변수를 만들고 private 생성자로 외부에서 생성을 막았으며 synchronized 키워드를 사용해서 thread-safe하게 만들었다.

하지만 synchronized 특성상 비교적 큰 성능저하가 발생하므로 권장하지 않는 방법이다.



2. Thread safe lazy initialization + Double-checked locking

\- 게으른 초기화의 성능저하를 완화시키는 방법

```java
public class ThreadSafeLazyInitialization {
    private volatile static ThreadSafeLazyInitialization instance;
    private ThreadSafeLazyInitialization(){}
    public static ThreadSafeLazyInitialization getInstance(){
        if(instance == null){
            synchronized (ThreadSafeLazyInitialization.class) {
                if(instance == null)
                    instance = new ThreadSafeLazyInitialization();
            }
        }
        return instance;
    }
}
```

getInstance()에 synchronized를 사용하는 것이 아니라 첫 번째 if문으로 인스턴스의 존재여부를 체크하고 두 번째 if문에서 다시 한번 체크할 때 동기화 시켜서 인스턴스를 생성하므로 thread-safe하면서도 처음 생성 이후에 synchonized 블럭을 타지 않기 때문에 성능저하를 완화했다.

그러나 완벽한 방법은 아니다. 



3. Initialization on demand holder idiom (holder에 의한 초기화)

클래스안에 클래스(Holder)를 두어 JVM의 Class loader 매커니즘과 Class가 로드되는 시점을 이용한 방법

```java
public class Something {
    private Something() {
    }
    private static class LazyHolder {
        public static final Something INSTANCE = new Something();
    }
    public static Something getInstance() {
        return LazyHolder.INSTANCE;
    }
}
```

개발자가 직접 동기화 문제에 대해 코드를 작성하고 문제를 회피하려 한다면 프로그램 구조가 그 만큼 복잡해지고 비용 문제가 생길 수 있고 특히 정확하지 못한 경우가 많다.(100%가 아닐수 있음)

그런데 이 방법은 JVM의 클래스 초기화 과정에서 보장되는 원자적 특성을 이용하여 싱글턴의 초기화 문제에 대한 책임을 JVM에 떠넘긴다.

holder안에 선언된 instance가 static이기 때문에 클래스 로딩시점에 한번만 호출될 것이며 final을 사용해 다시 값이 할당되지 않도록 만든 방법.



*** 가장 많이 사용하고 일반적인 Singleton 클래스 사용 방법이다.**



> 참고
>
> http://limkydev.tistory.com/67
>
> https://blog.seotory.com/post/2016/03/java-singleton-pattern
>
> https://blog.naver.com/junhyoung75/221717818066