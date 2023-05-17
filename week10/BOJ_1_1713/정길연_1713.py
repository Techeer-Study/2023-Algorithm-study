import sys

n = int(input())
num_student = int(input())
voteList = list(map(int,sys.stdin.readline().split()))

photo = []
photo_num = []

for v in voteList:
    if v in photo:
        idx = photo.index(v)
        photo_num[idx] += 1
    else:
        if len(photo) >= n:
            idx = photo_num.index(min(photo_num))
            del photo[idx]
            del photo_num[idx]
        photo.append(v)
        photo_num.append(1)

photo.sort()            
print(' '.join(map(str,photo)))