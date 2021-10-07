#### Array.prototype.splice()

`splice()` 메서드는 배열의 기존 요소를 **삭제** 또는 **교체**하거나 새 요소를 **추가** 하여 배열의 내용을 변경한다.

```js
const months = ['Jan', "March", "April", "June"];

months.splice(1, 0, 'Feb');
// inserts At index 1
console.log(months);
// expected output : ['Jan', 'Feb', 'March', 'April', 'June']

months.splice(4, 1, 'May');
// replace 1 element at index 4
console.log(months);
// expected output : ['Jan', 'Feb', 'March', 'April', 'May']

```

> array.splice(start [, deleteCount [, item1, [, item2 [, ...]]]])

\- start : 변경을 시작할 인덱스

\- deleteCount : 제거할 요소의 수 ( 0이면 제거 x)

\- item : 추가할 요소 

##### 반환값

**제거한 요소를 담은 배열**, 하나의 요소를 제거 한경우 길이가 1인 배열을 반환. 

[MDN splice 설명](https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Global_Objects/Array/splice)

