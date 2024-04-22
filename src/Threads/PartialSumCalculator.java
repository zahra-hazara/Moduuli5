package Threads;

class PartialSumCalculator implements Runnable {
    private final int[] numbers;
    private final int startIndex;
    private final int endIndex;
    private long partialSum;

    public PartialSumCalculator(int[] numbers, int startIndex, int endIndex) {
        this.numbers = numbers;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.partialSum = 0;
    }

    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            partialSum += numbers[i];
        }
    }

    public long getPartialSum() {
        return partialSum;
    }
}
