# OS

### 운영체제란???????
operating system 컴퓨터를 제어해주는 역할을 한다.<br>
OS가 하는 역할<br>
컴퓨터 하드웨어를 잘 관리<br>
성능 높이고, 사용자에게 편의성 제공<br>
#### 입출력장치 보호
입출력 장치를 사용하기 위해서는 os에게 허락을 맡아야한다.<br>
입출력 명령을 특권명령으로 in,out으로 설정 <br>
올바른 요청이 아니라면 운영체제가 거부하게 된다.<br>
ex) 여러컴퓨터가 프린터를 사용하는데 다른 컴퓨터에서 다른 컴퓨터의 정보를 요구<br>
사용자가 입출력 명령을 직접 내리게 되면 privileged instruction violation Error를 발생시킨다 <br>
#### 메모리 보호
각자의 프로세스에는 자신이 속한 메모리의 주소가 있다.<br>
MMU가 이것을 관리한다(memory management unit)<br>
os 는 프로세스마다의 주소를 알고있고 만약에 그 프로세스가 아닌 다른 프로세스가 접근을 하려고 하면 막는다.<br>
사실 완전 다 막는건 아니고 접근을 할려면 특정한 방법으로 해야한다 이것을 system call이라고 부른다.<br>
#### CPU 보호
한 사용자가 실수 또는 고의로 cpu 시간을 독접하는것을 방지한다.<br>
ex) while(n=1)<br>
timer를 두어 일정 시간 경과 시 타이머 인터럽트 <br>


### 인터럽트
현대 운영체제는 인터럽트 기반 시스템!<br>
부팅이 끝나면 운영체제는 메모리에 상주 <br>
사건을 기다리며 대기 ex)마우스,키보드<br>
마우스나 키보드 같은 것이 작동하여 하드웨어 인트럽트가 걸리게 되면 os에 특정 코드가 실행된다.<br>
프로그램이 돌아가면서도 인터럽트가 걸리는데 이것을 소프트웨어 인터럽트라고 한다.<br>
마찬가지로 운영채제 내의 특정 코드가 실행된다.(ISR) 종료후 다시 사용자 프로그램으로<br>
(인터럽트가 실행되면 os에서 돌아가야 하기 때문에 사용자모드가 아닌 moniter모드 또는 관리자모드로 실행된다)
<br>
평소에는 운영체제는 대기 상태이다. 그러다가 인터럽트가 걸리게 되면 os가 실행되게 된다.<br>

### 프로세스 관리
프로세스란 메모리에 올라가 있는 프로그램을 말한다.(program in execution)<br>
os가 프로세스를 관리하는데 디스크에서 메모리로 올리는 작업도 하고 소멸시키는 작업도한다.<br>
프로세스 간에 통신도 관여한다. 동기화,교착상태도 처리하게 된다.<br>
그리고 한 프로세스가 실행되는게 아니고 빠른 시간안에 왔다갔다 하는데 이것도 os가 관리한다.<br>

### 프로세스의 상태
new,ready(cpu작업을 기다리는중), running(cpu에의해 실행중), waiting(i/o작업을 기다림, terminated(종료)<br>

### PCB(process control block)
프로세스에 대한 모든 정보가 들어있는 곳(os에 있다)<br>
cpu가 하나라면 한번에 하나의 프로세스밖에 실행할 수 없다. 보통은 하나의 프로세스만 실행하는게 아니고 여러가지 프로세스를 돌아가면서 실행하기 때문에 프로세스 실행 중간에 멈추고 다른 프로세스로 넘어가게 된다<br>
그러면 다시 그 프로세스로 돌아왔을때 어디서부터 다시 진행해야하는지 그전에 정보는 무엇인지 기억하고 있어야 한다. 그 정보를 기억하는 공간이 PCB이다.<br>

## Queues
큐는 FCFS가 적용되는 자료구조이다. 프로세스가 디스크에서 메모리로 올라가서 CPU에서 작업이 진행될 때 까지 여러 큐를 거치게 된다.<br>
#### JOB QUEUE
하드디스크에서 메모리로 올라가기 위해 기다리는 곳을 JOB QUEUE라고 한다. 여기서 적용되는 전략을 JOB scheduler라고 부르고 이 상황은 잘 일어나지 않기 때문에 long-term scheduler라고 한다.

#### READY QUEUE
메모리에 올라와있는 프로세스가 CPU에 의해 실행되기 전에 대기하는 QUEUE이다. 되게 빈번하게 일어나기 때문에 short-term scheduler라고 한다.

#### DEVICE QUEUE
프로세스가 I/O작업을 원할 때 기다리고 있는 곳을 DEVICE QUEUE라고 한다. 

## MULTIPROGRAMMING
cpu는 보통 하나가 아니라 여러개의 프로세스를 돌아가면서 처리하게 된다. 이것을 멀티 프로그래밍이라고 한다.<br>
degree of multiprogramming : 메모리에 얼마나 많은 프로세스가 올라와있는지<br>
i/o bound(프로세스 중에 i/o를 많이 사용하는 프로세스)와 cpu-bound(cpu많이 사용)를 적절하게 잘 섞어야지 cpu를 효율적으로 사용할수 있게 된다.<br>
그리고 프로세스 중에 메로리에는 올라와 있지만 오랫동안 사용 안되는 프로세스가 있을 수 있다. os는 일정 주기마다 메모리를 확인하여 오래 사용 안된 프로세스를 swapping하게 된다.<br>
이러한 작업은 medium-term scheduler라고 한다. 그리고 내보내는 작업을 swapping out 다시 작업을 시작할때 불러오는 것을 swapping in 그리고 내보내는 장소를 swapping device라고 한다. 이 device는 하드디스크에 있다.<br>

#### context switching(문맥전환)
ready queue에 대기하고 있는 process들을 전략적으로 잘 swithing 해야 한다. 이것을 cpu scheduler이라고 부른다.<br>
이렇게 switching하는 곳을 dispatcher이라고 하고 os에 존재한다.<br>
너무 빈번하게 switching을 하게 되면 context switching overhead가 커지게 된다.(cpu에 무리)<br>

## CPU Scheduling
preemptive(선점)                      vs   Non-preemptive(비선점)<br>
들어와 있는애가 끝날때까지 안비켜준다      작업중인 애가 안끝나도 다른 프로세스가 들어올 수 있다.<br>

### scheduling criteria
– CPU Utilization (CPU 이용률) 
– Throughput (처리율) 
– Turnaround time (반환시간) 
– Waiting time (대기시간) 
– Response time (응답시간)

#### CPU Scheduling Algorithms 
- First-Come, First-Served
가장 먼저들어온 작업을 먼저 처리한다. 제일 단순한 방법 그러나 효율적이지 못하다. Nonpreemptive scheduling<br>
- Shrotest-Job-First
가장 짧게 걸리는 프로세스를 먼저 처리.<br>
FCFS 보다는 효율적 그러나 현실적이지 못하다(프로세스가 얼마나 걸릴지 모름)<br>
선점방식도 가능하고 비선점 방식도 가능하다.<br>
선점 방식일 경우 중간에 짧게 걸리는 프로세스가 들어오게 되면 변경 된다.<br>

- Priority Scheduling 
프로세스에 우선순위를 정해 우선순위가 높은 프로세스 먼저 처리하게 한다.<br>
우선순위는 internal 방식고 external방식으로 정해질 수 있다.<br>
문제점은 starvation이 일어날 수 있다.(우선순위가 낮은 프로세스는 평생 실행이 안될수 있다)<br>
againg으로 해결 가능하다.(시간이 지나면 우선순위를 높여준다)<br>

- Round-Robin
Time-sharing system (시분할/시공유 시스템) 시간이 어느정도 지나면 process를 변경하여 작업한다.<br>
변경하는 시간을 설정 할 수 있는데 그 시간 텀을 time quantum(시간양자)라고 부른다.<br>
preemptive scheduling 방식으로 계속 작업중인 process가 변경된다(당연한것,,)<br>
만약에 time quantum 이 무한대가 된다면 FCFS랑 같은 방식이고 0으로 수렴하게 되면 prcessor sharing이 된다. context switching overhead가 굉장히 높아져서 비효율적이다)<br>
적절한 time quantum을 정하는 것이 중요하다.<br>

- Multilevel Queue Scheduling
ready queue 를 한 줄이 아닌 여러줄로 나누어서 정리를 해둔다. 보통 비슷한 역할을 하는 프로세스끼리 묶어서 queue에 둔다. queue마다 우선순위가 다를 수 있고 각 queue 에서 사용하는 scheduling이 다를 수 있다. cpu time 을 차등 배분한다. <br>
다른 queue로 이동시켜 프로세스를 진행할 수 있다. 기아상태가 우려된면 우선순위 높은 queue로 올린다.<br>

#### 프로세스 생성과 종료
프로세스는 프로세스에 의해 만들어진다. os가 실행되면서 최초의 프로세스가 자동으로 만들어진다.<br>
모든 프로세스는 PID를 가지고 있다. 부모 프로세스에서 자식 프로세스가 나온다. <br>
fork() system call 부모 프로세스 복사<br>
exec() 실행파일을 메모리로 가져오기<br>
eixt() system call 프로세스 <br>


## 쓰레드
프로그램 내부의 흐름,맥

#### 다중 쓰레드(multithreads)
한 프로그램에 2개 이상의 맥이 존재한다. 맥이 빠르게 스위칭 되기 때문에 동시에 돌아가는 것 처럼 보인다.<br>
ex) web brower 화면출력 쓰레드 + 데이터 읽어오는 쓰레드 <br>
word processor 화면출력 쓰레드 + 키보드 입력, 철자문법오류 확인 쓰레드...

### Tread vs Process
프로세스가 조금 더 큰 개념이고 프로세스 안에 쓰레드가 존재한다. 프로세스에는 최소 하나의 쓰레드가 존재한다.<br>
한 프로세스에 있는 쓰레드 들은 프로세스의 메모리 공간 중 code,data를 공유하고 프로세스의 자원(file,i/o...)등을 공유한다.<br>
stack은 비공유한다. 각자 흐르고 있는 위치가 다르기 때문 <br>
요즘 컴퓨터는 쓰레드의 스위칭이 대부분이다. <br>

### 프로세스 동기화(process Synchronization)
os가 하는 역할중 cpu관리에서 스케쥴링과 함께 가장 중요한 기능중 하나가 프로세스 동기화이다.<br>
프로세스(쓰레드) 간에 서로 같은 데이터를 관리할 경우가 생긴다. 이때 동기화를 하지 않는다면 데이터가 잘못 된다.<br>
왜냐하면 cpu는 쓰레드의 스위칭이 일어나는데 관리하는 중간에 스위칭이 일어나 데이터가 변경이 될 수도 있기 때문이다. <br>
공통변수에 대한 동시 업데이트는 지양 해야한다. (임계구역 문제)<br>

### 임계구역 문제(critical-section problem)
멀티쓰레드를 가지고 있는 프로세스에서 common variables를 변경하는 코드를 critcal section이라고 부른다.<br>
solution<br>
mutual exclusion : 오직 한 쓰레드만 진입<br>
progress : 진입 결정은 유한 시간 내<br>
bounded waiting: 어느 쓰레드라도 유한 시간 내 cpu를 만나야함<br>
프로세스(쓰레드) 동기화를 정리하자면 임계구역 문제를 해결(틀린답이 나오지 않도록)하고 프로세스를 실행 순서 제어를 하는것이다.<br>

### Semaphores(세마포)
동작: P->acquire()<br>
      V -> release()<br>
![image](https://user-images.githubusercontent.com/77154341/119251618-71bac280-bbe2-11eb-98f6-a184516ddff2.png)<br>
즉 쓰레드가 돌다가 acquire를 만나게 되면 블록을 시키고 release를 만나게 되면 block되어있는 쓰레드를 꺼내주게된다.<br>
![image](https://user-images.githubusercontent.com/77154341/119251625-7b442a80-bbe2-11eb-92a9-7293effd1fe2.png)<br>
이런식으로 하면 multual exclusion문제는 해결된다. 초기 value는 1로 설정 처음 만난 쓰레드가 acquire를 만나게 되고 만나면 value가 0이된다.<br>
만약에 중간에 쓰레드 스위칭이 일어나서 다른 쓰레드가 acquire를 만나면 value가 -1이 되기 때문에 그 쓰레드는 block되게 된다.<br>
      <br>
세마포를 사용해서 ordering문제도 해결 가능하다. <br>
![image](https://user-images.githubusercontent.com/77154341/119251742-09b8ac00-bbe3-11eb-9447-859bcb30538e.png)<br>
이렇게 되면 항상 P1이 먼저 실행된다. (value값은 0으로 설정)<br>

#### 전통적 동기화 예제
- producer and Consumer problem
- 공유 데이터베이스 접근
- 식사하는 철학자 문제(교착상태)

### 교착상태(deadlock)
프로세스는 실행을 위해 여러 자원을 필요로 한다. 그런데 다른 프로세스가 이미 자원을 사용하고 있으면 그 프로세스는 대기를 해야한다.<br>
그런데 그때 하나를 붙잡고 다른 하나의 자원을 기다리는 프로세스가 엉키게 되면 교착상태에 빠질 수 있다.<br>
#### 교착상태 필요 조건
– Mutual exclusion (상호배타) 
– Hold and wait (보유 및 대기) 
– No Preemption (비선점) 
– Circular wait (환형대기)

#### 교착상태 처리
- 교착상태 방지
교착상태 필요조건 중에 한가지를 불만족 시키게 하는 것이다. 
 
- 교착상태 회피
- 교착상태 검출 및 복구
- 교착상태 무시


