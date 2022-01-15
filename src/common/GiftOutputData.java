package common;

import enums.Category;

/**
 * The class that contains the information specific to a output gift
 */
public class GiftOutputData {
    private String productName;
    private Double price;
    private Category category;

    /* the constructor */
    public GiftOutputData(final Gift gift) {
        this.productName = gift.getProductName();
        this.price = gift.getPrice();
        this.category = gift.getCategory();
    }

    /* getters and setters */
    public final String getProductName() {
        return productName;
    }

    public final void setProductName(final String productName) {
        this.productName = productName;
    }

    public final Double getPrice() {
        return price;
    }

    public final void setPrice(final Double price) {
        this.price = price;
    }

    public final Category getCategory() {
        return category;
    }

    public final void setCategory(final Category category) {
        this.category = category;
    }
}
