let input = require('fs').readFileSync('./dev/stdin').toString().split(' ');

function solution(input) {
  let cnt = 0;
  let idx = 0;
  let first = true;
  const word = ["q", "u", "a", "c", "k"];
  const visited = Array(input.length).fill(false);

  if (input.length % 5 !== 0) return -1;

  for (let i = 0; i < input.length; i++) {
    if (input[i] === "q" && !visited[i]) {
      first = true; //탐색

      for (let j = i; j < input.length; j++) {
        if (word[idx] === input[j] && !visited[j]) {
          visited[j] = true;

          if (input[j] === "k") {
            if (first) {
              cnt += 1;
              first = false;
            }
            idx = 0;
            continue;
          }

          idx += 1;
        }
      }
      console.log(cnt);
      console.log(visited);
    }
  }
  console.log(cnt);
}

solution(input);