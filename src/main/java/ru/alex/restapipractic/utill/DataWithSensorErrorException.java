package ru.alex.restapipractic.utill;

public class DataWithSensorErrorException extends RuntimeException{

    public DataWithSensorErrorException(String message){
       super(message);
    }
}
