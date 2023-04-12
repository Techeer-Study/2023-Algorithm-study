document = input() # 문서
word = input() # 단어

count = 0

while True:
    if document.find(word) != -1 :
        count+=1
        document=document[document.find(word)+len(word):]
    else:
        break

print(count)