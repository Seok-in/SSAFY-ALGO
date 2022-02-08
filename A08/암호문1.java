package A08;

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

public class 암호문1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        // TC의 갯수
        int TC = 10; 
        // TC 수행
        for(int i=0; i<TC; i++) {
        	// 원본 암호문의 길이
        	int pwLen = Integer.parseInt(br.readLine());
        	st = new StringTokenizer(br.readLine());
        	// queue로 원본 암호문 입력받기
        	List<Integer> pw = new LinkedList<>();
        	// 원본 암호문 입력받기
        	for(int j=0; j<pwLen; j++) {
        		pw.add(Integer.parseInt(st.nextToken()));
        	}
        	
        	// 명령어의 갯수
        	int cmdLen = Integer.parseInt(br.readLine());
        	st = new StringTokenizer(br.readLine());
        	// 명령어 수행
        	for(int cmd = 0; cmd<cmdLen; cmd ++) {
        		// 불편...
        		if(st.nextToken().equals("I")) {
        			
        			int place = Integer.parseInt(st.nextToken());
        			int nLen = Integer.parseInt(st.nextToken());
        			for(int n=0; n<nLen; n++) {
        				pw.add(place, Integer.parseInt(st.nextToken()));
        				place ++;
        			}
        		}
        	}
        	sb.append("#"+(i+1));
        	for(int j=0; j<10; j++) {
        		sb.append(" "+pw.get(j));
        	}
        	sb.append("\n");
        }
        
        System.out.println(sb.toString());
	}
}