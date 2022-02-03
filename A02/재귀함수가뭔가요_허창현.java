package A02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 재귀함수가뭔가요 {
	// 재귀함수
	public static void recursion(int n, int N) {
		String bar = "";
		// for문 사용과 함수 인자 2개인것이 불편.
		// 이문제의 포인트인 "__"를 처리하기 위한 부분
		for(int i=0; i<(N-n); i++) {
			bar+="____";
		}
		// 공통 질문
		System.out.println(bar + "재귀함수가 뭔가요?");
		// n이 0인경우
		if(n==0) {
			System.out.println(bar + "재귀함수는 자기 자신을 호출하는 함수라네");
			System.out.println(bar + "라고 답변하였지.");
			// 함수 종료
			return;
		}
		else {
			// n이 0이 아닌경우 출력
			System.out.println(bar + "잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
			System.out.println(bar + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
			System.out.println(bar + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.");
		}
		// 이 뒤로는 n이 0이 아닌경우에만 동작(n이 0일때는 리턴 되기 때문)
		// n을 1줄이고 함수 다시실행(재귀)
		recursion(n-1, N);
		// 함수가 끝마치고 나와지면 마무리 멘트 출력
		System.out.println(bar + "라고 답변하였지.");
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // TestCase의 수
        int N = Integer.parseInt(st.nextToken());
        
        String[] TCs = new String[N];
        
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        // 재귀함수 호출
        recursion(N, N);

		
	}
}
