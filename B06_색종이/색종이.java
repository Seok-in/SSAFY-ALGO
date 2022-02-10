package B06;

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

public class 색종이 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        // 색종이의 수
        int num = Integer.parseInt(br.readLine());
        // 색종이가 덮는전체영역의 방문 여부
        boolean[][] visited = new boolean[101][101];
        // 색종이가 덮는 영역의 크기
        int area = 0;
        // 각 색종이를 입력받은 뒤 차지하는 영역을 area에 추가
        for(int i=0; i<num; i++) {
        	st = new StringTokenizer(br.readLine());
        	int col= Integer.parseInt(st.nextToken());
        	int row= Integer.parseInt(st.nextToken());
        	// 그림과 같이 접근하지 않지만, 영역을 구하는데는 차이가 없다.
        	// 색종이 덮는 영역을 area에 추가
        	for(int r = row; r<row+10; r++) {
        		for(int c = col; c<col+10; c++) {
        			if(!visited[r][c]) {
        				visited[r][c] = true;
        				area += 1;
        			}
        		}
        	}
        }
        sb.append(area);
        System.out.println(sb.toString());
	}	
}