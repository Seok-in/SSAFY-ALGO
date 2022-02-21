package A22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class DFS와BFS {
	static int N;
	static int[][] adjMat; 
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]); // 정점의 수
		int M = Integer.parseInt(temp[1]); // 간선의 수
		int V = Integer.parseInt(temp[2])-1; // 탐색 시작점
		
		// 간선들을 압력받아 인접행렬 만들기;
		adjMat = new int[N][N];
		for(int i=0; i<M; i++) {
			temp = br.readLine().split(" ");
			int from = Integer.parseInt(temp[0])-1;
			int to = Integer.parseInt(temp[1])-1;
			adjMat[from][to] = 1;
			adjMat[to][from] = 1;
		}
		// dfs실행
		dfs(new boolean[N], V);
		sb.append("\n");
		// bfs실행
		bfs(V);
		System.out.println(sb.toString());
	}
	
	private static void dfs(boolean[] visited, int current) {
		visited[current] = true;
		sb.append(current+1).append(" ");
		
		// current 정점의 인접정점 처리(단, 방문하지 않은 인접정점만)
		for(int i=0; i<N; i++) {
			if(!visited[i] && adjMat[current][i] == 1) {
				visited[i] = true;
				dfs(visited, i);
			}
		}
		
	}

	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];
		
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			// 뽑혀나왔으니 출력
			sb.append(current+1).append(" ");
			// 정점들에 대하여 visited가 false이고 current와 연결된 정점이라면 queue에 추가
			for(int i=0; i<N; i++) {
				if(!visited[i] && adjMat[current][i] == 1) {
					queue.offer(i);
					visited[i] = true;
				}
			}
			
		}
	}
}

