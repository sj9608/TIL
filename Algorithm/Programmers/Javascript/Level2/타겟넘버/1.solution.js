const numbers = [1, 1, 1, 1, 1];
const target = 3;
// return 5}

const solution = (numbers, target) => {
  let answer = 0;

  const dfs = (depth, sum) => {
    if (depth === numbers.length) {
      if (sum === target) {
        answer += 1;
      }
      return;
    }

    dfs(depth + 1, sum + numbers[depth]);
    dfs(depth + 1, sum - numbers[depth]);
  };

  dfs(0, 0);

  return answer;
};

console.log(solution(numbers, target));
