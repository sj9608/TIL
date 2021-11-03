const progresses = [95, 90, 99, 99, 80, 99];
const speeds = [1, 1, 1, 1, 1, 1];
// rst [1, 3, 2]

const solution = (progresses, speeds) => {
  let answer = [];

  while (progresses.length > 0) {
    let completedWorkCount = 0;

    for (let i = 0; i < progresses.length; i++) {
      progresses[i] += speeds[i];
    }

    while (progresses[0] >= 100) {
      progresses.shift();
      speeds.shift();
      completedWorkCount++;
    }

    if (completedWorkCount > 0) {
      answer.push(completedWorkCount);
    }
  }

  return answer;
};

console.log(solution(progresses, speeds));
