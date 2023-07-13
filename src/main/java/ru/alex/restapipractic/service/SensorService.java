package ru.alex.restapipractic.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alex.restapipractic.model.Sensor;
import ru.alex.restapipractic.repository.SensorRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SensorService {

    private final SensorRepository sensorRepository;

    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public List<Sensor> findAll(){
        return sensorRepository.findAll();
    }
@Transactional
    public void save(Sensor sensor){
        sensorRepository.save(sensor);
    }

   public Sensor findByName(String name){
        return sensorRepository.findByName(name).orElse(null);
    }
}
