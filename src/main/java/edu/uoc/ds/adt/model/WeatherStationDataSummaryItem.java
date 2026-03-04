package edu.uoc.ds.adt.model;

public class WeatherStationDataSummaryItem {

    private final int year;
    private final int numRows;
    private final double accumulatedPrecipitation;
    private final double meanAvgAirTemperature;

    public WeatherStationDataSummaryItem(int year,
            int numRows,
            double accumulatedPrecipitation,
            double meanAvgAirTemperature) {
        this.year = year;
        this.numRows = numRows;
        this.accumulatedPrecipitation = accumulatedPrecipitation;
        this.meanAvgAirTemperature = meanAvgAirTemperature;
    }

    public int getYear() {
        return year;
    }

    public int numRows() {
        return numRows;
    }

    public double getAccumulatedPrecipitation() {
        return accumulatedPrecipitation;
    }

    public double getMeanAvgAirTemperature() {
        return meanAvgAirTemperature;
    }

    @Override
    public String toString() {
        return "WeatherStationDataSummaryItem{year=" + year +
                ", numRows=" + numRows +
                ", accPrecip=" + accumulatedPrecipitation +
                ", meanTemp=" + meanAvgAirTemperature +
                '}';
    }
}
