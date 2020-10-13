# JAVA 버전 별 특징



## JDK1.1

1997년 : RMI, JDBC, reflection, JIT, inner Class 개념포함



## JDK1.2

1998년 : Java SE 1.2, ME 1.2, EE 1.2 발표(J2EE라는 명칭 사용시작)
java가 세가지 버전으로 나뉨.
Swing이 SE에 포함, Corba IDL(이종 기기간 함수호출 스팩), Collection Framework 포함



## JDK 1.3

2000년도
HotSpot(Sun에서 만든 JIT 구현), JNDI(java 네이밍, 디렉토리 인터페이스 J2EE스펙) 포함



## JDK 1.4

2002년도
JCP(Java Community Process)에 의해서 오픈소스 정책으로 자바가 관리되기 시작한 버전
Java 2 Security 모델의 확립(Sandbox)
Java Web Start 포함 (Java Applet이 브라우저에서 돌아가는 것과 다르게, 외부 sandbox에서 동작)
Language : assert 도입
API : Reqular Expression, Assert keyword, Security 2 version(현재 security model), Non Blocking IO(NIO)

## JDK 1.5

2004년
기능적으로 가장 많은 변화가 생긴 버전
Language : Generics, annotation, auto boxing, enum, vararg, foreach, static imports 도입
API : java.utio.concurrent APi, scanner class
J2EE라는 명칭이 Java EE로 개칭

## JDK 1.6

2006년
기능에 큰 변화 없음, 보안 성능강화
JVM/Swing에 있어 많은 성능향상(synchronization, compiler, Gc, start-up time)
G1(Garbage Fist) GC도입



- interface에 @Override 추가됨
- JDBC 4.0
- Scripting Language Support
- Java Compiler API
- pluggable annotation



## JDK 1.7

2011년
JVM : Dynamic Language support
Language : Switch문 인자로 String 허용, try-resource, generics 타입추론, 숫자에서 undersocre 사용

### 숫자 언더스코어

조건 : 반드시 숫자 사이에만 올 수 있다.

```java
int moneyWon = 19000000000;

int moneyWon2 = 19_000_000_000;  // 숫자 언더스코어, 숫자의 가독성 상승
```



  - diamond operator <>
  - try-resource
  - multi-catch
  - switch문에 String 사용
  - concurrency API(new)
  - File NIO(new)
  - Java2D 지원
  - dynamic language 지원



## JDK 1.8

2014
오라클로 인수된 후 첫번째 버전
JDK 1.5이후 가장 큰 언어적 변화(Lambda및 함수형 프로그래밍,Interface default method)
JEP에 의해서 새로운 기능들이 발의되기 시작
Language : Lambda expression, Defauit Method Ingerface, functional programming for MapReduce style 지원, default method를 이용한 다중상속 지원, 메소드 참조
API : Nashorn(JS엔진), new Date and Tiem API, stream api, Collection에 대한 함수형화
병렬처리에 적합한 구조



- lambda expression
- type annotation
- stream api 추가
- repeating annotation
- static link library
- interface default method
- unsigned integer 계산
- 날짜와 시간 API(new) -> JodaTime
- rhino 대신 nashorn javascript 엔진 탑재



TODO : 최신 버전 특징 정리





> 참고
>
> https://i3utterfly.tistory.com/entry/JAVA-%EB%B2%84%EC%A0%84%EB%B3%84-%EC%A0%95%EB%A6%AC?category=831532?category=831532
>
> http://koreateam.co.kr/162
>
> https://www.hanumoka.net/2018/12/08/java-20181208-java-jdk-version-history/