package lk.institute.entity;

import javax.persistence.*;

@Entity
public class Registration {
    @Id
    private int regNo;
    private String regDate;
    private double regFee;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "StudentId" ,referencedColumnName = "id")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseID",referencedColumnName = "code")
    private Course course;


    public String getSid() {
        return Sid;
    }

    public void setSid(String sid) {
        Sid = sid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Registration(int regNo, String regDate, double regFee, String sid, String code) {
        this.regNo = regNo;
        this.regDate = regDate;
        this.regFee = regFee;
        Sid = sid;
        this.code = code;
    }

    private  String Sid;
    private String code;





    public Registration() {
    }

    public Registration(int regNo, String regDate, double regFee) {
        this.regNo = regNo;
        this.regDate = regDate;
        this.regFee = regFee;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public double getRegFee() {
        return regFee;
    }

    public void setRegFee(double regFee) {
        this.regFee = regFee;
    }
}

