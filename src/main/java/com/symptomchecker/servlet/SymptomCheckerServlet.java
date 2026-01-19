package com.symptomchecker.servlet;

import com.symptomchecker.logic.SymptomChecker;
import com.symptomchecker.model.Condition;
import com.symptomchecker.model.Advice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Servlet that handles symptom checking requests.
 * Receives POST requests from the HTML form and returns results.
 */
public class SymptomCheckerServlet extends HttpServlet {
    
    private SymptomChecker symptomChecker;

    @Override
    public void init() throws ServletException {
        // Initialize the symptom checker when servlet starts
        symptomChecker = new SymptomChecker();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Set response content type
        response.setContentType("text/html;charset=UTF-8");
        
        // Get selected symptoms from form
        String[] selectedSymptoms = request.getParameterValues("symptoms");
        List<String> symptomIds = new ArrayList<>();
        
        if (selectedSymptoms != null) {
            symptomIds = Arrays.asList(selectedSymptoms);
        }

        // Check symptoms using our logic
        List<Condition> conditions = symptomChecker.checkSymptoms(symptomIds);
        Advice advice = symptomChecker.getAdvice(symptomIds, conditions);

        // Generate HTML response
        PrintWriter out = response.getWriter();
        out.println(generateResultsPage(symptomIds, conditions, advice));
    }

    /**
     * Generates the HTML results page.
     * This method builds HTML string to display results.
     */
    private String generateResultsPage(List<String> symptoms, List<Condition> conditions, Advice advice) {
        StringBuilder html = new StringBuilder();
        
        html.append("<!DOCTYPE html>");
        html.append("<html lang='en'>");
        html.append("<head>");
        html.append("<meta charset='UTF-8'>");
        html.append("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        html.append("<title>Results - Symptom Checker</title>");
        html.append("<link rel='stylesheet' href='style.css'>");
        html.append("</head>");
        html.append("<body>");
        html.append("<div class='container'>");
        
        // Header
        html.append("<header>");
        html.append("<h1>🩺 Symptom Checker Results</h1>");
        html.append("</header>");
        
        // Disclaimer
        html.append("<div class='disclaimer'>");
        html.append("<strong>⚠️ Disclaimer:</strong> This is NOT a medical diagnosis. ");
        html.append("This tool is for educational purposes only. Always consult a qualified ");
        html.append("healthcare professional for medical advice.");
        html.append("</div>");
        
        // Results section
        html.append("<div class='results-section'>");
        
        // Show selected symptoms
        html.append("<h2>Your Selected Symptoms</h2>");
        if (symptoms.isEmpty()) {
            html.append("<p class='no-results'>No symptoms were selected.</p>");
        } else {
            html.append("<p>You selected: <strong>");
            html.append(String.join(", ", symptoms).replace("_", " "));
            html.append("</strong></p>");
        }
        
        // Show possible conditions
        html.append("<h2>Possible Conditions</h2>");
        if (conditions.isEmpty()) {
            html.append("<p class='no-results'>No matching conditions found. ");
            html.append("Please select more symptoms or consult a doctor.</p>");
        } else {
            for (Condition condition : conditions) {
                html.append("<div class='condition-card'>");
                html.append("<h3>").append(condition.getName()).append("</h3>");
                html.append("<p>").append(condition.getDescription()).append("</p>");
                html.append("</div>");
            }
        }
        
        // Show advice
        html.append("<h2>Advice</h2>");
        html.append("<div class='advice-card urgency-").append(advice.getUrgencyLevel()).append("'>");
        html.append("<h3>💡 Recommendation</h3>");
        html.append("<p class='advice-message'>").append(advice.getMessage()).append("</p>");
        html.append("<p><small>Urgency Level: <strong>");
        html.append(advice.getUrgencyLevel().toUpperCase());
        html.append("</strong></small></p>");
        html.append("</div>");
        
        html.append("</div>"); // End results-section
        
        // Back button
        html.append("<div style='text-align: center; margin-top: 30px;'>");
        html.append("<a href='index.html' class='submit-btn' style='text-decoration: none; display: inline-block;'>");
        html.append("Check More Symptoms");
        html.append("</a>");
        html.append("</div>");
        
        // Footer
        html.append("<footer>");
        html.append("<p>💡 <strong>Educational Project</strong> - Clinical Decision Support Demo</p>");
        html.append("<p>This demonstrates simple IF-ELSE logic for symptom matching.</p>");
        html.append("</footer>");
        
        html.append("</div>"); // End container
        html.append("</body>");
        html.append("</html>");
        
        return html.toString();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Redirect GET requests to the main page
        response.sendRedirect("index.html");
    }
}
