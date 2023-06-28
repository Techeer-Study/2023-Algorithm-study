import sys
input = sys.stdin.readline

n = int(input().rstrip())
word = input().rstrip()
answer = 0

for i in range(n - 1):
    compare_word = input().rstrip()
    temp_word = list(word)
    cnt = 0 # temp_word에 포함되지 않은 compare_word의 문자 개수

    for c in compare_word:
        if c in temp_word:
            temp_word.remove(c)
        else:
            cnt += 1
    
    if cnt < 2 and len(temp_word) < 2: 
        # 한 문자에서 한 단어만 변형가능하므로 cnt가 2이상이면 비슷하지 않은 단어
        # temp_word에 남아있는 단어가 2개 이상이면 비슷하지 않은 단어
        answer += 1

print(answer)