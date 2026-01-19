package com.symptomchecker.logic;

import com.symptomchecker.model.Symptom;
import com.symptomchecker.model.Condition;
import java.util.ArrayList;
import java.util.List;

/**
 * Database class that stores all available symptoms and conditions.
 * In a real application, this data would come from a database.
 * For simplicity, we use hardcoded data.
 */
public class SymptomDatabase {
    
    private List<Symptom> symptoms;
    private List<Condition> conditions;

    // Constructor - initializes the database with sample data
    public SymptomDatabase() {
        symptoms = new ArrayList<>();
        conditions = new ArrayList<>();
        initializeSymptoms();
        initializeConditions();
    }

    // Initialize all available symptoms
    private void initializeSymptoms() {
        symptoms.add(new Symptom("fever", "Fever", "Body temperature above 38°C (100.4°F)"));
        symptoms.add(new Symptom("cough", "Cough", "Persistent coughing"));
        symptoms.add(new Symptom("headache", "Headache", "Pain in the head area"));
        symptoms.add(new Symptom("fatigue", "Fatigue", "Feeling very tired"));
        symptoms.add(new Symptom("runny_nose", "Runny Nose", "Excess nasal discharge"));
        symptoms.add(new Symptom("sneezing", "Sneezing", "Frequent sneezing"));
        symptoms.add(new Symptom("body_aches", "Body Aches", "Muscle pain throughout body"));
        symptoms.add(new Symptom("sore_throat", "Sore Throat", "Pain or irritation in throat"));
        symptoms.add(new Symptom("nausea", "Nausea", "Feeling sick to stomach"));
        symptoms.add(new Symptom("dizziness", "Dizziness", "Feeling lightheaded or unsteady"));
    }

    // Initialize all conditions with their associated symptoms
    private void initializeConditions() {
        // Common Cold
        Condition cold = new Condition("Common Cold", "A viral infection of the upper respiratory tract");
        cold.addSymptom("fever");
        cold.addSymptom("cough");
        cold.addSymptom("runny_nose");
        cold.addSymptom("sore_throat");
        conditions.add(cold);

        // Flu
        Condition flu = new Condition("Flu (Influenza)", "A contagious respiratory illness caused by influenza viruses");
        flu.addSymptom("fever");
        flu.addSymptom("headache");
        flu.addSymptom("body_aches");
        flu.addSymptom("fatigue");
        flu.addSymptom("cough");
        conditions.add(flu);

        // Allergies
        Condition allergies = new Condition("Allergies", "An immune system response to allergens");
        allergies.addSymptom("runny_nose");
        allergies.addSymptom("sneezing");
        allergies.addSymptom("headache");
        conditions.add(allergies);

        // Stress/Fatigue
        Condition stress = new Condition("Stress or Exhaustion", "Physical or mental tiredness from overwork");
        stress.addSymptom("headache");
        stress.addSymptom("fatigue");
        stress.addSymptom("dizziness");
        conditions.add(stress);

        // Food Poisoning
        Condition foodPoisoning = new Condition("Mild Food Poisoning", "Illness caused by contaminated food");
        foodPoisoning.addSymptom("nausea");
        foodPoisoning.addSymptom("fatigue");
        foodPoisoning.addSymptom("dizziness");
        conditions.add(foodPoisoning);
    }

    // Get all symptoms
    public List<Symptom> getAllSymptoms() {
        return symptoms;
    }

    // Get all conditions
    public List<Condition> getAllConditions() {
        return conditions;
    }

    // Get a symptom by ID
    public Symptom getSymptomById(String id) {
        for (Symptom symptom : symptoms) {
            if (symptom.getId().equals(id)) {
                return symptom;
            }
        }
        return null;
    }
}
