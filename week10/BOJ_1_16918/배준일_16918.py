import sys
from collections import deque
input = sys.stdin.readline

# 1. 현재 맵 받아오기
R, C, N = map(int, input().split())
maps = [list(map(str, input().rstrip())) for _ in range(R)]
bomb = lambda li: deque((i, j) for j in range(C) for i in range(R) if li[i][j] == 'O')  # 현재 폭탄 위치

# 2. 폭탄 채우기
def fill_bombs():
    global maps, R, C
    maps = [['O' for _ in range(C)] for _r in range(R)]

# 3. 폭탄 터뜨리기
def explode(bombs):
    global maps, R, C

    movin = [[-1,0], [1,0], [0,-1], [0,1]]
    while bombs:
        a, b = bombs.popleft()
        # print(a,b)
        maps[a][b] = '.'    # 폭탄 해제
        for mov in movin:
            x = a + mov[0]
            y = b + mov[1]

            if 0 <= x < R and 0 <= y < C:
                if maps[x][y] == "O":
                    maps[x][y] = '.'


def solution():
    global N, maps

    #   봄버맨은 처음에 아무것도 하지 않음.
    N-=1
    while N:
        # 봄버맨이 폭탄 채우기 전의 폭탄 위치 기억
        bombs = bomb(maps)
        # print(bombs)

        # 다음 1초 동안 봄버맨은 폭탄을 채움
        fill_bombs()

        # 봄버맨이 폭탄 채워서 1초 지남
        N-=1
        # 시간이 모두 지나면 출력하고 탈출
        if not N:
            break

        # 기존 폭탄 터뜨리기
        explode(bombs)

        # 폭탄 터져서 1초 지남
        N-=1
    for row in maps:
        print("".join(row))            

solution()

# import sys
# from collections import deque
# input = sys.stdin.readline

# r, c, n = map(int, input().rstrip().split())
# graph = [list(map(str, input().rstrip())) for _ in range(r)]
# dx = [-1, 1, 0, 0]
# dy = [0, 0, -1, 1]
# q = deque()

# def bfs():
#     while q:
#         x, y = q.popleft()

#         for i in range(4):
#             nx = dx[i] + x
#             ny = dy[i] + y

#             if 0 <= nx < r and 0 <= ny < c:
#                 if graph[nx][ny] == '.':
#                     graph[nx][ny] = 'O'



# for i in range(r):
#     for j in range(c):
#         if graph[i][j] == 'O':
#             q.append((i, j))

# bfs()
