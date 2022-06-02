/*
public class CompositeVisitor implements TreeVisitor {

    private List<TreeVisitor> visitors = new ArrayList<>();

    public void addVisitor(TreeVisitor t){
        visitors.add(t);
    }

    @Override
    public void visit(LeftNode l){
        for (var visitor : visitors){
            visitor.visit(l)
        }
    }

    @Override
    public void visit(CompositeNode c){
        for (var visitor : visitors){
            visitor.visit(c)
        }
    }
}


public class ConcretVisitor1 implements TreeVisitor {
    @Override
    public void visit(LeftNode l){
        l.accept(this)
    }
    @Override
    public void visit(CompositeNode c){
        c.accept(this)
    }
}

public class ConcretVisitor2 implements TreeVisitor {
    @Override
    public void visit(LeftNode l){
        l.accept(this)
    }
    @Override
    public void visit(CompositeNode c){
        c.accept(this)
    }
}




    ConcretVisitor1 concretVisitor1 = new ConcretVisitor1();
    ConcretVisitor2 concretVisitor2 = new ConcretVisitor2();
    CompositeVisitor compositeVisitor = new CompositeVisitor();
compositeVisitor.addVisitor(concretVisitor1)
        compositeVisitor.addVisitor(concretVisitor2)

        LeafNode lf = new LeafNode();
        lf.accept(compositeVisitor)


 */