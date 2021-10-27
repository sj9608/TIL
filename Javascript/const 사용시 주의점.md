# const 키워드 상세

**const 키워드는 재할당을 금지할 뿐 '불변'을 의미하지는 않는다.** 새로운 값을 재할당 하는 것은 불가능하지만 프로퍼티 동적 생성, 삭제, 프로퍼티 값의 변경을 통해 객체를 변경하는 것은 가능하다. 

```js
const person = {
  name : 'Lee'
};

person.name = 'Kim';

console.log(person); // {name : 'Kim'} 
```

person 변수에 할당된 name 이라는 참조 값자체는 변경되지 않는다.