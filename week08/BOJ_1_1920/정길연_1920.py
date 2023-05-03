n =  int(input())
# target = list(map(int, input().split()))
target = set(map(int, input().split()) )

m = int(input())
check = list(map(int, input().split()))

# 1. 시간 초과 - in 사용
# for a in check:
#     if a in target:
#         print(1)
#         continue
#     else : print(0)

# 2. 시간 초과
# target.sort()
# for i in range(len(check)):
#     if check[i] > target[len(target)-1]:
#         print(0)
#         continue
#     if check[i] < target[0]:
#         print(0)
#         continue
#     if check[i] in target:
#         print(1)
#         continue
#     else:
#         print(0)


for a in check:
    if a in target:
        print(1)
    else : print(0)
