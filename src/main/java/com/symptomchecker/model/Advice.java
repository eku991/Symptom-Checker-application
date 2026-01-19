package com.symptomchecker.model;

/**
 * Represents health advice given to the user.
 * Contains a message and urgency level.
 */
public class Advice {
    
    private String message;
    private String urgencyLevel;  // "low", "medium", "high"

    // Constructor
    public Advice(String message, String urgencyLevel) {
        this.message = message;
        this.urgencyLevel = urgencyLevel;
    }

    // Getters
    public String getMessage() {
        return message;
    }

    public String getUrgencyLevel() {
        return urgencyLevel;
    }

    // Setters
    public void setMessage(String message) {
        this.message = message;
    }

    public void setUrgencyLevel(String urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    @Override
    public String toString() {
        return message + " (Urgency: " + urgencyLevel + ")";
    }
}
