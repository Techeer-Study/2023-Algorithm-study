const fs = require('fs');
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
//node.js 입력

const N = +input.shift(); //N = 가로 세로 크기 , shift() = 배열의 맨앞 값 제거
const M = +input.shift(); //M = 간선의 개수

const G = Array.from(Array(N + 1), () => []);
const V = Array.from(Array(N + 1), () => false);
V[1] = true; //방문 했을 경우 1 
let count = 0; //총 방문한 횟수 

for (let i = 0; i < M; i++) {
  const [first, second] = input[i].split(" ").map(Number);
  G[first].push(second);
  G[second].push(first);
}

const dfs = (start) => {
  for (let i of G[start]) { //graph를 순회
    if (V[i] === false) { //방문하지 않은 노드를 만나면 count를 +1 해주고 방문처리
      V[i] = true;
      count++;
      dfs(i);
    }
  }
};

dfs(1);

console.log(count); //방문횟수 출력