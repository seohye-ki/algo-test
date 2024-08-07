package draw_star;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DrawStar {
	    public static void main(String[] args) {
	    	Scanner sc = new Scanner(System.in);
	    	int[][] line = new int[5][3];
	      	for(int i = 0; i < 5; i++) {
	    		for(int j = 0; j < 3; j++) {
	    			line[i][j] = sc.nextInt();
	    		}
	    	}
	    	
	        ArrayList<int[]> star = new ArrayList<>();
	        //모든 조합 확인해보기
	        for(int i = 0;  i < line.length; i++){
	            for(int j = i + 1; j < line.length; j++){
	                int[] f1 = line[i];
	                int[] f2 = line[j];
	                // System.out.println(f1[0] + " " + f1[1] + " " + f1[2]);
	                // System.out.println(f2[0] + " " + f2[1] + " " + f2[2]);
	                //교점 구하기
	                if(((f1[0] * f2[1]) - (f1[1] * f2[0])) == 0) // AD - BC = 0 평행이거나 일치하는 경우
	                    continue;
	                double x = (double)((f1[1] * f2[2]) - (f1[2] * f2[1])) / (double)((f1[0] * f2[1]) - (f1[1] * f2[0])); // BF - ED / AD - BC
	                double y = (double)((f1[2] * f2[0]) - (f1[0] * f2[2])) / (double)((f1[0] * f2[1]) - (f1[1] * f2[0])); // EC - AF / AD - BC
	                System.out.println("double x : " + x + " double y : " + y);
	                System.out.println("int x : " + (x % 1) + " int y : " + (y % 1));
	                if(x - (int)x == 0.0 && y - (int)y == 0.0) //가능한 좌표
	                   star.add(new int[] {(int)x,(int)y});
	            }
	        }
	        
	        for(int i = 0; i < star.size(); i++)
	        	System.out.println("x : " + star.get(i)[0] + " y : " + star.get(i)[1]);
	        
	        //열 최대/최소, 행 최대/최소 구하기
	        int rowMin = star.get(0)[0];
	        int rowMax = star.get(0)[0];
	        int colMin = star.get(0)[1];
	        int colMax = star.get(0)[1];
	        for(int i = 0; i < star.size(); i++) {
	        	if(star.get(i)[0] < rowMin)
	        		rowMin = star.get(i)[0];
	        	if(rowMax < star.get(i)[0])
	        		rowMax = star.get(i)[0];
	        	if(star.get(i)[1] < colMin)
	        		colMin = star.get(i)[1];
	        	if(colMax < star.get(i)[1])
	        		colMax = star.get(i)[1];
	        	System.out.println("rowMin : " + rowMin + " rowMax : " + rowMax + " colMin : " + colMin + " colMax : " + colMax);
	        }
	        
	        //map 열과 행 구하기
	        int row = rowMax - rowMin + 1;
	        int col = colMax - colMin + 1;
	        System.out.println("row : " + row + " col : " + col);
	        
	        //map 만들기
	        String[] answer;
	        if(row == 1 && col == 1) {
	        	String[] map = {"*"};
	        	//answer에 넣기
	        	answer = map;
	        }
	        else {
	        	String[][] map = new String[row][col];
	        	for(int i = 0; i < row; i++)
	        		Arrays.fill(map[i], ".");
	        	//별찍기
	        	for(int i = 0; i < star.size(); i++) {
	        		int x = rowMin - star.get(i)[0];
	        		int y = colMin - star.get(i)[1];
	        		map[x][y] = "*";
	        	}

	        	//answer에 넣기
	        	answer = new String[row];
	        	for(int i = 0; i < row; i++) {
	        		for(int j = 0; j < col; j++) {
	        			answer[i] += map[i][j];
	        		}
	        	}
	        }
	        
	        //별찍기
	        System.out.println(Arrays.toString(answer));
	        sc.close();
	    }
}
