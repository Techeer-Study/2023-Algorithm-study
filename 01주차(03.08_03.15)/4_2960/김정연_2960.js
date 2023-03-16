const input = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split(' ');

const N = Number(input[0]);
const K = Number(input[1]);
const numbers = new Array(Number(input[0]) + 1);
let pN;
const count = [];
for (let i = 2; i < numbers.length; i++) {
  numbers[i] = i;
}
for (let i = 2; i <= N; i++) {
  if (numbers[i] !== 0) {
    pN = i;
    numbers[i] = 0;
    count.push(i);
    for (let j = i + i; j <= N; j += i) {
      if (numbers[j] === 0) {
        continue;
      }
      numbers[j] = 0;
      count.push(j);
    }
  } else {
    continue;
  }
}
console.log(count[K - 1]);