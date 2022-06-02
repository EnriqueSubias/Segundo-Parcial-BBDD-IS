package Recu_16_17;

public class Counter extends SequenceProcessor<String> {

    private int counter = 0;

    protected void processElement(String element) {
        counter += 1;
    }

    public int getCounter() {
        return this.counter;
    }
}
