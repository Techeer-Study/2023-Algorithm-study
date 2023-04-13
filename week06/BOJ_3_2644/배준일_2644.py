import sys
from collections import deque
input = sys.stdin.readline

def bfs(v):
    q = deque()
    q.append(v)

    while q:
        now = q.popleft()

        for i in graph[now]:
            if visited[i] == -1:
                visited[i] = visited[now] + 1
                q.append(i)

N = int(input())
target_start, target_end = map(int,input().split())
graph = [[] for _ in range(N + 1)]
visited = [-1 for _ in range(N + 1)] # 초기값 -1으로 초기화

for _ in range(int(input())):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

visited[target_start] = 0 # 시작부분 0

bfs(target_start)
print(visited[target_end])