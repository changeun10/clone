# Application layer<br>

###  Client - server architecture<br>
Server:<br>
always - on host<br>
permanent IP address<br>
data centers for scaling<br>

Clients:<br>
communicate with server<br>
do not communciate directly with each other<br>
may be intermittently connected<br>
may have dynamic IP addresses<br>

### P2P architecture (서버 없이 컴퓨들 끼리 communicate)<br>
no always-on server<br>
arbitary end systems directily communicate<br>
모든 컴퓨터 들은 서버이면서 클라이언트가 된다.<br>
self scalability<br>
complex management<br>

### Processes communicating<br>
결국 통신하는 주체는 각 컴퓨터안에서 돌아가고 있는 processes 이다. <br>
같은 호스트 내에서는 inter-process communicatin을 통해 서로 communicate를 하고<br>
다른 호스트에 있는 process와 communicate를 하기위해 messages를 교환하면서 communicate를 한다. <br>
<br>
client process와 server process로 나뉜다.<br>
client process는 server process에게 요청을 보내 communication을 initiates한다.<br>
server process는 contacted할려는 message를 기다린다. <br>


### Sockets<br>
![hqdefault](https://user-images.githubusercontent.com/77154341/118397745-80f4ba00-b690-11eb-933c-50aaba4a56dd.jpg)<br>
여기서 process에서 만들어진 message는 socket을 통해 보내지고 받게된다. 문같은 역할인것이다.<br>
message를 전달할때에는 보통 다른 host로 보내기 때문에 그 host의 주소인 IP가 필요하다<br>
더군다나 message의 종착지는 process이기 때문에 그 host에서 process가 위치하고 있는 port number도 필요하다.<br>
보통 HTTP server은 port # 80 , mail server는 25이다.<br>

### What transport service does an app need?<br>
app마다 중요시 여기는 부분이 다를 것이다. 예를 들면 속도를 중요시 하는 어플리케이션도 있을것이고<br>
정확성을 중요시하는 app도 있을 것이다. <br>
#### data integrity<br>
file transfer,web transactions, email 같은 경우는 integrity가 중요하다. 그러나 비디오나 오디오 같은경우에는 some loss에 tolerate 하다.<br>
#### timing<br>
속도를 중요시하는 app도 있다. 게임같은 경우가 대표적이다<br>
#### throughput<br>
일정 시간동안 들어오는 데이터의 양을 중요시 하는 app도 있다.<br>
multimedia 같은 app경우 그렇다. 그러나 email이나 다른 어플들은 elastic apps라고해서 throughput을 별로 중요시 하지 않는다. <br>
![fff](https://user-images.githubusercontent.com/77154341/118397986-96b6af00-b691-11eb-8002-645239d022ab.png)<br>

### TCP vs UDP<br>
![img](https://user-images.githubusercontent.com/77154341/118398292-ea75c800-b692-11eb-80de-a2b8b3276da1.png)<br>
TCP 는 reliable transport 이다. UDP는 unreliable data transfer<br>
간단하게 말해서 천천히 가도 정확히 가고싶다면 tcp 아니라면 udp를 사용하는것이 좋다.<br>
tcp는 flow control도 가능하다. buffer에 많이 쌓여있다면 더이상 message를 보내지 않는다. <br>
그러나 이러한 flow control이 문제가 될 경우도 있다. throughput을 중요하시하는 app같은 경우에는 계속 message가 와야하는데 flow control때문에 막힐 경우도 있다.<br>
이러한 경우에는 udp를 사용하기도 한다. <br>
그러나 udp,tcp모두 timing security나 throughput 를 보장하지는 않는다. <br>![캡처](https://user-images.githubusercontent.com/77154341/118399290-7984df00-b697-11eb-9c72-02ee4de20ca0.PNG)


### Web and HTTP<br>
web page는 objects로 구성된다.<br>
objects에는 여러가지 종류가 있는데 html file, jpeg image, java applet, audio file등이 있다.<br>
뼈대가 되는 base HTML-file이 있다. 각각의 object는 url 을 가지고 있다. <br>
#### HTTP overview<br>
HTTP : hypertext transfer protocol<br>
client가 server에게 request를 보낸다 그럼 server는 client에게 response를 보내준다. <br>
이때 message를 보내는 규약을 http를 지킨다고 생각하면 된다. <br>
TCP를 사용한다. (integreity가 중요)<br>
stateless이다.(response를 보내면 server는 connection을 끊는다)<br>
그래서 10개의 object를 받을려면 10번의 연결이 필요하게된다(되게 비효율적)<br>

### Persistent http vs NON-Persistent http<br>
앞에서 소개한 non-persistent http같은 경우 10개의 object를 받기위해서는 10번의 연결을 해야한다.<br>
하나의 message가 왔다갔다 하는 시간을 1 RTT라고 한다면 5개의 object를 받기위해서는 처음 연결을 위한 <br>
1RTT, 첫 message를 위해 1RTT 그다음에 5개가 필요하다는 것을 알 수 있다. 그럼 이제 2RTT만큼 5번을 반복해야한다<br>
총 12RTT가 필요한 셈이다. 매우 비효율적임을 알 수 있다.<br>
여기서 개선된 기능을 하는 연결이 parallel tcp connection이다. 처음 연결을 하고 나서 몇개의 object가 필요한지 파악한다음 한번 연결한뒤 한번에 모든 object에 대한 요구를 한다. 그렇게 되면 계속 연결을 맺었다 끊었다 할필요가 없기 때문에 속도에 향상을 기대할 수 있다. <br>
그러나 이렇게 하면 하나의 process에 여러개의 socket을 만들어야 하고 그렇게 되면 메모리에 부하가 걸리게된다. <br>
<br>
persistent http같은 경우 connection을 끊지 않는다. 그래서 매번 object를 위해 새로운 connect을 맺을필요가 없다. 앞선 예시에서 5개의 object가 필요한 경우 처음 connection을 위한 1RTT , 첫 message를 위해 1RTT<br>
5개의 object하나당 1RTT만 필요하다 NON CONNECTION과 비교해보면 거의 1/2수준임을 알 수 있다.<br>

### HTTP request message<br>
http request message에는 무슨 내용이 들어있을까?<br>
![ga](https://user-images.githubusercontent.com/77154341/118403011-6bd75580-b6a7-11eb-8c41-fed9933c876c.PNG)<br>
method에는 get,post 등이 들어갈 수 있다.<br>
get method같은 경우 단순 데이터를 조회할때 사용한다 그리고 parameter을 url 에 ?뒤에 넣어서 보낸다<br>
post method같은 경우 entity body 에 parameter를 넣어 message를 전송한다.보통 input값에 따라 데이터를 조회할때 사용한다 <br>
![gdg](https://user-images.githubusercontent.com/77154341/118403109-d5effa80-b6a7-11eb-9758-bf3e4276cf89.PNG)<br>
response message는 이렇게 생겼고 status codes는 여러가지가있다 보통 200번대는 성공을 말하고 400번대는 잘못된 연결을 말한다 <br>
200 OK<br>
301 Moved permanently<br>
400 bad request<br>
404 not found<br>
505 http version not supported





