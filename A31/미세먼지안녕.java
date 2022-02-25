package A31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 미세먼지안녕 { // bfs로 풀이
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] temp = br.readLine().split(" ");
		
		int R = Integer.parseInt(temp[0]); // 행의 크기
		int C = Integer.parseInt(temp[1]); // 열의 크기
		int T = Integer.parseInt(temp[2]); // 시간
		
		// 사방 탐색을 위한 재료(우상좌하)
		int[] dr = {0,-1,0,1};
		int[] dc = {1,0,-1,0};
		
		// 방 입력받기(공기청정기 위치 확인)
		int down_ac = -1;
		int[][] room = new int[R][C];
		for(int r=0; r<R; r++) {
			temp = br.readLine().split(" ");
			for(int c=0; c<C; c++) {
				room[r][c] = Integer.parseInt(temp[c]);
				if(room[r][c] == -1) {
					down_ac = r; // 무적권 1열에 존재하며 2칸 붙어있기 떄문에 밑어있는거 하나만 가지고 있어도 위치 추적 가능
				}
			}
		}
		
		// T 시간 동안 반복 !
		for(int t=0; t<T; t++) {
			// 문제풀이 알고리즘
			// 1. 미세먼지 확산 (bfs 사용)
			// queue생성 -> 초기값 잡아서 queue에 넣어주기
			Queue<int[]> queue = new LinkedList<>();
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					if(room[r][c] > 0) { // 양수 -> 미세먼지
						queue.offer(new int[] {r,c,room[r][c]});
					}
				}
			}
			// 확산시키기
			while(!queue.isEmpty()) {
				int[] cur = queue.poll();
				//종료조건 넣을까..
				int dust = cur[2]/5; // 확산되는 양
				// 사방으로 확산
				for(int i=0; i<4; i++) {
					int new_r = cur[0] + dr[i];
					int new_c = cur[1] + dc[i];
					if(new_r>=0 && new_c>=0 && new_r<R && new_c<C
							&& room[new_r][new_c]!=-1) { // 해당 위치로 이동가능하고 공기청정기가 아닌 경우
						room[new_r][new_c] += dust; // 해당 방으로 먼지 보내기
						room[cur[0]][cur[1]] -= dust; // 보낸 먼지만큼 기존 위치의 먼지 감소
					}
				}
			}
			
			// 2. 공기청정기 돌리기
			int up_ac = down_ac-1;
			// 위쪽 공기청정기 ->  반시계방향 
			int start_r = up_ac;
			int start_c = 1; 
			int dir = 0;
			int tmp = room[start_r][start_c];
			room[start_r][start_c] = 0;
			while(true) {
				int nr = start_r + dr[dir];
				int nc = start_c + dc[dir];
				// 종료 조건(공기 청정기와 만난 경우)
				if(nr==up_ac && nc == 0) {
					break;
				}
				 // 범위 안에 있으면
               if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                  // 자리 스왑
                  int tmp2 = room[nr][nc];
                  room[nr][nc] = tmp;
                  tmp = tmp2;
                  start_r = nr;
                  start_c = nc;
               }
               // 막힐땐 -> 방향전환
               else {
                   dir += 1;
                   if (dir == 4)
                      dir = 0;
                }
			}
	        
	        // 아래쪽 공기청정기 ->  시계방향 
			start_r = down_ac;
			start_c = 1; 
			dir = 0;
			tmp = room[start_r][start_c];
			room[start_r][start_c] = 0;
			while(true) {
				int nr = start_r + dr[dir];
				int nc = start_c + dc[dir];
				// 종료 조건(공기 청정기와 만난 경우)
				if(nr==down_ac && nc == 0) {
					break;
				}
				 // 범위 안에 있으면
               if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                  // 자리 스왑
                  int tmp2 = room[nr][nc];
                  room[nr][nc] = tmp;
                  tmp = tmp2;
                  start_r = nr;
                  start_c = nc;
               }
               // 막힐땐 -> 방향전환
               else {
                   dir += 3;
                   dir %= 4;
                }
			}
		}
		
		// 방에 남은 먼지의 양 출력
		int ans = 0;
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				ans += room[r][c];
			}
		}

		sb.append(ans+2);
		System.out.println(sb.toString());
	}
}
