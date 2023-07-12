package ru.alex.restapipractic.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alex.restapipractic.model.DataWithSenor;
@Repository
public interface DataWithSensorRepository extends JpaRepository<DataWithSenor, Integer> {
}
