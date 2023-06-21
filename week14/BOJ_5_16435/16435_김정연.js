const fs = require('fs');
const input = fs.readFileSync('example.txt').toString().split('\n');

let [N,L] = input[0].split(' ').map(n => parseInt(n));
const hArr = input[1].split(' ').sort((a,b)=>a-b);

for(let i = 0; i < N; i++){
    if(L >= hArr[i]){
        L++
    }
    else {
        break;
    }
}

console.log(L);

// let [N, init] = input[0].split(' ').map(n => parseInt(n));
// let arr = input[1].split(' ').sort((a,b)=>a-b);

// for(let i=0; i<N; i++){
//     if(arr[i]<=init){
//         init++
//     }else{
//         break;
//     }
// }
// console.log(init)