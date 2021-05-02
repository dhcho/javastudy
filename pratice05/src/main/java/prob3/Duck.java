package prob3;

public class Duck extends Bird {
	@Override
	public void fly() {
		System.out.println("오리(" + this.getName() + ")는 날지 않습니다.");
	}
	
	@Override
	public void sing() {
		System.out.println("오리(" + this.getName() + ")가 소리내어 웁니다.");
	}
	
	@Override
	public String toString() {
		return "오리의 이름은 " + this.name + " 입니다.";
	}
}
