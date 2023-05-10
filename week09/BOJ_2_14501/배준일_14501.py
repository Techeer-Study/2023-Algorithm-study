import sys
input = sys.stdin.readline

n = int(input().rstrip())
consultings = [list(map(int, input().rstrip().split())) for _ in range(n)]
dp = [0] * (n + 1)

for i in range(1, n + 1):
    t, p = consultings[i - 1][0], consultings[i - 1][1]

    if i + t - 1 <= n: # i + t - 1 = i일째에 시작한 상담이 끝나는 날
        dp[i + t - 1] = max(dp[i + t - 1], dp[i - 1] + p) # 현재 값과 추가 상담을 한 값을 비교

    if dp[i] < dp[i - 1]:
        dp[i] = dp[i - 1]

print(max(dp))