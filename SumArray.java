import java.util.ArrayList;

public class SumArray
{
    
		
	private ArrayList<Integer> numSumArray;//array of numbers
    private int maxNumThreads;// the number of maximum threads
    private int waitToDo;
    private boolean done;
    private boolean flage;

    public SumArray(ArrayList<Integer> arrayOfNumbers, int numbersOfThreads)
    {
        numSumArray = arrayOfNumbers;
        maxNumThreads = numbersOfThreads;
        waitToDo = 0;
        done = false;
        flage=true;
    }

   
    
    //remove two numbers from the array in order to sum their value.
    public synchronized int[] removeFromSumArray()
    {
    	
        while((numSumArray.size() <= 1)&&(flage==true))
        {
        	
            if(done || waitToDo == maxNumThreads - 1)
            {
            	
                done = true;
                notifyAll();
                flage=false;
            }
            else
            {
                waitToDo++;
                try
                {
                	
                    wait();
                }
                catch (InterruptedException e)
                {
                	System.out.println("The thraed was Interrupted while waiting\n");
                }
                waitToDo--;
            	
            }
        }
        
        if(done)
            return null;
        int[] tempArray = new int[2];
        tempArray[0] = numSumArray.remove(0);
        tempArray[1] = numSumArray.remove(0);
        return tempArray;
    }

    //add numbers to the array after summing them
    public synchronized void addToSumArray(int number)
    {
        numSumArray.add(number);
    	
        notifyAll();
    }

    
    //returning the final sum of the array
    public int arrayFinalSum()
    {
        return numSumArray.get(0);
    }
}

