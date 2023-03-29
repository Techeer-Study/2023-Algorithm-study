package week03.BOJ_2_2816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 강용민_2816{

    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        boolean flag1=false,flag2 = false;
        for(int n = 0; n<N;n++){
            String channel = br.readLine();
            if(channel.equals("KBS1")){
                flag1 = true;
            }else if(channel.equals("KBS2")){
                if(!flag1){
                    sb2.insert(0,"1");
                    sb2.append("4");
                }
                sb2.setLength(sb2.length()-1);
                flag2 = true;
            }
            if(!flag1){
                sb1.insert(0,"1");
                sb1.append("4");
            }
            if(!flag2){
                sb2.insert(0,"1");
                sb2.append("4");
            }
            if(flag1&&flag2) break;
        }
        System.out.println(sb1.toString()+sb2.toString());
    }
}