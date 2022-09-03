import java.util.Scanner;

public class TrainMain {
    public static void main(String[] args) {
        LocomotiveGarage locomotiveGarage = new LocomotiveGarage();
        TrainCarGarage trainCarGarage = new TrainCarGarage();
        TrainYard trainYard = new TrainYard();

        for (int i = 1; i <= 50; i++) {
            locomotiveGarage.addLocomotiveToGarage(new Locomotive(i, 500, 10));
            trainCarGarage.addTrainCarToGarage(new TrainCar(i, 250));
        }

        Scanner sc = new Scanner(System.in);
        int input;

        // Main menu.
        do {
            System.out.print("(1) create a train, (2) edit a train, (3) list all trains in yard, " +
                    "(4) delete a train, and (5) exit app. Choose one: ");
            input = sc.nextInt();

            switch (input) {
                case 1:
                    System.out.print("Enter the train ID to be created: ");
                    input = sc.nextInt();

                    // Auxiliary variable for a new instance of a train. It'll have the ID entered by the user.
                    Train auxTrain = new Train(input);

                    // The user have to choose a first locomotive to be attached to the new train.
                    System.out.print("Enter the locomotive ID to be attached to the new train: ");
                    input = sc.nextInt();

                    if (locomotiveGarage.isThereLocomotiveInGarage(input)) {
                        Locomotive locomotiveFromId = locomotiveGarage.getLocomotiveFromId(input);
                        auxTrain.attachLocomotive(locomotiveFromId);
                        trainYard.addTrainToTrainYard(auxTrain);
                        locomotiveGarage.moveLocomotiveFromGarageToTrain(input);
                        System.out.println("Train created.");
                    } else {
                        System.out.println("Invalid locomotive ID or there's no such locomotive garage.");
                    }
                    break;

                case 2:
                    System.out.print("Enter the train ID to be edited: ");
                    input = sc.nextInt();
                    auxTrain = trainYard.getTrainFromId(input);

                    if (trainYard.isThereTrainInTrainYard(input)) {
                        System.out.println("OK.");
                    } else {
                        System.out.println("Invalid train ID or there's no such train in train yard.");
                        break;
                    }

                    do {
                        System.out.print("(1) attach a locomotive, (2) attach a train car, " +
                                "(3) remove the last train element, (4) list all free locomotives, " +
                                "(5) list all free train cars, and (6) go back to main menu. " +
                                "Choose one: ");
                        input = sc.nextInt();

                        switch (input) {
                            case 1:
                                System.out.print("Enter the locomotive ID to be attached to the selected train: ");
                                input = sc.nextInt();

                                if (locomotiveGarage.isThereLocomotiveInGarage(input)) {
                                    if (auxTrain.getTrainCarQuantity() == 0) {
                                        Locomotive locomotiveFromId = locomotiveGarage.getLocomotiveFromId(input);
                                        auxTrain.attachLocomotive(locomotiveFromId);
                                        locomotiveGarage.moveLocomotiveFromGarageToTrain(input);
                                        System.out.println("Locomotive attached.");

                                    } else {
                                        System.out.println("You can't attach a locomotive to a train car. " +
                                                "Please remove all train cars first.");
                                    }
                                } else {
                                    System.out.println("Invalid locomotive ID or there's no such locomotive in garage.");
                                }
                                break;

                            case 2:
                                System.out.print("Enter the train car ID to be attached to the selected train: ");
                                input = sc.nextInt();

                                if (trainCarGarage.isThereTrainCarInGarage(input)) {
                                    TrainCar trainCarFromId = trainCarGarage.getTrainCarFromId(input);
                                    if (auxTrain.attachTrainCar(trainCarFromId)) {
                                        trainCarGarage.moveTrainCarFromGarageToTrain(input);
                                        System.out.println("Train car attached.");
                                    } else {
                                        System.out.println("Oh no!");
                                    }
                                } else {
                                    System.out.println("Invalid train car ID or there's no such train car in garage.");
                                }
                                break;

                            case 3:
                                // If we have only one element (a simple locomotive), then we can't detach it.
                                if (auxTrain.getTrainCarQuantity() == 0
                                    && auxTrain.getLocomotiveQuantity() == 1) {
                                System.out.println("You can't remove the only element remaining in the train.");

                                // The logic is quite straightforward:
                                    // If train cars == 0, then the last element will be a locomotive.
                                    // Recall that we can't attach a locomotive to a train car.
                                    // So whenever train cars == 0, the last element will be a locomotive.
                                } else if (auxTrain.getTrainCarQuantity() == 0) {
                                    Locomotive lastLocomotive = auxTrain.getLastLocomotiveFromTrain(auxTrain);
                                    locomotiveGarage.addLocomotiveToGarage(lastLocomotive);
                                    auxTrain.detachLocomotive();
                                    System.out.println("The last element (a locomotive) was removed and moved back" +
                                            " to garage.");

                                } else {
                                    TrainCar lastTrainCar = auxTrain.getLastTrainCarFromTrain(auxTrain);
                                    trainCarGarage.addTrainCarToGarage(lastTrainCar);
                                    auxTrain.detachTrainCar();
                                    System.out.println("The last element (a train car) was removed and moved back" +
                                            " to garage.");
                                }
                                break;

                            case 4:
                                System.out.println(locomotiveGarage);
                                break;

                            case 5:
                                System.out.println(trainCarGarage);
                                break;

                            case 6:
                                System.out.println("Going back to main menu...");
                                break;
                        }
                    } while (input != 6);
                    break;

                case 3:
                    System.out.println(trainYard);
                    break;

                case 4:
                    System.out.print("Enter the train ID to be deleted: ");
                    input = sc.nextInt();

                    auxTrain = trainYard.getTrainFromId(input);

                    if (trainYard.isThereTrainInTrainYard(input)) {
                        System.out.println("OK.");
                    } else {
                        System.out.println("Invalid train ID or there's no such train in train yard.");
                        break;
                    }

                    for (int i = auxTrain.getTrainCarQuantity(); i > 0; i--) {
                        TrainCar lastTrainCar = auxTrain.getLastTrainCarFromTrain(auxTrain);
                        trainCarGarage.addTrainCarToGarage(lastTrainCar);
                        auxTrain.detachTrainCar();
                    }

                    for (int i = auxTrain.getLocomotiveQuantity(); i > 0; i--) {
                        Locomotive lastLocomotive = auxTrain.getLastLocomotiveFromTrain(auxTrain);
                        locomotiveGarage.addLocomotiveToGarage(lastLocomotive);
                        auxTrain.detachLocomotive();
                    }

                    trainYard.deleteTrain(auxTrain);
                    break;

                case 5:
                    System.out.println("Bye.");
                    System.exit(0);
            }
        } while (input != 5);
    }
}