import com.sun.source.doctree.StartElementTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 정길연_9506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while(true){
            int target = Integer.parseInt(br.readLine());
            if(target == -1) break;

            // 1. 약수 찾기
            ArrayList<Integer> numList = new ArrayList<>();
            for(int i = 1; i<target; i++){
                if(target % i != 0) continue;
                numList.add((int)i);
            }

            // 2. 약수 합이 같은지 혹인
            int sum = 0;
            for (Integer n : numList){
                sum += n;
            }
            if(sum != target) System.out.print(target + " is NOT perfect.");
            else {
                System.out.print(target + " = ");
                for(int i=0; i<numList.size(); i++){
                    if(i == numList.size()-1) System.out.print(numList.get(i));
                    else System.out.print(numList.get(i) + " + ");
                }
            }
            System.out.println();
        }


    }
}
