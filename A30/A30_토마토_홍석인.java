import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class A30_토마토_홍석인 {
	public static int dx[] = {1, -1, 0, 0};
	public static int dy[] = {0, 0, 1, -1};
	public static boolean visited[][];
	public static int N;
	public static int M;
	public static int result;
	public static Queue<Pos> queue =new LinkedList<>();
	public static class Pos{
		int xpos;
		int ypos;
		int depth;
		public Pos(int x, int y, int depth) {
			this.xpos = x;
			this.ypos = y;
			this.depth = depth;
		}
	}
	public static int arr[][];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		arr = new int[M][N];
		visited = new boolean[M][N];
		result = 0;
		// 토마토의 정보 입력받기
		for(int i=0;i<M;i++) {
			String str2[] = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(str2[j]);
				// 익은 토마토의 정보
				if(arr[i][j]==1) {
					queue.add(new Pos(i, j, 0));
					visited[i][j] =true;
				}				
				// 익지 않은 토마토가 하나라도 있는경우
				if(arr[i][j]==0)
					result = -1;
			}			
		}
		
		bfs();
		// 익지않은 토마토가 있는지 확인
		for(int i=0;i<M;i++) {			
			for(int j=0;j<N;j++) {
				if(arr[i][j]==0)
					result = -1;	
			}			
		}
		System.out.println(result);
		
	}
	public static void bfs() {
		while(!queue.isEmpty()) {
			Pos pos = queue.poll();			
			// 4가지 방향에서 탐색
			for(int i=0;i<4;i++) {
				int nx= pos.xpos+dx[i];
				int ny = pos.ypos+dy[i];
				//범위안에 포함되고 토마토가 있는 곳이라면				
				if(nx >= 0 && nx <M && ny>= 0 && ny< N) {					
					if(arr[nx][ny] != -1 && !visited[nx][ny]) {
						//토마토 익히기						
						arr[nx][ny] = 1;
						queue.add(new Pos(nx, ny, pos.depth+1));
						visited[nx][ny] = true;
					}					
				}				
			}
			result = pos.depth;
		}
		
	}
}
