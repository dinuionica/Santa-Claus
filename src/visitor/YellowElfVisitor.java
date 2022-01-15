package visitor;

import child.Child;
import common.Gift;
import interfaces.Visitable;
import interfaces.Visitor;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * The class specific of a yellow elf
 */
public class YellowElfVisitor implements Visitor {
    private final List<Gift> giftsList;

    /* the constructor */
    public YellowElfVisitor(final List<Gift> giftsList) {
        this.giftsList = giftsList;
    }

    /**
     * The method by which a yellow elf gives a gift
     * @param visitable the visitable instance
     */
    @Override
    public void visit(final Visitable visitable) {
        /* sort the list of gift by price */
        Collections.sort(giftsList, Comparator.comparing(Gift::getPrice));
        Child child = (Child) visitable;

        /* the elf gives the child the cheapest gift in his favorite category */
        /* if the child has not received another gif */
        if (child.getReceivedGifts().isEmpty()) {
            for (Gift gift: giftsList) {
                /* if the gift is from your favorite category */
                if (gift.getCategory().equals(child.getGiftsPreferences().get(0))) {
                    /* if the gift quantity has not been used up */
                    if (gift.getQuantity() > 0) {
                        /* gift assignment and quantity update */
                        child.getReceivedCategory().add(child.getGiftsPreferences().get(0));
                        child.getReceivedGifts().add(gift);
                        gift.setQuantity(gift.getQuantity() - 1);
                    }
                    /* unfortunately he will not receive any gifts */
                    break;
                }
            }
        }
    }
}
