lottos = [44, 1, 0, 0, 31, 25];
win_nums = [31, 10, 45, 1, 6, 19];
// rst [3, 5]

const binarySearch = (array, target) => {
  let left = 0;
  let right = array.length - 1;
    
  while (left <= right) {
    let mid = parseInt((left + right) / 2);

    if (array[mid] === target) {
      return array[mid];
    }
    else if (array[mid] < target) {
      left = mid + 1;
    }
    else if (array[mid] > target) {
      right = mid - 1;
    }
  }
  return -1;
}

const solution = (lottos, win_nums) => {
  let answer = '';

  lottos.sort();
  for (number in win_nums) {
    if (binarySearch(lottos, number)) {

    }
  }

  return answer;
}

console.log(solution(lottos, win_nums));
