##### Application layer<br>

##  Client - server architecture<br>
Server:<br>
always - on host<br>
permanent IP address<br>
data centers for scaling<br>

Clients:<br>
communicate with server<br>
do not communciate directly with each other<br>
may be intermittently connected<br>
may have dynamic IP addresses<br>

## P2P architecture (서버 없이 컴퓨들 끼리 communicate)<br>
no always-on server<br>
arbitary end systems directily communicate<br>
모든 컴퓨터 들은 서버이면서 클라이언트가 된다.<br>
self scalability<br>
complex management<br>

## Processes communicating<br>
결국 통신하는 주체는 각 컴퓨터안에서 돌아가고 있는 processes 이다. <br>
같은 호스트 내에서는 inter-process communicatin을 통해 서로 communicate를 하고<br>
다른 호스트에 있는 process와 communicate를 하기위해 messages를 교환하면서 communicate를 한다. <br>
<br>
client process와 server process로 나뉜다.<br>
client process는 server process에게 요청을 보내 communication을 initiates한다.<br>
server process는 contacted할려는 message를 기다린다. <br>


## Sockets
