package week03.BOJ_3_1935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class 강용민_1935{

    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        Stack<Double> stack = new Stack<>();
        Double[] alpha = new Double[N];

        for(int n = 0;n<N;n++){
            alpha[n] = Double.parseDouble(br.readLine());
        }


        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if('A'<=c && c<='Z'){
                stack.push(alpha[c-'A']);
            }else{
                double sec = stack.pop();
                double val = stack.pop();
                switch(c){
                    case '+':
                        val += sec;
                        break;
                    case '-':
                        val -= sec;
                        break;
                    case '*':
                        val *= sec;
                        break;
                    case '/':
                        val /= sec;
                        break;
                }
                stack.push(val);
            }
        }
        System.out.printf("%.2f",stack.pop());
        br.close();
    }
}