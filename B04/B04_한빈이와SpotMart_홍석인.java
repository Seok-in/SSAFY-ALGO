import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B04_한빈이와SpotMart_홍석인 {
	public static int sum =-1;
	public static int num[]=new int[2];
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int N =0;
		int M=0;
		for(int i=0;i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			StringTokenizer st2=new StringTokenizer(br.readLine());
			int[] arr= new int[N];
			//값 입력받기
			for(int j =0; j<N;j++) {
				arr[j]=Integer.parseInt(st2.nextToken());
			}
			if(N!=1)
				comb(arr,0,0,N, M);
			bw.write("#"+(i+1)+" "+sum+"\n");
			sum=-1;
				
			
		}
		bw.flush();
		bw.close();
	}
	
	//comb 함수
	public static void comb(int[] arr, int start, int count, int N, int M) {		
		if(count==2) {
			if(sum<(num[0]+num[1]) && num[0]+num[1]<=M)
				sum = num[0]+num[1];
			return;
		}			
		for(int j=start;j<N;j++) {
			num[count]=arr[j];			
			comb(arr,j+1,count+1,N, M);
		}
	}
	
}
