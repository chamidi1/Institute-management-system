package lk.institute.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Student {
    @Id
    private String id;
    private String studentname;
    private String Address;
    private  String Contact;
    private String  dob;
    private String Gender;

    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "student")
    List<Registration>registrations=new ArrayList<>();


    public Student() {
    }

    public Student(String id, String studentname, String address, String contact, String dob, String gender) {
        this.id = id;
        this.studentname = studentname;
        Address = address;
        Contact = contact;
        this.dob = dob;
        Gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    @Override
    public String toString() {
        return this.id;
    }
}
