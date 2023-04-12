//https://nyang-in.tistory.com/283
let fs = require("fs");
let input = fs.readFileSync("dev/stdin").toString().split("\n");
let cost = BigInt(0); // BigInt는 길이의 제약 없이 정수를 다룰 수 있게 해주는 숫자형
const N = Number(input[0]); // N: 도시의 개수
const distance = input[1].trim().split(" ").map((element) => BigInt(element)); 
// distance: 각 도시 사이의 도로 길이

let city = input[2].trim().split(" ").map((element) => BigInt(element)); 
// city : 도시마다 주유소의 리터당 가격

let lowestPrice = city[0]; // 처음에는 맨 처음 값을 최저가를 지정
for (let i = 0; i < city.length - 1; i++) {
  if (lowestPrice > city[i]) {
    //  현재 값이 최저가보다 작다면 최저가를 갱신해준다.
    lowestPrice = city[i];
  }
  cost += lowestPrice * distance[i];
}
console.log(cost.toString());