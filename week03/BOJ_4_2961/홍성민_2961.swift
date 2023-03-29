
import Foundation

struct Main {
    static func main() {
        let n = Int(readLine()!)!
        var flavors = [[Int]]()
        for _ in 0..<n {
            flavors.append(readLine()!.split(separator: " ").map({ Int(String($0))! }))
        }
        
        var minDiff = Int.max
        
        func combine(_ index: Int, s: Int, b: Int) {
            guard index < n else { return }
            let newS = s * flavors[index][0]
            let newB = b + flavors[index][1]
            if minDiff > abs(newS-newB) {
                minDiff = abs(newS-newB)
            }
            combine(index+1, s: newS, b: newB)
            combine(index+1, s: s, b: b)
        }
        
        combine(0, s: 1, b: 0)
        print(minDiff)
    }
}


Main.main()
