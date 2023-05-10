import sys
input = sys.stdin.readline

n = int(input().rstrip())
soldier = list(map(int, input().rstrip().split()))
dp = [1] * n # 남아있는 병사 수 최소 1명

for i in range(n):
    for j in range(i):
        if soldier[i] < soldier[j]:
            dp[i] = max(dp[i], dp[j] + 1)

print(len(soldier) - max(dp))