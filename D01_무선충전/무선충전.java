package D01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 무선충전 {
	static int[] moveA;
	static int[] moveB;
	static BC[] BCs;
	static int[] dr = {0,-1,0,1,0};
	static int[] dc = {0,0,1,0,-1};
	static int M;
	static int A;
	
	
	static int A_r, A_c, B_r, B_c;
	static int totalCharge;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine()); // 테스트케이스의 수
		// 테스트케이스별 반복
		for(int t=0; t<TC; t++) {
			String[] temp =br.readLine().split(" ");
			M = Integer.parseInt(temp[0]); // 총 이동시간
			A = Integer.parseInt(temp[1]); // BC의 수
			// 사용자 A의 이동정보 입력받기
			moveA = new int[M];
			temp =br.readLine().split(" ");
			for(int i=0; i<M; i++) {
				moveA[i] = Integer.parseInt(temp[i]);
			}
			// 사용자 B의 이동정보 입력받기
			moveB = new int[M];
			temp =br.readLine().split(" ");
			for(int i=0; i<M; i++) {
				moveB[i] = Integer.parseInt(temp[i]);
			}
			// BC의 정보 입력받기
			BCs = new BC[A];
			for(int i=0; i<A; i++) {
				temp =br.readLine().split(" ");
				BCs[i] = new BC(Integer.parseInt(temp[1])-1, Integer.parseInt(temp[0])-1, Integer.parseInt(temp[2]), Integer.parseInt(temp[3]));
			}
			Arrays.sort(BCs); // 성능 순으로 BC들 정렬
			
			// 본격적인 이동 시작
			int time = 0; // 시간 초기화
			// A의 좌표 초기화
			A_r = 0;
			A_c = 0;
			// B의 좌표 초기화
			B_r = 9;
			B_c = 9;
			totalCharge = 0; // 총 충전량 초기화
			boolean check;
			while(time<=M) { // 수정 예정
				int forA = 2;
				int forB = 2;
				// 현재 자리에서 충전
				int tempCharge = 0;
				for(int i=0; i<A; i++) {
					check = false;
					
					if(BCs[i].can(A_r, A_c) && forA>0) {
						forA -= 1;
						check = true;
					}
					if(BCs[i].can(B_r, B_c) && forB>0) {
						forB -= 1;
						check = true;
					}
					if(forA == 1 && forB==1 && check) { // 나중에 정리
						if(tempCharge+BCs[i].power>BCs[0].power) { // 얌전히 한개씩 나눠먹을 수 있다.
							tempCharge += BCs[i].power;
							break;
						}
						else { // 같은칸 뺴먹었을 뿐이다.
							tempCharge += BCs[i].power;
						}
					}
					if(forA==2 && forB==1 && check) {
						tempCharge += BCs[i].power;
					}
					if(forA==1 && forB==2 && check) {
						tempCharge += BCs[i].power;
					}
					if(forA==2 && forB==0 && check) {
						continue;
					}
					if(forA==0 && forB==2 && check) {
						continue;
					}
					if(forA==1 && forB==0 && check) {
						tempCharge += BCs[i].power;
						break;
					}
					if(forA==0 && forB==1 && check) {
						tempCharge += BCs[i].power;
						break;
					}
					if(forA==0 && forB==0 && check) {
						tempCharge += BCs[i].power;
						break;
					}
				}
				
				totalCharge += tempCharge;
				
				
				// 다음 자리로 이동
				if(time==M) { // 다음 이동할 자리가 없기에 break
					break;
				}
				// 사용자가 지도밖으로 나가는 경우가 없기에, 시원하게 이동
				A_r += dr[moveA[time]];
				A_c += dc[moveA[time]];
				B_r += dr[moveB[time]];
				B_c += dc[moveB[time]];
				
				time++;
			}
			sb.append("#").append(t+1).append(" ").append(totalCharge).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static class BC implements Comparable<BC>{
		int r,c;
		int range;
		int power;
		
		BC(int r, int c, int range, int power){
			this.r = r;
			this.c = c;
			this.range = range;
			this.power = power;
		}
		@Override
		public int compareTo(BC o) { // 충전 파워를 기준으로 내림차순
			// TODO Auto-generated method stub
			return -(this.power-o.power);
		}
		public boolean can(int rr, int cc) { // (rr,cc)가 범위 내에 있는지 확인하는 함수 
			if(Math.abs(this.r-rr)+Math.abs(this.c-cc)<=range) {
				return true;
			}
			return false;
		}
	}
	
	
}
