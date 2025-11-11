package it.unicam.cs.platform;

import it.unicam.cs.model.IProduct;
import it.unicam.cs.model.Review;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class ProductDecorator implements IProduct {
    private IProduct wrappee;

    public void addReview(Review review){
        wrappee.addReview(review);
    }
}
