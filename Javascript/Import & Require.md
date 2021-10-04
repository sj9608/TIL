# Import와 Require

## 공통점

기본적으로 `import` 와 `require` 모두 모듈 키워드로 외부 파일이나 라이브러리를 불러올 때 사용한다.

## 차이점

`require`는 `Node.js` 에서 사용되고 있는 CommonJS 키워드이고, `import`는ES2015에서 새롭게 도입된 키워드이다. 

`require` 는 CommonJS 를 사용하는 `Node.js` 문법이지만 `import` 는 ES6 에서만 사용되는 키워드임.

## 사용법

```js
// require의 사용
const library = require('library')

// import의 사용
import library from 'library';
```

최근 ES6(ES2015) 모듈 시스템인 `import` 가 많이 사용되고 있지만, 아직까지는 `import` 키워드가 `require` 키워드를 100% 대체 할 수 없다. \<script> 태그를 사용하는 브라우저 환경과 `Node.js` 에서도 CommonJS를 기본 모듈 시스템으로 채택하고 있기 때문에, **Babel과 같은 ES6 코드를 변환해주는 도구를 사용할 수 없는 경우에는 require 키워드를 사용해야 한다.**

> webpack.config.js는 babel이 적용되기 전 이기때문에 **import가 아닌 require**를 사용해야한다