public class Package {
    private Address fromAddress;
    private Address toAddress;

    private double weightLbs;
    private double lengthIn;
    private double widthIn;
    private double heightIn;

    public Package(Address fromAddress, Address toAddress, double weightLbs, double lengthIn, double heightIn, double widthIn) {
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.weightLbs = weightLbs;
        this.lengthIn = lengthIn;
        this.widthIn = widthIn;
        this.heightIn = heightIn;
    }

    public Address getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(Address fromAddress) {
        this.fromAddress = fromAddress;
    }

    public Address getToAddress() {
        return toAddress;
    }

    public void setToAddress(Address toAddress) {
        this.toAddress = toAddress;
    }

    public double getWeightLbs() {
        return weightLbs;
    }

    public void setWeightLbs(double weightLbs) {
        this.weightLbs = weightLbs;
    }

    public double getLengthIn() {
        return lengthIn;
    }

    public void setLengthIn(double lengthIn) {
        this.lengthIn = lengthIn;
    }

    public double getWidthIn() {
        return widthIn;
    }

    public void setWidthIn(double widthIn) {
        this.widthIn = widthIn;
    }

    public double getHeightIn() {
        return heightIn;
    }

    public void setHeightIn(double heightIn) {
        this.heightIn = heightIn;
    }
}
