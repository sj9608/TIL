# How to set Servlet Project in IntelliJ

1. [Create Project](#Create-Project)
2. [Add Servlet Library](#Add%20Servlet%20Library)
3. [Tomcat context setting](#Tomcat%20Context.xml%20setting)

<br/><br/>

## Create Project

New > Project > Java Enterprise

<img src="https://user-images.githubusercontent.com/52594760/147573491-b342a490-bc45-4fb9-be6c-5959589a1a65.png" alt="image" style="zoom:50%;" />

Project template : Web application 선택

Language : Java or Kotlin

Test Framework 는 JUnit이 자주쓰이는 것 같다.

이후 Next를 누르면 다음과 같은 이미지가 뜨는데 상황에 맞는 라이브러리를 추가로 구성할 수 있다.

<img src="https://user-images.githubusercontent.com/52594760/147573777-3e01dee2-463b-435a-a0ba-2ec220bc369b.png" alt="image" style="zoom:50%;" />

<br/><br/>

## Add Servlet Library

Project > src > main > webapp > WEB-INF 폴더 내부에 `lib` directory 를 생성하고 그 안에 module을 추가하면 된다.

만약 Servlet과 jdbc를 연동하려면 다음과 같이 프로젝트를 구성하면 된다.

<img src="https://user-images.githubusercontent.com/52594760/147574690-330bb241-cb73-4a9c-86de-d4b7effe5d33.png" alt="image" style="zoom:50%;" />

<br/><br/>

## Tomcat Context.xml setting

File > Project Structure( `⌘ + ;` )

Project Settings > Modules > Web > `Add application Server specific descriptor...`

Application Server : Tomcat Server

Descriptor : Tomcat Context Descriptor

Version : 5.0 

<img src="https://user-images.githubusercontent.com/52594760/147575579-cf9c8fc6-acb6-4215-adeb-df6e59bafa02.png" alt="image" style="zoom:50%;" />