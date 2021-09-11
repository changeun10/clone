## WAS (Web Application Server)
<br>
예전에는 client 쪽에서 server에게 정적인 페이지만 요구를 하였다.<Br>
그래서 web server 측에서 단순히 page를 받아와서 client에게 넘겨주면 됐다.<br>
그러나 인터넷이 발전하면서 자연스럽게 동적인 페이지도 요구하게 되었고 server쪽에서는 코드를 수행해서 db에서 자료를 가져와야 하는 기능이 생기게되었다.<Br>
  이러한 기능을 하는 것이 WAS 이다.<br>
  그래서 서버의 실행환경은 web server + WAS 이렇게 구성되게 된다. 그러나 요즘은 WAS에서 web server기능도 수행하고 있어 작은 웹페이지는 그냥 was로도 충분하다.<Br>
  <br>
  was의 종류에는 여러가지가 있다. 여기서는 tomcat을 사용하도록 하겠다. 
  <br>
  ## Servlet
  client가 원하는 기능을 서버측에서 수행할수 있도록 해주는 class라고 생각하면 된다.<br>
  모든 servlet은 HttpServlet에 상속받게 된다. was는 실행 하면서 HttpServlet을 상속받은 class들을 container에 집어넣고 나중에 사용한다. <br>
  원래 java application은 main()함수에 의해 실행이 된다. servlet(server application let)은 service()에 의해 실행이 된다. <br>
  웹페이지에 특정 문자를 보여주고싶다면 response객체에서 getWriter를 얻어서 사용하면된다. <br>
  <br>
  그리고 servlet은 server측에서만 직접 실행이 가능하게 하고 client는 직접 접근은 불가능 하도록 해야한다. <br>
  Web-inf 폴더 안에 넣게 되면 이런 기능이 가능한데, 그래서 client가 접근할 수 있는 mapping정보를 사용해서 그 기능을 수행한다.<Br>
  servlet mapping은 web.xml에 설정이 가능하지만 3.0 version부터는 annotation을 이용해서 mapping을 할 수 있다. 그 때 web.xml에서 metadata-complete="false"로 바꾼다<br>
  그리고 servlet에서 @WebServlet으로 mapping이 가능하다. <br>
  
  ### 출력 형식<br>
  서버가 브라우저에 컨텐츠 형식을 알려주지 않은 경우 브라우저가 자의적으로 해석한다. microsoft의 edge는 html로 chrome은 text로 해석한다.<br>
  그래서 edge에서는 println으로 출력해도 줄 바꿈이 안되고 chrome에서는 된다. (한글도깨짐)<br> 
  기본적으로 컴퓨터는 한바이트씩 정보를 보내는데 한글은 2바이트씩 정보를 주고받아야지 한글이 안깨진다. 그래서 utf-8을 사용한다 <br>
  이런것을 위해 콘텐츠 형식을 알려줘야한다. encoding도 설정해서 보내야다. 그리고 클라이언트에서도 utf-8로 읽어야 한다는 것을 알려줘야한다.(setContentType으로) 응답 header에 utf-8이라는 정보가 담겨간다. <br>
  
  ### Context
  웹을 개발하다보면 하나의 웹안에 여러가지 기능이 있을 수 있다. 네이버만 봐도 네이버 웹툰, 부동산, 쇼핑 등등이 있다. <br>
  그런데 같은 root 디렉토리에서 개발을 하다보면 다른팀이랑 부딫히는 일이 생긴다. 그래서 따로 개발을 하고싶을 수 있다. <br>
  그런데 같은 root에 파일이 없다면 나중에 실행할때 파일을 못찾는다. 그럴때는 context에서 path를 설정해주면된다.(web.xml에서 설정)<br>
  지금은 tomcat을 설치한곳에가서 server.xml 에서 설정을 해주면된다. ide에서는 좀더 쉽게 설정이 가능하다. 
  
  
  ### GET 요청
  client가 server에게 어떤 정보를 요구할 수 있다. 이 때 원하는 옵션을 담아서 요청 할 수 있다. (url에서 /ooo?kkk=3이런 식으로)<br>
  server는 servlet에서 request라는 객체에서 getparameter를 통해 인자를 받아서 원하는 요구사항을 수행 할 수 있다.(문자열로 받아진다.)<br>
  만약에 ?가 없거나 ?만 있다면 인자는 null로 받게 된다. <br>
  url이 아니라 사용자에게 직접 인자를 받기 위해서는 form 태그를 사용하면 된다.<br>
  여기서 중요한건 input 태그에 name과 server에서 받는 인자의 이름이 갇아야한다. 
  
  
  ### POST 요청
  GET요청과 비슷한 방식으로 수행이 되지만 조금더 많은 내용을 전달 할 수 있다. <BR>
  그리고 url에 전달한 인자가 안보인다. (rest API에서는 정보를 요청할때 get, 정보를 insert할때 post를 사용하도록 한다.)<br>
  이번에 만약에 get이나 post요청을 했을 때 response에서 한글이 깨진다면 response에서도 setEncoding을 통해 utf-8로 설정해줘야한다.)<br>
  입력 데이터는 배열로도 보내고 받을 수 있다.<br>
  input tag에서 name값을 같이 설정 해준 입력값들은 servlet에서 getparamterValues를 통해 string배열로 받아 올 수 있고 배열 사용하여 로직을 수행 할 수 있다. 
  <br><br>
 
  submit button을 두개 만들 경우에는 name을 설정해주면 submit tag에 있는 value도 "name"="value" 이런식으로 인자로 넘어가서 servlet에서 어떤 버튼을 눌렀는지 알 수 있다.<br> 
  
  
  ### filter
  웹 서버에서 was를 통해 servlet container에 접근하여 request를 처리해서 response를 받고 사용자에게 보여주게 된다. <br>
  이럴때 was에서 servlet container에 있는 servlet에 request를 주기전에 filter라는 것을 사용하여 원하는 형식으로 변경이 가능하다.(response도 가능)<Br>
  예를 들면 지금까지 한 한글 설정을 servlet마다 하는 것이아니고 filter로 설정해주면 모든 servlet에 한글 설정이 적용 되는 것이다. <br>
  class에서 chain을 사용하여 흐름을 제어할 수 있다. <br>
  일단 fliter class를 만들고 servlet과 비슷하게 web.xml 에 설정하면 사용이 가능하다. <br>
  @WebFilter()로 도 설정이 가능하다.
  
  
  ###Scope
  원래 servlet은 실행 하고 나면 그때 사용했던 변수를 따로 저장하지 않는다. 만약에 다음에 사용하고 싶다면 특정 scope에 저장해야하는데 그 중 가장 광범위하게 저장하는 것이 application(servlet context)이다.<br>
  여기에 저장된 값은 application이 실행 되고 있다면 계속 저장이 되어있다.(was가 종료하기 전까지) setAttribute로 저장할 수 있고 getAttribute로 값을 받을 수 있다. 
  <Br><BR>
  
  비슷한 기능을 하는 session 객체가 있다. session 객체는 application 객체와 비슷하게 저장하고 저장한 값을 가져와서 사용 할 수 있도록 한다. <br>
  그러나 범위가 다르다. application은 누구든지 그 application을 사용하는 사람 전부에게 영향을 주지만 session은 그 특정 사용자에게만 주는 공간이다. <br><br>
  그럼 server측에서 session을 어떻게 구별할까?<br>
  처음에 client에서 server에 접근을 시도하면 was에서 처음보는 client이면 session객체를 사용 못하게 하고 application객체만 사용 가능하도록 한다.<br>
  그러고 client가 접속을 해제할때 WAS에서 SID를 만들어서 client에게 부여한다.<br>
  다음에 client가 접속을 하게 되면 SID를 들고 접속을 하고 was에서는 session구별이 된다. <br>
  session 객체와 비슷하게 cookie를 사용할 수 있다. session과 다른점은 cookie는 client쪽에서 저장되고 request를 할때 들고 오는 것이다. <br>
  cookie의 path를 설정하면 어떤 url로 요청할때 들고 갈 것인지 설정 해 줄 수 있다.<br>
  MaxAge를 설정하게 되면 브라우저가 닫히면 디스크에 쿠키를 저장하게 된다.그래서 나중에도 사용 할 수 있도록 해준다.(설정 안하면 브라우저가 꺼지면 쿠키 사라짐)<br>  
    
    
    ### redirect
    servlet에서 특정 기능을 수행하고 백지가 나오지 않고 원하는 페이지로 보내는 방법이다. <br><br>
    
    ###동적페이지
    servlet으로 동적 페이지를 만들 수 있는데 너무 귀찮다...한줄한줄 html 태그를 작성해줘야한다. 그래서 이제 jsp를 사용하게된다<br>
    
    #### JSP
    html 폼과 비슷하게 생겼다. 사용자가 jsp를 요구할때 servlet으로 바꾼다.(파일명_jsp.java)<br> 그리고 servlet으로 해석해서 사용자에게 보여준다.<br>
    jsp안에 java코드를 넣고싶다면 코드블록을 사용해야한다. (<% %>,<%= %>,<%! %>,<%@ %> 같은것들) <br>
    jsp 내장 객체는 사용자가 따로 선언하면 오류가 발생한다. 미리 선언이 되어있기 때문에 jsp에서 사용가능하다. <Br>
    
    
    
    ### JSP MVC model1
    코드블록만 사용해서 jsp를 만들게 되면 출력부분에 선언문이랑 다 섞여서 들어가게 된다.<Br>
    굉장히 보기싫은 코드가 된다. 이것을 해결하기 위해 model1방식이 나왔다. 입력과 출력을 나눠서 코드를 작성한다.<br>
    입력 부분에서 선언한 변수를 출력부분에서 출력을 한다. 이렇게 되면 나중에 수정하기도 편해진다. <br>
    
    ### JSP MVC model2
    model1 보다 유지보수가 쉽고 코드가 보기 쉬워지기 위해 model2를 도입한다. model2는 1과 다르게 view와 controller가 분리되어있다.<br>
    view 와 controller사이에 정보를 주고받기 위해 dispatcher를 사용한다. <br>
    다음 페이지에서도 작업을 이어가기 위해 forward를 통해 (request,response)를 넘겨준다. <br>
    
    ### el표기법
    view 에서 자바 코드 같은 부분을 최대한 빼기위한 기능이다. controller에서 view로 넘겨준 데이터를 그냥 ${}으로 사용하면 출력이 된다.<br>
    list,map도 쉽게 출력 할 수 있다. page,request,session,application 객체에 담겨있는 값도 출력 가능하다. (page가 가장 우선순위)<br>
    특정 위치에서 뽑고 싶다면 ___Scope.0000 을 사용하면 된다.<br>
    el 연산자도 있다. ${} 중괄호 안에 > == <,empty,not 등 연산자 사용 가능하다.<br>
    
    
    ### tag library
    JSTL(jsp standard tag library)<br>
    프로그래밍 언어처럼 반복문도 사용할 수 있고, if문도 사용 가능해진다.<br>
    날짜를 원하는 방식으로 출력하기 위해 format tag를 사용할 수 있다.(숫자 foramtting도 가능)<Br>
    
    
    
   
    
    
    
    
