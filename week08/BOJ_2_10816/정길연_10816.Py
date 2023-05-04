from bisect import bisect_left, bisect_right
from sys import stdin

n = stdin.readline().rstrip()
cards = list(map(int,stdin.readline().split()))
cards.sort()

m = stdin.readline().rstrip()
targets = list(map(int,stdin.readline().split()))


def count_by_range(a, left_value, right_value):
    right_idx = bisect_right(a, right_value)
    left_idx = bisect_left(a, left_value)

    return right_idx - left_idx


for i in range(len(targets)):
    print(count_by_range(cards, targets[i], targets[i]), end=' ')