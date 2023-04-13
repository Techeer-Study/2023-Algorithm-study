import sys
input = sys.stdin.readline
from collections import deque

com = int(input().rstrip())
connect = int(input().rstrip())
graph = [[] for _ in range(com + 1)]
visited = [0] * (com + 1)


for _ in range(connect):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def bfs(v):
    cnt = 0
    visited[v] = True
    q = deque()
    q.append(v)

    while q:
        now = q.popleft()

        for i in graph[now]:
            if not visited[i]:
                q.append(i)
                visited[i] = True
                cnt += 1
    return cnt

print(bfs(1))
