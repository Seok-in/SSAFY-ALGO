package A11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class 계산기3 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        // TC의 갯수
        int TC = 10; 
        // TC 수행
        for(int t=0; t<TC; t++) {
        	
        	// 해당 TC의 길이
        	int myLen = Integer.parseInt(br.readLine());
        	// 계산식 입력받기
        	String temp = br.readLine();
        	
        	// 후위식 구하기
        	String postfix = "";
        	// 연산자를 넣을 스택
        	Stack<Character> ops = new Stack<>(); 
        	for(int i=0; i<myLen; i++) {
        		char cur = temp.charAt(i);
        		// 피연산자인 경우 바로 문자열(postfix)로
        		if(cur != '+' && cur != '*'&& cur!='(' && cur!=')') {
        			postfix += cur;
        		}
        		// 연산자인 경우
        		// 여는 괄호인 경우 무조건 push
        		else if(cur == '(') {
        			
        			ops.push(cur);
        		}
        		else if(cur == ')') {
        			
        			while(ops.peek()!='(') {
        				postfix += ops.pop();
        			}
        			ops.pop();
        		}
        		else {
        			
        			// 연산자 스택이 빈경우, 스택에 푸쉬
        			if(ops.isEmpty()) {
        				ops.push(cur);
        			}
        			else {
        				// 스택의 맨 위 값의 우선순위가 새로 들어온 연산자의 우선순위보다 크거나 같은 경우, 
        				// 스택 위의 연산자를 뽑고 postfix에 추가 -> 현재 연산자를 스택에 추가
        				if(myPriority(ops.peek()) >= myPriority(cur)) {
        					
        					postfix += ops.pop();
        					ops.push(cur);
        				}
        				else {
        					
        					ops.push(cur);
        				}
        			}
        		}
        		
        		
        	}
        	while(!ops.isEmpty()) {
        		postfix += ops.pop();
        	}
        	
        	
        	// 후위식을 이용하여 계산식 계산하기
        	// 피연산자들을 저장할 stack
        	Stack<Integer> operands = new Stack<>();
        	for(int i=0; i<postfix.length(); i++) {
        		char cur = postfix.charAt(i);
        		// 피연산자인 경우 operands에 추가
        		if(cur != '+' && cur != '*') {
        			operands.push(cur-'0');
        		}
        		// 연산자를 만난 경우 operands의 맨위 두 피연산자를 꺼내 계산 후, 결과르 operands에 푸쉬
        		else {
        			int operand1 = operands.pop();
        			int operand2 = operands.pop();
        			if(cur=='+') {
        				operands.push(operand1+operand2);
        			}
        			else {
        				operands.push(operand1*operand2);
        			}
        		}
        	}
        	
        	
        	
        	// StringBuilder에 정답 저장
        	sb.append("#"+(t+1));
//        	sb.append(" " + ans);
//        	sb.append(" " + postfix);
        	sb.append(" " + operands.peek());
        	sb.append("\n");
        }
        System.out.println(sb.toString());
        
	}
	public static int myPriority(char op) {
		if(op=='(') {
			return 0;
		}
		else if(op=='+') {
			return 1;
		}
		else {
			return 2;
		}
	}
	
	
}