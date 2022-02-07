import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A05_백설공주_홍석인 {
	public static int arr[] = new int[9];
	public static int num[] = new int[7];
	public static boolean visited[] = new boolean[9];
	public static int sum;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		comb(0, 0);

	}

	public static void comb(int count, int start) {
		if (count == 7) {
			sum = 0;
			for (int i : num) {
				sum += i;
			}
			if (sum == 100) {
				for (int i : num) {
					System.out.println(i);
				}
				return;
			}
		} else {
			for (int j = start; j < 8; j++) {
				num[count] = arr[j];
				comb(count + 1, j + 1);
			}
		}

	}
}
