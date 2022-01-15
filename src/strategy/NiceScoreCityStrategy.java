package strategy;

import child.Child;
import enums.Cities;
import interfaces.Strategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * The class specific of a nice score city strategy
 */
public class NiceScoreCityStrategy implements Strategy {
    /**
     * The method tha applies a nice score city strategy
     * @param childrenList the children list
     */
    @Override
    public void applyStrategy(final List<Child> childrenList) {
        /* sort the list of children by id */
        Collections.sort(childrenList, Comparator.comparing(Child::getId));

        /* create a list of cities */
        List<Cities> listCities = new ArrayList<>();

        /* adding each city */
        for (Cities city : Cities.values()) {
            city.updateInformation();
            listCities.add(city);
        }

        /* calculating the average amount of scores and the number of children in a city */
        for (Cities city : listCities) {
            for (Child child : childrenList) {
                if (child.getCity().equals(city)) {
                    /* set the current sum  */
                    city.setSumScore(city.getSumScore() + child.getAverageScore());
                    /* update the number of children */
                    city.setNumberChildren(city.getNumberChildren() + 1);
                }
            }
        }

        /* calculate the average score of each city */
        for (Cities city : listCities) {
            city.setAverageScore(city.getSumScore() / city.getNumberChildren());
        }

        /* sort the list of children by average score and by name  */
        Collections.sort(listCities, Comparator.comparing(Cities::getAverageScore).reversed()
                .thenComparing(Cities::getValue));

        /* create a list of children sorted by average city score */
        List<Child> finalChildrenList = new ArrayList<>();
        for (Cities city : listCities) {
            for (Child child : childrenList) {
                if (child.getCity().equals(city)) {
                    finalChildrenList.add(child);
                }
            }
        }

        /* update the children list */
        childrenList.clear();
        childrenList.addAll(finalChildrenList);
    }
}
