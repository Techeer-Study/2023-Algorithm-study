from collections import deque
n, m, start = map(int, input().split())

graph = [ [0]*(n+1) for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a][b] = graph[b][a] = 1

visited = [False] * (n+1)
dfs_list =[]
bfs_list=[]

def bfs(start):
    q = deque()
    q.append(start)
    visited[start] = True
    while q:
        node = q.popleft()
        bfs_list.append(node)
        for i in range(1, n+1):
            if not visited[i] and graph[node][i] == 1:
                q.append(i)
                visited[i] = True


def dfs(start):
    visited[start] = True
    dfs_list.append(start)
    for i in range(1, n+1):
        if not visited[i] and graph[start][i] == 1:
            dfs(i)



dfs(start)
for i in dfs_list: print(i, end=" ")
print()

visited = [False] * (n+1)
bfs(start)
for i in bfs_list: print(i, end=" ")
