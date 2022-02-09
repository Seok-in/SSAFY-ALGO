package B03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 탑의 갯수
        int num = Integer.parseInt(br.readLine());
        String temp = br.readLine();
        String[] str_tops = temp.split(" ");
        int[] tops = new int[num];
        
        Stack<List<Integer>> stack = new Stack<>();
        
        // 탑들 입력받기
        for(int i=0; i<num; i++) {
        	tops[i] = Integer.parseInt(str_tops[i]);
        	
        	while(true) {
        		// 스택이 빈경우
        		if(stack.isEmpty()) {
        			sb.append("0 ");
        			List<Integer> tempList = new ArrayList<>();
        			tempList.add(i+1);
        			tempList.add(tops[i]);
        			stack.push(tempList);
        			break;
        		}
        		
        		// 스택이 있는 경우
        		else {
        			List<Integer> tempList1 = new ArrayList<>();
        			tempList1 = stack.peek();
        			// 스택에 맨위에 있는 것의 높이가 새로 들어온 것 보다 더 높은 경우
        			if(tempList1.get(1)>tops[i]) {
        				sb.append(tempList1.get(0) + " ");
        				List<Integer> tempList = new ArrayList<>();
            			tempList.add(i+1);
            			tempList.add(tops[i]);
            			stack.push(tempList);
            			break;
        			}
        			// 새로 들어온 것이 더 높은 경우
        			else {
        				stack.pop();
        			}
        		}
        		
        	}
        }
        
        
        System.out.println(sb.toString());
        
	}
}