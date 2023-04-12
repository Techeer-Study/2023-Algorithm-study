import Foundation

struct Main {
    static func main() {
        var k = 0
        var numbers = [Int]()
        var answer = [Int](repeating: 0, count: 6)

        func dfs(start: Int, depth: Int) {
            if depth == 6 {
                print(answer.map { String($0) + " " }.reduce("", +))
                return
            }
            
            for i in start..<numbers.count {
                answer[depth] = numbers[i]
                
                dfs(start: i+1, depth: depth+1)
            }
        }
        
        while true {
            numbers = readLine()!.split(separator: " ").map{ Int($0)! }
            k = numbers.removeFirst()
                
            guard k != 0 else { return }
            dfs(start: 0, depth: 0)
            print()
        }
    }
}

Main.main()