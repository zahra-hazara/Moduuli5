package Threads;

class NumberPrinter implements Runnable {
    private final int start;
    private final int end;
    private final boolean isEven;

    public NumberPrinter(int start, int end, boolean isEven) {
        this.start = start;
        this.end = end;
        this.isEven = isEven;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if ((i % 2 == 0 && isEven) || (i % 2 != 0 && !isEven)) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

