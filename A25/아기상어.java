package A25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 아기상어 {
	// bfs로 풀이
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 공간의 크기
		
		// bfs로 풀이 예정이기에 필요 요소 선언 - 1 -> queue(여기선 shark로)
		Queue<fish> shark = new LinkedList<>();
		
		// 공간 입력받기
		int[][] board = new int[N][N]; // 공간 초기화
		for(int r=0; r< N; r++) {
			String[] temp = br.readLine().split(" ");
			for(int c=0; c<N; c++) {
				board[r][c] = Integer.parseInt(temp[c]);
				if(board[r][c] == 9) { // 상어라면 -> BFS의 시작점이기 떄문에 shark에 추가
					shark.offer(new fish(r,c,0));
					board[r][c] = 0; // 빈공간처리
				}
			}
		}
		
		int size = 2; // 상어의 크기 초기화
		int eat = 0; // 상어가 먹은 물고기의 수
		int time = 0; // 시간 초기화
		
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		// 문제풀이 알고리즘
		while(true) {
			// bfs로 풀이 예정이기에 필요 요소 선언 - 1 -> visited
			int[][] visited = new int[N][N];
			// 1. 상어를 기준으로 먹을 수 있는 물고기들이 있는지 확인(bfs사용)
			List<fish> canEat = new ArrayList<>();
			while(!shark.isEmpty()) { //bfs로 확인
				fish now = shark.poll(); // 현재 상어의 정보 가져오기
				for(int i=0; i<4; i++) {
					// 상어가 이동할 좌표
					int new_r = now.row +dr[i];
					int new_c = now.col +dc[i];
					if(new_r < N && new_c < N && new_r>=0 && new_c>=0 && board[new_r][new_c]<=size && visited[new_r][new_c]==0) { // 상어가 지나갈 수 있는 곳이고, 아직 방문한적이 없을때
						if(1 <= board[new_r][new_c] && board[new_r][new_c] < size) { // 상어가 먹을 수 있는 물고기인 경우
							canEat.add(new fish(new_r, new_c, visited[now.row][now.col]+1));
						}
						visited[new_r][new_c] = visited[now.row][now.col] + 1; // visited 갱신
						shark.offer(new fish(new_r, new_c, visited[new_r][new_c])); // 해당위치로 상어 이동해봄
					}
				}
			}
			// 2-1 먹을 수 있는 물고기가 없다면 엄마상어 부르기 -> while문 break (해당 시간 기록)
			if(canEat.size() == 0) {
				sb.append(time);
				break;
			}
//			System.out.println(1);
			// 2-2 먹을 수 있는 물고기가 있을 때
			// 2-2-1 상어의 규칙에 맞는 것 선택 -> 해당 자리로 상어 이동(이동거리만큼 time증가)
			fish chosen = canEat.get(0);
			for(int i=0; i< canEat.size(); i++) {
				if(chosen.dist > canEat.get(i).dist) { // 거리가 더 가까운 물고기 선택
					chosen = canEat.get(i);
				}
				else if(chosen.dist == canEat.get(i).dist) { // 거리가 같은 경우
					if(chosen.row > canEat.get(i).row) { // 더 위에 있는 물고기 선택
						chosen = canEat.get(i);
					}
					else if(chosen.row == canEat.get(i).row) { // 위에 있으면서 거리가 같은게 여러머리라면
						if(chosen.col > canEat.get(i).col) { // 더 왼쪽에 있는 물고기 선택
							chosen = canEat.get(i);
						}
					}
				}
			}
//			System.out.println(chosen.row);
//			System.out.println(chosen.col);
			// 2-2-2 물고기 섭취(상어의 size, age조절, 이동거리 만큼 time 증가)
			eat ++;
			if(eat==size) {
				size++;
				eat = 0;
			}
			board[chosen.row][chosen.col] = 0; // 섭취했으니 0으로 처리
			time += chosen.dist;
			
			shark.add(new fish(chosen.row, chosen.col, 0)); // 해당위치로 상어 이동
		}
		System.out.println(sb.toString());
	}
	
	// 어류 class!!
	public static class fish{
		int row;
		int col; 
		int dist;
		public fish(int row, int col, int dist) {
			this.row = row;
			this.col = col;
			this.dist = dist;
		}
	}
}
