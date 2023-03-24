package week02.BOJ_5_1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 강용민_1759{
    public static int L,C;
    public static char[] inputs;
    public static char[] pwds;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        inputs = new char[C];
        pwds = new char[L];
        for(int i = 0; i<C;i++)
            inputs[i] = st.nextToken().charAt(0);
        Arrays.sort(inputs);
        comb(0,0);
    }

    public static void comb(int cnt,int idx){
        if(cnt==L){
            if(valid()){
                StringBuilder sb = new StringBuilder();
                for(char ch : pwds) 
                    sb.append(ch);
                System.out.println(sb);
            }
            return;
        }

        for(int i = idx; i < C;i++){
            pwds[cnt] = inputs[i];
            comb(cnt+1,i+1);
        }
    }

    public static boolean valid(){
        int cons = 0,vowel = 0;
        for(char ch : pwds){
            if(ch == 'a' || ch == 'e' || ch=='i' || ch=='o' || ch=='u')
                cons++;
            else
                vowel++;
        }
        return (cons < 1 || vowel <2) ?false :true;
    }
}