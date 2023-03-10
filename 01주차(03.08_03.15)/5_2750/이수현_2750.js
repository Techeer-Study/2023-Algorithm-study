// 2750 : 수 정렬하기
let input = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split('\n');

// 숫자의 개수 제거
input.shift();
// 숫자 오름 차순 정렬
input.sort((a, b) => a - b);

for (let i = 0; i < input.length; i++) {
  console.log(input[i]);
}
