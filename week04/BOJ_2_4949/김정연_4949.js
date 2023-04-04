const fs = require('fs');
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const ans = [];
for(let text of input){
    const stack = [];
    let isCompare = true; //비교
    if(text == ".") break;
    for(let i = 0; i < text.length; i++){
        if(text[i] == "[" || text[i] == "("){
            stack.push(text[i]); // 첫시작이 [, ( 이면 스택 추가
        }
        else if(text[i] == "]"){
            if(stack[stack.length - 1] == "["){
                stack.pop(); // ] 이고, 만약 바로 전 스택이 [이면 스택 빼기
            }
            else{
                isCompare = false;
                break;
            }
        }
        else if(text[i] == ")"){
            if(stack[stack.length - 1] == "("){
                stack.pop();
            }
            else{
                isCompare = false;
                break;
            }
        }
        else if(text[i] == ".") break;
    }
    if(stack.length > 0 || !isCompare) ans.push("no");
    else ans.push("yes");
}

console.log(ans.join("\n"));