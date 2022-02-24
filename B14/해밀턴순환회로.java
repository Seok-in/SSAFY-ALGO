package B14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class 해밀턴순환회로 { // dfs 방식으로 풀이할 예정 -> 백트랙킹
	static int[] seq; // 배달을 할 순서
	static int N;
	static int[][] adjMat; // 인접행렬
	static int min = Integer.MAX_VALUE;
	static int init = 0; // 최초출발지
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();	
		
		N = Integer.parseInt(st.nextToken()); // 장소의 개수
		int start = 0; // 출발지

		// 인접행렬 입력받기
		String[] temp;
		adjMat = new int[N][N];
		for(int r=0; r<N; r++) {
			temp = br.readLine().split(" ");	
			for(int c=0; c<N; c++) {
				adjMat[r][c] = Integer.parseInt(temp[c]);
			}
		}
		
		// dfs사용
		visited = new boolean[N];
		visited[0] = true;
		myDfs(0, 1, 0); // 항상 1번도시에서 출발 -> 1번을 0으로 표현 & 내자리는 밟았으니 1 & 아직 지불비용은 0
		
		sb.append(min);
		System.out.println(sb.toString());
	}
	private static void myDfs(int from, int cnt, int totalCost) { // dfs로 풀이
		// 종료 조건
		if(cnt == N) { // 모든 도시를 다 배달한 경우
			if(adjMat[from][init] != 0) { // 마지막 배달장소에서 집으로 돌아가는 길이 있는 경우
				totalCost += adjMat[from][init]; // 최종비용 계산
				min = Math.min(min, totalCost); // 기존 최종비용과 비교하여 더 작은값을 선택
			}
			return;
		}
		// 모든 다음 배달지들에 관하여
		for(int i=0; i<N; i++) {
			if(visited[i]) continue; // 이미 방문해본곳이라면 유망하지않다.
			// 유망하다면 보내본다..
			visited[i] = true;
			myDfs(i, cnt+1, totalCost+adjMat[from][i]);
			// 보내본뒤 다시 한칸 뒤로... 백트랙킹!
			visited[i] = false;
		}
		
	}
}

