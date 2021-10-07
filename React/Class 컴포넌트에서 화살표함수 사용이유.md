#### class 컴포넌트에서 사용자가 선언하는 함수에서 화살표 함수를 사용하는 이유

함수를 호출하기 위해서 생성자에 함수를 바인딩 해야하는데 이 작업이 번거로움

> 화살표 함수 사용시 자동으로 선언한 함수를 class에 bind 해준다.

```jsx
class Compo extends React.Compoenet {
  state = {
    value: 'hello'
  }

	const customFuncc = () => {
    console.log(this.state.value);
    // expected output : 'hello'
  }
  
	customFunc() {
    console.log(this);
    // output : undefined 
    
    console.log(this.state.value);
    // expected output : Cannot read property 'setState' of undefined
    // this 를 이해할 수 없게된다.
  }
}
```

화살표 함수를 쓰지않기 위해서 클래스형 컴포넌트를 다음처럼 구성해야한다.

```jsx
class Compo extends React.Component {
  constructor(props) {
    super(props);
    
    this.state = {
      value: "hello"
    }
    
    this.customFunc = this.customFunc.bind(this);
  }
  	
  customFunc() {
    console.log(this.state.value);
    // expected output : 'hello'
  }
  
}
```