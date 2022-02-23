package B12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 창용마을무리의개수 {
	static int [] parents;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine()); // 테스트케이스의 수
		
		// 테스트케이스 별로 수행
		for(int t=0; t<TC; t++) {
			sb.append("#").append(t+1).append(" ");
			
			String[] temp = br.readLine().split(" ");
			N = Integer.parseInt(temp[0]); // 초기 집합의 수
			int M = Integer.parseInt(temp[1]); // 관계의 수
			
			makeSet(); // 초기집합 만들기
			
			// 관계 합치기 수행
			for(int i=0; i<M; i++) {
				temp = br.readLine().split(" ");
				union(Integer.parseInt(temp[0])-1, Integer.parseInt(temp[1])-1);
			}
			
			// 무리의 갯수 찾기
			List<Integer> heads = new ArrayList<>();
			for(int i=0; i<N; i++) {
				if(heads.contains(findSet(i))) continue;
				else heads.add(findSet(i));
			}
			sb.append(heads.size()).append("\n");
		}
		System.out.println(sb.toString());
	}
	// 초기집합 만들기
	public static void makeSet() {
		parents = new int[N];
		// 자신의 부모노드를 자신의 값으로 세팅
		for (int i = 0; i < N; i++) {
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
