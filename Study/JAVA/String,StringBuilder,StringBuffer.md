# String, StringBuilder, StringBuffer의 차이

- String은 새로운 값을 할당할 때 마다 새로 생성
- StringBuffer는 Memory에 append하는 방식으로 클래스를 직접 생성하지 않음
- 논리적으로 클래스가 생성될 때 method들과 variable도 같이 생성되는데, StringBuffer는 이런 시간을 사용하지 않음
- 십번 String이 더해지는 경우에는 각 String의 주소값이 stack에 쌓이고 클래스들은 Garbage Collector가 호출되기 전까지 heap에 지속적으로 쌓임
- String에서 저장되는 문자열은 알고보면 char의 배열형태로 저장되며 이 값들은 외부에서 접근할 수 없도록 private으로 보호된다. 또한 final형이기 때문에 초기값으로 주어진 String의 값은 불변으로 바뀔 수가 없게 되는 것
- StringBuilder는 변경가능한 문자열이지만 synchronization이 적용되지 않았다. 하지만 StringBuffer는 thread-safe라는 말에서처럼 변경가능하지만 multiple thread환경에서 안전한 클래스라고 함
- StringBuffer는 multi thread환경에서 다른 값을 변경하지 못하도록 하므로 web이나 소켓환경과 같이 비동기로 동작하는 경우가 많을 때는 StringBuffer를 사용하는 것이 안전



|              | String               | StringBuffer                | StringBuilder |
| ------------ | -------------------- | --------------------------- | ------------- |
| Storage Area | Constant String pool | Head                        | Heap          |
| Modifiable   | No (immutable)       | Yes (mutable)               | Yes (mutable) |
| Thread Safe  | YES                  | YES                         | No            |
| Performance  | Slow                 | Slow but faster than String | Fast          |



>  참고
>
> http://docs.oracle.com/javase/8/docs/api/
>
> http://javahungry.blogspot.com/2013/06/difference-between-string-stringbuilder.html
>
> https://novemberde.github.io/2017/04/15/String_0.html

