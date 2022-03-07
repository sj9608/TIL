# Java (JDK) 버전 변경 (Mac )

## 0. java 설치

https://www.azul.com/downloads/?os=macos&architecture=arm-64-bit&package=jdk

사용환경에 맞게 설치하면 된다. m1의 경우 arm64 아키텍쳐 파일 다운로드



## 1. 사용중인 java 버전 확인

```bash
java -version
```

현재 17.0.1 LTS 버전 사용중

```term
java version "17.0.1" 2021-10-19 LTS
Java(TM) SE Runtime Environment (build 17.0.1+12-LTS-39)
Java HotSpot(TM) 64-Bit Server VM (build 17.0.1+12-LTS-39, mixed mode, sharing)
```



## 2. 설치 되어있는 Java Virtual Machines 확인

```bash
/usr/libexec/java_home -V
```



이전에 설치 했었던 8버전과 11버전 그리고 현재 사용중인 17버전이 다음과 같이 출력된다.

```term
Matching Java Virtual Machines (3):
    17.0.1 (x86_64) "Oracle Corporation" - "Java SE 17.0.1" /Library/Java/JavaVirtualMachines/jdk-17.0.1.jdk/Contents/Home
    11.0.13 (x86_64) "Oracle Corporation" - "Java SE 11.0.13" /Library/Java/JavaVirtualMachines/jdk-11.0.13.jdk/Contents/Home
    1.8.0_312 (x86_64) "Eclipse Temurin" - "Eclipse Temurin 8" /Library/Java/JavaVirtualMachines/temurin-8.jdk/Contents/Home
/Library/Java/JavaVirtualMachines/jdk-17.0.1.jdk/Contents/Home
```



## 3. JAVA_HOME 의 경로를 바꿔 사용할 버전을 바꾼다

사용 할 버전을 다음과 같이 입력한다.

```bash
# .zshrc

export JAVA_HOME=/Library/Java/JavaVirtualMachines/zulu-8.jdk/Contents/Home
export PATH=${PATH}:$JAVA_HOME/bin

source ~/.zshrc
```



## 4.  JDK 설치 경로는 다음과 같다.

```bash
/Users/(userName)/Library/Java/JavaVirtualMachines/
```