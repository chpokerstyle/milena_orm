package com.example.orm.entity;

import com.example.orm.Column;


public class Car {

    @Column(name = "id")
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "kw")
    private String kw;

    @Column(name = "holder_id")
    private Long holderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getKw() {
        return kw;
    }

    public void setKw(String kw) {
        this.kw = kw;
    }

    public Long getHolderId() {
        return holderId;
    }

    public void setHolderId(Long holderId) {
        this.holderId = holderId;
    }
}
