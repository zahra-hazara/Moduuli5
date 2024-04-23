package synchronization;

public class TestSafeArrayList {
    public static void main(String[] args) {
        SafeArrayList<String> safeList = new SafeArrayList<>();

        // Create multiple threads to add, remove, and query the list
        Thread addThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                safeList.addElement("Element " + i);
            }
        });

        Thread removeThread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                safeList.removeElement("Element " + i);
            }
        });

        Thread sizeThread = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Size of list: " + safeList.getSize());
                try {
                    Thread.sleep(1000); // Sleep for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start the threads
        addThread.start();
        removeThread.start();
        sizeThread.start();

        // Wait for all threads to finish
        try {
            addThread.join();
            removeThread.join();
            sizeThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // After all operations, print the final size of the list
        System.out.println("Final size of list: " + safeList.getSize());
    }
}

