package B02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 파리퇴치_허창현 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		String temp = "";
		
        // TC의 수
        int TC = Integer.parseInt(br.readLine());
        
        // 영역의 크기
        int a_size = 0;
        // 파리채의 크기
        int f_size = 0;
        // 잡은 파리의 최댓값
        int max_hit = 0;
        // 현재 위치에서 잡은 파리의 합
        int sum = 0;
        
        
        
        for(int t=0; t<TC; t++) {
        	temp = br.readLine();
        	a_size=Integer.parseInt(temp.split(" ")[0]);
        	f_size=Integer.parseInt(temp.split(" ")[1]);
        	// 영역 입력받기
        	int[][] area = new int[a_size][a_size];
        	
        	for(int r=0; r<a_size; r++) {
        		temp = br.readLine();
        		for(int c=0; c<a_size; c++) {
        			// 불편...
        			area[r][c] = Integer.parseInt(temp.split(" ")[c]);
        		}
        	}

        	// 잡은 파리의 최댓값 계산
        	max_hit = 0;
        	for(int r=0; r<a_size-f_size+1; r++) {
        		for(int c=0; c<a_size-f_size+1; c++) {
        			sum = 0;
        			for(int i=0; i<f_size; i++) {
        				for(int j=0; j<f_size; j++) {
        					sum +=area[r+i][c+j];
        				}
        			}
        			if(sum > max_hit) {
        				max_hit = sum;
        			}
        		}
        	}
        	
        	
        	// 수확한 농작물의 수 출력
        	System.out.print("#"+(t+1) + " ");
        	System.out.println(max_hit);
        	

        } 
		
	}
}
