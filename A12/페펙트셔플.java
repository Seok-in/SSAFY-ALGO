package A12;

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

public class 페펙트셔플 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        
        // TC의 갯수
        int TC = Integer.parseInt(br.readLine());
        // TC 수행
        for(int t=0; t<TC; t++) {
        	
        	// 카드의 수
        	int N = Integer.parseInt(br.readLine());
        	// 카드 입력받기
        	String temp = br.readLine();
        	String[] cards =  temp.split(" ");
        	Queue<String> total = new LinkedList<>();
        	for(String card : cards) {
        		total.offer(card);
        	}
        	
        	Queue<String> left = new LinkedList<>();
        	Queue<String> right = new LinkedList<>();
        	
        	for(int i=0; i< cards.length; i++) {
        		if(i<cards.length/2) {
        			left.offer(total.poll());
        		}
        		else {
        			right.offer(total.poll());
        		}
        	}
        	// 카드으 총 수가 홀수 인 경우 왼쪽에 하나 더 주기 위한 보정.. 불편
        	if(left.size()<right.size()) {
        		left.offer(right.poll());
        	}
        	// turn이 0이면 left에서, 1이면 right에서 카드 꺼내오기
        	int turn = 0;
        	while(!left.isEmpty() || !right.isEmpty()) {
        		if(turn == 0) {
        			total.offer(left.poll());
        			turn = 1;
        		}
        		else {
        			total.offer(right.poll());
        			turn = 0;
        		}
        	}
        	
        	// StringBuilder에 정답 저장
        	sb.append("#"+(t+1));
        	for(String card : total) {
        		sb.append(" " + card);	
        	}
        	sb.append("\n");
        }
        System.out.println(sb.toString());
        
	}
	
	
}