import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class A31_미세먼지안녕_홍석인 {
	public static class Pos {
		int xpos;
		int ypos;
		int value;
		public Pos(int x, int y, int value) {
			this.xpos = x;
			this.ypos = y;
			this.value = value;
		}
	}

	public static int R, C, T;
	public static int dx[] = { 0, -1, 0, 1 };
	public static int dy[] = { 1, 0, -1, 0 };
	public static Queue<Pos> queue = new LinkedList<>();
	public static Pos clean;
	public static int[][] board;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		// R, C, T 입력받기
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		T = Integer.parseInt(str[2]);
		int result = 2;
		// Board의 정보 입력받기
		board = new int[R][C];

		for (int i = 0; i < R; i++) {
			String str2[] = br.readLine().split(" ");
			for (int j = 0; j < C; j++) {
				board[i][j] = Integer.parseInt(str2[j]);
				if (board[i][j] > 0) {
					// 미세먼지 정보들 저장		
					//System.out.println("save");
					queue.add(new Pos(i, j, board[i][j]));

				}
				if (board[i][j] == -1) {
					clean = new Pos(i, j, -1);
				}
			}			
		}
		for(int i=0;i<T;i++) {
			timer();			
			for(int j=0;j<R;j++) {
				for(int k=0;k<C;k++) {
					if(board[j][k]>0)
						queue.add(new Pos(j,k, board[j][k]));
				}
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(board[i][j]+" ");
				result += board[i][j];
			}
			System.out.println();
		}
		System.out.println(result);
	}

	public static void timer() {
		 // 1. 미세먼지의 확산
		while (!queue.isEmpty()) {		
			//System.out.println("poll");
			Pos dust = queue.poll();		
			// 4방탐색으로 각 방향에 먼지 확산
			for(int i=0;i<4;i++) {
				int nx = dust.xpos + dx[i];
				int ny = dust.ypos + dy[i];				
				if(nx >= 0 && nx < R && ny >= 0 && ny < C) {
					if(board[nx][ny]!=-1) {
						board[nx][ny] += dust.value/5;
						board[dust.xpos][dust.ypos] -= dust.value/5;	
					}
									
				}
			}
		}
		// 2. 공기청정기
					
		// 2-1.반시계방향으로 보내기
		int direction = 0;
		// 나중에 들어온 공기청정기의 자리 이므로 위의 시계방향은 x값 -1
		// 초기 시작값
		int x = clean.xpos - 1;
		int y = clean.ypos + 1;		
		int temp = board[x][y];
		board[x][y] = 0;
		// 우 상 좌 하
		int temp2=0;
		while (true) {
			int nx = x + dx[direction];
			int ny = y + dy[direction];
			// 공기청정기를 만나면 멈춤
			//System.out.println(nx + " " + ny + " " + temp+direction);					
			if (nx == clean.xpos-1 && ny == clean.ypos)
				break;
			// 범위 안에 있으면
			if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
				// 자리 스왑
				//System.out.println(direction + "run");
				temp2 = board[nx][ny];
				board[nx][ny] = temp;
				temp = temp2;
				x = nx;
				y = ny;
			}
			else {
				direction += 1;						
			}
			// 범위 안에 없으면 direction 바꿔주기					
		}
		
		// 2-2. 시계방향으로 보내기
		// 초기 시작값
		x = clean.xpos;
		y = clean.ypos + 1;
		temp = board[x][y];
		board[x][y] = 0;
		direction = 0;
		// 우 하 좌 상
		while (true) {					
			int nx = x + dx[direction];
			int ny = y + dy[direction];
			if (nx == clean.xpos && ny == clean.ypos)
				break;
			// 범위 안에 있으면
			if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
				// 자리 스왑
				temp2 = board[nx][ny];
				board[nx][ny] = temp;
				temp = temp2;
				x = nx;
				y = ny;
			}
			// 범위 안에 없으면 direction 바꿔주기
			else {
				direction += 3;
				if (direction >= 4)
					direction %= 4;
			}
		}		
	} 	
}
