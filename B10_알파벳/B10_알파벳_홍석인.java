import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10_알파벳_홍석인 {
	public static int dx[] = { 1, 0, -1, 0 };
	public static int dy[] = { 0, 1, 0, -1 };
	public static char board[][];
	public static boolean alpha[] = new boolean [26];
	public static int result;
	public static int R;
	public static int C;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		board = new char[C][R];
		for(int i=0;i<R;i++) {
			String str2 = br.readLine();
			for(int j=0;j<C;j++) {
				board[i][j]=str2.charAt(j);
			}			
		}
		// 첫번째자리 방문 처리
		int first = (int)board[0][0]-65;
		alpha[first]=true;
		move(0,0,1);
		System.out.println(result);
	}
	// dfs로 최댓값을 구하는 함수
	public static void move(int xpos ,int ypos, int count) {		
		result=Math.max(result,count);
		for(int i=0;i<4;i++) {
			int nx = xpos +dx[i];
			int ny = ypos +dy[i];
			if(!isAvailable(nx, ny)) continue;
			int num = (int)board[nx][ny]-65;
			if(alpha[num])
				continue;
			alpha[num] = true;
			move(xpos, ypos,count+1);
			alpha[num]=false;			
		}			
	}

	public static boolean isAvailable(int xpos, int ypos) {
		if(xpos >=0 && ypos>=0 && xpos < C && ypos<R) {
			return true;
		}
		return false;
	}
}
