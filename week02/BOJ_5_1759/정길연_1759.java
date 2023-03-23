package BOJ_5_1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

    public class 정길연_1759 {

        static int L, C;
        static String[] inputStr, strArr;
        static String[] essential = {"a","e","i","o","u"};

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            strArr = new String[L];

            st = new StringTokenizer(br.readLine());
            inputStr = new String[C];
            for (int i = 0; i < C; i++) {
                inputStr[i] = st.nextToken();
            }
            Arrays.sort(inputStr);

            // 최소 한개 모음, 최소 2개 자음
            comb(0, 0);
        }

        private static void comb(int startIdx, int cnt) {
            if (cnt == L) {
                if (check(strArr)) {
                    for (String s : strArr) {
                        System.out.print(s);
                    }
                    System.out.println();
                }
                return;
            }
            for (int i = startIdx; i < C; i++) {
                strArr[cnt] = inputStr[i];
                comb(i + 1, cnt + 1);
            }

        }

        private static boolean check(String[] strArr) {
            int ja = 0;
            int mo = 0;
            for (int i = 0; i < strArr.length; i++) {
                if(Arrays.asList(essential).contains(strArr[i])) mo ++;
                else ja ++;
            }
            if (mo >= 1 && ja >= 2) return true;
            else return false;
        }
    }
