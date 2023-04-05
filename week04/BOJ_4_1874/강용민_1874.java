package week04.BOJ_4_1874;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 강용민_1874{
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        int[] targets = new int[N];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++){
            targets[i] = Integer.parseInt(br.readLine());
        }
        int num = 1;
        for(int i = 0; i < N; i++){
            int target = targets[i];
            if(!stack.empty() && stack.peek() == target){
                sb.append("-\n");
                stack.pop();
                continue;
            }

            if(stack.contains(target)){
                System.out.println("NO");
                return;
            }

            while(num != target){
                stack.push(num++);
                sb.append("+\n");
            }
            num++;
            sb.append("+\n");
            sb.append("-\n");

        }
        System.out.print(sb);
        
    }
}