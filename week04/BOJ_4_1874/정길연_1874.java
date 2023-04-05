package week04.BOJ_4_1874;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.Stack;

public class 정길연_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack numStack = new Stack<>();
        ArrayList targetList = new ArrayList<>();
        ArrayList resultList = new ArrayList<>();
        ArrayList returnList = new ArrayList<>();

        for(int i =0; i<n; i++){
            int inputNum = Integer.parseInt(br.readLine());
            targetList.add(inputNum);
        }

        int pushNum = 1;
        int target = 0;

        while(resultList.size() != n){
            if(pushNum > (n+1)) {
                System.out.println("NO");
                return;
            }
            if( !numStack.isEmpty() && numStack.peek().equals(targetList.get(target)) ){
                resultList.add(numStack.pop());
                target ++;
                returnList.add("-");
            } else {
                numStack.add(pushNum);
                returnList.add("+");
                pushNum ++;
            }
        }

        for(Object i : returnList){
            System.out.println(i);
        }
    }
}