package boj2567;

import java.util.Arrays;
import java.util.Scanner;

public class Confetti2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] paper = new int[100][100];
		for(int i = 0; i < 100; i++)
			Arrays.fill(paper[i], 3);
		int N = sc.nextInt();
		for(int t = 0;  t < N; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			//테두리 칠하기
			
			//빈공간: 4, 꼭짓점: 2, 변: 1, 면: 0
			for(int r = 24 - y; r >= 15 - y; r--) {
				for(int c = x; c < x + 10; c++) {
					if(paper[r][c] == 0) //이미 붙어있다면 볼필요 없음
						continue;
					//꼭짓점일때
					if((r == 24 - y && c == x) || (r == 15 - y && c == x) ||
						(r == 24 - y && c == x + 9) || (r == 15 - y && c == x + 9)) {
						if(paper[r][c] == 3)//빈공간이면
							paper[r][c] = 2;
						else
							paper[r][c] = 0;
					}
					//변일때
					else if(r == 24 - y || r == 15 - y || c == x || c == x + 9) {
						if(paper[r][c] == 3)
							paper[r][c] = 1;
						else
							paper[r][c] = 0;
					}
					else
						paper[r][c] = 0;
				}
			}
			for(int i = 0;  i < 25; i++) {
				for(int j = 0; j < 25; j++) {
					System.out.print(paper[i][j]);
				}
				System.out.println();
			}
			
//			//붙어있는 변 제거 + 둘레 계산
//			int total = 0;
//			for(int i = 0;  i < 100; i++) {
//				for(int j = 0; j < 100; j++) {
//					
//				}
//			}
		}
		sc.close();
	}
}
