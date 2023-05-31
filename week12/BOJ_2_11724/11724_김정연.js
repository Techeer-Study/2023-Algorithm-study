//https://lhoiktiv.tistory.com/252
const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().trim().split("\n");

class Node {
  constructor(item) {
    this.item = item;
    this.next = null;
  }
}

class Queue {
  constructor() {
    this.head = null;
    this.tail = null;
    this.length = 0;
  }

  push(item) {
    const node = new Node(item)
    if (this.head === null) {
      this.head = node;
    } else {
      this.tail.next = node;
    }
    this.tail = node;
    this.length += 1;
  }

  pop() {
    const popItem = this.head.item;
    this.head = this.head.next;
    this.length -= 1;
    return popItem;
  }
}

const edge = input.map(v => v.split(' ').map(v => +v))
const [N, E] = edge.shift();
let adj = Array.from(Array(N + 1), () => []);
let isVisited = new Array(N + 1).fill(false)

edge.forEach(x => {
  const [u, v] = x;
  adj[v].push(u);
  adj[u].push(v);
})

let connect = 0;
let q = new Queue();
for (let i = 1; i <= N; i++) {
  if (!isVisited[i]) {
    isVisited[i] = true;
    connect++;
    q.push(i);
    while (q.length > 0) {
      let now = q.pop();
      adj[now].forEach(v => {
        if (!isVisited[v]) {
          q.push(v);
          isVisited[v] = true;
        }
      })
    }
  }
}

console.log(connect)