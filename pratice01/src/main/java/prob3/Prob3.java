package prob3;

import java.util.Scanner;

public class Prob3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		/* 코드 작성 */
		while (true) {
			System.out.print("숫자를 입력하세요(0을 입력하면 종료): ");
			int num = scanner.nextInt();
			
			if(num == 0) {
				scanner.close();
				break;
			}
			
			int i = 0;
			int result = 0;

			if ((num % 2) == 0) {
				while (i <= num) {
					if ((i % 2) == 0) {
						result += i;
					}
					i++;
				}
			} else {
				while (i <= num) {
					if ((i % 2) != 0) {
						result += i;
					}
					i++;
				}
			}

			System.out.printf("결과 값 : %d\n", result);
			
			i = 0;
			result = 0;
		}
	}
}
