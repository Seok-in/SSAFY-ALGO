package B10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 알파벳 {
	static char[][] board;
	static boolean[] visit;
	static int row;
	static int col;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// R과 C 입력받기
		String[] temp = br.readLine().split(" ");
		row = Integer.parseInt(temp[0]); // 행의크기
		col = Integer.parseInt(temp[1]); // 열의 크기
		
		// 알파벳 보드 입력 받기
		board = new char[row][col];
		for(int r=0; r<row; r++) {
			board[r] = br.readLine().toCharArray();
		}
		
		// (0,0)에서 시작하는 가장 긴 길을 dfs를 이용하여 찾기
		visit = new boolean[26]; // 알파벳 갯수만큼!(A:0, B:1 ... 이런식으로 대응시켜 사용)
		visit[board[0][0]-'A'] = true;
		ans = 0;
		myDfs(1,0,0);
		sb.append(ans);
		System.out.println(sb.toString());
	}
	public static void myDfs(int cnt, int r, int c) {
		// 종료조건
		if(!moveRight(r,c) && !moveLeft(r,c)&& !moveDown(r,c)&& !moveUp(r,c)) {
			ans = Math.max(ans, cnt);
			return;
		}
		if(moveRight(r,c)) {
			visit[board[r][c+1]-'A'] = true;
			myDfs(cnt+1,r,c+1);
			visit[board[r][c+1]-'A'] = false;
		}
		if(moveLeft(r,c)) {
			visit[board[r][c-1]-'A'] = true;
			myDfs(cnt+1,r,c-1);
			visit[board[r][c-1]-'A'] = false;
		}
		if(moveDown(r,c)) {
			visit[board[r+1][c]-'A'] = true;
			myDfs(cnt+1,r+1,c);
			visit[board[r+1][c]-'A'] = false;
		}
		if(moveUp(r,c)) {
			visit[board[r-1][c]-'A'] = true;
			myDfs(cnt+1,r-1,c);
			visit[board[r-1][c]-'A'] = false;
		}
		
	}
	private static boolean moveUp(int r, int c) {
		if(r-1>=0 && !visit[board[r-1][c]-'A']) {
			return true;
		}
		return false;
	}
	private static boolean moveDown(int r, int c) {
		if(r+1<row && !visit[board[r+1][c]-'A']) {
			return true;
		}
		return false;
	}
	private static boolean moveLeft(int r, int c) {
		if(c-1>=0 && !visit[board[r][c-1]-'A']) {
			return true;
		}
		return false;
	}
	private static boolean moveRight(int r, int c) {
		if(c+1<col && !visit[board[r][c+1]-'A']) {
			return true;
		}
		return false;
	}
}
