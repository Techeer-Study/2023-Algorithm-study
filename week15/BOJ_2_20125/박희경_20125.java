package BOJ_2_20125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 박희경_20125 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] heart = {-1, -1};
        int[] size = new int[5];

        int N = Integer.parseInt(br.readLine());
        char[][] square = new char[N][N];

        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            square[n] = st.nextToken().toCharArray();
        }

        for (int i = 0; heart[0] == -1 && heart[1] == -1; i++) {
            for (int j = 0; j < N; j++) {
                if (square[i][j] == '*') {
                    heart[0] = i + 1;
                    heart[1] = j;
                    break;
                }
            }
        }

        for (int n = 1; heart[1] - n >= 0 && square[heart[0]][heart[1] - n] == '*'; n++) {
            size[0]++;
        }
        for (int n = heart[1] + 1; n < N && square[heart[0]][n] == '*'; n++) {
            size[1]++;
        }
        for (int n = heart[0] + 1; n < N && square[n][heart[1]] == '*'; n++) {
            size[2]++;
        }
        for (int n = heart[0] + size[2] + 1; n < N && square[n][heart[1] - 1] == '*'; n++) {
            size[3]++;
        }
        for (int n = heart[0] + size[2] + 1; n < N && square[n][heart[1] + 1] == '*'; n++) {
            size[4]++;
        }

        System.out.println((heart[0] + 1) + " " + (heart[1] + 1));
        for (int i = 0; i < 5; i++) {
            System.out.print(size[i] + " ");
        }
        System.out.println();
    }
}
