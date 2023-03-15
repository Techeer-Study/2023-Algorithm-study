import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 정길연_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] numArr = new int[n];
        for(int i=0; i<n; i++){
            numArr[i] = Integer.parseInt(br.readLine());
        }

        int[] result = bubbleSort(numArr, n);
        for(int item : result)
            System.out.println(item);

    }
    private static int[] bubbleSort(int[] numArr, int numLength){
        for(int i= 0; i<numLength; i++){
            for(int j = 0; j<numLength-1-i; j++){
                if(numArr[j] > numArr[j+1]) swap(numArr,j,j+1);
            }
        }
        return numArr;
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
