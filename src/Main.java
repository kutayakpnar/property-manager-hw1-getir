public class Main {
    public static void main(String[] args) {
        PropertyManager propertyManager = new PropertyManager();

        // Print all properties
        System.out.println("=== Property Lists ===");
        System.out.println("Houses: " + propertyManager.getHouseList().size());
        System.out.println("Villas: " + propertyManager.getVillaList().size());
        System.out.println("Summer Houses: " + propertyManager.getSummerHouseList().size());

        // Print total prices
        System.out.println("\n=== Total Prices ===");
        System.out.println("Total House Price: $" + propertyManager.getTotalHousePrice());
        System.out.println("Total Villa Price: $" + propertyManager.getTotalVillaPrice());
        System.out.println("Total Summer House Price: $" + propertyManager.getTotalSummerHousePrice());
        System.out.println("Total Price of All Properties: $" + propertyManager.getTotalPrice());

        // Print average square meters
        System.out.println("\n=== Average Square Meters ===");
        System.out.println("Average House Square Meters: " + propertyManager.getAverageHouseSquareMeters());
        System.out.println("Average Villa Square Meters: " + propertyManager.getAverageVillaSquareMeters());
        System.out.println("Average Summer House Square Meters: " + propertyManager.getAverageSummerHouseSquareMeters());
        System.out.println("Average Square Meters of All Properties: " + propertyManager.getAverageSquareMeters());

        // Filter properties by room and living room count
        System.out.println("\n=== Filtered Properties (3 rooms, 1 living room) ===");
        propertyManager.filterPropertiesByRoomAndLivingRoom(3, 1).forEach(property -> {
            System.out.println("Property Type: " + property.getClass().getSimpleName());
            System.out.println("Price: $" + property.getPrice());
            System.out.println("Square Meters: " + property.getSquareMeters());
            System.out.println("Number of Rooms: " + property.getNumberOfRooms());
            System.out.println("Number of Living Rooms: " + property.getNumberOfLivingRooms());
            System.out.println("---");
        });
    }
} 