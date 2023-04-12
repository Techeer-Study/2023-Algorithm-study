//1461번 도서관 남에꺼 참고함
let t = readLine()!.split(separator: " ").map{Int(String($0))!}
let (n,m) = (t[0],t[1])
let books = readLine()!.split(separator: " ").map{Int(String($0))!}.sorted()

var positiveArr: [Int] = []
var negativeArr: [Int] = []

books.forEach { pos in
    if pos > 0 {
        positiveArr.append(pos)
    } else {
        negativeArr.append(pos * -1)
    }
}
negativeArr = negativeArr.reversed()

let maxLen = max(positiveArr.max() ?? 0, negativeArr.max() ?? 0)
var ans = 0

while !positiveArr.isEmpty {
    ans += positiveArr.removeLast()
    for _ in 0 ..< m-1 {
        _ = positiveArr.popLast()
    }
}

while !negativeArr.isEmpty {
    ans += negativeArr.removeLast()
    for _ in 0 ..< m-1 {
        _ = negativeArr.popLast()
    }
}

print(ans * 2 - maxLen)