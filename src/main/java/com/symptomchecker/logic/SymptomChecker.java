package com.symptomchecker.logic;

import com.symptomchecker.model.Condition;
import com.symptomchecker.model.Advice;
import java.util.ArrayList;
import java.util.List;

/**
 * Main logic class for checking symptoms and providing advice.
 * Uses simple IF-ELSE logic to match symptoms to conditions.
 */
public class SymptomChecker {
    
    private SymptomDatabase database;

    // Constructor
    public SymptomChecker() {
        this.database = new SymptomDatabase();
    }

    // Get all available symptoms for display
    public List<com.symptomchecker.model.Symptom> getAllSymptoms() {
        return database.getAllSymptoms();
    }

    /**
     * Main method to check symptoms and find matching conditions.
     * Uses IF-ELSE logic to determine matches.
     * 
     * @param selectedSymptomIds List of symptom IDs selected by the user
     * @return List of possible conditions
     */
    public List<Condition> checkSymptoms(List<String> selectedSymptomIds) {
        List<Condition> matchingConditions = new ArrayList<>();
        
        // If no symptoms selected, return empty list
        if (selectedSymptomIds == null || selectedSymptomIds.isEmpty()) {
            return matchingConditions;
        }

        // Check each condition against selected symptoms
        for (Condition condition : database.getAllConditions()) {
            int matchCount = 0;
            List<String> conditionSymptoms = condition.getSymptomIds();
            
            // Count how many symptoms match
            for (String symptomId : selectedSymptomIds) {
                if (conditionSymptoms.contains(symptomId)) {
                    matchCount++;
                }
            }

            // IF at least 2 symptoms match, consider it a possible condition
            if (matchCount >= 2) {
                matchingConditions.add(condition);
            }
        }

        return matchingConditions;
    }

    /**
     * Get advice based on the selected symptoms and matching conditions.
     * Uses IF-ELSE logic to determine appropriate advice.
     * 
     * @param selectedSymptomIds List of symptom IDs selected by the user
     * @param conditions List of matching conditions
     * @return Advice object with recommendation
     */
    public Advice getAdvice(List<String> selectedSymptomIds, List<Condition> conditions) {
        
        // IF fever is present with multiple symptoms - see a doctor
        if (selectedSymptomIds.contains("fever") && selectedSymptomIds.size() >= 3) {
            return new Advice("You have a fever with multiple symptoms. Please see a doctor soon.", "high");
        }
        
        // ELSE IF fever is present - rest and monitor
        else if (selectedSymptomIds.contains("fever")) {
            return new Advice("You have a fever. Rest, stay hydrated, and monitor your temperature. See a doctor if it persists.", "medium");
        }
        
        // ELSE IF nausea with dizziness - seek medical attention
        else if (selectedSymptomIds.contains("nausea") && selectedSymptomIds.contains("dizziness")) {
            return new Advice("Nausea with dizziness may need medical attention. Stay hydrated and rest.", "medium");
        }
        
        // ELSE IF only mild symptoms like runny nose and sneezing - likely allergies
        else if (selectedSymptomIds.contains("runny_nose") && selectedSymptomIds.contains("sneezing") 
                 && !selectedSymptomIds.contains("fever")) {
            return new Advice("Your symptoms suggest allergies. Try to avoid allergens and consider antihistamines.", "low");
        }
        
        // ELSE IF fatigue and headache only - rest needed
        else if (selectedSymptomIds.contains("fatigue") && selectedSymptomIds.contains("headache") 
                 && selectedSymptomIds.size() <= 3) {
            return new Advice("You may be stressed or dehydrated. Rest, drink water, and take breaks.", "low");
        }
        
        // ELSE IF multiple symptoms detected - general advice
        else if (selectedSymptomIds.size() >= 3) {
            return new Advice("You have several symptoms. Rest and monitor your condition. See a doctor if symptoms worsen.", "medium");
        }
        
        // ELSE - mild symptoms, general rest
        else {
            return new Advice("Rest, stay hydrated, and monitor your symptoms. See a doctor if they persist.", "low");
        }
    }
}
