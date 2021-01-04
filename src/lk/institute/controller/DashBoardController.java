package lk.institute.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lk.institute.entity.Registration;
import lk.institute.entity.Student;
import lk.institute.util.hibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.awt.*;
import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;

public class DashBoardController{

    public void moveStudent(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = load(this.getClass().getResource("../view/Couse.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void moveRegister(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = load(this.getClass().getResource("../view/Register.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    public void moveCourse(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = load(this.getClass().getResource("../view/RegisterStudent.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
