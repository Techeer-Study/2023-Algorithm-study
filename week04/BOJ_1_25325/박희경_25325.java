import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 박희경_25325 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s;

        HashMap<String, Integer> students = new HashMap<>(); // 이름:인기도

        for(int i = 0; i < n; i++) {
            students.put(st.nextToken(), 0); // 이름:0

        }
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()) {
                s = st.nextToken();
                students.put(s, students.get(s) + 1);
            }
        }

        List<String> keyList = new ArrayList<>(students.keySet());
        keyList.sort((o1, o2) -> (students.get(o2).compareTo(students.get(o1))));

        for (String key : keyList) {
            System.out.println(key + " " + students.get(key));
        }
    }
}