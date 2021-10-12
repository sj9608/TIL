### Array.prototype.reduce()

`reduce()` 메서드는 배열의 각 요소에 대해 주어진 **리듀서(reducer)** 함수를 실행하고, 하나의 결과값을 반환한다. 또한 리듀서 함수는 화살표 함수로 간단하게 나타낼 수도 있다.

```js
const arr1 = [1, 2, 3, 4];
const reducer = (previousValue, currentValue) => previousValue + currentValue;

// 1 + 2 + 3 + 4
console.log(arr1.reduce(reducer));
// expected output : 10

// 5 + 1 + 2 + 3 + 4
console.log(arr1.reduce(reducer, 5));
```

```js
const numbers = [1, 3, 5, 6];

sum = numbers.reduce((acc, cur) => acc + cur, 0);

```



#### 구문

> <span style="color:black" >arr.reduce(callback [, initalValue])</span>



#### 매개변수

`callback`

​	배열의 각 요소에 대해 실행할 함수. 다음 네 가지 인수를 받습니다.

​	`accumulator` (누산기)

​		누산기는 콜백의 **반환값을 누적**한다. 콜백의 이전 반환값 또는, 콜백의 첫 번째 호출이면서 `initialValue`를 제공한 경우에는 `initialValue`의 값

​	`currentValue`

​		처리할 현재 요소

​	`currentIndex`

​		처리할 현재 요소의 인덱스 `initialValue`를 제공한 경우 0, 아니면 1부터 시작

​	`array`

​		`reduce`를 호출한 배열



#### 반환 값

누적 계산의 결과 값.

