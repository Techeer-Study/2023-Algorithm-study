func solution() {
    let test = Int(readLine()!)!
    var people = [[Int]]()
    var result = [Int]()
    for _ in 0..<test{
        let temp = Int(readLine()!)!
        var tempResult = 0
        for _ in 0..<temp{
            people.append(readLine()!.split(separator: " ").map({Int($0)!}))
        }
        people.sort { (a, b) -> Bool in
            return a[0] < b[0]
        }
        var tempMin = 0
        for index in 0..<temp{
            if index == 0 {
                tempResult += 1
                tempMin = people[index][1]
            } else {
                if tempMin > people[index][1]{
                    tempResult += 1
                    tempMin = people[index][1]
                }
            }
        }
        result.append(tempResult)
        people = []
    }
    for answer in result {
        print(answer)
    }
}

solution()