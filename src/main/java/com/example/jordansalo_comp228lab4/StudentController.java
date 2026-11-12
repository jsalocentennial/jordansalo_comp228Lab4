
package com.example.jordansalo_comp228lab4;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StudentController {

    // Student Information
    @FXML
    private TextField name_field;

    @FXML
    private TextField address_field;

    @FXML
    private TextField province_field;

    @FXML
    private TextField city_field;

    @FXML
    private TextField postal_field;

    @FXML
    private TextField phone_field;

    @FXML
    private TextField email_field;


    // Major Selection
    @FXML
    private RadioButton cs_class_button;

    @FXML
    private RadioButton business_class_button;

    @FXML
    private ToggleGroup class_selector;


    // Course Selection
    @FXML
    private ComboBox<String> class_combo_box;

    @FXML
    private ListView<String> list_area;


    // Activities
    @FXML
    private CheckBox Student_council_button;

    @FXML
    private CheckBox volunteer_work_button;


    // Output
    @FXML
    private TextArea text_area;


    // Initialize Controller
    @FXML
    private void initialize() {

        class_combo_box.setPromptText("Select a course");

        // Postal Code Validation
        postal_field.textProperty().addListener(
                (observable, oldValue, newValue) -> {

                    if (newValue.isEmpty()) {
                        postal_field.setStyle("");

                    } else if (validPostal(newValue)) {
                        postal_field.setStyle("-fx-border-color: green;");

                    } else {
                        postal_field.setStyle("-fx-border-color: red;");
                    }
                }
        );

        // Phone Number Validation
        phone_field.textProperty().addListener(
                (observable, oldValue, newValue) -> {

                    if (newValue.isEmpty()) {
                        phone_field.setStyle("");

                    } else if (validPhone(newValue)) {
                        phone_field.setStyle("-fx-border-color: green;");

                    } else {
                        phone_field.setStyle("-fx-border-color: red;");
                    }
                }
        );

        // Email Validation
        email_field.textProperty().addListener(
                (observable, oldValue, newValue) -> {

                    if (newValue.isEmpty()) {
                        email_field.setStyle("");

                    } else if (validEmail(newValue)) {
                        email_field.setStyle("-fx-border-color: green;");

                    } else {
                        email_field.setStyle("-fx-border-color: red;");
                    }
                }
        );
    }


    // Validation Methods
    private boolean validPostal(String postal) {

        return postal.matches(
                "(?i)[ABCEGHJ-NPRSTVXY]\\d[ABCEGHJ-NPRSTV-Z][ -]?\\d[ABCEGHJ-NPRSTV-Z]\\d"
        );
    }

    private boolean validPhone(String phone) {

        String digits = phone.replaceAll("[\\s()-]", "");

        return digits.matches("\\d{10}");
    }

    private boolean validEmail(String email) {

        return email.matches(
                "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
        );
    }


    // Error Message
    private void showError(String message) {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Student Information");
        alert.setHeaderText("Please correct the following:");
        alert.setContentText(message);
        alert.showAndWait();
    }


    // Major Selection
    @FXML
    private void select_class() {

        class_combo_box.getItems().clear();
        class_combo_box.setValue(null);
        list_area.getItems().clear();

        if (cs_class_button.isSelected()) {

            class_combo_box.getItems().addAll(
                    "Programming",
                    "Database",
                    "WebDesign"
            );

        } else if (business_class_button.isSelected()) {

            class_combo_box.getItems().addAll(
                    "Management",
                    "Human Resources",
                    "Accounting"
            );
        }
    }


    // Course Selection
    @FXML
    private void display_class() {

        String selectedClass = class_combo_box.getValue();

        if (selectedClass != null &&
                !list_area.getItems().contains(selectedClass)) {

            list_area.getItems().add(selectedClass);
        }
    }


    // Activities
    @FXML
    private void select_student_council() {
        // Selection is retrieved when Display is clicked
    }

    @FXML
    private void select_volunteer_work() {
        // Selection is retrieved when Display is clicked
    }


    // Display Student Information
    @FXML
    private void display_student_info() {

        text_area.clear();

        // Student Information
        String name = name_field.getText().trim();
        String address = address_field.getText().trim();
        String city = city_field.getText().trim();
        String province = province_field.getText().trim();
        String postal = postal_field.getText().trim();
        String phone = phone_field.getText().trim();
        String email = email_field.getText().trim();

        // Required Fields
        if (name.isEmpty() || address.isEmpty() ||
                city.isEmpty() || province.isEmpty() ||
                postal.isEmpty() || phone.isEmpty() ||
                email.isEmpty()) {

            showError("All student information fields are required.");
            return;
        }

        // Postal Code
        if (!validPostal(postal)) {
            showError("Invalid postal code. Use format A1A 1A1.");
            return;
        }

        // Phone Number
        if (!validPhone(phone)) {
            showError("Phone number must contain exactly 10 digits.");
            return;
        }

        // Email
        if (!validEmail(email)) {
            showError("Please enter a valid email address.");
            return;
        }

        // Program
        String program = "";

        if (cs_class_button.isSelected()) {
            program = "Computer Science";

        } else if (business_class_button.isSelected()) {
            program = "Business";

        } else {
            showError("Please select a program.");
            return;
        }

        // Courses
        if (list_area.getItems().isEmpty()) {
            showError("Please select at least one course.");
            return;
        }

        String courses = String.join(
                ", ", list_area.getItems()
        );

        // Activities
        String activities = "";

        if (Student_council_button.isSelected()) {
            activities += "Student Council\n";
        }

        if (volunteer_work_button.isSelected()) {
            activities += "Volunteer Work\n";
        }

        if (activities.isEmpty()) {
            activities = "None\n";
        }

        // Output
        String output =
                "STUDENT INFORMATION\n" +
                        "----------------------------\n" +
                        "Name: " + name + "\n" +
                        "Address: " + address + "\n" +
                        "City: " + city + "\n" +
                        "Province: " + province + "\n" +
                        "Postal Code: " + postal.toUpperCase() + "\n" +
                        "Phone: " + phone + "\n" +
                        "Email: " + email + "\n\n" +

                        "PROGRAM INFORMATION\n" +
                        "----------------------------\n" +
                        "Program: " + program + "\n" +
                        "Courses: " + courses + "\n\n" +

                        "STUDENT ACTIVITIES\n" +
                        "----------------------------\n" +
                        activities;

        text_area.setText(output);
    }
}
