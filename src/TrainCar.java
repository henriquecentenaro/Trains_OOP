public class TrainCar extends Vehicle{
    private double loadCapacity;
    private Train train;
    
    /**
     * It constructs a new train car with a specified ID and load capacity (in tons).
     */
    public TrainCar(int id, double loadCapacity) {
        super(id);
        this.loadCapacity = loadCapacity;
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
        return "Train car [ID = " + getId() + ", load capacity = " + loadCapacity + "]";
    }
}
