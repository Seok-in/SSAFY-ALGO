import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A09_정사각형방_홍석인 {
	public static int[] dx = { 1, -1, 0, 0 };
	public static int[] dy = { 0, 0, 1, -1 };
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			int max =0;
			int value = 0;
			int xpos =0;
			int ypos =0;
			int arr[][] = new int[N][N];
			
			//2차원 배열 입력받기
			for(int j=0;j<N;j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k=0;k<N;k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());					
				}
			}
			
			
			// 2차원 배열 이동 탐색
			for(int k=0;k<N;k++) {
				for(int p=0;p<N;p++) {
					//상 하 좌 우 탐색
					value = find(arr,k,p);					
					if(max<value) {
						max = value;
						xpos = k;
						ypos = p;
					}
						
				}
			}
			
			bw.write("#"+(i+1)+" "+arr[xpos][ypos]+" "+max+"\n");			
		}
		bw.flush();
		bw.close();
	}
	public static int find(int[][] arr,int x, int y) {
		int count =1;
		int directionCount = 0;
		while(directionCount<4) {			
			// 1. 상방향 탐색
			if(x>0) {				
				directionCount += 1;
				if((arr[x][y]+1) == arr[x-1][y]) {
					x-=1;
					count += 1;
					directionCount =0;
					continue;
				}
			}
			// 2. 하방향 탐색
			if(x<arr.length-1) {				
				directionCount += 1;
				if((arr[x][y]+1)==arr[x+1][y]) {
					x+=1;
					count += 1;
					directionCount =0;					
					continue;
				}
			}
			// 3. 우방향 탐색
			if(y<arr.length-1) {				
				directionCount += 1;
				if((arr[x][y]+1)==arr[x][y+1]) {
					y+=1;
					count += 1;
					directionCount =0;					
					continue;
				}
			}
			// 4. 좌방향 탐색
			if(y>0)  {				
				directionCount += 1;
				if((arr[x][y]+1)==arr[x][y-1]) {
					y-=1;
					count += 1;
					directionCount =0;					
					continue;
				}
			}			
			
		}
		return count;
	}
}
