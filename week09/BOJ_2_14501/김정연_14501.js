var input = require('fs').readFileSync('/dev/stdin').toString().split('\n');

const solution = (N, counseling) => {
  const DP = new Array(N).fill(0);

  for (let i = 0; i < N; i++) {
    const [cost, profit] = counseling[i];
    if (i + cost > N) continue;
    DP[i] = DP[i] + profit;
    for (let j = i + cost; j < N; j++) {
      DP[j] = Math.max(DP[j], DP[i]);
    }
  }
  return Math.max(...DP);
};

const N = Number(input[0]);
const counseling = input
  .slice(1)
  .map((v) => v.split(' ').map((v) => Number(v)));
console.log(solution(N, counseling));