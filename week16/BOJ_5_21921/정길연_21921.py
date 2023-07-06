n, x = map(int, input().split())  
arr = list(map(int, input().split()))

if max(arr) == 0:
    print("SAD")
else:
    values = [0]
    for i, a in enumerate(arr):
        values.append(values[i] + a)

    left = 0
    right = x
    result = 0
    count = 0

    while right <= n:
        if right - left == x:
            if result < values[right] - values[left]:
                result = values[right] - values[left]
                count = 1
            elif result == values[right] - values[left]:
                count += 1
            left += 1
            right += 1

    print(result)
    print(count)