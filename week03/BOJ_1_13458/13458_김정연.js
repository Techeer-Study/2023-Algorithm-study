const input = require("fs").readFileSync("dev/stdin").toString().trim().split("\n");

const room = input[0];
const peopleArray = input[1].split(" ").map(Number);
const adminArray = input[2].split(" ").map(Number); 

let sum = 0;

for (let i = 0; i < room; i++) {
  const people = peopleArray[i]; 
  const admin1 = adminArray[0]; 
  const admin2 = Math.floor((people - admin1) / adminArray[1]); 

  if (people - admin1 <= 0) {
    sum += 1;
  } else {
    sum += (people - admin1) % adminArray[1] === 0 ? admin2 + 1 : admin2 + 2;
  }
}

console.log(sum);