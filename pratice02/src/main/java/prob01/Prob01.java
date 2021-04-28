package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		/* 코드 작성 */
		System.out.print("금액: ");
		int money = scanner.nextInt();
		
		System.out.println();
		
		for(int i = 0; i < MONEYS.length; i++) {
			int j = 0;
			int k = 0;
			if((money / MONEYS[i]) > 0) {
				k = money / MONEYS[i];
				for(j = 0; j < k; j++) {
					money -= MONEYS[i];
				}
			}
			System.out.println(MONEYS[i] + "원 : " + j + "개");
		}
		scanner.close();
 	}
}