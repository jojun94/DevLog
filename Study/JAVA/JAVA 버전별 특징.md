# JAVA 버전 별 특징



##  **Java 분류**

- Java SE(Java Standard Edition / J2SE)
  - 대부분의 사람들이 가장 많이 접하는 표준 에디션으로, Java의 핵심 API화 기능들을 제공한다.
- Jakarta EE, 구 Java EE(Java Enterprise Edition / J2EE)
  - 기업에서 운영하는 서버 페이지에 특화된 에디션이다. JSP와 서블릿을 비롯한 웹 애플리케이션 서버에 관련된 기술들이 포함되어 있다.
- Java ME(Java Micro Edition / J2ME)
  - PDA나 셋톱박스, 센서 등의 임베디드 시스템 환경에 특화된 에디션이다.
- JavaFX
  - 데스크톱 애플리케이션 개발 및 배포를 위한 에디션으로 크로스 플랫폼 이식과 GUI 라이브러리를 제공한다.



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
  - try-resource : try문에서 자동 자원 관리
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



## Java 9 / Java SE 9

- 2017년 9월 21일 발표.
  - 일반 지원은 2018년 3월에 종료.
- 주요 사항
  - Project Jigsaw기반으로 런타임이 모듈화된 것.
    - 런타임의 모듈화는 하위 호환성을 어느 정도 포기하고 성능을 추구한 것.
    - 콘솔 프로그램 개발에는 더 이상 AWT나 Swing 같은 불필요한 라이브러리를 사용X, 최상위 모듈인 Base만 사용.
    - 특정 프로그램에 최적화된 최소 런타임을 제작할 수 있게 되면서 패키징 역시 간편.
  - Java를 인터프리터 언어 셸처럼 사용할 수 있는 JShell이 추가.
  - Java 바이트코드를 기계어로 미리 번역하는 선행 컴파일(Ahead-Of-Time Compilation) 역시 실험 기능으로 추가.
  - Deprecated 표시에는 해당 버전과 제거 예정 여부를 표시.
  - 불변 컬렉션을 생성할 수 있도록 새로운 팩토리 메서드 추가.
  - 통합 로깅, HTTP/2, private 인터페이스 메소드, HTML5 Javadoc 등도 지원.
  - 프로퍼티 파일에 UTF-8이 지원되어 인코딩 문제로 고생할 필요가 없어짐.
  - Java Applet 기능 지원 종료.

## Java 10 / Java SE 10

- 2018년 9월 25일 발표.
  - 일반 지원은 2018년 9월에 종료.
- 주요 사항
  - var 키워드를 이용한 지역 변수 타입 추론가능하며, C#과 기능 동일.
  - 병렬 처리 가비지 컬렉션, 개별 쓰레드로 분리된 Stop-The-Word, 루트 CA 목록 등이 추가.
  - JDK의 Repository가 하나로 통합되었으며, JVM Heep 영역을 시스템 메모리가 아닌 다른 종류의 메모리에도 할당할 수 있게 됨.
  - 실험 기능으로 Java 기반의 JIT 컴파일러 추가.
  - Deprecated API는 Java SE 10에서 완전 삭제되어 컴파일 불가.

## Java 11 / Java SE 11

- 2018년 9월 25일 발표.
  - 일반 지원은 2023년 9월, 연장 지원은 2026년 9월에 종료될 예정.
- 주요 사항
  - 이클립스 재단으로 넘어간 Java EE가 JDK에서 삭제되고, Java FX도 JDK에서 분리되어 별도의 모듈로 제공.
  - 람다 파라미터에 대한 지역 변수 문법, 엡실론 가비지 컬렉터, HTTP 클라이언트 표준화 등의 기능 추가.
  - 가장 큰 변화는 라이선스 부분
    - Java SE11부터 Oracle JDK의 독점 기능이 오픈소스 버전인 OpenJDK에 이식.
      - Oracle JDK와 OpenJSK가 완전히 동일해진다는 뜻.
    - Oracle JSK는 Java Se11부터 LTS(장기 지원) 버전으로 3년마다 출시되는데 출시 후 5년 동안 오라클 기술 지원이 제공되고 최대 3년까지 지원기간 연장.
      - Oracle JDK는 이제 3년에 한 번 출시되니 Java의 실질적인 version up을 담당하는 것은 OpenJDK가 된 셈.
      - OpenJDK는 기업들을 위한 기술 지원X.
      - 새로운 버전이 나오면 이전 버전에 대한 마이너 업데이트와 보안 업데이트는 중단.
    - Oracle JDK 구독형 유료 모델로 전환.
      - 2019년 1월부터 오라클이 제공하는 모든 JDK는 유료화되며, 구독권을 구입하지 않으면 JDK에 접근 자체가 금지.
      - 기존 일반/연장 지원 서비스는 구독권에 포함되므로 별도의 서비스로 제공 X.
      - 개인 사용자는 2021년 1월부터 비용 지불.
      - 많은 기업들이 Oracle JDK에서 발을 빼거나, OpenJDK를 기반으로 한 다른 서드파티 JDK가 대안으로 떠오름.

## Java 12 / Java SE 12

- 2019년 3월 19일 공개.
- 가비지 컬렉터 및 성능 개선.
- 특징 중 하나로 문법적으로 Switch문을 확장





> 참고
>
> https://i3utterfly.tistory.com/entry/JAVA-%EB%B2%84%EC%A0%84%EB%B3%84-%EC%A0%95%EB%A6%AC?category=831532?category=831532
>
> http://koreateam.co.kr/162
>
> https://www.hanumoka.net/2018/12/08/java-20181208-java-jdk-version-history/
>
> https://error-justdoit.tistory.com/22