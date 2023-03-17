import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 박희경_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[] arr = new int[input];

        for(int i = 0; i < input; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 정렬 메소드
        Arrays.sort(arr);

        for(int val : arr) {
            System.out.println(val);
        }
    }
}
