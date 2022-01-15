package visitor;

import child.Child;
import interfaces.Visitable;
import interfaces.Visitor;

import static common.Constants.PERCENT;
import static common.Constants.PROCENT_VALUE;

public class BlackElfVisitor implements Visitor {

    /**
     *
     * @param visitable
     */
    @Override
    public void visit(final Visitable visitable) {
        Child child = (Child) visitable;
        Double budget = child.getAssignedBudget();
        Double budgetSpent = child.getBudgetSpent();
        budget = budget - PROCENT_VALUE * budget / PERCENT;
        child.setAssignedBudget(budget);

        budgetSpent = budgetSpent - PROCENT_VALUE * budgetSpent / PERCENT;
        child.setBudgetSpent(budgetSpent);


    }
}
