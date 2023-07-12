package ru.alex.restapipractic.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DataWithSensorDTO {
    @Column
    @NotNull(message = "Value 'value' should be not null")
    @Size(min = -99, max = 99, message = "value should be minimum -99 and maximum 99")
    private float value;
    @Column
    @NotNull(message = "Value 'raining' shoud be not null")
    private boolean raining;

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
}
