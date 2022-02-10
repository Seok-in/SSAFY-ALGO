import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A13_요세푸스_홍석인 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> queue = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b= Integer.parseInt(st.nextToken());		
		for(int i=0;i<a;i++) {
			queue.offer(i+1);
		}
		bw.write("<");
		int count = 1;
		int num = 0;
		while(!queue.isEmpty()) {
			if(count == b) {
				num=queue.poll();
				bw.write(Integer.toString(num));
				if(queue.peek()!=null)
					bw.write(", ");
				count = 1;
			}
			else {
				num=queue.poll();
				queue.offer(num);
				count +=1;
			}
		}		
		bw.write(">");
		bw.flush();
		bw.close();
	}
}
