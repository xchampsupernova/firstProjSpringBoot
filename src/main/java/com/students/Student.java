package com.students;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_id_sequence",
            sequenceName = "student_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_id_sequence"
    )
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private String subject;
    private Double media;
    private Boolean isGrad;

    public Student() {
    }

    public Student(Integer id, String name, String surname, Integer age, String subject, Double media, Boolean isGrad) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.subject = subject;
        this.media = media;
        this.isGrad = isGrad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public Boolean getGrad() {
        return isGrad;
    }

    public void setGrad(Boolean grad) {
        isGrad = grad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(age, student.age) && Objects.equals(subject, student.subject) && Objects.equals(media, student.media) && Objects.equals(isGrad, student.isGrad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, age, subject, media, isGrad);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", subject='" + subject + '\'' +
                ", media=" + media +
                ", isGrad=" + isGrad +
                '}';
    }
}
