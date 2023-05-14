const fs = require('fs');
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const dx = [-1, 0, 1, 0]
const dy = [0, 1, 0,-1]
let A,B = map(int,input().split())
let N,M = map(int,input().split())
let command = []

for (let i in i+1){
    let x,y,d = input().split()
    if (d == "N")
        d = 0
    else if(d == "E")
        d = 1
    else if(d == "S")
        d = 2
    else
        d = 3
}

        console.log("OK")

// 모르겠어요...어려워요