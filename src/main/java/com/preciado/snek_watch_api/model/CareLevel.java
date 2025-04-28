package com.preciado.snek_watch_api.model;

public enum CareLevel {
    BEGINNER("Low maintenance, forgiving to mistakes (e.g., corn snake)."),
    INTERMEDIATE("Requires some experience, more specific care (e.g., ball python)."),
    ADVANCED("More sensitive or demanding care routines (e.g., green tree python)."),
    EXPERT("Only suitable for highly experienced keepers (e.g., venomous species or rare tropical snakes).");
    private String description;

    private CareLevel(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
