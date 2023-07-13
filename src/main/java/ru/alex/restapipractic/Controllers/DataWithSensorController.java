package ru.alex.restapipractic.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.alex.restapipractic.dto.SensorDTO;
import ru.alex.restapipractic.model.DataWithSensor;
import ru.alex.restapipractic.service.DataWithSensorService;
import ru.alex.restapipractic.service.SensorService;
import ru.alex.restapipractic.utill.DataWithSensorErrorException;
import ru.alex.restapipractic.utill.ErrorResponse;
import ru.alex.restapipractic.dto.DataWithSensorDTO;
import ru.alex.restapipractic.utill.SensorNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/measurements")
public class DataWithSensorController {
    private final ModelMapper modelMapper;
    private final DataWithSensorService data;
    private final SensorService service;
    public DataWithSensorController(ModelMapper modelMapper, DataWithSensorService data, SensorService service) {
        this.modelMapper = modelMapper;
        this.data = data;
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addData(@RequestBody DataWithSensorDTO dataWithSenorDTO,
                                              BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            StringBuilder builder = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (var i : errors){
                builder.append(i.getField())
                        .append("-")
                        .append(i.getDefaultMessage())
                        .append(";");
            }
            throw new DataWithSensorErrorException(builder.toString());
        }

        if(service.findByName(dataWithSenorDTO.getSensor().getName()) == null){
            throw new SensorNotFoundException();
        }

        data.save(convertDataWithSensorDTOToDataWithSensor(dataWithSenorDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/")
    public List<DataWithSensorDTO> findAll(){
        return  data.findAll().stream().map(this::convertDataWithSensorToDataWithSensorDTO).collect(Collectors.toList());
    }

    @GetMapping("/rainyDaysCount")
    public long findAllDayWithRain(){
        return data.findCountDayWithRain();
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handlEx(DataWithSensorErrorException ex) {
        ErrorResponse response = new ErrorResponse(
                ex.getMessage(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handlEx(SensorNotFoundException ex) {
        ErrorResponse response = new ErrorResponse(
                "Sensor Not Found",
                LocalDateTime.now()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private DataWithSensorDTO convertDataWithSensorToDataWithSensorDTO(DataWithSensor dataWithSensor){
        DataWithSensorDTO dto = modelMapper.map(dataWithSensor, DataWithSensorDTO.class);

        dto.setSensor(modelMapper.map(dataWithSensor.getSensor(), SensorDTO.class));

        return  dto;
    }

    private DataWithSensor convertDataWithSensorDTOToDataWithSensor(DataWithSensorDTO dataWithSensorDTO){
        return modelMapper.map(dataWithSensorDTO, DataWithSensor.class);
    }

}
