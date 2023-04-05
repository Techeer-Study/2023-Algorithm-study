package BOJ_2_4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 박희경_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s;

        while (true) {
            s = br.readLine();

            if (s.equals(".")) {    // 종료
                break;
            }
            Stack<Character> st = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(' || s.charAt(i) == '[') {
                    st.push(s.charAt(i));
                } else {
                    if (s.charAt(i) == ')') {
                        if (!st.isEmpty() && st.peek() == '(') st.pop();
                        else st.push(s.charAt(i));
                    } else if (s.charAt(i) == ']') {
                        if (!st.isEmpty() && st.peek() == '[') st.pop();
                        else st.push(s.charAt(i));
                    }
                }
            }
            if (st.isEmpty())
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}