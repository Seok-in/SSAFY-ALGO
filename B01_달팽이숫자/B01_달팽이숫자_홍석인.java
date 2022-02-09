import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A03_달팽이숫자_홍석인 {
	public static int dx[] = {0,1,0,-1};
	public static int dy[] = {1,0,-1,0};	

	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int x=0;
		int y=0;
		int d = 0;
		
		int t = br.read()-48;
		br.readLine();
		for(int i=0;i<t;i++) {
			int j =1;
			int a = Integer.parseInt(br.readLine());				
			int arr[][] = new int[a][a];
			arr[0][0]=1;
			x=0;
			y=0;
			j+=1;
			while(j<=a*a) {			
				
				// 오른쪽, 아래쪽, 왼쪽, 위쪽으로 이동
				if(x+dx[d]>=0 && y+dy[d]>=0 && x+dx[d]<a && y+dy[d]<a && arr[x+dx[d]][y+dy[d]]==0) {
					x += dx[d];
					y += dy[d];
					arr[x][y]=j;
					j++;
					continue;
				}				
				else {					
					d+=1;
					if(d==4)
						d =0;
				}				
			}
			bw.write("#"+(i+1)+"\n");
			for(int k=0;k<a;k++) {
				for (int p=0;p<a;p++) {
					bw.write(arr[k][p]+" ");
				}
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
	}

}
