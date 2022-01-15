package input;

import enums.Category;
import enums.Cities;
import enums.ElvesType;

import java.util.List;

/**
 * The class that contains the input information  specific to a child
 */
public class ChildInputData {
    private int id;
    private String lastName;
    private String firstName;
    private int age;
    private Cities city;
    private Double niceScore;
    private List<Category> giftsPreferences;
    private Double niceScoreBonus;
    private ElvesType elf;

    /* getters and setter */
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
}
