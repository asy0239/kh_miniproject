package miniProjectGame.cardGame.view;

public class Consumer  extends Thread{
	private Buffer criticalData;
	
	public static boolean myTurn = false;
	public static boolean turnExit = false;
	
	public Consumer(Buffer buffer, boolean myTurn, boolean turnExit) {
		this.criticalData = buffer;
		this.myTurn = myTurn;
		this.turnExit = turnExit;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 4; i++) {
			criticalData.myTurn();
			
			try {
				
				if(myTurn == true) {
					Thread.sleep(0);
				} else {
					Thread.sleep(15000);
				}
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
}
