import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());
        int gcd = 1;
        for(int i = 1; i<=Math.max(p1,p2);i++){
            if(p1 % i == 0 && p2 % i == 0){
                gcd = i;
            }
        }
        System.out.println(gcd);
        int m_p1 = p1,m_p2 = p2;
        while(m_p1 != m_p2){
            if(m_p1> m_p2) m_p2 += p2;
            else m_p1 += p1; 
        }
        System.out.println(m_p1);
    }
}