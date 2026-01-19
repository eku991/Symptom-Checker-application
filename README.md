# 🩺 Symptom Checker Application

A simple Java-based web application for educational purposes. Users select symptoms and receive possible conditions with health advice using rule-based IF-ELSE logic.

## Disclaimer
**This is NOT a medical diagnosis tool.** This application is for educational purposes only. Always consult a qualified healthcare professional for medical advice.

---

## Features

- Select from 10 common symptoms via checkboxes
- View possible matching conditions
- Get health advice based on symptoms
- Clean, responsive web interface
- Simple IF-ELSE logic (no AI)

---

## Technologies Used

- **Java 11** - Main programming language
- **Java Servlets** - Backend handling
- **HTML/CSS** - Frontend interface
- **Maven** - Build tool

---

## 📁 Project Structure

```
src/
├── main/
│   ├── java/com/symptomchecker/
│   │   ├── model/
│   │   │   ├── Symptom.java      # Symptom class
│   │   │   ├── Condition.java    # Medical condition class
│   │   │   └── Advice.java       # Health advice class
│   │   ├── logic/
│   │   │   ├── SymptomDatabase.java  # Stores symptoms/conditions
│   │   │   └── SymptomChecker.java   # IF-ELSE matching logic
│   │   └── servlet/
│   │       └── SymptomCheckerServlet.java  # Handles requests
│   └── webapp/
│       ├── index.html           # Main page
│       ├── style.css            # Styling
│       └── WEB-INF/web.xml      # Servlet config
```

---

##  How to Run

### Prerequisites
- Java 11 or higher
- Maven installed

### Steps

1. **Clone the repository**
```bash
git clone https://github.com/eku991/Symptom-Checker-application.git
cd Symptom-Checker-application
```

2. **Build the project**
```bash
mvn clean compile
```

3. **Run with Jetty**
```bash
mvn jetty:run
```

4. **Open in browser**
```
http://localhost:8080
```

---

##  OOP Concepts Demonstrated

| Concept | Example |
|---------|---------|
| Classes & Objects | Symptom, Condition, Advice |
| Encapsulation | Private fields with getters/setters |
| ArrayList | Storing symptoms and conditions |
| IF-ELSE Logic | SymptomChecker matching rules |

---

## Author

Educational project for health informatics demonstration.
