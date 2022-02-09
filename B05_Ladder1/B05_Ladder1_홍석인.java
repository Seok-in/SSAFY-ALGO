import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B05_Ladder1_홍석인 {
	public static class Pos {
		public int xpos;
		public int ypos;

	}

	public static int[] dx = { -1, 0, 0 };
	public static int[] dy = { 0, 1, -1 };
	public static int direction = 0;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] arr = new int[100][100];
		Pos pos = new Pos();
		for (int i = 0; i < 1; i++) {
			int T = Integer.parseInt(br.readLine());
			for (int j = 0; j < 100; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 100; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
					if (arr[j][k] == 2) {
						pos.xpos = j;
						pos.ypos = k;
					}
				}
			}
			System.out.println(pos.ypos);
			pos = find(pos, arr);
			bw.write("#" + (i + 1) + " " + pos.ypos);
		}
		bw.flush();
		bw.close();
	}

	// 방향 탐색
	public static Pos find(Pos pos, int[][] arr) {
		// 좌우 범위 확인

		direction = 0;
		while (true) {
			if (pos.xpos == 0) {
				break;
			}
			// 방향대로 이동
			pos.xpos += dx[direction];
			pos.ypos += dy[direction];

			if (direction == 0) {
				if (pos.xpos>0&&pos.ypos + dy[direction] >= 0 && pos.ypos + dy[direction] <= 99) {
					if (arr[pos.xpos + dx[direction + 1]][pos.ypos + dy[direction + 1]] == 1)
						direction = 1;
					else if (arr[pos.xpos + dx[direction + 2]][pos.ypos + dy[direction + 2]] == 1)
						direction = 2;
				}
			}
			System.out.println(pos.xpos + " " + pos.ypos);
			if (pos.xpos>0&&pos.ypos + dy[direction] >= 0 && pos.ypos + dy[direction] <= 99) {
				// 방향 탐색
				if (arr[pos.xpos + dx[direction]][pos.ypos + dy[direction]] == 0) {					
					direction =0;					
				}
			}
		}
		return pos;
	}
}
