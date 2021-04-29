package prob06;

public class Div extends Arithmetic {
	public void setValue(int a, int b) {
		this.lValue = a;
		this.rValue = b;
	}
	
	@Override
	public int calculate() {
		return this.lValue / this.rValue;
	}
}
