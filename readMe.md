## 이상형 월드컵을 웹 프로그래밍으로 만들어봤다.<br>
사용된 기술: mybatis, java Spring<br>
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

