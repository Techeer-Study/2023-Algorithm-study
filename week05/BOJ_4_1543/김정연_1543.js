let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split("\n");
input[0] = input[0].split("");
let start = 0; 
let end = input[1].length;
let count = 0;

while(1) {
	if (input[0].slice(start, end).join("") === input[1]) {
		input[0].splice(start, input[1].length);
		count++;
	} else {
		start++;
		end++;
	}
	if (end > input[0].length) break;
}

console.log(count);