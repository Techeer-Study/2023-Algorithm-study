import sys
input = sys.stdin.readline
from collections import deque

n = int(input().rstrip())

for t in range(n):
    walk = 0
    students = deque(list(map(int, input().rstrip().split())))
    students.popleft() # 테스트 케이스 번호 제거
    line = []
    
    line.append(students[0])
        
    for i in range(1, len(students)):
        if students[i] > line[-1]: # 줄에 추가할 학생이 줄의 맨 뒤에 사람보다 클 경우
            line.append(students[i])
            continue

        for j in range(len(line)):
            if students[i] < line[j]: # 줄에 추가할 사람이 라인에 있는 사람보다 작을 경우
                new_line = line[:j] + [students[i]] + line[j:] # 줄 재정렬
                walk += len(line[j:]) # 이동 수 추가
                line = new_line # 줄 갱신
                break
                
    print(str(t + 1) + " " + str(walk))