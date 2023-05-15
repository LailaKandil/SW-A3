public class Address {
    private String governorate;
    private String district;
    private String street;
    private String buildingNumber;
    private String floor;
    private String flat;
    private String landMark;
    // private String

    public Address() {
    }

    public Address(String governorate, String district, String street, String buildingNumber, String floor, String flat,
                   String landmark) {
        this.governorate = governorate;
        this.district = district;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.floor = floor;
        this.flat = flat;
        this.landMark = landmark;
    }

    public String getGovernorate() {
        return governorate;
    }

    public void setGovernorate(String governorate) {
        this.governorate = governorate;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getLandMark() {
        return landMark;
    }

    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }

}
