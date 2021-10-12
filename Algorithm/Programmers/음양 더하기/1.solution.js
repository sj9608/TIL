const absolutes = [1, 4, 7];
const signs = [true, false, true];
// rst 8

const solution = (absolutes, signs) => {
  return (answer = absolutes.reduce((acc, cur, i) =>
    signs[i] ? acc + cur : acc - cur
  ));
};

console.log(solution(absolutes, signs));
