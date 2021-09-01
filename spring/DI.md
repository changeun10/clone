## DI(Dependency Injection)<br>

스프링의 가장 기본적인 기능은 객체를 생성해주고 조립해주는 것이라고 할 수 있다.<br>
물론 직접 생성하고 조립 할 수 있지만 스프링을 이용하면 좀더 편리하고 유동적으로 활용이 가능하다<br>
<br>
DI 는 한국말로 번역하면 의존성 주입이라고 할 수 있지만, 부품 조립이라고 생각하는것이 더 좋은것 같다.<br>
<br>
<img width="601" alt="clip20210901_1550_13_975" src="https://user-images.githubusercontent.com/77154341/131625493-bc2180c1-fb8b-4305-82ba-8eb15a103afe.png"><br>
왼쪽 같은 경우는 붙박이로 class A를 생성할 때 클래스 B를 생성하여 집어넣게 된다.(일체형) <br>
오른쪽 같은 경우는 class A를 생성하고 나중에 set Method를 통해 B에 대한 class를 집어 넣을 수 있다.(나중에 수정이 용이하다)<br>
오른쪽 같은 경우를 DI라고 부른다. 여기서 Dependency를 주입하는 방법은 생성 단계에서 주입할 수 있고 set Method를 이용하여 주입 할 수 있다. <br>
<Br>
원래 프로그래밍에서는 이러한 생성을 혼자 다하고 조립도 직접 다 해줬어야했다. 그러나 스프링 프레임워크를 사용하면 어떤 부품을 사용할지 설정해놓고 어디에 조립할지 명시해주면 스프링이 직접 조립을 다 해준다. <Br>
이것이 우리가 스프링을 사용하는 이유이다. <br>
이 때 필요한것은 container 가 필요한데 이 때 container를 IoC container라고 부른다. <br><br>
  
스프링에서 DI를 하기 위해서는 주입받기 위한 속성에 setter method 또는 필드생성자가 있어야 한다. ApplicationContext를 이용하여  IoC Container에서 Bean을 가져와 사용할 수 있다. <br>
주입을 할때 value값인지 ref(참조)값 둘다 주입 가능하다. <br>
collections도 생성이 가능하다(arrayList나 list같은 객체)<br>
  
### Annotation으로 설정
요즘은 xml보다는 annotation을 통해 DI를 한다. <br>
xml에서 하던 설정을 java class로 하는데 @Configuration이라는 annotation을 붙여준다. <br>
bean을 만들고자 하면 @Bean으로 해서 public method를 만들어 주고 원하는 객체를 return 해주면 된다. <br>
  Container에 해당하는 bean들을 만들면셔 @Autowired를 만나게 되면 component를 뒤져서 알맞은 bean을 주입시켜준다.<br>
그래서 bean을 container에 등록할때 @component라는 annotation을 달아줘야 한다. <br>
그리고 어디패키지에서 component를 읽어 올 것인지 @ComponentScan 설정을 해둬야한다. 
