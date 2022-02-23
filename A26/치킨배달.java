package A26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 치킨배달 { // 좌표에 집중하여 조합을 이용하여 풀이
	static int N;
	static int totalChicken;
	static int M;
	static int chickenDist = Integer.MAX_VALUE;
	static boolean[] isSelected;
	static List<int[]> home;
	static List<int[]> chicken;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]); // 도시의 크기
		M = Integer.parseInt(temp[1]); // 남길 치킨집의 수
		
		home = new ArrayList<>(); // 집의 좌표들의 모임
		chicken = new ArrayList<>(); // 치킨집의 좌표들의 모임
		
		for(int r=0; r<N; r++) {
			temp = br.readLine().split(" ");
			for(int c=0; c<N; c++) {
				if(Integer.parseInt(temp[c]) == 1) { // 집이라면
					home.add(new int[] {r,c});
				}
				else if(Integer.parseInt(temp[c]) == 2) { // 치킨집이라면
					chicken.add(new int[] {r,c});
				}
			}
		}
		
		totalChicken = chicken.size();
		isSelected = new boolean[totalChicken];
		// 조합 사용 total chicken 중 M개 선택
		comb(0, 0);
		sb.append(chickenDist);
		System.out.println(sb.toString());
	}
	private static void comb(int start, int cnt) {
		// 종료조건
		if(cnt == M) { // M개 선정!
//			for(int i=0; i<totalChicken; i++) {
//				if(isSelected[i]) {
//					System.out.print(chicken.get(i)[0] + " " + chicken.get(i)[1] + "| ");
//				}
//				else {
//					System.out.print("     ");
//				}
//			}
//			System.out.println();
			// 집별로 가장 가까운 치킨집과의 거리 계산
			int total = 0;
			for(int i=0; i< home.size(); i++) {
				int myDist = Integer.MAX_VALUE;
				// 치킨 집들에 대하여
				for(int c=0; c<totalChicken; c++) {
					if(isSelected[c]) { // 장사하는 치킨집인 경우
						int newDist = Math.abs(home.get(i)[0] - chicken.get(c)[0]) + Math.abs(home.get(i)[1] - chicken.get(c)[1]);
						if(newDist < myDist) { // 새 치킨집이 기존 치킨집보다 가깝다면 갱신
							myDist = newDist;
						}
					}
				}
				total += myDist;
			}
			chickenDist = Math.min(chickenDist, total);
			return;
		}
		
		for(int i=start; i<totalChicken; i++) {
			isSelected[i] = true;
			comb(i+1, cnt+1);
			isSelected[i] = false;
		}
		
	}
}
