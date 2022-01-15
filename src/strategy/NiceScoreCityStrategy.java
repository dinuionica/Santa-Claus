package strategy;

import child.Child;
import enums.Cities;
import interfaces.Strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NiceScoreCityStrategy implements Strategy {
    @Override
    public void applyStrategy(List<Child> childrenList) {

        Collections.sort(childrenList, Comparator.comparing(Child::getId));

        /* create a list of cities */
        List<Cities> listCities = new ArrayList<>();

        for (Cities city : Cities.values()) {
            city.updateInformation();
            listCities.add(city);
        }

        /* calculare suma si numar de copii oras */
        for (Cities city : listCities) {
            for (Child child : childrenList) {
                if (child.getCity().equals(city)) {
                    /* setez suma */
                    city.setSumScore(city.getSumScore() + child.getAverageScore());
                    /* update numarul de copii */
                    city.setNumberChildren(city.getNumberChildren() + 1);
                }
            }
        }

        /* calculare get average oras */
        for (Cities city : listCities) {
            city.setAverageScore(city.getSumScore() / city.getNumberChildren());
        }

        /* sortare lista dupa average */
        Collections.sort(listCities, Comparator.comparing(Cities::getAverageScore).reversed()
                .thenComparing(Cities::getValue));



        List<Child> finalList = new ArrayList<>();
        for (Cities city : listCities) {
            for (Child child : childrenList) {
                if (child.getCity().equals(city)) {
                    finalList.add(child);
                }
            }
        }

        childrenList.clear();
        childrenList.addAll(finalList);

    }
}
