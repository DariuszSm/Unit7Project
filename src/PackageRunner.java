import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class PackageRunner {

    public static void printChoices() {
        System.out.println("What would you like to do?");
        System.out.println("1. Calculate cost of one package");
        System.out.println("2. Simulate packages");
        System.out.println("3. How package costs are calculated");
        System.out.println("4. Exit");
    }

    public static void singlePackCost() {
        Scanner s = new Scanner(System.in);
        String origZip;
        String destZip;
        double weight;
        double width;
        double height;
        double length;

        System.out.print("Enter origin zip code: ");
        origZip = s.nextLine();
        System.out.print("Enter destination zip code: ");
        destZip = s.nextLine();
        System.out.print("Enter package weight: ");
        weight = Double.parseDouble(s.nextLine());
        System.out.print("Enter package width: ");
        width = Double.parseDouble(s.nextLine());
        System.out.print("Enter package height: ");
        height = Double.parseDouble(s.nextLine());
        System.out.print("Enter package length: ");
        length = Double.parseDouble(s.nextLine());

        double cost = PostageCalculator.calculatePostage(origZip, destZip, weight,width, height, length);

        System.out.println("Cost: " + cost + "\n");
    }

    public static void main(String[] args) throws FileNotFoundException {
        ZipCodes.initZipCodes();
        PackageSimulator packSim = new PackageSimulator();
        Scanner s = new Scanner(System.in);

        String input = "";

        do {
            printChoices();
            System.out.print("Input: ");
            input = s.nextLine();

            if (input.equals("1")) {
                singlePackCost();
            } else if (input.equals("2")) {
                System.out.print("How many packages would you like to simulate? ");
                int packInput = Integer.parseInt(s.nextLine());
                packSim.generatePackages(packInput);
                System.out.println(packSim.getSimulationInfo());
                packSim.resetSimulation();
            } else if (input.equals("3")) {

            }

        } while (!input.equals("4"));


    }
}
