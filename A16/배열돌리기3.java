package A16;

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

public class 배열돌리기3 {
	
	static int row;
	static int col;
	static int R;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        // 행의 크기
        row = Integer.parseInt(st.nextToken());
        // 열의 크기
        col = Integer.parseInt(st.nextToken());
        // 연산의 수
        R = Integer.parseInt(st.nextToken());
        
        // 배열 입력받기
        int[][] arr = new int[row][col];
        
        for(int r=0; r<row; r++) {
        	st = new StringTokenizer(br.readLine());
        	for(int c=0; c<col; c++) {
        		arr[r][c] = Integer.parseInt(st.nextToken()); 
        	}
        }
        
        // 연산 입력받기
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<R; i++) {
        	int op = Integer.parseInt(st.nextToken());
        	switch(op){
        		case 1:
        			arr = op1(arr);
        			break;
        		case 2:
        			arr = op2(arr);
        			break;
        		case 3:
        			arr = op3(arr);
        			break;
        		case 4:
        			arr = op4(arr);
        			break;
        		case 5:
        			arr = op5(arr);
        			break;
        		case 6:
        			arr = op6(arr);
        			break;
        	}
        }
        
        //
        for(int[] arr1 : arr) {
        	for(int e: arr1) {
        		sb.append(e).append(" ");
        	}
        	sb.append("\n");
        }
        System.out.println(sb.toString());
	}
	// 연산 1
	public static int[][] op1(int[][] arr){
		int[][] new_arr = new int[row][col];
		for(int c=0; c<col; c++) {
			for(int r=0; r<row/2; r++) {
				new_arr[r][c] = arr[row-r-1][c];
				new_arr[row-r-1][c] = arr[r][c];
			}
		}
		return new_arr;
	}
	// 연산2
	public static int[][] op2(int[][] arr){
		int[][] new_arr = new int[row][col];
		for(int r=0; r<row; r++) {
			for(int c=0; c<col/2; c++) {
				new_arr[r][c] = arr[r][col-c-1];
				new_arr[r][col-c-1] = arr[r][c];
			}
		}
		return new_arr;
	}
	//연산3
	public static int[][] op3(int[][] arr){
		int[][] newArr = new int[col][row];
			
			for(int c=0; c<col; c++) {
				int[] add = new int[row];
				for(int r=0; r<row; r++) {
					newArr[c][r] = arr[row-1-r][c];
				}
			}
			int temp = col;
			col = row;
			row = temp;
			return newArr;
	}
	// 연산4
	public static int[][] op4(int[][] arr){
		int[][] newArr = new int[col][row];
		
		for(int c=0; c<col; c++) {
			for(int r=0; r<row; r++) {
				newArr[c][r] = arr[r][col-1-c];
			}
		}
		int temp = col;
		col = row;
		row = temp;
		return newArr;
	}
	// 연산 5
	public static int[][] op5(int[][] arr){
		int[][] newArr = new int[row][col];
		
		// 1사분면 -> 2사분면
		for(int r = 0 ; r < row / 2 ; ++r) {
			for(int c = 0 ; c < col / 2 ; ++c) {
				newArr[r][c + col / 2] = arr[r][c];
			}
		}
		
		// 2사분면 -> 3사분면
		for(int r = 0 ; r < row / 2 ; ++r) {
			for(int c = col / 2 ; c < col ; ++c) {
				newArr[r + row / 2][c] = arr[r][c];
			}
		}
		
		// 3사분면 -> 4사분면
		for(int r = row / 2 ; r < row; ++r) {
			for(int c = col / 2 ; c < col; ++c) {
				newArr[r][c - col / 2] = arr[r][c];
			}
		}
		
		// 4사분면 -> 1사분면 
		for(int r = row / 2 ; r < row; ++r) {
			for(int c = 0 ; c < col / 2; ++c) {
				newArr[r - row / 2][c] = arr[r][c];
			}
		}
		
		return newArr;
	}
	// 연산 6
		public static int[][] op6(int[][] arr){
			int[][] newArr = new int[row][col];
			
			// 1사분면 -> 4사분면
			for(int r = 0 ; r < row / 2 ; ++r) {
				for(int c = 0 ; c < col / 2 ; ++c) {
					newArr[r + row / 2][c] = arr[r][c];
				}
			}
			
			// 4사분면 -> 3사분면
			for(int r = row / 2 ; r < row; ++r) {
				for(int c = 0 ; c < col / 2 ; ++c) {
					newArr[r][c + col / 2] = arr[r][c];
				}
			}
			
			// 3사분면 -> 2사분면
			for(int r = row / 2 ; r < row; ++r) {
				for(int c = col/ 2 ; c < col; ++c) {
					newArr[r - row / 2][c] = arr[r][c];
				}
			}
			
			// 2사분면 -> 1사분면 
			for(int r = 0 ; r < row / 2 ; ++r) {
				for(int c = col / 2 ; c < col ; ++c) {
					newArr[r][c - col / 2] = arr[r][c];
				}
			}
			
			return newArr;
		}
}
