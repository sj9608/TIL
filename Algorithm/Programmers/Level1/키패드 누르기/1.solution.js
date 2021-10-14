const numbers = [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5];
const hand = "right";
// result : "LRLLLRLLRRL"

const getDistance = (target, pos) => {
  let distance = Math.abs(target[0] - pos[0]) + Math.abs(target[1] - pos[1]);

  return distance;
};

const solution = (numbers, hand) => {
  let answer = "";

  let numberPad = {
    0: [1, 3],
    1: [0, 0],
    2: [1, 0],
    3: [2, 0],
    4: [0, 1],
    5: [1, 1],
    6: [2, 1],
    7: [0, 2],
    8: [1, 2],
    9: [2, 2],
  };

  let left = [0, 3];
  let right = [2, 3];

  for (let index = 0; index < numbers.length; index++) {
    let leftDistance = getDistance(numberPad[numbers[index]], left);
    let rightDistance = getDistance(numberPad[numbers[index]], right);

    if (numbers[index] % 3 === 1) {
      answer += "L";
      left = numberPad[numbers[index]];
    } else if (numbers[index] % 3 === 0 && numbers[index] !== 0) {
      answer += "R";
      right = numberPad[numbers[index]];
    } else {
      if (leftDistance === rightDistance && hand === "right") {
        answer += "R";
        right = numberPad[numbers[index]];
      } else if (leftDistance === rightDistance && hand === "left") {
        answer += "L";
        left = numberPad[numbers[index]];
      }
      if (leftDistance > rightDistance) {
        answer += "R";
        right = numberPad[numbers[index]];
      } else if (leftDistance < rightDistance) {
        answer += "L";
        left = numberPad[numbers[index]];
      }
    }
  }

  return answer;
};
