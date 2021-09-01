## IoC Container (Inversion of Control Conatiner) <br>
(여기서 부품들은 class이다)<br><br>
우리가 annotation이나 xml을 사용해서 우리가 필요한 부품(bean)들을 만들어주면 스프링에서는 컨테이너를 하나 만들어서 그 부품들을 저장한다.<br>
그리고 우리가 조립을 원하게 되면 부품을 불러와서 조립을 해준다. 그 부품 보관장소를 IoC Container라고 부른다.(조립까지 해서 담겨있을수 있다. <br>
<br>
근데 왜 bean container라고 안부르고 IoC Container라고 부를까?<br>
만든 사람이 IoC라는 말을 강조하고 싶었나보다... 일단 IoC(Inversion of Control)는 우리가 부품을 생성하고 조립하는 과정과 반대라는 의미이다.<br>
원래는 큰부품을 만들면서 자연스럽게 하위 부품들이 생성되는 구조인데 IoC Container같은 경우는 작은 부품을 먼저 만들고 위에 있는 부품에 주입을 하게 된다.<Br>
여기서 보면 Control의 역전이 일어났다 해서 IoC Container라고 부른다. <br><br>
![image](https://user-images.githubusercontent.com/77154341/131627653-61e85ebe-c4e9-4e20-b95d-43710551a005.png)<br>
(위에는 일체형으로 만든 일반적인 class이고 아래는 DI를 통해 만든 class이다.) 
