//잘 모르겠어서 참조
const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().trim().split("\n").map(v=>v.split(' '));
const [L,C] = input.map(Number);
const alpha = input[1].sort();

const answer =[];
function solution(s,k){
    let S = s.length;
    if(S==L){
        let cnt = 0;
        for(let i = 0; i<S; i++){
            if(s[i]=='a' || s[i]=='e' || s[i]=='i' || s[i]=='o' || s[i]=='u'){
                cnt++;
            }
        }
        if(cnt > 0 && L-cnt>1){
            answer.push(s);
        }
            return;
        }else{
                for(let i = k +1; i<C; i++){
                    solution(s+alpha[i],i);
                }
            }
        }
        solution('',-1);
        console.log(answer.join('\n'));