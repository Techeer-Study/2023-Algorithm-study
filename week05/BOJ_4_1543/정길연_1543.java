package BOJ_4_1543;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 정길연_1543 {
    static 	StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb.append(br.readLine());
        String str = br.readLine();

        howManyTime(str);

    }

    static void howManyTime(String str) {
        int cnt = 0, startIdx = 0;
        int target = str.length();

        while((startIdx = sb.toString().indexOf(str)) != -1) {
            sb.delete(0, startIdx + target);
            cnt++;
        }

        System.out.println(cnt);
    }
}
