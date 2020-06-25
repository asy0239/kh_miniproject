package frameChange.cardGame.view;

public class Buffer{
	private int data;
	private boolean empty = true;
	private int i = 1;
	
	//유저
	public synchronized void myTurn() {
		
		while(empty) {
			try {
				wait();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		empty = true;
		System.out.println("유저: " + data + " 턴");
		
		
		notify();
		
	}
	

	
	//컴퓨터
	public synchronized void comTurn(int data) {
		while(!empty) {
			try {
				wait();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		this.data = data;
		empty = false;
		System.out.println("컴퓨터: " + data + " 턴");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		notify();

	}
}

