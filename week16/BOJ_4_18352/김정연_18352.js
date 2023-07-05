//https://velog.io/@jiyaho/%EB%B0%B1%EC%A4%80-18352-%ED%8A%B9%EC%A0%95-%EA%B1%B0%EB%A6%AC%EC%9D%98-%EB%8F%84%EC%8B%9C-%EC%B0%BE%EA%B8%B0-Node.js-BFS-%ED%92%80%EC%9D%B4
const input = require('fs').readFileSync("./dev/stdin").toString().trim().split('\n');
const [N, M, K, X] = input.shift().split(' ').map(Number);
const arr = input.map((v) => v.split(' ').map(Number));
const graph = [...Array(N + 1)].map(() => []);
const distance = Array(N + 1).fill(0); // 도로의 거리를 카운트하면서 방문 체크에 이용할 배열
let answer = [];

// 단방향 그래프 만들기
arr.map(([from, to]) => graph[from].push(to));

const bfs = (start) => {
  const queue = [start];
  distance[start] = 1; //bfs 거리 start

  while (queue.length) {
    const now = queue.shift();
    if (distance[now] == K + 1) {
      answer.push(now);
      continue;
    }
    for (const next of graph[now]) {
      if (!distance[next]) {
        queue.push(next);
        distance[next] = distance[now] + 1;
      }
    }
  }
};

bfs(X);
if (answer.length) {
  answer = answer.sort((a, b) => a - b).join('\n');
} else answer = -1;

console.log(answer);