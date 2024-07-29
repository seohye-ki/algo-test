package boj2567;

import java.util.Arrays;
import java.util.Scanner;

public class Cccccc {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//4: 빈공간 3: 테두리, 2: 꼭짓점, 1: 변, 0: 면 
		int[][] paper = new int[100][100];
		for(int i = 0; i < 100; i++)
			Arrays.fill(paper[i], 4);
		
		int N = sc.nextInt();
		for(int t = 0; t < N; t++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for(int r = y; r < y + 10; r++) {
				for(int c = x; c < x + 10; c++) {
					if(paper[r][c] == 0)
						continue;
					if(c == x) {
						//꼭짓점
						if(r == y) {
							paper[r][c] = 2;
						}
						//꼭짓점 
						else if(r == (y + 9)) {
							paper[r][c] = 2;
						}
						//변
						else {
							paper[r][c] = 1;
						}
					}
					else if(c == (x + 9)) {
						//꼭짓점
						if(r == y) {
							paper[r][c] = 2;
						}
						//꼭짓점
						else if(r == (y + 9)) {
							paper[r][c] = 2;
						}
						//변
						else {
							paper[r][c] = 1;
						}
					}
					else {
						//변
						if(r == y) {
							paper[r][c] = 1;
						}
						//변 
						else if(r == (y + 9)) {
							paper[r][c] = 1;
						}
						//면
						else {
							paper[r][c] = 0;
						}
					}
					//테두리 
					
				}
			}
			for(int i = 0;  i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					System.out.print(paper[i][j]);
				}
				System.out.println();
			}
		}
		sc.close();		
	}
}
