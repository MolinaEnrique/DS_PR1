package edu.uoc.ds.adt;

import edu.uoc.ds.adt.model.WeatherStationData;
import edu.uoc.ds.adt.model.WeatherStationDataSummaryItem;
import edu.uoc.ds.adt.sequential.Queue;
import edu.uoc.ds.adt.sequential.QueueArrayImpl;
import edu.uoc.ds.traversal.Iterator;

public class PR1WeatherStationDataQueue {

    // Capacidad máxima de la cola.
    public final int CAPACITY;

    // Años para los que se generan resúmenes.
    private final int[] years;

    // Cola interna de DSLib.
    private Queue<WeatherStationData> pr1q;

    // Constructor
    public PR1WeatherStationDataQueue(int capacity, int[] years) {
        this.CAPACITY = capacity;
        this.years = years;
        this.pr1q = new QueueArrayImpl<>(capacity);
    }

    // Devuelve los años de interés para los resúmenes anuales.
    public int[] getYears() {
        return years;
    }

    // Añade un registro meteorológico al final de la cola.
    public void add(WeatherStationData weatherData) {
        pr1q.add(weatherData);
    }

    // Devuelve la cola interna (sin extraer elementos).
    public Queue<WeatherStationData> getQueue() {
        return pr1q;
    }

    // Media de precipitación, o 0 si la cola está vacía
    public double getMeanPrecipitation() {
        if (pr1q.isEmpty())
            return 0.0;
        double sum = 0.0;
        int cnt = 0;
        Iterator<WeatherStationData> it = pr1q.values();
        while (it.hasNext()) {
            sum += it.next().getPrecipitation();
            cnt++;
        }
        return sum / cnt;
    }

    // Media de avgAirTemperature , o 0 si la cola está vacía
    public double getMeanAvgAirTemperature() {
        if (pr1q.isEmpty())
            return 0.0;
        double sum = 0.0;
        int cnt = 0;
        Iterator<WeatherStationData> it = pr1q.values();
        while (it.hasNext()) {
            sum += it.next().getAvgAirTemperature();
            cnt++;
        }
        return sum / cnt;
    }

    // Devuelve el resumen para el año indicado
    public WeatherStationDataSummaryItem getWeatherStationDataSumaryItem(int year) {
        int count = 0;
        double accPrecip = 0.0;
        double sumAvgTemp = 0.0;

        Iterator<WeatherStationData> it = pr1q.values();
        while (it.hasNext()) {
            WeatherStationData d = it.next();
            if (d.getLastUpdated().getYear() == year) {
                count++;
                accPrecip += d.getPrecipitation();
                sumAvgTemp += d.getAvgAirTemperature();
            }
        }

        if (count == 0)
            return null;

        return new WeatherStationDataSummaryItem(year, count, accPrecip, sumAvgTemp / count);
    }
}
