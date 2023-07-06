import sys
input = sys.stdin.readline

n = int(input().rstrip())
drinks = list(map(int, input().rstrip().split()))

drinks.sort(reverse=True)

answer = drinks[0]

for i in range(1, len(drinks)):
    answer += drinks[i] / 2

print(answer)