let ipt = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split('\n');

let [N, M] = ipt[0].split(' ').map((v) => +v);
let A = ipt[1].split(' ').map((v) => +v);

let st = 0;
let ed = 0;
let n = 0;

let ans = 0;
for (let i = 0; i < N; i++) {
  if (A[i] > M) {
    st = i + 1;
    ed = i + 1;
    n = 0;
    continue;
  }

  while (n + A[i] > M) {
    n -= A[st++];
  }

  n += A[i];
  ed++;

  ans = Math.max(ans, n);
}
console.log(ans);
