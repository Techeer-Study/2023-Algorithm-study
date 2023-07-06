import sys
input = sys.stdin.readline

# 입력 값 
n,x = map(int,input().split())
arr = list(map(int,input().split()))

# 0~ x-1 인덱스 까지 합
value = sum(arr[:x])
ans1, ans2 = value, 1


for i in range(x, n) :
  value += (arr[i] - arr[i-x])
  
  if ans1 < value : 
    ans1 = value
    ans2 = 1
  elif ans1 == value : 
    ans2 += 1

# 문제에서 요구하는 출력
if ans1 :
    print(ans1)
    print(ans2)
else :
   print("SAD")