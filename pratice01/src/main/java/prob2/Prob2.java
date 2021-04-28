package prob2;

public class Prob2 {
	public static void main(String[] args) {
		/* 코드 작성 */
		int num = 1;
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 9; j++)
				System.out.printf("%d ", num + i + j);
			System.out.println();
		}
	}
}
