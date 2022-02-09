package B05;

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

public class Ladder1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        // TC의 갯수
        int TC = 10;
        // 사다리게임판의 크기
        int N = 100;
        // TC 수행
        for(int t=0; t<TC; t++) {
        	
        	// 해당 TC의 번호
        	int tcNum = Integer.parseInt(br.readLine());
        	// 사다리게임 입력받기
        	
        	int [][] ladderGame = new int[N][N];
        	for(int r=0; r<N; r++) {
        		st = new StringTokenizer(br.readLine());
        		for(int c=0; c<N; c++) {
        			ladderGame[r][c] = Integer.parseInt(st.nextToken());
        		}
        	}
        	// 시작지점 찾기
        	List<Integer> startPoints = new ArrayList<>();
        	for(int c=0; c<N; c++) {
        		if(ladderGame[0][c] == 1) {
        			startPoints.add(c);
        		}
        	}
        	// 꽝인 시작지점 찾기
        	int ans = -1;
        	for(int startPoint : startPoints) {
        		// 시작 좌표 지정
        		int cur_r = 0;
        		int cur_c = startPoint;
        		
        		
        		while(true) {
        			// 종료조건 : 사다리의 끝(r==99)인 부분에 도달
        			if(cur_r==99) {
        				// 꽝인 경우
        				if(ladderGame[cur_r][cur_c] == 2) {
        					ans = startPoint;
        				}
        				break;
        			}
        			// 좌/우 이동 가능시 우선 이동
        			// 좌
        			if(cur_c-1>=0 && ladderGame[cur_r][cur_c-1] == 1) {
	        			while(cur_c-1>=0 && ladderGame[cur_r][cur_c-1] == 1) {
	        				cur_c -= 1;
	        			}
        				cur_r+=1;
	        			continue;
	        		}
	        		// 우
        			if(cur_c+1<N && ladderGame[cur_r][cur_c+1] == 1) {
	        			while(cur_c+1<N && ladderGame[cur_r][cur_c+1] == 1) {
	        				cur_c += 1;
	        			}
	        			cur_r += 1;
	        			continue;	        			
	        		}
	        		// 좌우 이동 불가시 아래 이동
	        		cur_r += 1;
	        		
        		}
        		// for문 종료를 위한 문장 : ans가 -1이 아니라는 것은 답을 찾았다는 뜻이기에 for문 종료 
        		if(ans != -1) {
        			break;
        		}
        	}
        	
        	// StringBuilder에 정답 저장
        	sb.append("#"+tcNum);
        	sb.append(" " + ans);
        	sb.append("\n");
        }
        System.out.println(sb.toString());
        
	}
}