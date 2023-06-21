// DFS 문제로, 어떻게 풀어야할지 잘 몰라 참고 하였습니다.
// 혹시 문제 이해 잘 하신분 설명좀 부탁드립니다 ㅜㅜ 

let fs = require("fs");
const input = fs.readFileSync("./dev/stdin").toString().split("\n");
 
const numbers = input[1].split(" ").map((e) => +e);
const operators = input[2].split(" ").map((e) => +e);

let max = -Infinity; 
let min = Infinity;
 
function operation(num1, num2, operator) {
  switch (operator) {
    case 0:
      return num1 + num2;
    case 1:
      return num1 - num2;
    case 2:
      return num1 * num2;
    case 3:
      const result =
        num1 >= 0 ? Math.floor(num1 / num2) : -Math.floor(-num1 / num2);
      return result;
  }
}
 
function dfs(index, result, operators) {
  if (index === numbers.length) {
    max = Math.max(max, result);
    min = Math.min(min, result);
  }
 
  for (let i = 0; i < 4; i++) {
    if (operators[i] > 0) {
      const newOpers = JSON.parse(JSON.stringify(operators));
      newOpers[i] -= 1;
      dfs(index + 1, operation(result, numbers[index], i), newOpers);
    }
  }
}
 
dfs(1, numbers[0], operators);
console.log(max ? max : 0);
console.log(min ? min : 0);