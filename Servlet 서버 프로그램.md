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
  Web-inf 폴더 안에 넣게 되면 이런 기능이 가능한데, 그래서 client가 접근할 수 있는 mapping정보를 사용해서 그 기능을 수행한다.
  
  
  
  ### Context
  웹을 개발하다보면 하나의 웹안에 여러가지 기능이 있을 수 있다. 네이버만 봐도 네이버 웹툰, 부동산, 쇼핑 등등이 있다. <br>
  그런데 같은 root 디렉토리에서 개발을 하다보면 다른팀이랑 부딫히는 일이 생긴다. 그래서 따로 개발을 하고싶을 수 있다. <br>
  그런데 같은 root에 파일이 없다면 나중에 실행할때 파일을 못찾는다. 그럴때는 context에서 path를 설정해주면된다.(web.xml에서 설정)<br>
  지금은 tomcat을 설치한곳에가서 server.xml 에서 설정을 해주면된다. ide에서는 좀더 쉽게 설정이 가능하다. 
