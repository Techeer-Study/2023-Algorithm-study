import Foundation

struct Main {
    static func main() {
        let n = Int(readLine()!)!
        var channels: [String] = []
        for _ in 0..<n {
            let channel = readLine()!
            channels.append(channel)
        }
        if let channelIndexFirst = channels.firstIndex(of: "KBS1"),
            let channelIndexSecond = channels.firstIndex(of: "KBS2") {
                if channelIndexFirst > channelIndexSecond {
                    channelIndexSecond += 1
                }
        }
        print("\("1"*channelIndexFirst+"4"*channelIndexFirst+"1"*channelIndexSecond+"4"*channelIndexSecond))")
    }
}

Main.main()