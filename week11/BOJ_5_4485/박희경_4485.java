package BOJ_5_4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 박희경_4485 {
    static class Point implements Comparable<Point> {

        int row, col, cost;

        public Point(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return cost - o.cost;
        }
    }
    static int N;
    static int[][] map, distance;
    static int[] dy = { 0, 1, -1, 0 };
    static int[] dx = { 1, 0, 0, -1 };

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cnt = 0;
        while (true) {

            N = Integer.parseInt(br.readLine());
            if (N == 0)
                break;
            map = new int[N][N];
            distance = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
            cnt++;
            System.out.println("Problem " + cnt + ": " + dijkstra());
        }
    }
    public static int dijkstra() {
        PriorityQueue<Point> queue = new PriorityQueue<Point>();
        distance[0][0] = map[0][0];
        queue.offer(new Point(0, 0, map[0][0]));

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = p.row + dy[i];
                int nextCol = p.col + dx[i];

                if (isValid(nextRow, nextCol)) {
                    if (distance[nextRow][nextCol] > distance[p.row][p.col] + map[nextRow][nextCol]) {
                        distance[nextRow][nextCol] = distance[p.row][p.col] + map[nextRow][nextCol];
                        queue.offer(new Point(nextRow, nextCol, distance[nextRow][nextCol]));
                    }
                }
            }
        }
        return distance[N - 1][N - 1];
    }

}
