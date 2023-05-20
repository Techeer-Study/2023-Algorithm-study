package week11.BOJ_1_1058;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class 최준혁_1058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            List<Integer> f = new ArrayList<>();

            String[] sArray = br.readLine().split("");
            for (int j = 0; j < sArray.length; j++) {
                if (sArray[j].equals("N")) continue;
                f.add(j);
            }
            graph.add(f);
        }

        Map<Integer, Set<Integer>> friendMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            friendMap.put(i, new HashSet<>(graph.get(i)));
            Set<Integer> pureFriend = friendMap.get(i);
            Set<Integer> twoDepthFriend = new HashSet<>();

            for (int p : pureFriend) {
                List<Integer> friends = graph.get(p);
                twoDepthFriend.addAll(friends);
            }

            pureFriend.addAll(twoDepthFriend);
        }

        int max = friendMap.values()
                .stream()
                .max((s1, s2) -> s1.size() - s2.size())
                .get()
                .size() - 1;

        if (max < 0) System.out.println(0);
        else System.out.println(max);

        int[] a = {1,2,3};
    }
}
