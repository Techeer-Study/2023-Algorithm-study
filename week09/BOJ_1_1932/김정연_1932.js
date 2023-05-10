//https://wonyoung2257.tistory.com/36
const input = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n");
let n = +input.shift();

let dp = input.map((x) => x.split(" ").map((e) => +e));

for (let i = 1; i < n; i++) {
  for (let j = 0; j < dp[i].length; j++) {
    if (j == 0) dp[i][j] += dp[i - 1][j];
    else if (j == dp[i].length - 1) dp[i][j] += dp[i - 1][j - 1];
    else dp[i][j] += Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
  }
}

console.log(Math.max(...dp[n - 1]));