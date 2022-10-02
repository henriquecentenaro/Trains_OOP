import java.util.ArrayList;
import java.util.List;

public class Garage {

    private final List<Vehicle> vehicles;
    private final List<Train> trains;

    /**
     * It constructs a new garage.
     */
    public Garage() {
        vehicles = new ArrayList<>();
        trains = new ArrayList<>();
    }

    /**
     * It adds a vehicle to the garage.
     * @param vehicle the vehicle to be added
     */
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void addTrain(Train t) {
        trains.add(t);
    }

    public boolean hasTrain(int id) {
        for (Train t : trains) {
            if (t.getId() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * It checks if there's a specific vehicle in garage.
     * @param id the vehicle ID
     * @return true if there's the specific vehicle; false if there isn't
     */
    public boolean hasVehicleInGarage(int id) {
        for (Vehicle vehicle : vehicles) {
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
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() == id) {
                return vehicle;
            }
        }
        return null;
    }

    public Train getTrainById(int id) {
        for (Train t : trains) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    /**
     * It removes a vehicle from garage.
     * @param id the vehicle to be removed
     */
    public Vehicle removeFromGarage(int id) {
        Vehicle vehicle = getById(id);
        if (vehicle != null) {
            vehicles.remove(vehicle);
            return vehicle;
        }
        return null;
    }

    public Train removeTrain(int id) {
        Train t = getTrainById(id);
        if (t != null) {
            trains.remove(t);
            return t;
        }
        return null;
    }

    public String listTrains() {
        String aux = "Trains in yard:\n\n";
        for (Train t : trains) {
            aux += t.toString() + "\n";
        }
        return aux;
    }

    public String listLocomotives() {
        String aux = "Locomotives in garage:\n\n";
        for (Vehicle v : vehicles) {
            if (v instanceof Locomotive) {
                Locomotive l = (Locomotive) v;
                aux += l.toString() + "\n";
            }
        }
        return aux;
    }

    public String listTrainCars() {
        String aux = "Train cars in garage:\n\n";
        for (Vehicle v : vehicles) {
            if (v instanceof TrainCar) {
                TrainCar tc = (TrainCar) v;
                aux += tc.toString() + "\n";
            }
        }
        return aux;
    }

    public String listPassengerTrain() {
        String aux = "Passenger Trains in garage:\n\n";
        for (Vehicle v : vehicles) {
            if (v instanceof PassengerTrain) {
                aux += v + "\n";
            }
        }
        return aux;
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