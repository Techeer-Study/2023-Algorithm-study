import Foundation 

struct Main {
    static func main() {
        let condition = readLine()!.split(separator: " ").map { Int($0)! }
        let n = condition[0]
        let m = condition[1]
        var targets = readLine()!.split(separator: " ").map { Int($0)! }
        var answer = 0
        var array = Array(1...n)

        while(!targets.isEmpty) {
            let target = targets[0] 
            let index = array.firstIndex(of: target)!
            if target == array[0] {
                popFirstElement(queue: &array, target: &targets)
            } else if index > array.count / 2 {
                shiftRight(queue: &array)
                answer += 1
            } else {
                shiftLeft(queue: &array)
                answer += 1
            }
        }
        print(answer)
    }

    private static func shiftLeft(queue: inout [Int]) {
        queue.append(queue.removeFirst())
    }

    private static func shiftRight(queue: inout [Int]) {
        queue.insert(queue.removeLast(), at: 0)
    }

    private static func popFirstElement(queue: inout [Int], target: inout [Int]) {
        queue.removeFirst()
        target.removeFirst()
    }
}

Main.main()