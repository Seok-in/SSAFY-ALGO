package A27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 친구네트워크 { // 서로소 집합으로 풀이
	
	static int[] parents;
	static int[] total;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine()); // 테스트케이스의 수
		
		// 테스트케이스별로 수행
		for(int t=0; t<TC; t++) {
			Map<String, Integer> toNum = new HashMap<>();
			int F = Integer.parseInt(br.readLine()); // 관계의 수
			parents = new int[F*2]; // 친구관계 초기화
			total = new int[F*2];
			
			int idx = 0; // 현재 새로들어올 자리를 뜻함
			// 관계별로 수행
			for(int f=0; f<F; f++) {
				String[] temp = br.readLine().split(" ");
				// 이름별로 수행
				for(int i=0; i<2; i++) {
					if(!toNum.containsKey(temp[i])) { // 처음보는 이름일때
						parents[idx] = idx; // 자기 자신을 가리키도록 해둠(makeSet의 과정으로 생각)
						total[idx] = 1; // 자기자신과 친구이기에.. 1!
						toNum.put(temp[i], idx++); // 이름에 새로운 숫자 매칭
					}
					else {
						continue;
					}
				}
				int al = toNum.get(temp[0]);
				int bl = toNum.get(temp[1]);
				sb.append(union(al,bl)).append("\n");
			}
		}

		System.out.println(sb.toString());
	}
	public static int union(int a, int b) {
        a = findSet(a);
        b = findSet(b);
 
        if (a != b) {
            parents[b] = a;
            total[a] += total[b];
 
        }
 
        return total[a];
    }
	private static int findSet(int a) {
		if(a==parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
}
