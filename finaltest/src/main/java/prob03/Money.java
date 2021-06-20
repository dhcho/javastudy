package prob03;

public class Money {

	private int amount;
    
    public Money(int a) {
    	this.amount = a;
    }

	public Object add(Money a) {
		return new Money(this.amount + a.amount);
	}

	public Object minus(Money a) {
		return new Money(this.amount - a.amount);
	}

	public Object multiply(Money a) {
		return new Money(this.amount * a.amount);
	}

	public Object devide(Money a) {
		return new Money(this.amount / a.amount);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Money) {
			if(((Money) obj).amount == this.amount) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
}