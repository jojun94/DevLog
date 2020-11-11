# JAVA 8 이후 변경사항

Oracle이 Java를 유료화 선언한 후 변경된 Java RoadMap은 다음과 같다. 현재 프로그램 언어 시장은 지각 변동하고 있으며 이에 Java진영도 JDK9부터 빠른 업데이트 주기를 가지고 제품을 출시하고 있다.

## Oracle Java Support RoadMap

|       | 출시    | 공식 업데이트 종료 | Premire Support | Extended Support |
| ----- | ------- | ------------------ | --------------- | ---------------- |
| JDK8  | 2014.03 | 2019.01            | 2022.03         | 2030.12          |
| JDK9  | 2017.09 | 2018.03            | *2018.03*       | Not Available    |
| JDK10 | 2018.03 | 2018.09            | *2018.09*       | Not Available    |
| JDK11 | 2018.09 | 2019.03            | 2023.09         | 2026.09          |
| JDK12 | 2019.03 | 2019.09            | 2019.09         | Not Available    |
| JDK13 | 2019.09 | 2020.03            | 2020.03         | Not Available    |
| JDK14 | 2020.03 | 2020.09            | 2020.09         | Not Available    |

https://www.oracle.com/java/technologies/java-se-support-roadmap.html 

##### **Premire Support**

제품 출시 후 5년간 제공되는 가장 다양한 Java update 지원 유상 서비스

##### Extended Support

Premire Support 종료 후 3년간 제공되는 추가 기술지원 서비스

JDK8은 현재 가장 많이 사용되고 있는 안정화된 Java 버전으로 공식 업데이트 기간은 종료되었지만 많이 사용되고 있는 만큼 추가 지원기간이 꽤 길게 잡혀있다.

JDK9부터 6개월마다 Major 버전 업데이트를 하도록 변경되었다. JDK9, 10은 LTS 버전이 나오지 않아 지원기간이 짧다.

JDK11부터 LTS(Long Term Support)가 생겨났으며 Premire + Extended Support로 최대 8년간 보안 업데이트와 버그 수정 지원을 받을 수 있게 되었다.

[![img](https://daddyprogrammer.org/wp-content/uploads/2020/06/jdktimeline-1.jpg)](https://daddyprogrammer.org/wp-content/uploads/2020/06/jdktimeline-1.jpg)

총 149개의 [JDK Enhancement Proposals](http://openjdk.java.net/jeps/0) 이 JDK14까지 반영되었다.

### 왜 6개월마다 Major 업데이트하는 방식으로 바뀌었나?

Java는 굉장히 보수적인 개발 언어로 하나의 버전이 정말 오랫동안 사용되고 있다. 다음 버전이 나오는 데까지도 시간이 오래 걸린다. 하지만 근래 등장하는 언어들은 업데이트 주기가 짧고 최신 기술을 빠르게 받아들이는 쪽으로 언어가 발전하고 있다. 이에 비해 Java는 이러한 변화의 속도를 따라가지 못하고 있으며 빠른 시간 내에 경쟁에서 밀려 도태될 것이란 전망도 나오고 있다.

Java 진영도 이에 위기감을 느낀 것인지 새로운 기능 출시 및 개발자들의 피드백을 빠르게 반영하기 위해 6개월마다 Major 업데이트를 실시 하도록 변경되었다.

그래프를 보면 JDK9에서 91개의 개선안이 수용되어 버전업이 되었고 그 뒤로는 6개월마다 10개 정도의 개선안이 빠르게 적용되면서 기존보다 빠른 기능 업데이트를 실시하고 있는것을 볼 수 있다.

## JDK9 주요 변경사항

전반적으로 Java8에서 아쉬웠다고 생각되었던 부분들이 대거 보강되었다.

https://www.oracle.com/java/technologies/javase/9-relnotes.html 

### Java Platform Module System(Jigsaw) 추가

유연한 런타임 이미지를 만들기 위해 Java 플랫폼을 모듈화 하여 필요한 모듈만으로 경량화된 이미지를 만들 수 있게 되었다. 기존에는 JRE 일부분만 배포가 불가능했지만 Jigsaw를 통하여 원하는 모듈만 모아 런타임 환경 이미지를 만들 수 있게 되었다. (소형 디바이스, 마이크로 서비스, 시작 시간 단축 등을 염두한 것으로 보인다.)

### Process API Updates

운영체제의 프로세스 제어 및 관리를 위한 API의 기능이 향상되었다.

### JShell 추가

javascript(node), python 같은 인터프리터 언어의 shell 환경처럼 바로 코드를 작성하고 결과를 확인할 수 있는 REPL(Read-Eval-Print-Loop) 도구를 제공한다. 번거롭게 java파일을 만들고 컴파일해서 결과를 볼 필요 없이 코드를 작성하고 바로 실행하여 결과를 확인할 수 있다.

### Compact String

자바의 기본 char형은 UTF-16기반의 2byte를 차지하는데 개선된 String은 문자열에 따라 Latin-1(1byte)와 UTF-16(2byte)으로 나누어졌다. 만일 영어만 있는 문자열의 경우 1byte의 영역을 차지해 기존보다 메모리 공간을 절약할 수 있게 되었다.

### HTML5 Javadoc / Javadoc Search

이전 버전까진 HTML 4.01 형식으로 JavaDoc을 생성하였으나 이제 HTML5 방식의 마크업으로 Javadoc을 생성할 수 있다. Javadoc 문서에서 프로그램 요소, tag가 지정된 단어나 문구를 검색하는 데 사용할 수 있는 검색 상자를 사이트상에서 사용할 수 있다. 검색 기능은 로컬에 구현되며 서버 사이드의 연산에 의존하지 않는다.

### **UTF-8 Property Files**

properties file에 대한 기본적인 파일 인코딩이 기존 ISO-8859-1에서 UTF-8 로 변경되었다.

### Multi-Release JAR Files

JAR 파일 형식을 확장하여 여러 버전의 클래스 파일을 하나의 JAR 안에 공존시킬 수 있다. 즉 동일한 클래스를 Java버전 별로 동작할 수 있게 구성하여 jar 안에 넣을 수 있다.

### More Concurrency Updates (reactive stream)

프로그램의 동시성 및 병렬 처리 지원을 위한 라이브러리의 지원이 늘어났다. 개선된 CompletableFuture과 Reactive stream이 도입되었다.

### Unicode 8.0

Unicode 6.1을 지원했던 java8에 비해 10,555자, 29개의 스크립트 및 42개 블록의 유니코드 8.0을 지원한다.

### Convenience Factory Methods for Collections

불변 Collection을 만들 수 있는 편리한 메서드가 생겼다.

// java8

Set**<**String**>** set = Collections.unmodifiableSet**(**Stream.of**(**"a", "b", "c"**)**.collect**(**toSet**()))**;

// 이후 java

Set**<**String**>** set = Set.of**(**"a", "b", "c"**)**;

List.of**(**a, b, c**)**;

Set.of**(**d, e, f, g**)**;

Map.of**()**

Map.of**(**k1, v1**)**

Map.ofEntries**(**

​    entry**(**k1, v1**)**,

​    entry**(**k2, v2**)**,

​    entry**(**k3, v3**)**,

​    // ...

​    entry**(**kn, vn**))**;

### SHA-3 Hash Algorithms

SHA-1, SHA-2 표준 해시 함수를 대체하는 진보된 암호화 해시 함수를 구현하여 제공한다.

### Deprecate the Applet API

더 이상 브라우저에서 사용하지 않는 applet api에 대한 지원이 종료되었다.

### Implement Selected ECMAScript 6 Features in Nashorn

Jvm의 공식 javascript 엔진인 Nashorn이 ECMAScript 6 버전의 많은 새로운 기능 중 일부를 구현하여 제공한다.

### **Private Interface Method**

 interface 에 private method / private static method라는 새로운 기능을 제공한다.

public interface IMyInterface **{**

 

​    private **void** method1**(**String arg**)** **{**

​    // do something

​    **}**

 

​    private static **void** method2**(**Integer arg**)** **{**

​    // do something

​    **}**

**}**

### **try-with-resource 향상**

java7에서 등장했던 try-with-resources의 불편사항이 개선되었다.

void tryWithResourcesByJava7**()** throws IOException **{**

BufferedReader reader1 = **new** BufferedReader**(****new** FileReader**(**"test.txt"**))**;

​    **try** **(**BufferedReader reader2 = reader1**)** **{**

​        // do something

​    **}**

**}**

// final or effectively final이 적용되어 reader 참조를 사용할 수 있음

**void** tryWithResourcesByJava9**()** throws IOException **{**

​    BufferedReader reader = **new** BufferedReader**(****new** FileReader**(**"test.txt"**))**;

**try** **(**reader**)** **{**

​        // do something

​    **}**

**}**

### Improve Diamond Operator

익명 클래스에 Diamond Operator를 사용할 수 있게 되었다.

// java7,8

MyHandler**<**Integer**>** intHandler = **new** MyHandler**<>(**10**)** **{** // Anonymous Class };  //오류

// java9

MyHandler**<**Integer**>** intHandler = **new** MyHandler**<>(**10**)** **{**

​    @Override

​    public **void** handle**()** **{**

​        // handling code...

​    **}**

**}**;

### **Stream Improvements**

Java 9 Stream 은 **iterate(), takeWhile()/dropWhile(), ofNullable()** 과 같은 새로운 추가 메서드를 제공하여 비동기 프로그래밍에 대한 몇 가지 유용한 개선 사항을 제공한다.

### **Optional class Stream**

Optional class에 or(), ifPresentOrElse(), stream() 메서드가 추가되어 활용도가 높아졌다.

## JDK10 주요 변경사항

https://www.oracle.com/java/technologies/javase/10-relnotes.html 

### Local-variable type inference

var를 사용하여 생성할 변수의 타입을 추론할 수 있는 기능이 추가되었다. var를 통해 지역변수에 대해서는 type을 명시해주지 않아도 된다.

//Java 1.6 or earlier jvm version

List**<**String**>** list = **new** ArrayList**<**String**>()**;

//Java 1.7 or later jvm version

List**<**String**>** list = **new** ArrayList**<>()**;

//Java 10

var list = **new** ArrayList**<**String**>()**;

var stream = list.stream**()**;

### Application Class-Data Sharing

Class-Data Sharing(CDS)는 JVM 기동시의 성능을 향상하거나, 여러 대의 JVM이 하나의 물리 장비 또는 가상 장비에서 돌아가는 경우, 자원에 미치는 영향을 줄이기 위해 개발된 기능이다. CDS는 JVM에서 공통으로 사용하는 클래스들을 공유하는 저장소에 위치시키고 이를 공유해서 사용하는 방식으로 제공된다 (.jsa 파일)

### Additional Unicode Language-Tag Extensions

java.util.Locale 클래스의 향상된 버전으로 Java9에서 제공되는 [BCP 47 Language tag](https://www.oracle.com/technetwork/java/javase/documentation/java9locales-3559485.html) 에 몇 가지를 더 추가한 버전이다.

- cu (currency type)
- fw (first day of week)
- rg (region override)
- tz (time zone)

### Time-Based Release versioning

Java SE Platform과 JDK의 버전 명시에 대한 기준이 생겼다. 새로운 버전 모델인 “**Six-month release model**“을 적용하기 위한 버전 표기법으로 등장하였다.

#### $FEATURE.$INTERIM.$UPDATE.$PATCH

$FEATURE - 주버전. Feature의 번호를 나타내는 값입니다. 기능의 내용에 상관없이 기능별로 번호가 하나씩 증가합니다.

$INTERIM - 개선 버전. 하위버전과 호환되는 Bug fixes와 enhancements의 경우에 증가하는 버전입니다.

$UPDATE - 업데이트 버전. 새로운 Feature에서 보안문제, 버그 등을 해결하는 경우에 증가하는 버전입니다.

$PATCH - 중요한 문제를 해결하기 위해 비상으로 업데이트 될 경우에 증가하는 버전입니다.

### Root Certificates

기본적인 Root Certification Authority(CA)세트를 제공한다. OpenJDK 빌드와 Oracle JDK 빌드간의 차이를 줄이기 위해, Oracle Java SE의 루트 인증서를 오픈 소스로 만드는 목표를 가진 feature다. 이전까지는, cacerts 라고 불리는 JDK의 keystore에는 보안 프로토콜에 사용되는 루트 인증서 세트를 넣을 수 있는 곳이 존재했지만, 비어있었고 사용자가 직접 문서화된 루트 인증서 세트를 채워야 했다.

### Parallel Full GC for G1

Full GC를 병렬로 만들어, G1의 worst-case latency를 개선하기 위한 feature다. 이전까지는 단일 스레드로 GC를 수행하였다면, jdk 10부터는 병렬로 Mark-Sweep-Compact를 수행한다.

### New APIs

73개의 표준 클래스 라이브러리 API가 추가되었다. 대표적인 신규 API는 아래와 같다.

#### java.io.Reader

long transferTo(Writer);

모든 문자를 읽고 주어진 순서대로 지정된 writer에 문자를 쓴다.

#### **Optional.orElseThrow() Method**

get() 메서드의 대안으로써 본질적으로 동일한 새로운 메서드. Optional이 값을 보유하면 반환된다. 그렇지 않으면 NoSuchElementException이 발생한다.

### **APIs for Creating Unmodifiable Collections**

Unmodifiable Collections(수정할 수 없는 컬렉션)을 쉽게 만들 수 있는 몇 가지 새로운 API가 추가되었다.

아래 메서드는 기존 인스턴스에서 새 Unmodifiable Collection 인스턴스를 만든다.

- List.copyOf
- Set.copyOf
- Map.copyOf

Stream 패키지의 Collectors 클래스에 다음과 같은 메서드가 추가되었다.
이것에 의해 Stream의 요소를 Unmodifiable Collections에 수집할 수 있습니다.

- Collector **toUnmodifiableList**();
- Collector **toUnmodifiableSet**();
- Collector **toUnmodifiableMap**(Function, Function);
- Collector **toUnmodifiableMap**(Function, Function, BinaryOperator);

## JDK11 주요 변경사항

https://www.oracle.com/java/technologies/javase/11-relnotes.html 

### Local-Variable Syntax for Lambda Parameters

jdk 10 버전에서 지역변수로써 사용되어 타입을 추론할 수 있는 var가 새로운 feature로 추가되었었는데, jdk 11 버전에서는 var를 람다 표현식에 쓰는 경우 전달되는 parameter들의 타입을 추론할 수 있는 feature가 추가되었다.

### HTTP Client (Standard)

jdk 9에서 추가되고 jdk 10에서 업데이트된 java.incubator.http 패키지가 인큐베이터에서 나와 [java.net.http](http://java.net.http/) 패키지로 표준화되었다. 구버전의 HttpUrlConnection을 대체한다.

- Non-Blocking request and response 지원 (with CompletableFuture)
- Backpressure 지원(java.util.concurrent.Flow 패키지를 통해 RX Flow를 구현체에 적용)
- HTTP/2 지원
- Factory method 형태로 지원
- websocket 지원

### ZGC: A Scalable Low-Latency Garbage Collector (Experimental)

jdk 11에서 새로 등장한 가비지 컬렉터로 ZGC라고도 불리는 이 가비지 컬렉터는 아래의 몇 가지 목표를 가지고 개발되었다.

- GC 일시 중지 시간은 10ms를 초과하지 않는다.
- 작은 크기(수백 메가) ~ 매우 큰 크기(수 테라) 범위의 힙을 처리한다.
- G1에 비해 애플리케이션 처리량이 15%이상 감소하지 않는다.
- 향후 GC 최적화를 위한 기반 마련.
- 처음에는 Linux / x64을 지원 (향후 추가 플랫폼 지원 가능).

### Flight Recorder

Oracle Java의 상용 addon이었던 JFR(Java Flight Recorder)를 오픈소스로 개발하였다. JFR은 실행 중인 Java 애플리케이션의 진단 및 프로파일링 데이터를 수집하는 도구다. 주로 실행 중인 Thread, GC Cycles, Locks, Sockets, 메모리 사용량 등에 대한 데이터를 수집한다.

### Launch Single-File Source-Code Programs

Single file 프로그램의 Main 메서드 실행 시 javac를 하지 않고도 바로 실행할 수 있도록 편의성이 향상되었다.

\# Before Java 11

**$** javac Hello.java

**$** java Hello

\# Now Java 11

**$** java Hello.java

### “Shebang” files

스크립트 언어를 작성하듯이 첫줄에 shebang을 선언하고 java프로그램을 작성하면 아래와 같이 실행가능 하다.

$ vi run.sh 

\#!/opt/java/openjdk/bin/java --source 11

public **class** SheBang **{**

​    public static **void** main**(**String**[]** args**)** **{**

​        System.out.println**(**"Hello World!"**)**;

​    **}**

**}**

**$** ./run.sh

### Deprecate the Nashorn javascript Engine

빠른 변화에 맞추어 대응하기가 어렵다고 판단되어 Javascript 엔진은 Deprecate 되었다.

## Java8에서 Java11로의 전환

Java 8 이후로 새 기능이 추가되고 기능이 향상되었다. 이러한 새 기능과 향상된 기능은 시작, 성능, 메모리 사용을 개선하며 컨테이너(Docker 포함)와의 보다 원활한 통합을 제공한다. 그리고 개발자 생산성을 개선할 수 있도록 새 API가 추가되고 기존 API가 수정되었다.

아쉽게도 전환을 위한 완전한 solution은 제공되지 않는다. 제거된 api, 사용되지 않는 패키지, 내부 api사용, 클래스 로더 변경, 가비지 수집 등의 차이점에 대한 테스트가 필요하다. 사실 JDK에서 제거된 JavaEE 또는 CORBA모듈에 의존하는 경우를 제외하고는 큰 문제없이 JDK11에서 실행될 수 있다.

Java 11에는 잠재적인 이슈를 해결하는 데 유용하게 사용할 수 있는 두 가지 도구인 *jdeprscan* 및 *jdeps*가 포함되어 있다. 

[jdeprscan](https://docs.oracle.com/en/java/javase/11/tools/jdeprscan.html) 은 더 이상 사용되지 않거나 제거된 API 사용을 찾는다. 

[jdeps](https://docs.oracle.com/en/java/javase/11/tools/jdeps.html) 는 Java 클래스 종속성 분석기다. `--jdk-internals` 옵션과 함께 사용할 경우 *jdeps*는 어떤 클래스가 어떤 내부 API에 종속되는지 알려준다. Java 11에서 내부 API를 계속 사용해도 되지만, 사용 방법을 바꾸는 것을 최우선으로 해야 한다.

Gradle과 Maven에 모두 사용할 수 있는 *jdeps* 및 *jdeprscan*플러그 인이 있다. 빌드 스크립트에 이러한 도구를 추가해 놓는 것이 좋다.

| 도구      | Gradle 플러그 인                                             | Maven 플러그 인                                              |
| :-------- | :----------------------------------------------------------- | :----------------------------------------------------------- |
| jdeps     | [jdeps-gradle-plugin](https://github.com/kordamp/jdeps-gradle-plugin) | [Apache Maven JDeps 플러그 인](https://maven.apache.org/plugins/maven-jdeps-plugin/index.html) |
| jdeprscan | [jdeprscan-gradle-plugin](https://github.com/kordamp/jdeprscan-gradle-plugin) | [Apache Maven JDeprScan 플러그 인](https://maven.apache.org/plugins/maven-jdeprscan-plugin/index.html) |

### Transition from java8 to 11

https://docs.microsoft.com/ko-kr/azure/developer/java/fundamentals/transition-from-java-8-to-java-11 

## **JDK12 주요 변경사항**

https://openjdk.java.net/projects/jdk/12/ 

### Shenandoah: A Low-Pause-Time Garbage Collector (Experimental)

Shenandoah라는 이름의 GC(Garbage Collector) 알고리즘이 새로 추가되었다. 실행 중인 Java 스레드와 동시에 GC를 실행하여 GC 중지 시간을 단축하는 알고리즘으로. 힙 크기와는 무관하게 동일한 중지 시간을 유지하므로 대용량 heap 애플리케이션에 유용하다. 아직 실험적인 기능으로 Shenandoah GC를 활성화하려면 다음 옵션을 사용해야 한다.

-XX:+UnlockExperimentalVMOptions -XX:+UseShenandoahGC

### Microbenchmark Suite

JDK 소스 코드 자체를 추가하거나 수정하려는 사람들을 위해 JDK 소스 코드에 다양한 JMH(Java Microbenchmark Harness) 벤치 마크가 추가되었다. JDK 소스 코드에 기본 마이크로 벤치 마크 제품군을 추가하면 개발자가 기존 마이크로 벤치 마크를 쉽게 실행하고 새 마이크로 벤치 마크를 쉽게 만들 수 있다. 추가되는 마이크로 벤치마크는 JMH(Java Microbenchmark Harness)를 기반으로 하며 JVM에서 돌아가는 프로그램의 성능을 테스트한다. (작성하는 방법은 [여기](http://hg.openjdk.java.net/code-tools/jmh/file/tip/jmh-samples/src/main/java/org/openjdk/jmh/samples/) 를 참고)

### Switch Expressions (Preview)

기존에 제공하던 switch문을 이후 JDK 14에서 Preview로 제공될 instance of의 패턴 매칭(JEP 305)을 사용할 수 있도록 단순화된 표현으로 변경되었다.

전통적인 switch 문에서는 값을 변수에 할당하여 값을 반환해야 했다. 하지만 Java 12에서는 break 또는 case value ->를 사용하여 스위치에서 값을 반환할 수 있다.

// before jdk12

private static String getText**(**int number**)** **{**

​        String result = "";

​        switch **(**number**)** **{**

​            case 1, 2:

​                result = "one or two";

​                break;

​            case 3:

​                result = "three";

​                break;

​            case 4, 5, 6:

​                result = "four or five or six";

​                break;

​            default:

​                result = "unknown";

​                break;

​        **}**;

​        **return** result;

​    **}**

// after jdk12 - using break

private static String getText**(**int number**)** **{**

​    String result = switch **(**number**)** **{**

​        case 1, 2:

​            break "one or two";

​        case 3:

​            break "three";

​        case 4, 5, 6:

​            break "four or five or six";

​        default:

​            break "unknown";

​    **}**;

​    **return** result;

**}**

// after jdk12 - using case value ->

private static String getText**(**int number**)** **{**

​    **return** switch **(**number**)** **{**

​        case 1, 2 -**>** "one or two";

​        case 3 -**>** "three";

​        case 4, 5, 6 -**>** "four or five or six";

​        default -**>** "unknown";

​    **}**;

**}** 

### JVM Constants API

모든 클래스는 cp_info라고 명시된, 내부의 메서드와 클래스 그리고 String과 Integer 같은 값을 바이트코드 형태로 저장하는 constant pool을 가진다.

cp_info **{**

​    u1 tag;

​    u1 info**[]**;

**}**

constant pool은 어떤 메서드나 필드를 참조할 때, JVM이 해당 메서드와 필드의 실제 메모리상 주소를 알기 위해서 참조하는 테이블이다. 이 제안에서는 이러한 constant pool에서 사용할 수 있는, 키 클래스 파일 및 런타임 아티팩트(예 : 상수 풀)를 모델링하기 위한 새로운 패키지( java.lang.invoke.constant ) API를 소개하고 있다.

### One AArch64 Port, Not Two

Java 12 이전에는 64 비트 ARM 아키텍처를 위한 두 가지 소스 코드 또는 포트가 중복으로 존재함.

- Oracle – src/hotspot/cpu/arm
- Red Hat? – src/hotspot/cpu/aarch64

Java 12에서는 Oracle src/hotspot/cpu/arm 포트를 제거하고 하나의 포트 src/hotspot/cpu/aarch64만 유지하여 aarch64를 64비트 ARM 아키텍처의 기본 빌드로 만들었다.

### Default CDS Archives

64비트 플랫폼에서의 JDK 빌드 프로세스를 개선하여 CDS(Class Data Sharing) 아카이브를 생성하는 것을 목표로 하는 제안. CDS는 이전 Java10에 언급된 내용으로 JVM 기동시에 성능을 향상하거나, 여러 대의 JVM이 하나의 물리 장비 또는 가상장비에서 돌아가는 경우, 자원에 미치는 영향을 줄이기 위해 개발된 기능이다.

이 제안에서는 사용자가 직접 실행할 필요 없이, -Xshare:dump 옵션을 통해서 CDS를 사용할 수 있도록 제안하고 있다. 또한, JDK 11의 VM에는 -Xshare:auto가 기본으로 사용되도록 설정되어 있기 때문에 CDS의 이점을 사용할 수 있으며, 이를 사용하지 않기 위해서는 -Xshare:off 명령어를 사용하면 된다.

java -Xshare:off HelloWorld.java

### Abortable Mixed Collections for G1

GC(Garbage Collection) 중 하나인 G1이, 효율적으로 동작하도록 하기 위해 중단 가능한 Collection을 가지도록 변경하는 제안.

GC가 발생할 경우, STW(Stop The World)라는 이름의 동작으로 불필요한 데이터들을 수집할 수 있는 시간을 가지는데, 이 시간은 일반적으로 애플리케이션 동작 중간에 들어가는 시간이다. 따라서 이 시간이 길어질수록, 애플리케이션은 느려지게 된다. 따라서, 정해진 시간 내에 불필요한 객체들을 수집하지 못할 경우, GC를 중단할 수 있도록 하는 제안이다.

GC 대상을 80%의 필수 대상(Mandatory)과 20%의 선택적 대상(Optional)으로 나눈 뒤, 우선적으로 필수적인 부분에서 수집을 진행한다. 이후 남은 시간에 선택적 부분에서 수집을 진행하되, 남아있는 정지시간에 선택적 부분을 수집하지 못하리라 판단하면, 이를 다음 GC 시간의 선택적 부분으로 넘기게 된다.

### Promptly Return Unused Committed Memory from G1

GC가 활성화된 상태일 때 Java의 힙 메모리를 운영체제에 반환하도록 하는 내용을 담고 있는 제안.

현재 G1은 Full GC가 일어나거나 Concurrent cycle이라는 상황에만 Java의 힙 메모리를 운영체제에 반환한다. 하지만, Full GC는 Java에서 최대한 피해야 할 상황이므로, Concurrent cycle만 해당 반환작업을 일으킬 수 있는데, 외부에서 강제하지 않는 한 대부분의 경우에는 힙 메모리를 반환하지 않는다.

이러한 동작은 하이퍼바이저의 자원을 공유해서 사용하는 컨테이너 환경에서 특히나 불리한데, VM이 비활성인 경우, 해당 VM에 할당된 메모리의 일부만 사용하는 단계에서도 G1은 모든 힙 메모리를 유지하게 되고, VM을 사용하는 사용자는 불필요한 메모리를, 자원을 제공하는 클라우드 공급자는 하이퍼바이저의 자원을 모두 활용하지 못하게 된다. 따라서, VM의 활동 상태를 감지하여 힙 사용량을 조절할 수 있게 한다.

위에서 설명한 Shenandoah와 OpenJ9의 GenCon collector에서는 이미 유사한 기능을 제공하고 있으며 OpenJDK에서 테스트한 결과, 야간에는 메모리의 약 85%까지 줄일 수 있었다고 한다.

### Files.mismatch

java.nio.file 패키지에 두 개의 파일을 비교하기 위한 Files.mismatch(Path path, Path path2) 함수가 추가되었다. 인자로 받은 두 개 Path에 위치한 파일을 비교하여, 처음으로 다른 부분의 위치를 반환하고 동일한 경우, -1L을 반환한다.

public static long mismatch**(**Path path, Path path2**)** throws IOException

### NumberFormat.getCompactNumberInstance

Locale과 NumberFormat.Style에 따라서 다른 형태로 값을 반환해주는 함수가 추가되었다.

NumberFormat format = NumberFormat.getCompactNumberInstance**(****new** Locale**())**

### Collectors.teeing

Stream API에 추가되는 Collectors.teeing 함수 두 개의 Collector와 하나의 BiFunction 총 세 개의 인자를 받는다. 처음 받은 두 개의 Collector의 결과를 세 번째 BiFunction에서 받아서 계산할 수 있다.

double mean = Stream.of**(**1, 2, 3, 4, 5**)**

​                .collect**(**Collectors.teeing**(**

​                        summingDouble**(**i -**>** i**)**,

​                        counting**()**,

​                        **(**sum, n**)** -**>** sum / n**))**;

System.out.println**(**mean**)**; // 3.0

### String 클래스

- String.indent(int n) : 입력한 n 만큼 들여 쓰기 하는 함수. 음수를 넣을 경우, 앞으로 당긴다.
- String.transform(Function<? super String, ? extends R> f) : 제공된 함수에 특정 String 인스턴스를 입력으로 제공하고 해당 함수에서 반환된 출력을 반환한다.`String str = "1000"; Integer integer = str.transform(Integer::parseInt); System.out.println(integer);`

## **JDK13 주요 변경사항**

https://openjdk.java.net/projects/jdk/13/ 

### Dynamic CDS Archives

Dynamic CDS Archives는 jdk12에서 추가된 Default CDS Archives의 확장된 버전이다. 사용성을 개선하고 Default CDS Archives에는 없는, 로드된 애플리케이션의 클래스와 라이브러리 클래스를 포함하도록 개선되었다.

#### Motivation

HotSpot에서 AppCDS(애플리케이션 클래스 데이터 공유)를 사용하여 애플리케이션 클래스를 저장하면, 추가적인 Startup 시간과 메모리의 이점을 볼 수 있지만, 여전히 세 가지 정도의 추가적인 절차가 필요하다.

1. 클래스 리스트를 생성하기 위한 하나 이상의 trial run
2. 생성된 클래스 리스트를 사용하여 아카이브를 덤프
3. 아카이브와 함께 실행

또한, 이 세 가지 절차는 기본 클래스 로더를 사용하는 애플리케이션에서만 동작하며 HotSpot에서 experimental로 지원하지만 사용하기가 쉽지가 않다.

#### Goals

이 제안에서는 이러한 불편함을 해결하기 위해서 Java 애플리케이션 실행 시, 간단하게 커맨드라인에 -XX:ArchiveClassesAtExit 옵션을 주는 것으로 AppCDS를 활성화 할 수 있다. 이렇게 실행된 Java 애플리케이션은 종료 시에 jsa라는 시스템 아카이브 파일을 생성하는데, 해당 파일을 이용해 메타데이터를 공유하는 Java 애플리케이션을 향상된 성능으로 실행시킬 수 있다. 또한, 아래와 같이 옵션에 인수를 주어 생성될 아카이브 파일의 이름을 지정할 수 있다.

$ bin/java -XX:ArchiveClassesAtExit=hello.jsa -cp hello.jar Hello

이렇게 생성된 아카이브 파일은 아래와 같이 사용할 수 있다.

$ bin/java -XX:SharedArchiveFile=hello.jsa -cp hello.jar Hello

이 방식은 위의 *‘1. trial run’* 절차를 제거하여 AppCDS의 사용이 간편해지고, 기본 제공 클래스 로더와 사용자 정의 클래스 로더 효과를 모두 지원한다. 또한, JEP350의 개선기능은 애플리케이션의 첫 실행에서 자동 아카이브 생성을 수행할 수 있다. 그러면 *‘2. 아카이브 덤프’* 절차를 제거할 수 있게 되고, 이는 CDS/AppCDS의 사용을 자동화할 수 있다.

### ZGC: Uncommit Unused Memory (Experimental)

사용하지 않는 힙 메모리를 OS에 반환하도록 ZGC를 개선하는 제안.
ZGC는 JDK11부터 실험적으로 도입된 GC로서 -XX:+UnlockExperimentalVMOptions XX:+UseZGC으로 ZGC를 활성화할 수 있다.

#### Motivation

초기 ZGC는 오랫동안 사용하지 않더라도 메모리를 OS에 반환하지 않는 문제가 있어 아래와 같은 몇몇 환경에서는 좋은 방식이 아니었다.

- 사용한 리소스만큼 비용을 지불하는 컨테이너 환경
- 오랫동안 유휴(Idle) 상태로 있거나 다른 애플리케이션들과 리소스를 공유하는 환경
- 시작상태와 실행상태의 메모리 사용량이 다른 환경 (실행 시에는 많은 메모리를 사용하지만, 실행 이후에는 일정한 메모리만을 사용하는 환경)

#### Goals

따라서 ZGC는 ZPage라는, page cache 내의 사용되지 않는 메모리 집합을 정해진 정책에 따라 커밋 해제하여 OS로 반환하되, 최소 힙 크기(-Xms) 아래로는 줄어들지 않도록 지정하게 변경되었다. (-Xms와 -Xmx가 동일한 경우, 이 기능이 암시적으로 비활성화된다. 명시적으로 비활성화하기 위해서는 -XX:-ZUncommit을 사용) 일반적으로 page cache는 LRU(Least Recently Used) 방식을 사용하고 page 크기별로 구분하기 때문에 메모리를 해제하는 방법은 비교적 간단하지만, 문제는 캐시에서 ZPage를 제거할 시기를 결정하는 데 있었다.

단순하게는 일정 시간이 지나면 제거되도록 설정할 수 있고, 실제로 이 방식은 Shenandoah GC에서, 기본값 5분으로 사용하고 있다. ZGC도 -XX:ZUncommitDelay=<seconds>(default 300초) 으로 간단한 시간 정책을 제공할 수 있다. 이러한 방식 외에도, GC가 일어나는 빈도에 기초하여 메모리 해제 주기를 설정할 수도 있다.

### Reimplement the Legacy Socket API

java.net.Socket 및 java.net.ServerSocket API의 기본 구현을 유지보수와 디버그하기 쉬운 형태로 리팩터링하는 제안.

#### Motivation

java.net.Socket과 java.net.ServerSocket은 JDK 1.0에서 처음 등장하였는데 유지보수와 디버깅이 어려운 레거시 Java 및 C 코드의 혼합 형태로 구현되어 아래와 같은 몇 가지 문제가 있었다.

- 스레드 스택을 I/O 버퍼로 사용하여 디폴트 스레드 스택 크기를 몇 번이고 늘려야하는 하는 문제.
- 네이티브 자료구조를 사용해 구현한 비동기 close에는 수년 동안 미묘한 안정성/이식성 문제가 존재.
- 구현에는 여러 가지의 동시성 문제가 있으며 이를 해결하기 위해서는 정밀 검사가 필요.
- 네이티브 메서드에서 스레드를 Blocking 하는 대신, park 하는 미래의 환경에서는 현재 구현이 목적에 맞지 않음.

#### Goals

따라서, java.net.Socket 및 java.net.ServerSocket API는 모든 조작을 [SPI(Service Provider Interface)](https://en.wikipedia.org/wiki/Service_provider_interface) 메커니즘인 java.net.SocketImpl에 위임하였고, 내장 구현을 “plain” 구현이라고 하며, SocketInputStream 및 SocketOutputStream 클래스를 지원하는 비공개 PlainSocketImpl에 의해 구현되도록 하였다.
-> SPI(Service Provider Interface): 플러그인 형태로 제공하는 인터페이스. 인터페이스만 정의하고 각 구현은 가져다 사용하는 벤더에서 구현하도록 함.

- SocketImpl은 레거시 SPI 메커니즘이며, 새로운 구현에서 해당하지 않은 경우에는 이전 구현을 모방하여 호환되도록 동작한다.
- Timeout(connect, accept, read)을 사용하는 소켓 연산자를, non-blocking 모드로 변경하고 소켓을 polling 하여 구현한다.
- SocketImpl이 GC되고 Socket이 명시적으로 닫히지 않은 경우, java.lang.ref.Cleaner 메커니즘이 사용된다.
- 연결 재설정 처리는 이전구현과 동일하게 처리된다.

아래는 이전 구현과 다르게 동작하는 상황에 해당하는 내용으로. 처음 두 개를 제외한 나머지들은 -Djdk.net.usePlainSocketImpl 옵션으로 완화할 수 있다.

- PlainSocketImpl.getINputStream()으로 반환된 InputStream과 OutputStream이 각각 java.io.FileInputStream과 java.io.FileOutputStream을 extend 한다.
- 사용자 정의 SocketImpl을 사용하는 ServerSocket은 플랫폼 SocketImpl과 함께 반환되는 Socket에 연결할 수 없다.
- InputStream 및 OutputStream은 이전 구현에서 EOF(End Of File)에 대한 테스트를 먼저 수행하여 -1를 반환하지만, 신규 구현에서는 Null 및 범위 검사를 먼저 수행한다.
- 수신 큐에서 읽지 않은 바이트로 소켓을 닫으면 기본 소켓이 정상적으로 종료된다. Windows 이외의 플랫폼에서는 중단/강제종료로 이어진다.
- Oracle Solaris 특정: 네트워크 오류가 발생하여 setsocketopt 또는 ioctl 호출이 실패하는 경우, 연결 재설정으로 인해 읽기 시도가 실패하지만, 이러한 방식은 깨지기 쉽고 유지보수가 어렵기 때문에 신규 구현에서는 이 동작을 따라 하지 않는다.
- Oracle Solaris 특정: TCP 소켓 연결 이후에 IPV6_TLCASS 소켓 옵션을 변경할 수 없게 되었다. 이전 구현은 setTrafficClass 함수에 지정된 값을 캐시하여 마스킹하였었음.
- 예외 시 SocketException을 발생시키지만, 신규 구현에서는 일부 같은 예외가 발생하지 않을 수 있다. 또한, 예외 메시지가 다른 경우도 존재한다. 예) Windows에서 SocketException시, 이전 구현은 오류 코드를 영어 전용 메시지를 사용하지만, 신규 구현은 시스템 메시지를 사용한다.
- 특정 작업을 실행할 때 성능이 다를 수 있다. 이전 구현은 ServerSocket에서 accept 메소드를 호출하는 여러 스레드가 커널에서 대기하지만, 신규 구현은 하나의 스레드가 accept를 호출하기 위해 대기하고 나머지 스레드들은 큐에서 lock을 얻기 위해 대기하기 때문이다.

### Switch Expressions (Second Preview)

JDK 12에서 preview로 언급되었던 Switch Expressions의 second preview. 내용은 [JEP325](https://openjdk.java.net/jeps/325) 와 동일하고 break 키워드가 yield 키워드로 변경되었다.

int result = switch **(**s**)** **{**

​    case "Foo": 

​        yield 1;

​    case "Bar":

​        yield 2;

​    default:

​        System.out.println**(**"Neither Foo nor Bar, hmmm..."**)**;

​        yield 0;

**}**;

JDK12에서 나왔던 break value; 표현식이 yield value;로 대체되었다. return value;가 제어권이 함수 호출자나 생성자에게 있었다면, yield value;는 스위치 표현식에게 제어권을 전달한다.

int j = switch **(**day**)** **{**

​    case MONDAY  -**>** 0;

​    case TUESDAY -**>** 1;

​    default      -**>** **{**   //블록이나 기존의 switch-case문에서 yield를 사용

​        int k = day.toString**()**.length**()**;

​        int result = f**(**k**)**;

​        yield result;

​    **}**

**}**;

### Text Blocks (Preview)

다른 언어에서도 등장하는 Text block이 Java에도 추가된다. 기존에 여러 줄의 텍스트를 사용할 때, +와 new line으로 연결해주었다면 이 제안에서는 “””을 통해 multi line으로 텍스트를 입력할 수 있도록 제안하고 있다.

##### HTML example (as-is)

String html = "<html>\n" +

​              "    <body>\n" +

​              "        <p>Hello, world</p>\n" +

​              "    </body>\n" +

​              "</html>\n";

##### HTML example (to-be)

String html = """

​              <html>

​                  <body>

                      <p>Hello, world</p>

​                  </body>

​              </html>

​              """;

##### SQL example (as-is)

String query = "SELECT `EMP_ID`, `LAST_NAME` FROM `EMPLOYEE_TB`\n" +

​               "WHERE `CITY` = 'INDIANAPOLIS'\n" +

​               "ORDER BY `EMP_ID`, `LAST_NAME`;\n";

##### SQL example (to-be)

String query = """

​               SELECT `EMP_ID`, `LAST_NAME` FROM `EMPLOYEE_TB`

​               WHERE `CITY` = 'INDIANAPOLIS'

​               ORDER BY `EMP_ID`, `LAST_NAME`;

​               """;

##### Polyglot language example (as-is)

ScriptEngine engine = **new** ScriptEngineManager**()**.getEngineByName**(**"js"**)**;

Object obj = engine.eval**(**"function hello() {\n" +

​                         "    print('\"Hello, world\"');\n" +

​                         "}\n" +

​                         "\n" +

​                         "hello();\n"**)**;

##### Polyglot language example (to-be)

ScriptEngine engine = **new** ScriptEngineManager**()**.getEngineByName**(**"js"**)**;

Object obj = engine.eval**(**"""

​                         function hello() {

​                             print('"Hello, world"');

​                         }

​                         hello();

​                         """**)**;

이 제안은 Java string의 가독성을 향상하고 이스케이프 문자열 사용을 피하고자 만들어졌다. 특수문자 이스케이프 방식은 기존의 문자열 사용법과 동일하고 필요한 경우, 아래 String 관련 함수들을 사용할 수 있다.

- String::stripIndent()
- String::translateEscapes()
- String::formatted(Object… args)





>출처
>
>https://okky.kr/article/802815
>
>https://daddyprogrammer.org/post/10411/jdk-roadmap-change-jdk9-11/