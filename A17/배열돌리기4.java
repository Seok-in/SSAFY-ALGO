package A17;

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

public class 배열돌리기4 {
	static int row;
	static int col;
	// 순열을 위한 변수
	static int perm_n;
	static int perm_r;
	static int[] num;
	static boolean[] isSelected;
	static List<int[]> mine = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int min = Integer.MAX_VALUE;
        
        st = new StringTokenizer(br.readLine());
        // 행의 크기
        row = Integer.parseInt(st.nextToken());
        // 열의 크기
        col = Integer.parseInt(st.nextToken());
        // 연산의 수
        int K = Integer.parseInt(st.nextToken());
        // 배열 입력받기
        int[][] arr = new int[row][col];
        int[][] temp_arr = new int[row][col];
        
        for(int r=0; r<row; r++) {
        	st = new StringTokenizer(br.readLine());        	
        	for(int c=0; c<col; c++) {
        		arr[r][c] = Integer.parseInt(st.nextToken());
        		temp_arr[r][c] = arr[r][c];
        	}
        }
        // 연산 입력받기
        int[][] ops = new int[K][3];
        for(int r=0; r<K; r++) {
        	st = new StringTokenizer(br.readLine());
        	for(int c=0; c<3; c++) {
        		ops[r][c] = Integer.parseInt(st.nextToken());
        	}
        }
        // 연산들을 줄세우는 방법을 순열을 이용하여 구함
        perm_n = K;
        perm_r = K;
        num = new int[perm_r];
        isSelected = new boolean[perm_n];
        perm(0);
		
        // 연신들을 줄세우는 모든 방법들에 대하여 for문
        for(int[] order: mine) {
        	int[][] my_ops = new int[K][3];
        	for(int i =0; i<K; i++) {
        		my_ops[i] = ops[order[i]];
        	}
        	// 연산을 시행
	        for(int[] op : my_ops) {
	        	// 정사각형이라 했으므로 나가는 부분 고려 안해도 괜찮.
	        	int start_r = op[0]-1-op[2];
	        	int start_c = op[1]-1-op[2];
	        	row = op[2]*2 + 1;
	        	col = op[2]*2 + 1;
	        	int[][] temp = new int[row][col];
	        	for(int r=0; r<row; r++) {
	        		for(int c=0; c<col; c++) {
	        			temp[r][c] = arr[start_r+r][start_c+c];
	        		}
	        	}
	        	// 특정 부분 회전
	        	temp = rotate(temp);
	        	for(int r=0; r<row; r++) {
	        		for(int c=0; c<col; c++) {
	        			arr[start_r+r][start_c+c] = temp[r][c];
	        		}
	        	}

	        }
	        // 최솟값 비교
	        for(int[] ae: arr) {
	        	int row_sum = 0;
	        	for(int e : ae) {
	        		row_sum += e;
	        	}
	        	if(row_sum<min) {
	        		min = row_sum;
	        	}
	        }
	        arr = temp_arr;
        }

        sb.append(min);
        System.out.println(sb.toString());
	}
	
	// 시계방향 회전 함수
	public static int[][] rotate(int[][] arr){
		int[][] new_arr = new int[row][col];
		// 회전도움
		int[] dr = {1,0,-1,0};
		int[] dc = {0,1,0,-1};
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
	
	// 순열 함수
	public static void perm(int cnt) {
		// 종료조건
		if(cnt == perm_r) {
			
			int[] temp = new int[perm_r];
			for(int i=0; i<perm_r; i++) {
				temp[i] = num[i];
			}			
			// 순열의 경우의 수들을 보관
			mine.add(temp);
			
			return;
		}
		for(int i=0; i<perm_n; i++) {
			if(isSelected[i]) {
				continue;
			}
			num[cnt] = i;
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i] = false;
		}
	}
}