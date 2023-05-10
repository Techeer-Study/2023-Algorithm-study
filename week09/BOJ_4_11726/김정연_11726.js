var count = Number(require('fs').readFileSync('/dev/stdin').toString());

const Box = {
    1:1,
    2:2
}

for(let i = 3; i <= count; i++){
    Box[i] = (Box[i-1] + Box[i-2]) % 10007;
}
console.log(Box[count])