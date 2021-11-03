const solution = (numbers) => {
  let answer = [];

  for (let i = 0; i < numbers.length; i++) {
    for (let j = i + 1; j < numbers.length; j++) {
      const sum = numbers[i] + numbers[j];
      if (answer.includes(sum)) continue;
      else answer.push(sum);
    }
  }

  answer.sort((a, b) => a - b);

  return answer;
};
