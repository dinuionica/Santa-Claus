package actions;

import child.Child;
import common.Gift;
import enums.Category;
import enums.CityStrategyEnum;
import enums.ElvesType;
import input.ChildInputData;
import input.ChildUpdateData;
import input.GiftInputData;
import input.Input;
import simulation.ChildFactory;
import strategy.AverageScoreStrategy;
import strategy.Context;
import strategy.IdStrategy;
import strategy.NiceScoreCityStrategy;
import visitor.BlackElfVisitor;
import visitor.PinkElfVisitor;
import visitor.YellowElfVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static common.Constants.AVERAGE_SCORE_BABY;
import static common.Constants.MAXIMUM_AGE_BABY;
import static common.Constants.MAXIMUM_AGE_TEEN;
import static common.Constants.MAX_VALUE_AVERAGE_SCORE;
import static common.Constants.PERCENT;


public final class Command {
    private static Command instanceCommand = null;

    /* the default constructor */
    private Command() {

    }

    /**
     * The method that return the instance
     * @return the instance of the object with Command type
     */
    public static Command getInstance() {
        if (instanceCommand == null) {
            instanceCommand = new Command();
        }
        return instanceCommand;
    }

    /**
     * The method that applies the annual updates
     * @param input the input data
     * @param childrenList the children list
     * @param numberRound the number of round
     */
    public void annualUpdate(final Input input, final List<Child> childrenList,
                             final int numberRound) {
        /* accessing the list of updates from the current round */
        List<ChildUpdateData> listUpdates = input.getAnnualChanges().get(numberRound)
                                        .getChildrenUpdates();

        for (ChildUpdateData listUpdate : listUpdates) {
            for (Child child : childrenList) {
                if (child.getAge() <= MAXIMUM_AGE_TEEN) {
                    if (listUpdate.getId() == child.getId()) {
                        /* if the two ids are identical and the score has a value */
                        if (listUpdate.getNiceScore() != null) {
                            /* add the score the history list */
                            child.getNiceScoreHistory().add(listUpdate.getNiceScore());
                        }

                        /* adding new preferences */
                        if (!listUpdate.getGiftsPreferences().isEmpty()) {
                            /* reverse the list with updates according to the child's preferences*/
                            Collections.reverse(listUpdate.getGiftsPreferences());

                            for (Category category : listUpdate.getGiftsPreferences()) {
                                /* if the child's list already contains
                                 * the preference it is deleted from the list
                                 */
                                if (child.getGiftsPreferences().contains(category)) {
                                    child.getGiftsPreferences().remove(category);
                                }
                                /* add the new preference to the first position in the list */
                                child.getGiftsPreferences().add(0, category);
                            }
                        }

                        /* update elf */
                        child.setElf(listUpdate.getElf());
                    }
                }
            }
        }
    }

    /**
     * The method that increases the age and updates the list of children
     * @param childrenList the children list
     */
    public void increaseAge(final List<Child> childrenList) {
        /* increase the age of every child */
        for (Child child : childrenList) {
            child.setAge(child.getAge() + 1);
        }

        /* updating the list of children according to the new age */
        ChildFactory childFactory = ChildFactory.getInstance();
        List<Child> childrenListCopy = new ArrayList<>();

        for (Child child : childrenList) {
            /* create a new child type */
            Child newChild = (Child) childFactory.createChild(child.getAge(), child);

            /* update the nice score history */
            newChild.setNiceScoreHistory(child.getNiceScoreHistory());

            /* add the new children to the list */
            childrenListCopy.add(newChild);
        }
        /* copy the items to the final list */
        childrenList.clear();
        childrenList.addAll(childrenListCopy);
    }

    /**
     * The method that adds new children from the annual round to the list of children
     * @param input the input data
     * @param childrenList the children list
     * @param numberRound the number of round
     */
    public void addNewChildren(final Input input, final List<Child> childrenList,
                               final int numberRound) {
        /* accessing the list of new children from the current round */
        List<ChildInputData> newChildren = input.getAnnualChanges().get(numberRound)
                                           .getNewChildren();

        for (ChildInputData childInput : newChildren) {
            if (childInput.getAge() <= MAXIMUM_AGE_TEEN) {
                /* create a new child */
                Child child = new Child(childInput);

                /* update the average score based on age */
                if (child.getAge() < MAXIMUM_AGE_BABY) {
                    child.setAverageScore(AVERAGE_SCORE_BABY);
                } else {
                    child.setAverageScore(childInput.getNiceScore());
                }

                /* update the nice score history of the child */
                child.getNiceScoreHistory().add(childInput.getNiceScore());

                /* add the child to the final list */
                childrenList.add(child);
            }
        }
    }

    /**
     * The method that adds new gifts from the gift list
     * @param input the input data
     * @param giftsList the gifts list
     * @param numberRound the number of round
     */
    public void addNewGift(final Input input, final List<Gift> giftsList, final int numberRound) {
        /* accessing the list of new gifts from the current round */
        List<GiftInputData> newGiftsList = input.getAnnualChanges().get(numberRound).getNewGifts();
        for (GiftInputData giftInput :  newGiftsList) {
            /* create a new gift and add it to the final list */
            Gift newGift = new Gift(giftInput);
            giftsList.add(newGift);
        }
    }

    /**
     * The function that updates the santa budget
     * @param input the input data
     * @param numberRound the number of round
     */
    public void updateSantaBudget(final Input input, final int numberRound) {
        /* update the new santa budget */
        input.setSantaBudget(input.getAnnualChanges().get(numberRound).getNewSantaBudget());
    }

    /**
     * The method that removes the children that become young adults
     * @param childrenList the children list
     */
    public void removeYoungAdults(final List<Child> childrenList) {
        /* delete from the list the child over the age of 18 */
        for (int i = 0; i < childrenList.size(); ++i) {
            if (childrenList.get(i).getAge() > MAXIMUM_AGE_TEEN) {
                childrenList.remove(childrenList.get(i));
            }
        }
    }

    /**
     * The method that calculates the budget unit for every child
     * @param input the input data
     * @param childrenList the children list
     */
    public void calculateBudgetUnit(final Input input, final List<Child> childrenList) {
        Collections.sort(childrenList, Comparator.comparing(Child::getId));
        Double sumAverageScore = 0.0;

        for (Child child : childrenList) {
            if (child.getAge() <= MAXIMUM_AGE_TEEN) {
                /* calculate the average score */
                child.calculateAverageScore();
                Double currentScore = child.getAverageScore();
                if (child.getNiceScoreBonus() != null) {
                    currentScore += currentScore * child.getNiceScoreBonus() / PERCENT;
                    if (currentScore > MAX_VALUE_AVERAGE_SCORE) {
                        currentScore = MAX_VALUE_AVERAGE_SCORE;
                    }
                    child.setAverageScore(currentScore);
                }
                /* calculate the sum of average scores */
                sumAverageScore += child.getAverageScore();
            }
        }


        /* determination of the budget unit */
        Double budgetUnit = input.getSantaBudget() / sumAverageScore;

        for (Child child : childrenList) {
            /* assign of the budget unit */
            child.setAssignedBudget(budgetUnit * child.getAverageScore());
            /* assign of the budget unit spent */
            child.setBudgetSpent(child.getAssignedBudget());
        }
    }

    /**
     * The method that awards the gifts for children
     * @param childrenList the children list
     * @param giftsList the gifts list
     */
    public void awardingGifts(final List<Child> childrenList, final List<Gift> giftsList) {
        /* sorting the gifts list by price */
        Collections.sort(giftsList, Comparator.comparing(Gift::getPrice));

        for (Child child : childrenList) {
            for (Category category : child.getGiftsPreferences()) {
                for (Gift gift : giftsList) {
                    /* if the category was found and the price is acceptable */
                    if (gift.getCategory().equals(category)
                        && gift.getPrice() <= child.getBudgetSpent()
                        && gift.getQuantity() > 0) {
                        /* if the child has not received a gift from the same category */
                        if (!child.getReceivedCategory().contains(category)) {
                            /* assign the desired gift to the child */
                            child.getReceivedGifts().add(gift);
                            child.getReceivedCategory().add(category);
                            /* update the budget spent */
                            child.setBudgetSpent(child.getBudgetSpent() - gift.getPrice());
                            gift.setQuantity(gift.getQuantity() - 1);
                        }
                    }
                }
            }
        }
    }

    /**
     * The method that adds the initial score to history of every child
     * @param childrenList the children list
     */
    public void addInitialScore(final List<Child> childrenList) {
        for (Child child : childrenList) {
            if (child.getAge() <= MAXIMUM_AGE_TEEN) {
                /* add the initial score to history list with nice scores */
                child.getNiceScoreHistory().add(child.getNiceScore());
            }
        }
    }

    /**
     *
     * @param input
     * @param childrenList
     * @param numberRound
     */
    public void applyStrategies(final Input input, final List<Child> childrenList,
                                final int numberRound) {

        if (input.getAnnualChanges().get(numberRound).getStrategy().equals(CityStrategyEnum.ID)) {
            Context context = new Context(new IdStrategy());
            context.executeStrategy(childrenList);

        } else if (input.getAnnualChanges().get(numberRound).getStrategy()
                   .equals(CityStrategyEnum.NICE_SCORE)) {
            Context context = new Context(new AverageScoreStrategy());
            context.executeStrategy(childrenList);
        } else if (input.getAnnualChanges().get(numberRound).getStrategy()
                   .equals(CityStrategyEnum.NICE_SCORE_CITY)) {
            Context context = new Context(new NiceScoreCityStrategy());
            context.executeStrategy(childrenList);
        }
    }

    /**
     *
     * @param childrenList
     */
    public void applyBlankPink(final List<Child> childrenList) {
        for (Child child: childrenList) {
            if (child.getElf().equals(ElvesType.PINK)) {
                PinkElfVisitor pinkElf = new PinkElfVisitor();
                child.accept(pinkElf);
            } else if (child.getElf().equals(ElvesType.BLACK)) {
                BlackElfVisitor blackElfVisitor = new BlackElfVisitor();
                child.accept(blackElfVisitor);
            }
        }
    }

    /**
     *
     * @param childrenList
     * @param giftsList
     */
    public void applyYellow(final List<Child> childrenList, final List<Gift> giftsList) {
        for (Child child: childrenList) {
            if (child.getElf().equals(ElvesType.YELLOW)) {
                YellowElfVisitor yellowElf = new YellowElfVisitor(giftsList);
                child.accept(yellowElf);
            }
        }
    }
}
