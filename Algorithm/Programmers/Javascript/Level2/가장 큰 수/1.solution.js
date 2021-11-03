// const numbers = [6, 10, 2];
// expected output : 6210

const solution = (numbers) => {
  let answer = numbers
    .map((a) => String(a))
    .sort((a, b) => b + a - (a + b))
    .join("");

  return answer[0] === "0" ? "0" : answer;
};

//  console.log(solution(numbers));
