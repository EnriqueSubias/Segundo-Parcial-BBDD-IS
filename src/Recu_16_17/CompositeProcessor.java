package Recu_16_17;

import java.util.ArrayList;
import java.util.List;

public class CompositeProcessor<E> extends SequenceProcessor<E> {

    private final List<SequenceProcessor<E>> components = new ArrayList<>();

    public void addComponent(SequenceProcessor<E> component) {
        components.add(component);
    }

    protected void processElement(E element) {
        for (var component : components) {
            component.processElement(element);
        }
    }
}
