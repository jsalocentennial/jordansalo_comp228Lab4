
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

    }

    // Major Selection
    @FXML
    private void select_class() {

    }

    // Course Selection
    @FXML
    private void display_class() {

    }

    // Activities
    @FXML
    private void select_student_council() {

    }

    @FXML
    private void select_volunteer_work() {

    }

    // Display Student Information
    @FXML
    private void display_student_info() {

    }
}
