package output;


import child.Child;
import common.GiftOutputData;
import enums.Category;
import enums.Cities;

import java.util.ArrayList;
import java.util.List;

/**
 * The class that contains the output information specific to an output child
 */
public class ChildOutputData {
    private int id;
    private String lastName;
    private String firstName;
    private Cities city;
    private int age;
    private List<Category> giftsPreferences;
    private Double averageScore;
    private List<Double> niceScoreHistory;
    private Double assignedBudget;
    private List<GiftOutputData> receivedGifts;

    /* the constructor */
    public ChildOutputData(final Child child) {
        this.id = child.getId();
        this.lastName = child.getLastName();
        this.firstName = child.getFirstName();
        this.age = child.getAge();
        this.city = child.getCity();
        this.giftsPreferences = child.getGiftsPreferences();
        this.niceScoreHistory = child.getNiceScoreHistory();
        this.receivedGifts = new ArrayList<>();
    }

    /* getters and setters */
    public final int getId() {
        return id;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public final int getAge() {
        return age;
    }

    public final void setAge(final int age) {
        this.age = age;
    }

    public final Cities getCity() {
        return city;
    }

    public final void setCity(final Cities city) {
        this.city = city;
    }

    public final List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public final void setGiftsPreferences(final List<Category> giftsPreference) {
        this.giftsPreferences = giftsPreference;
    }

    public final Double getAverageScore() {
        return averageScore;
    }

    public final void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }

    public final List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public final void setNiceScoreHistory(final List<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    public final Double getAssignedBudget() {
        return assignedBudget;
    }

    public final void setAssignedBudget(final Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public final List<GiftOutputData> getReceivedGifts() {
        return receivedGifts;
    }

    public final void setReceivedGifts(final List<GiftOutputData> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }
}
