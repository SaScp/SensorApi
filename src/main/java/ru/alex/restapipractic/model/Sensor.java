package ru.alex.restapipractic.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "sensor")
public class Sensor {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    @NotNull(message = "Value 'name' shoud be not null")
    @Size(min = 3, max = 30, message = "name should be minimum 3 and maximum 30")
    private String name;
    @OneToMany(mappedBy = "sensor")
    private List<DataWithSensor> dataWithSenor;

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

    public List<DataWithSensor> getDataWithSenor() {
        return dataWithSenor;
    }

    public void setDataWithSenor(List<DataWithSensor> dataWithSenor) {
        this.dataWithSenor = dataWithSenor;
    }
}
