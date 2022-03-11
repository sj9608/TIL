# TypeScript

자세한 기능들은 아래 링크에서 확인

[MS 공식문서 한글번역 핸드북](https://typescript-kr.github.io/)



## What is TypeScript?

TypeScript is **JavaScript with syntax for types**  공식 문서에 적혀있는 한마디

이 한마디에 모든게 담겨 있다. 타입 스크립트는 **타입을 위한 문법을 추가한 자바스크립트**

![image](https://user-images.githubusercontent.com/52594760/157857379-5ccb6aaa-62ff-457d-a5ee-0968f955fbdb.png)



## 타입스크립트의 특징

* **컴파일 언어, 정적 타입 언어**

  js는 동적 타입의 인터프리터 언어로 런타임에서 오류를 발견할 수 있다. 이에 반해 타입스크립트는 **정적 타입의 컴파일 언어** 이며 타입 스크립트 컴파일러 또는 바벨 (Babel) 을 통해 js 코드로 변환된다. 이점으로 코드 작성 단계에서 타입을 체크해 오류를 확인할 수 있고 미리 타입을 결정하기 때문에 실행 속도가 매우 빠르다는 장점이 있다. (코드 작성시 매번 타입을 결정해야하기 때문에 번거로울 수 있지만 코드의 안정성이 향상된다. 컴파일 시간은 오래 걸린다는 단점)

* **자바스크립트 슈퍼셋 (Superset)**

  자바 스크립트의 기본 문법에 타입스크립트의 문법을 추가한 언어로 js로 작성한 코드는 확장자를 .js에서 .ts로 변경하고 타입스크립트로 컴파일해 변환할 수 있다.

* **객체 지향 프로그래밍 지원**

  ES6 에서 새롭게 사용된 문법을 포함하고 있으며 클래스, 인터페이스, 상속, 모듈 등과 같은 객체 지향 프로그래밍 패턴을 제공한다.

  





## Installing TypeScript

2 ways to install TypeScript

1. install with npm (node.js package manager)

```bash
npm instlal -g typescript
```

2. install TypeScript plugin on vsCode extensions







참고 문서

* [삼성 SDS : 활용도가 높아지는 웹 프론트엔드 언어, 타입 스크립트 (TypeScript)](https://www.samsungsds.com/kr/insights/TypeScript.html)

* [TypeScript 공식문서 ](https://www.typescriptlang.org/)
* [microsoft 공식문서 한글번역 핸드북](https://typescript-kr.github.io/)

