package A15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 배열돌리기1 {
	static int row;
	static int col;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        // 행의 크기
        row = Integer.parseInt(st.nextToken());
        // 열의 크기
        col = Integer.parseInt(st.nextToken());
        // 회전 횟수
        int R = Integer.parseInt(st.nextToken());
        // 배열 입력받기
        int[][] arr = new int[row][col];
        for(int r=0; r<row; r++) {
        	st = new StringTokenizer(br.readLine());        	
        	for(int c=0; c<col; c++) {
        		arr[r][c] = Integer.parseInt(st.nextToken());
        	}
        }
        
        // R만큼 회전
        for(int i=0; i<R; i++) {
        	arr = rotate(arr);
        }
//        arr = rotate(arr);
        for(int r=0; r<row; r++) {
        	for(int c=0; c<col; c++) {
        		sb.append(arr[r][c]).append(" ");
        	}
        	sb.append("\n");
        }
        
        System.out.println(sb.toString());
	}
	public static int[][] rotate(int[][] arr){
		int[][] new_arr = new int[row][col];
		// 회전도움
		int[] dr = {0,1,0,-1};
		int[] dc = {1,0,-1,0};
		// 회전시켜야 하는 것의 수
		int num = Math.min(row,col)/2;
		
		for(int n=0; n<num; n++) {
			// 시작점
			int r = n;
			int c = n;
			// 회전방향
			int dir = 0;
			// 한 회전이 완료될 때까지 new_arr[][]==0
			while(new_arr[r][c]==0) {
				int new_r = r+dr[dir];
				int new_c = c+dc[dir];
				dir = dir%4;
				// 이동 가능한 곳인 경우
				if(new_r>=n && new_r<row-n && new_c>=n && new_c<col-n) {
					new_arr[r][c] = arr[new_r][new_c];
					r = new_r;
					c = new_c;
				}
				// 불가능시 방향 전환
				else {
					dir++;
				}
			}
			
		}
		// 회전하지 않은 부분이 있는 경우
		if(row<col && row%2==1) {
			for(int c=num; c<col-num; c++) {
				new_arr[num][c] = arr[num][c];
			}
		}
		if(col<=row && col%2==1) {
			for(int r=num; r<row-num; r++) {
				new_arr[r][num] = arr[r][num];
			}
		}
		
		
		return new_arr;
	}
}