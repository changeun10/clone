## 이상형 월드컵을 웹 프로그래밍으로 만들어봤다.<br>
사용된 기술: mybatis, java Spring<br>
7/27<br>
처음으로 바닥부터 설계해서 만든 웹 프로그래밍이라 로직이 조금 조잡할 수 있다.<br>
백앤드만 설계해서 ui/ux는 좋지 않다. <br>
처음 페이지는 <br>
![image](https://user-images.githubusercontent.com/77154341/127112012-cec17f86-2bea-4437-82aa-03c499df9818.png)<br>
여기서 원하는 월드컵 주제와 몇강으로 시작할지 선택할 수 있다.(8강,16강)<br>
pathVariable로는 무엇을 선택했는지 title, parameter로는 몇강을 선택했는지 round가 get방식으로 넘어간다<br>
<br>
<br>
![image](https://user-images.githubusercontent.com/77154341/127111957-6ffc1b39-a9f1-463f-8e83-99233860ba5f.png)<br>
선택지 중에 자신이 원하는 것을 선택하면 토너먼트로 다음 강으로 넘어가게 된다.service layer에서 작업을 진행한다.<br> 8강이 끝나면 4강 그다음엔 결승 그리고 우승이 정해진다<br><br><br>
![image](https://user-images.githubusercontent.com/77154341/127112182-d32edea4-0c49-4a12-9150-1722b3ab7758.png)<br>
여기서 통계보기를 선택하면 어떤 선택지가 얼마나 우승했는지 볼수 있다.<br>
우승횟수로 내림차순 정리를 했다.<br>
![image](https://user-images.githubusercontent.com/77154341/127112305-a4960e3b-014b-4394-a99b-dce40c463542.png)<br>
상단에 home을 누르면 첫 페이지로 돌아가게 된다.<br>

7/28<br>
오늘은 이상형 월드컵에 게시판 기능을 추가하였다.<br>
![image](https://user-images.githubusercontent.com/77154341/127324412-3ae8ffe1-fc0a-484c-83ba-53c80a8ca5b1.png)<br>
여기에 게시판을 누르면 게시판으로 이동한다. 이때 parameter로는 title(어느 월드컵이 진행중인지), name(내가 1등으로 뽑은 것)이 넘어가게 된다.<br>
![image](https://user-images.githubusercontent.com/77154341/127324682-0f6f45c2-92db-4fbe-a585-508dfd34084b.png)<br>여
내용에 내가 원하는 글을 작성하게 되면 db에 내가 뽑은 1등과 함께 저장이 된다.
그리고 아래는 지금까지 작성한 댓글들을 볼 수 있다. 홈으로는 맨처음 페이지로 넘어가게 된다.<br><br>
오늘의 고민: model에서 attribute 하는것은 service layer에서 하는게 맞을까 controller에서 하는게 맞을까??<br>
아직 문제점 : 새로고침을 하게 되면 url이 유지 되어 get방식으로 가는 데이터가 2번 넘아가게 되어 다음 대진에 영향을 준다...빨리 고쳐보자<br>
그리고 좀 꾸며보고 싶은데 일단은 기능을 구현해 놓고 react도 공부해서 프론트 앤드도 만들어 봐야겠다.<br>
다시하기 기능을 만들어도 괜찮을것 같다.

7/29<br>
원래는 월드컵 하나당 하나씩 form태그로 만들었는데 db에서 category라는 table을 만들어서 목록들을 가져와서 목록에 있는것을 화면에 보여주는 방식으로 수정하였다.<BR>
![image](https://user-images.githubusercontent.com/77154341/127507271-0b1332b1-ad2d-4613-ad7a-f65d3369166c.png)<BR>
 인기순을 누르면 사람들이 많이 진행한 순서대로 정렬을 해주고 최신순으로 하면 최근에 올라온 월드컵 순서로 보여주게 된다.<BR>
 썸네일 사진도 하나 넣어 봤다.<BR><BR>
  ![image](https://user-images.githubusercontent.com/77154341/127507809-4b6a0f41-e50d-443c-85bb-8de6a10f0dfd.png)
<BR>
  게시판도 조금 수정했다. DB에 작성자 칼럼도 추가했다. 그리고 내가뽑은 1등이 무엇인지 알 수 있도록 했다.<BR>
  지금 보니 작성자가 맨 왼쪽 그다음 내가뽑은1등 그리고 내용, 작성날짜 이렇게 나오는게 보기 좋을것 같다. (수정요망)<BR>
계속 확장하다보니 왜 처음에 설계를 잘해야 한다고 하는지 알것 같다. DB도 꼬이고 생각날때마다 설계를 하다보니 DB사이의 관계도 허술해 졌다. <BR>
  그리고 API도 잘 지키지 못하게 되는것 같다. 내일은 일반인들도 월드컵을 만들 수 있는 기능을 한번 구현해 봐야겠다!!
  
