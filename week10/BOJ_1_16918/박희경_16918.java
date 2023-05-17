package BOJ_1_16918;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 박희경_16918 {
    static int R, C, N;
    static char[][] map;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0}; // 북 동 남 서
    static int[] dy = {0, 1, 0, -1};
    static int[][] bombTime;
    static int time = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        bombTime = new int[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j]=='O') {
                    q.add(new int[]{i, j});
                    bombTime[i][j] = 3;
                }
            }
        }

        while(time++ < N) {
            if(time % 2 == 0)
                setBomb();
            else
                getBomb();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static void setBomb() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '.') {
                    map[i][j] = 'O';
                    bombTime[i][j] = time + 3;
                }
            }
        }
    }

    public static void getBomb() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(bombTime[i][j] == time) {
                    bomb(i,j);
                }
            }
        }
    }

    public static void bomb(int x, int y) {
        map[x][y] = '.';

        for(int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(isRange(nx,ny) && map[nx][ny] =='O' && bombTime[nx][ny] != time) {
                bombTime[nx][ny] = 0;
                map[nx][ny] = '.';
            }
        }
    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < R && y < C;
    }
}
