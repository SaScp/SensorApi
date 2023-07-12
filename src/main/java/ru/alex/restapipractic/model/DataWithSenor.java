package ru.alex.restapipractic.model;

import jakarta.persistence.*;

@Entity
@Table(name = "data_with_sensor")
public class DataWithSenor {
    @Id
    private Integer id;
    @Column
    private float value;
    @Column
    private boolean raining;
    @OneToOne
    @JoinColumn(name = "sensor_id", referencedColumnName = "id")
    private Sensor sensor;
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
