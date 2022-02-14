package A20;

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

public class 도영이가만든맛있는음식 {
	static int n;
	static int[][] ingredients;
	static int min = Integer.MAX_VALUE;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        // 재료의 수
        n = Integer.parseInt(br.readLine());
		// 재료 입력받기 크기 : nx2 재료 n개, 재료별 맛 2개
        ingredients = new int[n][2];
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	ingredients[i][0] = Integer.parseInt(st.nextToken());
        	ingredients[i][1] = Integer.parseInt(st.nextToken());
        }
		
        isSelected = new boolean[n];
		subset(0);
		sb.append(min);
        System.out.println(sb.toString());
	}
	
	public static void subset(int cnt) {
		if(cnt == n) {
			// 신맛 총합
			int sourSum = 1;
			// 쓴맛 총합
			int bitterSum = 0;
			// 사용된 재료의 수(공집합 체크용)
			int ingNum = 0;
			for(int i=0; i<n; i++) {
				if(isSelected[i]) {
					sourSum *= ingredients[i][0];
					bitterSum += ingredients[i][1];
					ingNum ++;
				}
			}
			// 선택된 재료가 1개이상인경우에만.
			if(ingNum != 0) {
				if(min>Math.abs(sourSum-bitterSum)) {
					min = Math.abs(sourSum-bitterSum);
				}
			}
			return;
		}
		
		isSelected[cnt] = true;
		subset(cnt+1);
		isSelected[cnt] = false;
		subset(cnt+1);
		
	}
}