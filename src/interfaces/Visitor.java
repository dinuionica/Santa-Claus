package interfaces;

/**
 * The visitable interface used for the visitor pattern
 */
public interface Visitor {
    /**
     * The method by which the visitable type operation is applied
     * @param visitable the visitable instance
     */
    void visit(Visitable visitable);
}
