import Foundation

struct Main {
    static func main() {
        var answer: Int64 = 0
        let _ = Int(readLine()!)!
        let students = readLine()!.split(separator: " ").map { Int64($0)! }
        let instructors = readLine()!.split(separator: " ").map { Int64($0)! }
        students.forEach { student in
            answer += 1 
            let remain = student - instructors[0]

            if remain > 0 {
                if remain % instructors[1] == 0 {
                    answer += Int64(remain / instructors[1])
                } else {
                    answer += Int64(remain / instructors[1]) + 1
                }
            }
            
        }
        print("\(answer)")
    }
}

Main.main()