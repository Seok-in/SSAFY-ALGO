import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class A27_친구네트워크_홍석인 {
	static List<Integer> list = new ArrayList<Integer>(); // union find 배열
	static List<Integer> total = new ArrayList<Integer>(); // 친구들의 수를 저장
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T--> 0) {
			list.clear();
			total.clear();
			int F =Integer.parseInt(br.readLine());
			int people = 0;
			Map<String, Integer> map = new HashMap<>();
			while(F-- > 0) {
				String[] input = br.readLine().split(" ");
				
				for(int i=0; i<2;i++) {
					if(!map.containsKey(input[i])) {
						map.put(input[i],people++);
						list.add(people -1);
						total.add(1);
					}
				}
				int a = map.get(input[0]);
				int b = map.get(input[1]);
				
				merge(a,b);
				
				a = find(a); // a 의 루트를 찾기
				System.out.println(total.get(a));
				
			}
		}
	}
	public static int find(int a) {
		if(list.get(a)== a) return a;
		list.set(a, find(list.get(a)));
		return list.get(a);
	}
	
	public static void merge(int a, int b) {
		a=find(a);
		b=find(b);
		
		if(b < a) {
			int tmp = a;
			a =b;
			b= tmp;
		}
		if(a==b) return;
		list.set(b, a); // list[b] = a
		total.set(a, total.get(a)+total.get(b));
 	}
}
