package D02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 요리사 {
	static int [][] S;
	static int N;
	static boolean[] isSelected;
	static int minDiff;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine()); // 테스트케이스의 수
		
		// 테스트케이스별 수행
		for(int t=0; t<TC; t++) {
			N = Integer.parseInt(br.readLine()); // 식재료의 수
			
			// 식재료의 시너지 리스트 입력받기
			S = new int[N][N];
			for(int r=0; r<N; r++) {
				String[] temp = br.readLine().split(" ");
				for(int c=0; c<N; c++) {
					S[r][c] = Integer.parseInt(temp[c]);
				}
			}
			
			// 문제 풀이 알고리즘 시작
			// 조합으로 경우를 고려하여 음식간의 맛의 차이 계산
			isSelected = new boolean[N];
			minDiff = Integer.MAX_VALUE;
			myComb(0,0);
			
			sb.append("#").append(t+1).append(" ").append(minDiff).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	private static void myComb(int cnt, int start) {
		// 종료조건
		if(cnt==N/2) {
			int taste1 = 0;
			int taste2 = 0;
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					for(int j=0; j<N; j++) {
						if(isSelected[j]) {
							taste1 += S[i][j];
						}
					}
				}
				else {
					for(int j=0; j<N; j++) {
						if(!isSelected[j]) {
							taste2 += S[i][j];
						}
					}
				}
			}
			minDiff = Math.min(minDiff, Math.abs(taste1-taste2));
		}
		for(int i=start; i<N; i++) {
			isSelected[i] = true;
			myComb(cnt+1,i+1);
			isSelected[i] = false;
		}
		
	}
}
