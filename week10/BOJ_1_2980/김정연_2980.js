let input = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n").map((val) => val.trim());

function solution(input) {
  //input
  let [n, l] = input[0].split(" ").map((v) => +v);
  for (let i = 1; i < input.length; i++) {}

  let time = 0;
  let distance = 0;

  for (let i = 1; i <= n; i++) {
    let [D, R, G] = input[i].split(" ").map((v) => +v);

    time += D - distance;
    distance = D;
    let check = time % (R + G);
    if (check < R) {
      time += R - check;
    } else {
      continue;
    }
  }
  time += l - distance;

  console.log(time);
}
solution(input);