import java.util.ArrayList;

public class TrainCarGarage {
    private ArrayList<TrainCar> trainCarGarage;

    /**
     * It constructs a new train car garage.
     */
    public TrainCarGarage() {
        trainCarGarage = new ArrayList<>();
    }

    /**
     * It adds a train car to the garage.
     * @param trainCar the train car to be added
     */
    public void addTrainCarToGarage(TrainCar trainCar) {
        trainCarGarage.add(trainCar);
    }

    /**
     * It checks if there's a specific train car in the garage.
     * @param trainCarId the train car ID to be checked
     * @return true if there's the train car; false if there isn't
     */
    public boolean isThereTrainCarInGarage(int trainCarId) {
        boolean flag = false;
        for (int i = 0; i < trainCarGarage.size(); i++) {
            if (trainCarId == trainCarGarage.get(i).getTrainCarId()) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * It moves the train car to the garage.
     * @param trainCarId the train car ID to be moved
     */
    public void moveTrainCarFromGarageToTrain(int trainCarId) {
        for (int i = 0; i < trainCarGarage.size(); i++) {
            if (trainCarGarage.get(i).getTrainCarId() == trainCarId) {
                trainCarGarage.remove(i);
            }
        }
    }

    /**
     * It gets a train car instance by its ID.
     * @param trainCarId the train car ID
     * @return the train car instance
     */
    public TrainCar getTrainCarFromId(int trainCarId) {
        TrainCar trainCarToBeReturned = null;
        for (int i = 0; i < trainCarGarage.size(); i++) {
            if (trainCarGarage.get(i).getTrainCarId() == trainCarId) {
                trainCarToBeReturned = trainCarGarage.get(i);
            }
        }
        return trainCarToBeReturned;
    }

    @Override
    public String toString() {
        String aux = "Train cars in garage:\n\n";
        for (TrainCar trainCars : trainCarGarage) {
            aux += trainCars.toString() + "\n";
        }
        return aux;
    }
}