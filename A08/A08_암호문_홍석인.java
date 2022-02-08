import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A08_암호문_홍석인 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		LinkedList<String> originQueue = new LinkedList<>();
		LinkedList<String> newQueue = new LinkedList<>();
		LinkedList<String> insertList = new LinkedList<>();
		int num=0;
		int orderNum=0;
		int pos = 0;
		int insertNum =0;
		int p=0;
		//TestCase 10개
		for(int i=0;i<1;i++) {
			// 암호문의 길이 입력받기
			num=Integer.parseInt(br.readLine());
			// 원본암호문 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<num;j++) {
				originQueue.offer(st.nextToken());
			}
			// 명령어의 개수 입력
			orderNum=Integer.parseInt(br.readLine());
			// 명령어 입력받기
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			while(st2.hasMoreTokens()) {
				p++;
				String str = st2.nextToken();				
				
				if(str.equals("I")) {
					pos = Integer.parseInt(st2.nextToken());
					insertNum = Integer.parseInt(st2.nextToken());
					// 삽입되어야하는 위치까지 따로 빼서 임시리스트에 앞에서부터 저장
					for(int k=0;k<pos;k++) {
						newQueue.offerFirst(originQueue.pollFirst());
					}
					
					// 들어가야할 요소들을 삽입리스트에 저장
					for(int t=0;t<insertNum;t++) {
						insertList.offerLast(st2.nextToken());
					}
					
					// 삽입리스트의 후순위 부터 기존 리스트의 앞에서부터 삽입
					while(!insertList.isEmpty()) {
						originQueue.offerFirst(insertList.pollLast());
					}// 임시리스트의 값을 앞에서부터 기존 리스트의 앞에서부터 삽입  
					while(!newQueue.isEmpty())
						originQueue.offerFirst(newQueue.pollFirst());
				}
				
			}			
			bw.write("#"+i+" ");
			for(int q=0;q<10;q++) {
				bw.write(originQueue.pollFirst()+" ");
			}			
		}
		bw.flush();
		bw.close();
		
	}

}
