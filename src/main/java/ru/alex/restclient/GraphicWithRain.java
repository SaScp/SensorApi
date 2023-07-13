package ru.alex.restclient;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class GraphicWithRain {
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final String url = "http://localhost:8080/measurements/rainyDaysCount";

    public static void main(String[] args) throws IOException {
        System.out.println(getRainDay());
        double[] yData = new double[(int) getRainDay()];
        for (int i = 0; i < getRainDay(); i++) {
            yData[i] = i;
        }
        double[] xData = new double[(int) getRainDay()];
        for (int i = 0; i < (int) getRainDay(); i++) {
            xData[i] = i;
        }
// Create Chart
        XYChart chart = QuickChart.getChart("Sample Chart", "X", "Y", "y(x)", xData, yData);

// Show it
        new SwingWrapper(chart).displayChart();

// Save it
        BitmapEncoder.saveBitmap(chart, "./Sample_Chart", BitmapEncoder.BitmapFormat.PNG);

// or save it in high-res
        BitmapEncoder.saveBitmapWithDPI(chart, "./Sample_Chart_300_DPI", BitmapEncoder.BitmapFormat.PNG, 300);
    }

    public static long getRainDay(){
        return restTemplate.getForObject(url, Long.class);
    }
}
