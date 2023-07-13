package ru.alex.restapipractic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alex.restapipractic.model.DataWithSensor;
@Repository
public interface DataWithSensorRepository extends JpaRepository<DataWithSensor, Integer> {

}
