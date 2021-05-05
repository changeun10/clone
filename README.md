# 이곳은 제가 수행한 프로젝트를 복사해 두는 저장소입니다! + 나의 공부한것 저장

### HTTP
HTTP(Hypertext Transfer Protocol)이다. 한국어로 변역하자면 다른사람과 정보를 주고받기 위한 규약정도로 생각하면 좋을 것같다.<br>
사람들끼리도 말이 통해야 의사소통이 되듯이 컴퓨터도 일정 규약을 해놓고 그위에서 돌아가야지 우리의 요청을 알아들 수 있다.<br>
데이터는 인터넷상에서 서버와 클라이언트가 주고 받는다.
  
<h5>http 작동방식</h5>
서버와 클라이언트가 데이터를 주고받는데 클라이언트가 서버에게 데이터를 요청하고 서버가 데이터를 보내주면 서버는 그다음에 관심을 끊어버린다. 그렇기 때문에 서버는 그전에 어떤 요청이 오고갔는지 알 수 없다.<br>이렇게 연결을 끊으면 장점과 단점이 생긴다. <br>
장점은 연결을 끊기 때문에 보다 많은 컴퓨터들과 연결이 가능하다.<br>
그러나 이전 상태를 알지 못하기 때문에 정보를 유지하기 위해 Cookie 같은 기술이 나왔다.<br>
우리가 검색기록삭제에 들어가보면 쿠키 삭제를 볼 수 있는데 그때의 그 쿠키이다.<br>
<img src="https://gmlwjd9405.github.io/images/network/http-network-connect.png">
<h5>http method</h5>
클라이언트가 서버로 요청을 보낼때 어떤 요청을 할 것인지 method를 정해서 보내게 된다<br>
여기서 method의 종류는 get,put,post,push,options등이 있다.<br>
GET : 정보를 요청하기 위해서 사용한다. (SELECT)<br>
POST : 정보를 밀어넣기 위해서 사용한다. (INSERT)<br>
PUT : 정보를 업데이트하기 위해서 사용한다. (UPDATE)<br>
DELETE : 정보를 삭제하기 위해서 사용한다. (DELETE)<br>
HEAD : (HTTP)헤더 정보만 요청한다. 해당 자원이 존재하는지 혹은 서버에 문제가 없는지를 확인하기 위해서 사용한다.<br>
OPTIONS : 웹서버가 지원하는 메서드의 종류를 요청한다.<br>
TRACE : 클라이언트의 요청을 그대로 반환한다. 예컨데 echo 서비스로 서버 상태를 확인하기 위한 목적으로 주로 사용한다.<br>

#### HTTP(S)

그렇다면 HTTP에 S가 붙은 https는 뭘까?? 우리가 현재 사용하는 대부분의 페이지를 보면 http가 아닌 https로 시작하는 것을 볼 수 있다. S는 Secure을 의미한다. HTTP에서 보안이 강화 되었다고 보면 된다.<BR>
HTTPS는 소켓 통신에서 일반 텍스트를 이용하는 대신에 SSL이나 TLS 프로토콜을 통해 세션 데이터를 암호화한다.
<BR>

### How browers work
<img src="https://www.html5rocks.com/en/tutorials/internals/howbrowserswork/webkitflow.png">

 css을 파싱한 style rules 를 html을 파싱한 DOM TREE에 Attachment 를 시켜서 rendering Tree 를 만든다. 그다음 해석을 한다음에 사용자 모니터에 보여준다.

## WEB Server

웹 서버란?
웹 서버는 소프트웨어(Software)를 보통 말하지만, 보통은 웹 서버 소프트웨어가 동작하는 컴퓨터를 말한ㄷ
웹 서버의 가장 중요한 기능은 클라이언트(Client)(web brower)가 요청하는 HTML 문서나 각종 리소스(Resource)를 전달하는 것 (없거나 에러 발생시 에러메세지를 보낸다 ex.404)
웹 브라우저나 웹 크롤러가 요청하는 리소스는 컴퓨터에 저장된 정적(static)인 데이터이거나 동적인 결과가 될 수 있다.

웹 브라우저와 웹서버는 http 를 통해 통신을 한다. url이 http로 시작하는 이유

웹 서버 소프트웨어의 종류

가장 많이 사용하는 웹 서버는 Apache, Nginx, Microsoft IIS
Apache웹 서버는 Apache Software Foundation에서 개발한 웹서버로 오픈소스 소프트웨어(Open-source Software)이며, 거의 대부분 운영체제에서 설치 및 사용을 할 수 있다.
Nginx는 차세대 웹서버로 불리며 더 적은 자원으로 더 빠르게 데이터를 서비스하는 것을 목적으로 만들어진 서버이며 Apache웹 서버와 마찬가지로 오픈소스 소프트웨어이다.

### WAS(Web Application Server)

클라이언트/서버
클라이언트는 서비스를 서버에게 정보를 요청하여 응답을 받아 결과를 사용자에게 보여준다. 서버는 클라이언트로 부터 정보 요청을 받고 가지고 있는 정보를 보내준다. (ex. web brower - web server)

DBMS(database management system)
다수의 사용자가 데이터베이스 내의 데이터에 접근할 수 있도록 해주는 소프트웨어
보통 서버형태로 서비스를 제공한다.
클라이언트 프로그램이 한때 유행했는데 이러한 프로그램의 문제점은 업데이트가 되면 항상 모든 파일을 배포 해야한다는 문제점이 있었다. 클라이언트 프로그램이 커져서 클라이언트 컴퓨터에 무리가 되는 문제점도있다.<br>
보안이 나쁘다

미들웨어







<h3>Annotation</h3>
어노테이션은 JEE5(Java Platform, Enterprise Edition 5)부터 새롭게 추가된 요소이다.<br>
일단 어노테이션의 용도는 다양한 목적이 있지만 메타 데이터의 비중이 가장 크다 할 수 있다.<br>
<br>
메타-테이터(Meta-Data) : 데이터를 위한 데이터를 의미하며, 풀어 이야기하면 한 데이터에 대한 설명을 의미하는 데이터. (자신의 정보를 담고 있는 데이터)<br>
<br>
내가 가장먼저 본 annotation은 @Override 붙이는게 좋다고 하지만 안붙여도 오류가 나지 않으니 중요해 보이진 않았다.<br>
@Override<br>
선언한 메서드가 오버라이드 되었다는 것을 나타낸다.<br>
만약 상위(부모) 클래스(또는 인터페이스)에서 해당 메서드를 찾을 수 없다면 컴파일 에러를 발생 시킵니다.<br>
<br>
많이 사용되는 annotation을 적어보자면<br>
@Deprecated<br>
해당 메서드가 더 이상 사용되지 않음을 표시합니다.<br>
만약 사용할 경우 컴파일 경고를 발생 키십니다.<br>
<br>
@SuppressWarnings<br>
선언한 곳의 컴파일 경고를 무시하도록 합니다.<br>
<br>
@SafeVarargs<br>
Java7 부터 지원하며, 제너릭 같은 가변인자의 매개변수를 사용할 때의 경고를 무시합니다.<br>
<br>
@FunctionalInterface<br>
Java8 부터 지원하며, 함수형 인터페이스를 지정하는 어노테이션입니다.<br>
만약 메서드가 존재하지 않거나, 1개 이상의 메서드(default 메서드 제외)가 존재할 경우 컴파일 오류를 발생 시킵니다.<br>
<br>
어노테이션도 class처럼 선언이 가능하고 커스터마이징이 가능하다.<br>
<br>
웹을 개발하면서 어노테이션을 많이 사용했는데 annotation을 사용하니 확실히 코드가 깔끔해 졌다는 것을 알 수 있다.<br>
다음에 기회가 된다면 spring에서 많이 사용하는 annotation에 대해 공부해 정리해 보겠다.<br>
<br>
<h3>자바 스크립트 변수키워드</h3><br>
var은 함수 레벨 스코프이고 let,const는 블럭 레벨 스코프.(그렇기 때문에 전역변수로 선언하기 위해서는 블럭,함수 밖에서 변수를 선언해야한다)<br>
<br>
var은 선언되어있는 이름과 같은 이름으로 변수를 또 선언해도 괜찮지만 let,const는 같은 변수명으로 선언하면 오류가 난다.<br>(여러사람과 함께 작업할 때 안정성을 더할 수 있는 요소라고 생각합니다.)<br>
<br>
var,let은 변수 선언시 초기값을 주지 않아도 되지만 const는 초기값 선언이 필요하다.<br>
const에 선언된 값은 변경 불가능하다.(상수)<br>
<br>
var,let,const는 다 호이스팅 된다.<br>
var은 호이스팅 될 때 초기값이 선언 되지 않는다면 undefinded로 메모리를 할당하지만 let,const는 초기값을 할당하지 않는다. (const는 오류가난다)<br>
