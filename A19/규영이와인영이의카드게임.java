package A19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 규영이와인영이의카드게임 {
	// 1명이 가지는 카드의 수
	static int n = 9;
	// 규영이와 인영이의 카드 집합
	static int[] kyu;
	static int[] inn;
	// 규영이가 이긴횟수, 인영이가 이긴횟수
	static int kyuWin;
	static int innWin;
	// 순열을 위한 boolean배열
	static boolean[] isSelected;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        // 모든 카드들
        int[] cards = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
        
        
        // TC의 수
        int TC = Integer.parseInt(br.readLine());
        
        // 각 TC별 수행
        for(int t=0; t<TC; t++) {
        	// 카드가 사용되었는지 여부 초기화
        	boolean[] used = new boolean[2*n];
        	// 규영이의 카드(kyu)입력받기
        	st = new StringTokenizer(br.readLine());
        	kyu = new int[n];
        	for(int k=0; k<n; k++) {
        		kyu[k] = Integer.parseInt(st.nextToken());
        		used[kyu[k]-1] = true;
        	}
        	
        	// 인영이의 카드들 찾아내기
        	inn = new int[n];
        	int i = 0;
        	for(int u=0; u<2*n; u++) {
        		// 규영이가 사용하지 않은 카드라면!! 인영이의 카드
        		if(!used[u]) {
            		inn[i] = cards[u];
            		i++;
            	}
        	}
        	// 규영이가 이긴횟수와 인영이가 이긴횟수 찾기
        	// 변수 초기화
        	kyuWin = 0;
        	innWin = 0;
        	isSelected = new boolean[n];
        	perm(0,0,0);
        	
        	sb.append("#" + (t+1) + " "+ kyuWin+ " " + innWin+"\n");
        }
        
        System.out.println(sb.toString());
        
	}
	
	
	// 순열 함수
	public static void perm(int cnt, int kyuSum, int innSum) {
		// 종료조건
		if(cnt == n) {
			if(kyuSum>innSum) {
				kyuWin++;
			}
			if(kyuSum<innSum) {
				innWin++;
			}
			return;
		}
		for(int i=0; i<n; i++) {
			if(isSelected[i]) {
				continue;
			}
			isSelected[i] = true;
			// kyu는 고정된 순서이므로, 현재 함수에 depth가 곧 규영이가 뽑을 카드
			// 인영이가 뽑을 카드는 인영이의 카드들 중 현재 선택된 i번째에 위치한 인영이의 카드
			// 규영이가 이긴경우
			if(kyu[cnt]>inn[i]) {
				perm(cnt+1, kyuSum+kyu[cnt]+inn[i], innSum);
			}
			// 인영이가 이긴경우
			else {
				perm(cnt+1, kyuSum, innSum+kyu[cnt]+inn[i]);
			}
			// i가 선택되지 않은 가짓수도 고려
			isSelected[i] = false;
		}
	}
}