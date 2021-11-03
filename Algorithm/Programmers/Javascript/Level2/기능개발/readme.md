# 기능개발

Programmers Stack/Queue Algorithm Level2

#### 문제 설명

프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.

또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.

먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.

#### 제한 사항

- 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
- 작업 진도는 100 미만의 자연수입니다.
- 작업 속도는 100 이하의 자연수입니다.
- 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.

#### 입출력 예

| progresses               | speeds             | return    |
| ------------------------ | ------------------ | --------- |
| [93, 30, 55]             | [1, 30, 5]         | [2, 1]    |
| [95, 90, 99, 99, 80, 99] | [1, 1, 1, 1, 1, 1] | [1, 3, 2] |



#### 문제이해

progresses 배열에 speeds 배열의 값들을 더하며 첫 번째 작업이 완료되면 작업을 진행한횟수만큼 result를 더해주고 첫번째 작업을 제거하는 식으로 해서 작업이 남아있지 않을 경우까지 작업을 하면 된다.



#### 수도코드

1. 배포할 수 있는 작업의 수를 카운트 하는 변수 `completedWorkCount` 를 선언한다.
2. 작업이 남아 있으면 작업 속도를 작업 진도에 더해주는 일을 한다.
3. 첫 번째 작업이 완료 되었다면 해당 작업을 제거하고 `completedWorkCount` 를 카운트 한다.
4. 3을 반복하다 작업이 완료되지 않았으면 반복을 그만두고 배포할 수 있는 작업의 수를 정답 배열에 추가한다.
5. `completedWorkCount` (배포할 수 있는 작업의 수) 를 초기화 해준다. 2로 돌아간다.
6. 정답 배열을 반환한다.



#### 코드

```js
const solution = (progrsses, speeds) => {
  let answer = [];
  
  while (progresses.length > 0) {
    let completedWorkCount = 0;
    
    for (let i = 0; i < progresses.length - 1; i++) {
      progresses[i] += speeds[i];
    }
    
    while (progresses[0] >= 100) {
      progrsses.shift();
      speeds.shift();
     	completedWorkCount++;
    }
    
    if (completedWorkCount > 0) {
      answer.push(completedWorkCount);
    }
  }
  
  return answer;
}
```



