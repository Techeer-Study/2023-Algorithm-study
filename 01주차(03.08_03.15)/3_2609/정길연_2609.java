import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 정길연_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStr = br.readLine().split(" ");
        int a = Integer.parseInt(inputStr[0]);
        int b = Integer.parseInt(inputStr[1]);


        System.out.println(gcd(a, b));
        System.out.println(lcm(a, b));
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int remain = a % b;
            a = b;
            b = remain;
        }
        return a;
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

}
