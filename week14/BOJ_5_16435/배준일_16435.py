import sys
input = sys.stdin.readline

fruit, snakebird = map(int, input().rstrip().split())
fruit_list = list(map(int, input().rstrip().split()))

fruit_list.sort()

for fruit in fruit_list:
    if snakebird >= fruit:
        snakebird += 1

print(snakebird)