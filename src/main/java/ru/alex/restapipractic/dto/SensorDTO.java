package ru.alex.restapipractic.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SensorDTO {
    @Column
    @NotNull(message = "Value 'name' shoud be not null")
    @Size(min = 3, max = 30, message = "name should be minimum 3 and maximum 30")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
