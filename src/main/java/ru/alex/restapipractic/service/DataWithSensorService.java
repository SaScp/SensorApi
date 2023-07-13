package ru.alex.restapipractic.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alex.restapipractic.dto.DataWithSensorDTO;
import ru.alex.restapipractic.dto.SensorDTO;
import ru.alex.restapipractic.model.DataWithSensor;
import ru.alex.restapipractic.repository.DataWithSensorRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class DataWithSensorService {
    private final DataWithSensorRepository dataWithSensorRepository;
    private final SensorService service;
    public DataWithSensorService(DataWithSensorRepository dataWithSensorRepository, SensorService service) {
        this.dataWithSensorRepository = dataWithSensorRepository;
        this.service = service;
    }

    public long findCountDayWithRain(){
       return dataWithSensorRepository
               .findAll()
               .stream()
               .filter(dataWithSenor -> dataWithSenor.isRaining() == true).count();
    }
    public List<DataWithSensor> findAll(){
        return dataWithSensorRepository.findAll();
    }
    @Transactional
    public void save(DataWithSensor dataWithSensor){
        dataWithSensor.setSensor(service.findByName(dataWithSensor.getSensor().getName()));
        dataWithSensor.setTime(LocalDateTime.now());
        dataWithSensorRepository.save(dataWithSensor);
    }

}
