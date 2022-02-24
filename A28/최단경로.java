package A28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


public class 최단경로 { // 다익스트라 기본 예제
	static ArrayList<myNode>[] adjList;
	static int[] distStart;
	static int V;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();	
		
		String[] temp = br.readLine().split(" ");
		V = Integer.parseInt(temp[0]); // 정점의 개수
		int E = Integer.parseInt(temp[1]); // 간선의 개수
		
		int start = Integer.parseInt(br.readLine())-1; // 시작 정점의 번호
		
		// 경로 정보 입력받아 -> 인접행렬 만들기
		adjList = new ArrayList[V];
		for(int i = 0; i < V; i++){
            adjList[i] = new ArrayList<>();
        }
		
		for(int i=0; i<E; i++) {
			temp = br.readLine().split(" ");
			int from = Integer.parseInt(temp[0])-1;
			int to = Integer.parseInt(temp[1])-1;
			int cost = Integer.parseInt(temp[2]);
			adjList[from].add(new myNode(cost, to));
		}
		
		// 다익스트라 실행
		Dij(start);
		
		for(int ans : distStart) {
			if(ans == Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
				continue;
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
		
	}
	private static void Dij(int start) {
		// 우선 모든 거리를 가장 큰 값으로 초기화
		distStart = new int[V];
		Arrays.fill(distStart, Integer.MAX_VALUE);
		distStart[start] = 0; // 자기 자신과의 거리는 0이다.
		
		// 우선 순위 큐 사용
		PriorityQueue<myNode> pq = new PriorityQueue<>();
		pq.offer(new myNode(0,start)); // 나 자신과의 거리가 0!인 부분을 pq에 추가
		
		while(!pq.isEmpty()) {
			// pq에서 하나 출력 -> dist순으로 정렬했기에 가장 경로가 짧은 노드를 알아서 찾아온다.
			myNode curNode = pq.poll();
			
			if(curNode.dist > distStart[curNode.num]) { // 새로 들어온 dist가 내가 기존에 유지하고 있떤 dist보다 길다면 가치가 없다. -> continue
				continue;
			}
			
			// 가치가 있는 녀석인 경우
			// 그 녀석이 접근 가능한 다른 노드를 관찰
			for(myNode node : adjList[curNode.num]){
	               if(distStart[node.num] > distStart[curNode.num] + node.dist){
	                   distStart[node.num] = distStart[curNode.num] + node.dist;
	                   pq.offer(new myNode(distStart[node.num], node.num));
	               }
	           }
			
		}
	}
	
	public static class myNode implements Comparable<myNode>{
		int dist;
		int num;
		public myNode(int dist, int num) {
			this.dist = dist;
			this.num = num;
		}
		@Override
		public int compareTo(myNode o) {
			// TODO Auto-generated method stub
			return this.dist-o.dist;
		}
	}
}
