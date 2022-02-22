package A23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class contact {
	static StringBuilder sb = new StringBuilder();
	static int[][] adjMat;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = 10; // 테스트케이스는 총 10개이다.
		
		// 테스트케이스별로 수행
		for(int t=0; t<TC; t++) {
			String[] temp = br.readLine().split(" ");
			int N = Integer.parseInt(temp[0]); // 입력받는 데이터의 길이
			int start = Integer.parseInt(temp[1])-1; // 시작점
			
			adjMat = new int[100][100]; // 최대 연락인원이 100명이다.
			
			temp = br.readLine().split(" ");
			for(int i=0; i< N; i+=2) {
				// 2개씩 짝지어 처음 껀 from 다음껀 to로 adjMat에 입력해준다.
				int from = Integer.parseInt(temp[i])-1;
				int to = Integer.parseInt(temp[i+1])-1;
				adjMat[from][to] = 1;
			}
			// bfs 사용!!
			int ans = bfs(start);
			sb.append("#").append(t+1).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
	private static int bfs(int start) {
		// visited 선언
		int[] visited = new int[100]; // 0이면 미방문, 다른 양의 정수 -> depth
		// queue 선언
		Queue<Integer> queue = new LinkedList<>();
		// queue에 초깃값 입력, visited의 초깃값 입력
		queue.offer(start);
		visited[start] = 1;
		// 뮨제풀이 알고리즘
		int maxDepth=0; // 연락의 가장 긴경로 확인
		int ans=0; // 가장 긴경로를 거친 노드중 가장 큰값
		while(!queue.isEmpty()) {
			int now = queue.poll();
			maxDepth = visited[now];
			// 모든 node에 관하여
			for(int i=0; i<100; i++) {
				if(adjMat[now][i]==1 && visited[i]==0) { // 현재 위치에서 접근이 가능하고, 아직 방문되지 않은 곳인 경우
					// 방문처리하고 해당 노드를 queue에 추가
					visited[i] = visited[now] + 1;
					queue.offer(i);
				}
			}
			
		}
		// depth가 가장 깊은 것중 가장 큰값 찾기
		for(int i=0; i<100; i++) {
			if(visited[i] == maxDepth) { // 내가 찾던 depth와 같은 경우
				if(ans < i) { // 더 큰값인 경우
					ans = i;
				}
			}
		}
		return ans+1;
	}
}



