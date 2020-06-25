package miniProjectGame.cardGame.view;

public class Producer extends Thread{
	
	private Buffer criticalData;
	public static boolean comTurn = false;
	public static boolean turnExit = false;
	
	public Producer(Buffer buffer, boolean comTurn, boolean turnExit) {
		this.criticalData = buffer;
		this.comTurn = comTurn;
		this.turnExit = turnExit;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 4; i++) {
			criticalData.comTurn(i);
			
			try {
				
				if(comTurn == true) {
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
