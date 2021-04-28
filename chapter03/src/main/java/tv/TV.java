package tv;

public class TV {
	private int channel;
	private int volume;
	private boolean power;	

	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	
	public TV() {
	}
	
	
	public int getChannel() {
		return channel;
	}

	public int getVolume() {
		return volume;
	}

	public boolean isPower() {
		return power;
	}

	void power(boolean on) {
		if(on) {
			this.power = on;
		}
		
		if(!on) {
			this.power = on;
		}
	}
	
	void channel(int channel) {
		if((channel >= 1) && (channel <= 255)) {
			this.channel = channel;
		}
	}

	void channel(boolean up) {
		int chk = 0;
		
		if(up == true) {
			chk = this.channel + 1;
		}
		
		if(up == false) {
			chk = this.channel - 1;
		}
		
		if(!((chk < 1) && (chk > 255))) {
			if(up) {
				this.channel += 1;
			}
			if(up) {
				this.channel -= 1;
			}
		}
	}
	
	void volume(int volume) {
		if((volume >= 0) && (volume <= 100)) {
			this.volume = volume;
		}
	}
	
	void volume(boolean up) {
		int chk = 0;
		
		if(up) {
			chk = this.volume + 1;
		}
		
		if(up) {
			chk = this.volume - 1;
		}
		
		if(!((chk < 0) || (chk > 100))) {
			if(up == true) {
				this.volume += 1;
			}
			if(up == false) {
				this.volume -= 1;
			}
		}
	}
	
	void status() {
		System.out.println("채널: " + getChannel() 
							+ " 볼륨: " + getVolume()
							+ " 전원: " + isPower());
	}
}
