let [n, ...ropes] = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split('\n');
ropes = ropes.map((i) => +i);
ropes.sort((a, b) => a - b);
let min = ropes[0] * n;
for (let i = 1; i < n; i++) {
  weight = ropes[i] * (n - i);
  if (min < weight) min = weight;
}
console.log(min);
