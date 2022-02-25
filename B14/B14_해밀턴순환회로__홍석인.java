import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class B14_해밀턴순환회로__홍석인 {
	public static boolean visited[];
	public static int N;
	public static int[] distance;
	public static int[][] arr;
	public static int min;
	public static class Vertex implements Comparable<Vertex>{
		int no;
		int weight;
		public Vertex(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}
		public int compareTo(Vertex o) {
			return this.weight - o.weight;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	 
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Vertex>[] queue = new PriorityQueue[N+1];		
		arr = new int[N][N];
		visited = new boolean[N];
		
		for(int k=1;k<=N;k++) {
			queue[k]=new PriorityQueue<Vertex>();
		}
		for(int i =0;i<N;i++) {			
			String str[] = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(str[j]);
				queue[j+1].add(new Vertex(i+1, Integer.parseInt(str[j])));
			}
		}
		int start = 1;
		distance = new int[N+1];
		Arrays.fill(distance, -1);
		distance[start] =0;
		
		// distance에 돌아오는 정보 저장
		while(!queue[start].isEmpty()) {
			Vertex current = queue[start].poll();
			int no = current.no;
			int weight=current.weight;
			if(distance[no]!=-1) continue;
			distance[no] = weight;
			for(Vertex v1 : queue[no]) {
				queue[start].add(new Vertex(v1.no, v1.weight + weight));
			}
		}
		min =Integer.MAX_VALUE;
		visited[0] = true;
		dfs(0, 1, 0);		
		System.out.println(Arrays.toString(distance));
		System.out.println(min);
	}
	
	public static void dfs(int start, int count, int result) {		
		if(count == N) {
			// 모든곳을 방문하였다면 돌아오는 최단경로의 값을 더해준다.
			// 돌아갈 수 없다면 return;
			if(distance[start+1]==-1) return;
			result += distance[start+1];			
			min = Math.min(result, min);
			return;
		}
		for(int i=0;i<N;i++) {
			// 방문했던곳이면 넘어간다
			if(visited[i]) continue;
			visited[i] = true;
			dfs(i, count+1, result +arr[start][i]);
			// 다시 돌려야하므로 백트래킹
			visited[i] =false;
		}
	}
	

}
