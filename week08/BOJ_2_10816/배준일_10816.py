import sys
input = sys.stdin.readline

n = int(input().rstrip())
n_card = input().rstrip().split()
m = int(input().rstrip())
m_card = input().rstrip().split()

sangun_card = {}

for card in n_card:
    if card in sangun_card:
        sangun_card[card] += 1
    else:
        sangun_card[card] = 1

answer = []

for num_card in m_card:
    answer.append(sangun_card.get(num_card, 0)) # get은 값이 key가 있으면 value를 출력하고 key가 없으면 디폴트 값으로 두번째 인자를 출력한다.

print(*answer)