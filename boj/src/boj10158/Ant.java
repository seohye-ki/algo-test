package boj10158;

import java.util.Scanner;

public class Ant {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int width = sc.nextInt();
		int height = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int time = sc.nextInt();
		
		int tmpX = time % (width * 2);
		int tmpY = time % (height * 2);
		
		System.out.println("tmpX " + tmpX);
		System.out.println("tmpY " + tmpY);
		
		if(x + tmpX > width) {
			x = tmpX - (width - x);
			if(x >= width)
				x = width - x;			
		}
		else
			x += tmpX;
		if(y + tmpY > height) {
			y = tmpY - (height - y);
			if(y >= height)
				y = height - y;			
		}
		else
			y += tmpY;

		System.out.println(x + " " + y);
		sc.close();
	}
}
