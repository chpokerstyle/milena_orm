package com.example.orm.entity;

import com.example.orm.Column;
import com.example.orm.Join;
import com.example.orm.Table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;

@Table(name = "person")
public class User {

    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "points")
    private Long points;

    @Column(name = "good_mode")
    private Boolean goodMode;

    @Join
    List<Car> cars = new ArrayList<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public Boolean getGoodMode() {
        return goodMode;
    }

    public void setGoodMode(Boolean goodMode) {
        this.goodMode = goodMode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
