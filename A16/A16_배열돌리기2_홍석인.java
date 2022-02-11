import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A16_배열돌리기2_홍석인 {

	public static void main(String[] args) throws IOException {
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
		for (int i = 0; i < m - 1; i++) {
			arr = right(arr, n, m);
		}

		for (int t = 0; t < n; t++) {
			for (int f = 0; f < m; f++) {
				bw.write(arr[t][f] + " ");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();

	}

	public static int[][] upDown(int[][] arr, int n, int m) {
		int temp = 0;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < m; j++) {
				temp = arr[i][j];
				arr[i][j] = arr[n - i - 1][j];
				arr[n - i - 1][j] = temp;
			}
		}
		return arr;
	}

	public static int[][] leftRight(int[][] arr, int n, int m) {
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m / 2; j++) {
				temp = arr[i][j];
				arr[i][j] = arr[i][m - j - 1];
				arr[i][m - j - 1] = temp;
			}
		}
		return arr;
	}

	public static int[][] right(int[][] arr, int n, int m) {
		int rotate[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				rotate[i][j] = arr[j][m - 1 - i];
			}
		}
		return rotate;
	}

	public static int[][] left(int[][] arr, int n, int m) {
		int rotate[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				rotate[i][j] = arr[n - 1 - j][i];
			}
		}
		return rotate;
	}

	public static int[][] op5(int[][] arr, int n, int m) {
		int rotate[][] = new int[n][m];
		int xmid = n / 2;
		int ymid = m / 2;
		// 1번에서 2번가기
		for (int i = 0; i < xmid; i++) {

			for (int j = 0; j < ymid; j++) {
				rotate[i][ymid + j] = arr[i][j];
			}
		}
		// 2번에서 3번 가기
		for (int i = 0; i < xmid; i++) {
			for (int j = ymid; j <m; j++) {
				rotate[xmid + i][ymid] = arr[i][j];
			}
		}
		// 3번에서 4번가기
		for (int i = xmid; i < n; i++) {
			int a =0;
			for (int j = ymid; j < m; a++) {
				rotate[i][a] = arr[i][j];
			}
		}
		// 4번에서 1번가기
		int b=0;
		for (int i = xmid; i < n; b++) {			
			for (int j = 0; j < ymid; j++) {
				rotate[b][j] = arr[i][j];
			}
		}
		return rotate;
	}

	public static int[][] op6(int[][] arr, int n, int m) {
		int rotate[][] = new int[n][m];
		int xmid = n / 2;
		int ymid = m / 2;
		// 1에서 4번가기
		for(int i=0;i<xmid;i++) {
			for(int j=0;j<ymid;j++) {
				rotate[xmid+i][j]=arr[i][j];
			}
		}
		//4에서 3번가기
		for(int i=0;i<xmid;i++) {
			for(int j=0;j<xmid;j++) {
				rotate[i][ymid+j]=arr[i][j];
			}
		}
		// 3에서 2번가기
		int a=0;
		for(int i=0;i<n;a++) {
			for(int j=0;j<ymid;j++) {
				rotate[a][j]=arr[i][j];
			}
		}
		// 2에서 1번가기
		for(int i=0;i<xmid;i++) {
			int b =0;
			for(int j=ymid;j<m;b++) {
				rotate[i][b]=arr[i][j];
			}
		}
		return rotate;
	}
}
