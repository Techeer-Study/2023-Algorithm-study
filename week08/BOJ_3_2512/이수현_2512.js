const input = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split('\n')
  .map((v) => v.split(' ').map((x) => +x));

const num = input[0][0];
const budget = input[1].sort((a, b) => {
  return a - b;
});
const total = input[2][0];
console.log(binarySearch(budget, total));

function binarySearch(arr, total) {
  let tempAnswer;
  let left = 0;
  let right = arr[arr.length - 1];
  let mid;
  while (left <= right) {
    mid = Math.floor((left + right) / 2);
    let sum = 0;
    arr.forEach((v, i) => {
      if (v < mid) {
        sum += v;
      } else {
        sum += mid;
      }
    });

    if (sum <= total) {
      left = mid + 1;
      tempAnswer = mid;
    } else {
      right = mid - 1;
    }
  }
  return tempAnswer;
}
