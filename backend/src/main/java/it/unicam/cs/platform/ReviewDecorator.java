package it.unicam.cs.platform;

import it.unicam.cs.model.IProduct;
import it.unicam.cs.model.Review;

public class ReviewDecorator extends ProductDecorator {

    public ReviewDecorator(IProduct wrappee) {
        super(wrappee);
    }

    public void addReview(Review review) {
        super.addReview(review);
    };
}
