package Threads;

public class Main {
    public static void main(String[] args) {
        int start = 1;
        int end = 20;

        Thread oddThread = new Thread(new NumberPrinter(start, end, false), "Odd Thread");
        Thread evenThread = new Thread(new NumberPrinter(start, end, true), "Even Thread");

        oddThread.start();
        evenThread.start();

        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Printing complete.");
    }
}
