import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 강용민_2960{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N+1];
        for (int i = 2 ; i <= N; i++){
            if(!visited[i]){
                visited[i] = true;
                if(--K == 0){
                    System.out.println(i);
                    return;
                }
                for(int j = i*i; j<=N ; j += i){
                    if (!visited[j]){
                        visited[j] = true;
                        if(--K == 0){
                            System.out.println(j);
                            return;
                        }
                    }
                }
            }
        }
    }
}