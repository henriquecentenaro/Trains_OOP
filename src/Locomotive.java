public class Locomotive extends Vehicle{
    // private int locomotiveId;
    private double maxWeight;
    private int maxQuantityTrainCar;
    
    /**
     * It constructs a new locomotive with a specified ID, max weight (tons), and how many train cars it supports.
     */
    public Locomotive(int id, double maxWeight, int maxQuantityTrainCar) {
        super(id);
        this.maxWeight = maxWeight;
        this.maxQuantityTrainCar = maxQuantityTrainCar;
    }

//    /**
//     * It gets the locomotive ID.
//     * @return the locomotive ID
//     */

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
        return "Locomotive [ID = " + getId() + ", max quantity train car = " + maxQuantityTrainCar +
                ", max weight = " + maxWeight + "]";
    }
}
