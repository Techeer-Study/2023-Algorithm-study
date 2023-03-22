let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\r\n');

const a = Number(input[0].split(" ")[0]);
const b = Number(input[0].split(" ")[1]);
const c = Array(b+1).fill(true);
c[1] = false;

for(let i = 2; i * i <= b; i++){
    for (let j = i * i; j <= b; j+= i){
        c[j] = false;
    }
}
    for (let i = a; i<= b; i++){
        if(c[i] === true) console.log(i);
    }


