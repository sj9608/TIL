const new_id = "...!@BaT#*..y.abcdefghijklm";

const solution = (new_id) => {
  let answer = new_id
    .toLowerCase()
    .replace(/[^\w-_.]/g, "")
    .replace(/\.{2,}/g, ".")
    .replace(/^\.|\.$/g, "")
    .replace(/^$/, "a")
    .slice(0, 15)
    .replace(/\.$/, "");

  if (answer.length >= 16) {
    return answer;
  }

  while (answer.length <= 2) {
    answer += answer.charAt(answer.length - 1);
  }

  return answer;
};

console.log(solution(new_id3));
