package com.company.data;

import static com.company.data.Rating.NOT_RATED;

@FunctionalInterface // that we have just one method
public interface Rateable<T> {
    public static final Rating DEFAULT_RATING = NOT_RATED;

    public abstract T applyRating(Rating rating);

    public default T applyRating(int stars) {
        return applyRating(convert(stars));
    }

    public default Rating getRating() {
        return DEFAULT_RATING;
    }

    public static Rating convert(int stars) {
        return (stars >= 0 && stars<=5) ? Rating.values()[stars] : DEFAULT_RATING;
    }
}
