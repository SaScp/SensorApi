package ru.alex.restapipractic.dto;

import jakarta.validation.constraints.*;

public class DataWithSensorDTO {
    @NotNull(message = "Value 'value' should be not null")
    @DecimalMin(value = "-99", message = "value should be minimum -99")
    @DecimalMax(value = "99", message = "value shouldn t be bigger 99")
    private float value;
    @NotNull(message = "Value 'raining' shoud be not null")
    private boolean raining;
    @NotNull(message = "Value 'sensor' shoud be not null")
    private SensorDTO sensor;

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

    public SensorDTO getSensor() {
        return sensor;
    }

    public void setSensor(SensorDTO sensor) {
        this.sensor = sensor;
    }
}
