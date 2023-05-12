n = int(input())
num_list = list()

for i in range(n):
    num_list.append(list(map(int, input().split())))
k = 2

for i in range(1, n):
    for j in range(k):
        if j == 0:
            num_list[i][j] = num_list[i][j] + num_list[i - 1][j]
        elif i == j:
            num_list[i][j] = num_list[i][j] + num_list[i - 1][j - 1]
        else:
            num_list[i][j] = max(num_list[i - 1][j - 1], num_list[i - 1][j]) + num_list[i][j]
    k += 1

print(max(num_list[n - 1]))