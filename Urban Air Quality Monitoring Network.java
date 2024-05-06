import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Enum to represent air quality levels
enum AirQualityLevel {
    EXCELLENT,
    GOOD,
    MODERATE,
    UNHEALTHY,
    VERY_UNHEALTHY,
    HAZARDOUS
}

// Class to represent air quality data for a location
class AirQualityData {
    private double pm25; // Particulate Matter (PM2.5) concentration in micrograms per cubic meter
    private double pm10; // Particulate Matter (PM10) concentration in micrograms per cubic meter
    private double no2; // Nitrogen Dioxide (NO2) concentration in parts per billion
    private double co;  // Carbon Monoxide (CO) concentration in parts per million
    private double o3;  // Ozone (O3) concentration in parts per billion

    public AirQualityData(double pm25, double pm10, double no2, double co, double o3) {
        this.pm25 = pm25;
        this.pm10 = pm10;
        this.no2 = no2;
        this.co = co;
        this.o3 = o3;
    }

    // Getters
    public double getPm25() {
        return pm25;
    }

    public double getPm10() {
        return pm10;
    }

    public double getNo2() {
        return no2;
    }

    public double getCo() {
        return co;
    }

    public double getO3() {
        return o3;
    }
}

// Class to represent the urban air quality monitoring network
public class UrbanAirQualityMonitoringNetwork {
    private Map<String, AirQualityData> dataMap; // Map of locations to air quality data

    public UrbanAirQualityMonitoringNetwork() {
        this.dataMap = new HashMap<>();
        // Initialize with dummy data for demonstration purposes
        dataMap.put("Location1", new AirQualityData(10.5, 20.3, 15.7, 0.5, 25.2));
        dataMap.put("Location2", new AirQualityData(8.9, 18.7, 13.2, 0.3, 21.8));
        // Add more locations and corresponding air quality data as needed
    }

    // Method to get air quality data for a specific location
    public AirQualityData getAirQualityData(String location) {
        return dataMap.get(location);
    }

    // Method to determine the overall air quality level based on air quality data
    public AirQualityLevel determineAirQualityLevel(AirQualityData airQualityData) {
        // For demonstration purposes, let's assume a simple algorithm based on PM2.5 concentration
        double pm25 = airQualityData.getPm25();
        if (pm25 <= 12) {
            return AirQualityLevel.EXCELLENT;
        } else if (pm25 <= 35.4) {
            return AirQualityLevel.GOOD;
        } else if (pm25 <= 55.4) {
            return AirQualityLevel.MODERATE;
        } else if (pm25 <= 150.4) {
            return AirQualityLevel.UNHEALTHY;
        } else if (pm25 <= 250.4) {
            return AirQualityLevel.VERY_UNHEALTHY;
        } else {
            return AirQualityLevel.HAZARDOUS;
        }
    }

    public static void main(String[] args) {
        UrbanAirQualityMonitoringNetwork monitoringNetwork = new UrbanAirQualityMonitoringNetwork();
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a location
        System.out.print("Enter the location for air quality monitoring: ");
        String location = scanner.nextLine();

        // Get air quality data for the entered location
        AirQualityData airQualityData = monitoringNetwork.getAirQualityData(location);
        if (airQualityData != null) {
            // Determine the overall air quality level
            AirQualityLevel airQualityLevel = monitoringNetwork.determineAirQualityLevel(airQualityData);
            System.out.println("Air Quality Level for " + location + ": " + airQualityLevel);
        } else {
            System.out.println("Air quality data not available for the entered location.");
        }

        scanner.close();
    }
}
