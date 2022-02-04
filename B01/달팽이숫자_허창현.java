package A03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 달팽이숫자_허창현 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // TestCase의 수
        int TC = Integer.parseInt(st.nextToken());
        // 달팽이의 크기
        int[] snails = new int[TC];
        
        for(int i=0; i<TC; i++) {
        	snails[i] = Integer.parseInt(br.readLine());
        }
        
        // 달팽이 숫자
        int n;
        
        // 달퍙이 이동방향 제어(순서 :  우 하 좌 상)
        // row방향
        int[] dr = {0,1,0,-1};
        // col방향
        int[] dc = {1,0,-1,0};
        //방향 제어기
        int d = 0;
        
        //현재 달팽이 좌표
        int r;
        int c;
        
        for(int i=0; i<TC; i++) {
        	// 달팽이 숫자 초기화
        	n = 1;
        	// 우측 이동 먼저
        	d = 0;
        	//좌표 초기화
        	r = 0;
        	c = 0;
        	// 달팽이가 움직일 판(모두 0으로 초기화)
        	int[][] board = new int[snails[i]][snails[i]];
        	// 불편 처리가능할듯
        	board[0][0] = n;
        	n++;
//        	snails[i]*snails[i]
        	while(n<=snails[i]*snails[i]) {
        		//현재 방향으로 이동가능시
        		if(r+dr[d]>=0 && r+dr[d]<snails[i] && c+dc[d]>=0 && c+dc[d]<snails[i] && board[r+dr[d]][c+dc[d]]==0) {
        			r = r+dr[d];
        			c = c+dc[d];
        			board[r][c] = n;
        			n++;
        			continue;
        			
        		}
        		// 이동불가시, 방향 전환
        		else {
        			d = (d+1)%4;
        		}	
        	}
//        	완성된 보드 출력
        	for(int[] bo : board) {
        		for(int b: bo) {
        			System.out.print(b + " ");;
        		}
        		System.out.println();
        	}
        	
        }
		System.out.println("success");
	}
}
