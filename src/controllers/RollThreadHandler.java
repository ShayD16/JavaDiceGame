package controllers;

public class RollThreadHandler extends Thread{
	  private Die[] compDieArr;
	  private Thread thread;
	  private Dice dice;
	  
	  public RollThreadHandler(Dice dice) {
		this.dice = dice;
	}

	public Die[] getCompDieArr() {
		return compDieArr;
	}

	public void setCompDieArr(Die[] compDieArr) {
		this.compDieArr = compDieArr;
	}

	public void start(){
		  if(thread==null){
			  thread=new Thread(this);
			  thread.start();
			  System.out.println("Starting new Thread: " +thread.getName());
		  }
	  }

	    public void run() {
	        compDieArr=dice.roll();
	    }
}
