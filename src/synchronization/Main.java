package synchronization;

public class Main {
    public static void main(String[] args) {
        final int TOTAL_SEATS = 10;
        Theater theater = new Theater(TOTAL_SEATS);
        final int NUM_CUSTOMERS = 15;

        CustomerThread[] customers = new CustomerThread[NUM_CUSTOMERS];
        for (int i = 0; i < NUM_CUSTOMERS; i++) {
            customers[i] = new CustomerThread(theater);
            customers[i].start();
        }

        for (int i = 0; i < NUM_CUSTOMERS; i++) {
            try {
                customers[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}