lottos = [44, 1, 0, 0, 31, 25];
win_nums = [31, 10, 45, 1, 6, 19];
// rst [3, 5]

const solution = (lottos, win_nums) => {
  let answer = '';

  let correct = lottos.filter(lotto => win_nums.includes(lotto)).length;
  console.log(`correct is : ${correct}`);

  let zeros = lottos.filter(lotto => lotto === 0).length;
  console.log(`zeros is : ${zeros}`);

  let min = 7 - correct > 6 ? 6 : 7 - correct;
  let max = min - zeros < 1 ? 1 : min - zeros;
  
  answer = [max, min];
  return answer;
}

console.log(solution(lottos, win_nums));