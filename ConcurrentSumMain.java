import java.util.ArrayList;
import java.util.Scanner;

public class MainQ1
{
    public static void main(String[] args)
    {
    	
        Scanner scan = new Scanner(System.in);
    	System.out.println("Pleas enter a number of numbers of the members in the array\n");
        int numOfNumbersToArray= scan.nextInt();    	
        System.out.println("Pleas enter a number of threads you would like to sum thae the members in the array\n");
        int numOfThreadsToArray= scan.nextInt(); 
        scan.close();
    	Controller control = new Controller(numOfThreadsToArray);
    	ArrayList<Integer> arrayOfNumbers = new ArrayList<Integer>(numOfNumbersToArray);
    	
    	//adding random numbers between 1 to 100 to the array:
    	int randomNumber;
    	int count=numOfNumbersToArray;
    	while(count>0)
    	{
    		randomNumber=((int)(Math.random()*99+1));
    		arrayOfNumbers.add(randomNumber);
    		count--;
    	}
       
        SumArray arrayOfSumNumbers = new SumArray(arrayOfNumbers,numOfThreadsToArray);//an array of SumArray
        ThreadSumArray[] threadsArray = new ThreadSumArray[numOfThreadsToArray];// an array of threads
       
        
       for(ThreadSumArray threadSum : threadsArray)
        {
        	
        	threadSum = new ThreadSumArray(arrayOfSumNumbers,control);
        	threadSum.start();
        }
    	
        control.waitingToThraeds();
        System.out.println("The final sum of the array is: " +arrayOfSumNumbers.arrayFinalSum());
    	
    }

}
