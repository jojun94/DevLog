# URL과 URI의 의미와 차이

+ URL (정형화된 자원 위치)

Uniform Resource Locator



+ URI (정형화된 자원 식별자)

Uniform Resource Identifier



+ URI = URL + URN(Uniform Resource Name, 추후 설명 예정)



> 예전에는 URL이 가리키는게 자원(파일)의 위치 였으나
>
> 요즘은 Rewirte 등의 IIS, Tomcat 핸들러 때문에 자원 식별자 라고 부른다.
>
> 즉 웹사이트의 주소가 http:// myproject.com/company/location 이라고 하였을 때
>
> 요청하는 주소가 실제 파일의 위치라기 보다 구분자로 보는것이다.
>
> 해당 웹사이트의 company/location 이라는 파일은 없다.
>
> (아마 company 클래스의 location 메소드를 호출할 것이다.)
>
> 이렇게 구분자(Identifier)로 보는 것이 URI 이다.

+ URL의 예시

> http:// myproject.com/company/sample.pdf
>
> myproject.com 서버에서 company/work 폴더안의 sample.pdf 를 요청하는 URL



+ URI의 예시

1. Rewrite 기술을 사용하여 만든 의미를 가진 식별자

> http:// myproject.com/company/location

2. REST Service (URL로 실행되는 서비스)

> http:// myproject.com/company/tv/turn/on

3. Web-Oriented Architecture (웹 기반의 구조 문법)

> kakaotalk://sendmsg?text=hello!  (이 uri는 kakaotalk 프로토콜을 해석할 수 있는 프로그램이 핸들링한다. 해당프로그램은 sendmsg 라는 식별자를 해석하고 동작한다.)
>
> facebookmsg://like?url=mysite.com (이 uri는 facebookmsg 프로토콜을 해석할 수 있는 프로그램이 핸들링한다. 해당프로그램은 like 라는 식별자를 해석하고 동작한다.)





> 참고
>
> https://javapapers.com/servlet/uri-and-url-difference/
>
> [https://ko.wikipedia.org/wiki/%ED%86%B5%ED%95%A9_%EC%9E%90%EC%9B%90_%EC%8B%9D%EB%B3%84%EC%9E%90](https://ko.wikipedia.org/wiki/통합_자원_식별자)