# 메모리 초과 에러.. 
# import sys 
# sys.setrecursionlimit(10000) 

# N, M, R = map(int, input().split())     # N: 정점, M: 간선, R: 출발 정점

# graph = [ [0] * (N+1) for _ in range(N+1) ]
# for i in range(M):
#     a, b = map(int, input().split())
#     graph[a][b] = graph[b][a] = 1

# dfs_list = [0] * (N+1)

# def DFS(node):
#     dfs_list[node]=node
#     for i in range(1, len(graph[node])):
#         if(graph[node][i] == 1):
#             graph[node][i] = graph[i][node] = 0
#             DFS(i)

# DFS(R)

# for i in range(1, len(dfs_list)):
#     print(dfs_list[i])



N, M, R = map(int, input().split())     # N: 정점, M: 간선, R: 출발 정점
graph = [ [] for _ in range(N+1) ]
dfs_list = [0] * (N+1)

for _ in range(M):
    a,b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1, len(graph)):
    graph[i].sort

def DFS(start):
    dfs_list[start] = start
    
    for node in graph[start]:
        graph[start].remove(node)
        graph[node].remove(start)
        DFS(node)
    return 

DFS(R)
for i in range(1,len(dfs_list)):
    print(dfs_list[i])
