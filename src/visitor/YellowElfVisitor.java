package visitor;

import child.Child;
import common.Gift;
import interfaces.Visitable;
import interfaces.Visitor;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class YellowElfVisitor implements Visitor {

    private final List<Gift> giftsList;

    public YellowElfVisitor(final List<Gift> giftsList) {
        this.giftsList = giftsList;
    }

    /**
     * The method by which a yellow elf gives a gift
     * @param visitable the visitable instance
     */
    @Override
    public void visit(final Visitable visitable) {
        Collections.sort(giftsList, Comparator.comparing(Gift::getPrice));
        Child child = (Child) visitable;
        if (child.getReceivedGifts().isEmpty()) {
            for (Gift gift: giftsList) {
                if (gift.getCategory().equals(child.getGiftsPreferences().get(0))) {
                    if (gift.getQuantity() > 0) {
                        child.getReceivedCategory().add(child.getGiftsPreferences().get(0));
                        child.getReceivedGifts().add(gift);
                        gift.setQuantity(gift.getQuantity() - 1);
                    }
                    break;
                }
            }
        }
    }
}
