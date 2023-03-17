import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class 강용민_10798{
    static char[][] arrs;
    static int[] arrs_len;
    static int max_len;

    public static void main(String[] args) throws IOException{
        arrs = new char[5][];
        arrs_len = new int[5];
        max_len = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int row = 0;row<5;row++){
             String str = br.readLine();
            arrs[row] = str.toCharArray();
            arrs_len[row] = str.length();
            max_len = Math.max(max_len, str.length());
        }

        StringBuilder sb = new StringBuilder();
        for(int col = 0; col < max_len; col++){
            for(int row = 0; row<5;row++){
                if(col < arrs_len[row]){
                    sb.append(arrs[row][col]);
                }
            }
        }
        System.out.println(sb);
    }
}