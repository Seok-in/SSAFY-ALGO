package A14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 사칙연산유효성검사 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        // TC의 수
        int TC = 10;
        for(int t=0; t<TC; t++) {
        	// 정답 여부
        	int answer = 1;
        	// tree의 사이즈 입력 받음
        	int treeSize = Integer.parseInt(br.readLine());
        	// 문제풀이 알고리즘
        	// (1.노드에 자식이 없다는 건 leaf node라는 뜻이다. 2.leafnode는 피연산자이다. 3.그 외 node는 연산자이다.)
        	for(int i=0; i<treeSize; i++) {
        		st = new StringTokenizer(br.readLine());
        		int node = Integer.parseInt(st.nextToken());
        		String op = st.nextToken();
        		// 자식이 있는지 try
        		try{
        			st.nextToken();
        			// 자식이 있는경우, 해당 node의 값이 피연산자라면 계산이 불가능하다.
        			if(op.charAt(0)>='0' && op.charAt(0)<='9') {
        				answer = 0;
        			}
        		}
        		catch(Exception e) {
        			// 자식이 없다 = leafnode -> 연산자라면 계산이 불가능하다.
        			if(op.charAt(0)<'0' || op.charAt(0)>'9') {
        				answer = 0;
        			}
        			
        		}
        	}
        	sb.append("#"+(t+1));
        	sb.append(" "+answer);
        	sb.append("\n");
        }        
        System.out.println(sb.toString());
	}	
}