package lk.institute.controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.institute.entity.Course;
import lk.institute.util.hibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.fxml.FXMLLoader.load;

public class CouseContoller implements Initializable {
    @FXML
    private JFXTextField txtid;

    @FXML
    private JFXTextField txtcoursename;

    @FXML
    private JFXTextField txttype;

    @FXML
    private JFXTextField txtDuration;

    @FXML
    private JFXButton addbtn;



    @FXML
    private TableView<Course> CourseTbl;

    @FXML
    private Button Viewbutoon;

    public void AddCourse(ActionEvent actionEvent) {
        String id=txtid.getText();
        String courseName=txtcoursename.getText();
        String Ctype=txttype.getText();
        String time=txtDuration.getText();
        Course course=new Course(id,courseName,Ctype,time);
        SessionFactory sessionFactory= hibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction tx=session.beginTransaction();
        session.save(course);
        tx.commit();
        session.close();

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void Register1(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = load(this.getClass().getResource("../view/Register.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void Student1(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(this.getClass().getResource("../view/StudentRegister.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }




}

