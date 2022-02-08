package B04;

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

public class 한빈이와SpotMart {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        // TC의 갯수
        int TC = Integer.parseInt(br.readLine());; 
        // TC 수행
        for(int i=0; i<TC; i++) {
        	st = new StringTokenizer(br.readLine());
        	// 과자의 수
        	int N = Integer.parseInt(st.nextToken());
        	// 한빈이가 들수 있는 최데 무게
        	int M = Integer.parseInt(st.nextToken());
        	// 한빈이가 들고 갈 과자의 무게
        	int mySnack = -1;
        	// 과자들의 무게 입력받기
        	st = new StringTokenizer(br.readLine());
        	int snacks[] = new int[N];
        	for(int j=0; j<N; j++) {
        		snacks[j] = Integer.parseInt(st.nextToken());
        	}
        	
        	// 완전탐색으로 풀이
        	for(int s1=0; s1<N-1; s1++) {
        		for(int s2=0; s2<N; s2++) {
        			int temp = snacks[s1]+snacks[s2];
        			// 한빈이가 들 수 있고, 현재 한빈이가 들고있는 과자의 양보다 무거울때,
        			if(temp<=M && temp>mySnack) {
        				mySnack = temp;
        			}
        		}
        	}
        	
        	sb.append("#"+(i+1));
        	sb.append(" "+mySnack);
        	sb.append("\n");
        }
        System.out.println(sb.toString());
	}
	
	
}