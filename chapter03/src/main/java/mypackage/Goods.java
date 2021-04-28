package mypackage;

public class Goods {
	static int countofGoods;
	
	public Goods() {
		Goods.countofGoods++;
	}
	
	public String name;		// 모든 접근 가능(접근제한 없음)
	protected int price;	// 같은 패키지 + *자식 접근 가능
	int countStock;			// 디폴트, 같은 패키지
	private int countSold;	// 클래스 내부에서만 접근이 가능
	
	void m() {
		countSold = 100;
	}
}
