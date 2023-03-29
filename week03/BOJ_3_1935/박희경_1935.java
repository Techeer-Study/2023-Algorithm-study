package BOJ_3_1935;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Stack;

public class 박희경_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        Stack < Double > stack = new Stack< >();
        double[] arr = new double[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < str.length(); i++) {
            char chr = str.charAt(i);
            double result = 0;
            if ('A' <= chr && chr <= 'Z') {
                stack.push(arr[chr - 'A']);
            } else {
                double a = stack.pop();
                double b = stack.pop();
                switch (chr) {
                    case '+':
                        result = b + a;
                        stack.push(result);
                        continue;
                    case '-':
                        result = b - a;
                        stack.push(result);
                        continue;
                    case '*':
                        result = b * a;
                        stack.push(result);
                        continue;
                    case '/':
                        result = b / a;
                        stack.push(result);
                }
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}