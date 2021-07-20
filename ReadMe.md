### 이 프로젝트는 처음 스스로 만드는 게시판이다.<br>
사용 기술 : java Spring<br>
일단 back-end 기술 위주로 만들었고 프론트부분인 jsp는 아래 영상에서 가져와 그대로 사용하였다.(그래도 별로 안예쁘다.)<br>
출처: https://www.youtube.com/watch?v=RYqlq1F9Jb8&list=PLieE0qnqO2kTyzAlsvxzoulHVISvO8zA9&index=79

![image](https://user-images.githubusercontent.com/77154341/126333853-c0a632c6-2bb8-4fb9-ba04-691b27f19b98.png)
<br>
프로젝트 설계는 이렇게 된다.<br>
MVC패턴을 사용했고 service는 command로 구현했다.<br>
DB에 접근하는 것은 Spring-JDBC를 사용했다. <br>

지금 구현한 내용은 그냥 강의에 있는 부분만을 스스로 한 것이다.<br>
로그인 기능도 추가하고, 다음 강의에서 트랙잭션을 배우게 되면 돈 거래 웹도 만들어 보고싶다.
