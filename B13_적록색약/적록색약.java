package B13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 적록색약 { // dfs 이용 풀이 & 구역의 색깔보다는 구역에 집중하여 접근
	static char[][] picture;
	static int N;
	static int[][] nPicture;
	static int[][] cbPicture;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine()); // 그림의 크기
		
		// 그림 입력받기
		picture = new char[N][N];
		for(int r=0; r<N; r++) {
			picture[r] = br.readLine().toCharArray();
		}
		
		int nArea = 0; // 일반인이 보는 구역의 수
		int cbArea = 0; // 생약이 보는 구역의 수
		
		nPicture = new int[N][N]; // 일반인이 한 구역화
		cbPicture = new int[N][N]; // 색약이 한 구역화
		
		// 그림내 각점에 대하여
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(nPicture[r][c] == 0) { // 일반환자가 아직 구역화 시키지 않은 경우
					nArea++; // 일반인이 구역화 한것 하나 증가
					nDfs(r, c, nArea, picture[r][c]);
				}
				if(cbPicture[r][c] == 0) { // 색약환자가 아직 구역화 시키지 않은 경우
					cbArea++; // 색약이 구역화 한 것 하나 증가
					cbDfs(r, c, cbArea, picture[r][c]);
				}
			}
		}
		sb.append(nArea).append(" ").append(cbArea);
		System.out.println(sb.toString());
	}
	private static void cbDfs(int r, int c, int cbArea, char pix) {
		// 현재 위치 구역화
		cbPicture[r][c] = cbArea;
		
		// 이동할 수 있는 곳 확인
		for(int i=0; i<4; i++) {
			int new_r = r+dr[i];
			int new_c = c+dc[i];
			if(new_r>=0 && new_c>=0 && new_r<N && new_c<N && cbPicture[new_r][new_c] == 0) { // 이동가능하고, 아직 구역화 시키지 않았다면 
				if(pix == 'B') { // 파란색만 파란색으로 봄!!
					if(picture[new_r][new_c] == pix ) {
						// 이동 위치 구역화
						cbPicture[new_r][new_c] = cbArea;
						// 다음 위치로 이동
						cbDfs(new_r, new_c, cbArea, pix);					
					}
				}
				else { // 빨강 초록.. 둘다 똑같다...
					if(picture[new_r][new_c] == 'R' || picture[new_r][new_c] == 'G') {
						// 이동 위치 구역화
						cbPicture[new_r][new_c] = cbArea;
						// 다음 위치로 이동
						cbDfs(new_r, new_c, cbArea, pix);
					}
				}
			}
		}
		
	}
	private static void nDfs(int r, int c, int nArea, char pix) {
		// 현재 위치 구역화
		nPicture[r][c] = nArea;
		
		// 이동할 수 있는 곳 확인
		for(int i=0; i<4; i++) {
			int new_r = r+dr[i];
			int new_c = c+dc[i];
			if(new_r>=0 && new_c>=0 && new_r<N && new_c<N && picture[new_r][new_c] == pix && nPicture[new_r][new_c] == 0) { // 이동가능하고, 아직 구역화 시키지 않았다면 
				// 이동 위치 구역화
				nPicture[new_r][new_c] = nArea;
				// 다음 위치로 이동
				nDfs(new_r, new_c, nArea, pix);
			}
		}
	}
}
