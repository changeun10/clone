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


## User-server state: cookies
일단 http 프로토콜은 stateless이다 그렇기 때문에 object를 주고 받은 다음에는 그 connection이 유지되 지않는다.<br>
그러면 자연스럽게 여러가지 불편한 점이 생기게 된다. 이를 보완하기 위해 나온 기술이 cookie<br>
처음 client가 server에 접속하게 되면 server은 그 client를 위한 쿠키를 하나 만든다.<br>
그리고 server에서는 client에 대한 data를 database에 저장을 하고 response message에 cookie정보를 넣어 client에게 보낸다. <br>
그리고 다음에 client가 server에 접속할때 request message에 cookie정보를 넣어 보내면 server에서는 확인하고 database에서 해당 cookie에 맞는 data를 가지고 작업을 진행한다.<br>
이런식으로 http protocol은 statless이지만 그 전의 정보를 기억 할 수 있게 된다.<br>
client에서는 cookie file을 저장하는 공간이 있다. <br>

## Web caches (proxy server)
<img width="684" alt="98208971-86ef3d00-1f81-11eb-9ab4-52bca42463e1" src="https://user-images.githubusercontent.com/77154341/118427596-93aad580-b708-11eb-8888-12e43ebcf630.png"><br>
client는 web에 접속할때 중간다리 역할인 proxy server에 요청을 하게 된다.<br>
만약에 proxy server에 원하는 정보가 없다면 이제 origin server에 요청을 해서 client가 원하는 data를 받아오게 된다. <br>
만약에 client가 요청한 자료가 이미 proxy server에 있다면 origin server를 거치지 않고 바로 client에게 보내준다. <br>
이렇게 되면 origin server로 가는 flow의 양이 줄어든다. cost 감소.(response time이 줄어든다)<br>
그러나 cache에도 단점이 있는데 proxy server에서 가지고 있는 데이터만 주게 된다면 최신 업데이트 된 자료가 아닌 옛날 자료를 주게 될 수도 있다.<br>
그렇기 때문에 일정 주기안에 proxy server에 있는 데이터를 업데이트 할 필요가 있다.<br>

## E-mail
#### User Agent
mail reader라고 불린다. 사용하는 우리들이다.<br>
여기서는 composing, editing,reading등을 진행한다.<br>

#### Mail Servers
server에서 오가는 mail message를 보관한다.<br>
mailbox와 message queue가 있다.<br>
mailbox는 사용자마다 각각 가지고 있다. <br>
![fsdfsd](https://user-images.githubusercontent.com/77154341/118428206-e8028500-b709-11eb-83be-6ef620f53aba.PNG)<br>
#### mail protocol
![image](https://user-images.githubusercontent.com/77154341/118428245-fa7cbe80-b709-11eb-977f-b81dbbae40cb.png)<br>
어떻게 메일이 보내질까?<br>
일단 보내고 싶은 사람이 받는 사람의 주소를 적어 메일을 보낸다. <br>
그러면 보낸 사람이랑 연결 되어 있는 mail server에 있는 message queue에 메일이 들어가게 된다. <br>
message queue에서 자신 메일이 보내질 차례가 된다면 받는 사람이랑 연결 되어있는 mail server에 있는 mail box에 보내지게 된다.<br>
그다음에 받는 사람이 mail server에 접속하여 mail box에 있는 mail을 읽게된다.<br>

#### SMTP protocol
email도 web과 마찬가지로 tcp를 사용한다.(reliably transfer)내용의 정확성이 중요!<br>
그렇기 때문에 연결을 위해 handshaking을 하고 message를 전달하고 close를 하게 된다.<br>
http는 pull, smtp는 push이다.
![image](https://user-images.githubusercontent.com/77154341/118429120-e8038480-b70b-11eb-8987-abb97079c6d1.png)








