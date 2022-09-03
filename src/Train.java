import java.util.ArrayList;

public class Train {
    private int trainId;
    private ArrayList<TrainCar> trainCarsInTrain;
    private ArrayList<Locomotive> locomotivesInTrain;
    private int maxTrainCarsTrainCanPull;
    private double maxWeightTrainCanPull;

    /**
     * It constructs a new train with a specified ID
     */
    public Train(int trainId) {
        this.trainId = trainId;
        trainCarsInTrain = new ArrayList<>(); // It stores train cars.
        locomotivesInTrain = new ArrayList<>(); // It stores locomotives.
        maxTrainCarsTrainCanPull = 0;
        maxWeightTrainCanPull = 0;
    }

    /**
     * It gets the train ID.
     * @return the train ID
     */
    public int getTrainId() {
        return trainId;
    }

    /**
     * It gets how many locomotives are attached to a train.
     * @return the quantity of locomotives
     */
    public int getLocomotiveQuantity() {
        int counter = 0;
        for (Locomotive locomotives : locomotivesInTrain) {
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
        for (TrainCar trainCar : trainCarsInTrain) {
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
        if (locomotivesInTrain.size() == 0) {
            locomotivesInTrain.add(locomotive);
            maxWeightTrainCanPull = locomotive.getMaxWeight();
            maxTrainCarsTrainCanPull = locomotive.getMaxQuantityTrainCar();
            return true;
        } else {
            locomotivesInTrain.add(locomotive);
            setMaxWeightTrainCanPull();
            return true;
        }
    }

    /**
     * It attaches a train car to a train.
     * @param trainCar the train car to be attached
     * @return true if you can attach the train car; false if you can't
     */
    public boolean attachTrainCar(TrainCar trainCar) {
        double maxWeight = 0.0;
        for (TrainCar trainCars : trainCarsInTrain) {
            maxWeight += trainCars.getLoadCapacity();
        }
        maxWeight += trainCar.getLoadCapacity();

        if (trainCarsInTrain.size() < maxTrainCarsTrainCanPull && !(maxWeight > maxWeightTrainCanPull)) {
            trainCarsInTrain.add(trainCar);
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
        if (locomotivesInTrain.size() == 0) {
            return false;
        } else {
            locomotivesInTrain.remove(locomotivesInTrain.size() - 1);
            return true;
        }
    }

    /**
     * It detaches a train car.
     * @return true if you can't detach; false if you can't
     */
    public boolean detachTrainCar() {
        if (trainCarsInTrain.size() == 0) {
            return false;
        } else {
            trainCarsInTrain.remove(trainCarsInTrain.size() - 1);
            return true;
        }
    }

    /**
     * It gets the last locomotive attached to a train.
     * @param train the train you want to get the locomotive from
     * @return the locomotive
     */
    public Locomotive getLastLocomotiveFromTrain(Train train) {
        Locomotive locomotive = locomotivesInTrain.get(locomotivesInTrain.size() - 1);
        return locomotive;
    }

    /** It gets the last train car attached to a train.
     * @param train the train you want to get the train car from
     * @return the train car
     */
    public TrainCar getLastTrainCarFromTrain(Train train) {
        TrainCar trainCar = trainCarsInTrain.get(trainCarsInTrain.size() - 1);
        return trainCar;
    }

    /**
     * It sets the max weight and the max train cars a train can pull.
     */
    public void setMaxWeightTrainCanPull() {
        double weight = 0;
        int trainCars = 0;
        double tx = 0.9;
        for (Locomotive locomotives : locomotivesInTrain) {
            weight += locomotives.getMaxWeight();
            trainCars += locomotives.getMaxQuantityTrainCar();
        }
        maxWeightTrainCanPull = weight * tx;
        maxTrainCarsTrainCanPull = trainCars - (10 * trainCars / 100);
    }

    @Override
    public String toString() {
        return "Train [ID = " + trainId + "]\n" + locomotivesInTrain + "\n" + trainCarsInTrain + "\n\nThis train " +
                "can pull " + maxTrainCarsTrainCanPull + " train cars and " + maxWeightTrainCanPull + " tons.";
    }
}