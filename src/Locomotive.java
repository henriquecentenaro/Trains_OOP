public class Locomotive {
    private int locomotiveId;
    private double maxWeight;
    private int maxQuantityTrainCar;
    
    /**
     * It constructs a new locomotive with a specified ID, max weight (tons), and how many train cars it supports.
     */
    public Locomotive(int locomotiveId, double maxWeight, int maxQuantityTrainCar) {
        this.locomotiveId = locomotiveId;
        this.maxWeight = maxWeight;
        this.maxQuantityTrainCar = maxQuantityTrainCar;
    }

    /**
     * It gets the locomotive ID.
     * @return the locomotive ID
     */
    public int getLocomotiveId() {
        return locomotiveId;
    }

    /**
     * It gets the max weight a locomotive can pull.
     * @return the max weight
     */

    public double getMaxWeight() {
        return maxWeight;
    }

    /**
     * It gets the max quantity train cars a train can pull.
     * @return the max quantity
     */
    public int getMaxQuantityTrainCar() {
        return maxQuantityTrainCar;
    }

    @Override
    public String toString() {
        return "Locomotive [ID = " + locomotiveId + ", max quantity train car = " + maxQuantityTrainCar +
                ", max weight = " + maxWeight + "]";
    }
}
