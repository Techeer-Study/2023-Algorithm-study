import sys
input = sys.stdin.readline
from collections import deque

n, m, v = map(int, input().rstrip().split()) # 정점, 간선, 시작번호
graph = [[] for _ in range(n + 1)]

visited = [0 for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().rstrip().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(len(graph)):
    graph[i].sort()

def bfs(v):
    visited[v] = True
    q = deque()
    q.append(v)

    while q:
        now = q.popleft()
        print(now, end = ' ')

        for i in graph[now]:
            if not visited[i]:
                q.append(i)
                visited[i] = True

def dfs(v):
    visited[v] = True
    print(v, end = ' ')

    for i in graph[v]:
        if not visited[i]:
            dfs(i)
            visited[i] = True


bfs(v)

visited = [0 for _ in range(n + 1)]
print()

dfs(v)
