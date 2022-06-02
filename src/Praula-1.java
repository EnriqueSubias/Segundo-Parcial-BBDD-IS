// Recuperació 16/17
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinesIterator implements Iterator<String> {

    private BufferedReader reader;
    private String peek;

    public LinesIterator(BufferedReader reader) {
        this.reader = reader;
    }

    public boolean hasNext() {
        if (peek != null) {
            return true;
        } else {
            try {
                peek = reader.read();
                return peek != null;
            } catch (IOException ex) {
                return false;
            }
        }
    }

    public String next() {
        if (peek != null) {
            String next = peek;
            peek = null;
            return next;
        } else {
            try {
                String next = reader.read();
                if (next == null) {
                    throw new NoSuchElementException("no more lines");
                } else {
                    return next;
                }
            } catch (IOException ex) {
                throw new NoSuchElementException("no more lines");
            }

        }
    }
}

public abstract class Recu_16_17.SequenceProcessor<E> {
    public void processSequence(Iterator<E> iterator) {
        while (iterator.hasNext()) {
            E element = iterator.next();
            processElement(element);
        }
    }
    protected abstract void processElement(E element);
}

public class Counter extends Recu_16_17.SequenceProcessor<String> {

    private int counter = 0;

    protected void ProcessElement(String element) {
        counter += 1;
    }

    public int getCounter() {
        return counter;
    }
}

public class MeanLength extends Recu_16_17.SequenceProcessor<String> {

    private int counter = 0;
    private int sumLengths = 0;

    protected void processElement(String element) {
        counter += 1;
        sumLengths += element.length();
    }

    public double getMeanLength() {
        return (double) sumLengths / counter;
    }
}

public class CompositeProcessor<E> extends Recu_16_17.SequenceProcessor<E> {

    private List<Recu_16_17.SequenceProcessor<E>> components = new ArrayList<>();

    protected void processElement(E element) {
        for(var component : components) {
            component.processElement(element);
        }
    }

    public void addComponent(Recu_16_17.SequenceProcessor<E> component) {
        components.add( component);
    }
}

public class Main {

    public static void main(String[] args) {
        var multi = new CompositeProcessor<String>();
        var counter = new Counter();
        var mean = new MeanLength();
        multi.addComponent(counter);
        multi.addComponent(mean);
        var lines = new LinesIterator(new BufferedReader(.....));
        multi.processSequence(lines);
        System.out.println("counter" + counter.getCounter());
        System.out.println("mean" + mean.getMeanLength());
    }
}

// Segon parcial 2019/2020

public final class Email {
    // ....
    public static EmailBuilder builder() {
        return new EmailBuilder();
    }
}

public class EmailBuilder {

    private String from, subject, body; 
    private List<String> tos = new ArrayList<>();
    private List<String> ccTos = new ArrayList<>();

    public EmailBuilder from(String from) {
        if (this.from != null)
            throw new EmailBuilderException("from called twice");
        this.from = from;
        return this;
    }

    public EmailBuilder to(String to) {
        tos.add(to);
        return this;
    }

    public EmailBuilder subject(String subject) {
        if (this.subject != null)
            throw new EmailBuilderException("subject called twice");
        this.subject = subject;
        return this;
    }

    public EmailBuilder body(String body) {
        if (this.body != null)
            throw new EmailBuilderException("body called twice");
        this.body = body;
        return this;
    }

    public EmailBuilder ccTo(String ccTo) {
        ccTos.add(ccTo);
        return this;
    }

    public Email make() {
        checkConditions();
        if (ccTos.isEmpty()) {
            return new Email(from, tos, subject, body);
        } else {
            return new Email(from, tos, subject, body, ccTos);
        }
    }

    private void checkConditions() {
        if (from == null) {
            throw new EmailBuilderException("no from");
        } else if (subject == null) {
            throw new EmailBuilderException("no subject");
        } else if (body == null) {
            throw new EmailBuilderException("no body");
        } else if (tos.isEmpty()) {
            throw new EmailBuilderException("no to");
        }
    }
}

// FigureBuilder

public class FigureBuilder {

    Double atX, atY;

    public FigureBuilder at(double x, double y) {
        atX = x; // atX = new Double(x);
        atY = y;
    }

    public Figure do() {
        if (atX == null) {
            return null; // guarradilla (usar excepcions !!!!!)
        }
    }
}

public class FigureBuilder {

    double atX, atY;
    boolean hasAt = false;

    public FigureBuilder at(double x, double y) {
        atX = x; // atX = new Double(x);
        atY = y;
        hasAt = true;
    }

    public Figure do() {
        if (!hasAt) {
            return null; // guarradilla (usar excepcions !!!!!)
        }
        if (hasRadius) {
            return new Circle( .... );
        }
        if (hasDims) {
            return new Rectangle( .... );
        }
    }
}

// Recuperació 2019/2020

public interface ResolutionFactory {
    Viewer createViewer();
    Printer createPrinter();
}

public class LowResolution implements ResolutionFactory {
    public Viewer createViewer() {
        return new LowResViewer();
    }
    public Printer createPrinter() {
        return new LowResPrinter();
    }
}

public class Controller {
    ResolutionFactory resolution;

    public Controller(ResolutionFactory resolution) {
        this.resolution = resolution;
    }

    public void view(Image image) {
        var viewer = resolution.createViewer();
        viewer.view(image);
    }

    public void print(Image image) {
        var printer = resolution.createPrinter();
        printer.print(image);
    }
}

var controller = new Controller(new LowResolution());

// He comprovat que es pot
public enum Resolution implements ResolutionFactory {
    LOW {
        public Viewer createViewer() {
            return new LowResViewer();
        }

        public Printer createPrinter() {
            return new LowResPrinter();
        }
    },
    HIGH {
        public Viewer createViewer() {
            return new HiResViewer();
        }

        public Printer createPrinter() {
            return new HiResPrinter();
        }
    }
}

var controller = new Controller(Resolution.LOW);

*/