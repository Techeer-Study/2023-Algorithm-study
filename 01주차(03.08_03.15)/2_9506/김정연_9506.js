var fs = require("fs")
var input = fs.readFileSync("/dev/stdin").toString().split("\n")

let answer = ''
let sum = 0;
let index = 0;	
let array = new Array();
    for(let i = 1; i <= input.length; i++) {
        if(input[i] == -1) break;
    }
    for(let k = 1; k < input[i]; k++) {
		if(input[i] % k == 0) {	
            array[i] = k;
            sum += i;
    }
    if(sum != input[i]) {
		    answer += input[i] + ' is NOT perfect.';
	}
    else {
            answer += input[i] + ' = ' + array.join(' + ');
    }
    console.log(answer);
   }