import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Stack;

public class B03_탑_홍석인 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int a = Integer.parseInt(br.readLine());
		int num = 0;
		int key = 0;

		// 결과를 받을 Map
		HashMap<Integer, Integer> map = new HashMap<>();

		HashMap<Integer, Integer> map2 = new HashMap<>();
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		String arr[] = (br.readLine().split(" "));
		for (int i = 0; i < a; i++) {
			num = Integer.parseInt(arr[i]);
			map2.put(num,i+1);
			// stack이 비어있으면 푸쉬
			if (stack.isEmpty()) {
				stack.push(num);
			}
			else if (!stack.isEmpty()) {
				// 스택에 있는 top이 주어진 값보다 크면 push
				if (stack.peek() > num) {
					
					stack.push(num);
				}
				// 스택에 있는 top이 주어진 값보다 작으면 pop -> 큰값이 나올때까지 pop
				// pop 하기 전에 값을 저장해야함
				else if (stack.peek() < num) {
					while (true) {
						if (stack.peek() > num) {
							stack.push(num);							
							break;
						}
						key = stack.peek();						
						stack.pop();
						if (stack.isEmpty()) {
							map.put(key, 0);
							System.out.println(key);
							stack.push(num);							
							break;
						} else if (!stack.isEmpty()) {
							map.put(key, stack.peek());
						}
					}
				}
			}
		}
		while(!stack.isEmpty()) {
			key =stack.peek();
			stack.pop();
			if(stack.isEmpty()) {
				map.put(key, 0);
				break;
			}				
			map.put(key, stack.peek());
		}
		map2.put(0, 0);
		for(int j=0;j<arr.length;j++) {			
			int num2 = map.get(Integer.parseInt(arr[j]));
			System.out.print(map2.get(num2)+" ");
		}
		

	}
}
