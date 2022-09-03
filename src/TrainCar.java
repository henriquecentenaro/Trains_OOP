public class TrainCar {
    private int trainCarId;
    private double loadCapacity;
    private Train train;
    
    /**
     * It constructs a new train car with a specified ID and load capacity (in tons).
     */
    public TrainCar(int trainCarId, double loadCapacity) {
        this.trainCarId = trainCarId;
        this.loadCapacity = loadCapacity;
    }

    /**
     * It gets the train car ID.
     * @return the train car ID
     */
    public int getTrainCarId() {
        return trainCarId;
    }

    /**
     * It gets the load capacity of a train car.
     * @return the load capacity
     */
    public double getLoadCapacity() {
        return loadCapacity;
    }

    @Override
    public String toString() {
        return "Train car [ID = " + trainCarId + ", load capacity = " + loadCapacity + "]";
    }
}
