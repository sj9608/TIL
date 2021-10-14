# 음양 더하기

#### 문제 설명

어떤 정수들이 있습니다. 이 정수들의 절댓값을 차례대로 담은 정수 배열 absolutes와 이 정수들의 부호를 차례대로 담은 불리언 배열 signs가 매개변수로 주어집니다. 실제 정수들의 합을 구하여 return 하도록 solution 함수를 완성해주세요.

#### 제한사항

- absolutes의 길이는 1 이상 1,000 이하입니다.
  - absolutes의 모든 수는 각각 1 이상 1,000 이하입니다.
- signs의 길이는 absolutes의 길이와 같습니다.
  - `signs[i]` 가 참이면 `absolutes[i]` 의 실제 정수가 양수임을, 그렇지 않으면 음수임을 의미합니다.

------

##### 입출력 예

| absolutes  | signs                | result |
| ---------- | -------------------- | ------ |
| `[4,7,12]` | `[true,false,true]`  | 9      |
| `[1,2,3]`  | `[false,false,true]` | 0      |



#### 문제이해

주어진 absolutes 배열의 숫자와 signs의 부호를 보고 덧셈을 하면될 것 같다.

마침 오늘 정리한 reduce함수를 이용해서 풀어 보았다.



#### 수도코드

1. 주어진 절대값 배열들에 대한 원소를 순차적으로 접근한다.
2. 해당 원소의 인덱스에 해당하는 부호를 판별한다.
3. 참(signs[index] === true)이면 누산기에 더한값을 반환하고, 거짓이면 뺀 값을 반환한다.
4. 최종적으로 reduce함수가 반환하는 acc 를 return



#### 코드

```js
const solution = (absolutes, signs) => {
  return answer = absolutes.reduce((acc, currentValue, index) => signs[index] ? acc + currentValue : acc - currentValue, 0)
}
```

