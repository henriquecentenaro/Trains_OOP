import java.util.Scanner;
public class TrainMain {
    public static void main(String[] args) {
        Garage g = new Garage();

        for (int i = 1; i <= 10; i++) {
            g.addVehicle(new Locomotive(200 + i, 500, 2));
            g.addVehicle(new TrainCar(300 + i, 250));
        }

        Scanner sc = new Scanner(System.in);
        int input;

        do {
            System.out.print("(1) create a train, (2) edit a train, (3) list all trains in yard, " +
                    "(4) delete a train, and (5) exit app. Choose one: ");
            input = sc.nextInt();

            switch (input) {
                case 1:
                    System.out.print("Enter the train ID to be created: ");
                    input = sc.nextInt();

                    Train t = new Train(input);

                    if (g.hasTrain(input)) {
                        System.out.println("Duplicate train.");
                        break;
                    }

                    System.out.print("Enter the locomotive ID to be attached to the new train: ");
                    input = sc.nextInt();

                    if (g.hasVehicleInGarage(input)) { // (1) It checks if there's the locomotive in garage.
                        Vehicle v = g.getById(input); // (2) It gets the locomotive by its ID.
                        t.addLocomotive(v); // (3) It adds the locomotive to the train.
                        g.addTrain(t); // (4) It adds the train to train yard.
                        g.removeFromGarage(input); // (5) It removes locomotive from garage. Now it isn't available anymore.
                        System.out.println("Train created.");
                    } else {
                        System.out.println("Invalid locomotive ID or there's no such locomotive in garage.");
                    }
                    break;

                case 2:
                    System.out.print("Enter the train ID to be edited: ");
                    input = sc.nextInt();

                    if (g.hasTrain(input)) {
                        t = g.getTrainById(input);
                    } else {
                        System.out.println("Invalid train ID or there's no such train in train yard.");
                        break;
                    }

                    do {
                        System.out.print("(1) add a locomotive, (2) add a train car, " +
                                "(3) remove the last train element, (4) list all free locomotives, " +
                                "(5) list all free train cars, and (6) go back to main menu. " +
                                "Choose one: ");
                        input = sc.nextInt();

                        switch (input) {
                            case 1:
                                if (t.getLastElement() instanceof TrainCar) {
                                    System.out.println("You can't add a locomotive to a train car.");
                                    break;
                                }

                                System.out.print("Enter the locomotive ID to be attached to the selected train: ");
                                input = sc.nextInt();

                                if (g.hasVehicleInGarage(input)) {
                                    Vehicle v = g.getById(input);
                                    t.addLocomotive(v);
                                    g.removeFromGarage(input);
                                    System.out.println("Locomotive added.");
                                } else {
                                    System.out.println("Invalid locomotive ID or there's no such locomotive in garage.");
                                }
                                break;

                            case 2:
                                System.out.print("Enter the train car ID to be attached to the selected train: ");
                                input = sc.nextInt();

                                if (g.hasVehicleInGarage(input)) {
                                    Vehicle v = g.getById(input);
                                    if (t.addTrainCar(v)) {
                                        g.removeFromGarage(input);
                                        System.out.println("Train car added.");
                                    } else {
                                        System.out.println("Oh no!");
                                    }
                                } else {
                                    System.out.println("Invalid train car ID or there's no such train car in garage.");
                                }
                                break;

                            case 3:
                                if (t.getComposition() == 1) {
                                    System.out.println("You can't remove the only element remaining in the train.");
                                    break;
                                } else {
                                    Vehicle v = t.getLastElement();
                                    g.addVehicle(v);
                                    t.removeVehicle(v);
                                    System.out.println("The last element was removed and moved back to garage.");
                                }
                                break;

                            case 4:
                                System.out.println(g.listLocomotives());
                                break;

                            case 5:
                                System.out.println(g.listTrainCars());
                                break;

                            case 6:
                                break;
                        }
                    } while (input != 6);
                    break;

                case 3:
                    System.out.println(g.listTrains());
                    break;

                case 4:
                    System.out.print("Enter the train ID to be deleted: ");
                    input = sc.nextInt();

                    if (g.hasTrain(input)) {
                        t = g.getTrainById(input);
                        while (t.getComposition() != 0) {
                            Vehicle v = t.getLastElement();
                            g.addVehicle(v);
                            t.removeVehicle(v);
                        }
                        g.removeTrain(input);
                    } else {
                        System.out.println("Invalid train ID or there's no such train in train yard.");
                    }
                    break;

                case 5:
                    System.exit(0);
            }
        } while (input != 5);
    }
}