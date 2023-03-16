import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int num = Integer.parseInt(br.readLine());
            if (num == -1) break;

            ArrayList<Integer> nums = new ArrayList<Integer>();
            nums.add(1);
            int sum = 1;
            for(int i = 2; i< Math.sqrt(num) ; i++){
                if(num%i == 0){
                    nums.add(i);
                    nums.add(num/i);
                    sum += i + num/i;
                }
            }

            if (sum == num) {
                nums.sort(Comparator.naturalOrder());
                System.out.print(num + " = "+ nums.get(0));
                for(int i = 1;i<nums.size();i++){
                    System.out.print(" + "+nums.get(i));
                }
                System.out.println();
            }else{
                System.out.println(num+" is NOT perfect.");
            }

        }
    }
}