package Threads;


public class ParallelSummation {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int numThreads = 4; // Number of threads to use

        // Calculate the size of each portion
        int portionSize = numbers.length / numThreads;

        // Create an array to store the partial sums
        long[] partialSums = new long[numThreads];

        // Create and start threads
        Thread[] threads = new Thread[numThreads];
        PartialSumCalculator[] calculators = new PartialSumCalculator[numThreads];
        for (int i = 0; i < numThreads; i++) {
            int startIndex = i * portionSize;
            int endIndex = (i == numThreads - 1) ? numbers.length - 1 : (i + 1) * portionSize - 1;
            calculators[i] = new PartialSumCalculator(numbers, startIndex, endIndex);
            threads[i] = new Thread(calculators[i]);
            threads[i].start();
        }

        // Wait for all threads to finish
        try {
            for (int i = 0; i < numThreads; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Calculate the total sum by combining the partial sums
        long totalSum = 0;
        for (int i = 0; i < numThreads; i++) {
            totalSum += calculators[i].getPartialSum();
        }

        // Print the total sum
        System.out.println("Total sum: " + totalSum);
    }
}