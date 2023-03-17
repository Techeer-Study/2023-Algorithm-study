// 2609 : 최대공약수와 최소공배수

const input = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split(' ');

let a = input[0];
let b = input[1];

while (a % b !== 0) {
  let n = a % b;
  if (n !== 0) {
    a = b;
    b = n;
  }
}
console.log(b);
console.log((input[0] * input[1]) / b);
