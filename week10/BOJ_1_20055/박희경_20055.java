package BOJ_1_20055;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 박희경_20055 {
    static int N, K;
    static int[] map;
    static int left, right;
    static boolean[] robot;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[2 * N];
        robot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2 * N; i++)
            map[i] = Integer.parseInt(st.nextToken());

        left = 0;
        right = N;

        int count = 0;
        while(K > 0) {
            count++;
            moveBelt();
            moveRobot();
            newRobot();
        }
        System.out.println(count);
    }

    public static void moveBelt() {
        left--;
        right--;

        if(left < 0)
            left = 2 * N -1;
        if(right < 0)
            right = 2 * N - 1;

        for(int i = N - 2 ; i > 0 ; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false;
        robot[N - 1] = false;
    }

    public static void moveRobot() {
        for(int i = N-2 ; i >= 0 ; i--) {
            if(robot[i]) {
                int next = left + i + 1;
                if(next >= 2 * N)
                    next -= 2 * N;
                if(!robot[i + 1] && map[next] >= 1) {
                    robot[i] = false;
                    if(i + 1 < N - 1)
                        robot[i + 1] = true;
                    map[next]--;
                    if(map[next] == 0)
                        K--;
                }
            }
        }
    }

    public static void newRobot() {
        if(map[left] > 0) {
            robot[0] = true;
            map[left]--;
            if(map[left] == 0)
                K--;
        }
    }
}
