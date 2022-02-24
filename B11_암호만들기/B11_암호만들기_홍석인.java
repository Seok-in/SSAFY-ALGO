import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B11_암호만들기_홍석인 {
	public static int N;
	public static char[] result;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[] = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		int b = Integer.parseInt(str[1]);
		
		//character배열에 값 저장
		char arr2[] = new char[b];
		result = new char[N];
		String str2[]= br.readLine().split(" ");
		
		for(int j=0;j<b;j++) {
			arr2[j] = str2[j].charAt(0);
		}
		// 정렬해주기
		Arrays.sort(arr2);
		comb(0,0,arr2);
		System.out.println(sb.toString());
	}
	// 조합
	public static void comb(int count, int start, char[] arr) {
		int aCount = 0;
		int bCount = 0;
		if(count == N) {
			// 자음과 모음의 개수 카운트
			for(char a : result) {
				if(a == 'i' || a=='e' || a=='o'|| a=='u'|| a=='a') {
					aCount +=1;
				}
				else {
					bCount +=1;
				}
			}
			if(aCount >= 1 && bCount >=2) {
				for(char a : result)
					sb.append(a);
				sb.append("\n");
			}			
			return;
		}
		for(int i=start;i<arr.length;i++) {
			result[count] = arr[i];
			comb(count+1,i+1,arr);
		}
	}
}
