function solution(s) {
	let numbers = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
	answer = s;
	
	for (let i = 0; i < numbers.length; i++) {
		let arr = answer.split(numbers[i]);
		// console.log(`after split '${numbers[i]}': ${arr}`);
		// console.log(`before join ${i} : ${arr}`);
		answer = arr.join(i);
		// console.log(`after join ${i} : ${answer}`);
		// console.log('');
	}
	
	return Number(answer);
}

// s = "one4seveneight" // result 1478
// console.log(`input: ${s} , rst : 1478`);