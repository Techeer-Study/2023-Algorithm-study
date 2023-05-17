import sys
input = sys.stdin.readline

N, L = map(int, input().split()) # 신호등 개수, 도로의 길이
pos = 0 # 현재 위치
answer = 0 

for _ in range(N):
    d, r, g = map(int, input().split()) # 신호등 위치, 빨간불, 초록불

    answer += (d - pos) # 신호등 위치 - 현재 위치
    pos = d # 현재 위치 갱신

    if answer % (r + g) <= r: # 경과시간 % (빨간불 + 초록불)이 빨간불 이하면 대기해야함
        answer += (r - (answer % (r + g))) # 대기시간 더하기

answer += (L - pos) # 반복문을 돌고나면 신호등이 없는 도로의 길이를 더해야함.
print(answer)