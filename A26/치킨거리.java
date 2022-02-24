import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class 치킨거리 {
	public static int M;
	public static int N;
	public static int range = 0;
	public static int min = Integer.MAX_VALUE;
	public static ArrayList<Pos> list = new ArrayList<Pos>();
	public static ArrayList<Pos> house = new ArrayList<Pos>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);

		int arr[][] = new int[N][N];

		Pos result[] = new Pos[M];

		for (int i = 0; i < N; i++) {
			String str2[] = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(str2[j]);
				// 치킨집인 경우 리스트에 넣기
				if (arr[i][j] == 2) {
					list.add(new Pos(i, j));
				}
				if (arr[i][j] == 1) {
					house.add(new Pos(i, j));
				}
			}
		}
		comb(0, 0, result);
		System.out.println(min);

	}

	public static class Pos {
		int xpos;
		int ypos;

		public Pos(int xpos, int ypos) {
			super();
			this.xpos = xpos;
			this.ypos = ypos;
		}
	}

	public static int range(Pos a, Pos b) {
		return Math.abs(a.xpos - b.xpos) + Math.abs(a.ypos - b.ypos);
	}
	// 조합으로 M개 뽑기
	public static void comb(int start, int cnt, Pos result[]) {
		int value;
		int value2 = 0;
		if (cnt == M) {
			for (Pos b : house) {
				value = Integer.MAX_VALUE;
				for (Pos a : result) {
					if (value >= range(b, a)) {
						value = range(b, a);
					}
				}
				value2 += value;
			}
			min = Math.min(value2, min);
			return;
		}
		for (int i = start; i < list.size(); i++) {
			result[cnt] = list.get(i);
			comb(i + 1, cnt + 1, result);
		}
	}
}
