import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B08_냉장고_홍석인 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 화학물질의 수
		int N = Integer.parseInt(br.readLine());
		// 화학물질 입력받기
		ArrayList<chemical> list = new ArrayList<>();
		// 냉장고
		ArrayList<chemical> refr = new ArrayList<>();
		for(int i=0;i<N;i++) {
			String str[] = br.readLine().split(" ");
			list.add(new chemical(Integer.parseInt(str[0]),Integer.parseInt(str[1])));
		}
		refr.add(list.get(0));
		// 각각의 온도를 비교하여 최솟값이 최댓값보다 크면 냉장고를 만들어줘야함.
		
		for(int j =1;j<N;j++) {
			for(int k=0;k<refr.size();k++) {
				// 화학물질과 냉장고에 들어간 최대 최소 온도 값 비교
				if(refr.get(k).max > list.get(j).min && refr.get(k).min < list.get(j).max) {
					// 냉장고의 온도 설정
					refr.get(k).max = Math.min(refr.get(k).max, list.get(j).max);
					refr.get(k).min = Math.max(refr.get(k).min, list.get(j).min);
					list.get(j).goToRefr = true;
					break;
				}					
			}
			// 들어갈 냉장고가 없을때
			if(!list.get(j).goToRefr) {
				refr.add(list.get(j));
			}
		}
		System.out.println(refr.size());
	}
	public static class chemical {
		int min;
		int max;
		boolean goToRefr=false;
		public chemical(int min, int max) {			
			this.min = min;
			this.max = max;
		}
		
	}
}
