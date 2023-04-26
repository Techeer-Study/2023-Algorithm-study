const fs = require('fs');
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let N = Number(input[0].split(' ')[0])
let M = Number(input[0].split(' ')[1])
let R = Number(input[0].split(' ')[2])

const dfs = (N, M, R) => {
  
  let graph = {}

  for(let i = 1 ; i < N+1 ; i++){
    graph[i] = []  
  }

  for(let i = 1 ; i < M+1 ; i++){
    u = Number(input[i].split(' ')[0])
    v = Number(input[i].split(' ')[1])

    graph[u].push(v)
    graph[v].push(u)
  }

  for(let i =1 ; i < M+1 ; i++){
    if (graph[i]){
    graph[i].sort((a,b)=>{
      return a-b
    })
  }
  }

  const visited = new Array(N).fill(0); // [0, 0, 0, 0, 0] // 탐색을 마친 노드들
  let cnt = 1
  let needVisit = []; // 탐색해야할 노드들
    
  needVisit.push(R); // 노드 탐색 시작

  while (needVisit.length !== 0) { // 탐색해야할 노드가 남아있다면
    const node = needVisit.pop(); 
    if (visited[node-1] === 0 ) { // 해당 노드가 탐색된 적 없다면
      visited[node-1] = cnt; 
      cnt +=1

      needVisit.push(...graph[node]) // stack이니까 뒤에서 부터 빼줘야하니까 꺼구로 뒤집음. b와 c 중 b를 먼저
    }
  }
  return visited;

  };
  
console.log(dfs(N,M,R).join('\n'))