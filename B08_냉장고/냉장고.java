package B08_냉장고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 냉장고 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 화학물질의 수
		// 화학물질들 입력받기
		Chem[] arr = new Chem[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Chem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		 // 화학물질들을 최고 보관온도를 기준으로 오름차순 정렬
		Arrays.sort(arr);
		
		int refr =1; // 냉장고의 수
		int i=0;
		Chem cur = arr[0];
		while(i<N) {
			if(cur.maxTemp < arr[i].minTemp) {
				cur = arr[i];
				refr ++;
			}
			i++;
		}
		sb.append(refr);
		System.out.println(sb.toString());
	}
	
	static class Chem implements Comparable<Chem>{
		int minTemp;
		int maxTemp;
		
		Chem(int minTemp, int maxTemp){
			this.minTemp = minTemp;
			this.maxTemp = maxTemp;
			
		}
		@Override
		public int compareTo(Chem o) {
			// TODO Auto-generated method stub
			return this.maxTemp - o.maxTemp;
		}
	}
}
