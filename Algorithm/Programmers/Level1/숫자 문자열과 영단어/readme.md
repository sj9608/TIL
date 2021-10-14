# 숫자 문자열과 영단어
[문제 보러 가기](https://programmers.co.kr/learn/courses/30/lessons/81301)

입출력 예

|s|result|
|---|---|
|"one4seveneight"|1478|
|"23four5six7"|234567|
|"2three45sixseven"|234567|
|"123"|123|

## solution 1
1. 문자열을 영문으로 표기된 숫자 기준으로 split
2. `Array.join`을 이용해 두 원소 사이에 해당 숫자 삽입후 새 문자열 생성

과정은 다음과 같다.
예제 'one4seveneight'의 경우 
1. split -> ['', '4seveneight']
2. join -> "14seveneight"
3. split -> ['14', 'eight']
4. join -> 147eight
5. split -> ['147', '']
6. join -> 1478

## solution 2
정규 표현식을 이용하는 방법이 있다.
`str.replace`를 이용 하는것 `str.replaceAll`을 이용해 전체를 한번에 바꾸는 방법도 있지만 지원을 안하는 버전일 수 있기 때문에 안전하게 `replace`를 이용한다고 함.

```js
function solution(s) {
  let answer = '';

  s = s.replace(/zero/g, '0'); //
  . . .
  . . .
  s = s.replace(/nine/g, '9');

  return answer = Number(s);
}
```

> `s.replace`는 기존 문자열을 재구성하는 것이 **아님** 
새로운 문자열을 반환한다. 또한 첫번째 인자에 해당하는 문자열 최초 1회만 변환하기 때문에 g옵션을 추가해줘야함
