// https://github.com/WEB-FE-STUDY/Algorithm 
// 모르겠어서 참고
const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});
const input = [];

const dx = [0, 1, -1, 0];
const dy = [1, 0, 0, -1];

const solution = (input) => {
  const BFS = (map, N) => {
    const visited = Array.from(Array(N), () => new Array(N).fill(Infinity));

    const q = [];
    visited[0][0] = map[0][0];
    q.push([0, 0]);
    let idx = 0;

    while (idx !== q.length) {
      const [x, y] = q[idx];

      for (let dir = 0; dir < 4; dir++) {
        const [nx, ny] = [x + dx[dir], y + dy[dir]];

        if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
        if (visited[x][y] + map[nx][ny] < visited[nx][ny]) {
          // 최솟값 저장
          visited[nx][ny] = visited[x][y] + map[nx][ny];
          q.push([nx, ny]);
        }
      }
      idx++;
    }

    console.table(visited);

    return visited[N - 1][N - 1];
  };

  let caseNumber = 0;

  while (input.length) {
    caseNumber++;
    const N = Number(input.shift());

    if (N === 0) break;

    const map = [];

    for (let i = 0; i < N; i++) {
      map.push(input.shift().split(" ").map(Number));
    }

    console.log(`Problem ${caseNumber}: ${BFS(map, N)}`);
  }
};

rl.on("line", (answer) => {
  input.push(answer.trim());
}).on("close", () => {
  solution(input);
});