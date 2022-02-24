import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B13_적록색약_홍석인 {
	public static boolean visited[][];
	public static int[] dx = { -1, 0, 0, 1 };
	public static int[] dy = { 0, 1, -1, 0 };
	public static int N;
	public static char arr[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		arr = new char[N][N];
		visited = new boolean[N][N];
		// board 정보 입력받기
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		int count = 0;
		// 적록색약이 아닌사람
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					count += 1;
				}
			}
		}
		sb.append(count + " ");
		visited = new boolean[N][N];
		// 적록색약인 사람

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 'G')
					arr[i][j] = 'R';
			}
		}

		count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					count++;
				}
			}
		}
		sb.append(count);
		System.out.println(sb.toString());
	}

	public static void dfs(int x, int y) {		
		visited[x][y] = true;
		char temp = arr[x][y];
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			System.out.println(nx + " " + ny);
			
			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				System.out.println("range");
				if (!visited[nx][ny] && temp == arr[nx][ny]) {
					System.out.println("dfs");
					dfs(nx, ny);
				}
			}
		}
	}
}
