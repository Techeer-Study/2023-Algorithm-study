import sys
input = sys.stdin.readline
n = int(input())

numbers = list(map(int, input().rstrip().split()))
a = list(set(numbers)) # 중복 제거
a.sort() 

numdict = {}
for i in range(len(a)):
    numdict[a[i]] = i

for i in numbers: # numbers 순서대로 출력
    print(numdict[i], end = ' ')