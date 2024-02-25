public class Address {
    private String houseNumber;
    private String streetName;
    private String apartmentNumber;
    private String city;
    private String state;
    private String zipCode;

    public Address(String houseNumber, String streetName, String apartmentNumber, String city, String state, String zipCode) {
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.apartmentNumber = apartmentNumber;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Address(Address copyAddress) {
        this.houseNumber = copyAddress.houseNumber;
        this.streetName = copyAddress.streetName;
        this.apartmentNumber = copyAddress.apartmentNumber;
        this.city = copyAddress.city;
        this.state = copyAddress.state;
        this.zipCode = copyAddress.zipCode;
    }

    public Address(String infoString) {
        this.houseNumber = infoString.substring(0, infoString.indexOf(" "));
        infoString = infoString.substring(infoString.indexOf(" ")+1);
        int aptInd = infoString.indexOf("Apt");
        if (aptInd != -1) {
            this.streetName = infoString.substring(0, aptInd-1);
            this.apartmentNumber = infoString.substring(aptInd+4, infoString.indexOf(","));
        } else {
            this.streetName = infoString.substring(0, infoString.indexOf(","));
            this.apartmentNumber = null;
        }
        infoString = infoString.substring(infoString.indexOf(", ")+1);
        this.city = infoString.substring(0, infoString.indexOf(", "));
        infoString = infoString.substring(infoString.indexOf(", ")+1);
        this.state = infoString.substring(0, infoString.indexOf(" "));
        infoString = infoString.substring(infoString.indexOf(" ")+1);
        this.zipCode = infoString;
//        String[] parsed = infoString.split("/%*%/");
//        if (parsed.length == 6) {
//            this.houseNumber = parsed[0];
//            this.streetName = parsed[1];
//            this.apartmentNumber = parsed[2];
//            this.city = parsed[3];
//            this.state = parsed[4];
//            this.zipCode = parsed[5];
//        } else if (parsed.length == 5) {
//            this.houseNumber = parsed[0];
//            this.streetName = parsed[1];
//            this.city = parsed[2];
//            this.state = parsed[3];
//            this.zipCode = parsed[4];
//        }
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String toString() {
        String assemble = "";
        assemble += houseNumber + " ";
        assemble += streetName + " ";
        if (apartmentNumber != null) {
            assemble += "Apt " + apartmentNumber + ", ";
        }
        assemble += city + ", ";
        assemble += state + ", ";
        assemble += zipCode;
        return assemble;
    }
}
