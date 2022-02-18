import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class A21_줄세우기_홍석인 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> queue = new LinkedList<>();
		int i = Integer.parseInt(br.readLine());
		int arr[] = new int[i];
		String str[] = br.readLine().split(" ");
		for(int j=0;j<i;j++) {			
			arr[j] =Integer.parseInt(str[j]);
			if(arr[j]==0) {
				queue.addLast(j+1);
			}
			else {
				queue.add(j-arr[j], j+1);				
			}
		}
		StringBuilder sb = new StringBuilder();	
		while(!queue.isEmpty()) {
			sb.append(queue.pollFirst()).append(" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}

}
