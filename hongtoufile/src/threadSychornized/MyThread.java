package threadSychornized;

public class MyThread implements Runnable {
	
	private int i =1000000;

	@Override
	public void run() {
		
		descentI();

	}
	
	synchronized public void descentI() {
		
		while (true) {
			
		if (i>0) 
		  {
			i--;
			System.out.println("当前数值"+Thread.currentThread().getName()+"  "+i);
		  }
		else {
			break;
		}
			
		}

	}
	
}
