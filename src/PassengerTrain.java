public class PassengerTrain extends Vehicle implements WeightTrain{

    private final int numberMaxPassengers;

    public PassengerTrain(int id, int numberMaxPassengers) {
        super(id);
        this.numberMaxPassengers = numberMaxPassengers;
    }

    public int getNumberMaxPassengers() {
        return numberMaxPassengers;
    }

    @Override
    public double getWeight() {
        return 3 + 0.075 * getNumberMaxPassengers();
    }

    @Override
    public String toString() {
        return "Passenger Train [ID = " + getId() + ", numberMaxPassengers = " + numberMaxPassengers + "]";
    }
}
