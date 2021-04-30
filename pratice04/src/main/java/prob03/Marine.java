package prob03;

public class Marine extends Unit{
	@Override
	void move(int x, int y) {
		/* 지정된 위치로 이동 */
		this.x = x;
		this.y = y;
	}

	@Override
	void stop() {
		/* 현재 위치에 정지 */
	}
	
	void stimPack() { 
		/* 스팀팩을 사용한다.*/
	}	
}
