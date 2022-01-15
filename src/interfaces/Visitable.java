package interfaces;

/**
 * The visitable interface used for the visitor pattern
 */
public interface Visitable {
    /**
     * The method by which a visitor's operation is accepted
     * @param visitor the visitor instance
     */
    void accept(Visitor visitor);
}
