package week04.BOJ_3_1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 정길연_1021 {
    static int N, M, count =0;
    static LinkedList<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static boolean check(int a) {

        for(int i = 0 ; i <= q.size()/2 ; i++) {
            if(a == q.get(i)) return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] tmp = new int[M];
        for (int i = 0; i < M; i++)
            tmp[i] = Integer.parseInt(st.nextToken());


        for (int i = 1; i <= N; i++)
            q.add(i);

        for (int i = 0; i < M; i++) {
            if (check(tmp[i])) {
                while (tmp[i] != q.get(0)) {
                    q.addLast(q.pollFirst());
                    count++;
                }
            } else {
                while (tmp[i] != q.get(0)) {
                    q.addFirst(q.pollLast());
                    count++;
                }
            }
            q.poll();
        }

        System.out.println(count);

    }

}
