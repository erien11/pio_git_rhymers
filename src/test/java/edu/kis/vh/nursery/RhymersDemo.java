package edu.kis.vh.nursery;

import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.RhymersFactory;

class RhymersDemo {

    public static final int ARRAY_SIZE = 15;
    public static final int RHYMERS_LAST_INDEX = 3;
    public static final int MAX_RANGE = 20;

    public static void main(String[] args) {
        RhymersFactory factory = new DefaultRhymersFactory();
        
        DefaultCountingOutRhymer[] rhymers = { factory.getStandardRhymer(), factory.getFalseRhymer(),
                factory.getFifoRhymer(), factory.getHanoiRhymer()};
        
        for (int i = 1; i < ARRAY_SIZE; i++)
            for (int j = 0; j < RHYMERS_LAST_INDEX; j++)
                rhymers[j].countIn(i);
        
        java.util.Random rn = new java.util.Random();
        for (int i = 1; i < ARRAY_SIZE; i++)
            rhymers[RHYMERS_LAST_INDEX].countIn(rn.nextInt(MAX_RANGE));
        
        for (int i = 0; i < rhymers.length; i++) {
            while (!rhymers[i].callCheck())
                System.out.print(rhymers[i].countOut() + "  ");
            System.out.println();
        }
        
        System.out.println("total rejected is "
                + ((HanoiRhymer) rhymers[RHYMERS_LAST_INDEX]).reportRejected());
        
    }
    
}