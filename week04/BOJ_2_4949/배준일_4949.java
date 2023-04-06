package week04.BOJ_2_4949;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 배준일_4949 {
    private static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input_len;
        Stack<Character> stack = new Stack<>();
        char c;

        String input;
        while(!(input = br.readLine()).equals(".")) {
            stack.clear();

            input_len = input.length();

            for(int i = 0; i < input_len; i++) {
                c = input.charAt(i);

                if(c == '(' || c == '[') { // (, [ 일 때 추가
                    stack.push(c);
                }
                else if(c == ')' || c == ']') { // ), ] 일 때
                    if(stack.isEmpty() || (c == ')' && stack.peek() != '(') || (c == ']' && stack.peek() != '[')) {
                        // 짝이 안맞는 경우 추가
                        stack.push(c);
                        break;
                    }

                    stack.pop(); // 짝이 맞으면 pop
                }
            }

            if(stack.isEmpty()) { 
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
