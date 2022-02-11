import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A15_배열돌리기1_홍석인 {
	public static int[] dx = { 1, 0, -1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int arr[][] = new int[n][m];		
		for (int i = 0; i < n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		for (int k = 0; k < r; k++) {
			arr = rotate(arr, n, m);
		}
		for (int t = 0; t < n; t++) {
			for (int f = 0; f < m; f++) {
				bw.write(arr[t][f]+" ");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();

	}

	public static int[][] rotate(int[][] arr, int n, int m) {
		boolean visited[][] = new boolean[n][m];
		int xpos = 0;
		int ypos = 0;
		int direction = 0;
		int count = 0;
		int temp1 = arr[0][0];
		int temp2 = 0;
		while (true) {
			// 아래로 값 바꿔주기
			// 범위설정
			if (direction > 3) {
				direction = 0;
			}
			if (count == 4) {
				if(xpos+1>=arr.length || ypos+1>=arr[0].length)
					break;
				xpos += 1;
				ypos += 1;
				temp1 = arr[xpos][ypos];
				direction = 0;
				count =0;
				continue;
			}

			if (xpos + dx[direction] >= 0 && ypos + dy[direction] >= 0 && xpos + dx[direction] < arr.length
					&& ypos + dy[direction] < arr[0].length) {

				if (visited[xpos + dx[direction]][ypos + dy[direction]] == true) {
					direction += 1;					
					count += 1;
					continue;
				}
				count = 0;

				// 바꿀부분 방문처리
				visited[xpos + dx[direction]][ypos + dy[direction]] = true;
				//System.out.println(direction);
				// 값 바꿔주기
				temp2 = arr[xpos + dx[direction]][ypos + dy[direction]];
				arr[xpos + dx[direction]][ypos + dy[direction]] = temp1;
				temp1 = temp2;
				xpos += dx[direction];
				ypos += dy[direction];
			} else {
				direction += 1;
				count += 1;				
			}

		}
		return arr;
	}
}
