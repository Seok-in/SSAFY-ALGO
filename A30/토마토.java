package A30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 토마토 { // bfs로 풀이
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] temp = br.readLine().split(" ");
		
		int col = Integer.parseInt(temp[0]); // 열의 크기
		int row = Integer.parseInt(temp[1]); // 행의 크기
		
		// 사방 탐색을 위한 재료
		int[] dr = {0,0,1,-1};
		int[] dc = {1,-1,0,0};
		
		// 상자 입력받기
		int[][] box = new int[row][col];
		for(int r=0; r<row; r++) {
			temp = br.readLine().split(" ");
			for(int c=0; c<col; c++) {
				box[r][c] = Integer.parseInt(temp[c]);
			}
		}
		
		// bfs를 사용하기 위해 visited(box로 대체가능할듯)와 queue 선언
		Deque<int[]> queue = new LinkedList<>();
		
		// bfs의 queue에 초깃값입력(box를 완탐하며 1로 표기된 부분을 	queue에 추가)
		for(int r=0; r<row; r++) {
			for(int c=0; c<col; c++) {
				if(box[r][c] == 1) { // 익지 않은 토마토가 있는 경우
					queue.offer(new int[] {r,c});
				}
			}
		}
		
		// bfs 알고리즘 실행
		while(!queue.isEmpty()) {
			// queue의 원소를 하나 꺼낸뒤, visited를 사용할 필요가 있나,,?
			int[] cur = queue.poll();
			// 사방 탐색하며 이동가능시 기존 위치의 값에 +1 (box에서)
			for(int i=0; i<4; i++) {
				int new_r = cur[0] + dr[i];
				int new_c = cur[1] + dc[i];
				if(new_r>=0 && new_c>=0 && new_r<row && new_c<col && box[new_r][new_c]==0) { // 해당 위치로 이동가능하고 익지 않은 토마토인 경우
					box[new_r][new_c] = box[cur[0]][cur[1]]+1;
					queue.offer(new int[] {new_r, new_c});
				}
			}
		}
		// box내 가장 큰 값 출력
		int ans = 0;
		outer : for(int r=0; r<row; r++) {
			for(int c=0; c<col; c++) {
				if(box[r][c] == 0) { // 익지 않은 토마토가 있는 경우
					ans = 0;
					break outer;
				}
				ans = Math.max(ans, box[r][c]);
			}
		}
		sb.append(ans-1);
		System.out.println(sb.toString());
	}
}
