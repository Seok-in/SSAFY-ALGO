import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A04_농작물수확하기_홍석인 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		for (int k = 0; k < t; k++) {
			int n = Integer.parseInt(br.readLine());
			int arr[][] = new int[n][n];
			// 중간값
			int mid = n / 2;
			int sum = 0;
			// 농작물 값어치 입력
			// 중간에 십자가 빼기
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					arr[i][j] = str.charAt(j) - '0';
					if (i == mid || j == mid) {
						sum -= arr[i][j];
					}
				}
			}

			// 농작물 값어치 더하기
			sum = valueSum(arr,sum);
			bw.write("#" + t + " " + sum);
			
		}
		bw.flush();
	}
	

	public static int valueSum(int arr[][], int sum) {
		// 1사분면
		int n = arr.length;
		int mid = arr.length / 2;
		for (int i = 0; i <= mid; i++) {
			for (int j = mid; j <= mid + i; j++) {
				sum += arr[i][j];
			}

		}
		// 2사분면
		for (int i = 0; i <= mid; i++) {
			for (int j = mid; j >= mid - i; j--) {
				sum += arr[i][j];
			}

		}
		// 3사분면
		for (int i = mid; i < n; i++) {
			for (int j = i - mid; j <= mid; j++)
				sum += arr[i][j];

		}
		// 4사분면

		for (int i = mid; i < n; i++) {
			for (int j = mid; j < n + mid - i; j++) {
				sum += arr[i][j];
			}

		}
		// 가운데 부분 빼주기
		sum -= (arr[mid][mid] * 2);

		return sum;
	}
}
