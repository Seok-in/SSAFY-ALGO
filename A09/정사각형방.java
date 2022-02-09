package A09;

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

public class 정사각형방 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        // TC의 갯수
        int TC = Integer.parseInt(br.readLine());
        // TC 수행
        for(int t=0; t<TC; t++) {
        	
        	// 방의 크기(N x N)
        	int N = Integer.parseInt(br.readLine());
        	// 방 입력받기
        	int[][] room = new int[N][N];
        	for(int r=0; r<N; r++) {
        		st = new StringTokenizer(br.readLine());
        		for(int c=0; c<N; c++) {
        			room[r][c] = Integer.parseInt(st.nextToken());
        		}
        	}
        	// 방문할 수 있는 방의 최댓값
        	int max = -1;
        	// 방문할 수 있는 방의 최댓값이 되게 하는 위치
        	int ans_r = -1;
        	int ans_c = -1;
        	
        	// 완전탐색으로 풀이
        	for(int row = 0; row<N; row++) {
        		for(int col=0; col<N; col++) {
        			
        			// 현재 위치
        			int r = row;
        			int c = col;
        			// 현재방을 기점으로 방문할 수 있는 방들의 최댓값
        			int temp_max = 1;
        			// 이동하는 알고리즘
        			while(true) {
        				// 모든 방의 수가 다르기에 쓸 수 있는 방법
        				// 아래로 이동 가능시
        				if(r+1 < N && room[r+1][c]== room[r][c]+1) {
        					r += 1;
        					temp_max+=1;
        					continue;
        				}
        				// 위로 이동 가능시
        				else if(r-1 >= N && room[r-1][c]== room[r][c]+1) {
        					r -= 1;
        					temp_max+=1;
        					continue;
        				}
        				// 오른쪽으로 이동 가능시
        				else if(c+1 < N && room[r][c+1]== room[r][c]+1) {
        					c += 1;
        					temp_max+=1;
        					continue;
        				}
        				// 왼쪽으로 이동 가능시
        				else if(c-1 >= 0  && room[r][c-1]== room[r][c-1]+1) {
        					c -= 1;
        					temp_max+=1;
        					continue;
        				}
        				// 이동불가시 종료
        				else {
        					// 현재 방에서 찾은 최대 방수가 이전의 최대 방수 보다 큰 경우, 이전 ans를 비우고 현재 위치 추가
        					if(temp_max>max) {
        						max = temp_max;
        						ans_r = row;
        						ans_c = col;
        					}
        					
        					break;
        				}
        			}
        		}
        	}
        	
        	
        	
        	// StringBuilder에 정답 저장
        	sb.append("#"+(t+1));
        	sb.append(" " + room[ans_r][ans_c]);
        	sb.append(" " + max);
        	sb.append("\n");
        }
        System.out.println(sb.toString());
        
	}
	
	
}