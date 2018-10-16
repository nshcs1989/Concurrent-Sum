# Concurrent-Sum

The project was created to practice concurrency programming by building a system to sum in concurrency an array of integers.

ConcurrentSumMain - the class which contains the main method:
The user needs to type the number of array elements(n) and the number of threads(m) of summing. The array elements will be random numbers between 1 to 100. Then, in concurrency, the system will generate m threads of summing. Each thread will remove to elements from the array, sum them and then will return to the original array one element which consists the sum of the two elements.

Eventually, the sum of the elements will be printed two the console.

