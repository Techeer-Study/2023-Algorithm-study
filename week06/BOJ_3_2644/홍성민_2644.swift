//
//  2644.swift
//  CodingInterview
//
//  Created by Sean Hong on 2023/04/19.
//

import Foundation

struct _2644 {
    static func main() {
        func bfs() {
            var queue = [(target1,0)]
            var isFind = false
            while !queue.isEmpty {
                let first = queue.removeLast()
                if first.0 == target2 {
                    isFind = true
                    print(first.1)
                    break
                }
                for next in nodes[first.0] {
                    if !visit[next] {
                        visit[next] = true
                        queue.append((next, first.1 + 1 ))
                    }
                }
            }
            if !isFind { print(-1)}
        }

        let N = Int(readLine()!)!
        let input0 = readLine()!.split(separator : " ").map{Int(String($0))!}
        let target1 = input0[0], target2 = input0[1]
        let M = Int(readLine()!)!
        var nodes = Array(repeating: [Int](), count: N+1)
        for _ in 0..<M {
            let input1 = readLine()!.split(separator : " ").map{Int(String($0))!}
            nodes[input1[0]].append(input1[1])
            nodes[input1[1]].append(input1[0])
        }

        var visit = Array(repeating : false, count : N+1)
        visit[target1] = true

        bfs()
    }
}
