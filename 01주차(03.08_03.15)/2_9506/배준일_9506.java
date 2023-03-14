import java.io.*;
import java.util.*;

public class Main {
    private static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        List<Integer> inputList = new ArrayList<Integer>();

        while(true) {
            int input = Integer.parseInt(br.readLine()); // int형으로 받기
            int sum = 0;
            inputList.clear(); // 리스트 내부 초기화
            sb.setLength(0); // StringBuffer 초기화

            if(input == -1) { // -1이 들어온 경우
                break;
            }

            for(int i = 1; i < input + 1; i++) {
                if(input % i == 0) { // 약수이고 자기 자신이 아닌 경우 추가
                    inputList.add(i); // 약수를 inputList에 추가
                    sum += i; // 약수들의 합 저장 -> 약수의 합 중 자기 자신까지 더해진 상태
                }
            }

            inputList.sort(Comparator.naturalOrder()); // 오름차순 정렬

            if(sum - input == input) { // 현재 자기 자신까지 더해진 상태라 sum - input이 input과 같아야 한다.
                sb.append(input).append(" = 1"); // 약수에 1이 무조건 들어가므로 추가
                for(int i = 1; i < inputList.size() - 1; i++) { // 1을 제외한 나머지 약수들 StringBuffer에 저장
                    sb.append(" + ").append(inputList.get(i));
                }
            }
            else{ // 아닌 경우
                sb.append(input).append(" is NOT perfect.");
            }

            System.out.println(sb);
        }
    }
    public static void main(String[] args) throws Exception {
        solution();
    }
}