import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class A06_괄호짝짓기_홍석인 {
	public static char[] arr2= new char[2];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0;i<1;i++) {
			Stack<Character>stack = new Stack();
			int T = Integer.parseInt(br.readLine());
			String str = br.readLine();
			for(int j=0;j<T;j++) {
				char a=str.charAt(j);
				if(!stack.isEmpty()) {
					if( a == '}' && stack.peek()=='{') {
						stack.pop();
					}
					else if(a == ']' && stack.peek()=='[') {
						stack.pop();
					}
					else if(a==')'&& stack.peek()=='(') {
						stack.pop();
					}
					else if(a=='>'&&stack.peek()=='<') {
						stack.pop();
					}
					else
						stack.push(a);
				}
				
				else
					stack.push(a);
				}
			if(stack.isEmpty())
				bw.write("#"+ (i+1) +" " +1+"\n");
			else
				bw.write("#"+ (i+1) +" " +1+"\n");;
		}
		bw.flush();
		bw.close();
		
		
	}

}
