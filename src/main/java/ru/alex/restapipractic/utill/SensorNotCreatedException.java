package ru.alex.restapipractic.utill;

public class SensorNotCreatedException extends RuntimeException{

    public SensorNotCreatedException(String messege){
        super(messege);
    }
}
