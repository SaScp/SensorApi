package ru.alex.restclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * Hello world!
 *
 */
// Open in other project!
public class App 
{
    private static final String url = "http://localhost:8080/measurements/add";
    private static final String getUrl = "http://localhost:8080/measurements/";
   private static final RestTemplate restTemplate = new RestTemplate();

    public static void main( String[] args ) throws JsonProcessingException {
        addNewRandomData(false); //TODO не сохраняет в бд везде!
        DataWithSensor[] data = getDate();

        for (int i = 0; i < 40; i++) {
            System.out.println(data[i]);
        }
    }

    public static void addNewRandomData(boolean b) {
        if(b) {
            for (int i = 0; i < 2; i++) {
                Map<String, String> jsonData = new HashMap<>();
                try {
                    Double random = new Random().nextDouble(-99, 99);
                    Boolean randomRaining = new Random().nextBoolean();
                    DataWithSensor data = new DataWithSensor();
                    data.setValue(random);
                    data.setRaining(randomRaining);
                    Sensor sensor = new Sensor();
                    sensor.setName("sensor3");
                    data.setSensor(sensor);
                    HttpEntity<DataWithSensor> mapHttpEntity = new HttpEntity<>(data);

                    DataWithSensor data1 = restTemplate.postForObject(url, mapHttpEntity, DataWithSensor.class);
                } catch (Exception e) {
                    continue;
                }
            }
        }
    }

    public static DataWithSensor[] getDate(){
        DataWithSensor[] data = restTemplate.getForObject(getUrl, DataWithSensor[].class);
        return data;
    }

}
