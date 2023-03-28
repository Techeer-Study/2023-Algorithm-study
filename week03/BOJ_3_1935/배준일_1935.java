package BOJ_3_1935;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 배준일_1935 {
    private static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        String data = br.readLine();
        double[] arr = new double[num];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();

        double result = 0;

        for(int i = 0; i < data.length(); i++) {
            if('A' <= data.charAt(i) && data.charAt(i) <= 'Z') { // 숫자인 경우 스택에 push
                stack.push(arr[data.charAt(i) - 'A']);
            } else {
                if(!stack.isEmpty()) { // 연산자일 경우
                    double first = stack.pop();
                    double second = stack.pop(); // 마지막 2개 pop해서 연산
                    switch (data.charAt(i)) {
                        case '+':
                            result = second + first;
                            stack.push(result);
                            continue;
                        case '-':
                            result = second - first;
                            stack.push(result);
                            continue;
                        case '*':
                            result = second * first;
                            stack.push(result);
                            continue;
                        case '/':
                            result = second / first;
                            stack.push(result);
                            continue;
                    }
                }
            }
        }

        System.out.printf("%.2f", stack.pop()); // 소수점 둘째자리까지 출력

        br.close();

    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
