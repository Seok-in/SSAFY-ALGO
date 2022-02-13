import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class C02_비밀번호_홍석인 {
	public static int zeroCount = 0;
	public static int oneCount = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Long a = Long.parseLong(br.readLine());
		LinkedList<Long> list = new LinkedList<>();
		LinkedList<Long> result = new LinkedList<>();
		int sum = 0;
		int n = 1;
		// 2진법 바꾸기
		while (true) {
			if (a == 1) {
				list.offerFirst((long)1);
				result.offerFirst((long)1);
				break;
			}
			list.offerFirst(a % 2);
			result.offerFirst(a % 2);
			a /= 2;
		}
		// 2진법을 숫자로 바꾸기
		result = small(result);
		while (true) {
			if (result.isEmpty())
				break;
			sum += (n * result.pollLast());
			n *= 2;
		}
		bw.write(Integer.toString(sum) + " ");
		bw.flush();
		zeroCount = 0;
		oneCount = 0;
		sum = 0;
		
		n = 1;
			
		list = big(list);
		while (true) {
			if (list.isEmpty())
				break;
			sum += (n * list.pollLast());
			n *= 2;
		}
		bw.write(Integer.toString(sum));
		bw.flush();
		bw.close();	
		
	}

	// 큰 수 찾기
	public static LinkedList<Long> big(LinkedList<Long> list) {
		while (true) {
			if (list.peekLast() == 1) {
				//System.out.println("큰 수 1빼기");
				list.pollLast();
				oneCount += 1;
				// 리스트가 빈 경우(예외.. 11111)
				if (list.isEmpty()) {
					list.offerLast((long)0);					
				}
				// 1을 뺀 후에 0이 나오면 중단
				if (list.peekLast() == 0) {
					// 0을 1로 바꿔주기
					//System.out.println("큰 수 0빼기,, 종료");
					list.pollLast();
					zeroCount += 1;
					list.offerLast((long)1);
					oneCount -= 1;
					// 큰 수 중에 작은수가 제일 가까운 수 이므로 0부터 먼저 넣어주기
					for (int i = 0; i < zeroCount; i++) {
						list.offerLast((long)0);
					}
					// 그 다음에 1넣어주기
					for (int j = 0; j < oneCount; j++) {
						list.offerLast((long)1);
					}
					break;
				}

			} else if (list.peekLast() == 0) {
				//System.out.println("큰 수 0빼기");
				list.pollLast();
				zeroCount += 1;
			}
		}
		return list;
	}

	// 작은 수 찾기
	public static LinkedList<Long> small(LinkedList<Long> list) {
		while (true) {
			if (list.peekLast() == 0) {
				//System.out.println("작은 수 0빼기");
				list.pollLast();
				zeroCount += 1;
				// 0을 뺀 후에 1이 나오면 중단
				if (list.peekLast() == 1) {
					// 1을 0으로 바꿔주기
					//System.out.println("작은 수 1빼기,, 종료");
					list.pollLast();
					oneCount += 1;
					list.offerLast((long)0);
					zeroCount -= 1;

					// 작은 수 중 제일 큰수이므로 1부터 먼저 넣어주기
					for (int i = 0; i < oneCount; i++) {
						list.offerLast((long)1);
					}
					// 그 다음에 0 넣어주기
					for (int j = 0; j < zeroCount; j++) {
						list.offerLast((long)0);
					}
					break;
				}
			} else if (list.peekLast() == 1) {
				//System.out.println("작은 수 1빼기");
				list.pollLast();
				oneCount += 1;
				// list가 전부 1인경우 작은수가 없으므로 0출력하기
				if (list.isEmpty()) {
					list.offer((long)0);
					break;
				}
			}
		}
		return list;
	}
}
