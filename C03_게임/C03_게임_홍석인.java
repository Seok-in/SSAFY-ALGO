import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class C03_게임_홍석인 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int num1 = 0;
		int num2 = 0;
		for(int i=0;i<c;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			num1=Integer.parseInt(st2.nextToken());
			num2=Integer.parseInt(st2.nextToken());
			if(num1==b) {
				b = num2;
			}
			else if(num2==b) {
				b = num1;
			}
		}
		bw.write(Integer.toString(b));
		bw.flush();
		bw.close();
	}
}
