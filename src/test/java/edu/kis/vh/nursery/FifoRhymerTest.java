package edu.kis.vh.nursery;

import org.junit.Assert;
import org.junit.Test;

public class FifoRhymerTest {

    @Test
    public void testFifoRhymerCountOut() {
        FifoRhymer rhymer = new FifoRhymer();
        final int EMPTY_STACK_VALUE = -1;

        int result = rhymer.countOut();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        int testValue1 = 4;
        int testValue2 = 5;
        rhymer.countIn(testValue1);
        rhymer.countIn(testValue2);

        result = rhymer.countOut();
        Assert.assertEquals(testValue1, result);

        result = rhymer.countOut();
        Assert.assertEquals(testValue2, result);

        result = rhymer.countOut();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);
    }
}
