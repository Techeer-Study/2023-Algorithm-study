import Foundation 

struct Main {
    static func main() {
        while true {
            guard let string = readLine() else {
                return
            }
            if string == "." { return }

            let onlyBrackets = string.map { $0 == "(" || $0 == ")" || $0 == "[" || $0 == "]" ? String($0) : "" }.joined()
            if onlyBrackets.isEmpty {
                print("yes")
                continue
            }
            if checkBrackets(s: onlyBrackets) {
                print("yes")
            } else {
                print("no")
            }
        }
    }

    private static func checkBrackets(s: String) -> Bool {
        let pairs: [Character: Character] = ["(": ")", "[": "]"]
        var stack: [Character] = []
        for char in s {
            if let match = pairs[char] {
                stack.append(match)
            } else if stack.last == char {
                stack.popLast()
            } else {
                return false
            }
        }
        return stack.isEmpty
    }
}

Main.main()