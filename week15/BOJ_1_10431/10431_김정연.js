const inputFile = process.platform === 'linux' ? '/dev/stdin' : './input';
const [P, ...tests] = require('fs').readFileSync(inputFile).toString().trim()
  .split('\n')
  .map((line) => line.split(' ').map(Number));

const countMoves = function countTotalMovesCallback(prev, cur, index, height) {
  let moves = 0;

  for (let i = 0; i < index; i += 1) {
    if (height[i] > cur) moves += 1;
  }

  return prev + moves;
};

const sol = [];
tests.forEach((test) => {
  const [caseNo, ...height] = test;
  const moveCnt = height.reduce(countMoves, 0);
  sol.push(`${caseNo} ${moveCnt}`);
});

console.log(sol.join('\n'));