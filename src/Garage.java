import java.util.ArrayList;
import java.util.List;

public class Garage {

    private final List<Vehicle> vehicles;

    /**
     * It constructs a new garage.
     */
    public Garage() {
        vehicles = new ArrayList<>();
    }

    /**
     * Add a vehicle to the garage.
     * @param vehicle the vehicle to be added
     */
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    /**
     * It checks if there's a specific vehicle in garage.
     * @param id the vehicle ID
     * @return true if there's the specific vehicle; false if there isn't
     */
    public boolean hasVehicleInGarage(int id) {
        for (Vehicle vehicle: vehicles) {
            if (vehicle.getId() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * It gets a vehicle from a specified ID.
     * @param id the vehicle ID whose vehicle instance it belongs
     * @return the vehicle instance
     */
    public Vehicle getById(int id) {
        for (Vehicle vehicle: vehicles) {
            if (vehicle.getId() == id) {
                return vehicle;
            }
        }
        return null;
    }

    /**
     * It selects a vehicle to be attached to train.
     * @param id the vehicle to be moved
     */
    public Vehicle removeFromGarage(int id) {
        Vehicle vehicle = getById(id);
        if (vehicle != null) {
            vehicles.remove(vehicle);
            return vehicle;
        }
        return null;
    }

    @Override
    public String toString() {
        String aux = "Vehicles in garage:\n\n";
        for (Vehicle vehicle : vehicles) {
            aux += vehicle.toString() + "\n";
        }
        return aux;
    }
}
