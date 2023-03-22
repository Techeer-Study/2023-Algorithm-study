const fs = require('fs');
const input = Number(fs.readFileSync("/dev/stdin"));

function fib(input) {
    if(input === 0){
        return 0;
    }
    if(input === 1){
        return 1;
    }
    return fib(input-1) + fib(input-2);
}
console.log(fib(input));