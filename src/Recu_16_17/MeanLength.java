package Recu_16_17;

public class MeanLength extends SequenceProcessor<String> {

    private int counter = 0;
    private int sumLength = 0;

    protected void processElement(String element) {
        counter += 1;
        sumLength += element.length();
    }

    public double getMeanLength() {
        return (double) sumLength / this.counter;
    }
}
