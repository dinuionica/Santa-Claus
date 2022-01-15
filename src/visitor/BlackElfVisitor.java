package visitor;

import child.Child;
import interfaces.Visitable;
import interfaces.Visitor;

import static common.Constants.PERCENT;
import static common.Constants.PROCENT_VALUE;

/**
 * The class specific of a black elf
 */
public class BlackElfVisitor implements Visitor {
    /**
     * The method by which a black elf changes a child's budget
     * @param visitable the visitable instance
     */
    @Override
    public void visit(final Visitable visitable) {
        Child child = (Child) visitable;
        /* accessing a child's budgets */
        Double currentBudget = child.getAssignedBudget();
        Double currentBudgetSpent = child.getBudgetSpent();

        /* update the assign budget */
        currentBudget = currentBudget - PROCENT_VALUE * currentBudgetSpent / PERCENT;
        child.setAssignedBudget(currentBudget);

        /* update the budget spent */
        currentBudgetSpent = currentBudgetSpent - PROCENT_VALUE * currentBudgetSpent / PERCENT;
        child.setBudgetSpent(currentBudgetSpent);
    }
}
