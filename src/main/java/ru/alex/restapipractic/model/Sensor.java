package ru.alex.restapipractic.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sensor")
public class Sensor {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @OneToOne
    private DataWithSenor dataWithSenor;
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataWithSenor getDataWithSenor() {
        return dataWithSenor;
    }

    public void setDataWithSenor(DataWithSenor dataWithSenor) {
        this.dataWithSenor = dataWithSenor;
    }
}
