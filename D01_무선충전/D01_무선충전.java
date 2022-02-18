import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class D01_무선충전 {
	//public static int arr[][] = new int[11][11];
	
	public static int dy[] = { 0, -1, 0, 1, 0 };
	public static int dx[] = { 0, 0, 1, 0, -1 };	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 테스트 케이스 입력
		int N = Integer.parseInt(br.readLine());
		ArrayList<Bc> Bcs = new ArrayList<>();
		// N번만큼 수행
		for (int i = 0; i < N; i++) {
			String str[] = br.readLine().split(" ");
			// M A 입력
			int M = Integer.parseInt(str[0]);
			int A = Integer.parseInt(str[1]);
			 
			//Bcs = new Bc[A];
			Bcs.clear();
			int aMove[] = new int[M+1];
			int bMove[] = new int[M+1];
			
			String str2[] = br.readLine().split(" ");
			String str3[] = br.readLine().split(" ");
			
			aMove[M] = 0;
			bMove[M] = 0;
			
			// 이동 정보 받기
			for (int j = 0; j < M; j++) {
				aMove[j] = Integer.parseInt(str2[j]);
				bMove[j] = Integer.parseInt(str3[j]);
			}

			// BC 정보 받기
			for (int k = 0; k < A; k++) {
				String str4[] = br.readLine().split(" ");
				Bcs.add(new Bc(Integer.parseInt(str4[0]), Integer.parseInt(str4[1]), Integer.parseInt(str4[2]),
						Integer.parseInt(str4[3])));				
			}
			//Power 순으로 정렬
			Collections.sort(Bcs, (a, b) -> b.power-a.power);			
			
			// 이동하기
			int nxA = 1;
			int nyA = 1;
			int nxB = 10;
			int nyB = 10;
			
			int result = 0;
			
			int countA = 0;
			int countB = 0;			
			
			for (int p = 0; p < M+1; p++) {
				countA = 0;
				countB = 0;
				//System.out.println(p+"단계"+"x좌표 :" +nxA+ "y좌표 : "+nyA);
				//System.out.println(p+"단계"+"x좌표 :" +nxB+ "y좌표 : "+nyB);
				
				for(int q=0;q<A;q++) {
					if(countA >= 2 && countB>=2) {
						continue;
					}					
					if(Bcs.get(q).isAvailable(nxA, nyA) && Bcs.get(q).isAvailable(nxB, nyB)){
						//ystem.out.println("중복 : "+Bcs.get(q).power);
						result += Bcs.get(q).power;
						countA +=1;
						countB +=1;
					}					
					else if(Bcs.get(q).isAvailable(nxA, nyA) && countA != 2) {
						//System.out.println("A :"+Bcs.get(q).power);
						result += Bcs.get(q).power;
						countA = 2;
						countB += 1;
					}
					else if(Bcs.get(q).isAvailable(nxB, nyB) && countB != 2) {
						//System.out.println("B : " + Bcs.get(q).power);
						result += Bcs.get(q).power;
						countB = 2;
						countA += 1;
					}
				}				
				nxA = nxA + dx[aMove[p]];
				nyA = nyA + dy[aMove[p]];
				nxB = nxB + dx[bMove[p]];
				nyB = nyB + dy[bMove[p]];				
			}
			sb.append("#").append(i+1).append(" ").append(result).append("\n");					
		}
		System.out.println(sb.toString());
	}
	

	// BC 클래스
	public static class Bc{
		int xpos;
		int ypos;
		int range;
		int power;

		// 생성자
		public Bc(int xpos, int ypos, int range, int power) {
			this.xpos = xpos;
			this.ypos = ypos;
			this.range = range;
			this.power = power;
		}

		// 충전할 수 있는 범위인지 확인
		public boolean isAvailable(int xpos, int ypos) {
			int x = Math.abs(this.xpos - xpos);
			int y = Math.abs(this.ypos - ypos);
			if (x + y <= this.range)
				return true;
			else
				return false;
		}		
	}
}
