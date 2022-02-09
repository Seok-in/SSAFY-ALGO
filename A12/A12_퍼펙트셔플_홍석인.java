import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class A12_퍼펙트셔플_홍석인 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		LinkedList<String> listA = new LinkedList<>();
		LinkedList<String> listB = new LinkedList<>();
		LinkedList<String> perfect = new LinkedList<>();
		String mid="";
		int T=Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			int len = Integer.parseInt(br.readLine());
			System.out.println(len);
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int k=0;k<len;k++) {			
				if(k<(len/2)) {
					listA.add(st.nextToken());					
				}				
				else if(k>=(len/2)){
					listB.add(st.nextToken());
				}				
				
			}
			if(len%2==1) {
				mid=listB.pollFirst();
			}
			
			for(int j=0;j<listA.size();j++) {
							
				perfect.add(listA.get(j));
				perfect.add(listB.get(j));				
			}
			bw.write("#"+(i+1));
			if(len%2!=0)
				perfect.add(mid);
			for(int x=0;x<len;x++) {
				bw.write(" "+perfect.get(x));
			}
			bw.newLine();
			listA.clear();
			listB.clear();
			perfect.clear();
		}
		bw.flush();
		bw.close();
	}
	
	
}
