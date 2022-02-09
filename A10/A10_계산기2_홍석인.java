import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class A10_계산기2_홍석인 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num1 = 0;
		int num2 = 0;
		for (int i = 0; i < 10; i++) {
			int len = Integer.parseInt(br.readLine());
			Stack<Character> stack = new Stack<>();
			Stack<Integer> stack2 = new Stack<>();
			String str = br.readLine();
			StringBuilder sb = new StringBuilder();
			// 후위연산자 변환하기
			for (int j = 0; j < len; j++) {
				char a = str.charAt(j);				
				// 숫자면 삽입
				if (a != '*' && a != '+') {
					sb.append(a);
					continue;
				}
				// 연산자인 경우
				if (stack.isEmpty())
					stack.push(a);
				else if (stack.peek() == '*') {
					sb.append(stack.pop());
					if(a=='*') {
						stack.push(a);
					}
					else {
						sb.append(a);
					}					
				} else if (stack.peek() == '+') {
					if (a == '*') {
						stack.push(a);
					} else {
						sb.append(stack.pop());
						stack.push(a);
						
					}
						
				}				
			}
			while(!stack.isEmpty()){
				sb.append(stack.pop());				
			}
			for(int p=0;p<sb.length();p++) {
				if(sb.charAt(p)=='+'||sb.charAt(p)=='*') {
					num1 = stack2.pop();
					num2 = stack2.pop();
					if(sb.charAt(p)=='+')
						stack2.push(num1+num2);
					else
						stack2.push(num1*num2);
				}
				else {
					stack2.push(sb.charAt(p)-'0');					
				}
					
				
			}
			bw.write("#"+(i+1)+" "+stack2.pop()+"\n");
		}
		bw.flush();
		bw.close();
	}
}