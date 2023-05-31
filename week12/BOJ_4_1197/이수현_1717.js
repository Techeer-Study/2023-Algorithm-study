const rl = require('readline').createInterface({
  input: process.stdin,
  output: process.stdout,
});

const input = [];
rl.on('line', function (line) {
  input.push(line.split(' ').map(Number));
}).on('close', function () {
  solution(input.shift(), input);
  process.exit();
});

function solution([V, E], costs) {
  let count = 0;
  const sortedCosts = costs.sort((a, b) => a[2] - b[2]);
  const parent = Array.from({ length: V }, (_, i) => i);

  const find = (parent, x) => {
    if (parent[x] === x) return x;
    return (parent[x] = find(parent, parent[x])); //경로 압축
  };

  const union = (parent, a, b) => {
    a = find(parent, a);
    b = find(parent, b);
    if (a < b) parent[b] = a;
    else parent[a] = b;
  };

  const compare = (parent, a, b) => {
    a = find(parent, a);
    b = find(parent, b);
    return a === b;
  };

  for (const [a, b, cost] of sortedCosts) {
    if (!compare(parent, a, b)) {
      count += cost;
      union(parent, a, b);
    }
  }
  console.log(count);
}
