package A24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 서로소집합 {
	static int [] parents;
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine()); // 테스트케이스의 수
		
		// 테스트케이스 별로 수행
		for(int t=0; t<TC; t++) {
			sb.append("#").append(t+1).append(" ");
			String[] temp = br.readLine().split(" ");
			n = Integer.parseInt(temp[0]); // 초기 집합의 수
			int m = Integer.parseInt(temp[1]); // 연산의 수
			
			makeSet(); // 초기집합 만들기
			
			// 연산 수행
			for(int i=0; i<m; i++) {
				temp = br.readLine().split(" ");
				int op = Integer.parseInt(temp[0]);
				if(op==0) { // 합연산 Union
					union(Integer.parseInt(temp[1])-1, Integer.parseInt(temp[2])-1);
				}
				else {
					if(findSet(Integer.parseInt(temp[1])-1) == findSet(Integer.parseInt(temp[2])-1)){ // 같은 집합내에 속한다면
						sb.append(1);
					}
					else {
						sb.append(0);
					}
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	// 초기집합 만들기
	public static void makeSet() {
		parents = new int[n];
		// 자신의 부모노드를 자신의 값으로 세팅
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}
	public static int findSet(int a) {
		if(a==parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
}
