package ru.alex.restapipractic.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "data_with_sensor")
public class DataWithSensor {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    @NotNull(message = "Value 'value' should be not null")
    @DecimalMin(value = "-99", message = "value should be minimum -99")
    @DecimalMax(value = "99", message = "value shouldn t be bigger 99")
    private float value;
    @Column
    @NotNull(message = "Value 'raining' shoud be not null")
    private boolean raining;
    @Column
    private LocalDateTime time;

    @ManyToOne(cascade ={CascadeType.PERSIST,CascadeType.REMOVE, CascadeType.REFRESH})
    @JoinColumn(name = "sensor_id", referencedColumnName = "id")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
