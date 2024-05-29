package edu.kis.vh.nursery;

/**
 * Klasa FifoRhymer, implementuje logikę kolejki FIFO
 * dla operacji na stosie. Rozszerza DefaultCountingOutRhymer.
 */
public class FifoRhymer extends DefaultCountingOutRhymer {

    /**
     * Tymczasowy stos używany do realizacji logiki FIFO.
     */
    private final DefaultCountingOutRhymer temp = new DefaultCountingOutRhymer();

    /**
     * Nadpisuje metodę countOut z klasy bazowej.
     * Przenosi wszystkie elementy do tymczasowego stosu,
     * zwraca wartość ze szczytu tymczasowego stosu,
     * a następnie przenosi elementy z powrotem na oryginalny stos.
     *
     * @return wartość ze szczytu stosu, lub -1 jeśli stos jest pusty.
     */
    @Override
    public int countOut() {
        while (!callCheck())
            temp.countIn(super.countOut());

        final int ret = temp.countOut();

        while (!temp.callCheck())
            countIn(temp.countOut());

        return ret;
    }
}