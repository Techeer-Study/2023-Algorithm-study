import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 강용민_10870 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fibo(n));
    }
    public static int fibo(int n){
        if(n < 2) return n;
        return fibo(n-1)+fibo(n-2);
    }
}
