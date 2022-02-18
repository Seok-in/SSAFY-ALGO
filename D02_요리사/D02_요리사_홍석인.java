import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

public class D02_요리사_홍석인 {
	static int arr[][];
	static int sum = 0;
	static int min = Integer.MAX_VALUE;
	static int result[];
	static int N;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int k = 0; k < T; k++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			result = new int[N / 2];
			for (int i = 0; i < N; i++) {
				String str[] = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(str[j]);
					sum += arr[i][j];
				}
			}
			minFood(0, 0);
			sb.append("#").append(k + 1).append(" ").append(min).append("\n");
			min = Integer.MAX_VALUE;
			sum = 0;
		}
		System.out.println(sb);

	}

	// N개의 식재료를 뽑아서 최솟값 구하는 알고리즘
	public static void minFood(int start, int cnt) {
		int temp = sum;
		if (cnt == N / 2) {
			for (int i : result) {
				for (int x = 0; x < N; x++) {
					temp -= arr[i][x];
					temp -= arr[x][i];
				}
			}
			min = Math.min(min, Math.abs(temp));
			return;
		}
		for (int k = start; k < N; k++) {
			result[cnt] = k;
			minFood(k + 1, cnt + 1);
		}
	}
}
