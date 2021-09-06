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
  
  
  ### filter
  웹 서버에서 was를 통해 servlet container에 접근하여 request를 처리해서 response를 받고 사용자에게 보여주게 된다. <br>
  이럴때 was에서 servlet container에 있는 servlet에 request를 주기전에 filter라는 것을 사용하여 원하는 형식으로 변경이 가능하다.(response도 가능)<Br>
  예를 들면 지금까지 한 한글 설정을 servlet마다 하는 것이아니고 filter로 설정해주면 모든 servlet에 한글 설정이 적용 되는 것이다. <br>
  class에서 chain을 사용하여 흐름을 제어할 수 있다. <br>
  일단 fliter class를 만들고 servlet과 비슷하게 web.xml 에 설정하면 사용이 가능하다. <br>
  @WebFilter()로 도 설정이 가능하다.
  
