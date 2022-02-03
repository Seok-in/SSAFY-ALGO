package A01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 원재의메모리복구하기_허창현 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        // TestCase의 수
        int N = Integer.parseInt(st.nextToken());
        
        String[] TCs = new String[N];
        
        for(int i=0; i<N; i++) {
        	TCs[i] = br.readLine();
        }
        
        for(int k=0; k<N; k++) {
        	// 불편1
        	int[] arr = new int[TCs[k].length()];
        	for(int i=0; i<TCs[k].length(); i++) {
        		// 불편2
        		arr[i] = Character.getNumericValue(TCs[k].charAt(i));
        	}
        	// 핵심
        	// 불편 3
        	int cnt = 0;
        	int my = 0;
        	for(int i=0; i<TCs[k].length(); i++) {
        		if(arr[i]!=my) {
        			cnt++;
        			my = arr[i];
        		}
        	}
        	// 불편 4 printf써야하나..
        	sb.append("#").append(k+1).append(" ").append(cnt).append("\n");
        	System.out.println(sb.toString());
        }
        

		
	}
}
