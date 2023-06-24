import sys
input = sys.stdin.readline

n = int(input())
num = list(map(int, input().split()))
op = list(map(int, input().split())) 

max_num = -1e9
min_num = 1e9


def dfs(dep, total, plus, minus, multi, divi):
    global max_num, min_num

    if dep == n:
        max_num = max(total, max_num)
        min_num = min(total, min_num)
        return

    if plus:
        dfs(dep + 1, total + num[dep], plus - 1, minus, multi, divi)
    if minus:
        dfs(dep + 1, total - num[dep], plus, minus - 1, multi, divi)
    if multi:
        dfs(dep + 1, total * num[dep], plus, minus, multi - 1, divi)
    if divi:
        dfs(dep + 1, int(total / num[dep]), plus, minus, multi, divi - 1)


dfs(1, num[0], op[0], op[1], op[2], op[3])

print(max_num)
print(min_num)