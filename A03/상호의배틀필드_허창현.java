package A03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상호의배틀필드_허창현 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		String temp = "";
		
        // TC의 수
        int TC = Integer.parseInt(br.readLine());
        
        // r(행), c(렬)의 크기
        int row=0;
        int col=0;
        
        // 전차의 좌표, 방향
        int r=0;
        int c=0;
        
        // 사용자가 넣을 입력의 수
        int num = 0;
        // 영령어
        char cmd;
        
        for(int t=0; t<TC; t++) {
        	temp = br.readLine();
        	row=Integer.parseInt(temp.split(" ")[0]);
        	col=Integer.parseInt(temp.split(" ")[1]);
        	
        	// 배틀필드 입력받기
        	char[][] BF = new char[row][col];
        	for(int i=0; i<row; i++) {
        		temp = br.readLine();
        		for(int j=0; j<col; j++) {
        			BF[i][j] = temp.charAt(j);
        			// ><v^ 발견시, 전차의 위치 확인
        			// 동
        			if(BF[i][j] == '>') {
        				r = i;
        				c = j;
        			}
        			// 서
        			else if(BF[i][j] == '<') {
        				r = i;
        				c = j;
        			}
        			// 남
        			else if(BF[i][j] == 'v') {
        				r = i;
        				c = j;
        			}
        			//북
        			else if(BF[i][j] == '^') {
        				r = i;
        				c = j;
        			}
        			else {
        				continue;
        			}
        		}
        	}
        	
        	// cmd의 수 입력 받기
        	num = Integer.parseInt(br.readLine());
        	// 명령여들 입력 받기
        	temp = br.readLine();
        	
        	// cmd처리하기
        	for(int i=0; i<num; i++) {
        		cmd = temp.charAt(i);
        		switch(cmd) {
        		// 동
        		case 'R':
        			// 전차의 상태 변경
        			BF[r][c] = '>';
        			// 이동가능(공간이 존재하고, 평지라면)하다면 이동
        			if(c+1<col && BF[r][c+1]=='.') {
        				BF[r][c+1] ='>';
        				BF[r][c] = '.';
        				// 전차의 좌표 갱신
        				c += 1;
        			}
        			break;
        		// 서
        		case 'L':
        			// 전차의 상태 변경
        			BF[r][c] = '<';
        			// 이동가능(공간이 존재하고, 평지라면)하다면 이동
        			if(c-1>=0 && BF[r][c-1]=='.') {
        				BF[r][c-1] ='<';
        				BF[r][c] = '.';
        				// 전차의 좌표 갱신
        				c -= 1;
        			}
        			break;
        		// 남
        		case 'D':
        			// 전차의 상태 변경
        			BF[r][c] = 'v';
        			// 이동가능(공간이 존재하고, 평지라면)하다면 이동
        			if(r+1<row && BF[r+1][c]=='.') {
        				BF[r+1][c] ='v';
        				BF[r][c] = '.';
        				// 전차의 좌표 갱신
        				r += 1;
        			}
        			break;
        		// 북
        		case 'U':
        			// 전차의 상태 변경
        			BF[r][c] = '^';
        			// 이동가능(공간이 존재하고, 평지라면)하다면 이동
        			if(r-1>=0 && BF[r-1][c]=='.') {
        				BF[r-1][c] ='^';
        				BF[r][c] = '.';
        				// 전차의 좌표 갱신
        				r -= 1;
        			}
        			break;
        		// 사격
        		case 'S':
        			int mv;
        			// 동쪽으로 쏘기
        			if(BF[r][c]=='>') {
        				mv = 1;
        				while(true) {
        					// 포탄이 맵밖으로 나간경우
        					if(c+mv>=col) {
        						break;
        					}
        					// 강철벽을 만난경우
        					else if(BF[r][c+mv] == '#') {
        						break;
        					}
        					// 벽돌벽을 만난경우
        					else if(BF[r][c+mv] == '*') {
        						BF[r][c+mv] = '.';
        						break;
        					}
        					
        					mv++;
        				}
        			}
        			// 서쪽으로 쏘기
        			if(BF[r][c]=='<') {
        				mv = 1;
        				while(true) {
        					// 포탄이 맵밖으로 나간경우
        					if(c-mv<0) {
        						break;
        					}
        					// 강철벽을 만난경우
        					else if(BF[r][c-mv] == '#') {
        						break;
        					}
        					// 벽돌벽을 만난경우
        					else if(BF[r][c-mv] == '*') {
        						BF[r][c-mv] = '.';
        						break;
        					}
        					
        					mv++;
        				}
        			}
        			// 남쪽으로 쏘기
        			if(BF[r][c]=='v') {
        				mv = 1;
        				while(true) {
        					// 포탄이 맵밖으로 나간경우
        					if(r+mv>=row) {
        						break;
        					}
        					// 강철벽을 만난경우
        					else if(BF[r+mv][c] == '#') {
        						break;
        					}
        					// 벽돌벽을 만난경우
        					else if(BF[r+mv][c] == '*') {
        						BF[r+mv][c] = '.';
        						break;
        					}
        					
        					mv++;
        				}
        			}
        			// 북쪽으로 쏘기
        			if(BF[r][c]=='^') {
        				mv = 1;
        				while(true) {
        					// 포탄이 맵밖으로 나간경우
        					if(r-mv<0) {
        						break;
        					}
        					// 강철벽을 만난경우
        					else if(BF[r-mv][c] == '#') {
        						break;
        					}
        					// 벽돌벽을 만난경우
        					else if(BF[r-mv][c] == '*') {
        						BF[r-mv][c] = '.';
        						break;
        					}
        					
        					mv++;
        				}
        			}
        			break;
        		}
        		
    		}
        	
        	
        	
        	// cmd 후 BF출력
        	System.out.print("#"+(t+1) + " ");
        	for(int i=0; i<row; i++) {
        		for(int j=0; j<col; j++) {
        			System.out.print(BF[i][j]);
        		}
        		System.out.println();
        	}
        	
        	// 시험용
//        	System.out.println(num);
//        	System.out.println(temp);
//        	System.out.println(temp.charAt(22)=='S');
        }
        
        
        
        
        
        
		
	}
}
