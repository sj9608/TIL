# Docker 개념 설명

**해당 Post는 ** [**초보를 위한 도커 안내서 by subicura**](https://subicura.com/2017/01/19/docker-guide-for-beginners-1.html) 와 [**생활코딩 Docker 입문수업**](https://opentutorials.org/course/4781/30609) 의 내용을 **다수 인용하였습니다.**

<img src="https://www.docker.com/sites/default/files/d8/2019-07/vertical-logo-monochromatic.png" alt="img" style="zoom:33%;" />

## docker ?

* 도커는 **컨테이너 기반의 오픈소스 가상화 플랫폼** 이다.

### Container ?

컨테이너라고 생각하면 운송을 할 때 이것 저것 담는 엄청 큰 박스 를 연상하게 될 텐데 서버에서 이야기하는 컨테이너도 이와 다르지 않다.

* 다양한 프로그램, 실행환경을 컨테이너로 추상화
* 동일한 인터페이스를 제공
  * 프로그램의 배포 및 관리를 단순하게 해준다

* 컨테이너는 격리된 공간에서 프로세스가 동작하는 기술이다.



### difference between docker and other VM

* 기존의 VMware, VirtualBox 같은 가상머신은 **호스트 OS위에 게스트 OS 전체**를 가상화하여 사용하는 방식
* 위의 방식은 사용법이 **간단**하지만 **무겁고, 느리다는 단점이 있음**

![Docker containers](https://assets-global.website-files.com/5efc3ccdb72aaa7480ec8179/5f03f585f55f79c8b17ae7d2_containers-blog.png)



### Image ?

* 도커에서 **특정 프로세스(컨테이너)를 실행하기 위한 모든 파일 및 설정 값을 포함**하고 있는 파일

* 하나의 이미지 파일로 여러개의 컨테이너를 생성할 수 있다.
* 또한 컨테이너의 상태가 바뀌어도 이미지는 그대로 남아있는 하나의 SNAPSHOT 이라고 할 수 있다.