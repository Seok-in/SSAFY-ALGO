import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A24_서로소집합_홍석인 {
	static int N;
	static int[] parents;
	
	public static void makeSet() {
		// 1부터 N까지의 집합 선언
		parents = new int [N+1];
		for(int i=0;i<N;i++) {
			parents[i]=i;
		}
	}
	// 집합찾기
	public static int findSet(int a) {
		if(a==parents[a]) return a;
		return parents[a]=findSet(parents[a]);		
	}
	// 합집합
	public static boolean union(int a, int b) {		
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return true;
		else return false;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int M;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			String str1[] = br.readLine().split(" ");
			N =Integer.parseInt(str1[0]);
			M = Integer.parseInt(str1[1]);
			makeSet();
			sb.append("#").append(i+1).append(" ");
			for(int j=0;j<M;j++) {
				String str[] = br.readLine().split(" ");
				int a = Integer.parseInt(str[0]);
				int m = Integer.parseInt(str[1]);
				int n = Integer.parseInt(str[2]);
				// 합집합을 하면서 집합을 찾기때문에 합집합만 해줘도 됨.
				if(a == 0) {
					union(n,m);
					continue;
				}				
				if(union(n,m)) {
					sb.append(1);
				}
				else {
					sb.append(0);
				}				
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
