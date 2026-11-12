
package com.example.jordansalo_comp228lab4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentLauncher extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                StudentLauncher.class.getResource("/student_form.fxml")
        );

        Parent root = loader.load();

        Scene scene = new Scene(root, 600, 400);

        stage.setTitle("Student Form");
        stage.setScene(scene);
        stage.show();
    }
}
