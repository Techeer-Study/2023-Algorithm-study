T = int(input())

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def DFS(x, y):
    for i in range(4):
        nx = dx[i] + x
        ny = dy[i] + y
        if(nx < 0 or nx >= M or ny < 0 or ny >= N): continue
        if graph[nx][ny]== 1:
            graph[nx][ny] = 0
            DFS(nx, ny)

while(T):
    T -= 1
    M, N, K = map(int, input().split())  # M: 가로, N:세로, K:배추위치 개수  
    graph = [ [0]* N for _ in range(M) ]

    for i in range(K):
        a, b = map(int, input().split())
        graph[a][b] = 1

    cnt = 0
    for i in range(M):
        for j in range(N):
            if(graph[i][j]==1):
                DFS(i,j)
                cnt += 1

    print(cnt)


