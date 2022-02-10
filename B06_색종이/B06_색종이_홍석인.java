import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B06_색종이_홍석인 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean visited[][]=new boolean[111][111];
		int num = Integer.parseInt(br.readLine());
		int xpos =0;
		int ypos =0;
		int result = 100*num;		
		for(int i=0;i<num;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ypos = Integer.parseInt(st.nextToken());
			xpos = 100-Integer.parseInt(st.nextToken());			
			for(int j=xpos-10;j<xpos;j++) {
				for(int k=ypos;k<ypos+10;k++) {
					if(visited[j][k]==true)
						result -= 1;
					else
						visited[j][k]=true;
				}
			}			
		}
		bw.write(Integer.toString(result));
		bw.flush();
		bw.close();
	}
}
