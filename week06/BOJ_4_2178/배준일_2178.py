import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int,input().rstrip().split())

graph = [list(map(int, input().rstrip())) for _ in range(N)]

def bfs(x, y):
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    q = deque()
    q.append((x, y))

    while q:
        a, b = q.popleft()
        
        for i in range(4):
            nx = dx[i] + a
            ny = dy[i] + b

            if 0<=nx<N and 0<=ny<M and graph[nx][ny] == 1:
                graph[nx][ny] = graph[a][b] + 1
                q.append((nx, ny))
    
    return graph[N-1][M-1]

print(bfs(0,0))