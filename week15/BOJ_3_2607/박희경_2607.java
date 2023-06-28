package BOJ_3_2607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 박희경_2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String first = br.readLine();
        int result = 0;

        for(int i = 0; i < N - 1; i++) {
            String str = br.readLine();
            int cnt = 0;
            int[] word = new int[26];
            for(int j = 0; j < first.length(); j++) {
                word[first.charAt(j) - 'A']++;
            }

            for(int j = 0; j < str.length(); j++) {
                if(word[str.charAt(j) - 'A'] > 0) {
                    cnt++;
                    word[str.charAt(j) - 'A']--;
                }
            }

            if(first.length() - 1 == str.length() && cnt == str.length()) {
                result++;
            }
            else if (first.length() == str.length()) {
                if (cnt == first.length() || cnt == first.length() - 1)
                    result++;
            }
            else if (first.length() + 1 == str.length()) {
                if (cnt == first.length())
                    result++;
            }

        }
        System.out.println(result);
    }
}