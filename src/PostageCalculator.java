public class PostageCalculator {

    private static double roundToPlace(double num, int postDec) {
        double shiftNum = Math.pow(10, postDec);
        return Math.round(shiftNum*num)/shiftNum;
    }

    public static double calculatePostage(String zip1, String zip2, double weight, double width, double height, double length) {
        double cost = 3.75;

        int fromZip = Integer.parseInt(zip1.substring(0, 2));
        int toZip = Integer.parseInt(zip2.substring(0, 2));

        double weightCost = 0.05 * (int)(weight*10);
        if (weight > 40) {
            weightCost += 0.05 * (int)((weight-40)*10);
        }

        double distCost = (double)(Math.abs(fromZip-toZip)/100);
        double sizeCost = 0;

        double totalSize = width + height + length;
        if (totalSize > 36) {
            sizeCost = totalSize * .1;
        }

        cost += weightCost;
        cost += distCost;
        cost += sizeCost;

        return roundToPlace(cost, 2);
    }

    public static double calculatePostage(Address add1, Address add2, double weight, double width, double height, double length) {
        double cost = 3.75;

        int fromZip = Integer.parseInt(add1.getZipCode().substring(0, 2));
        int toZip = Integer.parseInt(add2.getZipCode().substring(0, 2));

        double weightCost = 0.05 * (int)(weight*10);
        if (weight > 40) {
            weightCost += 0.05 * (int)((weight-40)*10);
        }

        double distCost = (double)(Math.abs(fromZip-toZip)/100);
        double sizeCost = 0;

        double totalSize = width + height + length;
        if (totalSize > 36) {
            sizeCost = totalSize * .1;
        }

        cost += weightCost;
        cost += distCost;
        cost += sizeCost;

        return roundToPlace(cost, 2);
    }

    public static double calculatePostage(Package pack) {
        double cost = 3.75;

        int fromZip = Integer.parseInt(pack.getFromAddress().getZipCode().substring(0, 3));
        int toZip = Integer.parseInt(pack.getToAddress().getZipCode().substring(0, 3));

        double weightCost = 0.05 * (int)(pack.getWeightLbs()*10);
        if (pack.getWeightLbs() > 40) {
            weightCost += 0.10 * (int)((pack.getWeightLbs()-40)*10);
        }

        double distCost = (double)(Math.abs(fromZip-toZip)/(double)100);
        double sizeCost = 0;

        double totalSize = pack.getWidthIn() + pack.getHeightIn() + pack.getLengthIn();
        if (totalSize > 36) {
            sizeCost = totalSize * .1;
        }

        cost += weightCost;
        cost += distCost;
        cost += sizeCost;

        return roundToPlace(cost, 2);
    }
}
