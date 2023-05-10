import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6) # 재귀 허용 깊이를 수동으로 늘려주는 코드

# dfs 탐색
def dfs(x, y):
    # 주어진 범위를 벗어나는 경우에 즉시 종료
    if x <= -1 or x >= m or y <= -1 or y >= n:
        return False

    # 현재 노드를 아직 방문하지 않았다면
    if graph[x][y] == 0:
        # 해당 노드 방문 처리 (전류 이동)
        graph[x][y] = 2

        # 상, 하, 좌, 우의 위치들도 모두 재귀적으로 호출
        dfs(x - 1, y)
        dfs(x, y - 1)
        dfs(x + 1, y)
        dfs(x, y + 1)

        return True
    return False


m, n = map(int, input().rstrip().split())

# 2차원 리스트의 맵 정보를 입력 받는다.
graph = []
for _ in range(m):
    graph.append(list(map(int, input().rstrip())))

# 바깥쪽에서 전류가 흐르면 안쪽까지 침투하는지 DFS 탐색으로 수행
for i in range(n):
    dfs(0, i)

# 2차원 리스트 안쪽에 침투한 전류가 있다면 YES 출력 없다면 NO 출력
if graph[m - 1].count(2):
    print("YES")
else:
    print("NO")