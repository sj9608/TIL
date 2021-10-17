const n = 17;

const solution = (n) => {
  let answer = "";
  let str = "412";

  while (n) {
    answer = str[n % 3] + answer;
    n = n % 3 ? Math.floor(n / 3) : n / 3 - 1;
  }

  return answer;
};

console.log(solution(n));
