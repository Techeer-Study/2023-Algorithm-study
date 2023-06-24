import sys
input = sys.stdin.readline

n = int(input().rstrip())
rope_list = [int(input().rstrip()) for _ in range(n)]

rope_list.sort(reverse = True) # 역순으로 정렬
result = 0

for i in range(n):
    result = max(result, rope_list[i] * (i + 1))

print(result)