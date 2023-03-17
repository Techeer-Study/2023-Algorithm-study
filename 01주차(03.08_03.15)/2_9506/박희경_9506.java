import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 박희경_9506 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int input = Integer.parseInt(br.readLine()); // int형으로 받기
            int sum = 0;

            if (input == -1)
                break;

            for (int i = 1; i < input; i++)
                if (input % i == 0) {
                    sb.append(i).append(" + ");
                    sum += i;
                }
            System.out.println(input == sum ? input + " = " + sb.substring(0, sb.length() - 3) : input + " is NOT perfect.");
        }
    }
}