package simulation;

import child.Child;
import common.Gift;
import input.ChildInputData;
import input.GiftInputData;
import input.Input;

import java.util.ArrayList;
import java.util.List;

/**
 * The class that simulates a database and reads the input data
 */
public final class DataBase {
    private static DataBase instanceDataBase = null;

    /*  the default constructor */
    private DataBase() {

    }
    /**
     * The method that returns the instance
     * @return the instance of the object with Database type
     */
    public static DataBase getInstance() {
        if (instanceDataBase == null) {
            instanceDataBase = new DataBase();
        }
        return instanceDataBase;
    }

    /**
     * The method that creates the children list
     * @param input the input data
     * @return the children list
     */
    public  List<Child> createChildList(final Input input) {
        /* get the factory instance */
        ChildFactory childFactory = ChildFactory.getInstance();
        List<Child> childrenList = new ArrayList<>();

        /* get the input children list with children */

        List<ChildInputData> childrenListInput = input.getInitialData().getChildren();

        for (ChildInputData childInput : childrenListInput) {
            /* using factory, create the type of child according to his age */
            Child newChild = (Child) childFactory.createChildInput(childInput.getAge(), childInput);
            /* add the child to the final list */
            childrenList.add(newChild);
        }
        return childrenList;
    }

    /**
     * The method that creates the gift list
     * @param input the input data
     * @return the desired list
     */
    public List<Gift> createGiftsList(final Input input) {
        List<Gift> giftsList = new ArrayList<>();

        /* get the input gifts list with gifts */
        List<GiftInputData> giftsListInput = input.getInitialData().getSantaGiftsList();

        for (GiftInputData giftInput : giftsListInput) {
            /* create the product based on the input gift */
            Gift newGift = new Gift(giftInput);
            /* add the gift to the final list */
            giftsList.add(newGift);
        }
        return giftsList;
    }

    /**
     * The method that creates a copy list of children list
     * @param childrenList the input children list
     * @return the copy of the list
     */
    public List<Child> createCopyList(final List<Child> childrenList) {
        List<Child> copyList = new ArrayList<>();
        /* create a copy of the children list using a deep copy constructor */
        for (Child child : childrenList) {
            copyList.add(new Child(child));
        }
        return copyList;
    }
}
