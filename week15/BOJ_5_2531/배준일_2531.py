from collections import deque
import sys
input = sys.stdin.readline

n, d, k, c = map(int, input().split())   # n: 접시 수, d: 초밥 가짓수, k: 연속해서 먹는 접시 수, c: 쿠폰 번호
sushi = [int(input()) for _ in range(n)]   # 초밥 종류
max_kinds = 0   # 초밥 최대 가짓수
q = deque(sushi[:k])

for i in range(n):
    if i != 0:  
        if i <= n/2:
            q.append(sushi[i+k-1])
        else:   # 개수가 반을 넘어가면
            q.append(sushi[k-(n-i)-1])
    kinds = set(q)
    kinds.add(c)
    max_kinds = max(max_kinds, len(kinds))
    q.popleft()

print(max_kinds)