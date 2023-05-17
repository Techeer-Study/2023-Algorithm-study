package week10.BOJ_1_16918;

import java.util.*;
import java.util.stream.*;
import java.io.*;

public class 최준혁_16918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());   // 행
        int C = Integer.parseInt(st.nextToken());   // 열
        int N = Integer.parseInt(st.nextToken());

        Set<List<Integer>> point = new HashSet<>(); // 폭탄 좌표 모음

        String[][] board = new String[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                if (board[i][j].equals("O"))
                    point.add(Arrays.asList(i, j));
            }
        }

        int[] dx = {1, -1, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0};

        boolean flag = false;

        // N초 경과
        for (int i = 0; i <= N; i++) {
            if (i % 2 == 0 || i == 1) {
                flag = true;
                continue;
            }

            flag = false;

            // 폭탄 터뜨리기
            Set<List<Integer>> blank = new HashSet<>(); // 빈 칸 좌표 모음

            for (List<Integer> p : point) {
                int col = p.get(0);
                int row = p.get(1);

                for (int j = 0; j < 5; j++) {
                    int mCol = col + dy[j];
                    int mRow = row + dx[j];

                    if (mCol < 0 || mCol >= R || mRow < 0 || mRow >= C) continue;
                    blank.add(Arrays.asList(mCol, mRow));
                }
            }

            // 폭탄 좌표 설정
            point.clear();

            for (int k = 0; k < R; k++) {
                for (int l = 0; l < C; l++) {
                    if (blank.contains(Arrays.asList(k, l))) continue;    // 빈 칸을 제외하고
                    point.add(Arrays.asList(k, l));   // 나머지 부분들은 모두 폭탄 좌표
                }
            }
        }

        StringBuilder sb;
        if (flag) { // 모두 0으로 출력
            for (int i = 0; i < R; i++) {
                sb = new StringBuilder();
                for (int j = 0; j < C; j++) {
                    sb.append("O");
                }
                bw.write(sb + "\n");
            }
        } else {    // 폭탄 좌표 고려하여 출력
            for (int i = 0; i < R; i++) {
                sb = new StringBuilder();
                for (int j = 0; j < C; j++) {
                    if (point.contains(Arrays.asList(i, j))) {
                        sb.append("O");
                    } else {
                        sb.append(".");
                    }
                }
                bw.write(sb + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
