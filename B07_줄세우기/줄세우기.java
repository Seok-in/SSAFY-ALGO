package B07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄세우기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		StringTokenizer st;
        // 학생의 수 n
		int n = Integer.parseInt(br.readLine());
		// 학생들이 뽑은 번호 입력받기
		st = new StringTokenizer(br.readLine());
		// 학생들의 줄
		List<Integer> line = new ArrayList<>();
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
//			// 뽑은 번호표에 맞는 위치에 학생입장
			if(num==0) {
				line.add(i+1);
			}
			else {
				line.add(i-num, i+1);
			}
		}
		
		for(int std : line) {
			sb.append(std + " ");
		}
        
        System.out.println(sb.toString());
		
	}
}
