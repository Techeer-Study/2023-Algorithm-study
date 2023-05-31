const fs = require("fs");
const [T, ...input] = fs.readFileSync('/dev/stdin').toString().split("\n").map( v => v.split(" ").map(Number));

let number = input.splice(0);
let result = [];

for (let i = 0; i < T; i++) {
    let N = number[0][0];
    let M = number[0][1];
    number.shift();

    for(let j = 0; j < M; j++) {
        number.shift();
    };

    result.push(N - 1);
};

console.log(result.join("\n"));