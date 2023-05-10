//https://velog.io/@ywc8851/%EB%B0%B1%EC%A4%80-18353-%EB%B3%91%EC%82%AC-%EB%B0%B0%EC%B9%98%ED%95%98%EA%B8%B0-javascript

const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

let n = Number(input[0]);
let nums = new Array(n);
let dp = new Array(n + 1).fill(1);
nums = input[1].split(" ").map(Number);
nums.reverse();
// 최장 증가 부분 수열
for (let i = 1; i < n; i++) {
  for (let j = 0; j <= i; j++) {
    if (nums[i] > nums[j]) {
      dp[i] = Math.max(dp[i], dp[j] + 1);
    }
  }
}
let ans = 0;
for (let i = 0; i <= n; i++) {
  ans = Math.max(ans, dp[i]);
}
console.log(n - ans);