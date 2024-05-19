package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    public static final  int ARRAY_SIZE = 12;
    public static final int UNMODIFIED_TOTAL = -1;

    private final int[] numbers = new int[ARRAY_SIZE];

    public int total = UNMODIFIED_TOTAL;

    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    public boolean callCheck() {
        return total == UNMODIFIED_TOTAL;
    }

    public boolean isFull() {
        return total == ARRAY_SIZE-1;
    }

    protected int peekaboo() {
        if (callCheck())
            return -1;
        return numbers[total];
    }

    public int countOut() {
        if (callCheck())
            return -1;
        return numbers[total--];
    }

}
