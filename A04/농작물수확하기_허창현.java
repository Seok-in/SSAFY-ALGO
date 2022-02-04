package A04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 농작물수확하기_허창현 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		String temp = "";
		
        // TC의 수
        int TC = Integer.parseInt(br.readLine());
        
        // 농장의 크기
        int size = 0;
        
        // 앞에 비울 칸의 수
        int blank=0;
        // 수확할 칸의 수
        int harvest=0;
        // 수확총합
        int sum=0;
        
        for(int t=0; t<TC; t++) {
        	size = Integer.parseInt(br.readLine());
        	// 농장 입력받기
        	int[][] field = new int[size][size];
        	
        	for(int r=0; r<size; r++) {
        		temp = br.readLine();
        		for(int c=0; c<size; c++) {
        			// 불편...
        			field[r][c] = Integer.parseInt(temp.split("")[c]);
        		}
        	}
        	
        	// 수확 합 계산하기
        	sum = 0;
        	for(int r=0; r<size; r++) {
        		// 윗 쪽, 가운데
        		if(r<=size/2) {
        			blank = size/2 -r;
        			harvest = size - 2*blank;
        			for(int c=blank; c<blank+harvest; c++) {
        				sum += field[r][c];
        			}
        		}
        		// 가운데, 수정마렵
//        		else if(r==size/2) {
//        			for(int c=0; c<size; c++) {
//        				sum += field[r][c];
//        			}
//        		}
        		// 아래
        		else {
        			blank = r - size/2;
        			harvest = size - 2*blank;
        			for(int c=blank; c<blank+harvest; c++) {
        				sum += field[r][c];
        			}
        		}
        	}
        	
        	
        	
        	
        	
        	// 수확한 농작물의 수 출력
        	System.out.print("#"+(t+1) + " ");
        	System.out.println(sum);
        	

        }
        
        
        
        
        
        
		
	}
}
