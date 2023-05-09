public class address {

    String governorate;
    String district;
    String street;
    String buildingNumber;
    String floor;
    String flat;
    String landMark;

    public address(String governorate, String district, String street, String buildingNumber, String floor, String flat, String landmark) {
        this.governorate = governorate;
        this.district = district;
        this.buildingNumber = buildingNumber;
        this.floor = floor;
        this.flat = flat;
        this.landMark = landmark;
    }


    public void setGovernorate(String governorate) {
        this.governorate = governorate;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }

    public String getGovernorate() {
        return governorate;
    }

    public String getDistrict() {
        return district;
    }

    public String getStreet() {
        return street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public String getFlat() {
        return flat;
    }

    public String getLandMark() {
        return landMark;
    }



}
