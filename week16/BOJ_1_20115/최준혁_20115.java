package week16.BOJ_1_20115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 최준혁_20115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Double> drinks = Arrays.stream(br.readLine().split(" "))
                .map(Double::valueOf)
                .collect(Collectors.toList());

        Double max = Collections.max(drinks);
        drinks.remove(max);

        double total = max;

        for (double i : drinks) {
            total += (i / 2);
        }

        System.out.println(total);
    }
}
