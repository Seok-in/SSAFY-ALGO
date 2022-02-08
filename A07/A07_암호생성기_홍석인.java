import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A07_암호생성기_홍석인 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<String> queue = new LinkedList<>();
		int num=0;
		int x =0;
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<8;j++) {
				queue.offer(st.nextToken());
			}
			while(true) {
				if(x==5)
					x=0;
				num=Integer.parseInt(queue.poll());				
				x+=1;
				num-=x;
				if(num<=0) {
					num =0;
					queue.offer(Integer.toString(num));
					bw.write("#"+T +" ");
					break;
				}
				queue.offer(Integer.toString(num));
			}
			while(!queue.isEmpty()) {
				bw.write(queue.poll()+" ");
			}
			
		}
		bw.flush();
		bw.close();
	}

}
