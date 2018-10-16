public class Controller 
{
	
	private int numberOfThreads;
	private int countOfThreads=0;;
	
	public Controller(int num)
	{
		this.numberOfThreads=num;
	}
	
	
	//the thread finished
	public synchronized void finishedThreads()
	{
		countOfThreads++;
    	
		if (countOfThreads>=numberOfThreads)
			notifyAll();
	}
	
	//when entering thread to wait until all threads finished.
	public synchronized void waitingToThraeds()
	{
		while (countOfThreads<numberOfThreads)
		
		try 
		{
			wait();
		}
		catch(InterruptedException e)
		{
			System.out.println("Interrupted while waiting");
		}
	    	
		
    	
	}
}
