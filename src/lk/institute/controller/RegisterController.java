package lk.institute.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lk.institute.entity.Course;
import lk.institute.entity.Registration;
import lk.institute.entity.Student;
import lk.institute.util.hibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private JFXTextField regid;

    @FXML
    private JFXDatePicker regDate;

    @FXML
    private JFXTextField regFee;

    @FXML
    private JFXComboBox<String> Sid;

    @FXML
    private JFXComboBox<String> cid;

    @FXML
    private JFXButton AddRegDetsails;

    public void moveStudent(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(this.getClass().getResource("../view/Couse.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void moveCourse(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(this.getClass().getResource("../view/RegisterStudent.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void AddregDetails(javafx.event.ActionEvent actionEvent) {
        int id = Integer.parseInt(regid.getText());
        String date = regDate.getEditor().getText();
        double fee = Double.parseDouble(regFee.getText());
        String StuId = Sid.getSelectionModel().getSelectedItem();
        String Code = cid.getSelectionModel().getSelectedItem();

        Registration registration = new Registration(id, date, fee, StuId, Code);

        SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(registration);
        tx.commit();
        session.close();
        sessionFactory.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<String> sid = getCid();
        Sid.setItems(FXCollections.observableArrayList(sid));

        List<String> courseCode = getCode();
        cid.setItems(FXCollections.observableArrayList(courseCode));

    }

    private List<String> getCode() {
        SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Course> select_id_from_Course = session.createQuery("FROM lk.institute.entity.Course",Course.class).list();
        List<String> list = new ArrayList<>();
        for (Course course : select_id_from_Course) {
            list.add(course.getCode());
        }
        session.getTransaction().commit();
        session.close();
        return list;

    }

    private List<String> getCid() {
        SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<Student> select_id_from_student = session.createQuery("FROM lk.institute.entity.Student",Student.class).list();
        session.getTransaction().commit();
        List<String> list = new ArrayList<>();
        for (Student student : select_id_from_student) {
            list.add(student.getId());
        }
        session.close();
        return list;
    }
}
