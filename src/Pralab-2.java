
import java.awt.*;
import java.lang.module.ModuleDescriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


// Segundo parcial 2019/2020

public class Email {

    private final String from;
    private final List<String> to;
    private final String subject;
    private final String body;
    private final List<String> ccTo;

    private Email(
            String from, List<String> to, String subject, String body) {
        this(from, to, subject, body, new ArrayList<>()); }

    private Email(
            String from, List<String> to, String subject, String body, List<String> ccTo) {
        this.from = from; this.to = to; this.subject = subject;
        this.body = body; this.ccTo = ccTo; }


    public interface EmailBuilder {
        EmailBuilder from(String from);
        EmailBuilder to(String to);
        EmailBuilder subject(String subject);
        EmailBuilder body(String body);
        EmailBuilder ccTo(String ccTo);
        Email make();
    }

    public static EmailBuilder builder() {
        return new EmailBuilderImpl();
    }

    private static class EmailBuilderImpl implements EmailBuilder {

        private String from, subject, body;
        private List<String> tos = new ArrayList<>();
        private List<String> ccTos = new ArrayList<>();

        public EmailBuilder from(String from) {
            if (this.from != null) 
                throw new EmailBuilderException("too many froms");
            this.from = from;
            return this;
        }

        public EmailBuilder to(String to) {
            tos.add(to);
            return this;
        }

        public EmailBuilder subject(String subject) {
            if (this.subject != null) 
                throw new EmailBuilderException("too many subjects");
            this.subject = subject;
            return this;
        }

        public EmailBuilder body(String body) {
            if (this.body != null) 
                throw new EmailBuilderException("too many bodies");
            this.body = body;
            return this;
        }

        public EmailBuilder ccTo(String ccTo) {
            ccTos.add(ccTo);
            return this;
        }

        public Email make() {
            checkBuilder();
            if (ccTos.isEmpty()) 
                return new Email(from, tos, subject, body);
            else
                return new Email(from, tos, subject, body, ccTos);
        }

        private void checkBuilder() {
            if (from == null) {
                throw new EmailBuilderException("no from");
            } else if (tos.isEmpty()) {
                throw new EmailBuilderException("no to");          
            } else if (subject == null) {
                throw new EmailBuilderException("no subject");
            } else if (body == null) {
                throw new EmailBuilderException("no body");
            }
        }
    }
}

class EmailBuilderException extends RuntimeException {
    public EmailBuilderException(String message) {
    super(message);
}
}

class Main {
    public static void main(String[] args) {
        Email email = Email.builder()
                .from("juanmanuel.gimeno@udl.cat")
                .to("xyz@alumnes.udl.cat")
                .to("pqr@alumnes.udl.cat")
                .subject("Copias en los exámenes presenciales")
                .body(" </strong > Ya sabíais las consecuencias \"+" +
                        "de copiar ...</strong >")
                .ccTo("capest.inf@eps.udl.cat")
                .make();
    }
}

// Recuperacion 2012/2013

public class FigureBuilder {

    private Double atX; 

    public FigureBuilder at(double x, double y) {
        atX = x; // atX = new Double(x);
    }

    private hasAt() {
        return atX != null;
    }

    public static FigureBuilder builder() {
        return new FigureBuilderImpl();
    }
 
}

public class FigureBuilderImpl {

    private double atX; 
    private boolean hasAt = false;

    public FigureBuilder at(double x, double y) {
        atX = x; // atX = new Double(x);
        hasAt = true;

    }
 
    public Figure do() {
        // Si està tot comprovat
        if (hasRadius) {
            return new Circle(....);
        }
    }
}


abstract class Figure extends Observable {
    public double getArea() {
        return 0;
    }
}

class Drawing extends Figure implements Observer {

    double x, y;

    public ArrayList<Figure> figures = new ArrayList<>();

    public Drawing(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Implementa el mètode update() de la interfície Observer
    @Override
    public void update(Observable o, Object arg) {

        // TODO Auto-generated method stub
    }

    public void addFigure(Figure figura){
        figures.add(figura);
        figura.addObserver(this);
    }


}

public class Circle extends Figure {
    private final double radius;
    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }







// Recuperación 2019/2020

public enum Resolution {
    LOW, HIGH;
}
public interface ResolutionFactory {
    Viewer createViewer();
    Printer createPrinter();

}

public class LowResolution implements ResolutionFactory {
    public Viewer createViewer() {
        return LowResViewer();
    }

    public Printer createPrinter() {
        return LowResPrinter();
    }
}

public class HighResolution implements ResolutionFactory {
    public Viewer createViewer() {
        return HighResViewer();
    }

    public Printer createPrinter() {
        return HighResPrinter();
    }
}

public class Controller {

    private ResolutionFactory resolution;

    public Controller(ResolutionFactory resolution) {
        this.resolution = resolution;
    }

    public void view(Image image) {
        var viewer = resolution.createViewer();
        viewer.view(image);
    }

    public void printer(Image image) {
        var printer = resolution.createPrinter();
        printer.print(image);
    }
}

// Abans

var controller = new Controller(Resolution.LOW);

// Ara

var controller = new Controller(new LowResolution());

// Ome more thing ...

public enum Resolution implements ResolutionFactory {
    LOW {
        public Viewer createViewer() {
            return LowResViewer();
        }

        public Printer createPrinter() {
            return LowResPrinter();
        }
    },
    HIGH {
        public Viewer createViewer() {
            return HighResViewer();
        }

        public Printer createPrinter() {
            return HighResPrinter();
        }
    }
}

var controller = new Controller(Resolution.LOW);