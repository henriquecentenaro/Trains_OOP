import java.util.List;
import java.util.ArrayList;

public class Train {
    private List<Vehicle> composition;
    private int id;
    private int maxTrainCarsTrainCanPull;
    private double maxWeightTrainCanPull;

    public Train(int id) {
        this.id = id;
        composition = new ArrayList<>();
        maxTrainCarsTrainCanPull = 0;
        maxWeightTrainCanPull = 0;
    }

    public int getId() {
        return id;
    }

    public boolean addLocomotive(Vehicle v) {
        for (Vehicle aux : composition) {
            if (aux instanceof TrainCar)
                return false;
        }

        if (getComposition() == 0 && v instanceof Locomotive l) {
            composition.add(l);
            maxWeightTrainCanPull = l.getMaxWeight();
            maxTrainCarsTrainCanPull = l.getMaxQuantityTrainCar();
            return true;
        } else if (v instanceof Locomotive l) {
            composition.add(l);
            setMaxWeightTrainCanPull();
            return true;
        }
        return false;
    }

    public boolean addTrainCar(Vehicle v) {
        if (isTrainOverloaded() && !(isTrainOverweigth(v))) {
            composition.add(v);
            return true;
        } else {
            return false;
        }
    }

    public boolean addPassagersTrain(Vehicle v) {
        if (isTrainOverloaded() && !(isTrainOverweigth(v))) {
            composition.add(v);
            return true;
        } else {
            return false;
        }
    }

    public int getComposition() {
        return composition.size();
    }

    public Vehicle getLastElement() {
        if (getComposition() == 0) {
            return null;
        }
        return composition.get(composition.size() - 1);
    }

    public void removeVehicle(Vehicle v) {
        composition.remove(v);
        setMaxWeightTrainCanPull();
    }

    /**
     * It sets the max weight and the max train cars a train can pull.
     */
    public void setMaxWeightTrainCanPull() {
        double weight = 0;
        int trainCars = 0;
        double tx = 0.9;
        for (Vehicle vehicle : composition) {
            if (vehicle instanceof Locomotive locomotive) {
                weight += locomotive.getMaxWeight();
                trainCars += locomotive.getMaxQuantityTrainCar();
            }
        }
        maxWeightTrainCanPull = weight * tx;
        maxTrainCarsTrainCanPull = trainCars - (10 * trainCars / 100);
    }

    private boolean isTrainOverweigth(Vehicle v) {
        double maxWeight = 0.0;
        for (Vehicle vehicle : composition) {
            if (vehicle instanceof WeightTrain weightTrain)
                maxWeight += weightTrain.getWeight();
        }

        return maxWeight > maxWeightTrainCanPull;
    }

    private boolean isTrainOverloaded() {
        int count = 0;

        for (Vehicle vehicle : composition) {
            if (vehicle instanceof WeightTrain)
                count++;
        }

        return count <= maxTrainCarsTrainCanPull;
    }

    @Override
    public String toString() {
        return "Train [ID = " + id + "]\n" + composition  + "\n\nThis train " +
                "can pull " + maxTrainCarsTrainCanPull + " train cars and " + maxWeightTrainCanPull + " tons.";
    }
}