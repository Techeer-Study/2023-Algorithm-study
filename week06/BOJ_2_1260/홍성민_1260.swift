//
//  1260.swift
//  CodingInterview
//
//  Created by Sean Hong on 2023/04/19.
//

import Foundation

struct _1260 {
    static func main() {
        func dfs(start: Int) {
            var visited = [Int]()
            var stack = [start]
            
            while !stack.isEmpty {
                let node = stack.popLast()!
                
                if !visited.contains(node) {
                    visited.append(node)
                    print(node, terminator: " ")
                    stack.append(contentsOf: graph[node].sorted(by: >))
                }
            }
        }
        
        func bfs(start: Int) {
            var visited = [Int]()
            var queue = [start]
            
            while !queue.isEmpty {
                let node = queue.removeFirst()
                
                if !visited.contains(node) {
                    visited.append(node)
                    print(node, terminator: " ")
                    queue.append(contentsOf: graph[node].sorted())
                }
            }
        }
        
        var readline = readLine()!.split(separator: " ").map { Int($0)! }
        let n = readline[0]
        let m = readline[1]
        let v = readline[2]
        
        var graph: [[Int]] = Array(repeating: Array(repeating: 0, count: 0), count: n + 1)
        
        for _ in 0..<m {
            let readline = readLine()!.split(separator: " ").map { Int($0)! }
            let src = readline[0]
            let dest = readline[1]
            graph[src].append(dest)
            graph[dest].append(src)
        }
        
        
        dfs(start: v)
        print()
        bfs(start: v)
    }
}
