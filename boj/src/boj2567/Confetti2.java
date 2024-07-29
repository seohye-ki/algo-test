package boj2567;

import java.util.Arrays;
import java.util.Scanner;

public class Confetti2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//100 * 100 도화지
		int[][] paper = new int[100][100];
		for(int i = 0; i < 100; i++)
			Arrays.fill(paper[i], 4);
		
		//중복값 체크 배열
		int[][] check = new int[100][100];
		for(int i = 0; i < 100; i++)
			Arrays.fill(check[i], 0);
		
		int N = sc.nextInt();
		for(int t = 0;  t < N; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			//전에 나왔던 값인지 확인
			if(check[y][x] == 1)
				continue;
			else
				check[y][x] = 1;
			
			//테두리 칠하기
			//상단
			if(99 - y - 10 >= 0) {
				for(int c = x; c < x + 10; c++) {
					if(paper[99 - y - 10][c] == 4)
						paper[99 - y - 10][c] = 3;				
				}
			}
			//하단
			if(99 - y + 1 < 100) {
				for(int c = x; c < x + 10; c++) {
					if(paper[99 - y + 1][c] == 4)
						paper[99 - y + 1][c] = 3;	
				}
			}
			//좌측
			if(x - 1 >= 0) {
				for(int r = 99 - y; r >= 100 - y - 10; r--) {					
					if(paper[r][x - 1] == 4)
						paper[r][x - 1] = 3;
				}
			}
			//우측
			if(x + 10 < 100) {
				for(int r = 99 - y; r >= 100 - y - 10; r--) {
					if(paper[r][x + 10] == 4)
						paper[r][x + 10] = 3;	
				}
			}
			
			//빈공간: 4, 테두리: 3, 꼭짓점: 2, 변: 1, 면: 0
			for(int r = 99 - y; r >= 100 - y - 10; r--) {
				for(int c = x; c < x + 10; c++) {
					if(paper[r][c] == 0) //이미 색종이가 붙어있는 곳이라면 볼필요 없음
						continue;
					//꼭짓점일때 왼쪽하단, 왼쪽상단, 오른쪽하단, 오른쪽상단
					if((r == 99 - y && c == x) || (r == 100 - y - 10 && c == x) ||
						(r == 99 - y && c == x + 9) || (r == 100 - y - 10 && c == x + 9)) {
						if(paper[r][c] == 4)//빈공간이면
							paper[r][c] = 2;
						else if(paper[r][c] == 3) {
							//인접한곳에 변이나 꼭짓점이 있다면 (- 1) 해주기
							//왼쪽하단
							if(r == 99 - y && c == x) {
								paper[r][c] = 2;
								//좌
								if(c >= 1 && (paper[r][c - 1] == 2 || paper[r][c - 1] == 1)) {
									paper[r][c]--;
									paper[r][c - 1]--;
								}
								//하
								if(r + 1 < 100 && (paper[r + 1][c] == 2 || paper[r + 1][c] == 1)) {
									paper[r][c]--;
									paper[r + 1][c]--;
								}
							}
							//왼쪽 상단
							else if(r == 100 - y - 10 && c == x) {
								paper[r][c] = 2;
								//상
								if(r - 1 >= 0 && (paper[r - 1][c] == 2 || paper[r - 1][c] == 1)) {
									paper[r][c]--;
									paper[r - 1][c]--;
								}
								//좌
								if(c >= 1 && (paper[r][c - 1] == 2 || paper[r][c - 1] == 1)) {
									paper[r][c]--;
									paper[r][c - 1]--;
								}
							}
							//오른쪽하단
							else if(r == 99 - y && c == x + 9) {
								//우
								if(c + 1 < 100 && (paper[r][c + 1] == 2 || paper[r][c + 1] == 1)) {
									paper[r][c]--;
									paper[r][c + 1]--;
								}
								//하
								if(r + 1 < 100 && (paper[r + 1][c] == 2 || paper[r + 1][c] == 1)) {
									paper[r][c]--;
									paper[r + 1][c]--;
								}
							}
							//오른쪽 상단
							else {
								//우
								if(c + 1 < 100 && (paper[r][c + 1] == 2 || paper[r][c + 1] == 1)) {
									paper[r][c]--;
									paper[r][c + 1]--;
								}
								//상
								if(r - 1 >= 0 && (paper[r - 1][c] == 2 || paper[r - 1][c] == 1)) {
									paper[r][c]--;
									paper[r - 1][c]--;
								}
							}
						}
						else
							paper[r][c] = 0;
					}
					//변일때 아랫변, 윗변, 왼변, 오른변
					else if(r == 99 - y || r == 100 - y - 10 || c == x || c == x + 9) {
						if(paper[r][c] == 4)
							paper[r][c] = 1;
						else if(paper[r][c] == 3) {
							paper[r][c] = 1;
							//아랫변
							if(r == 99 - y) {
								//하
								if(r + 1 < 100 && (paper[r + 1][c] == 2 || paper[r + 1][c] == 1)) {
									paper[r][c]--;
									paper[r + 1][c]--;
								}
							}
							//윗변
							else if(r == 100 - y - 10) {
								//상
								if(r - 1 >= 0 && (paper[r - 1][c] == 2 || paper[r - 1][c] == 1)) {
									paper[r][c]--;
									paper[r - 1][c]--;
								}
							}
							//왼변
							else if(c == x) {
								//좌
								if(c >= 1 && (paper[r][c - 1] == 2 || paper[r][c - 1] == 1)) {
									paper[r][c]--;
									paper[r][c - 1]--;
								}
							}
							//오른변
							else {
								//우
								if(c + 1 < 100 && (paper[r][c + 1] == 2 || paper[r][c + 1] == 1)) {
									paper[r][c]--;
									paper[r][c + 1]--;
								}
							}
						}
						else
							paper[r][c] = 0;
					}
					//면일때
					else
						paper[r][c] = 0;
				}
			}
			System.out.println();
			for(int i = 0;  i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					System.out.print(paper[i][j]);
				}
				System.out.println();
			}
			
		}
		//둘레 계산
		int total = 0;
		for(int i = 0;  i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(paper[i][j] == 1 || paper[i][j] == 2)
					total += paper[i][j];
			}
		}
		System.out.println(total);
		sc.close();
	}
}
