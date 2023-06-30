N = int(input())
drinks = list(map(int, input().split()))

drinks.sort()

ans = 0.0
while(len(drinks) != 1):
    ans = drinks[0]/2 + drinks.pop()
    drinks.append(ans)
    if(len(drinks)) : 
        drinks.pop(0)

print(ans)