import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class B09_쿼드트리_홍석인 {
	static StringBuilder sb = new StringBuilder();
	static boolean use = false;
	static int arr[][] ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str[] = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		QuadTree(0,0,N);
		System.out.println(sb);
	}
	
	public static void QuadTree(int x, int y, int size) {
		if(isAvailable(x, y, size)) {
			sb.append(arr[x][y]);
			return;
		}
		int half =size/2;
		
		sb.append("(");
		
		
		// 왼쪽 위
		QuadTree(x, y, half);
		// 오른쪽 위
		QuadTree(x, y+half, half);
		// 왼쪽 아래
		QuadTree(x+half, y, half);
		// 오른쪽 아래
		QuadTree(x+half, y+half, half);
		
		sb.append(")");
	}
	
	public static boolean isAvailable(int x, int y, int size) {
		int value = arr[x][y];
		for(int i=x;i<x+size;i++) {
			for(int j= y; j<y+size;j++) {
				if(value != arr[x][y]) {
					return false;
				}
			}
		}
		return true;
	}
}
