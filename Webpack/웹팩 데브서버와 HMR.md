## 1. Webpack Dev Server

웹팩 데브서버는 웹 어플리케이션을 개발하는 과정에서 유용하게 쓰이는 도구. **웹팩의 빌드 대상파일이 변경되었을 때 매번 웹팩 명령어를 실행하지 않아도** 코드만 변경하고 저장하면 웹팩으로 빌드한 후 브라우저를 새로고침 해준다.

매번 명령어를 치고 새로고침 하는시간 뿐 아니라 빌드시간 또한 줄여주기 때문에 웹팩 기반 웹 애플리케이션 개발에 **필수**도구라고 볼 수 있다.

### 웹팩 데브 서버의 특징

웹팩 데브 서버는 일반 웹팩 빌드와 다른 점이 있다. 먼저 명령어는 다음과 같다.

```js
// package.json

"scripts": {
  "dev": "webpack serve"
  "build": "webpack"
}
```

웹팩 데브 서버를 실행하여 웹팩 빌드를 하는 경우에는 빌드한 결과물이 파일 탐색기나 프로젝트 폴더에서 보이지 않는다. 좀 더 구체적으로 얘기하자면 웹팩 데브 서버로 빌드한 결과물은 메모리에 저장되고 파일로 생성하지는 않기 때문에 컴퓨터 내부적으로 접근할 수 있지만 사람이 직접 눈으로 보고 파일을 조작할 수 없다.

따라서 웹팩 데브 서버는 **개발할 때만사용**하다가 개발이 완료되면 웹팩 명령어를 이용해 결과물을 파일로 생성해야 한다.

> 컴퓨터 구조 관점에서 파일 입출력보다 메모리 입출력이 더 빠르고 컴퓨터 자원이 덜 소모 된다.

### 프록시(Proxy) 설정

프록시 설정은 실무에서 가장 흔하게 사용되는 속성이다. 아래와 같이 선언한다.

```js
// webpack.config.js
module.exports = {
  devServer: {
    proxy: {
      '/api': 'http://localhost:3000'
    }
  }
}
```

위와 같이 설정하고 나면 로컬 웹팩 데브 서버에서 발생하는 API 요청에 변화가 생긴다. 그림으로 보면 다음과 같다. 먼저 프록시를 쓰지 않았을 때 기본적인 webpack dev server와 API 서버의 통신 구조이다.

<img src="https://joshua1988.github.io/webpack-guide/assets/img/cors-error.e6e73b68.png" style="zoom:50%" />

여기서 [CORS](https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS) 라는 용어가 나온다. 브라우저 보안과 관계가 있는데 쉽게 얘기해서 다른 도메인간에는 자바스크립트로 자원을 요청할 수 없는 설정이다. 위 그림에서도 서버에 로그인 관련 API를 요청했는데 CORS 오류가 나는걸 확인할 수 있다.

뷰, 리액트 같은 프론트엔드 프레임워크를 쓰면 개발 편의상 로컬에 웹팩 데브 서버를 띄워놓고 개발하는 경우가 많은데 이 때, 이러한 문제를 해결하기 위해서 아래와 같이 프록시 속성을 설정하면 서버에서 해당 요청을 받아준다.

```js
// webpack.config.js

module.exports = {
  devServer: {
    proxy: {
      '/api': 'domain.com'
    }
  }
}
```

<img src="https://joshua1988.github.io/webpack-guide/assets/img/proxy.dce9d87c.png" style="zoom:50%"/>

CORS가 브라우저 보안과 관련있기 때문에 브라우저에서 벗어나 서버에서 서버로 요청한다. 실제로 브라우저에서는 `localhost:8080/api/login` 으로 요청했지만 중간에 프록시 서버의 활약으로 `domain.com` 서버에서는 같은 도메인(domain.com)에서 온 요청으로 인식하여 CORS 에러가 나지 않게된다.



> 위 프록시 설정은 도메인이 ip 주소인 경우를 가정해서 작성되었지만 실제 가상이름(domain.com)으로 되어있는 경우 아래 옵션을 추가해주어야한다.

```js
// webpack.config.js

module.export = {
  devServer: {
    proxy: {
      '/api': {
        target: 'domain.com'
        changeOrigin: true
      }
    }
  }
};
```

참고 : [웹팩 핸드북](https://joshua1988.github.io/webpack-guide/devtools/webpack-dev-server.html#프록시-proxy-설정)



## 2. HMR (Hot Moudle Replacement)

<img src="/Users/seungjun/Library/Application Support/typora-user-images/image-20211003173223908.png" alt="image-20211003173223908" style="zoom:50%;" />

핫 모듈 리플레이스먼트는 웹팩이 제공하는 기능으로 전체 새로고침 없이 모든 종류의 모듈들을 런타임 시점에서 업데이트 한다.

> HMR은 프로덕션에 사용하는것이 아닌 개발에서 사용하기 위한 기능이다. 자세한 내용은 [building for porduction guide](https://webpack.js.org/guides/production) 참고

### HMR 사용

이 기능은 생산력 향상에 도움을 준다. [webpack-dev-server](https://github.com/webpack/webpack-dev-server) 구성을 업데이트 하고 웹팩에 내장된 HMR 플러그인을 사용해야 한다.

> 만약 webpack-dev-server 대신 webpack-dev-middleware 라우트를 선택했다면, 커스텀 서버 또는 어플리케이션에서 HMR을 사용할 수 있도록 [webpack-hot-middleware](https://github.com/webpack-contrib/webpack-hot-middleware) 패키지를 사용

### HMR 설정하기
리액트, 앵귤러, 뷰와 같이 대부분의 프레임워크에서 이미 HMR을 사용할 수 있는 로더들을 지원하고 있지만 만약 개별적으로 설정하고 싶다면 아래와 같은 방식으로 설정할 수 있다.
```js
/// webpack.config.js

module.exports = {
  devServer: {
    hot: true
  }
}
```
데브 서버에 옵션으로 `hot:true`를 추가하고 자바스크립트나 CSS 스타일시트를 변경하면 해당 모듈이 바로 업데이트가 됩니다. 그리고 화면에서는 브라우저가 다시 로딩되지 않고도 변경된 내용을 확인할 수 있습니다