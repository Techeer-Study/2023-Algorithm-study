import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        primeNumber(a,b);
    }

    //에라토스테네스의 체
    static void primeNumber(int a, int b) {
        int[] arr = new int[a + 1];

        //배열 초기화화
        for (int i = 2; i <= a; i++) {
            arr[i] = i;
        }
        for (int i = 2; i <= a; i++) {
            if (arr[i] == 0)
                continue;

            for (int j = i; j <= a; j += i) {
                if (arr[j] != 0) {
                    arr[j] = 0;
                    b--;
                    if (b == 0) {
                        System.out.print(j);
                        return;
                    }
                }
            }
        }
    }
}
