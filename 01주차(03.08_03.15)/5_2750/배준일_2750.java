import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 배준일_2750 {
    private static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // int형으로 받기
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) { // 배열에 저장
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr); // 정렬

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append('\n'); // StringBuilder에 저장
        }

        System.out.print(sb); // 출력
        br.close();
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}
