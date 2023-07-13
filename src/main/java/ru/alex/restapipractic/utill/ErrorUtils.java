package ru.alex.restapipractic.utill;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

public class ErrorUtils {
    public static void returnErrorsDataWithSensorToClient(BindingResult bindingResult){
        StringBuilder builder = new StringBuilder( );
        List<FieldError> errors = bindingResult.getFieldErrors();
        for (var i : errors){
            builder.append(i.getField())
                    .append("-")
                    .append(i.getDefaultMessage())
                    .append(";");
        }
        throw new DataWithSensorErrorException(builder.toString());
        }
    public static void returnErrorsSensorToClient(BindingResult bindingResult){
        StringBuilder builder = new StringBuilder( );
        List<FieldError> errors = bindingResult.getFieldErrors();
        for (var i : errors){
            builder.append(i.getField())
                    .append("-")
                    .append(i.getDefaultMessage())
                    .append(";");
        }
        throw new SensorNotCreatedException(builder.toString());
    }
    }

