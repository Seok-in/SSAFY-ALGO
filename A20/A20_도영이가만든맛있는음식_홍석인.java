import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class A20_도영이가만든맛있는음식_홍석인 {
	static LinkedList<Ingred> list = new LinkedList<>();

	public static class Ingred {
		Long a;
		Long b;

		public Ingred(java.lang.Long a, java.lang.Long l) {
			this.a = a;
			this.b = l;
		}
	}

	public static Long sumA = 1L;
	public static Long sumB = 0L;
	public static Long min = Long.MAX_VALUE;

	public static void main(String[] args) throws Exception {

		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		Long arr[] = new Long[T];
		Long arr2[] = new Long[T];
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Ingred(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())));
		}
		for (int k = 1; k <= list.size(); k++) {			
			for (int i = 0; i < (1 << list.size()); i++) { // 1024번 수행
				if (Integer.bitCount(i) == k) {
					//System.out.println("bit의 개수가" + k+"개인 "+i);
					sumA = 1L;
					sumB = 0L;					
					// j는 0부터 j는 리스트의 자리수 까지 들어있는 원소 유무 파악
					for (int j = 0; j < list.size(); j++) {
						// j의 원소 유무 파악
						if (((1 << j) & i) > 0) {
							//System.out.println("리스트에 포함된 원소: "+j);
							sumA *= list.get(j).a;							
							sumB += list.get(j).b;							
						}									
					}
					min = Math.min(min, (sumA - sumB) > 0 ? sumA - sumB : sumB - sumA);		
				}
			}
		}
		sb.append(min);
        System.out.println(sb);
	}
}
