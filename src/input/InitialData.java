package input;


import java.util.List;

/**
 * The class that contains the input information specific to initial data
 */
public class InitialData {
    private List<ChildInputData> children;
    private List<GiftInputData> santaGiftsList;

    /* getters and setters */
    public final List<ChildInputData> getChildren() {
        return children;
    }

    public final void setChildren(final List<ChildInputData> children) {
        this.children = children;
    }

    public final List<GiftInputData> getSantaGiftsList() {
        return santaGiftsList;
    }

    public final void setSantaGiftsList(final List<GiftInputData> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }
}
