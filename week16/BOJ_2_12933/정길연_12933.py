
# # # 차례대로 q, u, a, c, k가 나오는 경우 (겹쳐서를 고려하지 않음))
# ori = list(input())

# cnt = 0
# ans = 0

# for i in range(len(ori)):
#     if cnt == 0 and ori[i] == "q":
#         cnt += 1
#     elif cnt == 1 and ori[i] == "u":
#         cnt += 1
#     elif cnt == 2 and ori[i] == "a":
#         cnt +=1 
#     elif cnt == 3 and ori[i] == "c":
#         cnt += 1
#     elif cnt == 4 and ori[i] == "k":
#         cnt = 0
#         ans += 1
#     else:
#         continue

# if(ans == 0):
#     print(-1)
# else:
#     print(ans)


# 이렇게 하면 연속된 quack은 한마리로 인지하는 것이 아닌, 여러 마리로 인식됨
sound = list(input())
visited = [ 0 ] * len(sound)
ans = 0

if sound[0] != "q"  or  sound[-1] != "k" or len(sound) % 5 :
    print(-1)
    exit()

def find_uack(start) :
    uack = "uack"
    j = 0
    global ans 
    for i in range(start, len(sound)):
        if sound[i] == uack[j] and not visited[i]:
            visited[i] = 1
            if sound[i] == "k":
                ans += 1
                j = 0
                continue    # j 떄문에 continue로 꼭 끊어줘야함
            j += 1

for i in range(len(sound) - 4):     # 어차피 q 뒤에는 무조건 uack이 와야하므로 -4를 해준다
    if sound[i] == "q" and not visited[i]:
        visited[i] = 1
        find_uack(i + 1)

if ans :
    print(ans)
else :
    print(-1)



sound = list(input())
ans = 0

if sound[0] != "q"  or  sound[-1] != "k" or len(sound) % 5 :
    print(-1)
    exit()

def find_quack(start) :
    quack = "quack"
    j = 0
    global ans 
    new_ori = True      # 새로운 오리로 생성하라는 flag
    for i in range(start, len(sound)):
        if sound[i] == quack[j]:
            if sound[i] == "k":
                if new_ori:     # 새로운 오리일 경우, 오리(ans) 추가
                    ans += 1
                    new_ori = False     # k값으로 끝났으니 새로운 오리를 생성하지 말라는 flag          
                j = 0           # 이어지는 "q" 탐색 - 새로운 오리가 아님 (현재 오리)
                sound[i] = 0           
                continue        
            j += 1
            sound[i] = 0


for i in range(len(sound) - 4):     # 어차피 q 뒤에는 무조건 uack이 와야하므로 -4를 해준다
    if sound[i] == "q" :
        find_quack(i)


if any(sound) or ans == 0 :
    print(-1)
else :
    print(ans)