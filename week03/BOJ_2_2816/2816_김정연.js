let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');
let N = parseInt(input.shift());

let index1 = input.indexOf('KBS1');
let index2 = input.indexOf('KBS2');
index2 = index1 > index2 ? ++index2 : index2;

let result = '';

for(let i = 0; i < index1; i++){
    result += '1';
}
for(let i = 0; i < index1; i++){
    result += '4';
}
for(let i = 0; i < index2; i++){
    result += '1';
}
for(let i = 0; i < index2-1; i++){
    result += '4';
}
console.log(result);

