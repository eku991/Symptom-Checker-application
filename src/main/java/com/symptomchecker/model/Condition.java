package com.symptomchecker.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a medical condition with associated symptoms.
 * This class demonstrates the use of ArrayList to store related symptoms.
 */
public class Condition {
    
    private String name;
    private String description;
    private List<String> symptomIds;  // List of symptom IDs associated with this condition

    // Constructor
    public Condition(String name, String description) {
        this.name = name;
        this.description = description;
        this.symptomIds = new ArrayList<>();
    }

    // Add a symptom ID to this condition
    public void addSymptom(String symptomId) {
        symptomIds.add(symptomId);
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getSymptomIds() {
        return symptomIds;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSymptomIds(List<String> symptomIds) {
        this.symptomIds = symptomIds;
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}
