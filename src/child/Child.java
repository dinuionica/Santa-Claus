package child;

import common.Gift;
import enums.Category;
import enums.Cities;
import enums.ElvesType;
import input.ChildInputData;
import interfaces.Visitable;
import interfaces.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * The class that contains the all information about a child
 */
public class Child implements Visitable {
    private int id;
    private String lastName;
    private String firstName;
    private int age;
    private Cities city;
    private Double niceScore;
    private List<Category> giftsPreferences;
    private Double averageScore;
    private List<Double> niceScoreHistory;
    private Double assignedBudget;
    private List<Gift> receivedGifts;
    private List<Category> receivedCategory;
    private Double budgetSpent;
    private Double niceScoreBonus;
    private ElvesType elf;


    /* the normal constructor */
    public Child(final int id, final String lastName, final String firstName, final int age,
                 final Cities city, final Double niceScore, final List<Category> giftsPreferences,
                 final Double niceScoreBonus, final ElvesType elf) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.city = city;
        this.niceScore = niceScore;
        this.giftsPreferences = giftsPreferences;
        this.niceScoreBonus = niceScoreBonus;
        this.elf = elf;
        this.niceScoreHistory = new ArrayList<>();
        this.receivedGifts = new ArrayList<>();
        this.receivedCategory = new ArrayList<>();
        this.averageScore = 0.0;
    }

    /* the constructor used to create a child based on information taken from an input child */
    public Child(final ChildInputData child) {
        this.id = child.getId();
        this.lastName = child.getLastName();
        this.firstName = child.getFirstName();
        this.age = child.getAge();
        this.city = child.getCity();
        this.niceScore = child.getNiceScore();
        this.giftsPreferences = child.getGiftsPreferences();
        this.elf = child.getElf();
        this.niceScoreBonus = child.getNiceScoreBonus();
        this.niceScoreHistory = new ArrayList<>();
        this.receivedGifts = new ArrayList<>();
        this.receivedCategory = new ArrayList<>();
        this.averageScore = 0.0;
    }

    /* the deep constructor used to create a child based on information taken from child database */
    public Child(final Child child) {
        this.id = child.getId();
        this.lastName = child.getLastName();
        this.firstName = child.getFirstName();
        this.age = child.getAge();
        this.city = child.getCity();
        this.niceScore = child.getNiceScore();
        this.giftsPreferences = new ArrayList<>(child.getGiftsPreferences());
        this.niceScoreHistory = new ArrayList<>(child.getNiceScoreHistory());
        this.receivedGifts = child.getReceivedGifts();
        this.receivedCategory = child.getReceivedCategory();
        this.averageScore = child.getAverageScore();
        this.elf = child.getElf();
        this.assignedBudget = 0.0;
        this.budgetSpent = 0.0;
        this.niceScoreBonus = child.getNiceScoreBonus();
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

    public final Double getNiceScore() {
        return niceScore;
    }

    public final void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    public final List<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public final void setGiftsPreferences(final List<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
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

    public final List<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    public final void setReceivedGifts(final List<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    public final List<Category> getReceivedCategory() {
        return receivedCategory;
    }

    public final void setReceivedCategory(final List<Category> receivedCategory) {
        this.receivedCategory = receivedCategory;
    }

    public final Double getBudgetSpent() {
        return budgetSpent;
    }

    public final void setBudgetSpent(final Double budgetSpent) {
        this.budgetSpent = budgetSpent;
    }

    public final Double getNiceScoreBonus() {
        return niceScoreBonus;
    }

    public final void setNiceScoreBonus(final Double niceScoreBonus) {
        this.niceScoreBonus = niceScoreBonus;
    }

    public final ElvesType  getElf() {
        return elf;
    }

    public final void setElf(final ElvesType  elf) {
        this.elf = elf;
    }

    /**
     * The method that calculates the average score for a child
     */
    public void calculateAverageScore() {
    }

    /**
     *
     * @param visitor
     */
    @Override
    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }
}
