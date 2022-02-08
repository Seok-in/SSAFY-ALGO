package A07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class 암호생성기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        // TC의 갯수
        int TC = 10; 
        // TC 수행
        for(int i=0; i<TC; i++) {
        	int TC_num = Integer.parseInt(br.readLine());
        	st = new StringTokenizer(br.readLine());
        	// queue으로 암호 입력받기
        	Queue<Integer> pw = new LinkedList<>();
        	for(int j=0; j<8; j++) {
        		pw.add(Integer.parseInt(st.nextToken()));
        	}
        	// 입력받은 암호로 알고리즘 돌기
        	int cnt = 1;
        	while(true) {
        		int temp = pw.poll();
        		// 종료 조건(첫원소에서 cnt를 뺀값이 0이거나 0보다 작아지는 경우)
        		if(temp-cnt <= 0) {
        			pw.add(0);
        			sb.append("#"+TC_num);
        			for(int e : pw) {
        				sb.append(" "+e);
        			}
        			sb.append("\n");
        			break;
        		}
        		// 종료조건이 아닌경우
        		pw.add(temp-cnt);
        		// cnt가 5인경우 1로 만듬
        		if(cnt==5) {
        			cnt = 1;
        		}
        		// 그 외의 경우에는 1씩 증가
        		else {
        			cnt++;
        		}
        		
        		
        	}
        }
        System.out.println(sb.toString());
	}
}