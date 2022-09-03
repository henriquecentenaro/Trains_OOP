import java.util.ArrayList;

public class TrainYard {
    private ArrayList<Train> trainYard;

    /**
     * It constructs a new train yard.
     */
    public TrainYard() {
        trainYard = new ArrayList<>();
    }

    /**
     * It adds a train to the train yard.
     * @param train the train to be added
     */
    public void addTrainToTrainYard(Train train) {
        trainYard.add(train);
    }

    /**
     * It deletes a train from the train yard.
     * @param train the train to be deleted
     */
    public void deleteTrain(Train train) {
        trainYard.remove(train);
    }

    /**
     * It checks if there's a specif train in the train yard.
     * @param trainId the train ID to be checked
     * @return true if there's the train; false if there isn't
     */
    public boolean isThereTrainInTrainYard(int trainId) {
        boolean flag = false;
        for (int i = 0; i < trainYard.size(); i++) {
            if (trainYard.get(i).getTrainId() == trainId) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * It gets a train instance by its ID.
     * @param trainId the train ID
     * @return the train instance
     */
    public Train getTrainFromId(int trainId) {
        Train trainToBeReturned = null;
        for (int i = 0; i < trainYard.size(); i++) {
            if (trainYard.get(i).getTrainId() == trainId) {
                trainToBeReturned = trainYard.get(i);
            }
        }
        return trainToBeReturned;
    }

    @Override
    public String toString() {
        String aux = "Trains in yard:\n\n";
        for (Train trains : trainYard) {
            aux += trains.toString() + "\n";
        }
        return aux;
    }
}