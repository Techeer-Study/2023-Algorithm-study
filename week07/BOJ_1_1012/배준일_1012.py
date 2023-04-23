import sys 
input = sys.stdin.readline
from collections import deque

def bfs(a, b):
    q = deque([(a, b)])
    graph[a][b] = 0 # 0으로 초기화
    
    while q:
        x, y = q.popleft()
        
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            
            if 0<= nx < n and 0<= ny < m and graph[nx][ny] == 1:
                q.append((nx, ny))
                graph[nx][ny] = 0
    

T = int(input().rstrip())
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for _ in range(T):
    worm = 0
    n, m, k = map(int, input().rstrip().split())
    graph = [[0] * m for _ in range(n)] # 배추밭
    
    for i in range(k):
        x, y = map(int, input().rstrip().split())
        graph[x][y] = 1 # 배추 표시

    for i in range(n):
        for j in range(m):
            if graph[i][j] == 1: # 배추일 때
                bfs(i, j)
                worm += 1
                
    print(worm)
                    