const numbers = [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5];
const hand = "right";
// result : "LRLLLRLLRRL"

function solution(numbers, hand) {
  hand = hand[0] === "r" ? "R" : "L";
  let position = [1, 4, 4, 4, 3, 3, 3, 2, 2, 2];
  let h = { L: [1, 1], R: [1, 1] };
  return numbers
    .map((x) => {
      if (/[147]/.test(x)) {
        h.L = [position[x], 1];
        return "L";
      }
      if (/[369]/.test(x)) {
        h.R = [position[x], 1];
        return "R";
      }
      let distL = Math.abs(position[x] - h.L[0]) + h.L[1];
      let distR = Math.abs(position[x] - h.R[0]) + h.R[1];
      if (distL === distR) {
        h[hand] = [position[x], 0];
        return hand;
      }
      if (distL < distR) {
        h.L = [position[x], 0];
        return "L";
      }
      h.R = [position[x], 0];
      return "R";
    })
    .join("");
}
console.log(solution(numbers, hand));
