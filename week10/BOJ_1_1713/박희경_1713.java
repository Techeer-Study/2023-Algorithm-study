package BOJ_1_1713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 박희경_1713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int total = Integer.parseInt(br.readLine());

        Student[] students = new Student[101];
        List<Student> list= new ArrayList<>();

        StringTokenizer st= new StringTokenizer(br.readLine());
        for (int i = 0; i < total; i++) {
            int num = Integer.parseInt(st.nextToken()); // 추천학생 번호

            if(students[num] == null) {
                students[num] = new Student(num, 0, 0, false);
            }

            // 게시된 적 있는 사람
            if(students[num].isPosted)
                students[num].cnt++; // 추천수 증가
            // 게시된 적 없는 사람
            else {
                // 게시판 꽉 참
                if(list.size() == N) {
                    list.sort((o1, o2) -> {
                        if (o1.cnt == o2.cnt) {
                            return o1.time - o2.time;
                        }
                        return o1.cnt - o2.cnt;
                    });
                    list.get(0).isPosted = false;
                    list.remove(0);
                }
                students[num].cnt = 1;
                students[num].time = i;
                students[num].isPosted = true;
                list.add(students[num]);
            }
        }

        //오름차순
        list.sort(Comparator.comparingInt(o -> o.num));
        for(Student i : list) {
            System.out.print(i.num + " ");
        }
    }

    static class Student{
        int num; // 학생 번호
        int cnt; //추천수
        int time; // 게시된 시간
        boolean isPosted; //게시판 여부

        public Student(int num, int cnt, int time, boolean isPosted) {
            this.num = num;
            this.cnt = cnt;
            this.time = time;
            this.isPosted = isPosted;
        }
    }
}
