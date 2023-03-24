const fs = require('fs');
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const input2 = input.map(Number);

const a = input2[0];
for(i = 1; i<= a; i++){
    const b = input2[i].toString(2);
    const c = [...b].reverse();
    
    let answer = [];
    
    for(let j = 0; j < c.length; j++ ){
        if(c[j] === '1'){
            answer.push(j);
        }
    }
    console.log(answer.join(" "));
}