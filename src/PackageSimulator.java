import java.util.ArrayList;
import java.util.HashMap;

public class PackageSimulator {
    private ArrayList<Package> packages;

    public PackageSimulator() {
        packages = new ArrayList<Package>();
    }

    public void generatePackages(int packsToGenerate) {
        String[] validZipCodes = ZipCodes.getZipCodes().keySet().toArray(new String[0]);

        for (int i = 0; i < packsToGenerate; i++) {
            String randomFromZip = validZipCodes[(int)(Math.random()*validZipCodes.length)];
            String randomToZip = validZipCodes[(int)(Math.random()*validZipCodes.length)];
            Address randomFrom = new Address("123", "Garbage Street", "3", "136 twenty vargo pilago chen swing", "Economic State", randomFromZip);
            Address randomTo = new Address("123", "Garbage Street", "3", "136 twenty vargo pilago chen swing", "Economic State", randomToZip);

            double randomWeight = (Math.random()*200) + 0.1;
            double randomWidth = (Math.random()*100) + 2;
            double randomHeight = (Math.random()*100) + 2;
            double randomLength = (Math.random()*100) + 2;

            Package genPack = new Package(randomFrom, randomTo, randomWeight, randomWidth, randomHeight, randomLength);

            packages.add(genPack);
        }
    }

    public double generateTotalCost() {
        double total = 0;
        for (Package pack : packages) {
            total += PostageCalculator.calculatePostage(pack);
        }

        return total;
    }

    public String getSimulationInfo() {
        String assemble = "";
        assemble += "Randomly generated packages info:\n";
        int packsProcessed = 0;
        for (Package pack : packages) {
            assemble += "Package " + (packsProcessed+1) + ":\n";
            assemble += "Origin address: " + pack.getFromAddress() + "\n";
            assemble += "Destination address: " + pack.getToAddress() + "\n";
            assemble += "Weight: " + pack.getWeightLbs() + "\n";
            assemble += "Width: " + pack.getWidthIn() + "\n";
            assemble += "Height: " + pack.getHeightIn() + "\n";
            assemble += "Length: " + pack.getLengthIn() + "\n";
            assemble += "Cost: " + PostageCalculator.calculatePostage(pack) + "\n\n";
            packsProcessed++;
        }
        assemble += "Total Cost of all packages: " + generateTotalCost() + "\n";
        return assemble;
    }

    public void resetSimulation() {
        packages.clear();
    }

}
