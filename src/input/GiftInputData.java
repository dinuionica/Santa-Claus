package input;

import enums.Category;

/**
 * The class that contains the input information specific to a gift
 */
public class GiftInputData {
    private String productName;
    private Double price;
    private Category category;
    private int quantity;

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

    public final int getQuantity() {
        return quantity;
    }

    public final void setQuantity(final int quantity) {
        this.quantity = quantity;
    }
}
