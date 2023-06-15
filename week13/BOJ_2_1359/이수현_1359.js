const fs = require('fs');
let [n, m, k] = fs
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split(' ')
  .map(Number);
let com = new Array(9);
let ans = 0;
com[0] = [1, 0];
for (let i = 1; i <= 8; i++) {
  com[i] = [];
  com[i][0] = 1;
  com[i][i] = 1;
  for (let j = 1; j < i; j++) {
    com[i][j] = com[i - 1][j - 1] + com[i - 1][j];
  }
}
for (let i = k; i <= m; i++) {
  if (n - m >= m - i) ans += com[m][i] * com[n - m][m - i];
}
ans /= com[n][m];
if (ans == 1) ans = '1.0';
console.log(ans);
