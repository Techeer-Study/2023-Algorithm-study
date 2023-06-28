import sys

n = int(input())

heart_x, heart_y = 0, 0
arm_left, arm_right = 0, 0
back = 0
leg_left, leg_right = 0, 0

for i in range(n):
    for j, cookie in enumerate(list(sys.stdin.readline().strip())):
        # 머리를 찾아서 심장 위치를 찾음 (심장은 머리 아래)
        if (not heart_x) and (not heart_y) and (cookie == '*'):
            heart_x, heart_y = i+1, j
        # 심장라인 + 왼쪽 : 왼쪽 팔 개수
        elif (i == heart_x) and (j < heart_y) and (cookie == '*'):
            arm_left += 1
        # 심장라인 + 오른쪽 : 오른쪽 팔 개수
        elif (i == heart_x) and (j > heart_y) and (cookie == '*'):
            arm_right += 1
        # 심장과 같은 열 + row가 큼: 허리 개수
        elif (i > heart_x) and (j == heart_y) and (cookie == '*'):
            back += 1
        # 허리 아래 + 왼쪽 : 왼다리 개수
        elif (i > heart_x+back) and (j < heart_y) and (cookie == '*'):
            leg_left += 1
        # 허리 아래 + 오른쪽 : 오른다리 개수
        elif (i > heart_x+back) and (j > heart_y) and (cookie == '*'):
            leg_right += 1

print(heart_x+1, heart_y+1)
print(arm_left, arm_right, back, leg_left, leg_right)