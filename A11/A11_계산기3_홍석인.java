import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class A11_계산기3_홍석인 {
	public static void makeHu() {
		
	}
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
				if (a == '(')
					stack.push('(');
				else if (a == ')') {
					while (true) {
						if (stack.peek() == '(') {
							stack.pop();
							break;
						} else {
							sb.append(stack.pop());
						}
					}
				} else if (a != '*' && a != '+') {
					sb.append(a);
				}
				else if (stack.isEmpty())
					stack.push(a);
				else if(a=='*') {
					stack.push(a);
				} else if (a=='+') {
					while(!stack.isEmpty()) {
						if(stack.peek()=='(') {
							stack.push(a);
							break;
						}
						else {
							sb.append(stack.pop());
						}
					}
				}
			}		
			
			while (!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			//계산하기
			//System.out.println(sb.toString());
			for (int p = 0; p < sb.length(); p++) {
				if (sb.charAt(p) == '+' || sb.charAt(p) == '*') {
					num1 = stack2.pop();
					num2 = stack2.pop();
					if (sb.charAt(p) == '+')
						stack2.push(num1 + num2);
					else
						stack2.push(num1 * num2);
				} else {
					stack2.push(sb.charAt(p) - '0');
				}
			}
			bw.write("#" + (i + 1) + " " + stack2.pop() + "\n");
		}
		bw.flush();
		bw.close();
	}
}
