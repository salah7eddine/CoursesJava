package com.company.data;

public enum Rating {
    NOT_RATED("\u2686\u2686\u2686\u2686"),
    ONE_STAR("\u2686\u2686\u2686\u2686"),
    TWO_STAR("\u2686\u2686\u2686\u2686"),
    THREE_STAR("\u2686\u2686\u2686\u2686"),
    FOUR_STAR("\u2686\u2686\u2686\u2686"),
    FIVE_STAR("\u2686\u2686\u2686\u2686");

    private String stars;

    Rating(String stars) {
        this.stars = stars;
    }

    public String getStars() {
        return stars;
    }
}
