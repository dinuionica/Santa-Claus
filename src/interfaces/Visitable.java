package interfaces;

/**
 * The visitable interface
 */
public interface Visitable {
    /**
     *
     * @param visitor
     */
    void accept(Visitor visitor);
}
