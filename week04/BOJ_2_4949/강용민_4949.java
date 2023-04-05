package week04.BOJ_2_4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class 강용민_4949{
    static HashMap<Character,Character> dict;
    static final String YES = "yes\n", NO = "no\n";

    public static void main(String[] args) throws NumberFormatException,IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        dict = new HashMap<>();
        dict.put('(',')');
        dict.put('[',']');
        while(true){
            String str = br.readLine();
            if(str.equals(".")) break;
            sb.append(check(str));
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }

    public static String check(String str){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='(' || ch =='['){
                stack.push(dict.get(ch));
            }else if(ch==')' || ch==']'){
                if(stack.empty() || ch != stack.pop()){
                    return NO;
                }
            }
        }
        return stack.empty() ?YES :NO;
    }
}