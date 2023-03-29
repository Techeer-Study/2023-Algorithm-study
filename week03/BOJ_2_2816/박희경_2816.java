package BOJ_2_2816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 박희경_2816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int kbs1 = 0;
        int kbs2 = 0;
        String[] channels = new String[n];
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            channels[i] = str;
            if(str.equals("KBS1"))
                kbs1 = i;
            if(str.equals("KBS2"))
                kbs2 = i;
        }

        if(kbs1 < kbs2)
        {
            result.append("1".repeat(kbs1));
            result.append("4".repeat(kbs1));
            result.append("1".repeat(kbs2));
            result.append("4".repeat(kbs2 - 1));
        }
        else if(kbs1 > kbs2)
        {
            result.append("1".repeat(kbs1));
            result.append("4".repeat(kbs1));
            result.append("1".repeat(kbs2 + 1));
            result.append("4".repeat(kbs2));
        }

        System.out.println(result);
    }
}
