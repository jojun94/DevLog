# 객체지향설계의 5대 원칙

#### SOLID 원칙

> 프트웨어 작업에서 프로그래머가 [소스 코드](https://ko.wikipedia.org/wiki/소스_코드)가 읽기 쉽고 확장하기 쉽게 될 때까지 소프트웨어 소스 코드를 [리팩터링](https://ko.wikipedia.org/wiki/리팩터링)하여 [코드 냄새](https://ko.wikipedia.org/wiki/코드_냄새)를 제거하기 위해 적용할 수 있는 지침



- S (SRP)

> 단일 책임 원칙 (Single responsibility principle)
>
> 한 클래스는 하나의 책임만 가져야 한다.

- O (OCP)

> 개방-폐쇄 원칙 (Open/closed principle)
>
> 소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어야 한다.

- L (LSP)

> 리스코프 치환 원칙 (Liskov substitution principle)
>
> 프로그램의 객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀수 있어야 한다.

- I (ISP)

> 인터페이스 분리 원칙 (Interface segregation principle)
>
> 특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 하나보다 낫다.

- D (DIP)

> 의존관계 역전 원칙 (Dependency inversion principle)
>
> 프로그래머는 추상화에 의존해야지 구체화에 의존하면 안된다.