import java.io.*;
public class A22_DFS와BFS_홍석인 {	
	public static Node[] adjList;
	public static boolean visited_dfs[];
	public static boolean visited_bfs[];
	public static StringBuilder sb = new StringBuilder();	
	public static void main(String[] args) throws IOException {
	
		
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		int V = Integer.parseInt(str[2]);
		
		adjList = new Node[N+1];
		
		visited_bfs = new boolean[N];
		visited_dfs = new boolean[N];
		
		for(int x=0;x<M;x++) {
			String str2[] = br.readLine().split(" ");
			int i = Integer.parseInt(str[0]);
			int j = Integer.parseInt(str[1]);
			adjList[i]=new Node(j, adjList[i]);
			adjList[j]=new Node(i,adjList[j]);
		}
		dfs(1);
		System.out.println(sb.toString());
	}
	static class Node{
		int vertex;
		Node link;
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
		
		
	}
	public static void dfs(int n) {
		visited_dfs[n] = true;
		sb.append(n).append(" ");
		for(Node link : adjList) {
			if(!visited_dfs[link.vertex])
				dfs(link.vertex);
		}
	}
	public static void bfs(int n) {
		
	}
}
