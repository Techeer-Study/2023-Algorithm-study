import Foundation

struct Main {
    static func main() {
        let n = Int(readLine()!)!
        var stack: [Int] = []
        var answer: [String] = []
        var count = 1
        for _ in 0..<n {
            let num = Int(readLine()!)!

            while count <= num {
                stack.append(count)
                answer.append("+")
                count += 1
            }

            if stack.last == num {
                stack.popLast()
                answer.append("-")
            } else {
                print("NO")
                return
            }
        }
        print(answer.joined(separator: "\n"))
    }
}

Main.main()