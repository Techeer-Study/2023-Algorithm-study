import sys
input = sys.stdin.readline
from collections import deque

N, M = map(int, input().rstrip().split()) # 정점, 간선
graph = [[] for _ in range(N+1)]
visited = [False for _ in range(N+1)]

for _ in range(M):
    u, v = map(int, input().rstrip().split())
    graph[u].append(v)
    graph[v].append(u)

def bfs(start):
    deq = deque([start])
    visited[start] = True

    while deq:
        node = deq.popleft()
        
        for next_node in graph[node]:
            if not visited[next_node]:
                visited[next_node] = True
                deq.append(next_node)
        
count = 0

for i in range(1, N + 1):
    if not visited[i]:  # 만약 방문하지 않았다면
        if not graph[i]:  # 만약 그래프가 비어있다면
            count += 1  # 연결요소 1개 추가
            visited[i] = True  # 방문 처리
        else:  # 만약 그래프가 비어있지 않다면(어느 점과 연결된 점이 있다면)
            bfs(i)  # 해당 i를 시작노드로 bfs를 돈다. bfs가 끝나면 연결요소의 방문이 끝난거다.
            count += 1  # 연결요소 +1개 해준다.

print(count)
