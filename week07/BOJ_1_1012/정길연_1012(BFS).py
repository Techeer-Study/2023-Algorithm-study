# 뭉쳐져 있는 구역 찾기 - BFS or DFS 이용
    # BFS
    #   - visited 쓰려했는데, 굳이 쓸 필요없이, 0으로 만들어놓으면 탐색하지 않음

from collections import deque

    
# 뭉쳐져 있는 뭉탱이 찾기
def BFS(graph, a, b):
    q = deque()
    q.append((a,b))
    graph[a][b] = 0

    dx = [0,0,1,-1]
    dy = [1,-1,0,0]

    while(q):
        x, y = q.popleft()
        graph[x][y] = 0

        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if(nx < 0 or nx >= M or ny < 0 or ny >= N): continue
            if( graph[nx][ny] == 1):
                q.append((nx,ny))
                graph[nx][ny] = 0



T = int(input())

while(T): 
    M, N, K = map(int, input().split()) # M: 가로, N:세로, K:배추위치 개수  
    graph = [ [0] * N for _ in range(M) ]

    for i in range(K):
        a,b = map(int, input().split())
        graph[a][b] = 1
    
    cnt = 0
    for i in range(M):
        for j in range(N):
            if(graph[i][j] == 1):
                BFS(graph, i,j)
                cnt += 1

    print(cnt)
    T -= 1

