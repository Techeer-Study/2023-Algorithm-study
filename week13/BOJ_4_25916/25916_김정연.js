// :: 참고 :: 
const INPUT_FILE = process.platform === 'linux' ? '/dev/stdin' : './input';
const [holeCount, maxSize, ...holes] = require('fs').readFileSync(INPUT_FILE).toString().trim().split(/\s/).map(Number);

let curSize = 0;
let left = 0;
let right = -1;
let MaxSize = 0; //최대 사이즈

while (right <= holeCount) {
  right += 1;
  curSize += holes[right];

  while (curSize > maxSize && left <= right) {
    curSize -= holes[left];
    left += 1;
  }

  if (curSize > MaxSize) MaxSize = curSize;
}

console.log(MaxSize);