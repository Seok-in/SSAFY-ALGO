import java.util.StringTokenizer;
import java.io.*;

public class C01_콘테스트_홍석인 {
	public static int num[] = new int[3];
	public static int max = 0;
	public static int sum = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = new int[10];
		int arr2[] = new int[10];
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int j = 0; j < 10; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr2[j] = Integer.parseInt(st.nextToken());
		}
		comb(0,0,arr);
		System.out.println(max);
		max =0;
		sum =0;
		comb(0,0,arr2);
		System.out.println(max);
	}

	public static void comb(int count, int start, int arr[]) {
		if (count == 3) {
			for (int i : num) {
				sum += i;
			}
			
			if (max < sum) {
				max = sum;
			}
			sum = 0;
			return;
		} else {
			for (int j = start; j < 10; j++) {
				num[count]=arr[j];
				comb(count +1, j+1, arr);
			}
		}
	}
}
