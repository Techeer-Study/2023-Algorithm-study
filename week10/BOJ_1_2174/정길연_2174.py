dx = [-1, 0, 1, 0]
dy = [0, 1, 0,-1]

A, B = map(int,input().split())
N, M = map(int,input().split())

cmd = []
robot = dict()
robotMap = [[0] * A for _ in range(B)]

for i in range(1,N+1):
    x, y, d = input().split()
    if d == "N":
        d = 0
    elif d == "E":
        d = 1
    elif d == "S":
        d = 2
    else:
        d = 3
    robotMap[(B - int(y))][int(x)-1] = 1
    robot[i] = [(B - int(y)), int(x) - 1, d]

for _ in range(M):
    x, y, d = input().split()
    cmd.append([int(x), y, int(d)])


for R, C, repeat in cmd:
    for _ in range(repeat):
        if C == "F":
            cx, cy, dir = robot[R]
            nx = cx + dx[dir]
            ny = cy + dy[dir]
            if not (0 <= nx < B and 0 <= ny < A):
                print("Robot",R,"crashes into the wall")
                exit()
            elif robotMap[nx][ny] == 1:
                for i in robot:
                    if nx == robot[i][0] and ny == robot[i][1]:
                        print("Robot", R, "crashes into robot", i)
                        exit()
            else:
                robotMap[cx][cy] = 0
                robotMap[nx][ny] = 1
                robot[R][0] = nx
                robot[R][1] = ny
        elif C == "L":
            robot[R][2] = (robot[R][2] - 1)%4
        else:
            robot[R][2] = (robot[R][2] + 1)%4



print("OK")