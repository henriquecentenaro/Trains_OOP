import java.util.List;
import java.util.ArrayList;

public class Train {
    private int id;
    // private ArrayList<TrainCar> trainCarsInTrain;
    // private ArrayList<Locomotive> locomotivesInTrain;
    private final List<Vehicle> composition;
    private int maxTrainCarsTrainCanPull;
    private double maxWeightTrainCanPull;

    /**
     * It constructs a new train with a specified ID
     */
    public Train(int id) {
        composition = new ArrayList<>();
        this.id = id;
        // trainCarsInTrain = new ArrayList<>(); // It stores train cars.
        // locomotivesInTrain = new ArrayList<>(); // It stores locomotives.
        maxTrainCarsTrainCanPull = 0;
        maxWeightTrainCanPull = 0;
    }

    /**
     * It gets the train ID.
     * @return the train ID
     */
    public int getTrainId() {
        return id;
    }

    /**
     * It gets how many locomotives are attached to a train.
     * @return the quantity of locomotives
     */
    public int getLocomotiveQuantity() {
        int counter = 0;
        for (Vehicle vehicle : composition) {
            if (vehicle instanceof Locomotive)
                counter++;
        }
        return counter;
    }

    /**
     * It gets how many train cars are attached to a train.
     * @return the quantity of train cars
     */
    public int getTrainCarQuantity() {
        int counter = 0;
        for (Vehicle vehicle : composition) {
            if (vehicle instanceof TrainCar)
                counter++;
        }
        return counter;
    }

    /**
     * It attaches a locomotive to a train.
     * @param locomotive the locomotive to be attached
     * @return true if you can attach the locomotive; false if you can't
     */
    public boolean attachLocomotive(Locomotive locomotive) {
        if (getTrainCarQuantity() == 0) {
            if (getLocomotiveQuantity() == 0) {
                composition.add(locomotive);
                maxWeightTrainCanPull = locomotive.getMaxWeight();
                maxTrainCarsTrainCanPull = locomotive.getMaxQuantityTrainCar();
                return true;
            } else {
                composition.add(locomotive);
                setMaxWeightTrainCanPull();
                return true;
            }
        } else {
            return false;
        }
    }

    /**
     * It attaches a train car to a train.
     * @param trainCar the train car to be attached
     * @return true if you can attach the train car; false if you can't
     */
    public boolean attachTrainCar(TrainCar trainCar) {
        double maxWeight = 0.0;
        for (Vehicle vehicle : composition) {
            if (vehicle instanceof TrainCar vehicleTrainCar)
            maxWeight += vehicleTrainCar.getLoadCapacity();
        }
        maxWeight += trainCar.getLoadCapacity();

        if (getTrainCarQuantity() < maxTrainCarsTrainCanPull && !(maxWeight > maxWeightTrainCanPull)) {
            composition.add(trainCar);
            return true;
        } else {
            return false;
        }
    }

    /**
     * It detaches a locomotive.
     * @return true if you can detach the locomotive; false if you can't
     */
    public boolean detachLocomotive() {
        if (getTrainCarQuantity() == 0) {
            if (getTrainCarQuantity() == 0) {
                return false;
            } else {
                composition.remove(composition.size() - 1);
                return true;
            }
        } else {
         return false;
        }
    }

    /**
     * It detaches a train car.
     * @return true if you can't detach; false if you can't
     */
    public boolean detachTrainCar() {
        if (getTrainCarQuantity() == 0) {
            return false;
        } else {
            composition.remove(composition.size() - 1);
            return true;
        }
    }

    /**
     * It gets the last locomotive attached to a train.
     * @param train the train you want to get the locomotive from
     * @return the locomotive
     */
    public Locomotive getLastLocomotiveFromTrain(Train train) {
        Vehicle vehicle = composition.get(getLocomotiveQuantity() - 1);
        if (vehicle instanceof Locomotive locomotive)
            return locomotive;
        else
            return null;
    }

    /** It gets the last train car attached to a train.
     * @param train the train you want to get the train car from
     * @return the train car
     */
    public TrainCar getLastTrainCarFromTrain(Train train) {
        TrainCar trainCar = null;

        for (Vehicle vehicle: composition){
            if (vehicle instanceof TrainCar)
                trainCar = (TrainCar) vehicle;
        }

        return trainCar;
    }

    /**
     * It sets the max weight and the max train cars a train can pull.
     */
    public void setMaxWeightTrainCanPull() {
        double weight = 0;
        int trainCars = 0;
        double tx = 0.9;
        for (Vehicle vehicle : composition) {
            if (composition instanceof Locomotive locomotive) {
                weight += locomotive.getMaxWeight();
                trainCars += locomotive.getMaxQuantityTrainCar();
            }
        }
        maxWeightTrainCanPull = weight * tx;
        maxTrainCarsTrainCanPull = trainCars - (10 * trainCars / 100);
    }

    @Override
    public String toString() {
        return "Train [ID = " + id + "]\n" + composition  + "\n\nThis train " +
                "can pull " + maxTrainCarsTrainCanPull + " train cars and " + maxWeightTrainCanPull + " tons.";
    }
}
