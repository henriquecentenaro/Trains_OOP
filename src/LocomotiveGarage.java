import java.util.ArrayList;

public class LocomotiveGarage {
    private ArrayList<Locomotive> locomotiveGarage;
    
    /**
     * It constructs a new locomotive garage.
     */
    public LocomotiveGarage() {
        locomotiveGarage = new ArrayList<>();
    }
    
    /**
     * Add a locomotive to the garage.
     * @param locomotive the locomotive to be added
     */
    public void addLocomotiveToGarage(Locomotive locomotive) {
        locomotiveGarage.add(locomotive);
    }

    /**
     * It checks if there's a specific locomotive in garage.
     * @param locomotiveId the locomotive ID
     * @return true if there's the specific locomotive; false if there isn't
     */
    public boolean isThereLocomotiveInGarage(int locomotiveId) {
        boolean flag = false;
        for (int i = 0; i < locomotiveGarage.size(); i++) {
            if (locomotiveId == locomotiveGarage.get(i).getLocomotiveId()) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * It gets a locomotive from a specified ID.
     * @param locomotiveId the locomotive ID whose locomotive instance it belongs
     * @return the locomotive instance
     */
    public Locomotive getLocomotiveFromId(int locomotiveId) {
        Locomotive locomotiveToBeReturned = null;
        for (int i = 0; i < locomotiveGarage.size(); i++) {
            if (locomotiveGarage.get(i).getLocomotiveId() == locomotiveId) {
                locomotiveToBeReturned = locomotiveGarage.get(i);
            }
        }
        return locomotiveToBeReturned;
    }
    
    /**
     * It selects a locomotive to be attached to train.
     * @param locomotiveId the locomotive to be moved
     */
    public void moveLocomotiveFromGarageToTrain(int locomotiveId) {
        for (int i = 0; i < locomotiveGarage.size(); i++) {
            if (locomotiveGarage.get(i).getLocomotiveId() == locomotiveId) {
                locomotiveGarage.remove(i);
            }
        }
    }

    @Override
    public String toString() {
        String aux = "Locomotives in garage:\n\n";
        for (Locomotive locomotives : locomotiveGarage) {
            aux += locomotives.toString() + "\n";
        }
        return aux;
    }
}