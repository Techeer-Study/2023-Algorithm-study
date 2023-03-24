import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 강용민_10974{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        permutation(N, new boolean[N+1], 0, new int[N]);
    }

    static void permutation(int N,boolean[] visited,int depth,int[] nums){
        if(depth == N){
            StringBuilder sb = new StringBuilder();
            for(int num: nums)
                sb.append(num + " ");
            System.out.println(sb);
            return;
        }

        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                visited[i] = true;
                nums[depth] = i;
                permutation(N, visited, depth + 1, nums);
                visited[i] = false;
            }
        }
    }
}