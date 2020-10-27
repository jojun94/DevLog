### JetBrains가 사랑하는 Java의 25가지 특징

## 이전 버전과의 호환성

Java는 25년 전의 코드를 최신 버전의 Java에서도 실행할 수 있다는 점에서 거의 독보적입니다. 언어 개발자는 이전 버전과의 호환성을 매우 중요하게 생각하기에 수많은 조직에서 몇년이 지난 코드라도 JVM에서 실행된다는 점을 고려해 Java를 기본 개발 플랫폼으로 적극 수용했습니다.

## 성숙도

오랜 시간이 지난 만큼 이점도 많습니다. 지난 25년 동안 개발자들은 다양한 업계 및 비즈니스 유형과 다양한 플랫폼에서 Java로 애플리케이션을 작성해왔습니다. 또한, 25년 동안 개발자들은 학교, 대학, 부트캠프, 직장에서 Java를 배워 왔습니다. 이를 통해 시간의 흐름에 따라 경험에서 지식을 축적하고 계속 성장하는 거대한 에코시스템이 형성되었습니다. Java 및 Java로 해결 가능한 문제에 관해서는 [공급업체와 비영리단체](https://en.wikipedia.org/wiki/List_of_Java_virtual_machines), [개인들](https://stackoverflow.com/questions/tagged/java)이 자세히 문서화하고 지원하고 있습니다. 무엇보다 우리 같은 개발자에게 매우 중요한 이점은 Java가 성숙하고 폭넓게 채택되면서 Java로 코딩하려는 개발자에게 수많은 일거리가 생긴다는 것입니다!

## 지속적 개선

이전 버전과의 호환성 및 성숙도와 대비되는 특징은 플랫폼과 언어의 발전입니다. Java는 2017년(Java 9)부터 6개월마다 새로운 버전이 출시되어 꾸준히 변경되고 개선되어 왔습니다. [테스트 버전 기능](https://docs.oracle.com/en/java/javase/14/language/preview-language-and-vm-features.html)을 결합하여 새로운 구문을 실험하고 개발자로부터 피드백을 받은 다음, Java 사용자들을 위한 실용화된 새로운 기능을 표준화합니다.

## 균형성

Java는 이전 버전과의 호환성과 미래 사이에서 까다로운 균형을 맞춰야 합니다. 이전 버전과의 호환성을 평가하고 6개월마다 출시하는 현재의 접근 방식은 3년마다 출시되는 [장기적 지원](https://www.oracle.com/java/technologies/java-se-support-roadmap.html)과 결합되어 균형을 적절히 맞추고 있는 듯 보입니다. Java는 [제거될 예정인](https://docs.oracle.com/javase/9/core/enhanced-deprecation1.htm#JSCOR-GUID-E182DAF6-282B-4C1F-8CCF-0A61008E3F11) 사용 중단 기능에 대한 경고를 제공하고 없어질 수 있는 항목의 대체 기능을 마련하여 발전합니다.

높은 안정성을 원하는 사람은 장기적 지원 릴리스를 계속 사용하면 됩니다. 업그레이드 시기가 되었을 때 위험을 줄이려면 6개월마다 출시되는 릴리스를 정기적으로 테스트할 수도 있습니다. 6개월마다 업그레이드하는 것이 좋은 사람은 릴리스가 나올 때마다 최신 Java 버전으로 업데이트하면 됩니다. 새로운 구문이 표준화되기 전에 사용해 보고 싶은 개발자는 [테스트 버전 기능을 활성화](https://docs.oracle.com/en/java/javase/14/language/preview-language-and-vm-features.html)할 수 있으며, 최대한 빨리 체험해 보고 싶은 개발자는 새 구문이 출시되기 전에 [얼리 액세스](http://jdk.java.net/) 릴리스 버전을 사용해 볼 수 있습니다. 최신 Java 버전을 사용하는 팀은 실제로 모든 이점을 누릴 수 있습니다.

## 표준

표준은 언어 기능만큼 개발자의 흥미를 끌지는 않지만 Java, [Java EE](https://www.oracle.com/java/technologies/java-ee-glance.html), [Jakarta EE](https://jakarta.ee/specifications/platform/8/platform-spec-8.html) 및 개발자가 마주치게 되는 일반적인 사용 사례에 대한 표준이 있으면 개발자의 삶이 더 편해집니다. JDBC를 사용하여 데이터베이스와 통신하는 방법을 이해한다는 것은 데이터베이스 드라이버가 구현되는 방식에 신경 쓸 필요가 없으며 데이터베이스와 상호작용하는 방식이 항상 동일하다는 것을 의미합니다. [JCP](https://jcp.org/)는 Java 표준을 파악하는 데 사용되는 프로세스 중 하나입니다.

[Java 언어 사양](https://docs.oracle.com/javase/specs/)은 Java 언어의 형태와 컴파일러의 작동 방식을 설명합니다. 여기에는 JVM 또는 하드웨어에 관계없이 애플리케이션의 작동 방식을 예측하는 데 도움이 되는 [Java 메모리 모델](https://docs.oracle.com/javase/specs/jls/se14/html/jls-17.html#jls-17.4)이 포함되어 있습니다. [Java 가상 머신 사양](https://docs.oracle.com/javase/specs/jvms/se14/html/index.html)은 JVM에 관한 하위 수준 세부 정보를 설명합니다. 이러한 사양을 통해 서로 다른 제공업체에서 배포한 JDK가 다양한 플랫폼에서 실행되고 지정된 예측 가능한 방식으로 작동하도록 만들 수 있습니다. 그 결과 우리는…

## 작성은 한 번만, 실행은 어디서나

[WORA](https://en.wikipedia.org/wiki/Write_once,_run_anywhere)는 Java의 기반이 된 원래 아이디어 중 하나로, 오늘날에는 너무나 당연시되어 이 개념이 얼마나 혁신적이었는지 깨닫지 못할 정도입니다. 2002년 제가 몸 담았던 매우 큰 조직에서는 이전 기술 스택에서 Java로 전환했습니다. 수많은 다른 하드웨어가 이미 있는 상황에서 애플리케이션용 특정 하드웨어를 구매하지 않고 새로운 Java 애플리케이션을 실행할 수 있다는 것이 모든 개발을 Java로 옮긴 주요 이유 중 하나였습니다. 클라우드의 시대이기도 한 오늘날 이 사례는 관련성이 별로 없어 보일 수 있지만 WORA의 작동이 항상 보이는 게 아니라고 해서 여전히 그 이점을 활용하지 않는 것은 아닙니다. 그리고 당연한 말이지만 [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)(또는 NetBeans)를 사용하는 경우 데스크톱에서 WORA를 활용하게 됩니다.

## 성능

Java에 익숙하지 않은 사람들에게 놀라운 특징이지만 Java는 성능이 매우 높은 언어입니다. 25년 동안 성능이 개선되어온 성숙한 플랫폼으로서, 다양한 성능 프로파일을 가진 수많은 가비지 컬렉터가 있으며 JVM은 실제 프로덕션 사용 사례에서 대부분의 인간 개발자가 할 수 있는 것보다 훨씬 더 효과적으로 런타임 시 코드를 최적화합니다. 예를 들어 Java는 트랜잭션의 지연 시간이 짧아야 하고 성능이 예측 가능해야 하는 금융업계에서 널리 사용됩니다.

## 메모리 관리 및 가비지 컬렉션

자동 가비지 컬렉션은 25년이 지난 지금, 일반적으로 당연하게 여기게 된 또 다른 기능입니다. 사용자는 애플리케이션에서 메모리를 할당하는 방법이나 메모리 여유 공간을 확보하는 방법에 대해 고민할 필요가 없습니다. 각 JVM에는 하나 이상의 서로 다른 GC 알고리즘이 있으므로 애플리케이션의 내부 상태에 크게 신경 쓸 필요 없이 애플리케이션에서 잘 작동하는 알고리즘 선택하고 애플리케이션의 비즈니스 로직을 작성할 수 있습니다.

## 관찰 가능성 및 관리

애플리케이션이 실행되는 동안 진행 중인 작업을 확인하고 싶은 경우 사용할 수 있는 도구가 매우 많이 있습니다. 특히 [Java Flight Recorder](http://openjdk.java.net/jeps/328) 및 [Mission Control](http://openjdk.java.net/projects/jmc/)이 OpenJDK에 포함되어(Java 11 이후) 대부분의 도구가 무료입니다. [JMX](https://docs.oracle.com/javase/tutorial/jmx/overview/index.html)와 같은 도구를 사용하면 애플리케이션을 동적으로 관리할 수도 있습니다.

## Java 가상 머신(JVM)

지금까지 언급한 수많은 기능은 [JVM](https://en.wikipedia.org/wiki/Java_virtual_machine)의 특징이지만, JVM은 Java 언어 자체는 별개의 것이라는 사실을 특히 명확히 하고 싶습니다. 이미 다루었던 기능 중 몇가지(WORA, 런타임 최적화, 성능, 제공업체 선택 등)를 포함하여 JVM이 사랑받는 이유는 다양하지만, 이러한 기능 대부분은 표준과 사양 덕에 구현된 것입니다. 또한 JVM이 Java 언어와 별개의 것이라는 사실도 중요합니다. 이는 다양한 언어를 이 플랫폼에 구축할 수 있고, 방금 언급된 JVM의 뛰어난 기능을 모두 활용하는 동시에 다양한 유형의 구문과 언어 기능을 제공할 수 있다는 뜻이기 때문입니다.

## 기타 JVM 언어

Java 6과 8 사이의 조용한 시대(Java 7에는 훌륭한 기능이 있지만, Java 개발자에게는 큰 릴리스처럼 느껴지지 않았습니다)에 Java가 살아남고 심지어 발전했던 이유 중 하나는 기타 JVM 언어 덕분입니다. 물론 JetBrains가 가장 좋아하는 언어는 [Kotlin](https://kotlinlang.org/)이지만, JVM은 [Groovy](https://groovy-lang.org/), [Scala](https://www.scala-lang.org/), [Clojure](https://clojure.org/), [JRuby](https://www.jruby.org/)와 같은 다른 인기 언어 및 기타 수많은 [재구현 언어 또는 새로운 언어](https://en.wikipedia.org/wiki/List_of_JVM_languages)가 사용되는 플랫폼입니다. 대부분의 경우 [이러한 언어와 기본 Java 간의 상호 운용성](https://kotlinlang.org/docs/reference/java-interop.html)은 다양성을 수용하고 활용할 수 있도록 도와줍니다.

## 라이브러리/프레임워크

가장 매력적인 특징 중 하나는 수많은 라이브러리와 프레임워크를 선택할 수 있고 그중 다수가 오픈 소스이며 무료로 사용할 수 있다는 것입니다. 특히 [Spring](https://spring.io/) 및 [Spring Boot](https://spring.io/projects/spring-boot)와 같은 인기 프레임워크를 사용하면 소규모 서비스에서 대규모의 복잡한 엔터프라이즈 애플리케이션에 이르기까지 모든 것을 쉽게 작성할 수 있습니다. 표준이 있으면 많은 경우 다른 컨텍스트에서 비슷한 항목을 사용할 때 라이브러리를 이해하고 사용하는 것이 어렵지 않습니다. Java가 성숙되었고 해당 커뮤니티가 오픈 소스를 조기에 채택한 만큼, 대개 표준 관련 문제에 대한 해결책이 마련되어 있으므로 처음부터 연구를 시작할 필요가 없습니다. 또한 이러한 해결책 중 대부분이 오랫동안 사용되어 왔기 때문에 충분히 테스트되고 이해하기 쉬우며 문서로 잘 정리되어 있습니다.

## 빌드 도구 및 종속 요소 관리

불쌍한 개발자(저요!)가 실행하려는 코드에 필요한 클래스가 일부 들어 있는 알 수 없는 [JAR](https://en.wikipedia.org/wiki/JAR_(file_format)) 파일을 인터넷에서 검색해야 했던 시절은 오래전에 끝났습니다. 특히 Maven과 Gradle을 사용하면 애플리케이션을 간편하게 빌드하고 배포할 수 있을 뿐만 아니라 필요한 모든 종속 요소를 포함하여 표준 방식으로 프로젝트를 쉽게 설정할 수 있습니다. 또한 새로운 프로젝트든 기존 프로젝트든 코딩을 쉽게 시작할 수 있습니다. [Maven Central](https://maven.apache.org/repository/index.html)이나 [Bintray](https://bintray.com/)와 같은 공용 저장소를 사용하면 라이브러리를 검색하고 게시할 수도 있습니다.

## JUnit 및 자동화된 테스트

[JUnit](https://junit.org/junit5/)은 [1997년에 제작](https://martinfowler.com/bliki/Xunit.html)되어 Java만큼 오래되었습니다! Java 세계에서 가장 일반적인 자동화된 테스트 프레임워크로서, IntelliJ IDEA에서는 새로운 Java 프로젝트에는 테스트 프레임워크가 필요하다는 고려 하에 [JUnit 및 TestNG를 모두 함께 제공](https://www.jetbrains.com/help/idea/configuring-testing-libraries.html#)합니다. 모든 언어에 대한 최신 테스트 프레임워크 역시 지금은 당연하게 여겨지는 JUnit의 아이디어를 기반으로 합니다. Java 커뮤니티의 자동화된 테스트 문화는 이 하나의 라이브러리 덕분에 성장했습니다.

## IDE

여기는 IntelliJ IDEA 블로그라는 사실을 절대 잊어서는 안 되겠죠! Java의 방대함 때문에 IDE가 필요하다고 생각하든, 실제로 Java가 정적 유형 때문에 IDE를 크게 활용할 수 있다고 생각하든 관계없이 Java 개발자가 IDE를 좋아한다는 것은 사실입니다(저희도 여러분을 좋아하고요!). 개발자가 IDE(IntelliJ IDEA, Eclipse 또는 NetBeans이든)를 효과적으로 사용하는 방법을 배우면 [코드 완성](https://blog.jetbrains.com/idea/2020/05/code-completion/), [코드 생성](https://youtu.be/btqCYUc3nFE), [테스트 실행](https://youtu.be/QDFI19lj4OM), [디버그](https://youtu.be/lAWnIP1S6UA), [탐색](https://youtu.be/1UHsJyCq1SU) 및 [기타 수많은 기능](https://blog.jetbrains.com/idea/2020/04/tips-for-writing-code-in-intellij-idea/)을 이용해 생산성을 크게 향상할 수 있습니다. Java 개발자는 IDE가 제공하는 이점을 일반적으로 매우 좋아합니다.

## Community

Java 커뮤니티는 거대하고 성숙되었으며 활기차고 친절한 커뮤니티입니다. 전 세계 여러 도시에[ Java 사용자 그룹](https://community.oracle.com/community/groundbreakers/java/jug)이 있으며 물리적 모임에 갈 수 없는 경우 참여할 수 있는 [가상 Java 사용자 그룹](https://virtualjug.com/)도 있습니다. [Java Champion](https://community.oracle.com/community/groundbreakers/java/java-champions)은 Java 및 JVM 개발자에게 유용하거나 흥미로운 정보를 공유하는 것으로 알려진 유명한 Java 세계의 기술 리더입니다. Java에는 JDK 자체를 포함하여 [OpenJDK](https://openjdk.java.net/)를 통한 거대한 오픈 소스 커뮤니티가 있습니다. Java 커뮤니티는 학습, 교육, 지속적인 향상에 가치를 두고 표준 및 ‘모범 사례’에 관심을 가지며 실제 환경에서 이를 적용하는 방법에 관해 실용적으로 접근합니다.

## 개발팀

물론 커뮤니티도 사람들로 구성되어 있지만 개발자에게 자신이 가장 중요하게 생각하는 Java 관련 요소에 관해 질문하면 대부분이 자신에게 영향을 미친 Java 세계의 개인을 꼽습니다. 이러한 개인들에는 동료 및 교사부터 [Brian Goetz](https://twitter.com/BrianGoetz), [Angie Jones](https://twitter.com/techgirl1908), [Georges Saab](https://twitter.com/gsaab), [Mala Gupta](http://ejavaguru.com/about/malagupta.html), [Venkat Subramaniam](https://twitter.com/venkat_s)과 같은 사람들까지 다양하게 있습니다. 어떤 이들은 [저](https://twitter.com/trisha_gee)를 언급하기도 합니다. 개인적으로 저는 대학에서 Java를 배운 후 일자리가 많았기 때문에 Java 세계에 들어왔지만, 여기에 계속 머문 이유는 이곳의 사람들을 사랑하고 이들로부터 얻은 도움과 지원에 감사했기 때문입니다.

## Javadoc 및 문서

Java는 [Javadoc](https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html)을 통해 API 문서를 언어의 핵심 부분으로 만듭니다. 세 가지 다른 유형의 주석([Javadoc](https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html), 블록 및 줄)은 개발자가 남긴 주석의 말의 종류가 무엇인지 명확하게 나타냅니다. Javadoc은 특히 메소드를 호출하거나 클래스 또는 패키지를 사용하는 다른 개발자에게 유용한 문서를 남기도록 개발자에게 권장합니다. 개발자가 라이브러리나 코드에 대한 자세한 튜토리얼 정보를 찾을 수 없는 경우에도, 보통은 올바른 방향을 지시해주는 Javadoc이 있습니다.

또한 Java 에코시스템은 일반적으로 개발자에게 양질의 문서를 기대하고 제공하는 것으로 보입니다. 향후 오픈 소스 프로젝트의 커미터가 되려는 이들은 Javadoc 주석 또는 기타 문서의 pull 요청을 제출하도록 권장받고 전 세계의 개발자들은 특정 문제에 관한 해결책을 구하기 위해 블로그나 [StackOverflow에서 질문 및 답변](https://en.wikipedia.org/wiki/List_of_Java_virtual_machines)합니다.

## 오픈 소스

Java 커뮤니티는 오픈 소스를 조기에 수용했을 뿐만 아니라 이제 JDK 자체도 [OpenJDK](http://openjdk.java.net/)를 통해 오픈 소스로 제공됩니다. 오픈 소스를 사용하면 개인뿐만 아니라 여러 공급업체도 쉽게 참여하고 협업할 수 있습니다. Java 자체의 코드를 볼 수 있다는 것도 매력적입니다. 오픈 소스 코드는 복잡한 문제에 관해 이미 열심히 작업하고 고민하며 해결해온 이들로부터 우리 같은 개발자가 배울 수있는 좋은 기회를 제공합니다.

## 무료

Java 플랫폼과 Java 에코시스템에서 가장 많이 사용되는 도구는 개발자가(또는 종종 영리단체도) 사용할 때 돈을 지불할 필요가 없습니다. Oracle이 Java 11에서 라이선스 및 지원을 변경한 후에도 Oracle 및 기타 많은 공급업체는 [프로덕션에서 무료로 언어를 사용하는 방법을 계속 제공](https://docs.google.com/document/d/1nFGazvrCvHMZJgFstlbzoHjpAVwv5DEdnaBr_5pKuHo/edit?usp=sharing)했습니다. 이 글에서 이미 언급된 오픈 소스 프로젝트, 빌드 도구 및 IDE는 모두 무료이거나 무료 옵션이 있습니다. 이는 예산을 계속 고려하며 소프트웨어를 개발해야 하는 모든 규모의 조직이나 코딩을 시작하는 개발자에게 Java가 매력적인 이유이기도 합니다.

## 객체 지향적

물론 [객체 지향 프로그래밍](https://en.wikipedia.org/wiki/Object-oriented_programming)은 유일한 선택지는 아니며 모든 패러다임에는 각각의 장단점이 있습니다. Java는 처음부터 객체 지향적 언어로 설계되었기에 객체 지향의 수많은 설계 패턴 예시와 기타 코딩 모범 사례가 Java로 시연됩니다. 따라서 객체 지향적 프로그래밍 언어를 원한다면 Java를 사용해봐야 할 언어 목록 중 우선적으로 고려해야 할 것입니다.

## 발전과 적응

Java는 과거에도 그랬고, 지금 역시 객체 지향적 프로그래밍 언어입니다. 그러나 한편으로 람다 식, 불변 데이터 구조와 같은 함수 프로그래밍의 일부 개념을 성공적으로 도입하여 객체 지향적 패러다임 내에서 원활하게 작동하도록 만들었습니다. 유형 추론(예: [var](https://openjdk.java.net/jeps/286))을 사용하면 정적 유형 언어의 이점을 얻을 수 있지만 상용구는 적습니다. 컴퓨터 과학은 여전히 젊은 분야이지만, 점차 지식을 쌓으면 학습한 내용을 기존 도구에 적용할 수 있습니다. Java(언어 및 전체 에코시스템)는 새로운 트렌드와 새로운 ‘모범 사례’에 따라, 또한 실제 환경에서 어떻게 작동하는지 확인한 결과를 바탕으로 지속적으로 발전하고 있습니다.

Java는 또한 다른 JVM 언어의 구문과 아이디어를 활용하여 기존 Java 환경에 적합한 것과 적합하지 않을 수 있는 것이 무엇인지 파악합니다. [JCP](https://jcp.org/en/jsr/summary?id=java+community+process)와 [OpenJDK](https://openjdk.java.net/)와 같이 Java가 발전하고 성장하기 위해 사용하는 프로세스와 도구조차도 이러한 끊임없는 발전 과정에서 적합성을 유지하도록 적응시키고 있습니다. 이러한 발전과 적응은 Java가 맞추어야 할 조심스러운 균형의 일부입니다.

## 가독성에 중점

Java 코드는 Java 프로그래머가 아닌 사람도 읽을 수 있는 경우가 많습니다. 이 언어는 과하게 간결하기보다 장황하게 표현되므로 읽을 때 의미를 추론하기가 더 쉽습니다. Java 언어 개발자는 예기치 않은 사용자 지정 동작에 놀라지 않는 것이 중요하다고 생각하기 때문에 연산자 오버로드와 같은 기능을 구현하지 않았습니다. 언어와 프레임워크에서는 ‘마법 같은 동작’을 기피하는 경향이 있습니다. 일부 프레임워크에서는 개발자가 따로 명령하지 않아도 [구성보다 관습(Convention over configuration)](https://en.wikipedia.org/wiki/Convention_over_configuration) 같은 것을 사용해 작업을 수행하지만 가령 [AOP(관점 지향 프로그래밍) 수행 시 어노테이션을 추가](https://docs.spring.io/spring/docs/4.3.15.RELEASE/spring-framework-reference/html/aop.html)하는 것을 삼가하고 문서 및 정적 분석 검사에 어노테이션을 사용하려는 움직임이 확연히 있습니다. 커뮤니티와 에코시스템은 표준과 ‘모범 사례’를 선호하는 편이므로 Java 코드는 종종 매우 다른 프로젝트에서도 비슷한 종류의 규칙을 따릅니다.

## 언어 기능

지금까지 Java에 관해 좋아하는 23가지를 다루었지만 기능은 단 하나도 언급하지 않았습니다! 솔직히 기능을 25가지로 한정하는 것은 매우 어려워 보였고, Java에 관해 우리가 좋아하는 수많은 특징이 항상 구문이나 기능에 관한 것만은 아니기 때문입니다. 그래서 좋아하는 기능에 관해서는 개발자의 목소리로 직접 들려 드리려고 합니다.

- [Collections API](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Collection.html): 오랫동안 사용하며 도움을 많이 받았어요!
- [편리한 컬렉션용 factory 메소드](https://www.baeldung.com/java-9-collections-factory-methods): 수정 불가능한 컬렉션을 훨씬 간편하게 만들 수 있어요.
- [Streams API](https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html): Collections API의 훌륭한 추가 기능으로, Java 8 이후에도 계속 발전하고 있어서 좋았습니다. 병렬 스트림으로 최신 하드웨어를 활용할 수 있는 방법이 생겼어요.
- [람다 식](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html): Streams API에서 특히 유용하지만 그 자체로도 매우 쓸모가 많아요.
- [Optional](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Optional.html): 메소드가 무언가를 제공하지 않을 수 있음을 표현하는 좋은 방법이에요(NullPointerException으로부터 보호해야 할 필요가 없어져요!). Java 8부터 Optional에 대한 개선 사항을 확인할 수 있는 것도 정말 좋아요.
- [java.time](https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/time/package-summary.html): 날짜 및 시간 작업을 위한 최신 API는 반가운 개선 사항이죠.
- [검사된 예외](https://docs.oracle.com/javase/tutorial/essential/exceptions/runtime.html): 사람들은 검사된 예외파와 런타임 예외파로 나뉘지만 적어도 검사된 예외를 사용하려는 사람들에게는 검사된 예외가 제공되죠.
- [어노테이션](https://docs.oracle.com/javase/tutorial/java/annotations/): 어노테이션은 (다른 기능도 있겠지만) 컴파일러가 확인할 수 있는 문서나 대규모 작업을 수행하는 프레임워크에 대한 메모 같은 역할을 해요.
- [JShell](https://docs.oracle.com/javase/9/jshell/introduction-jshell.htm): 드디어 REPL에서 Java로 작업할 수 있게 되었어요.
- [var](https://openjdk.java.net/jeps/286): 유형 추론을 현명하게 사용하면 코드 노이즈를 줄일 수 있어요.
- [액세스 한정자](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html) 및 [모듈성](https://www.oracle.com/corporate/features/understanding-java-9-modules.html): Java를 사용하면 어떤 코드가 어떤 필드, 메소드, 클래스, 모듈에 액세스할 수 있는지 쉽게(Java 9부터는 훨씬 더 쉽게) 명시화할 수 있어요.
- [Switch 식](https://docs.oracle.com/en/java/javase/14/language/switch-expressions.html): 이제 switch 식을 사용해도 덜 지저분해 보이네요!
- [Helpful NullPointerExceptions](https://openjdk.java.net/jeps/358): 좋은 NullPointerException을 마다할 사람이 누가 있을까요? 이제 예외에서 무엇이 null인지에 관해 훨씬 유용한 정보를 개발자에게 제공해줘요.
- [테스트 버전 기능](https://docs.oracle.com/en/java/javase/14/language/preview-language-and-vm-features.html): 테스트 버전 기능이 정말 좋아요! [레코드](https://openjdk.java.net/jeps/359), [instanceof의 패턴 일치](https://openjdk.java.net/jeps/305), [텍스트 블록](https://openjdk.java.net/jeps/355) 기능을 보고 진짜 신났어요.

## 미래

새로운 기능은 6개월마다 출시되며 보통 각각의 장기적 지원 릴리스는 해당 릴리스에서 실행되는 모든 애플리케이션에 대해 기본적으로 더 나은 성능을 제공합니다. Java 15(2020년 9월)에는 [숨겨진 클래스](https://openjdk.java.net/jeps/371), 텍스트 블록(더 이상 테스트 버전으로 제공되지 않음), 업데이트된 레코드 테스트 버전, instanceof에 대한 패턴 일치, [봉인된 클래스](https://openjdk.java.net/jeps/360)의 테스트 버전이 포함될 예정입니다.

[Project Loom](https://wiki.openjdk.java.net/display/loom)에서 고안 중인 사용하기 쉽고 가벼운 동시 실행, [Project Valhalla](https://wiki.openjdk.java.net/display/valhalla/Main)의 인라인 유형, [Project Amber](https://wiki.openjdk.java.net/display/amber)에서 작업 중인 람다의 잔여 요소(leftovers) 등의 다양한 언어 변경 사항, [Project Panama](https://openjdk.java.net/projects/panama/)에서 지원하는 외부 API에 대한 간편한 액세스, [Project Leydon](https://mail.openjdk.java.net/pipermail/discuss/2020-April/005429.html)에서 준비 중인 시작 시간 단축, 가비지 컬렉터에 대한 다양한 개선 사항 등, 향후 출시되기를 기대하는 기능이 많습니다.

Java의 미래는 밝습니다!



> 출처: https://blog.jetbrains.com/ko/2020/05/25/25-things-we-love-about-java-ko/