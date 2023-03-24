let input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
let a = +input.shift(); 
let target = input.shift()


const solution = (a) => {
  let answer = [];
  let visited = new Array(a + 1).fill(0);
  let tmp = [];
  const dfs = (cnt) => {
    if (cnt === a) {
      answer.push(tmp.join(" "));
    } else {
      for (let i = 1; i <= a; i++) {
        if (!visited[i]) {
          visited[i] = 1;
          tmp.push(i);
          dfs(cnt + 1);
          tmp.pop();
          visited[i] = 0;
        }
      }
    }
  };
  dfs(0);

  return answer.join("\n");
};

console.log(solution(a, target));