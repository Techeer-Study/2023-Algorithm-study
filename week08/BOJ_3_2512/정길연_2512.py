import sys
input = sys.stdin.readline

n = int(input())  # 지방의 수
arr = list(map(int, input().split()))  # 예산 요청
m = int(input())  # 총 예산

start, end = 0, max(arr)

while start <= end:  # 이분탐색
    mid = (start + end) // 2  # 상한액 
    curr = 0
    for i in arr:
        if i >= mid:  
            curr += mid 
        else:  
            curr += i  
    if curr <= m: 
        start = mid + 1
    else: 
        end = mid - 1


print(end)