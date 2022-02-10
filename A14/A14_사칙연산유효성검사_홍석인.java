import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A14_사칙연산유효성검사_홍석인 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		for (int t = 0; t < 10; t++) {
			char node[] = new char[n + 1];
			node[0] = '0';			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int k = Integer.parseInt(st.nextToken());
				System.out.println(k);
				node[k] = (st.nextToken().charAt(0));
			}			
			bw.write("#"+(t+1)+" "+dfs(1,node)+"\n");
		}
		bw.flush();
		bw.close();
	}

	public static int dfs(int num, char[] arr) {		
		// 노드 탐색시 숫자가 나왔을때 다음 깊이에 탐색할 노드가 있으면 틀린 계산식임.
		if(arr[num]!='+'&& arr[num]!='-'&&arr[num]!='*'&&arr[num]!='/') {
			if(num *2<=arr.length-1)
				return 0;
		}
		if (num * 2 <= arr.length-1) {				
				return dfs(num * 2, arr);				
			}

		if (num * 2 + 1 <= arr.length-1) {
			return dfs(num * 2 +1 , arr);
		}
		else return 1;
	}
}
