import sys
input = sys.stdin.readline

N, L = map(int, input().split())
position = 0
ans = 0

for _ in range(N):
    D, R, G = map(int, input().split())

    ans += (D - position)
    position = D
    if ans % (R + G) <= R:
        ans += (R - (ans % (R + G)))

ans += (L - position)
print(ans)