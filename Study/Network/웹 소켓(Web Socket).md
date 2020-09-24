# Web Socket 이란?

**Web Socket이란?**

WebSocket은 **Transport protocol로서, 웹에서 사용하는 Socket**.

HTTP는 클라이언트와 서버는 연결을 유지하지 않는 Connectionless 특징이 있다.

Socket은 클라이언트와 서버가 연결을 유지하는 특성을 갖는데, WebSocket을 사용함으로써 웹에서 양방향 실시간 통신이 가능해진다.



**WebSocket 프로토콜**

WebSocket은 RFC6445 표준이며, WebSocket을 사용하기 위해서는 ws 프로토콜을 사용.



웹은 HTTP 프로토콜을 사용하는데, WS 프로토콜을 사용하기 위해서는 어떤 과정을 거칠까?

HTTP에서 WebSocket으로의 프토토콜 전환을 **WebSocket HandShake**라고 한다.



브라우저는 프로토콜을 HTTP에서 Websocket으로 전환하려는 요청을 Header에 Upgrade 속성을 추가하여 서버로 보낸다.

이 요청을 받은 서버가 WebSocket 프로토콜을 이해하면, Upgrade 속성을 통해 프로토콜 전환을 동의하게 되고,

그러면 브라우저와 서버는 ws 프로토콜을 사용하게 된다.

[![img](https://postfiles.pstatic.net/MjAxOTA4MDhfMTMg/MDAxNTY1MjQ5MTQzMjUw.EvWpNAiKFYTNp7yqzSpwXmCAtN2NZn0hKF1lw2C5HIAg._r7k0YzIApvSPt6QN0Xv4KcsmRvqaNXiBhbHKYwbaO0g.PNG.junhyoung75/1.PNG?type=w966)](https://blog.naver.com/PostView.nhn?blogId=junhyoung75&logNo=221609916855&categoryNo=0&parentCategoryNo=0&viewDate=&currentPage=3&postListTopCurrentPage=&from=postList&userTopListOpen=true&userTopListCount=5&userTopListManageOpen=false&userTopListCurrentPage=3#)

ws 프로콜로 전환되면, HTTP 연결은 중단되며 동일한 TCP / IP 연결을 통해 WebSocket 연결로 대체 한다.

WebSocket 연결은 기본적으로 HTTP( 80 ), HTTPS ( 443 )와 동일한 포트를 사용.

즉 CORS 적용이나 인증 등의 과정을 기존 HTTP 방식으로 사용할 수 있는 장점이 있다.



**WebSocket 특징**

**1) 양방향 통신**

WebSocket은 클라이언트와 서버는 지속적으로 연결된 TCP 라인을 통해 양뱡향 통신을 한다.

처음 WebSocket을 사용할 때 Ajax와 비슷한 느낌을 받았는데, 가장 큰 차이점은 **서버에서 클라이언트로 요청을 보낼 수 있다**는 것.

즉 Ajax는 클라이언트에서 서버로밖에 요청을 못하는 단방향 통신인 반면,

WebSoket은 어느 쪽에서든 요청을 보낼 수 있는 양방향 통신.



**2) 실시간 통신 / 성능**

WebSocket은 클라이언트와 서버가 연결되어 있기 때문에 실시간 통신이 가능.

그래서 실시간 채팅, 주식 등 실시간 정보가 필요한 서비스에서 주로 활용되곤 한다.



어느 논문( [**링크**](http://www.sersc.org/journals/AJMAHS/vol7_no8_2017/39.pdf) )에 따르면 WebSocket이 Ajax 통신보다 적게는 5배 많게는 10배 정도의 좋은 성능을 보인다고 한다.



**3) Cross Browser 문제**

Web Socket은 구 버전 브라우저 ( IE 8 이하 )에서는 지원이 불가능하다는 단점이 있다.

[![img](https://postfiles.pstatic.net/MjAxOTA4MDhfMTQ4/MDAxNTY1MjQ5MTM1NDEy.yHU0W1AX7yWlUIUtW_GKWTm7hAKFFCs4pyqEEoD-Y8gg.mTAdehzVydp15zxOV_FztTlG0yk-IR_APdsN7Xu7P8Ug.PNG.junhyoung75/2.png?type=w966)](https://blog.naver.com/PostView.nhn?blogId=junhyoung75&logNo=221609916855&categoryNo=0&parentCategoryNo=0&viewDate=&currentPage=3&postListTopCurrentPage=&from=postList&userTopListOpen=true&userTopListCount=5&userTopListManageOpen=false&userTopListCurrentPage=3#)

**4) Stateful**

WebSocket은 HTTP와 달리 상태를 유지( Stateful )하기 때문에 서버와 클라이언트는 연결을 항상 유지해야 한다.

따라서 부하가 발생할 수 있다는 단점이 있고, 비정상적으로 연결이 끊어졌을 때 적절하게 대응할 수 있어야 한다.



> 참고
>
> http://www.sersc.org/journals/AJMAHS/vol7_no8_2017/39.pdf
>
> http://www.websocket.org/aboutwebsocket.html
>
> 
>
> https://victorydntmd.tistory.com/250





WebSocket은 클라이언트와 서버가 실시간 양방향 통신을 하는 프로토콜입니다.

WebSocket은 실시간 양방향 데이터 통신이 필요한 경우, 많은 수의 동시 접속자를 수용해야 하는 경우, 브라우저에서 TCP 기반의 통신으로 확장해야 하는 경우 등의 상황에서 사용하면 좋다.



> 마치며 
>
> WebSocket은 클라이언트와 서버가 실시간 양방향 통신을 하는 프로토콜.
>
> 다수의 접속개체를 웹으로 수용하고 싶은 경우, 서버에서 브라우저에 요청을 보낼 경우, 브라우저에서 TCP 통신으로 확장할 경우에 고려하게될 프로토콜.
>
> 실제 업무 중  현장단말기들 - 서버의 시스템을 웹으로 변환 하는 프로젝트를 했을 때 브라우저로 소켓통신을 할 수 있다는 것에 흥미가 생겨서 자료들을 발췌하여 종합, 정리 함.

