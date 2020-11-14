# TCP vs UDP

TCP는 Transmission Control Protocol의 약자이고, UDP는 User Datagram Protocol의 약자이다. 두 프로토콜은 모두 패킷을 한 컴퓨터에서 다른 컴퓨터로 전달해주는 `IP 프로토콜`을 기반으로 구현되어 있지만, 서로 다른 특징을 가지고 있다.



**신뢰성이 요구되는 애플리케이션에서는 TCP를 사용**하고 **간단한 데이터를 빠른 속도로 전송하고자 하는 애플리케이션에서는 UDP를 사용**한다.



| TCP                                                          | UDP                                                          |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| Connection-oriented protocol<br/>(연결지향형 프로토콜)       | Connection-less protocol<br/>(비 연결지향형 프로토콜)        |
| Connection by **byte** stream<br/>(바이트 스트림을 통한 연결) | Connection by **message** stream<br/>(메세지 스트림을 통한 연결) |
| Congestion / Flow control<br/>(혼잡제어, 흐름제어)           | NO Congestion / Flow control<br/>(혼잡제어와 흐름제어 지원 X) |
| Ordered, Lower speed<br/>(순서 보장, 상대적으로 느림)        | Not ordered, Higer speed<br/>(순서 보장되지 않음, 상대적으로 빠름) |
| Reliable data transmission<br/>(신뢰성 있는 데이터 전송 - 안정적) | Unreliable data transmission<br/>(데이터 전송 보장 X)        |
| TCP packet : Segment<br/>(세그먼트 TCP 패킷)                 | UDP packet : Datagram<br/>(데이터그램 UDP 패킷)              |
| HTTP, Email, File transfer<br/>에서 사용                     | DNS, Broadcasting<br/>(도메인, 실시간 동영상 서비스에서 사용) |



#### TCP의 특징

연결형 서비스

- 연결형 서비스로 가상 회선 방식을 제공한다.

- 3-way handshaking 과정을 통해 연결을 설정

- 4-way handshaking 을 통해 연결을 해제

흐름제어(Flow control)

- 데이터 처리 속도를 조절하여 수신자의 버퍼 오버플로우를 방지

- 송신하는 곳에서 감당이 안되게 많은 데이터를 빠르게 보내 수신하는 곳에서 문제가 일어나는 것을 막는다.

- 수신자가 윈도우크기(Window Size) 값을 통해 수신량을 정할 수 있다.

혼잡제어(Congestion control)

- 네트워크 내의 패킷 수가 넘치게 증가하지 않도록 방지

- 정보의 소통량이 과다하면 패킷을 조금만 전송하여 혼잡 붕괴 현상이 일어나는 것을 막는다.

신뢰성이 높은 전송(Reliable transmission)

- Dupack-based retransmission

  > 정상적인 상황에서는 ACK 값이 연속적으로 전송되어야 한다.
  >
  >  그러나 ACK값이 중복으로 올 경우 패킷 이상을 감지하고 재전송을 요청한다.

- Timeout-based retransmission

  > 일정시간동안 ACK 값이 수신을 못할 경우 재전송을 요청한다.

전이중, 점대점 방식

- 전이중 (Full-Duplex)

전송이 양방향으로 동시에 일어날 수 있다.

- 점대점 (Point to Point)

각 연결이 정확히 2개의 종단점을 가지고 있다.



스트림 전송으로 전송 데이터의 크기가 무제한



=> 멀티캐스팅이나 브로드캐스팅을 지원하지 않는다.



#### UDP의 특징

- 비연결형 서비스로 데이터그램 방식을 제공한다

- 정보를 주고 받을 때 정보를 보내거나 받는다는 신호절차를 거치지 않는다.

- UDP헤더의 CheckSum 필드를 통해 최소한의 오류만 검출한다.

- 신뢰성이 낮다

- TCP보다 속도가 빠르다





> 참고
>
> https://mangkyu.tistory.com/15
>
> https://www.slideshare.net/bluem31/tcp-47441568?qid=04ddad59-7ebb-4557-99d7-50435e9a5f92&v=&b=&from_search=5
>
> https://madplay.github.io/post/network-tcp-udp-tcpip
>
> https://m.blog.naver.com/PostView.nhn?blogId=ksg7514&logNo=220772997742&proxyReferer=https:%2F%2Fwww.google.com%2F
>
> https://gmlwjd9405.github.io/2018/09/19/tcp-connection.html
>
> https://velog.io/@hidaehyunlee/TCP-%EC%99%80-UDP-%EC%9D%98-%EC%B0%A8%EC%9D%B4

