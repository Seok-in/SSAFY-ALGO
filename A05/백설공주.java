package A05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 백설공주 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 행의 길이
        int dwarf = 9;
        // 후보들
        int[] candidates = new int[dwarf];
        int sum=0;;
        
        for(int i=0; i<dwarf; i++) {
        	candidates[i] = Integer.parseInt(br.readLine());
        	sum += candidates[i];
        }
        // 출력할때 오름차순 출력해야 하므로 미리 sort
        
        
        
        // 전체에서 두명의 값을 빼서 진짜 난쟁이들을 알아낸다.
        outer : for(int i=0; i<dwarf-1; i++) {
        	for(int j=i; j<dwarf; j++) {
        		if(sum - (candidates[i]+candidates[j]) == 100) {
        			// 정답이니 출력
        			for(int d=0; d<dwarf; d++) {
        				if(d==i || d==j) {
        					continue;
        				}
        				
        				sb.append(candidates[d]).append("\n");
        			}
        			break outer;
        		}
        	}
        }
        System.out.println(sb.toString());
	}
}
