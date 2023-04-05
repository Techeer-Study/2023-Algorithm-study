class Main {
    static func Main() {
        var studentDict: [String: Int] = [:]
        let n = Int(readLine()!)!
        readLine()!.split(separator: " ").map { studentDict[String($0)] = 0 }
        for i in 0..<n {
            readLine()!.split(separator: " ").map { student in 
                if let liked = studentDict[String(student)] {
                    studentDict[String(student)] = liked + 1
                }
            }
        }

        let sortedByKey = studentDict.sorted { $0.0 < $1.0 } 
        let sortedByKeyAndValue = sortedByKey.sorted { $0.1 > $1.1 } 
        sortedByKeyAndValue.forEach { student in 
            print("\(student.key) \(student.value)")
        }
    }
}

Main.Main()