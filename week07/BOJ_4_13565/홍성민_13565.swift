//
//  13565.swift
//  CodingInterview
//
//  Created by Sean Hong on 2023/04/26.
//

import Foundation

struct _13565 {
    static func main() {
        let dx = [0, 0, -1, 1]
        let dy = [-1, 1, 0, 0]
        let ip = readLine()!.split(separator: " ").map { Int(String($0))! }
        let (r, c) = (ip[0], ip[1])
        var graph = [[Character]]()
        var visited = [[Bool]](repeating: [Bool](repeating: false, count: c), count: r)
        
        (0..<r).forEach { _ in
            graph.append(Array(readLine()!))
        }
        
        func dfs(x: Int, y: Int) -> Bool {
            for idx in dx.indices {
                let nx = x + dx[idx]
                let ny = y + dy[idx]
                if nx < 0 || ny < 0 || nx >= r || ny >= c { continue }
                if visited[nx][ny] || graph[nx][ny] == "1" { continue }
                visited[nx][ny] = true
                if nx == r - 1 { return true }
                if dfs(x: nx, y: ny) { return true }
            }
            return false
        }
        
        var ans = false
        
        for idx in graph[0].indices {
            if graph[0][idx] == "1" || visited[0][idx] { continue }
            visited[0][idx] = true
            if dfs(x: 0, y: idx) {
                ans = true
                break
            }
        }
        
        print(ans ? "YES" : "NO")
    }
}
