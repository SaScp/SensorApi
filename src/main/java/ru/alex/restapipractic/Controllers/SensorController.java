package ru.alex.restapipractic.Controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.alex.restapipractic.dto.SensorDTO;
import ru.alex.restapipractic.model.Sensor;
import ru.alex.restapipractic.service.SensorService;
import ru.alex.restapipractic.utill.ErrorResponse;
import ru.alex.restapipractic.utill.SensorNotCreatedException;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/sensors")
public class SensorController {
    private final SensorService service;
    private final ModelMapper modelMapper;

    public SensorController(SensorService service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> registrationSesnor(@RequestBody @Valid SensorDTO sensorDTO,
                                                         BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            StringBuilder builder = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (var i : errors){
                builder.append(i.getField())
                        .append("-")
                        .append(i.getDefaultMessage())
                        .append(";");
            }
            throw new SensorNotCreatedException(builder.toString());
        }
        if(service.findByName(sensorDTO.getName())!=null) {
            throw new SensorNotCreatedException("There is already such a sensor");
        }

        service.save(convertSensorDTOToSensor(sensorDTO));

        return  ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/")
    public List<SensorDTO> showAllSensor() {

        return service.findAll().stream().map(this::convertSensorToSensorDTO).toList();
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handlEx(SensorNotCreatedException ex) {
       ErrorResponse response = new ErrorResponse(
               ex.getMessage(),
               LocalDateTime.now()
       );

       return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private SensorDTO convertSensorToSensorDTO(Sensor sensor) {
        return modelMapper.map(sensor, SensorDTO.class);
    }

    private Sensor convertSensorDTOToSensor(SensorDTO sensorDTO) {
        return modelMapper.map(sensorDTO, Sensor.class);
    }
}

