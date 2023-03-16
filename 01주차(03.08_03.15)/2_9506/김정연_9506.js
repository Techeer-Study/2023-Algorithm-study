var fs = require("fs")
var input = fs.readFileSync("/dev/stdin").toString().split("\n")

let answer = ''
for(let i = 0; i <= input.length; i++) { //input 받은걸 순서대로 나열
    let sum = 0;
    let array = new Array(); //약수를 찾아서 넣는 배열
    if(input[i] == '-1') break; // input 값 중 -1 이 있다면 종료
    for(let k = 1; k < input[i]; k++) { // 본인을 포함하지 않는 약수를 찾는 반복문, k = 약수
        if(input[i] % k == 0) {	
            array[i] = k; //약수를 배열에 저장
            sum += k; // 약수들을 더한거를 사용자가 입력한 값과 비교하기위해
        }
    }

    if(sum != input[i]) {
        answer += input[i] + ' is NOT perfect.';
    } //완전수 확인하는 조건문
    else {
        answer += input[i] + ' = ' + array.join(' + ');
    } //약수들을 확인하는 조건문 
    console.log(answer);
}
