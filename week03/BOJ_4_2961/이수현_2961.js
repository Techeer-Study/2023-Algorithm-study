// 2961 : 도영이가 만든 맛있는 음식
// https://velog.io/@aurpo1/%EB%B0%B1%EC%A4%80-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-2961%EB%B2%88-%EB%8F%84%EC%98%81%EC%9D%B4%EA%B0%80-%EB%A7%8C%EB%93%A0-%EB%A7%9B%EC%9E%88%EB%8A%94-%EC%9D%8C%EC%8B%9D-node.js

const input = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split('\n');
const n = Number(input.shift());
const flavor = [];

for (let i = 0; i < n; i++) {
  flavor.push(input[i].split(' ').map(Number));
}

// 재료의 조합 (1개, 2개, 3개 ...)
let combi = [];
// 신맛과 쓴맛의 차이
let diff = Math.abs(flavor[0][0] - flavor[0][1]);
let visited = Array(n).fill(false);

// 재료의 조합을 만드는 함수
// cnt는 섞을 재료의 개수를 정하는 인자
const makeCombi = (start, num, cnt) => {
  if (num === cnt) {
    let sour = 1;
    let bitter = 0;
    combi.map((el) => {
      sour *= flavor[el][0];
      bitter += flavor[el][1];
    });
    if (diff > Math.abs(sour - bitter)) diff = Math.abs(sour - bitter);
    return;
  }
  for (let i = start; i < n; i++) {
    if (!visited[i]) {
      visited[i] = true;
      combi.push(i);
      makeCombi(i, num + 1, cnt);

      visited[i] = false;
      combi.pop();
    }
  }
};

// 재료의 개수만큼 조합을 찾아서 차이를 계산한다.
for (let i = 1; i <= n; i++) {
  makeCombi(0, 0, i);
}
console.log(diff);
