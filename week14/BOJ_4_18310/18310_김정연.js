const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

rl.question('', (N) => {
  rl.question('', (input) => {
    const house = input.trim().split(' ').map(Number);
    house.sort((a, b) => a - b);
    console.log(house[Math.floor((N - 1) / 2)]);
    rl.close();
  });
});
