package prob5;

public class Prob5 {
	public static void main(String[] args) {
		for(int i = 1; i < 100; i++) {
			int x = i % 10;
			int y = i / 10;
			
			if((x == 3 || x == 6 || x == 9) && (y == 3 || y == 6 || y == 9)) {
				System.out.printf("%d ", i);
				System.out.println("짝짝");
			} else if((x == 3 || x == 6 || x == 9) || (y == 3 || y == 6 || y == 9)) {
				System.out.printf("%d " , i);
				System.out.println("짝");
			} 
		}
	}
}
