import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class A28_최단경로_홍석인 {
	static class Vertex implements Comparable<Vertex>{
		int no, minDistance; // 정점의 번호, 출발지에서 자신으로의 최소비용

		public Vertex(int no, int minDistance) {
			super();
			this.no = no;
			this.minDistance = minDistance;
		}

		@Override
		public int compareTo(Vertex o) {			
			return this.minDistance - o.minDistance;
		}
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str[] = br.readLine().split(" ");
		int V = Integer.parseInt(str[0]);
		int E = Integer.parseInt(str[1]);
		int start = Integer.parseInt(br.readLine());
		
		PriorityQueue<Vertex>[] pQueue = new PriorityQueue[V+1];
		for(int i=1;i<=V;i++) {
			pQueue[i] = new PriorityQueue<Vertex>();
		}
		for(int i=0;i<E;i++) {
			String str2[] = br.readLine().split(" ");
			int u = Integer.parseInt(str2[0]);
			int v = Integer.parseInt(str2[1]);
			int w = Integer.parseInt(str2[2]);
			pQueue[u].add(new Vertex(v, w));
		}		
		

			
		int distance[] = new int[V+1];
		Arrays.fill(distance, -1);
		distance[start] = 0;			
		
		
		while(!pQueue[start].isEmpty()) {
			Vertex current = pQueue[start].poll();
			int no = current.no;
			int minDistance = current.minDistance;
			// distance 가 -1이면 연결되어있지 않다.
			if(distance[no]!=-1) continue;
			
			distance[no] = minDistance;
			// pQueue
			for(Vertex v1: pQueue[no]) {
				// 다음에 pQ에 들어갈 Vertex는 경유점을 더한 거리로 들어가게 됨
				pQueue[start].add(new Vertex(v1.no, v1.minDistance+minDistance));
			}
		}
		for(int i=1;i<=V;i++) {
			if(distance[i]==-1) 
				sb.append("INF").append("\n");
			else
				sb.append(distance[i]).append("\n");
		}
		System.out.println(sb.toString());
	}

}
