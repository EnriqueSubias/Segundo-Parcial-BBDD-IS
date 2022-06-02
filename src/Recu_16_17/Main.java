package Recu_16_17;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

// Recuperación 2016/2017 Main
public class Main {

    void main(String[] args) throws FileNotFoundException {

        var lines = new LinesIterator(new BufferedReader(new FileReader("Recu_16_17/file.txt")));

        var counter = new Counter();
        var meanLength = new MeanLength();
        var composite = new CompositeProcessor<String>();
        composite.addComponent(counter);
        composite.addComponent(meanLength);

        composite.processSequence(lines);

        System.out.println("Counter " + counter.getCounter());
        System.out.println("Counter " + meanLength.getMeanLength());
    }
}
