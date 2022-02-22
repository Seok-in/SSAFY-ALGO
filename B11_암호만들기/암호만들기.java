package B11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 암호만들기 {
	static StringBuilder sb = new StringBuilder();
	static int L, C;
	static boolean[] isSelected;
	static String[] myAlp;
	static List<String> myAns = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String[] temp = br.readLine().split(" ");
		L = Integer.parseInt(temp[0]); // 암호의 길이
		C = Integer.parseInt(temp[1]); // 문자의 수
		
		myAlp = br.readLine().split(" ");
		Arrays.sort(myAlp);
		
		
		
		 
		// 문제 알고리즘(dfs사용 예정)
		// 가능성 있는 시작점들에 대하여
		
		isSelected = new boolean[C];
		dfs(0, 0);
		
		Collections.sort(myAns);
		for(String ans : myAns) {
			sb.append(ans).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
	private static void dfs(int depth, int length) {
		// 종료 조건
		if(length == L) {
			String[] temp = new String[L];
			int cnt1 = 0;
			int cnt2 = 0;
			int idx = 0;
			for(int i=0; i<C; i++) {
				if(isSelected[i]) {
					temp[idx] = myAlp[i];
					if(myAlp[i].equals("a") || myAlp[i].equals("e") || myAlp[i].equals("i") || myAlp[i].equals("o") || myAlp[i].equals("u")) {
						cnt1 ++;
					}
					else {
						cnt2++;
					}
					idx++;
				}
			}
			String ans = "";
			if(cnt1>=1 && cnt2 >=2) {
				for(int i=0; i<L; i++) {
//					sb.append(temp[i]);
					ans += temp[i];
				}
				myAns.add(ans);
//				sb.append("\n");
			}
			return;
		}
		if(depth >= C) {
			return;
		}
		for(int i=depth; i<C; i++) {
			if(isSelected[i]) {
				continue;
			}
			isSelected[i] = true;
			dfs(i+1,length+1);
			isSelected[i] = false;
		}
		
	}
}



