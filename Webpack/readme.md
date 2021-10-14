# Webpack Core Concepts

\- Entry (엔트리)

\- Output (출력)

\- Loaders (로더)

\- Plugins (플러그인)

\- Mode (모드)

\- Browser Compatibility (브라우저 호환성)

## Entry

**엔트리 포인트**는 webpack이 내부의 디펜던시 그래프를 생성하기 위해 사용해야 하는 모듈입니다.  Webpack은 엔트리 포인트가 (직간접적으로) 의존하는 다른 모듈과 라이브러리를 찾아냅니다.

기본값은 `./src/index.js` 이지만 webpack 설정에서 `entry` 속성을 설정하여 다른 (또는 여러 엔트리 포인트)를 지정할 수 있습니다.

```js
module.exports = {
  entry: './path/to/my/entry/file.js',
};

// 여러가지를 지정할 때는 아래와 같이 지정해주면 된다.
module.exports = {
  entry: {
    home : './home.js',
    about: './about.js',
    contact: './contact.js',
  },
};
```

## Output

**output** 속성은 생성된 번들을 내보낼 위치와 이 파일의 이름을 지정하는 방법을 webpack에 알려주는 역할을 한다. 기본 출력 파일의 경우에는 `./dist/main.js`로, 생성된 기타 파일의 경우에는 `./dist` 폴더로 설정된다. 다음과 같이 설정에서 `output` 필드를 지정할 수 있다.

```js
// webpack.config.js
const path = require('path');

module.exports = {
  entry : {
   home : './home.js',
  },
  output : {
    path : path.join(__dirname, 'dist'),
    filename: 'abc.bundle.js',
  }
}
```

위 예제에서 `output.filename` 과 `output.path` 속성을 사용하여 webpack 번들의 이름과 내보낼 위치를 설정함.

## Loaders

webpack은 기본적으로 JavaScript와 JSON 파일만 이해한다. **로더** 를 사용하면 webpack이 다른 유형의 파일을 처리하거나, 그들을 유효한 모듈로 변환하여 애플리케이션에서 사용하거나 디펜던시 그래프에 추가한다.



>  **Warning**
>
>  webpack의 특정 기능 중 하나인 모든 유형의 모듈(예: `.css`)을 `import` 하는 기능은 다른 번들러나 태스크 러너에서 지원하지 않을 수 있습니다. 개발자들에게 더욱 정확한 디펜던시 그래프를 생성하는 데 도움을 주기 때문에 이러한 언어의 확장이 필요하다고 생각합니다.

상위 수준에서 **로더** 는 webpack 설정에 두 가지 속성을 가진다.

1. 변환이 필요한 파일을 식별하는 `test` 속성
2. 변환을 수행하는데 사용되는 로더를 가리키는 `use` 속성

```js
// webpack.config.js
const path = require('path');

module.exports = {
  output : {
    filenmae : 'abc.bundle.js',
  },
  
  module: {
    rules: [{
      test: /\.txt$/,
      use: 'raw-loader',
    }],
  },
};
```

위 설정에서  `test`와 `use`라는 두 가지 필수 속성을 가진 하나의 모듈을 위해 `rules` 속성을 정의했습니다. 이는 webpack의 컴파일러에 다음과 같이 말합니다.

> " `require ()`/`import` 문 내에서 '.txt' 파일로 확인되는 경로를 발견하면 번들에 추가하기 전에 `raw-loader`를 **사용하여** 변환하여라."

> ###### Warning
>
> webpack 설정에서 규칙을 정의할 때 `rules`가 아닌 `module.rules` 아래에 정의한다는 것을 기억하세요. 당신의 편의를 위해 webpack은 잘못 정의한 경우에 경고를 합니다.

> ###### Warning
>
> 정규식을 사용하여 파일을 매칭할 때 따옴표를 사용하지 않도록 주의하세요. 즉, `/\.txt$/`는 `'/\.txt$/'` 또는 `"/\.txt$/"`와 같지 않습니다. 전자는 webpack에 .txt로 끝나는 모든 파일과 일치하도록 지시하고 후자는 webpack에 절대 경로 '.txt'를 가진 단일 파일과 일치하도록 지시합니다. 이는 당신의 의도한 것이 아닐 가능성이 높습니다.

## Plugins

로더는 특정 유형의 모듈을 변환하는 데 사용되지만, 플러그인을 활용하여 번들을 최적화하거나, 애셋을 관리하고, 또 환경 변수 주입등과 같은 광범위한 작업을 수행 할 수 있습니다.

플러그인을 사용하려면 `require ()`를 통해 플러그인을 요청하고 `plugins` 배열에 추가해야 합니다. 대부분의 플러그인은 옵션을 통해 사용자가 지정할 수 있습니다. 다른 목적으로 플러그인을 여러 번 사용하도록 설정할 수 있으므로 `new` 연산자로 호출하여 플러그인의 인스턴스를 만들어야 합니다.

```js
// webpack.config.js

const HtmlWebpackPlugin = require('html-webpack-plugin'); // npm을 통해 설치
const webpack = require('webpack'); // 내장 plugin에 접근하는 데 사용

module.exports = {
  module: {
    rules: [{ 
      test: /\.txt$/,
      use: 'raw-loader'
    }],
  },
  plugins: [
    new HtmlWebpackPlugin({ template: './src/index.html' })
  ],
};
```

위의 예제에서 `html-webpack-plugin`은 생성된 모든 번들을 자동으로 삽입하여 애플리케이션용 HTML 파일을 생성합니다.

 [plugin 목록](https://webpack.kr/plugins)

## Mode

`mode` 파라미터를 `development`, `production` 또는 `none`으로 설정하면 webpack에 내장된 환경별 최적화를 활성화 할 수 있습니다. 기본값은 `production` 입니다.

``` js
// webpack.config.js
module.exports = {
  mode: 'production'
}
```

## Browser Compatibility

Webpack은 [ES5](https://kangax.github.io/compat-table/es5/)가 호환되는 모든 브라우저를 지원합니다(IE8 이하는 지원되지 않습니다). Webpack은 [`import()` 및 `require.ensure()`](https://webpack.kr/guides/code-splitting/#dynamic-imports)을 위한 `Promise`를 요구합니다. 구형 브라우저를 지원하려면 이러한 표현식을 사용하기 전에 [폴리필을 로드](https://webpack.kr/guides/shimming/)해야 합니다.



참고 : [Webpack 공식문서](https://webpack.kr/concepts/)

