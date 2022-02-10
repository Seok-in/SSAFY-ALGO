package A13;

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

public class 요세푸스문제 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        sb.append("<");
        
        st = new StringTokenizer(br.readLine());
        // 사람의 수
        int N = Integer.parseInt(st.nextToken());
        // 제거될 사람
        int K = Integer.parseInt(st.nextToken());
        
        // queue를 이용하여 문제해결
        Queue<Integer> yo = new LinkedList<>();
        // queue에 초깃값들 입력
        for(int i=1; i<=N; i++) {
        	yo.offer(i);
        }
        // 문제풀이 알고리즘
        // queue에 원소가 존재하는 동안 진행
        while(!yo.isEmpty()) {
        	// K-1번째까지를 queue에서 뺀뒤 queue의 맨 뒤로 붙인다.
        	for(int i=0; i<K-1; i++) {
        		yo.offer(yo.poll());
        	}
        	// K번째가 맨앞에 와있을텐데 꺼내어 sb에 추가
        	if(yo.size()==1) {
        		sb.append(yo.poll());
        	}
        	else {
        		sb.append(yo.poll()+", ");	
        	}
        	
        	
        }
        sb.append(">");
        System.out.println(sb.toString());
	}
	
	
}