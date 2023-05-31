import sys
from collections import deque 

def bfs(x):
    # 들려야 할 정점 저장
    queue = deque([x])

    # 현재 노드 방문 처리
    visited[x] = 1
    cnt = 0

    # 큐가 없을때까지 반복
    while queue:

        # 큐에서 하나의 원소를 팝
        queue.popleft()

        # 모든 국가가 연결되어 있으므로 모든 국가 확인
        for i in range(1, n + 1):
            if visited[i] == 0:
                queue.append(i)
                visited[i] = 1
                cnt += 1
    return cnt


# 테스트 케이스만큼 반복
t = int(sys.stdin.readline())
for _ in range(t):
    n, m = map(int, sys.stdin.readline().split())

    # 각 노드가 연결된 정보를 표현
    graph = [[0] * (n + 1) for i in range(n + 1)]
    for i in range(m):
        a, b = map(int, sys.stdin.readline().split())
        graph[b][a] = 1

    # 각 노드의 방문유무
    visited = [0] * (n + 1)

    # 첫 번째 국가부터 탐색
    print(bfs(1))