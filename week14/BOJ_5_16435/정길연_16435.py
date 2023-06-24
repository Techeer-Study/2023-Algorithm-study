fruit, init_len = map(int, input().split())
num = list(map(int, input().split()))
num.sort()
idx = 0

while(True):
    if init_len < num[idx]:
        break
    else:
        idx += 1
        init_len += 1
        if idx >= len(num):
            break
        
    

print(init_len)