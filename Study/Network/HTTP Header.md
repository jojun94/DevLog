# About HTTP Header /

- HTTP Header에 쓰이는 Content-Type이란 무엇일까?

Request에 실어 보내는 데이터(Body)의 type의 정보를 표현한다.



> Text타입으로는 text/css, text/javascript, text/html, text/plain등이 있다.
>
> File을 실어보내기 위한 타입으로는 multipart/formed-data가 있다.
>
> 그리고 Application 타입으로 application/json, application/x-www-form-urlencode가 있다.



> Detail
>
> ```
> Content-Type := type "/" subtype *[";" parameter] 
> 
> type :=          "application"     / "audio" 
>           / "image"           / "message" 
>           / "multipart"  / "text" 
>           / "video"           / x-token 
> 
> x-token := <The two characters "X-" followed, with no 
>            intervening white space, by any token> 
> 
> subtype := token 
> 
> parameter := attribute "=" value 
> 
> attribute := token 
> 
> value := token / quoted-string 
> 
> token := 1*<any CHAR except SPACE, CTLs, or tspecials> 
> 
> tspecials :=  "(" / ")" / "<" / ">" / "@"  ; Must be in 
>            /  "," / ";" / ":" / "\" / <">  ; quoted-string, 
>            /  "/" / "[" / "]" / "?" / "."  ; to use within 
>            /  "="                        ; parameter values
> ```



> 참고
>
> https://www.w3.org/Protocols/
>
> https://gist.github.com/jays1204