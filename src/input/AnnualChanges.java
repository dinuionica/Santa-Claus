package input;

import enums.CityStrategyEnum;

import java.util.List;

/**
 * The class that contains the input information specific to an annual update
 */
public class AnnualChanges {
    private int newSantaBudget;
    private List<GiftInputData> newGifts;
    private List<ChildInputData> newChildren;
    private List<ChildUpdateData> childrenUpdates;
    private CityStrategyEnum strategy;

    /* getters and setter */
    public final int getNewSantaBudget() {
        return newSantaBudget;
    }

    public final void setNewSantaBudget(final int newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public final List<GiftInputData> getNewGifts() {
        return newGifts;
    }

    public final void setNewGifts(final List<GiftInputData> newGifts) {
        this.newGifts = newGifts;
    }

    public final List<ChildInputData> getNewChildren() {
        return newChildren;
    }

    public final void setNewChildren(final List<ChildInputData> newChildren) {
        this.newChildren = newChildren;
    }

    public final List<ChildUpdateData> getChildrenUpdates() {
        return childrenUpdates;
    }

    public final void setChildrenUpdates(final List<ChildUpdateData> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }
    public final CityStrategyEnum getStrategy() {
        return strategy;
    }

    public final void setStrategy(final CityStrategyEnum strategy) {
        this.strategy = strategy;
    }
}
