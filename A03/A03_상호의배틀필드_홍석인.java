import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A03_상호의배틀필드_홍석인 {
	public static int[] dx = { 1, -1, 0, 0 };
	public static int[] dy = { 0, 0, 1, -1 };

	public static int play(String str3, int direction) {
		if (str3.equals("U")) {
			direction = 1;
		} else if (str3.equals("D")) {
			direction = 0;
		} else if (str3.equals("L")) {
			direction = 3;
		} else if (str3.equals("R")) {
			direction = 2;
		} else if (str3.equals("S")) {
			// shoot();
		} else {
			System.out.print("잘못된 입력입니다.");
		}
		// move(direction);
		return direction;
	}

	public static void main(String[] args) throws Exception {
		Tank tank = new Tank();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char pos = 'a';
		int direction = 0;
		int xpos = 0;
		int ypos = 0;
		int t = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		// 지형 입력받기
		char[][] map = new char[w][h];
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				map[i][j] = (char) br.read();
				// System.out.println(i+"번째"+j+"번째 : "+map[i][j]);
				if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
					pos = map[i][j];
					xpos = i;
					ypos = j;

				}

			}
			br.readLine();
		}

		if (pos == '^') {
			direction = 1;
		} else if (pos == 'v') {
			direction = 0;
		} else if (pos == '<') {
			direction = 2;
		} else if (pos == '>') {
			direction = 3;
		}
		System.out.print(direction);

		int n = Integer.parseInt(br.readLine());
		String[] move = br.readLine().split("");

		for (String moving : move) {
			System.out.println(moving);
			if (moving.equals("S")) {
				map = shoot(map, xpos, ypos, direction);
				continue;
			}
			direction = play(moving, direction);
			tank = move(map, xpos, ypos, direction);
			map = tank.map;
			xpos = tank.xpos;
			ypos = tank.ypos;
		}

		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				bw.write(map[i][j]);
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();

	}

	// move 함수
	public static Tank move(char[][] map, int xpos, int ypos, int direction) {
		// 맵의 범위 확인
		Tank tank = new Tank();
		if (xpos + dx[direction] >= 0 && xpos + dx[direction] < map.length && ypos + dy[direction] >= 0
				&& ypos + dy[direction] < map[0].length) {
			// 갈 수 있는 평지인지 확인
			System.out.println("move동작확인!");
			if (map[xpos + dx[direction]][ypos + dy[direction]] == '.') {
				// 기존에 있던 곳은 평지로 만들기
				map[xpos][ypos] = '.';
				// 움직인곳 바꾸기
				xpos += dx[direction];
				ypos += dy[direction];
			}

			if (direction == 1) {
				map[xpos][ypos] = '^';
				System.out.println(direction + "으로 move!");
			} else if (direction == 0) {
				map[xpos][ypos] = 'v';
				System.out.println(direction + "으로 move!");
			} else if (direction == 2) {
				map[xpos][ypos] = '<';
				System.out.println(direction + "으로 move!");
			} else if (direction == 3) {
				map[xpos][ypos] = '>';
				System.out.println(direction + "으로 move!");
			}
		}

		tank.map = map;
		tank.xpos = xpos;
		tank.ypos = ypos;
		return tank;
	}

	// shoot 함수
	public static char[][] shoot(char[][] map, int xpos, int ypos, int direction) {
		// System.out.println("shoot!");
		// 맵 밖으로 나갈때까지
		while (xpos + dx[direction] >= 0 && xpos + dx[direction] < map.length && ypos + dy[direction] >= 0
				&& ypos + dy[direction] < map[0].length) {
			// 강철이면 멈춤
			if (map[xpos + dx[direction]][ypos + dy[direction]] == '#')
				break;
			// 벽돌이면 평지로 바꾸고 멈춤
			else if (map[xpos + dx[direction]][ypos + dy[direction]] == '*') {
				xpos += dx[direction];
				ypos += dy[direction];
				map[xpos][ypos] = '.';
				break;
			}
			// 그외는 계속 지나감
			else {
				xpos += dx[direction];
				ypos += dy[direction];
			}

		}
		return map;
	}

	public static class Tank {
		public char[][] map;
		public int xpos;
		public int ypos;
	}

}
