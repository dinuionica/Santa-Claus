package enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Cities {

    @JsonProperty("Bucuresti")
    BUCURESTI("Bucuresti"),

    @JsonProperty("Constanta")
    CONSTANTA("Constanta"),

    @JsonProperty("Buzau")
    BUZAU("Buzau"),

    @JsonProperty("Timisoara")
    TIMISOARA("Timisoara"),

    @JsonProperty("Cluj-Napoca")
    CLUJ("Cluj-Napoca"),

    @JsonProperty("Iasi")
    IASI("Iasi"),

    @JsonProperty("Craiova")
    CRAIOVA("Craiova"),

    @JsonProperty("Brasov")
    BRASOV("Brasov"),

    @JsonProperty("Braila")
    BRAILA("Braila"),

    @JsonProperty("Oradea")
    ORADEA("Oradea");

    private String value;
    private Double averageScore;
    private Double sumScore;
    private int numberChildren;

    public final Double getSumScore() {
        return sumScore;
    }

    public final void setSumScore(final Double sumScore) {
        this.sumScore = sumScore;
    }

    public final int getNumberChildren() {
        return numberChildren;
    }

    public final void setNumberChildren(final int numberChildren) {
        this.numberChildren = numberChildren;
    }

    public final Double getAverageScore() {
        return averageScore;
    }

    public final void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }

    public final String getValue() {
        return value;
    }

    public final void setValue(final String value) {
        this.value = value;
    }

    /**
     * The method that initializes class members
     */
    public void updateInformation() {
        this.sumScore = 0.0;
        this.numberChildren = 0;
        this.averageScore = 0.0;
    }

    Cities(final String value) {
        this.value = value;
    }
}
