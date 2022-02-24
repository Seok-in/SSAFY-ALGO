import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;

public class A25_아기상어_홍석인 {
	public static int[] dx = { -1, 0, 0, 1 };
	public static int[] dy = { 0, -1, 1, 0 };
	public static int N;	
	public static int direction = -1;	
	public static int shark = 2;	
	public static int result = 0;	
	public static int sharkCount = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Queue<Pos> queue = new LinkedList<>();
		ArrayList<Pos> eating = new ArrayList<>();
		boolean visited[][];
		int arr[][];
		visited = new boolean[N][N];
		// Map 의 정보 입력받기
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str[] = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
				// 상어의 위치 찾기
				if (arr[i][j] == 9) {
					queue.add(new Pos(i, j, 0));
					arr[i][j] = 0;
					visited[i][j] =true;
				}
			}
		}
		bfs(queue, eating, visited, arr);
		System.out.println(result);
	}

	
	public static void bfs(Queue<Pos> queue, ArrayList<Pos> eating, boolean visited[][], int arr[][]) {		
		while (!queue.isEmpty()) {
			Pos pos = queue.poll();			
			// 상하좌우로 먹을 수 있는지 여부 판단
			for (int i = 0; i < 4; i++) {
				direction += 1;
				direction %= 4;
				if (pos.xpos + dx[direction] >= 0 && pos.xpos + dx[direction] < N && pos.ypos + dy[direction] >= 0
						&& pos.ypos + dy[direction] < N
						&& !visited[pos.xpos + dx[direction]][pos.ypos + dy[direction]]) {
					// 다음 위치
					int nx = pos.xpos + dx[direction];
					int ny = pos.ypos + dy[direction];
					// 먹을수있는경우!
					if (arr[nx][ny] < shark && arr[nx][ny] != 0) {
						// 먹킷리스트에 추가
						eating.add(new Pos(nx, ny, pos.count + 1));
					}
					// 지나갈 수 있는 경우 큐에 넣기
					if(arr[nx][ny]<= shark) {
						queue.add(new Pos(nx, ny, pos.count+1));
						visited[nx][ny] =true;
					}					
				}
			}
		}
		// 먹킷리스트 중 제일 우선순위를 큐에 넣기
		if(!eating.isEmpty()) {
			Collections.sort(eating);
			queue.add(new Pos(eating.get(0).xpos, eating.get(0).ypos, 0));			
			result += eating.get(0).count;
			arr[eating.get(0).xpos][eating.get(0).ypos] = 0;
			visited= new boolean[N][N];
			visited[eating.get(0).xpos][eating.get(0).ypos] = true;
			sharkCount +=1;
			if(sharkCount == shark) {
				shark +=1;
				sharkCount =0;
			}
			// System.out.println("먹는것" + eating.get(0).xpos +" " + eating.get(0).ypos + " " + result);
			eating.clear();
			bfs(queue, eating, visited, arr);
		}	
	}

	
	
	// x, y , 거리 를 저장하는 객체
	public static class Pos implements Comparable<Pos> {
		int xpos;
		int ypos;
		int count;

		public Pos(int xpos, int ypos, int count) {
			this.xpos = xpos;
			this.ypos = ypos;
			this.count = count;
		}

		@Override
		public int compareTo(Pos o) {
			if (this.count == o.count) {
				if (this.xpos == o.xpos)
					return this.ypos - o.ypos;
				else
					return this.xpos - o.xpos;
			} else
				return this.count - o.count;
		}
	}

}
