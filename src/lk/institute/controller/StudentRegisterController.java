package lk.institute.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import lk.institute.entity.Student;
import lk.institute.util.hibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.awt.event.ActionEvent;
import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;

public class StudentRegisterController {

    @FXML
    private JFXTextField txtid;

    @FXML
    private JFXTextField txtname;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXDatePicker txtdob;

    @FXML
    private JFXTextField txtGender;

    @FXML
    private JFXButton addbtn;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;



    public void Addstudent(javafx.event.ActionEvent actionEvent) {
        String id=txtid.getText();
        String name=txtname.getText();
        String address=txtAddress.getText();
        String contact=txtContact.getText();
        String date=txtdob.getEditor().getText();
        String gender=txtGender.getText();

        Student student=new Student(id,name,address,contact,date,gender);

        SessionFactory sessionFactory= hibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction tx=session.beginTransaction();
        session.save(student);
        tx.commit();

        session.close();



    }

    public void Register1(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = load(this.getClass().getResource("../view/Register.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    public void Student1(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(this.getClass().getResource("../view/RegisterStudent.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }


}
