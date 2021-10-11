let board = [
  [0, 0, 0, 0, 0],
  [0, 0, 1, 0, 3],
  [0, 2, 5, 0, 1],
  [4, 2, 4, 4, 2],
  [3, 5, 1, 3, 1],
];
let moves = [1, 5, 3, 5, 1, 2, 1, 4];
// result 4

const solution = (board, moves) => {
  let result = 0;
  let basket = [];

  moves.forEach((order) => {
    const doll = pickup(board, order - 1);
    if (doll) {
      if (basket[basket.length - 1] === doll) {
        basket.pop();
        result += 2;
      } else {
        basket.push(doll);
      }
    }
  });

  return result;
};

const pickup = (board, orders) => {
  for (let i = 0; i < board.length; i++) {
    if (board[i][orders] !== 0) {
      const doll = board[i][orders];
      board[i][orders] = 0;
      return doll;
    }
  }
};

console.log(solution(board, moves));
