package A06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class 괄호짝짓기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // TC의 갯수
        int TC = 10;

//        for(int i=0; i<TC; i++) {
//        	int valid = 0;
//        	int len = Integer.parseInt(br.readLine());
//        	String temp = br.readLine();
//        	// 0:( 1:[ 2:{ 3:<
//        	int[] brackets = new int[4]; 
//        	for(int j=0; j<len; j++) {
//        		char bracket = temp.charAt(j);
//        		switch(bracket){
//        		case '(' : brackets[0] += 1; break;
//        		case '[' : brackets[1] += 1; break;
//        		case '{' : brackets[2] += 1; break;
//        		case '<' : brackets[3] += 1; break;
//        		case ')' : brackets[0] -= 1; break;
//        		case ']' : brackets[1] -= 1; break;
//        		case '}' : brackets[2] -= 1; break;
//        		case '>' : brackets[3] -= 1; break;
//        		}
//        	}
//        	if(brackets[0]==0 && brackets[1]==0 && brackets[2]==0 && brackets[3]==0) {
//        		valid = 1;
//        	}
//        	
//        	sb.append("#").append(i+1).append(" ").append(valid).append("\n");
//        }
        for(int i=0; i<TC; i++) {
        	int valid = 1;
        	int len = Integer.parseInt(br.readLine());
        	String temp = br.readLine();
        	Stack<Character> stack = new Stack<>();
        	
        	outer : for(int j=0; j<len; j++) {
        		char bracket = temp.charAt(j);
        		switch(bracket){
        		case ')' : 
        			if(stack.peek() != '(') {
        				valid = 0;
        				break outer;
        			}
        			else {
        				stack.pop();
        			}
        			break;
        		case ']' : 
        			if(stack.peek() != '[') {
        				valid = 0;
        				break outer;
        			}
        			else {
        				stack.pop();
        			}
        			break;
        		case '}' : 
        			if(stack.peek() != '{') {
        				valid = 0;
        				break outer;
        			}
        			else {
        				stack.pop();
        			}
        			break;
        		case '>' : 
        			if(stack.peek() != '<') {
        				valid = 0;
        				break outer;
        			}
        			else {
        				stack.pop();
        			}
        			break;
        		default:
        			stack.push(bracket);
        			break;
        		}
        	}
        	
        	
        	sb.append("#").append(i+1).append(" ").append(valid).append("\n");
        }
        
        
        System.out.println(sb.toString());
	}
}