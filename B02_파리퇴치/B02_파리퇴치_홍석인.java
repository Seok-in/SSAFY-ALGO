import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B02_파리퇴치_홍석인 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		
		for(int k=0;k<t;k++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			//최댓값
			int max =0;
			int arr[][]=new int[n][n];
			// 배열 입력받기
			for(int i=0;i<n;i++) {
				String a[] = br.readLine().split(" ");
				for(int j=0;j<n;j++) {
					arr[i][j]=Integer.parseInt(a[j]);
				}
			}
			
			// 파리채로 내려치기			
			for(int p=0;p<n;p++) {
				for(int q=0;q<n;q++) {
					// 범위를 벗어나지 않게 내려치기
					int sum =0;
					if(p+m>=n || q+m>=n) {
						continue;
					}
					// 범위 안에 있으면 값 더하기
					for(int x=0;x<m;x++) {
						for(int y=0;y<m;y++) {
							sum+=arr[p+x][q+y];
						}
					}
					if(max<sum) {
						max = sum;
					}
				}
			}
			
			bw.write("#"+k+" "+max+"\n");
		}
		bw.flush();
		bw.close();
	}

}
