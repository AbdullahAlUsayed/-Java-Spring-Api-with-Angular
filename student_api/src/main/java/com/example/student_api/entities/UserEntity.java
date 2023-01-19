package com.example.student_api.entities;

import javax.persistence.*;

@Entity
@Table(name = "Usayed_Student_Info")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "gender")
    private String gender;

    public UserEntity(int id, String name, int age, String mobile, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mobile = mobile;
        this.gender = gender;
    }

    public UserEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
