package ru.alex.restapipractic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alex.restapipractic.model.Sensor;
@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {
}
