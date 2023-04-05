package week04.BOJ_3_1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 강용민_1021{
    public static void main(String[] args) throws NumberFormatException, IOException{
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //queue 생성
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            queue.offer(i);
        }

        //뽑아야하는거
        Queue<Integer> targets = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M; i++){
            targets.offer(Integer.parseInt(st.nextToken()));
        }

        while(!targets.isEmpty()){
            int target_idx = queue.indexOf(targets.poll());
            int half_idx = (queue.size() % 2 == 0)?queue.size()/2-1 : queue.size()/2;
            if(target_idx <= half_idx){
                for(int i = 0; i < target_idx; i++){
                    queue.offer(queue.poll());
                    answer++;
                }
            }else{
                for(int i = 0; i < queue.size() - target_idx; i++){
                    queue.offerFirst(queue.pollLast());
                    answer++;
                }
            }
            queue.poll();
        }
       System.out.println(answer);
    }
}