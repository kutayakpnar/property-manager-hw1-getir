import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PropertyManager {
    private List<House> houses;
    private List<Villa> villas;
    private List<SummerHouse> summerHouses;

    public PropertyManager() {
        this.houses = new ArrayList<>();
        this.villas = new ArrayList<>();
        this.summerHouses = new ArrayList<>();
        initializeProperties();
    }

    private void initializeProperties() {
        // Initialize houses
        houses.add(new House(500000, 120, 3, 1));
        houses.add(new House(750000, 150, 4, 2));
        houses.add(new House(600000, 130, 3, 1));

        // Initialize villas
        villas.add(new Villa(1500000, 250, 5, 2));
        villas.add(new Villa(2000000, 300, 6, 3));
        villas.add(new Villa(1800000, 280, 5, 2));

        // Initialize summer houses
        summerHouses.add(new SummerHouse(800000, 180, 4, 1));
        summerHouses.add(new SummerHouse(1000000, 200, 4, 2));
        summerHouses.add(new SummerHouse(900000, 190, 4, 1));
    }

    public List<House> getHouseList() {
        return houses;
    }

    public List<Villa> getVillaList() {
        return villas;
    }

    public List<SummerHouse> getSummerHouseList() {
        return summerHouses;
    }

    public double getTotalHousePrice() {
        return houses.stream().mapToDouble(House::getPrice).sum();
    }

    public double getTotalVillaPrice() {
        return villas.stream().mapToDouble(Villa::getPrice).sum();
    }

    public double getTotalSummerHousePrice() {
        return summerHouses.stream().mapToDouble(SummerHouse::getPrice).sum();
    }

    public double getTotalPrice() {
        return getTotalHousePrice() + getTotalVillaPrice() + getTotalSummerHousePrice();
    }

    public double getAverageHouseSquareMeters() {
        return houses.stream().mapToDouble(House::getSquareMeters).average().orElse(0.0);
    }

    public double getAverageVillaSquareMeters() {
        return villas.stream().mapToDouble(Villa::getSquareMeters).average().orElse(0.0);
    }

    public double getAverageSummerHouseSquareMeters() {
        return summerHouses.stream().mapToDouble(SummerHouse::getSquareMeters).average().orElse(0.0);
    }

    public double getAverageSquareMeters() {
        List<Property> allProperties = new ArrayList<>();
        allProperties.addAll(houses);
        allProperties.addAll(villas);
        allProperties.addAll(summerHouses);
        return allProperties.stream().mapToDouble(Property::getSquareMeters).average().orElse(0.0);
    }

    public List<Property> filterPropertiesByRoomAndLivingRoom(int numberOfRooms, int numberOfLivingRooms) {
        List<Property> allProperties = new ArrayList<>();
        allProperties.addAll(houses);
        allProperties.addAll(villas);
        allProperties.addAll(summerHouses);
        
        return allProperties.stream()
                .filter(p -> p.getNumberOfRooms() == numberOfRooms && p.getNumberOfLivingRooms() == numberOfLivingRooms)
                .collect(Collectors.toList());
    }
} 