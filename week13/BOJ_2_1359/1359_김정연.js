// Java 코드 참고후 js로 풀이
const readline = require('readline');

function main() {
  const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
  });

  rl.on('line', (input) => {
    const [N, M, K] = input.trim().split(' ').map(Number);

    // 뽑기
    const choice = comb(N, M);

    // 당첨 뽑기
    const win = winComb(N, M, K);

    console.log(win / choice);
    rl.close();
  });
}

function comb(n, r) {
  // 기저 조건
  if (n === r || r === 0) return 1;

  // nCr = n-1Cr-1 + n-1Cr
  return comb(n - 1, r - 1) + comb(n - 1, r);
}

function winComb(n, r, k) {
  // 당첨된 경우: 최소 k개 일치(k개 일치 + (k + 1)개 일치 + ... + r개 일치)
  let cnt = 0;

  for (let i = k; i <= r; i++) {
    if (n - r < r - i) continue; // 쉽게 말해 NCR에서 N < R이면 패쓰!

    // r개 중 k개를 뽑고, 나머지(n-r) 중 r-k개를 뽑는다.
    cnt += comb(r, i) * comb(n - r, r - i);
  }

  return cnt;
}

main();
