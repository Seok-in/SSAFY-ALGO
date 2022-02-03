import java.io.*;
import java.util.StringTokenizer;

public class A01_원재의메모리복구하기_홍석인 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = br.read()-48;
		br.readLine();
		for(int i=0;i<t;i++) {
			String str = br.readLine();
			String array[] = str.split("");
			int count =0;
			int changeValue = 0;
			for(int j=0;j<array.length;j++) {
				int a=Integer.parseInt(array[j]);
				System.out.println(a);
				if(a != changeValue) {
					count +=1;
					if(changeValue ==0)
						changeValue = 1;
					else if(changeValue == 1)
						changeValue = 0;
				}
			}
			bw.write("#"+(i+1)+" "+count +"\n");
		}
		bw.flush();
		bw.close();
	}

}
