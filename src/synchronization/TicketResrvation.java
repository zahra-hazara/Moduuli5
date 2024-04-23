package synchronization;
import java.util.concurrent.Semaphore;

class Theater {
    private int totalSeats;
    private Semaphore semaphore;

    public Theater(int totalSeats) {
        this.totalSeats = totalSeats;
        this.semaphore = new Semaphore(totalSeats, true); // true for fair semaphore
    }

    public void reserveSeats(int requestedSeats, int customerId) {
        try {
            semaphore.acquire(requestedSeats);
            System.out.println("Customer " + customerId + " reserved " + requestedSeats + " tickets.");
        } catch (InterruptedException e) {
            // Handle interruption
            e.printStackTrace();
        }
    }

    public void tryReserveSeats(int requestedSeats, int customerId) {
        boolean success = semaphore.tryAcquire(requestedSeats);
        if (success) {
            System.out.println("Customer " + customerId + " reserved " + requestedSeats + " tickets.");
        } else {
            System.out.println("Customer " + customerId + " couldn't reserve " + requestedSeats + " tickets.");
        }
    }

    public void releaseSeats(int requestedSeats) {
        semaphore.release(requestedSeats);
    }
}

class CustomerThread extends Thread {
    private static int customerIdCounter = 1;
    private Theater theater;

    public CustomerThread(Theater theater) {
        this.theater = theater;
    }

    @Override
    public void run() {
        int customerId = customerIdCounter++;
        int requestedSeats = (int) (Math.random() * 5) + 1; // Randomly choose 1 to 5 seats
        theater.tryReserveSeats(requestedSeats, customerId);
    }
}


