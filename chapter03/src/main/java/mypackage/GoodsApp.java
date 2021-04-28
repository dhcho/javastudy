package mypackage;

public class GoodsApp {

	public static void main(String[] args) {
		Goods goods1 = new Goods();
		
		// public은 접근 제한이 없다.
		goods1.name = "camera";
		
		
		// protected는 같은 패키지에서만 접근이 가능하다.
		// (더 중요한 것은 자식에게만 접근이 가능하다.)
		// goods.price = 1000;
		
		goods1.countStock = 50;
		
		// private은 같은 클래스 내에서만 접근이 가능하다.
		// goods.countSold = 20;
		
		System.out.println(goods1.name);
		
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		
		System.out.println(Goods.countofGoods);
	}
}
