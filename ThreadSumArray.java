
public class ThreadSumArray extends Thread
{
    private SumArray arrayOfSum;//object of array of numbers.
    private Controller c;//object of the contoller

    public ThreadSumArray(SumArray r, Controller c)
    {
        arrayOfSum = r;
        this.c=c;
    }

    public void run()//the method that run the thraeds.
    {
        int[] tempArray;
    	        
        tempArray = arrayOfSum.removeFromSumArray();
    	
        while(tempArray != null)
        {
        	
        	arrayOfSum.addToSumArray(tempArray[0] + tempArray[1]);// put back the sum you got
        	
        	tempArray = arrayOfSum.removeFromSumArray();// give me two nums
        	
        }
    	c.finishedThreads();
    }
}
