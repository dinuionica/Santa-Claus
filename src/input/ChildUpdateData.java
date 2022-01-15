package input;

import enums.Category;
import enums.ElvesType;

import java.util.List;

/**
 * The class that contains the input information specific to an update for a child
 */
public class ChildUpdateData {
    private int id;
    private Double niceScore;
    private List<Category> giftsPreferences;
    private ElvesType elf;

    /* getters and setters */
    public final int getId() {
        return id;
    }

    public final void setId(final int id) {
        this.id = id;
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
    public final ElvesType getElf() {
        return elf;
    }

    public final void setElf(final ElvesType elf) {
        this.elf = elf;
    }
}
