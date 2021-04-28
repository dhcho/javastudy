package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		Goods goods = new Goods();
		goods.name = "camera";
		goods.price= 1000;
		goods.countStock = 50;
		
		// private은 같은 클래스 내에서만 접근이 가능하다.
		// goods.countSold = 20;
		
		System.out.println(goods.name);
		
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		
		System.out.println(Goods.countofGoods);
	}
}
