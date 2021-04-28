package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );
		int i = 1;
		int low = 1;
		int high = 100;
		int correctNumber = 0;

		while( true ) {
			/* 게임 작성 */
			if(i == 1) {
				// 정답 랜덤하게 만들기
				Random random = new Random();
				correctNumber = random.nextInt( 100 ) + 1;
				System.out.println("수를 결정하였습니다. 맞추어 보세요");
				System.out.println(correctNumber);
				System.out.printf("%d-%d\n", low, high);
			}
			
			System.out.print(i++ + ">>");	
			int num = scanner.nextInt();
		
			if(correctNumber < num) {
				System.out.println("더 낮게");
				high = num;
				System.out.printf("%d-%d\n", low, high);
			} else if(correctNumber > num) {
				System.out.println("더 높게");
				low = num;
				System.out.printf("%d-%d\n", low, high);
			} else {
				System.out.println("맞았습니다.");
				//새 게임 여부 확인하기
				System.out.print( "다시 하겠습니까(y/n)>>" );
				String answer = scanner.next();
				if( "y".equals( answer ) == false ) {
					break;
				} else {
					i = 1;
					low = 1;
					high = 100;
				}
			}
		}
		scanner.close();
	}

}