package com.example.vaccineManagementSystem.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table
@Data
public class Dose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String doseId;

    @CreationTimestamp
    private Date creationDate;

    @OneToOne
    @JoinColumn
    private User user;

    public Dose() {
    }

    public Dose(int id, String doseId, Date creationDate, User user) {
        this.id = id;
        this.doseId = doseId;
        this.creationDate = creationDate;
        this.user = user;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getDoseId() {
//        return doseId;
//    }
//
//    public void setDoseId(String doseId) {
//        this.doseId = doseId;
//    }
//
//    public Date getCreationDate() {
//        return creationDate;
//    }
//
//    public void setCreationDate(Date creationDate) {
//        this.creationDate = creationDate;
//    }
}
