package B09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쿼드트리 {
	static int N;
	static char[][] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine()); // 배열의 크기
		
		// 압축할 파일 입력받기
		arr = new char[N][N];
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		quadTree(0,0,N);
		System.out.println(sb.toString());
	}
	
	private static void quadTree(int row, int col, int n) {
		char init = arr[row][col];// 처음 문자
		// 주어진 범위내의 문자들이 모두 init와 같은지 확인 -> 다른게 발견되면 4조각으로 뽀개기 -> 각조각들을 다시 quadTree보냄
		for(int r=row; r<row+n; r++) {
			for(int c=col; c<col+n; c++) {
				if(arr[r][c]!=init) {
					sb.append("(");
//					System.out.print("(");
					// 1사분면
					quadTree(row,col,n/2);
					// 2사분면
					quadTree(row,col+n/2,n/2);
					// 3사분면
					quadTree(row+n/2,col,n/2);
					// 4사분면
					quadTree(row+n/2,col+n/2,n/2);
					sb.append(")");
//					System.out.print(")");
					return;
				}
			}
		}
		// 범위내의 문자가 모두 같은 경우
		sb.append(init);
//		System.out.print(init);
	}
}
