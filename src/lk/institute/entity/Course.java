package lk.institute.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    private  String code;
    private String  courseName;
    private String courseType;
    private String duration;

    @OneToMany(mappedBy = "course" ,cascade = CascadeType.ALL)
    List<Registration>Register=new ArrayList<>();



    public Course() {
    }

    public Course(String code, String courseName, String courseType, String duration) {
        this.code = code;
        this.courseName = courseName;
        this.courseType = courseType;
        this.duration = duration;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return this.code;
    }
}
