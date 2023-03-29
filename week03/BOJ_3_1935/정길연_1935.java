package BOJ_3_1935;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 정길연_1935 {

    static int N, numbers[];
    // a b c
    // 0 1 2
    static String func;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        func = br.readLine();

        numbers =new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> st = new Stack<>();
        for (int i = 0; i < func.length(); i++) {
            char c = func.charAt(i);

            if(c >= 'A' && c <= 'Z') st.push((double)numbers[c-'A']);
            else {
                double y = st.pop() * 1.;
                double x = st.pop() * 1.;
                if(c == '+') st.push(x + y);
                else if(c == '-') st.push(x - y);
                else if(c == '*') st.push(x * y);
                else if(c == '/') st.push(x / y);
            }
        }

        Double result = st.pop();
        System.out.printf("%.2f", result);

        br.close();
    }
}
