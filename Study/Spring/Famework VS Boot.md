# Spring Framework VS Spring Boot

+ 환경설정

  + XML 설정

     Spring에서는 환경설정을 XML 파일로 설정하였으나 Spring Boot 에서는 환경설정을 최소화 해주어 개발자가 코드개발에만 집중할 수 있도록 도와준다.

  + Dependency 설정

    Spring에서는 Dependency들의 호환되는 버전을 하나하나 찾아서 수동으로 설정해야 한다, 따라서 추가 및 수정의 버전관리가 어려웠으나 Spring Boot에서는 starter를 통한 Dependency의 자동설정을 통해 버전 관리 및 추가 수정이 용이해졌다.

+ 내장 웹 서버

Spring Boot는 내부에 웹서버를 포함하고 있다. 개발자가 Spring Boot에서 사용할 Tomcat , Jetty, Undertow를 설정할 수 있으며 `org.springframework.boot.web.embedded.*` 를 참고하여 설정 할 수 있다. 이에 따라 Spring에서 `web.xml`  관련 설정을  클래스를 통하여 관리할 수 있으며 starter를 통해 초기 설정을 자동으로 할 수 있다.



+ 정리

Spring Framework 와 Spring Boot를 비교하였을 때, Spring Boot는 inbuilt 되어있는 특징들과 이익들 때문에 더욱 사용하기 편하고 안정적이라고 할 수 있다. 또한 대부분은 auto configured 되어있다. 