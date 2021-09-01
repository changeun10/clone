## AOP(Aspect Oriented Programming)
<br>
보통은 프로그래밍을 하다보면 사용자의 입장에서 개발을 하게 된다. 그러나 테트트를 하거나 다른 업무를 할때에는<br>
개발자나, 운영자의 입장에서 필요한 부분이 있을수 있다. 이렇게 관점을 분리해서 개발을 진행하는 것을 AOP라고 한다.<br><br>
예를들면 로그처리,보안처리,트랜잭션처리 같은 것은 사용자에게는 필요없지만 개발자나 운영자한테는 필요한 기능이다. <br><br>
![image](https://user-images.githubusercontent.com/77154341/131673524-1947f1b3-5221-4f71-928a-90acf6642380.png)
<br>
노란부분은 우리가 원하는 로그나, 보안처리 부분이다. 모든 core 에서 해당 로직을 수행하고 싶은데 직접 넣게 되면 손이 많이 가게 된다. <br>
그래서 aop라는 방법이 나왔다. 그래서 proxy라는 것을 이용하여 평소에는 바로 core를 호출하고 특정 기능이 필요하면 proxy에서 method를 호출한다.<br><br>
spring으로 aop를 구현하게 되면 조금더 쉽게 구현이 가능하다.<br>
annotation 이나 xml파일에 본 기능을 하는 class, 연결을 해주는 proxy 그리고 개발자나 다른사람들이 원하는 부가적인 기능을 담고있는 class를 bean으로 등록해 두고 사용한다. <br>
proxy bean에다 본 기능 class와 부가적인 기능 class를 property로 설정해두면 된다. <br>
advice의 종류는 after returning,before, around trhowing가 있다. <br>

### pointcut
본 class에서 특정 메소드에만 aop를 적용할 때 사용하는 기능
